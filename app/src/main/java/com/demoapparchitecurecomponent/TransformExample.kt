package com.demoapparchitecurecomponent

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.transform
import kotlinx.coroutines.runBlocking

suspend fun performRequest(response : Int) : String{
    delay(1000)
    return "Response $response"
}

fun main() = runBlocking {
    (1..3).asFlow().transform {
        emit("Making Request $it")
        emit(performRequest(it))
    }
        .collect{
            println(it)
        }
}

/*
output
Making Request 1
Response 1
Making Request 2
Response 2
Making Request 3
Response 3*/
