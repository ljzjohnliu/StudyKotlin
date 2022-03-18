package com.studykotlin.kotlin

/**
 * 为什么选择 Kotlin？
 * 简洁: 大大减少样板代码的数量。
 * 安全: 避免空指针异常等整个类的错误。
 * 互操作性: 充分利用 JVM、Android 和浏览器的现有库。
 * 工具友好: 可用任何 Java IDE 或者使用命令行构建。
 */
class Greeter(private val name: String) {
    fun greet() {
        print("Hello $name")
    }
}

fun main(args: Array<String>) {    // 包级可见的函数，接受一个字符串数组作为参数
    Greeter("World").greet()
}