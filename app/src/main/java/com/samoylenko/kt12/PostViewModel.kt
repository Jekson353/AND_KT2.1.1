package com.samoylenko.kt12

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel

class PostViewModel : ViewModel() {
    private val repository: PostRepository = PostRepositoryInMemoryImpl()
    val data: LiveData<Post> = repository.get()
    fun like() = repository.like()
    fun sharing() = repository.sharing()
}