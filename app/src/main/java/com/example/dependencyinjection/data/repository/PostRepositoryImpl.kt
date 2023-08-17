package com.example.dependencyinjection.data.repository

import com.example.dependencyinjection.data.model.Post
import com.example.dependencyinjection.data.service.PostService

import javax.inject.Inject

class PostRepositoryImpl @Inject constructor(
    private val postService: PostService
) : PostRepository {

    override suspend fun getAll(): List<Post> {
       return postService.getAll()
    }
    override suspend fun create(post: Post){
        postService.create()
    }

}