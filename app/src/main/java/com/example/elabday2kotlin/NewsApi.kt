package com.example.elabday2kotlin

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query
//https://newsapi.org/v2/top-headlines?country=us&apiKey=772ad2641943484f97201e078241bfce
const val BASE_URL="https://newsapi.org/"
const val KEY="772ad2641943484f97201e078241bfce"
interface NewsApi{
    @GET("v2/top-headlines?apiKey=772ad2641943484f97201e078241bfce")
    fun getheadlines(@Query("country")country:String, @Query("page")page:Int): Call<News>
}
object NewsServices{
    var newsinstance:NewsApi
    init {
        var retrofit=Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        newsinstance=retrofit.create(NewsApi::class.java)
    }
}