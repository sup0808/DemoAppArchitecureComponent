package com.demoapparchitecurecomponent

fun main(){
    val p1 = PersonDemo(1,"Supriya")
    val p2 = PersonDemo(1,"Supriya")

    //copy() example
    val p3 : PersonDemo = p1.copy()
    println(p3)

    val p4 : PersonDemo = p1.copy(name= "Arvind")
    println(p4)

    //ComponentN() example (Destructure example)
    val(ids : Int, names : String) = p1
        println(ids)
        println(names)
        println(p1.component2())
}

data class PersonDemo(val id : Int,val name: String)

//Output
/*
PersonDemo(id=1, name=Supriya)
PersonDemo(id=1, name=Arvind)
1
Supriya
Supriya*/
