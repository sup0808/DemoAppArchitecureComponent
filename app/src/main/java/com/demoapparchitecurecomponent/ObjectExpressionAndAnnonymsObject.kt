package com.demoapparchitecurecomponent


fun main() {

val obj = object : com.demoapparchitecurecomponent.Cloneable{
    override fun clone() {
        println("Not yet implemented")
    }
}

    obj.clone()

}

interface Cloneable{
    fun  clone()
}