package com.demoapparchitecurecomponent

fun main() {
    val currentDirections = Directions.NORTH
    currentDirections.printFormattedDirection()
}

enum class Directions(val number : Int) {
    EAST(1),
    WEST(2),
    NORTH(3),
    SOUTH(4); // put ; for wtiting function inside enum class

    fun printFormattedDirection(){
        println("Direction is $this")
    }
}