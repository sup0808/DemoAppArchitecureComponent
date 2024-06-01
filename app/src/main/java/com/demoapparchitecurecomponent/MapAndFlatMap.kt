package com.demoapparchitecurecomponent

suspend fun MapExample(){
    val data = listOf(User(listOf("supriya","shresth","arvind")),User(listOf("shreeja","bhindi","shibu")))

    val combinedFlatMap = data.flatMap { it.names }
    println(combinedFlatMap)

    val combinedMap = data.map { it.names }
    println(combinedMap)


}

data class User(val names: List<String>)

/*Output
        //Flat Map
[supriya, shresth, arvind, shreeja, bhindi, shibu]
        //Map
[[supriya, shresth, arvind], [shreeja, bhindi, shibu]]*/





