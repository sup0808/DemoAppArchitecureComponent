package com.demoapparchitecurecomponent

fun main() {
    val currentDirections = Directions.NORTH

    val message = when(currentDirections){
        Directions.EAST -> "East Directions"
        Directions.WEST -> "WEST Directions"
        Directions.NORTH -> "NORTH Directions"
        Directions.SOUTH -> "SOUTH Directions"

    }

    println(message)

    println(Directions.valueOf("WEST"))
}

enum class Directions {
    EAST,
    WEST,
    NORTH,
    SOUTH
}