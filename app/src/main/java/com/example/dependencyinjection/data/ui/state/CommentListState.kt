package com.example.dependencyinjection.data.ui.state

import com.example.dependencyinjection.data.model.Comment

sealed class CommentListState{
    object Idle: CommentListState()
    object Loading: CommentListState()
    class Success(val comment: List<Comment>): CommentListState()
    object Error: CommentListState()
}
