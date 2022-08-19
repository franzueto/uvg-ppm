package com.franzueto.lab1

class Kotlin2

// Types:
val char: Char = 'a'
val stringA: String = "String"
val stringB: String = """
        Start.
        This is a String of several lines
        To simplify reading
        End.
    """.trimIndent()

val int: Int = 10
// val longError: Long = int // No implicit conversion in Kotlin
val intToLong: Long = int.toLong()
val long: Long = 10L

val double: Double = 3.14
val double2 = 3.14
val double3 = 123.5e10

val float: Float = 10F
val float2: Float = 10f

val hex: Int = 0x0F
val binary: Int = 0b00001011

// Make it readable:
val oneMillion = 1_000_000
val creditCardNumber = 1234_5678_9012_3456L
val socialSecurityNumber = 999_99_9999L
val hexBytes = 0xFF_EC_DE_5E
val bytes = 0b11010010_01101001_10010100_10010010


// String interpolation:
val score = 100
// println("Your score is $score")

val activities = 15
val points = 3
// println("The total is ${activities * 3}")

// Labels in loops
val list1 = listOf("Hello", "there!")
val list2 = listOf("See", "ya!")

fun loops() {
    loop1@ for (e1 in list1) {
        for (e2 in list2) {
            if (e2 == "See") {
                break@loop1
            }
            println("$e2")
        }
        println("$e1")
    }
}

// Named imports:
// import com.franzueto.lab1.TextView as MyTextView
// val myTextView = MyTextView()

// Functions: Unlimited parametes
fun print(ints: List<Int>, vararg strings: String) {
    ints.forEach {
        val resultado = 1 + it
        strings.forEach { i ->
            println(i)
        }
    }
}

// Classes
// We declare "Properties, no "Fields"
// Mutable (var) or Immutable (val)

// Class Constructor:
class Customer(val id: Int, val nombre: String) {

    var email: String? = null
        get() = field?.uppercase()
        set(value) {
            field = value?.uppercase()
        }

    // Secondary constructor
    constructor(email: String): this(email=email, nombre="")

    constructor(email: String, nombre: String): this(id=0, nombre=nombre) {
        this.email = email
    }

    init {
        // First block to be executed
    }
}

// Visibility:

// Top level declarations
// public -> default. Accessible from anywhere
// private -> Accessible inside files declaration
// internal -> Accessible in the same module

// Class members
// private -> Accessible only by class members
// internal -> Accessible by any client in the module
// protected -> Like 'private' but also accesible from subclasses

// GO-TO ENUMS

// Enums:
enum class Priority(val value:Int) {
    ONE(1),
    TWO(2)
}

fun printPriorities() {
    for(priority in Priority.values()) {
        println(priority.value)
    }
}

// Enum with abstract
enum class Priority2(val value:Int) {
    ONE(1) {
        override fun text(): String {
            return value.toString()
        }
    },
    TWO(2) {
        override fun text(): String {
            return value.toString()
        }
    };

    abstract fun text(): String
}

fun test() {
    //Priority.ONE.
}

// Objects:
// Created without Classes
object Global { // This is a Singleton
    val PI: Double
    const val PI2: Double = 3.14 // 'const' Must be set at compile time

    // This can't be done if we use 'const'
    init {
        PI = 3.14
    }
}

// Inheritance
// By default all classes are 'final'. -> We need to use 'open' for inheritance
open class Shape
class Square : Shape()

// Abstract classes and Interfaces
abstract class Shape2 {
    // It can maintain states
    var value:Int = 0

    abstract fun area(): Int

    fun type(): String = "I'm a Shape!"
}

// Interfaces
interface Shape3 {
    // Cannot maintain states
    // var value:Int = 0 -> compile error

    // It can have properties
    val x: Int

    // It can have get/set
    val y: Int
        get() = 0

    fun area(): Int

    // You cannot use 'final'
    fun type(): String = "I'm a Shape!"
}

// Nullables
fun nullable(x: Int?) {
    println(x!!.compareTo(10)) // runtime error X.X
}

// Casting
//fun testTypes(typeTest: Int?) {
//    val x = typeTest?.let { value ->
//        val x = 1 + value
//    } ?: run {
//
//    }
//
//    if (typeTest is Boolean) {
//        // Smart casting
//        if (typeTest) {
//            println("It is true")
//        }
//    }
//
//    // If I'm sure it is a String at this point. Otherwise, we get an exception.
//    val str: String = typeTest as String
//
//    // Safe casting
//    val str2: String? = typeTest as? String
//}

// Exceptions
fun testExceptions(str: String) {
    try {
        println(str.toInt())
    } catch (exception: NumberFormatException) {
        exception.printStackTrace()
        println("Not a number $str")
    }
}

// Extensions
fun String.hello(): String {
    return "Hello World! This is your value $this"
}

fun testHello() {
    println("Franzueto".hello())


    val numbers = listOf(1, 2)

    numbers.mapIndexed({ index, value -> value * index })
}

// Lambdas
// High Order functions - https://kotlinlang.org/docs/lambdas.html#higher-order-functions
fun testLambdas(
    value1: Int,
    value2: Int,
    operation: (x: Int, y: Int) -> Int): Int {
    return operation(value1, value2)
}

fun testLambdaCall() {
    val sum = { x: Int, y: Int ->
        x + y
    }

    val result = testLambdas(1, 2, sum)
    println(result)

    // Lambda out of the parenthesis. Only if the lambda is the last element.
    val result2 = testLambdas(1, 2) { x, y ->
        x + y
    }
    println(result2)
}

//numbers.mapIndexed(
//    { index, value -> value * index
//    }
//)

fun operation(x: Int, y: Int): Int {
    return x + y
}

// Filtering and Transformations
// https://kotlinlang.org/docs/collection-filtering.html
// https://kotlinlang.org/docs/collection-transformations.html
fun testFiltering() {
    val numbers = listOf("one", "two", "three", "four")
    val longerThan3 = numbers.filter { it.length > 3 }
    println(longerThan3)
}

fun testTransformations() {
    val numbers = setOf(1, 2, 3)
    println(numbers.map { it * 3 })
    println(numbers.mapIndexed { idx, value -> value * idx })
}

// Kotlin standard library:
// Scope functions
// https://kotlinlang.org/docs/scope-functions.html
// let, run, with, apply, and also
class Person(val name: String, var age: Int, var country: String) {

    fun moveTo(country: String) {
        this.country = country
    }

    fun incrementAge() {
        age++
    }
}

//fun testScopeFunctions() {
//    val alice = Person("Alice", 20, "Amsterdam")
//    println(alice)
//    alice.moveTo("London")
//    alice.incrementAge()
//    println(alice)
//
//    Person("Bob", 20, "Amsterdam").run {
//        println(this)
//        moveTo("London")
//        incrementAge()
//        println(this)
//    }
//
//    with(bob) {
//        moveTo("")
//        incrementAge()
//    }
//}
//
//
//fun conditionalAssignment(any: Any) {
//    val result = if (boolean) "Verdadero" else "Falso"
//
//    val itemData: ItemData = when (any) {
//        is String -> {
//            ItemData(pos, value, "cadena", "L" + any.length)
//        }
//    }
//}

fun test4() {
    val list = listOf("")
    list.withIndex()

    list.filterNotNull()
}