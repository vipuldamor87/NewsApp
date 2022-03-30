package com.test.newsapp.network

import com.test.newsapp.model.NewsData
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface ApiService {
    @GET("everything?q=tesla&from=2022-02-28&sortBy=publishedAt&apiKey=30470afd6fdf44d2b6b220a524d09f76")
    fun getTestlaNews(): Call<NewsData>

    @GET("everything?q=apple&from=2022-03-29&to=2022-03-29&sortBy=popularity&apiKey=30470afd6fdf44d2b6b220a524d09f76")
    fun getAppleData(): Call<NewsData>

    @GET("top-headlines?country=us&category=business&apiKey=30470afd6fdf44d2b6b220a524d09f76")
    fun getBusinessData(): Call<NewsData>

    @GET("everything?q=india&from=2022-03-30&to=2022-03-30&sortBy=popularity&apiKey=30470afd6fdf44d2b6b220a524d09f76")
    fun getIndiaData(): Call<NewsData>

    companion object {
        var apiService: ApiService? = null

        fun getInstance() : ApiService {
            if (apiService == null) {
                val retrofit = Retrofit.Builder()
                    .baseUrl("https://newsapi.org/v2/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                apiService = retrofit.create(ApiService::class.java)
            }
            return apiService!!
        }
    }


}