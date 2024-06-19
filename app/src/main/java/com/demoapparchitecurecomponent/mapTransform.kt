package com.demoapparchitecurecomponent

fun main() {
    // map() with mutableListOf--

    var names = mutableListOf("Supriya","test","sggs","android","test")

    names.map{it.uppercase()}.forEach{ println(it)}

    var stu = mutableListOf(
        StudentKnit("shresth",8),
        StudentKnit("supriya",32),
        StudentKnit("shresth",8),
        StudentKnit("arvind",37),
        StudentKnit("shreeja",1),
    )

    stu.map{it->"--${it.name}--"}.forEach{ println(it)}

    // map() with mutableSetOf--

    var namesSet = mutableListOf("Supriya","test","sggs","android","test")

    namesSet.map{it.uppercase()}.forEach{ println(it)}

    var stuSet = mutableListOf(
        StudentKnit("shresth",8),
        StudentKnit("supriya",32),
        StudentKnit("shresth",8),
        StudentKnit("arvind",37),
        StudentKnit("shreeja",1),
    )

    stu.map{it->"--${it.name}--"}.forEach{ println(it)}


}

class StudentKnit(var name : String, var age : Int){
    override fun toString(): String{

        return "${name} : ${age} "
    }

}