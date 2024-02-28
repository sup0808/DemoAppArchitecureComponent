package com.demoapparchitecurecomponent

import java.util.zip.DeflaterOutputStream

fun main(){
    println(addition(b=1.2,a=1.3)) // Named Argument
    println(addition(2.3)) //Default Argument

    var test = :: addition
    println(test(1.2,12.2)) // Function Type

    var test2 : (a: Double, b: Double)->Double = ::addition
    println(test2(2.2,13.2)) // Function Type

}

fun addition(a: Double,  b: Double =10.9): Double{ // Default Argument
    return a+b
}