package com.demoapparchitecurecomponent

fun main() {

    var person = listOf(
        Persons("shresth",8),
        Persons("supriya",32),
        Persons("shresth",8),
        Persons("arvind",37),
        Persons("shreeja",1),
    )
    //associateBy example
    var nameMap = person.associateBy{it.name}
    var nameAgeMap = person.associateBy({it.name},{it.age})

    println("nameMap ${nameMap}")
    println("nameAgeMap ${nameAgeMap}")

    //groupBy


    var nameMaps = person.groupBy{it.name}
    var nameAgeMaps = person.groupBy({it.name},{it.age})

    println("nameMap groupBY ${nameMaps}")
    println("nameAgeMap groupBy ${nameAgeMaps}")


}

class Persons(var  name : String, var age : Int){

    override fun toString() : String{
        return "${name}-${age}"
    }
}