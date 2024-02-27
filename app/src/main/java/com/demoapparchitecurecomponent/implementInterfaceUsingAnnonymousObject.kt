package com.demoapparchitecurecomponent

fun main(){
    val studentClass = object  : CLoneable{
        override fun clone() {

            println("Interafce using ANnonyuous")
        }
    }
    studentClass.clone()
}

interface CLoneable{
    fun clone()
}