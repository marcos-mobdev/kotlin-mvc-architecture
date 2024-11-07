package br.com.appforge.kotlinmvcarchitecture.view

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import br.com.appforge.kotlinmvcarchitecture.controller.PostController
import br.com.appforge.kotlinmvcarchitecture.databinding.ActivityMainBinding
import br.com.appforge.kotlinmvcarchitecture.model.Post
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {

    private val binding by lazy{
        ActivityMainBinding.inflate(layoutInflater)
    }

    //Instance of Controller
    private lateinit var postController: PostController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        //Initializing Controller
        postController = PostController(this)

        binding.btnGetPosts.setOnClickListener {
            postController.getPosts()
        }

        binding.btnNavigate.setOnClickListener {
            startActivity(Intent(this,FeedActivity::class.java))
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        postController.onDestroy()
    }

    //Passive
    suspend fun showPosts(list:List<Post>){
        var postsText = ""
        list.forEach { post->
            postsText += "${post.id} - ${post.body}\n"
        }
        withContext(Dispatchers.Main){
            binding.textPosts.text = postsText
        }

    }
}