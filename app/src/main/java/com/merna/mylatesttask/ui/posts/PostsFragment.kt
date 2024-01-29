package com.merna.mylatesttask.ui.posts

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.merna.mylatesttask.api.InternetConnection
import com.merna.mylatesttask.databinding.FragmentPostsBinding
import com.merna.mylatesttask.model.PostsResponse

import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PostsFragment : Fragment(), PostsAdapter.OnItemClickListener {
    private lateinit var binding: FragmentPostsBinding
  
    private lateinit var postsList: ArrayList<PostsResponse>
    private lateinit var postsAdapter: PostsAdapter
    private val viewModel: PostsViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPostsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    
        postsList = ArrayList()
        postsAdapter = PostsAdapter(postsList, this@PostsFragment)
      
        fetchRec()
        binding.postsRec.layoutManager = LinearLayoutManager(requireContext())
        binding.postsRec.setHasFixedSize(true)

        binding.postsRec.adapter = postsAdapter




    }



    private fun fetchRec() {
        Log.d("hhhh","hhhh")
        if (InternetConnection.isInternetConnected(requireContext())) {

            viewModel.posts.observe(requireActivity()) {
                postsList.clear()
                binding.progressBar.visibility=View.GONE
                postsList.addAll(it!!)
                postsAdapter.notifyDataSetChanged()
            }
            viewModel.getPosts()
        } else {

            Toast.makeText(
                requireContext(), " Check Internet Connection",
                Toast.LENGTH_SHORT
            ).show()
        }

    }

    override fun onItemClick(position: Int, item: PostsResponse) {

        val action = PostsFragmentDirections.fragmentProfileToAlbumsDetails(item.id)
        findNavController().navigate(action)
    }


}