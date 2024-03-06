package com.demoapparchitecurecomponent

fun main(){
    val  employee = Employee()
    employee.age = 20
    employee.name = "Supriya"

    println(employee)

    employee.apply {
        age= 30
        name = "Arvind"
    }

    println(employee)
}

data class Employee(var name: String ="", var age : Int = 18)