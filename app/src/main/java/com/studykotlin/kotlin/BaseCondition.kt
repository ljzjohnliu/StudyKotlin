package com.studykotlin.kotlin

class BaseCondition {
}

class Person constructor(firstName: String) {
    /*
    主构造器
    主构造器中不能包含任何代码，初始化代码可以放在初始化代码段中，初始化代码段使用 init 关键字作为前缀。
     */
    init {
        println("FirstName is $firstName")
    }

    lateinit var name: String

    var lastName: String = "liu"
    get() = field.toUpperCase()
    set

    var no: Int = 100
        get() = field
        set(value) {
            if (value < 10) {
                field = value
            } else {
                field = -1
            }
        }

    var height: Float = 145.4f
        private set
}

fun main(args: Array<String>) {
    var x = 1
    when (x) {
        1 -> print("x == 1")
        2 -> print("x == 2")
        else -> {
            print("x 不是 1， 也不是2")
        }
    }
    println()
    when (x) {
        0, 1 -> print("x == 0 or x == 1")
        else -> print("otherwise")
    }
    println()
    x = 21
    when (x) {
        in 1..10 -> println("x is in the range")
        !in 10..20 -> println("x is outside the range")
        else -> {
            println("none of the above")
        }
    }

    var person: Person = Person("li")
    person.lastName = "wang"
    println("lastName:${person.lastName}")

    person.no = 9
    println("no:${person.no}")

    person.no = 20
    println("no:${person.no}")
}