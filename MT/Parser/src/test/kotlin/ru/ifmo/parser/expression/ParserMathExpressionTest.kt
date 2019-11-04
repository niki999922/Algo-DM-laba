package ru.ifmo.parser.expression

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test


internal class ParserMathExpressionTest {
    private val parser = ParserMathExpression()

    @Test
    @DisplayName("Empty input")
    fun emptyInputTest() {
        assertEquals(ExpressionNode("S eps"), parser.parse(""))
    }
}