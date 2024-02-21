package com.demoapparchitecurecomponent

fun main() {
    var user: User= Student()
    user.getUserName()
}

open class User(val name : String) {
    open fun getUserName(){
        println("Base class :: User $name")
    }
}

interface test{
    fun getUserName(){
        println("intercae :: dervied")
    }
}

interface test2{
    fun getUserName(){
        println("intercae :: derviednnn")
    }
}

class Student : User("supriya"), test,test2{
    override fun getUserName(){
        super<User>.getUserName()
        super<test>.getUserName()
        super<test2>.getUserName()
        println("Derived class : Student")
    }
}