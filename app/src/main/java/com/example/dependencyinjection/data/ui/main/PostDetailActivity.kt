package com.example.dependencyinjection.data.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.example.dependencyinjection.data.ui.adapter.CommentAdapter
import com.example.dependencyinjection.data.ui.state.CommentListState
import com.example.dependencyinjection.databinding.ActivityPostDetailBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class PostDetailActivity : AppCompatActivity() {

    lateinit var binding: ActivityPostDetailBinding
    private val viewModel: PostDetailViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPostDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val postId = intent.getIntExtra(MainActivity.PostId, -1)

        viewModel.getComment(postId)
        observeCommentState()

    }


   private fun observeCommentState() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.CREATED) {
                viewModel.commentListState.collect {
                    when (it) {
                        CommentListState.Idle -> {}
                        CommentListState.Loading -> {}
                        is CommentListState.Success -> {
                            binding.rvComments.adapter =
                                CommentAdapter(this@PostDetailActivity, it.comment)
                        }

                        CommentListState.Error -> {}
                    }
                }
            }
        }
    }
}