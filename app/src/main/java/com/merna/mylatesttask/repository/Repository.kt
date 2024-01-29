package com.merna.mylatesttask.repository


import com.merna.mylatesttask.api.ServiceBuilder
import com.merna.mylatesttask.api.TaskBostaService
import com.merna.mylatesttask.model.PostsResponse
import javax.inject.Inject


//@Inject

class Repository @Inject constructor(private val api: TaskBostaService) {
    suspend fun getPosts(): List<PostsResponse> {
        return api.getPosts()
    }

    suspend fun getPostById(postId: Int): PostsResponse {
        return api.getPostById(postId)
    }

}