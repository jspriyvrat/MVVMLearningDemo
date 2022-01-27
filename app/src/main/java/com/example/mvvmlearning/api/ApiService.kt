package com.example.mvvmlearning.api

import com.example.mvvmlearning.models.User
import io.reactivex.Single

interface ApiService {

    fun getUsers(): Single<List<User>>

}