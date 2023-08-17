package com.example.dependencyinjection.data.service

import com.example.dependencyinjection.data.model.Post
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

interface PostService {
    @GET("posts")
    suspend fun getAll() :List<Post>

    @POST("posts")
    suspend fun create():Post

}