package com.example.mvvmlearning.ui.main.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mvvmlearning.models.User
import com.example.mvvmlearning.repository.MainRepository
import com.example.mvvmlearning.utils.Resource
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class MainViewModel(private val mainRepository: MainRepository) : ViewModel() {
    private val users = MutableLiveData<Resource<List<User>>>()
    private val compositeDisposable = CompositeDisposable()

    init {
        fetchUser()
    }

    private fun fetchUser() {
        users.postValue(Resource.loading(null))
        compositeDisposable.add(
            mainRepository.getUsers()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ userList ->
                    users.postValue(Resource.success(userList))
                }, { throwable ->
                    users.postValue(Resource.error("Something Went Wrong", null))

                })
        )
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
    }

    fun getUsers(): LiveData<Resource<List<User>>> {
        return users
    }

}