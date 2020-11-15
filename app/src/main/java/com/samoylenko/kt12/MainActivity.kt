package com.samoylenko.kt12

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.samoylenko.kt12.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val viewModel: PostViewModel by viewModels()
        viewModel.data.observe(this, { post ->
            with(binding) {
                author.text = post.author
                txtDate.text = post.published
                textData.text = post.content
                countView.text = post.countVisability.toString()
                countLike.text = Calc.intToText(post.like)
                countShare.text = post.sharing.toString()
                like.setImageResource(
                    if (post.likedByMe) R.drawable.ic_liked_24  else R.drawable.ic_baseline_favorite_border_24
                )
            }
        })
        binding.share.setOnClickListener {
            viewModel.sharing()
        }
        binding.like.setOnClickListener {
            viewModel.like()
        }
    }
}
