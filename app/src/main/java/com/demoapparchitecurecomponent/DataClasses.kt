package com.demoapparchitecurecomponent

fun main(){
    val p1 = PersonDemo(1,"Supriya")
    val p2 = PersonDemo(1,"Supriya")
    println(p1)
    println(p2)
    println(p1.hashCode())
    println(p1 == p2) //p1.equals(p2) false value is same but address is diffeernt, refers differnt object
}

data class PersonDemo(val id : Int,val name: String){

}

//Output
/*
PersonDemo(id=1, name=Supriya)
PersonDemo(id=1, name=Supriya)
-190059828
true*/
