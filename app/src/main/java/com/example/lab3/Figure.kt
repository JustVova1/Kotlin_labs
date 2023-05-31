package com.example.lab3

data class Figure(
    val width :Int,
    val height :Int

){
    var area :Int =0
        private set
        get() = this.width * this.height

}