fun main() {
    //readonly set
    val names : Set<String> = setOf("Supriya","test","sggs","android","test")

    //MutableSet
    var ages: MutableSet<Int> = mutableSetOf(1,9,6,0,5,88,0,8)
    ages.add(7)
    ages.add(10)
    ages.remove(0)
    print(ages)

    //MutableSet with  Object

    var stu = mutableSetOf(
        Student("shresth",8),
        Student("supriya",32),
        Student("shresth",8),
        Student("arvind",37),
        Student("shreeja",1),
    )

    println(stu)

    stu.distinctBy { it.age>8 }.forEach{ println(it)}
}

class Student(var name : String, var age : Int){
    override fun toString(): String{

        return "${name} : ${age} "
    }

}