package ru.ifmo.antll1.generator.testing

import java.util.regex.Pattern

class GrammarFileLexerImpl(input: String) : AbstractLexer(input) {
    val input_tokens = mutableListOf<Pair<Token, Pattern>>()

    init {
        ignore = Pattern.compile("([ \t\n\r]+)|([ \t\n\r]+)")
        input_tokens.add(Token.TOKEN1 to Pattern.compile(Token.TOKEN1.title))
        input_tokens.add(Token.TOKEN2 to Pattern.compile(Token.TOKEN2.title))
        input_tokens.add(Token.TOKEN3 to Pattern.compile(Token.TOKEN3.title))
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
