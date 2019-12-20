import antlr.PascalGrammarLexer
import antlr.PascalGrammarParser
import org.antlr.v4.runtime.CharStream
import org.antlr.v4.runtime.CharStreams.fromFileName
import org.antlr.v4.runtime.CommonTokenStream
import java.io.BufferedWriter
import java.io.File
import java.io.FileWriter


fun main() {
    val fileName = "fileName"
    val cs: CharStream = fromFileName("src/main/resources/pascal/Hello2.pas")
    val lexer2 = PascalGrammarLexer(cs)
    val tokenStream2 = CommonTokenStream(lexer2)
    val parser2 = PascalGrammarParser(tokenStream2)
    val myVisitor2 = PascalVisitor()
    val translatedCode2 = myVisitor2.visit(parser2.program())!!
    val writer = BufferedWriter(FileWriter("$fileName.c"))
    writer.write(translatedCode2)
    writer.close()
    Runtime.getRuntime().exec("gcc $fileName.c -o $fileName.out")
    File("$fileName.out").setExecutable(true)
}