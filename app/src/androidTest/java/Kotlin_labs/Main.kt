package Kotlin_labs


fun main(){

    val dog1 = Dog("Лаки")
    val dog2 = Dog("Лео")
    val bird1 = Bird("Джо")
    val bird2 = Bird("Буш")

    dog1.age = 5
    dog2.setterBreed("Bulldog")
    println(dog1.age)
    println(dog2.breed)


    bird1.move()
    bird1.chirp()
    bird2.setterColor("red")

    val myAnimals = listOf(dog1,dog2,bird1,bird2)
    myAnimals.forEach(){
        it.move()
    }
}
