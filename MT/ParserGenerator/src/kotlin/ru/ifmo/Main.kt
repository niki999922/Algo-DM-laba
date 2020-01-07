package ru.ifmo

//import antlr.PascalGrammarLexer
//import antlr.PascalGrammarParser
import org.antlr.v4.runtime.CharStream
import org.antlr.v4.runtime.CharStreams.fromFileName
import org.antlr.v4.runtime.CommonTokenStream
import ru.ifmo.antlr.InputGrammarParserLexer
import ru.ifmo.antlr.InputGrammarParserParser
import java.io.BufferedWriter
import java.io.File
import java.io.FileWriter


fun main() {
    println()
//    val fileName = "fileName"
//    val cs: CharStream = fromFileName("src/main/resources/pascal/Hello2.pas")
    val cs: CharStream = fromFileName("/Users/nikita/Algo-DM-laba/MT/ParserGenerator/src/resources/myAntlr/GrammarFile1.gll")
    val lexer2 = InputGrammarParserLexer(cs)
    val tokenStream2 = CommonTokenStream(lexer2)
    val parser2 = InputGrammarParserParser(tokenStream2)
    var r = parser2.grammarFile().grammar!!

    println(r.toString())
//    val myVisitor2 = PascalVisitor()
//    val translatedCode2 = myVisitor2.visit(parser2.program())!!
//    val writer = BufferedWriter(FileWriter("$fileName.c"))
//    writer.write(translatedCode2)
//    writer.close()
//    Runtime.getRuntime().exec("gcc $fileName.c -o $fileName.out")
//    File("$fileName.out").setExecutable(true)
}