fun main() {
    var numbers = listOf(-1,-2,-3,-4,-5,-6,2,4,5)
    var emptyList = emptyList<Int>()
    var only = listOf(4)

    println("Numbers :: ${numbers}  , Min : ${numbers.minOrNull()}, Max : ${numbers.maxOrNull()}")
    println("emptyList :: ${emptyList}  , Min : ${emptyList.minOrNull()}, Max : ${emptyList.maxOrNull()}")
    println("only :: ${only}  , Min : ${only.minOrNull()}, Max : ${only.maxOrNull()}")
}

/*
Numbers :: [-1, -2, -3, -4, -5, -6, 2, 4, 5]  , Min : -6, Max : 5
emptyList :: []  , Min : null, Max : null
only :: [4]  , Min : 4, Max : 4*/
