package com.samoylenko.kt12

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.samoylenko.kt12.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val post = Post(
            id = 1,
            author = "Пушкин А.С.",
            content = "У Лукоморья дуб зеленый, Златая цепь на дубе том...",
            published = "01 апреля 1985 года",
            sharing = 0,
            like = 999,
            countVisability = 10,
            likedByMe = false
        )

        with(binding){
            countView.text = post.countVisability.toString()

            author.text = post.author
            txtDate.text = post.published
            textData.text = post.content
            countLike.text = Calc.intToText(post.like)
            countShare.text = post.sharing.toString()
            if (post.likedByMe){
                like.setImageResource(R.drawable.ic_liked_24)
            }

            like.setOnClickListener {
                post.likedByMe = !post.likedByMe
                like.setImageResource(
                    if (post.likedByMe) {
                        post.like++
                        R.drawable.ic_liked_24
                    } else {
                        post.like--
                        R.drawable.ic_baseline_favorite_border_24
                    }
                )
                countLike.text = Calc.intToText(post.like)
            }

            share.setOnClickListener {
                post.sharing ++
                countShare.text = post.sharing.toString()
            }
        }
    }
}
