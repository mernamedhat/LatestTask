package com.merna.mylatesttask.ui.posts_details

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.merna.mylatesttask.api.InternetConnection
import com.merna.mylatesttask.databinding.FragmentPostsDetailsBinding

import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PostsDetailsFragment : Fragment() {
    private lateinit var binding: FragmentPostsDetailsBinding

    private val postDetailsViewModel: PostsDetailsViewModel by viewModels()

    val args: PostsDetailsFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPostsDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        fetchPostDetails()


    }

    private fun fetchPostDetails() {
        Log.d("hhhh", "hhhhpostDetailsViewModel")
        if (InternetConnection.isInternetConnected(requireContext())) {

            postDetailsViewModel.posts.observe(requireActivity()) {
                binding.titleDetails.text = it.title
                binding.bodyDetails.text = it.body

            }
            postDetailsViewModel.getPostById(args.albumid)
        } else {

            Toast.makeText(
                requireContext(), " Check Internet Connection",
                Toast.LENGTH_SHORT
            ).show()
        }

    }


}


