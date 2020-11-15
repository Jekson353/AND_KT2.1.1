package com.samoylenko.kt12

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class PostRepositoryInMemoryImpl : PostRepository {
    private var post = Post(
        id = 1,
        author = "Пушкин А.С.",
        content = "У Лукоморья дуб зеленый, Златая цепь на дубе том...",
        published = "01 апреля 1985 года",
        sharing = 0,
        like = 995,
        countVisability = 10,
        likedByMe = false
    )
    private val data = MutableLiveData(post)
    override fun get(): LiveData<Post> = data

    override fun like() {
        if (post.likedByMe) {
            post = post.copy(likedByMe = !post.likedByMe, like = post.like - 1)
        } else {
            post = post.copy(likedByMe = !post.likedByMe, like = post.like + 1)
        }
        //post = post.copy(likedByMe = !post.likedByMe, like = post.like - 1)
        data.value = post
    }

    override fun sharing() {
        post = post.copy(sharing = post.sharing + 1)
        data.value = post
    }
}