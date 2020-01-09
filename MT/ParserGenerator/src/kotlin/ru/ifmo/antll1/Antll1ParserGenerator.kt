package ru.ifmo.antll1

import org.antlr.v4.runtime.CharStream
import org.antlr.v4.runtime.CharStreams
import org.antlr.v4.runtime.CommonTokenStream
import ru.ifmo.antll1.grammar.parser.InputGrammarParserLexer
import ru.ifmo.antll1.grammar.parser.InputGrammarParserParser
import java.nio.file.Path

class Antll1ParserGenerator {
    companion object {
        fun generate(input: Path, output: Path, packageName:String = "") {
            println("Start parsing input grammar")
            val cs: CharStream = CharStreams.fromFileName(input.toAbsolutePath().toString())
            val lexer2 = InputGrammarParserLexer(cs)
            val tokenStream2 = CommonTokenStream(lexer2)
            val parser2 = InputGrammarParserParser(tokenStream2)
            var grammar = parser2.grammarFile().grammar!!
            println("Start generating Parser and Lexer")
            grammar.build(output, packageName)
        }
    }
}