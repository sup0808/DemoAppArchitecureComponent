package com.demoapparchitecurecomponent

import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*

fun requestFlow(i: Int): Flow<String> = flow {
    emit("$i: First")
    delay(500) // wait 500 ms
    emit("$i: Second")
}

fun main() = runBlocking<Unit> {
    val startTime = System.currentTimeMillis() // remember the start time
    val result = (1..3).asFlow().onEach { delay(100) } // emit a number every 100 ms
        .flatMapConcat { requestFlow(it) }
        .collect { value -> // collect and print
            println(value)
          //  println("$value at ${System.currentTimeMillis() - startTime} ms from start")
        }
}
/*
* 1: First
1: Second
2: First
2: Second
3: First
3: Second*/