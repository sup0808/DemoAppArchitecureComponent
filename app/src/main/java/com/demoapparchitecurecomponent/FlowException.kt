package com.demoapparchitecurecomponent

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.runBlocking

fun FlowException() : Flow<String> =
    flow {
        for (i in 1..3) {
            println("Emitting $i")
            emit(i) // emit next value
        }
    }
        .map { value ->
            check(value <= 1) { "Crashed on $value" }
            "string $value"
        }

fun main() = runBlocking {

        FlowException()
            .catch { println("caught $it") }
            .collect{
                 println(it)

        }


}
/*
Emitting 1
1
Emitting 2
2
Caught :: java.lang.IllegalStateException: collected : 2*/

/*
* Emitting 1
string 1
Emitting 2
Caught :: java.lang.IllegalStateException: Crashed on 2*/

