package com.merna.mylatesttask.ui.posts_details

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
class PostsDetailsViewModel @Inject constructor(private val getPostsUseCase: GetPostsUseCase) :
    ViewModel() {

    private val _posts = MutableLiveData<PostsResponse>()
    val posts: LiveData<PostsResponse> get() = _posts


    fun getPostById(id:Int) {
        viewModelScope.launch {
            _posts.value = getPostsUseCase.getPostById(id)
        }
    }
}