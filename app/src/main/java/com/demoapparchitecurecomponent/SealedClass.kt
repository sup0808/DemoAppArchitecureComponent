package com.demoapparchitecurecomponent

fun main() {
    val obj : Result = Success("Print data")

    val message = when(obj){

        is Error -> println("exception")
        is Success ->  println("Success")
    }


}
sealed class Result

class Success(val message : String) : Result()

class Error(ex : Exception) : Result()