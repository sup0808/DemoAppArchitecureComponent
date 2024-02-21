package com.demoapparchitecurecomponent

fun main(){
    val p1 = PersonDemo(1,"Supriya")
    val p2 = PersonDemo(1,"Supriya")
    println(p1)
    println(p2)
    println(p1.hashCode())
    println(p1 == p2) //p1.equals(p2) false value is same but address is diffeernt, refers differnt object
}

class PersonDemo(val id : Int,val name: String){

}

//Output
/*
com.demoapparchitecurecomponent.PersonDemo@67b64c45
com.demoapparchitecurecomponent.PersonDemo@4411d970
1740000325
false*/
