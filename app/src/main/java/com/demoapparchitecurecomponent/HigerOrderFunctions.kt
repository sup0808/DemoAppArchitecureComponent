package com.demoapparchitecurecomponent

fun main(){
    calculator(1.2,2.3, ::sum)
}


fun sum(a: Double,  b: Double ): Double{
    return a+b
}

fun calculator(a : Double, b: Double, add : (Double, Double)->Double)
{
    val result =  add(a,b)
    println(result)
}