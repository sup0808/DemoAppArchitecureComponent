fun main() {
    val kotlin = "🙂"
    println(kotlin)

    val names: MutableList<String> = mutableListOf("A", "a", "B", "j")
    names.add("s")
    names.add("j")

    var age = listOf(1, 6, 4, 9, 10, 89)

    print(age.get(4))

    var users = listOf(
        User("supriya", 10),
        User("supriya", 10),
        User("arvind", 32),
        User("shreeja", 24),
        User("shresth", 98)
    )
}

class User(val name: String, val age: Int) {

    //convert object into string
    override fun toString(): String {
        return "${name} -- ${age}"
    }
}

