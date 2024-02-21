package com.demoapparchitecurecomponent

fun main() {
    var person = Person("supriya",5)
    println(person.name)
    person.age =12
    person.age = -12
}

class Person(nameParam : String, ageParam : Int){
    var name : String = nameParam
        get(){
            println("getter called")
            return field.toUpperCase()
        }


    var age : Int= ageParam

        set(value){
            if(value>0)
                field= value
            else
                println("Age can not negative")
        }

    //Default geteer /setter provided by kotlin

    var address: String ="fff"
        get()= field
        set(value){
            field = value
        }
}