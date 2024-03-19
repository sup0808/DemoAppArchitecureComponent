package com.example.kotlinroomdatabase.repository



sealed interface Response<out T> {

    object Loading : Response<Nothing>
   data class Success<T>(val datas: T? = null) : Response<T>
   data class Error(val errorMessage : String) : Response<Nothing>
}