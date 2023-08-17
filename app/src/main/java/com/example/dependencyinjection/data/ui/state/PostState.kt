package com.example.dependencyinjection.data.ui.state

import com.example.dependencyinjection.data.model.Post

sealed class PostState{
    object Idle: PostState()
    object Loading: PostState()
    class Result(val post: List<Post>): PostState()
    object Error: PostState()
}
