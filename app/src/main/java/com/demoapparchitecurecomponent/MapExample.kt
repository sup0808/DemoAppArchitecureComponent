package com.demoapparchitecurecomponent

fun main() {
    //readonly set
    val names : Map<Int,String> = mapOf(1 to "Supriya" ,3 to "test",2 to "sggs",5 to "android",6 to "test")
    println(names)

    var stuMap : MutableMap<Int, Students> = mutableMapOf(
        1 to Students("shresth",8),
        2 to Students("supriya",32),
        3 to Students("shresth",8),
        4 to Students("arvind",37),
        5 to Students("shreeja",1),
    )
    println(stuMap)

    if(stuMap.contains(2)){
        println("updating age -- ${stuMap.getValue(2)}") // getting value from map

        stuMap[2] = Students("SURRRRRRRR",3) // setting value in map
        println(stuMap)
    }

    stuMap.filter { it.key>2 }.forEach{//filter map based on key and this iterating each element
            k,v->
        println("$k -- $v")
    }

    var transMap : List<Int> =   stuMap.map { it.key*2 } // tansform the keys of maps

    println(transMap)

}
class Students(var name : String, var age : Int){
    override fun toString(): String{

        return "${name} : ${age} "
    }

}