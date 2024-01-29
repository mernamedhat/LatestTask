package com.merna.mylatesttask.ui.posts

import android.annotation.SuppressLint
import android.os.Build
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView
import com.merna.mylatesttask.databinding.PostsItemBinding
import com.merna.mylatesttask.model.PostsResponse

class PostsAdapter(
    var AlbumsList: List<PostsResponse>,
    ItemClickListener: OnItemClickListener?,
) : RecyclerView.Adapter<PostsAdapter.ViewHolder>() {

    private lateinit var binding: PostsItemBinding
    private var listener: OnItemClickListener


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        binding = PostsItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder()
    }

    init {
        this.listener = ItemClickListener!!
    }

    interface OnItemClickListener {
        fun onItemClick(position: Int, item: PostsResponse)


    }

    override fun getItemCount() = AlbumsList.size

    @RequiresApi(Build.VERSION_CODES.Q)
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.setData(AlbumsList[position], position)
        holder.setIsRecyclable(false)
    }

    inner class ViewHolder : RecyclerView.ViewHolder(binding.root) {
        @SuppressLint("QueryPermissionsNeeded")
        @RequiresApi(Build.VERSION_CODES.Q)
        fun setData(item: PostsResponse, position: Int) {
            binding.apply {
                root.setOnClickListener {

                    listener.onItemClick(position, item)
                }

                name.text = item.title


            }
        }
    }


}
