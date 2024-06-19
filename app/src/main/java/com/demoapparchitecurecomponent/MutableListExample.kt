package com.demoapparchitecurecomponent

fun main() {
    val kotlin = "🙂"
    println(kotlin)

    val names: MutableList<String> = mutableListOf("A", "a", "B", "j")
    //adding elements
    names.add("s")
    names.add("j")

    //remving elements
    names.remove("B")
    println("Name list after deletion :: $names")

    var age = listOf(1, 6, 4, 9, 10, 89)

    //getting elements
    print(age.get(4))

    var users = listOf(
        Users("supriya", 10),
        Users("supriya", 10),
        Users("arvind", 32),
        Users("shreeja", 24),
        Users("shresth", 98)
    )
}

class Users(val name: String, val age: Int) {

    //convert object into string
    override fun toString(): String {
        return "${name} -- ${age}"
    }
}

