package com.demoapparchitecurecomponent

fun main(){
    val outer = Outer()

    println(outer.i)
    val inner = OuterTest().Inner()
    inner.test()




}
class OuterTest {
    val i =1
    inner class Inner{
        fun test(){
            println("Inner class :: $i")
        }
    }
}