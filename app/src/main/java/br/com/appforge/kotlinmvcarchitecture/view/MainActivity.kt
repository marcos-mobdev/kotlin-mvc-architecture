package br.com.appforge.kotlinmvcarchitecture.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import br.com.appforge.kotlinmvcarchitecture.controller.PostController
import br.com.appforge.kotlinmvcarchitecture.databinding.ActivityMainBinding
import br.com.appforge.kotlinmvcarchitecture.model.Post
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {

    private val binding by lazy{
        ActivityMainBinding.inflate(layoutInflater)
    }

    private lateinit var postController: PostController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        postController = PostController(this)
        //userController.getUsers() //Active

        binding.btnGetUsers.setOnClickListener {
            /*
            CoroutineScope(Dispatchers.IO).launch {
                postController.getUsers()
            }
             */
            postController.getUsers()
        }
    }

    //Passive
    suspend fun showPosts(list:List<Post>){
        var postsText = ""
        list.forEach { post->
            postsText += "${post.id} - ${post.body}\n"
        }
        withContext(Dispatchers.Main){
            binding.textResult.text = postsText
        }

    }
}