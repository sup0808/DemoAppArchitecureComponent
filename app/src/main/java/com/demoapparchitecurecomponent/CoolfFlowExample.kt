package com.demoapparchitecurecomponent

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking

fun Simple() : Flow<Int> = flow {
    println("Flow started")
    for(i in 1..3){
        delay(100)
        emit(i)
    }
}

fun main() = runBlocking {
    println("Calling simple function...")
    val flow = Simple()
    println("Calling collect...")
    flow.collect{ println(it) }
    println("Calling collect again ...")
    flow.collect{ println(it) }

}
/*
* Output
* Calling simple function...
Calling collect...
Flow started
1
2
3
Calling collect again ...
Flow started
1
2
3
* */