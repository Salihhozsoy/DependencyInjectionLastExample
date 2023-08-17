package com.example.dependencyinjection.data.service

import com.example.dependencyinjection.data.model.Comment
import retrofit2.http.GET
import retrofit2.http.Path

interface CommentService {

    @GET("/posts/{id}/comments")
    suspend fun getComment(@Path ("id")id:Int) :List<Comment>
}