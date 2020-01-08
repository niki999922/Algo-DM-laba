package ru.ifmo.parser.expression.lexer

import java.text.ParseException

class LexerMathExpression(input: String) : AbstractLexer(input) {
    init {
        var token = processTokens()
        while (token != Token.END) {
            tokens.add(token to context)
            context = ""
            token = processTokens()
            tokenPosition++
        }
        tokens.add(Token.END to "")
        tokenPosition = 0
    }

    fun processTokens(): Token {
        skipWhiteSpace()
        if (currentPosition == input.length) {
            return Token.END
        }
        return when (currentChar) {
            '>' -> {
                currentPosition++
                if (currentChar != '>') {
                    throw ParseException("Illegal symbol $currentChar, expected \'>\':", currentPosition)
                }
                currentPosition++
                Token.R_SHIFT
            }
            '<' -> {
                currentPosition++
                if (currentChar != '<') {
                    throw ParseException("Illegal symbol $currentChar, expected \'<\':", currentPosition)
                }
                currentPosition++
                Token.L_SHIFT
            }
            '+' -> {
                currentPosition++
                Token.ADD
            }
            '-' -> {
                currentPosition++
                if (tokens.size != 0 && (currentToken == Token.CONST || currentToken == Token.RPAREN)) {
                    return Token.SUB
                }
                if (currentChar.isDigit()) {
                    var endString = currentPosition
                    while (endString < input.length && input[endString].isDigit()) {
                        endString++
                    }
                    context = input.substring(currentPosition - 1, endString)
                    currentPosition = endString

                    return Token.CONST
                }
                Token.NEGATIVE
            }
            '*' -> {
                currentPosition++
                Token.MUL
            }
            '(' -> {
                currentPosition++
                Token.LPAREN
            }
            ')' -> {
                currentPosition++
                Token.RPAREN
            }
            else -> {
                if (currentChar.isDigit()) {
                    var endString = currentPosition
                    while (endString < input.length && input[endString].isDigit()) {
                        endString++
                    }
                    context = input.substring(currentPosition, endString)
                    currentPosition = endString
                    return Token.CONST
                } else {
                    throw ParseException("Illegal symbol $currentChar", currentPosition)
                }
            }
        }
    }
}