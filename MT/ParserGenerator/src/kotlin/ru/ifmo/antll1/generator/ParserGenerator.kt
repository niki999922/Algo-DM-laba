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
    private var table: Table
    private var termTokens: Set<String>

    init {
        var tokens = ((tokensQ.map { it.name }.toSet() - ignore.map { it.name }.toSet()) + "EPS").toList()
        table = createTable(rules, tokens, startRule)
        println("Starting generating FIRST")
        table.buildFirst()
        println("Starting generating FOLLOW")
        table.buildFollow()
        termTokens = tokens.toSet()

    }

    fun build(file: File) {
        val parserFolder = file.resolve(packageName.split(".").stream().collect(Collectors.joining("/")))
        parserFolder.mkdirs()

        buildNodes(parserFolder)
        buildParser(parserFolder)
    }


    private fun buildParser(file: File) {
        val parserFile = file.resolve("${grammarName}Parser.kt")
        parserFile.delete()
        parserFile.createNewFile()

        val textBuilder = TablerStringBuilder(delimiter = "\n")
        if (!packageName.isBlank()) textBuilder.add(0, "package $packageName")


        if (!headers.code.isBlank()) textBuilder.add(0, headers.code.substring(1, headers.code.length - 1))


        textBuilder.add(0, "import $packageName.Token.*\n")

        textBuilder.add(0, "class ${grammarName}Parser {")


        textBuilder.add(1, "private lateinit var lexer: Lexer\n")
        textBuilder.add(1, "fun parse(input: String): Node {")
        textBuilder.add(2, "lexer = ${grammarName}LexerImpl(input)")
        textBuilder.add(2, "return build${startRule}()")
        textBuilder.add(1, "}\n")


        rules.forEach { rule ->
            var returnName = rule.returnType.name
            var params = rule.parameters.map { it.name + ": " + it.type }.joinToString(", ")
            textBuilder.add(1, "fun build${rule.name}($params) : ${rule.name}Node {")
            textBuilder.add(2, "var result = ${rule.name}Node(\"${rule.name}\")")
            textBuilder.add(2, "when(lexer.token()) {")

            for (i in 0 until rule.conditions.size) {
                if (table.rules[rule.name]!!.conditions[i].getTokens().contains("EPS")) {
                    continue
                }

                textBuilder.add(3, "${table.rules[rule.name]!!.conditions[i].firstColumn.joinToString(", ")} -> {")
                rule.conditions[i].steps.forEach { step: Step ->
                    if (step.stepType == StepType.CODE) {
                        var code = (step as CodeStep).code
                        code.substring(1, code.length - 1).split(";").map { it.trim() }.map { if (it.startsWith(returnName)) "result.$it" else it }.forEach { textBuilder.add(4, it) }
//                            textBuilder.add(4, code)
                    } else {
                        var ruleTerm = (step as RuleTermStep)
                        var rightPartToken = ruleTerm.rightPart.substring(
                            0,
                            if (ruleTerm.rightPart.indexOf("(") != -1) ruleTerm.rightPart.indexOf("(") else ruleTerm.rightPart.length
                        )
                        if (!termTokens.contains(rightPartToken)) {
                            textBuilder.add(4, "var ${ruleTerm.leftPart} = build${ruleTerm.rightPart}")
                            textBuilder.add(4, "result.children.add(${ruleTerm.leftPart})")
                        } else {

//                                textBuilder.add(3,"var ${ruleTerm.leftPart} = Node(\"${ruleTerm.rightPart}\")")
                            textBuilder.add(4, "var ${ruleTerm.leftPart} = Node(lexer.context())")
                            textBuilder.add(4, "result.children.add(${ruleTerm.leftPart})")
                            textBuilder.add(4, "lexer.next()")
                        }
                    }
                }
//                    textBuilder.add(3,"break")
                textBuilder.add(3, "}")
            }
            if (table.rules[rule.name]!!.getTokens().contains("EPS")) {
                textBuilder.add(3, "${table.rules[rule.name]!!.followColumn.joinToString(", ")} -> {")
                rule.conditions[rule.conditions.size - 1].steps.forEach { step: Step ->
                    if (step.stepType == StepType.CODE) {
                        var code = (step as CodeStep).code
                        code.substring(1, code.length - 1).split(";").map { it.trim() }.map { if (it.startsWith(returnName)) "result.$it" else it }
                            .forEach { textBuilder.add(4, it) }
//                            textBuilder.add(4, code)
                    } else {
                        var ruleTerm = (step as RuleTermStep)
//                                textBuilder.add(3,"var ${ruleTerm.leftPart} = Node(\"${ruleTerm.rightPart}\")")
                        textBuilder.add(4, "var ${ruleTerm.leftPart} = Node(lexer.context())")
                        textBuilder.add(4, "result.children.add(${ruleTerm.leftPart})")
                        textBuilder.add(4, "lexer.next()")
                    }
                }
//                    textBuilder.add(3,"break")
                textBuilder.add(3, "}")
            }
            textBuilder.add(3, "else -> {")
            textBuilder.add(4, "throw Exception(\"Unexpected token ${rule.name}: \${lexer.tokenDescription()}\")")
            textBuilder.add(3, "}")

            textBuilder.add(2, "}")
            textBuilder.add(2, "return result")
            textBuilder.add(1, "}")


        }

        textBuilder.add(0, "}")

        parserFile.writeText(textBuilder.toString())
    }

    private fun buildNodes(file: File) {
        val parserFile = file.resolve("${grammarName}Nodes.kt")
        parserFile.delete()
        parserFile.createNewFile()

        val textBuilder = TablerStringBuilder(delimiter = "\n")
        if (!packageName.isBlank()) textBuilder.add(0, "package $packageName\n")

        textBuilder.add(0, "open class Node(val text: String) {")
        textBuilder.add(1, "val children = mutableListOf<Node>()")
        textBuilder.add(0, "}\n")

        rules.forEach { rule ->
            if (!rule.returnType.isEmpty()) {
                textBuilder.add(0, "class ${rule.name}Node(text: String) : Node(text) {")
                textBuilder.add(1, "var ${rule.returnType.name}: ${rule.returnType.type} ${rule.returnType.initInfo}")
                textBuilder.add(0, "}\n")
            } else {
                textBuilder.add(0, "class ${rule.name}Node(text: String) : Node(text)\n")
            }
        }
        parserFile.writeText(textBuilder.toString())
    }


    private fun createTable(rules: List<Rule>, list: List<String>, startRule: String): Table {
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
                        lineT.steps.add(clearRuleFromBrackets((it as RuleTermStep).rightPart))
                    }
                }
                fftable.conditions.add(lineT)
            }
        }
        return table
    }

    private fun clearRuleFromBrackets(input: String): String {
        return input.substring(0, if (input.indexOf("(") == -1) input.length else input.indexOf("("))
    }
}
