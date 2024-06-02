package com.demoapparchitecurecomponent

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking

fun FlowException() : Flow<Int> = flow {
    for (i in 1..3) {
        println("Emitting $i")
        emit(i) // emit next value
    }
}

fun main() = runBlocking {
    try{
        FlowException().collect{
            println(it)
            check(it<=1){
                "collected : $it"
            }
        }
    }
    catch (e : Throwable){
        println("Caught :: $e")
    }
}
/*
Emitting 1
1
Emitting 2
2
Caught :: java.lang.IllegalStateException: collected : 2*/
