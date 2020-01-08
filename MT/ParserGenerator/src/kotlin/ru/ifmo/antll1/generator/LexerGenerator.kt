package ru.ifmo.antll1.generator

import ru.ifmo.antll1.entities.Ignore
import ru.ifmo.antll1.entities.TokenQ
import java.io.File
import java.util.stream.Collectors

class LexerGenerator(
    private val packageName: String,
    private val grammarName: String
) {
    fun build(file: File, listTokens: List<TokenQ>, ignore : List<Ignore>) {
        val lexerFolder = file.resolve(packageName.split(".").stream().collect(Collectors.joining("/")))
        lexerFolder.mkdirs()
        buildLexerInterface(lexerFolder)
        buildAbstractLexer(lexerFolder)

        val listWithoutIgnore = listTokens.filter { tokenQ ->
            !ignore.any { ign ->
                return@any tokenQ.name == ign.name
            }
        }
        val listIgnore = listTokens.filter { tokenQ ->
            ignore.any { ign ->
                return@any tokenQ.name == ign.name
            }
        }

        buildLexerInterfaceImpl(lexerFolder, listWithoutIgnore, listIgnore)


        buildTokenEnum(lexerFolder, listTokens)
    }

    private fun buildLexerInterface(file: File) {
        val lexerInterfaceFile = file.resolve("Lexer.kt")
        lexerInterfaceFile.delete()
        lexerInterfaceFile.createNewFile()

        val textBuilder = TablerStringBuilder(delimiter = "\n")
        textBuilder
            .add(0, "package $packageName\n")
            .add(0, "interface Lexer {")
            .add(1, "fun next(): Token")
            .add(1, "fun token(): Token")
            .add(1, "fun context(): String")
            .add(1, "fun tokenDescription(): String")
            .add(0, "}")

        lexerInterfaceFile.writeText(textBuilder.toString())
    }

    private fun buildAbstractLexer(file: File) {
        val lexerInterfaceImplFile = file.resolve("AbstractLexer.kt")
        lexerInterfaceImplFile.delete()
        lexerInterfaceImplFile.createNewFile()

        val textBuilder = TablerStringBuilder(delimiter = "\n")
        textBuilder.add(0, "package $packageName\n")

        //don't do this never!
        File("/Users/nikita/Algo-DM-laba/MT/ParserGenerator/src/kotlin/ru/ifmo/antll1/generator/lexer/abstractLexer").forEachLine { textBuilder.add(0, it) }

        lexerInterfaceImplFile.writeText(textBuilder.toString())
    }


    private fun buildLexerInterfaceImpl(file: File, listTokens: List<TokenQ>, listIgnore : List<TokenQ>) {
        val lexerInterfaceImplFile = file.resolve("${grammarName}LexerImpl.kt")
        lexerInterfaceImplFile.delete()
        lexerInterfaceImplFile.createNewFile()

        val textBuilder = TablerStringBuilder(delimiter = "\n")
        textBuilder.add(0, "package $packageName\n")
        textBuilder.add(0, "import java.util.regex.Pattern\n")
        textBuilder.add(0, "class ${grammarName}LexerImpl(input: String) : AbstractLexer(input) {")
        textBuilder.add(1, "val input_tokens = mutableListOf<Pair<Token, Pattern>>()\n")

        textBuilder.add(1,"init {")
        textBuilder.add(2,"ignore = Pattern.compile(\"${listIgnore.map {"(${it.regexp})"}.joinToString("|")}\")")
        listTokens.forEach {
            textBuilder.add(2,"input_tokens.add(Token.${it.name} to Pattern.compile(Token.${it.name}.title))")
        }
        textBuilder.add(2,"var token = processTokens()")
        textBuilder.add(2,"while (token != Token.END) {")
        textBuilder.add(3,"tokens.add(token to context)")
        textBuilder.add(3,"context = \"\"")
        textBuilder.add(3,"token = processTokens()")
        textBuilder.add(3,"tokenPosition++")
        textBuilder.add(2,"}")
        textBuilder.add(2,"tokens.add(Token.END to \"\")")
        textBuilder.add(2,"tokenPosition = 0")
        textBuilder.add(1,"}\n")

        textBuilder.add(1,"fun skipWhiteSpace() {")
        textBuilder.add(2,"matcher.usePattern(ignore);")
        textBuilder.add(2,"matcher.reset(input);")
        textBuilder.add(2,"while (matcher.lookingAt()) {")
        textBuilder.add(3,"input = input.substring(matcher.end());")
        textBuilder.add(3,"matcher.reset(input);")
        textBuilder.add(2,"}")
        textBuilder.add(1,"}\n")

        textBuilder.add(1,"fun processTokens(): Token {")
        textBuilder.add(2,"skipWhiteSpace()")
        textBuilder.add(2,"if (input.isEmpty()) {")
        textBuilder.add(3,"return Token.END")
        textBuilder.add(2,"}\n")
        textBuilder.add(2,"input_tokens.any { (itToken, pattern) ->")
        textBuilder.add(3,"matcher.usePattern(pattern)")
        textBuilder.add(3,"matcher.reset(input)")
        textBuilder.add(3,"if (matcher.lookingAt()) {")
        textBuilder.add(4,"context = input.substring(0, matcher.end())")
        textBuilder.add(4,"input = input.substring(context.length)")
        textBuilder.add(4,"return itToken")
        textBuilder.add(3,"}")
        textBuilder.add(3,"return@any false")
        textBuilder.add(2,"}\n")
        textBuilder.add(2,"throw Exception(\"Illegal symbol \$input\")")
        textBuilder.add(1,"}")


        textBuilder.add(0,"}")
        lexerInterfaceImplFile.writeText(textBuilder.toString())
    }

    private fun buildTokenEnum(file: File, listTokens: List<TokenQ>) {
        val tokenFile = file.resolve("Token.kt")
        tokenFile.delete()
        tokenFile.createNewFile()

        val textBuilder = TablerStringBuilder(delimiter = "\n")
        textBuilder.add(0, "package $packageName\n")
        textBuilder.add(0, "enum class Token(val title: String) {")
        listTokens.forEach { token ->
            textBuilder.add(1, "${token.name}(\"${token.regexp}\"),")
        }
        textBuilder.add(1, "END(\"end\")")
        textBuilder.add(0, "}")

        tokenFile.writeText(textBuilder.toString())
    }

}

fun main() {
    val generator =  LexerGenerator("ru.ifmo.antll1.generator.lexer","Test___")
    generator.build(
        File("/Users/nikita/Algo-DM-laba/MT/ParserGenerator/src/kotlin"),
        listOf(TokenQ("MINUS","[-]"),TokenQ("PLUS","[+]"),TokenQ("IGNOR","[ ]+")),
        listOf(Ignore("IGNOR"))
    )
}