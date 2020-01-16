package ru.ifmo.antll1.generator.math
import ru.ifmo.antll1.generator.math.Token.*

class MathExpressionParser {
    private lateinit var lexer: Lexer

    fun parse(input: String): Node {
        lexer = MathExpressionLexerImpl(input)
        return buildS()
    }

    fun buildS() : SNode {
        var result = SNode("S")
        when(lexer.token()) {
            OP_B, MINUS, NUMBER -> {
                var h = buildH()
                result.children.add(h)
                result.res = h.res
                
            }
            END -> {
                result.res = 0
                
            }
            else -> {
                throw Exception("Unexpected token S: ${lexer.tokenDescription()}")
            }
        }
        return result
    }
    fun buildH() : HNode {
        var result = HNode("H")
        when(lexer.token()) {
            OP_B, MINUS, NUMBER -> {
                var e = buildE(0)
                result.children.add(e)
                var h1 = buildH1(e.res)
                result.children.add(h1)
                result.res = h1.res
                
            }
            else -> {
                throw Exception("Unexpected token H: ${lexer.tokenDescription()}")
            }
        }
        return result
    }
    fun buildH1(acc: Int) : H1Node {
        var result = H1Node("H1")
        when(lexer.token()) {
            L_SHIFT -> {
                var l_shift = Node(lexer.context())
                result.children.add(l_shift)
                lexer.next()
                var e = buildE(0)
                result.children.add(e)
                var h1 = buildH1(acc shl e.res)
                result.children.add(h1)
                result.res = h1.res
                
            }
            R_SHIFT -> {
                var r_shift = Node(lexer.context())
                result.children.add(r_shift)
                lexer.next()
                var e = buildE(0)
                result.children.add(e)
                var h1 = buildH1(acc shr e.res)
                result.children.add(h1)
                result.res = h1.res
                
            }
            END, CL_B -> {
                result.res = acc
                
            }
            else -> {
                throw Exception("Unexpected token H1: ${lexer.tokenDescription()}")
            }
        }
        return result
    }
    fun buildE(acc: Int) : ENode {
        var result = ENode("E")
        when(lexer.token()) {
            OP_B, MINUS, NUMBER -> {
                var t = buildT(0)
                result.children.add(t)
                var e1 = buildE1(t.res)
                result.children.add(e1)
                result.res = e1.res
                
            }
            else -> {
                throw Exception("Unexpected token E: ${lexer.tokenDescription()}")
            }
        }
        return result
    }
    fun buildE1(acc: Int) : E1Node {
        var result = E1Node("E1")
        when(lexer.token()) {
            PLUS -> {
                var plus = Node(lexer.context())
                result.children.add(plus)
                lexer.next()
                var t = buildT(0)
                result.children.add(t)
                var e1 = buildE1(acc + t.res)
                result.children.add(e1)
                result.res = e1.res
                
            }
            MINUS -> {
                var minus = Node(lexer.context())
                result.children.add(minus)
                lexer.next()
                var t = buildT(0)
                result.children.add(t)
                var e1 = buildE1(acc - t.res)
                result.children.add(e1)
                result.res = e1.res
                
            }
            L_SHIFT, R_SHIFT, END, CL_B -> {
                result.res = acc
                
            }
            else -> {
                throw Exception("Unexpected token E1: ${lexer.tokenDescription()}")
            }
        }
        return result
    }
    fun buildT(acc: Int) : TNode {
        var result = TNode("T")
        when(lexer.token()) {
            OP_B, MINUS, NUMBER -> {
                var l = buildL(0)
                result.children.add(l)
                var t1 = buildT1(l.res)
                result.children.add(t1)
                result.res = t1.res
                
            }
            else -> {
                throw Exception("Unexpected token T: ${lexer.tokenDescription()}")
            }
        }
        return result
    }
    fun buildT1(acc: Int) : T1Node {
        var result = T1Node("T1")
        when(lexer.token()) {
            MUL -> {
                var mul = Node(lexer.context())
                result.children.add(mul)
                lexer.next()
                var l = buildL(0)
                result.children.add(l)
                var t1 = buildT1(acc * l.res)
                result.children.add(t1)
                result.res = t1.res
                
            }
            PLUS, MINUS, L_SHIFT, R_SHIFT, END, CL_B -> {
                result.res = acc
                
            }
            else -> {
                throw Exception("Unexpected token T1: ${lexer.tokenDescription()}")
            }
        }
        return result
    }
    fun buildL(acc: Int) : LNode {
        var result = LNode("L")
        when(lexer.token()) {
            OP_B, MINUS, NUMBER -> {
                var f = buildF(0)
                result.children.add(f)
                var l1 = buildL1(f.res)
                result.children.add(l1)
                result.res = l1.res
                
            }
            else -> {
                throw Exception("Unexpected token L: ${lexer.tokenDescription()}")
            }
        }
        return result
    }
    fun buildL1(acc: Int) : L1Node {
        var result = L1Node("L1")
        when(lexer.token()) {
            POW -> {
                var pow = Node(lexer.context())
                result.children.add(pow)
                lexer.next()
                var f = buildF(0)
                result.children.add(f)
                var l1 = buildL1(f.res)
                result.children.add(l1)
                result.res = Math.pow(acc.toDouble(), l1.res.toDouble()).toInt()
                
            }
            MUL, PLUS, MINUS, L_SHIFT, R_SHIFT, END, CL_B -> {
                result.res = acc
                
            }
            else -> {
                throw Exception("Unexpected token L1: ${lexer.tokenDescription()}")
            }
        }
        return result
    }
    fun buildF(acc: Int) : FNode {
        var result = FNode("F")
        when(lexer.token()) {
            OP_B -> {
                var op_b = Node(lexer.context())
                result.children.add(op_b)
                lexer.next()
                var h = buildH()
                result.children.add(h)
                var cl_b = Node(lexer.context())
                result.children.add(cl_b)
                lexer.next()
                result.res = h.res
                
            }
            MINUS -> {
                var minus = Node(lexer.context())
                result.children.add(minus)
                lexer.next()
                var op_b = Node(lexer.context())
                result.children.add(op_b)
                lexer.next()
                var h = buildH()
                result.children.add(h)
                var cl_b = Node(lexer.context())
                result.children.add(cl_b)
                lexer.next()
                result.res = -h.res
                
            }
            MINUS -> {
                var minus = Node(lexer.context())
                result.children.add(minus)
                lexer.next()
                var number = Node(lexer.context())
                result.children.add(number)
                lexer.next()
                result.res = -Integer.parseInt(number.text)
                
            }
            NUMBER -> {
                var number = Node(lexer.context())
                result.children.add(number)
                lexer.next()
                result.res = Integer.parseInt(number.text)
                
            }
            else -> {
                throw Exception("Unexpected token F: ${lexer.tokenDescription()}")
            }
        }
        return result
    }
}
