package ru.ifmo

import ru.ifmo.parser.JPanelImpl
import ru.ifmo.parser.expression.ParserMathExpression
import ru.ifmo.parser.expression.lexer.Lexer
import ru.ifmo.parser.expression.lexer.LexerMathExpression
import ru.ifmo.parser.expression.lexer.Token
import javax.swing.JFrame

fun main() {
    val lexer: Lexer = LexerMathExpression("(1+2)*(-3*(7-4)+2)")
    println("${lexer.token()}   :   ${lexer.context()}")
    while (lexer.next() != Token.END) {
        println("${lexer.token()}   :   ${lexer.context()}")
    }
    val parser = ParserMathExpression()
    val res = parser.parse("(1+2)*(-3*(7-4)+2)")
    val jFrame = JFrame("Parse Tree")
    jFrame.setSize(1200, 1000)
    jFrame.defaultCloseOperation = JFrame.EXIT_ON_CLOSE
    jFrame.add(JPanelImpl(res))
    jFrame.isVisible = true
}

