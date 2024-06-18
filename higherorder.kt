fun main() {
    val kotlin = "🙂"
  
var res=  calculate(1,3){
        a,b->a+b
    }
 println("Add :: $res")
  
  
  var multiply = calculate(4,5, {a,b -> a*b})
  println("Multiply :: $multiply")
  
  
}

fun calculate(a : Int, b : Int, add : (Int, Int) ->Int) :Int
{
     var res=add(a,b)
     println("$res")
     return add(a,b)
     
}
