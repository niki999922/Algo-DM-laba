package ru.ifmo.antll1.generator.pascal

import java.util.regex.Pattern

class PascalLogicLexerImpl(input: String) : AbstractLexer(input) {
    val input_tokens = mutableListOf<Pair<Token, Pattern>>()

    init {
        ignore = Pattern.compile("([ \t\n\r]+)")
        input_tokens.add(Token.NAME to Pattern.compile(Token.NAME.title))
        input_tokens.add(Token.OR to Pattern.compile(Token.OR.title))
        input_tokens.add(Token.XOR to Pattern.compile(Token.XOR.title))
        input_tokens.add(Token.AND to Pattern.compile(Token.AND.title))
        input_tokens.add(Token.NOT to Pattern.compile(Token.NOT.title))
        input_tokens.add(Token.OP_B to Pattern.compile(Token.OP_B.title))
        input_tokens.add(Token.CL_B to Pattern.compile(Token.CL_B.title))
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

    fun skipWhiteSpace() {
        matcher.usePattern(ignore);
        matcher.reset(input);
        while (matcher.lookingAt()) {
            input = input.substring(matcher.end());
            matcher.reset(input);
        }
    }

    fun processTokens(): Token {
        skipWhiteSpace()
        if (input.isEmpty()) {
            return Token.END
        }

        input_tokens.any { (itToken, pattern) ->
            matcher.usePattern(pattern)
            matcher.reset(input)
            if (matcher.lookingAt()) {
                context = input.substring(0, matcher.end())
                input = input.substring(context.length)
                return itToken
            }
            return@any false
        }

        throw Exception("Illegal symbol $input")
    }
}
