package com.merna.mylatesttask.use_case

import com.merna.mylatesttask.model.PostsResponse
import com.merna.mylatesttask.repository.Repository
import javax.inject.Inject

class GetPostsUseCase @Inject constructor(private val repository: Repository) {

    suspend  fun getPosts(): List<PostsResponse> {
        return repository.getPosts()
    }
    suspend  fun getPostById(id:Int):PostsResponse {
        return repository.getPostById(id)
    }
}