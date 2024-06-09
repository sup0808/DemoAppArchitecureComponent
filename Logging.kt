
//perflormimg long operations
fun main() {
    log("MainActivity ","Gettin user deatils "){
        //perflormimg long operations
            54554
    }
  
  
}
​
fun <T> log(tag : String, msg : String , LoggedFunction : ()->T) : T{
    println("$tag :: $msg")
    var result =  LoggedFunction()
    println("$tag Function Result :: $result")
    return result
}

//MainActivity  :: Gettin user deatils 
MainActivity  Function Result :: 54554
