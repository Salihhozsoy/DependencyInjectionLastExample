package com.example.dependencyinjection.data.ui.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.dependencyinjection.data.repository.CommentRepository
import com.example.dependencyinjection.data.ui.state.CommentListState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PostDetailViewModel @Inject constructor(
    private val commentRepository: CommentRepository
):ViewModel() {

    private val _commentListState: MutableStateFlow<CommentListState> = MutableStateFlow(
        CommentListState.Idle)
    val commentListState: StateFlow<CommentListState> = _commentListState

    fun getComment(id:Int){
        viewModelScope.launch {
            kotlin.runCatching {
                _commentListState.value = CommentListState.Loading
                _commentListState.value = CommentListState.Success(commentRepository.getComment(id))
            }.onFailure {
                _commentListState.value = CommentListState.Error
            }
        }
    }
}