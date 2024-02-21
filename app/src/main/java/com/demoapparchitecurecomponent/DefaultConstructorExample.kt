package com.demoapparchitecurecomponent




fun main(){
    var calculator = Calculator()
    println(calculator.add(2,3))
}

class Calculator {
    fun add(a: Int, b : Int) =  a+b

    fun multiply(a: Int, b : Int ) = a*b
}