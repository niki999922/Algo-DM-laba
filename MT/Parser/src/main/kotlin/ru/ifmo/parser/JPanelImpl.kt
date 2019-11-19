package ru.ifmo.parser

import ru.ifmo.parser.expression.ExpressionNode
import java.awt.Font
import java.awt.Graphics
import java.awt.Toolkit
import javax.swing.JPanel

class JPanelImpl(private var node: Node) : JPanel() {
    public override fun paintComponent(graphic: Graphics) {
        graphic.font = Font("TimesRoman", Font.PLAIN, ExpressionNode.SHRIFT)
        val screenSize = Toolkit.getDefaultToolkit().screenSize
        val width = screenSize.getWidth()
        val height = screenSize.getHeight()
        node.paint(graphic, 0, width.toInt(), 0, height.toInt())
//        node.paint(graphic, 0, 1200, 0, 1000)
    }
}