package com.studykotlin.kotlin

enum class Color {
    RED, BLACK, BLUE, GREEN,WHITE
}

enum class BaseColor(val rgb: Int) {
    RED(0xFF0000),
    GREEN(0x00FF00),
    BLUE(0x0000FF)
}