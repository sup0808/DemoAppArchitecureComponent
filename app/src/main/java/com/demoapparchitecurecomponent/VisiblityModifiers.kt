package com.demoapparchitecurecomponent

fun main(){
        val obj = A()
    val obj2 = B()

    obj2.test()
}

 fun test(){

}

open class A{
   public  var a = 10
   private  var b = 20
  internal  var c = 30
  protected  var d = 40
}

class B : A(){

    fun test(){
        println(a)
        // println(b)
        println(c)
        println(d)
    }
}