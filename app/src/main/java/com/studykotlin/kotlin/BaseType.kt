package com.studykotlin.kotlin

/**
 * 基础数据类型
 * Double(64)、 Float(32)、 Long(64)、 Int(32)、 Short(16)、 Byte(8)、
 */
class BaseType {
}

fun main(args: Array<String>) {
    val oneMillion = 1_000_000
    /*
    比较两个数字
    Kotlin 中没有基础数据类型，只有封装的数字类型，你每定义的一个变量，其实 Kotlin 帮你封装了一个对象，这样可以保证不会出现空指针。
    数字类型也一样，所以在比较两个数字的时候，就有比较数据大小和比较两个对象是否相同的区别了。
    在 Kotlin 中，三个等号 === 表示比较对象地址，两个 == 表示比较两个值大小。
     */
    val a: Int = 10000
    println(a === a) // true，值相等，对象地址相等

    //经过了装箱，创建了两个不同的对象
    val boxedA: Int? = a
    val anotherBoxedA: Int? = a

    //虽然经过了装箱，但是值是相等的，都是10000
    println(boxedA === anotherBoxedA) //  false，值相等，对象地址不一样
    println(boxedA == anotherBoxedA) // true，值相等

    /*
    位操作符
    对于Int和Long类型，还有一系列的位操作符可以使用，分别是：
    shl(bits) – 左移位 (Java’s <<)
    shr(bits) – 右移位 (Java’s >>)
    ushr(bits) – 无符号右移位 (Java’s >>>)
    and(bits) – 与
    or(bits) – 或
    xor(bits) – 异或
    inv() – 反向
     */
    /*
    字符
    和 Java 不一样，Kotlin 中的 Char 不能直接和数字操作，Char 必需是单引号 ' 包含起来的。比如普通字符 '0'，'a'。
     */
    /*
    数组
    数组用类 Array 实现，并且还有一个 size 属性及 get 和 set 方法，由于使用 [] 重载了 get 和 set 方法，所以我们可以通过下标很方便的获取或者设置数组对应位置的值。
    数组的创建两种方式：一种是使用函数arrayOf()；另外一种是使用工厂函数。如下所示，我们分别是两种方式创建了两个数组：
    注意: 与 Java 不同的是，Kotlin 中数组是不协变的（invariant）。
    除了类Array，还有ByteArray, ShortArray, IntArray，用来表示各个类型的数组，省去了装箱操作，因此效率更高，其用法同Array一样：
     */
    val array1 = arrayOf(1, 2, 3)
    val array2 = Array(3) { i -> (i * 2) }
    for (i in array2) {
        println(i)
    }

    /*
    字符串
    和 Java 一样，String 是不可变的。方括号 [] 语法可以很方便的获取字符串中的某个字符，也可以通过 for 循环来遍历：
     */
    val str = "Hello"
    for (c in str) {
        println(c)
    }

    /*
    Kotlin 支持三个引号 """ 扩起来的字符串，支持多行字符串，比如：
     */
    val text = """
    多行字符串
    多行字符串
    """
    println(text)   // 输出有一些前置空格
    /*
    String 可以通过 trimMargin() 方法来删除多余的空白。
     */
    val text2 = """
    |多行字符串
    |菜鸟教程
    |多行字符串
    |Runoob
    """.trimMargin()
    println(text2)    // 前置空格删除了

}