package com.demoapparchitecurecomponent

fun main() {
    // map() with mutableListOf--

    var fruits = mutableListOf("mango", "garpes","lici","straberry")
    var vegesarbles = mutableListOf("potato","onion","ginger","garlic")

    var cart = listOf(fruits,vegesarbles)
    var cartMap =  cart.map{it}
    var cartFlatMap = cart.flatMap{it}
    println(" Cart map $cartMap")
    println(" Cart flatMap $cartFlatMap")

}