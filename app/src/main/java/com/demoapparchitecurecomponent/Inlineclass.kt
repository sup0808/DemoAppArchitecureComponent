package com.demoapparchitecurecomponent

fun main(){
    calculateTimeandRun {
        loopFu(100000)
    }
}

fun loopFu(n : Long){
    for ( i:Long in 1..n){

    }
}

inline fun calculateTimeandRun(fn : ()->Unit){
    val start = System.currentTimeMillis()
    fn()
    val end = System.currentTimeMillis()
    println("Time taken : ${end-start} ms")
}