fun main() {
    val kotlin = "🙂"
    println(kotlin)

    val names: MutableList<String> = mutableListOf("A", "a", "B", "j")
    print(names.distinctBy({ it.toUpperCase() }))

    var age = listOf(1, 6, 4, 9, 10, 89)
    println(age.distinctBy({ it > 6 }))

    var users = listOf(
        User("supriya", 10),
        User("supriya", 10),
        User("arvind", 32),
        User("shreeja", 24),
        User("shresth", 98)
    )
    //remove duplicate object on age
    users.distinctBy { it.age }.forEach { println(it.toString()) }

    users.filter { it.age > 10 }.forEach { println(it.toString()) }


}


class User(val name: String, val age: Int) {

    //convert object into string
    override fun toString(): String {
        return "${name} -- ${age}"
    }
}

