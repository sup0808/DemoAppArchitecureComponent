fun main() {
    var input  = "supriya"
   val result = input.validate{
        value -> value.isNotEmpty()
    }
   
   println("Result  :: $result")
  
  
}

fun String.validate(validation : (String)->Boolean) : Boolean{
    return validation(this)
}
