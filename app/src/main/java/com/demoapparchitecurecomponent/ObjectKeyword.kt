package com.demoapparchitecurecomponent

fun main(){
    println(ObjectA.num)
    println(ObjectB.p)
    ObjectB.test()
}

object  ObjectA{
    val num : Int =9
}

object ObjectB{
    val p =90
    fun test(){
        println("Object B Decalrtion")
    }
}