package com.example.dependencyinjection.data.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.dependencyinjection.data.model.Comment
import com.example.dependencyinjection.databinding.DetailListItemBinding

class CommentAdapter(private val context: Context,private val comment:List<Comment>):RecyclerView.Adapter<CommentAdapter.CustomViewModel>() {

    class CustomViewModel(binding: DetailListItemBinding) :RecyclerView.ViewHolder(binding.root) {
        val tvCommentId =binding.tvCommentId
        val tvCommentName =binding.tvCommentName
        val tvCommentEmail =binding.tvCommentEmail
        val tvCommentBody =binding.tvCommentBody
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CustomViewModel {
        val binding =DetailListItemBinding.inflate(LayoutInflater.from(context),parent,false)
        return  CustomViewModel(binding)
    }

    override fun onBindViewHolder(holder: CustomViewModel, position: Int) {
        val comment =comment[position]
        holder.tvCommentId.text = comment.id.toString()
        holder.tvCommentName.text=comment.name.toString()
        holder.tvCommentEmail.text=comment.email
        holder.tvCommentBody.text=comment.body
    }

    override fun getItemCount(): Int {
        return comment.size
    }
}