package com.example.dependencyinjection.data.ui.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.dependencyinjection.data.repository.PostRepository
import com.example.dependencyinjection.data.ui.state.PostState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val postRepository: PostRepository
) : ViewModel() {

    private val _postState: MutableStateFlow<PostState> = MutableStateFlow(PostState.Idle)
    val postState: StateFlow<PostState> = _postState

    fun getAll() {
        viewModelScope.launch {
            kotlin.runCatching {
                _postState.value = PostState.Loading
                _postState.value = PostState.Result(postRepository.getAll())
            }.onFailure {
                _postState.value = PostState.Error
            }
        }
    }
}