package com.demoapparchitecurecomponent

fun main() {
    println(" ${isEvenObj.accept(9)}")
    println(" ${isEven.accept(6)}")
}

fun interface EvenCal{
    fun accept(number : Int) : Boolean
}

val isEven = EvenCal { it%2 ==0 }

val isEvenObj = object : EvenCal{
    override fun accept(number : Int) : Boolean{
        return number%2 == 0
    }
}