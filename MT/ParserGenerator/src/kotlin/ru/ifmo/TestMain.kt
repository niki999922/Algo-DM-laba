package ru.ifmo

import ru.ifmo.antll1.generator.pascal.PascalLogicParser
import ru.ifmo.antll1.graph.Painter

fun main() {
    val parser = PascalLogicParser()
    var flag = true
    val thread = Thread {
        val start = System.currentTimeMillis()
        while (flag) {
            Thread.currentThread().join(5)
            var time = System.currentTimeMillis() - start
            print("\r${time / 1000}.${time % 1000} seconds...")
        }
    }
    try {
        thread.start()
        // 3.3 sec
        val res = parser.parse(
            "(!a | b) & a & (a | !(b ^ c))"
        )
        Painter.draw(res, "Tree")
    } catch (e: Exception) {
        println(e.message)
        return
    } finally {
        flag = false
        thread.join()
    }
}