package Kotlin_labs


class Dog(name: String) : Animal(name) , Voiceable{
    var breed: String = ""

    fun setterBreed(breed: String) {
        this.breed = breed
    }

    override fun move() {
        println("Собака $name біжить")
    }
    override fun loudVoice() {
        println("Собака: ГАВ-ГАВ-ГАВ!")
    }

    override fun quietVoice() {
        println("Собака: гав-гав-гав...")
    }
    fun bark() {
        println("Гав-гав!")
    }
}