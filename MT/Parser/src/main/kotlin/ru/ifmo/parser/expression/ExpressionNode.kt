package ru.ifmo.parser.expression

import ru.ifmo.parser.Node
import java.awt.Graphics

data class ExpressionNode(private val node: String) : Node {
    override fun childs() = childs

    private val childs = mutableListOf<Node>()

    constructor(node: String, vararg nodes: Node) : this(node) {
        childs.addAll(nodes.toList())
    }

    override fun paint(graphic: Graphics, left: Int, right: Int, top: Int, bottom: Int) {
        graphic.drawString(node, (right + left) / 2, top + TOP + SHRIFT)
        if (childs.size != 0) {
            var delimiter = (right - left) / childs.size
            for ((tmp, child) in childs.withIndex()) {
                child.node().length
                graphic.drawLine(
                    (right + left) / 2,
                    top + TOP + SHRIFT + 10,
                    left + delimiter * tmp + delimiter / 2,
                    top + TOP * 2
                )
                child.paint(graphic, left + delimiter * tmp, left + delimiter * (tmp + 1), top + TOP, bottom)
            }
        }
    }

    override fun node(): String = node

    companion object {
        const val SHRIFT = 30
        const val TOP = 50
    }
}