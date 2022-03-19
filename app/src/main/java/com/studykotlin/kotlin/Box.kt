package com.studykotlin.kotlin

import java.util.*

class Box<T>(t: T) {
    var value = t
}

fun <T> doPrintln(content: T) {
    when (content) {
        is Int -> println("整型数字为 $content")
        is String -> println("字符串转换成大写: ${content.toUpperCase()}")
        else -> println("T 不是整型，也不是字符串")
    }
}

//泛型约束
fun <T: Comparable<T>> sort(list: List<T>) {
    Collections.sort(list)
}

/**
 * 声明处型变
 * 声明处的类型变异使用协变注解修饰符：in、out，消费者 in, 生产者 out。
 * 使用 out 使得一个类型参数协变，协变类型参数只能用作输出，可以作为返回值类型但是无法作为入参的类型：
 */
class Runoob<out A>(val a: A) {
    fun foo(): A {
        return a
    }
}

/**
 * in 使得一个类型参数逆变，逆变类型参数只能用作输入，可以作为入参的类型但是无法作为返回值的类型：
 */
// 定义一个支持逆变的类
class Runoob2<in A>(a: A) {
    fun foo(a: A) {

    }
}

fun main(args: Array<String>) {
    val boxInt: Box<Int> = Box<Int>(2)
    val boxString = Box("xxx") //编译器会进行类型推断
    println(boxInt.value)
    println(boxString.value)

    val age = 23
    val name = "ljz"
    val bool = true
    doPrintln(age)
    doPrintln(name)
    doPrintln(bool)

    var strCo: Runoob<String> = Runoob("a")
    var anyCo: Runoob<Any> = Runoob<Any>("b")
    println(strCo.foo())
    println(anyCo.foo())
}