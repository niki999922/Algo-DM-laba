package ru.ifmo.antll1.generator

import ru.ifmo.antll1.entities.TokenQ
import java.io.File
import java.util.*
import java.util.stream.Collectors

class LexerGenerator(
    private val packageName: String,
    private val grammarName: String
) {
    fun build(file: File, listTokens: List<TokenQ>) {
        val lexerFolder = file.resolve(packageName.split(".").stream().collect(Collectors.joining("/")))
        lexerFolder.mkdirs()
        buildLexerInterface(lexerFolder)
        buildAbstractLexer(lexerFolder)
        buildLexerInterfaceImpl(lexerFolder)
        buildTokenEnum(lexerFolder, listTokens)
    }

    fun buildLexerInterface(file: File) {
        val lexerInterfaceFile = file.resolve("Lexer.kt")
        lexerInterfaceFile.delete()
        lexerInterfaceFile.createNewFile()

        val textBuilder = TablerStringBuilder(delimiter = "\n")
        textBuilder
            .add(0, "package $packageName\n")
            .add(0, "interface Lexer {")
            .add(1, "fun next(): Token\n")
            .add(1, "fun token(): Token")
            .add(1, "fun context(): String")
            .add(0, "fun tokenDescription(): String")
            .add(0, "}")

        lexerInterfaceFile.writeText(textBuilder.toString())
    }

    fun buildAbstractLexer(file: File) {
        val lexerInterfaceImplFile = file.resolve("AbstractLexer.kt")
        lexerInterfaceImplFile.delete()
        lexerInterfaceImplFile.createNewFile()

        val textBuilder = TablerStringBuilder(delimiter = "\n")
        textBuilder.add(0, "package $packageName\n")

        //don't do this never!
        File("/Users/nikita/Algo-DM-laba/MT/ParserGenerator/src/kotlin/ru/ifmo/antll1/generator/lexer/abstractLexer").forEachLine { textBuilder.add(0, it) }

        lexerInterfaceImplFile.writeText(textBuilder.toString())
    }


    fun buildLexerInterfaceImpl(file: File) {
        val lexerInterfaceImplFile = file.resolve("${grammarName}LexerImpl.kt")
        lexerInterfaceImplFile.delete()
        lexerInterfaceImplFile.createNewFile()

        val textBuilder = TablerStringBuilder(delimiter = "\n")
        textBuilder.add(0, "package $packageName\n")
        textBuilder.add(0, "import java.text.ParseException\n")
        textBuilder.add(0, "class ${grammarName}Lexer(input: String) : AbstractLexer(input) {\n")
        textBuilder.add(1,"init {")
        textBuilder.add(2,"var token = processTokens()")
        textBuilder.add(2,"while (token != Token.END) {")
        textBuilder.add(3,"tokens.add(token to context)")
        textBuilder.add(3,"context = \"\"")
        textBuilder.add(3,"token = processTokens()")
        textBuilder.add(3,"tokenPosition++")
        textBuilder.add(2,"}")
        textBuilder.add(2,"tokens.add(Token.END to \"\")")
        textBuilder.add(2,"tokenPosition = 0")
        textBuilder.add(1,"}")

        //here processTokens



        textBuilder.add(0,"}")

        lexerInterfaceImplFile.writeText(textBuilder.toString())
    }

    fun buildTokenEnum(file: File, listTokens: List<TokenQ>) {
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

//        val size = listTokens.size
//        if (size > 1){
//            val subList = listTokens.subList(0, size - 1)
//            subList.forEach {token ->
//                textBuilder.add(1,"${token.name}(\"${token.regexp}\"),")
//            }
//            textBuilder.add(1,"${listTokens[size - 2].name}(\"${listTokens[size - 2].regexp}\")")
//        } else {
//            if (listTokens.size == 1) {
//                textBuilder.add(1,"${listTokens[0].name}(\"${listTokens[0].regexp}\")")
//            }
//        }

        tokenFile.writeText(textBuilder.toString())
    }

}