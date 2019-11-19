package ru.ifmo.parser.expression

import org.junit.jupiter.api.Assertions
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

    @Test
    fun `одиночное число`() {
        parser.parse("1")
    }

    @Test
    fun `одиночное число в скобках`() {
        parser.parse("(1)")
    }

    @Test
    fun `отрицательное одиночное число`() {
        parser.parse("-1")
    }

    @Test
    fun `отрицательное одиночное число в скобках`() {
        parser.parse("(-1)")
    }

    @Test
    fun `унарный минус перед числом в скобах`() {
        parser.parse("-(1)")
    }

    @Test
    fun `сложение 2 чисел`() {
        parser.parse("3 + 3")
    }

    @Test
    fun `вычитание 2 чисел`() {
        parser.parse("3 - 3")
    }

    @Test
    fun `умножение 2 чисел`() {
        parser.parse("3 * 3")
    }

    @Test
    fun `сложение 3 чисел`() {
        parser.parse("3 + 3 + 3")
    }

    @Test
    fun `вычитание 3 чисел`() {
        parser.parse("3 - 3 - 3")
    }

    @Test
    fun `умножение 3 чисел`() {
        parser.parse("3 * 3 * 3")
    }

    @Test
    fun `чередование знаков *, +, -`() {
        parser.parse("3 * 3 - 3 + 3")
        parser.parse("3 - 3 * 3 + 3")
        parser.parse("3 - 3 + 3 * 3")
    }

    @Test
    fun `чередование знаков *, +, - + среднее число в (), тут не унарный минус`() {
        parser.parse("3 - (3 + 3) * 3")
    }

    @Test
    fun `чередование знаков *, +, - + среднее число в (), тут не унарный минус + число в сокбках отрицательное`() {
        parser.parse("3 - (-3 + 3) * 3")
        parser.parse("3 - (-3 * -3) * 3")
    }

    @Test
    fun `разные числа`() {
        parser.parse("15623 -793 * (27) * 11")
    }

    @Test
    fun `много скобок`() {
        parser.parse("(((((((((((((13+13)))))))))))))")
    }

    @Test
    fun `очень много скобок`() {
        parser.parse("(((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((7)))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))")
    }

    @Test
    fun `умножение отрицательных чисел`() {
        parser.parse("(-7)*(-7)")
    }

    @Test
    fun `сдвиг R`() {
        parser.parse("3>>3")
    }

    @Test
    fun `сдвиг L`() {
        parser.parse("3<<3")
    }

    @Test
    fun `сдвиг R и L`() {
        parser.parse("3>>3<<2")
    }

    @Test
    fun `сдвиг L и R`() {
        parser.parse("3<<3>>2")
    }

    @Test
    fun `голый -`() {
        try {
            parser.parse("-")
        } catch (e: Exception) {
            println(e.message)
            return
        }
        Assertions.fail<Exception>()
    }

    @Test
    fun `голый +`() {
        try {
            parser.parse("+")
        } catch (e: Exception) {
            println(e.message)
            return
        }
        Assertions.fail<Exception>()
    }

    @Test
    fun `голый *`() {
        try {
            parser.parse("*")
        } catch (e: Exception) {
            println(e.message)
            return
        }
        Assertions.fail<Exception>()
    }

    @Test
    fun `голый *-`() {
        try {
            parser.parse("*-")
        } catch (e: Exception) {
            println(e.message)
            return
        }
        Assertions.fail<Exception>()
    }

    @Test
    fun `непонятные символы`() {
        try {
            parser.parse("adsa ads")
        } catch (e: Exception) {
            println(e.message)
            return
        }
        Assertions.fail<Exception>()
    }

    @Test
    fun `число в буквах`() {
        try {
            parser.parse("a123dsa")
        } catch (e: Exception) {
            println(e.message)
            return
        }
        Assertions.fail<Exception>()
    }

    @Test
    fun `плюс унарный`() {
        try {
            parser.parse("+(3)")
        } catch (e: Exception) {
            println(e.message)
            return
        }
        Assertions.fail<Exception>()
    }

    @Test
    fun `много минусов у этого примера (бадумс)`() {
        try {
            parser.parse("---3")
        } catch (e: Exception) {
            println(e.message)
            return
        }
        Assertions.fail<Exception>()
    }

    @Test
    fun `много плюсов у этого примера (бадумс)`() {
        try {
            parser.parse("+++3")
        } catch (e: Exception) {
            println(e.message)
            return
        }
        Assertions.fail<Exception>()
    }

    @Test
    fun `пустые скобки`() {
        try {
            parser.parse("()")
        } catch (e: Exception) {
            println(e.message)
            return
        }
        Assertions.fail<Exception>()
    }

    @Test
    fun `много пустых скобок`() {
        try {
            parser.parse("()()()()()")
        } catch (e: Exception) {
            println(e.message)
            return
        }
        Assertions.fail<Exception>()
    }

    @Test
    fun `не ПСП`() {
        try {
            parser.parse("(((((((((()")
        } catch (e: Exception) {
            println(e.message)
            return
        }
        Assertions.fail<Exception>()
    }

    @Test
    fun `не сдвиг L`() {
        try {
            parser.parse("1<2")
        } catch (e: Exception) {
            println(e.message)
            return
        }
        Assertions.fail<Exception>()
    }

    @Test
    fun `не сдвиг R`() {
        try {
            parser.parse("1>2")
        } catch (e: Exception) {
            println(e.message)
            return
        }
        Assertions.fail<Exception>()
    }

}