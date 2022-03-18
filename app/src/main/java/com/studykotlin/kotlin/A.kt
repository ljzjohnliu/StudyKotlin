package com.studykotlin.kotlin

open class A {
    open val x: Int = 2
        get() { return field }

    open fun f() { println("A") }
    fun a() { println("a") }
}

interface B {
    fun f() { println("B") }//接口的成员变量默认是 open 的
    fun b() { println("b") }
}

class C() : A(), B {
    override val x: Int = 100

    override fun f() {
        super<A>.f()//调用A.f()
        super<B>.f()//调用B.f()
    }
}

fun main(args: Array<String>) {
    val c = C()
    c.f()
    println(c.x)
}