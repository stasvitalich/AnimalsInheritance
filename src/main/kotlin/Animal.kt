interface Roamable { // Мы добавили интерфейс, и нам нужен класс для него.
    fun roam()
}

abstract class Animal : Roamable { // Данный класс реализует интерфейс Roamable.
    abstract val image: String
    abstract val food: String
    abstract val habitat: String
    val hunger = 10
    abstract fun makeNoise()
    abstract fun eat()
    override fun roam() { // Данная функция будет переопределяться в интерфейсе, поэтому override
        println("The animal is roaming")
    }

    fun sleep() {
        println("The animal is sleeping")
    }
}

class Hippo : Animal() {
    override val image = "hippo.jpg"
    override val food = "grass"
    override val habitat = "water"

    override fun makeNoise() {
        println("Grunt! Grunt!")
    }

    override fun eat() {
        println("The Hippo is eating $food")
    }
}

abstract class Canine : Animal() {
    override fun roam() {
        println("The Canine is roaming")
    }
}

class Wolf : Canine() {
    override val image = "wolf.jpg"
    override val food = "meat"
    override val habitat = "forests"

    override fun makeNoise() {
        println("Hoooooowl")
    }

    override fun eat() {
        println("The wolf is eating $food")
    }
}

class Vehicle : Roamable { // Создаём класс для интерфейса
    override fun roam(){
        println("The Vehicle is roaming")
    }
}

class Vet {
    fun giveShot(animal: Animal) {
        //Code to do something medical
        animal.makeNoise()
    }
}

fun main() {
    val animals = arrayOf(Hippo(), Wolf())
    for (item in animals) {
        item.roam()
        item.eat()
    }

    val vet = Vet()
    val wolf = Wolf()
    val hippo = Hippo()

    vet.giveShot(wolf)
    vet.giveShot(hippo)

    val roamables = arrayOf(Hippo(), Wolf(), Vehicle())
    for (item in roamables){
        item.roam()
        if (item is Animal){
            item.eat()
        }
    }
}