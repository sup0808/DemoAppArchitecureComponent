package com.demoapparchitecurecomponent

fun main() {
    // map() with mutableListOf--

    var fruits = mutableListOf("A", "B","C","D")
    var vege= mutableListOf(1,2,3,4)


    var cartMap =  fruits.zip(vege){ a,b->"$a--$b"}
    var cartFlatMap =fruits zip  vege
    println(cartMap)
    println(" Cart flatMap $cartFlatMap")

}

/*
*
* [A--1, B--2, C--3, D--4]
 Cart flatMap [(A, 1), (B, 2), (C, 3), (D, 4)]*/