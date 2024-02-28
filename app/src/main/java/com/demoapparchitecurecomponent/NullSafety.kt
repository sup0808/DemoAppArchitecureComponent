package com.demoapparchitecurecomponent

fun main(){
    var gender : String = "female"

    var name : String? = null

    var status : Boolean? = null

    if (name != null) {
       println(name.toUpperCase())
    }

    println(name?.toLowerCase())

    name?.let {
        println("Line 1")
        println("Line 2 $name")
        println("Line 3 $it")

    }
    var slectedValue = name ?: "vv"
    println(slectedValue)

    var name2 = name!!.toUpperCase()
    println(name2)
}