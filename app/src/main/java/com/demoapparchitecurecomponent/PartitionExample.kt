fun main() {
    var numbers = listOf(-1,-2,-3,-4,-5,-6,2,4,5)

    var evenOdd = numbers.partition{ it%2==0 }
    var (positive, negative) = numbers.partition{ it>0 }

    println("Even :: ${evenOdd.first}")
    println("Odd :: ${evenOdd.second}")
    println("Positive :: ${positive}")
    println("Negative :: ${negative}")
}

/*
* Even :: [-2, -4, -6, 2, 4]
Odd :: [-1, -3, -5, 5]
Positive :: [2, 4, 5]
Negative :: [-1, -2, -3, -4, -5, -6]*/