package com.merna.mylatesttask.api

import com.merna.mylatesttask.model.PostsResponse
import retrofit2.Response

import retrofit2.http.GET
import retrofit2.http.Path


interface TaskBostaService {



    @GET("posts")
    suspend fun getPosts(): List<PostsResponse>


    @GET("posts/{id}")
    suspend fun getPostById(@Path("id") postId: Int): PostsResponse




}
