package com.example.mvvmlearning.api

class ApiHelper (private val apiService: ApiService) {

    fun getUsers() = apiService.getUsers()


}