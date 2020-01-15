package ru.ifmo.antll1.graph

import ru.ifmo.antll1.generator.math.*
import java.io.File

object MathTreePrinter {
    private fun isTokenNumber(node : ru.ifmo.antll1.generator.math.Node): Int {
        when (node) {
            is SNode -> {return 0}
            is HNode -> {return 0}
            is H1Node -> {return 0}
            is ENode -> {return 0}
            is E1Node -> {return 0}
            is TNode -> {return 0}
            is T1Node -> {return 0}
            is FNode -> {return 0}
        }
        try {
            var r = Integer.parseInt(node.text)
        } catch (e : Exception) {
            return 1
        }
        return 2
    }

    private fun getRes(node : ru.ifmo.antll1.generator.math.Node): Int {
        when (node) {
            is SNode -> {return node.res}
            is HNode -> {return node.res}
            is H1Node -> {return node.res}
            is ENode -> {return node.res}
            is E1Node -> {return node.res}
            is TNode -> {return node.res}
            is T1Node -> {return node.res}
            is FNode -> {return node.res}
        }
        return 0
    }

    private fun createIdLine(tree: ru.ifmo.antll1.generator.math.Node, id: Int): String = "$id " +
            "[label=\"${tree.text} res=${getRes(tree)}\" " +
            (if (tree.children.isEmpty()) { var r = ""; when (isTokenNumber(tree)) {
                0 -> {}
                1 -> {r = ", color=blue"}
                2 -> {r =", color=red"}
                else -> r =""
            } ;r} else "") +
            "];"

    private fun getId(tree: ru.ifmo.antll1.generator.math.Node) = System.identityHashCode(tree)

    private fun getChildrenLine(tree: ru.ifmo.antll1.generator.math.Node) = buildString {
        tree.children.forEach {
            append(getId(it))
            if (it != tree.children.last()) {
                append(", ")
            }
        }
    }

    private fun dfs(tree: ru.ifmo.antll1.generator.math.Node): String = buildString {
        val id = getId(tree)
        appendln(createIdLine(tree, id))
        appendln("$id -> {${getChildrenLine(tree)}};")
        tree.children.forEach {
            append(dfs(it))
        }
    }

    fun print(tree: ru.ifmo.antll1.generator.math.Node): String {
        return dfs(tree)
    }

    fun printToFile(tree: ru.ifmo.antll1.generator.math.Node, name: String = "Tree") {
        val file = File("$name.dot")
        file.createNewFile()
        file.writeText("digraph $name {${System.lineSeparator()}" +
                print(tree) +
                "${System.lineSeparator()}}"
        )
    }
}


object PascalTreePrinter {
    private fun createIdLine(tree: ru.ifmo.antll1.generator.pascal.Node, id: Int): String = "$id " +
            "[label=\"${tree.text}\"" +
            (if (tree.children.isEmpty()) ", color=red" else "") +
            "];"

    private fun getId(tree: ru.ifmo.antll1.generator.pascal.Node) = System.identityHashCode(tree)

    private fun getChildrenLine(tree: ru.ifmo.antll1.generator.pascal.Node) = buildString {
        tree.children.forEach {
            append(getId(it))
            if (it != tree.children.last()) {
                append(", ")
            }
        }
    }

    private fun dfs(tree: ru.ifmo.antll1.generator.pascal.Node): String = buildString {
        val id = getId(tree)
        appendln(createIdLine(tree, id))
        appendln("$id -> {${getChildrenLine(tree)}};")
        tree.children.forEach {
            append(dfs(it))
        }
    }

    fun print(tree: ru.ifmo.antll1.generator.pascal.Node): String {
        return dfs(tree)
    }

    fun printToFile(tree: ru.ifmo.antll1.generator.pascal.Node, name: String = "Tree") {
        val file = File("$name.dot")
        file.createNewFile()
        file.writeText("digraph $name {${System.lineSeparator()}" +
                print(tree) +
                "${System.lineSeparator()}}"
        )
    }
}