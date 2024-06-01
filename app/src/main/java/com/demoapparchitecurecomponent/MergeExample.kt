package com.demoapparchitecurecomponent

import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.merge
import kotlinx.coroutines.flow.toList

public suspend fun mergeExample(){
     val flow1 = flowOf(1,2)
     val flow2 = flowOf(3,4,5)
    val result = merge(flow1,flow2)
    println("Merge result :: "+result.toList())
    println("First Value of result :: "+result.firstOrNull())
    println("Filter result :: "+result.filter { it>5 }.toList())
    println("Map result :: "+result.map { it*2 }.toList())

 }

/*OutPut

Merge result :: [1, 2, 3, 4, 5]
First Value of result :: 1
Filter result :: []
Map result :: [2, 4, 6, 8, 10]
*/

public suspend fun mergeExampleAnother(){
    val flow1 = flowOf("A","B","C")
    val flow2 = flowOf(3,4,5)

    val result = merge(flow2,flow1)
    result.collect(){
        println("result value $it")

    }
    println("Merge result :: "+result.toList())
    println("First Value of result :: "+result.firstOrNull())
}
/*Output
result value 3
result value 4
result value 5
result value A
result value B
result value C
Merge result :: [3, 4, 5, A, B, C]







*/