package com.test.newsapp.network

class Repository constructor( val apiService: ApiService ) {
    fun getTeslaData() = apiService.getTestlaNews()
    fun getAppleData() = apiService.getAppleData()
    fun getBusinessData() = apiService.getBusinessData()
    fun getIndiaData() = apiService.getIndiaData()
}