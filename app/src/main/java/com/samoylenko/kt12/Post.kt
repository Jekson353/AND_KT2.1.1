package com.samoylenko.kt12

data class Post (
    val id:Long,
    val author: String,
    val content: String,
    val published: String,
    var sharing: Int,
    var like: Int,
    var countVisability: Int,
    var likedByMe: Boolean = false
)