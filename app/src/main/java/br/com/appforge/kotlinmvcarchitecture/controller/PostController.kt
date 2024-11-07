package br.com.appforge.kotlinmvcarchitecture.controller

import br.com.appforge.kotlinmvcarchitecture.model.Post
import br.com.appforge.kotlinmvcarchitecture.model.api.PostAPI
import br.com.appforge.kotlinmvcarchitecture.view.MainActivity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class PostController (
    //High dependence, high coupling
    private val mainActivity: MainActivity
){
    private val postApi = PostAPI()

    fun getUsers(){

        CoroutineScope(Dispatchers.IO).launch {
            //1) Business rules
            val list = postApi.getPosts()

            //2) Update view
            withContext(Dispatchers.Main){
                mainActivity.showPosts(list)
            }
        }


    }

}