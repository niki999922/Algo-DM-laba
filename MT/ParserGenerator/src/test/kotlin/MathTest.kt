import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import ru.ifmo.antll1.generator.math.MathExpressionParser
import ru.ifmo.antll1.generator.math.SNode

class MathTest {
    private val parser = MathExpressionParser()

    @Test
    fun test1(){
        var expression = "1 + 1"
        Assertions.assertEquals(2, (parser.parse(expression) as SNode).res)
    }

    @Test
    fun test2(){
        var expression = "2 * 7"
        Assertions.assertEquals(14, (parser.parse(expression) as SNode).res)
    }

    @Test
    fun test3(){
        var expression = "4 >> 1"
        Assertions.assertEquals(2, (parser.parse(expression) as SNode).res)
    }


    @Test
    fun test4(){
        var expression = "4 << 1"
        Assertions.assertEquals(8, (parser.parse(expression) as SNode).res)
    }


    @Test
    fun test5(){
        var expression = "4 - 1 - 1"
        Assertions.assertEquals(2, (parser.parse(expression) as SNode).res)
    }

    @Test
    fun test6(){
        var expression = "2*(4 - 1 - 1)"
        Assertions.assertEquals(4, (parser.parse(expression) as SNode).res)
    }


    @Test
    fun test7(){
        var expression = "28000-((3 << 3) + 17* 8-(13>>2 * 7)-4)+11000-27*48"
        Assertions.assertEquals(37548, (parser.parse(expression) as SNode).res)
    }


    @Test
    fun test8(){
        var expression = "((280+100-((3 << 3) + 17* 8-(13>>2 * 7)-4)+11000-27*48) - 28384)*14 "
        Assertions.assertEquals(-258384, (parser.parse(expression) as SNode).res)
    }


    @Test
    fun test9(){
        var expression = "((280+100-((3 << 3) + 17* 8-(13>>2 * 7)-4)+11000-27*48) - 28384)*14  >> 1 >> 1 >> 1 >> 1"
        Assertions.assertEquals(-16149, (parser.parse(expression) as SNode).res)
    }

    @Test
    fun test10(){
        var expression = "((((((((((((280+100-((3 << 3) + 17* 8-(13>>2 * 7)-4)+11000-27*48) - 28384)*14  >> 1 >> 1 >> 1 >> 1 >> 1)>>12) + 20<<2<<3>>4<<2<<5>>4+1) * (((13*4*4-2+3*5*4)>>4))* (((13*4*4-2+3*5*4)>>4)))-1-1-1-1-1-1-1-1-1-1-1-1-1-1-1-1-1-1-1-1-1-1-1-1))))))"
        Assertions.assertEquals(36840, (parser.parse(expression) as SNode).res)
    }

    @Test
    fun test11(){
        var expression = "2 ** 4"
        Assertions.assertEquals(16, (parser.parse(expression) as SNode).res)
    }

    @Test
    fun test12(){
        var expression = "2 ** 2 ** 3"
        Assertions.assertEquals(256, (parser.parse(expression) as SNode).res)
    }

}