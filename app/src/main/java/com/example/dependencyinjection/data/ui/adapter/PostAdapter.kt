package com.example.dependencyinjection.data.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.dependencyinjection.data.model.Post
import com.example.dependencyinjection.databinding.PostListItemBinding

class PostAdapter(
    private val context: Context,
    private var posts: List<Post>,
    val onClick:(post: Post) -> Unit
    ) : RecyclerView.Adapter<PostAdapter.CustomViewHolder>() {

    class CustomViewHolder(binding: PostListItemBinding) : RecyclerView.ViewHolder(binding.root) {
        val tvPostTitle = binding.tvPostTitle
        val tvPostBody = binding.tvPostBody
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CustomViewHolder {
        val binding = PostListItemBinding.inflate(LayoutInflater.from(context), parent, false)
        return CustomViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        val posts = posts[position]
        holder.tvPostTitle.text =posts.title
        holder.tvPostBody.text =posts.body
        holder.itemView.setOnClickListener {
            onClick(posts)
        }
    }

    override fun getItemCount(): Int {
        return posts.size
    }
}