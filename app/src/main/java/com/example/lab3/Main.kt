package com.example.lab3

fun main(){
    val a = Figure(2,5)
    val b = Figure(1,3)
    val c = Figure(6,4)

    val figures = listOf(a,b,c)
    var generalArea = 0
    figures.forEach(){
        generalArea = it.area
    }

    val r1 = Shape.Rectange(5,4)
    val r2 = Shape.Rectange(3,5)
    val o1 = Shape.Oval(6,7)
    val o2 = Shape.Oval(3,2)
    val l1 = Shape.Line(7)
    val l2 = Shape.Line(2)


    val shapes = listOf(r1,r2,o1,o2,l1,l2)
    var rectangles = shapes.filterIsInstance<Shape.Rectange>().count()
    var ovals = shapes.filterIsInstance<Shape.Oval>().count()
    var lines = shapes.filterIsInstance<Shape.Line>().count()
    println("Filter")
    println(rectangles)
    println(ovals)
    println(lines)

    rectangles=0
    ovals=0
    lines=0

    shapes.forEach(){
        when(it){
            is Shape.Rectange -> rectangles++
            is Shape.Oval -> ovals++
            is Shape.Line -> lines++
        }
    }
    println("When")
    println(rectangles)
    println(ovals)
    println(lines)
}