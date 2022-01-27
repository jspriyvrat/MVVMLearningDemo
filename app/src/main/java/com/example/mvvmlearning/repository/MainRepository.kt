package com.example.mvvmlearning.repository

import com.example.mvvmlearning.api.ApiHelper
import com.example.mvvmlearning.models.User
import io.reactivex.Single

class MainRepository(private val apiHelper: ApiHelper) {

    fun getUsers(): Single<List<User>> {
        return apiHelper.getUsers()
    }

}