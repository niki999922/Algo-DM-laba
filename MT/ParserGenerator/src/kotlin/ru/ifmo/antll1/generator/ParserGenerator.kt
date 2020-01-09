package ru.ifmo.antll1.generator

import ru.ifmo.antll1.entities.*
import ru.ifmo.antll1.entities.table.FFTable
import ru.ifmo.antll1.entities.table.LineTable
import ru.ifmo.antll1.entities.table.Table
import java.io.File
import java.util.stream.Collectors

class ParserGenerator(
    private val packageName: String,
    private val grammarName: String,
    private val rules: List<Rule>,
    private val tokensQ: List<TokenQ>,
    private val ignore: List<Ignore>,
    private val startRule: String,
    private val headers: CodeStep

) {
    private lateinit var table:Table

    init {
        val tokens = ((tokensQ.map { it.name }.toSet() - ignore.map { it.name }.toSet()) + "EPS").toList()
        val table = createTable(rules, tokens, startRule)
        table.buildFirst()
        table.buildFollow()
    }

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



    fun createTable(rules: List<Rule>, list: List<String>, startRule: String): Table {
        val table = Table(list, startRule)
        rules.forEach { rule ->
            val fftable = FFTable()
            table.rules[rule.name] = fftable
            rule.conditions.forEach { cond ->
                val lineT = LineTable()
                if (cond.steps.size == 1 && cond.steps[0].stepType == StepType.CODE) {
                    lineT.steps.add("EPS")
                } else {
                    cond.steps.filter { it.stepType == StepType.NON_CODE }.forEach {
                        lineT.steps.add((it as RuleTermStep).rightPart)
                    }
                }
                fftable.conditions.add(lineT)
            }
        }
        return table
    }
}