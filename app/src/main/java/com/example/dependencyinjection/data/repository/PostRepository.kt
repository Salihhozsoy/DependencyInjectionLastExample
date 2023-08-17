package com.example.dependencyinjection.data.repository

import com.example.dependencyinjection.data.model.Post

interface PostRepository {

    suspend fun getAll(): List<Post>

    suspend fun create(post: Post)

}