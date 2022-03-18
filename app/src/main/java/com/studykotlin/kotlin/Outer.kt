package com.studykotlin.kotlin

class Outer {
    private val bar: Int = 1
    var v = "成员属性"
    class Nested { //嵌套类
        fun foo() = 2
    }
    /** 嵌套内部类 **/
    inner class Inner {
        fun foo() = bar // 访问外部类成员
        fun innerTest() {
            var o = this@Outer //获取外部类的引用
            println("内部类可以引用外部类的成员， 例如：" + o.v)
        }
    }
}

interface  TestInterface {
    fun test()
}
class Test {
    var v = "成员属性"
    fun setInterface(test: TestInterface) {
        test.test()
    }
}

fun main(args: Array<String>) {
    val demo = Outer.Nested().foo() // 调用格式：外部类.嵌套类.嵌套类方法/属性
    println(demo)

    val inn = Outer().Inner()
    println(inn.foo())
    println(inn.innerTest())

    var test = Test()
    /*
    采用对象表达式来创建接口对象，即匿名内部类的实例
     */
    test.setInterface(object: TestInterface {
        override fun test() {
            println("对象表达式创建匿名内部类的实例")
        }
    })
}