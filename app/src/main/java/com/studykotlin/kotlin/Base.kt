package com.studykotlin.kotlin

open class Base(name: String)  {
    constructor(name: String, age: Int): this(name) {
        println("-------基类次级构造函数--------")
    }

    open fun study() {
        println("我毕业了！")
    }
}

class SubClass1(p: Int, s: String) : Base(s) {

}

class SubClass2 : Base {
    //如果子类没有主构造函数，则必须在每一个二级构造函数中用 super 关键字初始化基类，或者在代理另一个构造函数。初始化基类时，可以调用基类的不同构造方法。
    constructor(name: String, age: Int, score: Int) : super(name, age) {
        println("-------继承类次级构造函数----------")
        println("学生名：${name}")
        println("成绩：${score}")
    }

    override fun study() {
        println("我在读大学！")
    }
}

fun main(args: Array<String>) {
    var s = SubClass2("ljz", 18, 100)
    s.study()
}

open class Person1(open var name: String, var age: Int) {
    open var sex: String = "unknow"
    init {
        println("基类初始化")
    }
}
// 子类的主构造方法的 name 前边也加了 var，这是不允许的，会报'name' hides member of supertype and needs 'override' modifier
class Student(override var name: String, age: Int, var no: String, var score: Int) : Person1(name, age) {
    override var sex: String = "male"
}