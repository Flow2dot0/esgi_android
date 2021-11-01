package com.florian.gustin

import java.math.RoundingMode
import java.text.DecimalFormat
import java.util.*

fun main(){

    // calculator
    10.tva()

    // isEven()
    println(9.isEven())
    println(4.isEven())

    // voyelle
    println(isVoyelle('b'))

    // loop
    loopingAndRevert()

    // ESGI
    displayESGI()

    // Multiply
    multiply(5)
    multiply()

    // compilation
    useFoo()

    // factorielle
    println(factorielle(55))

    // User
    val user1 = User("gustin", "florian")
    val user2 = User("gustin", "florian")

    val usr1 = UserPre("gustin", "florian")
    val usr2 = UserPre("gustin", "florian")
    println(usr1 == usr2)
    println(user1.equals(user2))

    // Weather
    val w = Weather(12.666666666666663, "tokyo")
    val ww = Weather(w)

    // User
    User.hello()

    // Pangramme
    println(pangrammeVoyelle("Portez ce vieux whisk au juge blond qui fume"))
    println(pangramme("Portez ce vieux whisky au juge blond qui fume"))

    // Collections
    collections()

}

fun Int.tva() {
    val df = DecimalFormat("#.##")
    df.roundingMode = RoundingMode.CEILING
    println(df.format(this*1.021))
    println(df.format(this*1.055))
    println(df.format(this*1.10))
    println(df.format(this*1.20))
}

fun Int.isEven() : Boolean {
    return this % 2 == 0
}

fun isVoyelle(char : Char) : Boolean {
    return when(char){
        'a', 'e', 'i', 'o', 'u', 'y' -> true
        else -> false
    }
}

fun loopingAndRevert(){
    for(i in 1..100){
        println(i)
    }
    for(i in 100 downTo 1){
        println(i)
    }
}

fun displayESGI() : Unit {
    println("Hello ESGI")
}

fun multiply(value : Int = 2) : Int = value*5

fun foo(name: String, number: Int = 1, toUpperCase: Boolean = true) =
    (if (toUpperCase) name.toUpperCase() else name) + number

fun useFoo() = listOf(
    foo("a"),
    foo("b", number = 1),
    foo("c", toUpperCase = true),
    foo(name = "d", number = 2, toUpperCase = true)
)

fun factorielle(n : Int) : Int{
    if(n > 1)
        return factorielle(n-1)
    else
        return 1;
}

class UserPre(val nom : String, val prenom : String){


    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as UserPre

        if (nom != other.nom) return false
        if (prenom != other.prenom) return false

        return true
    }

    override fun hashCode(): Int {
        var result = nom.hashCode()
        result = 31 * result + prenom.hashCode()
        return result
    }
}

data class User(val nom : String, val prenom : String){

    companion object{
        fun hello() : String = "Hello World"
    }


    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as User

        if (nom != other.nom) return false
        if (prenom != other.prenom) return false

        return true
    }

    override fun hashCode(): Int {
        var result = nom.hashCode()
        result = 31 * result + prenom.hashCode()
        return result
    }
}

open class Weather(val temperature : Double, val location : String){

    companion object{
        const val ZERO : Int = 0
        const val TWENTY_FIVE : Int = 25
    }

    constructor(weather: Weather) : this(weather.temperature, weather.location)

    val safeLocation : String
        get() = if(location.isEmpty()) "" else "Lieu : $location"

    override fun toString(): String {
        return "Température de $location : $temperature"
    }

    fun isCold() : String {
        return if (temperature < ZERO ) "il fait froid" else "il fait pas encore trop froid"
    }

    open fun isHot() : String {
        return if(temperature > TWENTY_FIVE) "il fait chaud" else "il fait pas encore chaud"
    }
}

class LocalWeather(temperature : Double, location : String) : Weather(temperature = temperature, location = location) {

    companion object{
        const val fourty = 40
    }

    override fun isHot(): String {
        return if (temperature > 40) "il fait très chaud" else "il fait pas encore si chaud"
    }
}


fun pangrammeVoyelle(sentence: String) : Boolean{
    val characters = mutableListOf<Char>('a', 'e', 'u', 'i', 'o', 'y')
    val temp = mutableListOf<Char>()

    for (char in sentence){
        if(sentence.contains(char) && !temp.contains(char)) temp.add(char)
    }

    return temp.containsAll(characters)
}

fun pangramme(sentence: String) : Boolean = ('a'..'z').all { sentence.lowercase().contains(it) }


fun collections() : Unit {
    val entiers = mutableListOf<Int>()
    (1..10).all { entiers.add(it) }

    var total = 0
    for (entier in entiers){
        total += entier
    }

    val totalSum = entiers.sum()
    val totalSumBy = entiers.sumOf { it*2 }

    println("iterate sum $total")
    println("sum $totalSum")
    println("sumBy $totalSumBy")


    val list = listOf("bonjour", "le", "Monde", "je", "m'appelle", "Toto", "j'habite", "en", "Bretagne")
    val grouped = list.groupBy { it[0].toLowerCase() }

    println(grouped)
}
