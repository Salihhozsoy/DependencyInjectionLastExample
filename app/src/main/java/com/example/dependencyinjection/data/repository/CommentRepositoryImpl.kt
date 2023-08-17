package com.example.dependencyinjection.data.repository

import com.example.dependencyinjection.data.model.Comment
import com.example.dependencyinjection.data.service.CommentService
import javax.inject.Inject

class CommentRepositoryImpl @Inject constructor(
    private val commentService: CommentService) : CommentRepository {


    override suspend fun getComment(id:Int): List<Comment> {
       return commentService.getComment(id)
    }
}