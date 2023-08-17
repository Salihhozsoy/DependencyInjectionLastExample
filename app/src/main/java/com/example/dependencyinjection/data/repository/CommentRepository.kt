package com.example.dependencyinjection.data.repository

import com.example.dependencyinjection.data.model.Comment

interface CommentRepository {
    suspend fun getComment(id:Int) :List<Comment>
}