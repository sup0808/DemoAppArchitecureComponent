package com.demoapparchitecurecomponent


fun main(){
    val outer = Outer()

    println(outer.i)
    val nested = Outer.Nested()
    nested.test()

    //class with inner class,inner interface examaple
    val innerClassTest = Outer1.InnerClassTest()
    innerClassTest.testInner()

    //class with inner class,inner interface examaple
   /* val innerInterfcaeTest = Outer1.InnerInterface
    innerInterfcaeTest.testInner()*/


}
class Outer {
    val i =1
    class Nested{
        fun test(){
            println("Nested class :: ")
        }
    }
}

class Outer1{
    class InnerClassTest{
        fun testInner(){
            println(" InnerClassTest Nested class :: ")
        }
    }

    interface InnerInterface {
        fun testInterfcae(){
            println("InnerInterface Nested Interface :: ")
        }
    }
}