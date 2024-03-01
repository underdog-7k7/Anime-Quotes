package com.personal.animeshpandey.animefacts.Model

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET


//suspend fun getQuotes():QuoteResponse
private val myretrofitobject = Retrofit.Builder().baseUrl("https://animechan.xyz/api/")
    .addConverterFactory(GsonConverterFactory.create())
    .build()

    val QuoteService = myretrofitobject.create(ApiService::class.java)

interface ApiService{
    @GET("random")
    suspend fun getQuotes():Quote
}