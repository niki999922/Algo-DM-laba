package ru.ifmo.antll1.graph

import java.io.File

object MathPainter {
    private fun draw(name: String) {
        ProcessBuilder("dot", "-Tpng", "$name.dot")
            .redirectOutput(File("$name.png"))
            .redirectError(ProcessBuilder.Redirect.INHERIT)
            .start()
            .waitFor()
    }

    fun draw(tree: ru.ifmo.antll1.generator.math.Node, name: String = "Tree") {
        MathTreePrinter.printToFile(tree, name)
        draw(name)
    }
}

object PascalPainter {
    private fun draw(name: String) {
        ProcessBuilder("dot", "-Tpng", "$name.dot")
            .redirectOutput(File("$name.png"))
            .redirectError(ProcessBuilder.Redirect.INHERIT)
            .start()
            .waitFor()
    }

    fun draw(tree: ru.ifmo.antll1.generator.pascal.Node, name: String = "Tree") {
        PascalTreePrinter.printToFile(tree, name)
        draw(name)
    }
}