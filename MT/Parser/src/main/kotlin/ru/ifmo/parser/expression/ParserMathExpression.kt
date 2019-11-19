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
 * S -> H
 * H -> EH1
 * H1 -> <<EH1
 * H1 -> >>EH1
 * H1 -> eps
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
                val e = buildH()
                ExpressionNode("S", e)
            }
            Token.END -> {
                ExpressionNode("S eps")
            }
            else -> {
                throw Exception("Unexpected token S: ${lexer.tokenDescription()}")
            }
        }
    }

    private fun buildH(): Node {
        return when (lexer.token()) {
            Token.CONST, Token.LPAREN, Token.NEGATIVE -> {
                //H -> EH1
                val e = buildE()
                val h1 = buildH1()
                ExpressionNode("H", e, h1)
            }
            else -> {
                throw Exception("Unexpected token H: ${lexer.tokenDescription()}")
            }
        }
    }

    private fun buildH1(): Node {
        return when (lexer.token()) {
            Token.L_SHIFT -> {
                //H1 -> <<EH1
                lexer.next()
                val e = buildE()
                val h1 = buildH1()
                ExpressionNode("H1", ExpressionNode("<<"), e, h1)
            }
            Token.R_SHIFT -> {
                //H1 -> >>EH1
                lexer.next()
                val e = buildE()
                val h1 = buildH1()
                ExpressionNode("H1", ExpressionNode(">>"), e, h1)
            }
            Token.END, Token.RPAREN -> {
                //E1 -> eps
                ExpressionNode("H1 eps")
            }
            else -> {
                throw Exception("Unexpected token H1: ${lexer.tokenDescription()}")
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
                throw Exception("Unexpected token E: ${lexer.tokenDescription()}")
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
            Token.END, Token.RPAREN, Token.L_SHIFT, Token.R_SHIFT -> {
                //E1 -> eps
                ExpressionNode("E1 eps")
            }
            else -> {
                throw Exception("Unexpected token E1: ${lexer.tokenDescription()}")
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
                throw Exception("Unexpected token T: ${lexer.tokenDescription()}")
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
            Token.END, Token.RPAREN, Token.ADD, Token.SUB, Token.L_SHIFT, Token.R_SHIFT -> {
                //T1 -> eps
                ExpressionNode("T1 eps")
            }
            else -> {
                throw Exception("Unexpected token T1: ${lexer.tokenDescription()}")
            }
        }
    }

    private fun buildF(): Node {
        return when (lexer.token()) {
            Token.LPAREN -> {
                //F -> (H)
                lexer.next()
                val h = buildH()
                lexer.next()
                ExpressionNode("F", ExpressionNode("("), h, ExpressionNode(")"))
            }
            Token.CONST -> {
                //F -> n
                val context = lexer.context()
                lexer.next()
                ExpressionNode("F", ExpressionNode(context))
            }
            else -> {
                throw Exception("Unexpected token F: ${lexer.tokenDescription()}")
            }
        }
    }
}