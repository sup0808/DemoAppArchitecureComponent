package com.demoapparchitecurecomponent

import kotlinx.coroutines.cancel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking

fun CancelFlowUsingCancelMethod():Flow<Int> = flow{
    for(i in 1..5){
        delay(50)
        emit(i)
        println("emitting $i")
    }
}

fun main() = runBlocking {

    CancelFlowUsingCancelMethod().collect{
        if(it == 3)
            cancel()
        println(it)
    }
}
/*
output
1
emitting 1
2
emitting 2
3
emitting 3
Exception in thread "main" kotlinx.coroutines.JobCancellationException: BlockingCoroutine was cancelled; job=BlockingCoroutine{Cancelled}@2173f6d9
*/
