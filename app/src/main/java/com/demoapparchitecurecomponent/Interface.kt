/*
package com.demoapparchitecurecomponent

//Absract class example

fun main() {

    //using child object
    // var shapeObj : Shape = Circle(.1)
    // println(shapeObj.area())

    dragObject(arrayOf(Circle(1.2),Square(1.2), Triangle(1.3,3.0)))

}

fun dragObject(objects: Array<Shape>){
    for(item : Shape in objects){
        item.drag()
    }
}

interface Draggable{
    fun darg()
}

interface Cloneable{
    fun clone()
}

abstract class Shape: Draggable,Cloneable{

    abstract fun area() : Double
    abstract fun drag()

}



class Circle(var radius : Double) : Shape(){

    override fun area() : Double {
        return 3.14*radius*radius
    }

    override fun drag() = println("Circle is drawing")

}

class Square(var side : Double,) : Shape(){

    override fun area() : Double {
        return side*side
    }

    override fun drag() = println("Square is drawing")

}

class Triangle(var base : Double,var height : Double) : Shape(){

    override fun area() : Double = 0.5*base*height
    override fun drag() = println("Triangle is drawing")

}





*/
