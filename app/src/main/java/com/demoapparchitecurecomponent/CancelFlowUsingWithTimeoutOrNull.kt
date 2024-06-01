package com.demoapparchitecurecomponent

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withTimeoutOrNull

fun CancelFlowUsingWithoutTimeOut() : Flow<Int> = flow {
    for(i in 1..5){
        delay(50)
        emit(i)
        println("emitting $i")
    }
}

fun main() = runBlocking<Unit>{

    withTimeoutOrNull(250){
        CancelFlowUsingWithoutTimeOut().collect{
            println(it)
        }
    }
}

/*
output
1
emitting 1
2
emitting 2
3
emitting 3*/
