package Kotlin_labs

class Bird(name: String) : Animal(name) , Voiceable {
    var color: String = ""

    fun setterColor(color: String) {
        this.color = color
    }
    override fun move() {
        println("Птиця $name літає")
    }

    fun chirp() {
        println("Кар!")
    }
    override fun loudVoice() {
        println("Птиця: КАР-КАР!")
    }

    override fun quietVoice() {
        println("Птиця: кар-кар...")
    }
}