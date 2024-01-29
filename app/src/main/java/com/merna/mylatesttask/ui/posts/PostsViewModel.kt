package com.merna.mylatesttask.ui.posts

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.merna.mylatesttask.model.PostsResponse
import com.merna.mylatesttask.use_case.GetPostsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PostsViewModel @Inject constructor(private val getPostsUseCase: GetPostsUseCase) :
    ViewModel() {

    private val _posts = MutableLiveData<List<PostsResponse>?>()
    val posts: LiveData<List<PostsResponse>?> get() = _posts

    fun getPosts() {
        viewModelScope.launch {
            _posts.value = getPostsUseCase.getPosts()
        }
    }

}