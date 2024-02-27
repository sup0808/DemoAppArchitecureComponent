package com.demoapparchitecurecomponent

fun main(){
    val lamda = {a:Int, b:Int ->a+b}
    println(lamda(1,2))

    val multilineLamda = {
        println("Supriya")
        val ad = 12
        "data"
        2
    }

    val singleParam = { x : Int -> x*x}
    val sayHi = {msg : String -> println(msg) }

    multilineLamda()
    println(singleParam(3))
    sayHi("hello")

}