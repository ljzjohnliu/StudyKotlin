package com.studykotlin.kotlin

class TestObject {
    /**
     * 请注意，匿名对象可以用作只在本地和私有作用域中声明的类型。如果你使用匿名对象作为公有函数的返回类型或者用作公有属性的类型，
     * 那么该函数或属性的实际类型会是匿名对象声明的超类型，如果你没有声明任何超类型，就会是 Any。在匿名对象中添加的成员将无法访问。
     */
    private val adHoc = object {
        var x: Int = 0
        var y: Int = 0
    }

    // 私有函数，所以其返回类型是匿名对象类型
    private fun foo() = object {
        val x: String = "x"
    }

    // 公有函数，所以其返回类型是 Any
    fun publicFoo() = object {
        val x: String = "x"
    }

    fun bar() {
        print(adHoc.x + adHoc.y)
        val x1 = foo().x        // 没问题
//        val x2 = publicFoo().x  // 错误：未能解析的引用“x”
    }
}

class MyClass {
    companion object Factory {
        @JvmStatic
        val staticF: String = "I am static"
        //该伴生对象的成员可以通过类名作为限定符调用
        fun create(): MyClass = MyClass()
    }
}
//可以对半生对象扩展函数
fun MyClass.Factory.foo() {
    println("伴生对象的扩展函数")
}
//可以对伴生对象属性扩展
val MyClass.Factory.no: Int
    get() = 10

fun main(args: Array<String>) {
    val instance = MyClass.create()
    println("no:${MyClass.no}")
    MyClass.foo()
}