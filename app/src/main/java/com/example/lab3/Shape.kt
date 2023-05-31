package com.example.lab3

sealed interface Shape {
    class Rectange(sideA:Int , sideB:Int):Shape
    class Line(length:Int):Shape
    class Oval(smallRadius:Int,bigRadius:Int):Shape
}