package br.com.appforge.kotlinmvcarchitecture.api

import br.com.appforge.kotlinmvcarchitecture.model.Post
import retrofit2.Response
import retrofit2.http.GET

interface JsonPlaceAPI {

    @GET("posts")
    suspend fun getPosts(): Response<List<Post>>

}