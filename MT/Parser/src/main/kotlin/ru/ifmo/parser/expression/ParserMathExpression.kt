package ru.ifmo.parser.expression

import ru.ifmo.parser.Node
import ru.ifmo.parser.Parse
import ru.ifmo.parser.expression.lexer.Lexer
import ru.ifmo.parser.expression.lexer.LexerMathExpression
import ru.ifmo.parser.expression.lexer.Token

/**
 * b (bad) = unary minus
 *
 * Grammar:
 * S-> eps
 * S -> E
 * E -> b(E)E1
 * E -> TE1
 * E1 -> +TE1
 * E1 -> -TE1
 * E1 -> eps
 * T -> FT1
 * T1 -> *FT1
 * T1 -> eps
 * F -> n
 * F -> (E)
 */
class ParserMathExpression : Parse {
    private lateinit var lexer: Lexer

    override fun parse(input: String): Node {
        lexer = LexerMathExpression(input)
        return buildS()
    }

    private fun buildS(): Node {
        return when (lexer.token()) {
            Token.NEGATIVE, Token.LPAREN, Token.CONST -> {
                // S -> E
                val e = buildE()
                ExpressionNode("S", e)
            }
            Token.END -> {
                ExpressionNode("S eps")
            }
            else -> {
                throw Exception("Unexpected token: ${lexer.tokenDescription()}")
            }
        }
    }

    private fun buildE(): Node {
        return when (lexer.token()) {
            Token.CONST, Token.LPAREN -> {
                //E -> TE1
                val t = buildT()
                val e1 = buildE1()
                ExpressionNode("E", t, e1)
            }
            Token.NEGATIVE -> {
                //E -> b(E)E1
                lexer.next()
                lexer.next()
                val e = buildE()
                lexer.next()
                val e1 = buildE1()
                ExpressionNode("E", ExpressionNode("-"), ExpressionNode("("), e, ExpressionNode(")"), e1)
            }
            else -> {
                throw Exception("Unexpected token: ${lexer.tokenDescription()}")
            }
        }
    }

    private fun buildE1(): Node {
        return when (lexer.token()) {
            Token.ADD -> {
                //E1 -> +TE1
                lexer.next()
                val t = buildT()
                val e1 = buildE1()
                ExpressionNode("E1", ExpressionNode("+"), t, e1)
            }
            Token.SUB -> {
                //E1 -> -TE1
                lexer.next()
                val t = buildT()
                val e1 = buildE1()
                ExpressionNode("E1", ExpressionNode("-"), t, e1)
            }
            Token.END, Token.RPAREN -> {
                //E1 -> eps
                ExpressionNode("E1 eps")
            }
            else -> {
                throw Exception("Unexpected token: ${lexer.tokenDescription()}")
            }
        }
    }

    private fun buildT(): Node {
        return when (lexer.token()) {
            Token.CONST, Token.LPAREN -> {
                //T -> FT1
                val f = buildF()
                val t1 = buildT1()
                ExpressionNode("T", f, t1)
            }
            else -> {
                throw Exception("Unexpected token: ${lexer.tokenDescription()}")
            }
        }
    }


    private fun buildT1(): Node {
        return when (lexer.token()) {
            Token.MUL -> {
                //T1 -> *FT1
                lexer.next()
                val f = buildF()
                val t1 = buildT1()
                ExpressionNode("T1", ExpressionNode("*"), f, t1)
            }
            Token.END, Token.RPAREN, Token.ADD, Token.SUB -> {
                //T1 -> eps
                ExpressionNode("T1 eps")
            }
            else -> {
                throw Exception("Unexpected token: ${lexer.tokenDescription()}")
            }
        }
    }

    private fun buildF(): Node {
        return when (lexer.token()) {
            Token.LPAREN -> {
                //F -> (E)
                lexer.next()
                val e = buildE()
                lexer.next()
                ExpressionNode("F", ExpressionNode("("), e, ExpressionNode(")"))
            }
            Token.CONST -> {
                //F -> n
                val context = lexer.context()
                lexer.next()
                ExpressionNode("F", ExpressionNode(context))
            }
            else -> {
                throw Exception("Unexpected token: ${lexer.tokenDescription()}")
            }
        }
    }
}