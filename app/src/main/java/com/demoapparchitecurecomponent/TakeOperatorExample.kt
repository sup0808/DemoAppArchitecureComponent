package com.demoapparchitecurecomponent

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.take
import kotlinx.coroutines.runBlocking

fun TakeOperatorExample() : Flow<Int> = flow {
    emit(1)
    emit(2)
    println("This will not execute")
    emit(3)
}

fun main() = runBlocking {
       TakeOperatorExample().take(2)
           .collect{
               println(it)
           }
    }

