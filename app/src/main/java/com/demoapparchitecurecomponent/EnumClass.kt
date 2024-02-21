package com.demoapparchitecurecomponent

fun main() {
    val currentDirections = Directions.NORTH

    println(currentDirections)
    println(currentDirections.name)
    println(currentDirections.number)

    for( i :Directions in Directions.values() ){
        println(i)
    }

}

enum class Directions(val number : Int) {
    EAST(1),
    WEST(2),
    NORTH(3),
    SOUTH(4)
}