package com.demoapparchitecurecomponent

fun main(){
    val studentClass = object  : StudentClass("Supriua"){
        override fun getName() {
            super.getName()
            println("Annumuss :$name")
        }
    }
    studentClass.getName()
}

open class StudentClass(val name: String){
  open  fun getName(){
        println("Name is  : $name")
    }
}