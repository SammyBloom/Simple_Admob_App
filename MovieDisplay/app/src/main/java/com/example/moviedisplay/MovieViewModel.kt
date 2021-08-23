package com.example.moviedisplay

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.moviedisplay.model.Movies
import com.example.moviedisplay.repository.Repository
import kotlinx.coroutines.launch
import retrofit2.Response

class MovieViewModel (private val repository: Repository): ViewModel() {

    val myResponse: MutableLiveData<Response<Movies>> = MutableLiveData()
//    val myUserResponse: MutableLiveData<Response<User>> = MutableLiveData()

    fun getMovie(number: Int, key: String){
        viewModelScope.launch{
            val response: Response<Movies> = repository.getMovie(number, key)
            myResponse.value= response
        }
    }
}
