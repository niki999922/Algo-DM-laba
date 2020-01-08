package ru.ifmo.parser.expression.lexer

abstract class AbstractLexer(protected var input: String) : Lexer {
    override fun context() = tokens[tokenPosition].second
    override fun token(): Token = currentToken

    protected val tokens = mutableListOf<Pair<Token, String>>()
    protected var currentPosition = 0
    protected var tokenPosition = 0
    protected var context = ""

    protected val currentChar: Char
        get() = input[currentPosition]

    protected val currentToken: Token
        get() = tokens[tokenPosition].first

    init {
        input = input.trim()
    }

    protected fun skipWhiteSpace() {
        if (currentPosition == input.length) return
        while (currentChar.isWhitespace()) {
            currentPosition++
        }
    }

    override fun next(): Token {
        tokenPosition++
        return currentToken
    }

    override fun tokenDescription() = "${currentToken.title} in $currentPosition position"

}