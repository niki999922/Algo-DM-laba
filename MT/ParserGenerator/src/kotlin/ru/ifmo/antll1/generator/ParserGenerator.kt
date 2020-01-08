package ru.ifmo.antll1.generator

import java.io.File
import java.util.stream.Collectors

class ParserGenerator(
    private val packageName: String,
    private val grammarName: String
) {
    fun build(file: File) {
        val parserFolder = file.resolve(packageName.split(".").stream().collect(Collectors.joining("/")))
        parserFolder.mkdirs()

        buildParserInterface(parserFolder)
        buildParserImpl(parserFolder)
    }

    private fun buildParserInterface(file: File) {
        val lexerInterfaceFile = file.resolve("Parser.kt")
        lexerInterfaceFile.delete()
        lexerInterfaceFile.createNewFile()

        val textBuilder = TablerStringBuilder(delimiter = "\n")



        lexerInterfaceFile.writeText(textBuilder.toString())
    }


    private fun buildParserImpl(file: File) {
        val lexerInterfaceFile = file.resolve("${grammarName}Parser.kt")
        lexerInterfaceFile.delete()
        lexerInterfaceFile.createNewFile()

        val textBuilder = TablerStringBuilder(delimiter = "\n")



        lexerInterfaceFile.writeText(textBuilder.toString())
    }

}