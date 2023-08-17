package com.example.dependencyinjection.data.ui.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.example.dependencyinjection.data.ui.adapter.PostAdapter
import com.example.dependencyinjection.data.ui.state.PostState
import com.example.dependencyinjection.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity  : AppCompatActivity() {

    companion object{
        const val PostId="id"
    }
    private lateinit var binding:ActivityMainBinding
    private val viewModel:MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding =ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel.getAll()
        observePostState()

    }

    private fun observePostState(){
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.CREATED){
                viewModel.postState.collect{ it ->
                    when(it){
                        PostState.Idle->{}
                        PostState.Loading->{}
                        is PostState.Result->{
                            binding.rvPost.adapter = PostAdapter(this@MainActivity,it.post){
                                val intent=Intent(this@MainActivity,PostDetailActivity::class.java,)
                                intent.putExtra(PostId,it.id)
                                startActivity(intent)
                            }
                        }
                        PostState.Error->{}
                    }
                }
            }
        }
    }
}