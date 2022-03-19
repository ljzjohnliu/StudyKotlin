package com.studykotlin.kotlin

interface MyInterface {
    /*
    接口中的属性
    接口中的属性只能是抽象的，不允许初始化值，接口不会保存属性值，实现接口时，必须重写属性：
     */
    var name: String //name属性，抽象的
    fun bar() //未实现
    fun foo() { // 已实现
        //可选的方法体
        println("foo")
    }
}

class Child : MyInterface {
    override var name: String = "ljz"
    override fun bar() {
        println("bar")
    }
}

fun Child.test() {
    println("扩展函数 test！！")
}
//扩展函数 swap 调换不同位置的值
fun MutableList<Int>.swap(index1: Int, index2: Int) {
    val temp = this[index1] //this 对应该列表
    this[index1] = this[index2]
    this[index2] = temp
}

/**
 * 扩展函数是静态解析的
 * 扩展函数是静态解析的，并不是接收者类型的虚拟成员，在调用扩展函数时，具体被调用的的是哪一个函数，由调用函数的的对象表达式来决定的，而不是动态的类型决定的:
 */
open class CC {
    open fun foo() {
        println("CC 的成员函数")
    }
}
class DD : CC() {
    override fun foo() {
        println("DD 的成员函数")
    }
}
fun CC.foo() = "CC"
fun DD.foo() = "DD"
fun printFoo(c: CC) {
    println(c.foo())
}

/**
 * 扩展属性允许定义在类或者kotlin文件中，不允许定义在函数中。初始化属性因为属性没有后端字段（backing field），所以不允许被初始化，只能由显式提供的 getter/setter 定义。
 */
val DD.bbq: Int
    get() = 1

fun main(args: Array<String>) {
    /*
    如果foo有成员函数，那么优先执行成员函数这个时候呈现多态，打印的是DD
    如果foo只有扩展函数，这里打印的是CC 而非DD！！
     */
    printFoo(DD())
    val c = Child()
    c.foo()
    c.bar()
    println(c.name)
    c.test()

    val l = mutableListOf<Int>(1, 2, 3)
    l.swap(0,2)
    println(l.toString())
}