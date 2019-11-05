import antlr.PascalBaseListener
import antlr.PascalLexer
import antlr.PascalParser
import org.antlr.v4.runtime.CharStreams
import org.antlr.v4.runtime.CommonTokenStream
import org.antlr.v4.runtime.tree.ParseTreeWalker

fun main() {
    var lexer = PascalLexer(CharStreams.fromString("hello world"))
    val tokens = CommonTokenStream(lexer)
    val parser = PascalParser(tokens)
    val tree = parser.r()
    val walker = ParseTreeWalker()
    walker.walk(object : PascalBaseListener() {
        override fun enterR(ctx: PascalParser.RContext) {
            println("Entering R : " + ctx.ID().text)
        }

        override fun exitR(ctx: PascalParser.RContext) {
            println("Exiting R")
        }
    }, tree)
}