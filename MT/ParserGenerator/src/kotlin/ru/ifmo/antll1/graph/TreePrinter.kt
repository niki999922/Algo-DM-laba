package ru.ifmo.antll1.graph

import ru.ifmo.antll1.generator.pascal.*
import java.io.File

object TreePrinter {
    private fun createIdLine(tree: Node, id: Int): String = "$id " +
            "[label=\"${tree.text}\"" +
            (if (tree.children.isEmpty()) ", color=red" else "") +
            "];"

    private fun getId(tree: Node) = System.identityHashCode(tree)

    private fun getChildrenLine(tree: Node) = buildString {
        tree.children.forEach {
            append(getId(it))
            if (it != tree.children.last()) {
                append(", ")
            }
        }
    }

    private fun dfs(tree: Node): String = buildString {
        val id = getId(tree)
        appendln(createIdLine(tree, id))
        appendln("$id -> {${getChildrenLine(tree)}};")
        tree.children.forEach {
            append(dfs(it))
        }
    }

    fun print(tree: Node): String {
        return dfs(tree)
    }

    fun printToFile(tree: Node, name: String = "Tree") {
        val file = File("$name.dot")
        file.createNewFile()
        file.writeText("digraph $name {${System.lineSeparator()}" +
                print(tree) +
                "${System.lineSeparator()}}"
        )
    }
}