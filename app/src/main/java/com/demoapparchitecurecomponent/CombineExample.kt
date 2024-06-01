package com.demoapparchitecurecomponent

import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.toList

public suspend fun combineExample(){
     val flow1 = flowOf(1,2)
     val flow2 = flowOf(3,4,5)
    val result = flow1.combine(flow2){num1,num2 ->
        num1+num2
    }
    println("Combine result :: "+result.toList())
    println("First Value of result :: "+result.firstOrNull())
    println("Filter result :: "+result.filter { it>5 }.toList())
    println("Map result :: "+result.map { it*2 }.toList())

 }

/*OutPut

Combine result :: [4, 5, 6, 7]
First Value of result :: 4
Filter result :: [6, 7]
Map result :: [8, 10, 12, 14]
*/

public suspend fun combineExampleAnother(){
    val flow1 = flowOf("A","B","C")
    val flow2 = flowOf(3,4,5)
    val result = flow1.combine(flow2){num1,num2 ->
        "$num1$num2"
    }
    result.collect(){
        println("result value $it")

    }
    println("Combine result :: "+result.toList())
    println("First Value of result :: "+result.firstOrNull())


}



/*Output
result value A3
result value B3
result value B4
result value B5
Combine result :: [A3, B3, B4, B5]
First Value of result :: A3*/

public suspend fun combineMultipleFlowExample(){
    val flow1 = flowOf("A","B","C")
    val flow2 = flowOf(3,4,5)
    val flow3 = flowOf("X","Y","Z")
    val flow4 = flowOf(8,9)

    val result = combine(flow1, flow2, flow3,flow4) { x, y, z ,q->
        "$x $y $z $q"
    }

    result.collect(){
        println("result value $it")

    }
    println("Combine result :: "+result.toList())
    println("First Value of result :: "+result.firstOrNull())


}

/*Output

result value A 3 X 8
result value B 3 X 8
result value B 4 X 8
result value B 4 Y 8
result value B 4 Y 9
result value C 4 Y 9
result value C 5 Y 9
result value C 5 Z 9
Combine result :: [A 3 X 8, B 3 X 8, B 4 X 8, B 4 Y 8, B 4 Y 9, C 4 Y 9, C 5 Y 9, C 5 Z 9]
        */






