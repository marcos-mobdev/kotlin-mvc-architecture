package br.com.appforge.kotlinmvcarchitecture.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import br.com.appforge.kotlinmvcarchitecture.controller.PostController
import br.com.appforge.kotlinmvcarchitecture.databinding.ActivityFeedBinding

class FeedActivity : AppCompatActivity() {

    private val binding by lazy{
        ActivityFeedBinding.inflate(layoutInflater)
    }

    private lateinit var userController: PostController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        //Code cannot be reused
        //userController = UserController(this) //Expected MainActivity at parameters

    }
}