package br.com.appforge.kotlinmvcarchitecture.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import br.com.appforge.kotlinmvcarchitecture.R
import br.com.appforge.kotlinmvcarchitecture.controller.PostController

class FeedActivity : AppCompatActivity() {

    private lateinit var userController: PostController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_feed)

        //Code cannot be reused
        //userController = UserController(this) //Expected MainActivity at parameters

    }
}