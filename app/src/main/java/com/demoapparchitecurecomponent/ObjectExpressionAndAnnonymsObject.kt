package com.demoapparchitecurecomponent




fun main() {


    val obj = object {} // Object Expression , obj = annonmous object

    val testObj = object {
        val number = 10
        fun test() {
            println("Object Excprssion Example")
        }
    }
    testObj.test()
}