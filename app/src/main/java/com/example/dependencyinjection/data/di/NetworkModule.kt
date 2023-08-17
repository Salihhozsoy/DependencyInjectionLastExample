package com.example.dependencyinjection.data.di

import com.example.dependencyinjection.data.service.CommentService
import com.example.dependencyinjection.data.service.PostService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    fun provideRetrofit() :Retrofit =Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl("https://jsonplaceholder.typicode.com/").build()

    @Provides
    fun providePostService(retrofit: Retrofit): PostService = retrofit.create(PostService::class.java)

    @Provides
    fun provideCommentService(retrofit: Retrofit): CommentService = retrofit.create(CommentService::class.java)
}