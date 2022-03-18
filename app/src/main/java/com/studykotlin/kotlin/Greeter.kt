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
        println("Hello $name")
    }
}

fun main(args: Array<String>) {    // 包级可见的函数，接受一个字符串数组作为参数
    Greeter("World").greet()

    println(sum2(1, 2))
    printSum(2, 3)

//    vars(1,2,3,4,5)

    println(sumLambda(1, 2))

    var age: String? = "23"
    val ages = age!!.toInt()
    println(ages)
    val ages1 = age?.toInt()
    println(ages1)
    val ages2 = age?.toInt() ?: -1

    testIn()
}

/**
 * 1、函数定义
 * Int 参数，返回值 Int
 */
fun sum(a: Int, b: Int): Int {
    return a + b
}
//表达式作为函数体，返回类型自动推断
fun sum2(a: Int, b: Int) = a + b
//如果是返回 Unit类型，则可以省略(对于public方法也是这样)：
fun printSum(a: Int, b: Int): Unit {
    println(a + b)
}

/**
 * 2、可变长参数函数
 * 函数的变长参数可用vararg关键字标识
 */
fun vars(vararg v: Int) {
    for (vt in v) {
        println(vt)
    }
}

/**
 * 3、lambda匿名函数
 */
val sumLambda: (Int, Int) -> Int = {x, y -> x + y}

/**
 * 4、类型检测及自动类型转换
 */
fun getStringLength(obj: Any): Int? {
    if (obj is String) {
        //做过类型判断后，obj会被系统自动转换成String类型
        return obj.length
    }
    // 这里的obj仍然是Any类型引用
    return null
}

fun getStringLength2(obj: Any): Int? {
    if (obj !is String) {
        return null
    }
    //在这个分支中， obj的类型会被自动转换成String
    return obj.length
}

/**
 * 区间
 * 区间表达式由具有操作符形式 .. 的 rangeTo 函数辅以 in 和 !in 形成。
 * 区间是为任何可比较类型定义的，但对于整型原生类型，它有一个优化的实现。以下是使用区间的一些示例:
 */
fun testIn() {
    for (i in 1..4) print(i)//输出1234
    for (i in 4..1) print(i)//什么都不输出
    val j = 8
    if (j in 1..10) { // 等同于 1 <= i && i <= 10
        println(j)
    }
    for (i in 1..4 step 2) println(i)
    for (i in 4 downTo 1 step 2) println(i)
    // 使用 until 函数排除结束元素
    for (i in 1 until 10) {   // i in [1, 10) 排除了 10
        println(i)
    }
}














