package ru.ifmo

import ru.ifmo.antll1.generator.math.MathExpressionParser
import ru.ifmo.antll1.generator.pascal.PascalLogicParser
import ru.ifmo.antll1.graph.*

fun main() {
//    pascal()
    math()
}

fun pascal() {
    val parser = PascalLogicParser()
    var flag = true
    val thread = Thread {
        val start = System.currentTimeMillis()
        while (flag) {
            Thread.currentThread().join(5)
            val time = System.currentTimeMillis() - start
            print("\r${time / 1000}.${time % 1000} seconds...")
        }
    }
    try {
        thread.start()
//         0.15 sec
        val res = parser.parse(
            "(!a | b) & a & (a | !(b ^ c))"
        )
        PascalPainter.draw(res, "TreePascal")
    } catch (e: Exception) {
        println(e.message)
        return
    } finally {
        flag = false
        thread.join()
    }
}


fun math() {
    val parser = MathExpressionParser()
    var flag = true
    val thread = Thread {
        val start = System.currentTimeMillis()
        while (flag) {
            Thread.currentThread().join(5)
            val time = System.currentTimeMillis() - start
            print("\r${time / 1000}.${time % 1000} seconds...")
        }
    }
    try {
        thread.start()
        // 0.15 sec
        val res = parser.parse(
            "(1<<2)*(3*(7-4)+2)"
        )
        MathPainter.draw(res, "TreeMath")

    } catch (e: Exception) {
        println(e.message)
        return
    } finally {
        flag = false
        thread.join()
    }
}