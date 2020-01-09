package ru.ifmo.antll1.entities

import ru.ifmo.antll1.entities.table.FFTable
import ru.ifmo.antll1.entities.table.LineTable
import ru.ifmo.antll1.entities.table.Table
import java.util.*
import kotlin.collections.ArrayList

class Grammar {
    public val tokens = mutableListOf<TokenQ>()
    public val rules = mutableListOf<Rule>()
    public val ignore = mutableListOf<Ignore>()

    lateinit var headers: CodeStep
    lateinit var startRule: String
    lateinit var grammarName: String

    fun build(,packageName: String = "") {

    }
}


fun generateOwnRules(): List<Rule> {
    val rules = LinkedList<Rule>()
    val e = Rule("E")
    var c = Condition()
    c.steps.add(RuleTermStep("r", "T"))
    c.steps.add(CodeStep("code code 1"))
    c.steps.add(RuleTermStep("", "E1"))
    c.steps.add(CodeStep("code code 2"))
    e.conditions.add(c)
    rules.add(e)

    val e1 = Rule("E1")
    c = Condition()
    c.steps.add(RuleTermStep("", "PLUS"))
    c.steps.add(RuleTermStep("", "T"))
    c.steps.add(CodeStep("code code 3"))
    c.steps.add(RuleTermStep("", "E1"))
    e1.conditions.add(c)

    c = Condition()
    c.steps.add(CodeStep(""))
    e1.conditions.add(c)
    rules.add(e1)

    val t = Rule("T")
    c = Condition()
    c.steps.add(RuleTermStep("", "F"))
    c.steps.add(RuleTermStep("p", "T1"))
    c.steps.add(CodeStep("code code 4"))
    t.conditions.add(c)
    rules.add(t)


    val t1 = Rule("T1")
    c = Condition()
    c.steps.add(RuleTermStep("", "MUL"))
    c.steps.add(RuleTermStep("", "F"))
    c.steps.add(RuleTermStep("", "T1"))
    t1.conditions.add(c)

    c = Condition()
    c.steps.add(CodeStep(""))
    t1.conditions.add(c)
    rules.add(t1)


    val f = Rule("F")
    c = Condition()
    c.steps.add(RuleTermStep("", "OP_B"))
    c.steps.add(RuleTermStep("", "E"))
    c.steps.add(RuleTermStep("", "CL_B"))
    f.conditions.add(c)

    c = Condition()
    c.steps.add(RuleTermStep("","NUM"))
    f.conditions.add(c)
    rules.add(f)

    return rules
}

fun generateOwnRules2(): List<Rule> {
    val rules = LinkedList<Rule>()
    val e = Rule("E")
    var c = Condition()
    c.steps.add(RuleTermStep("r", "T"))
    c.steps.add(CodeStep("code code 1"))
    c.steps.add(RuleTermStep("", "E1"))
    c.steps.add(CodeStep("code code 2"))
    e.conditions.add(c)
    rules.add(e)

    val e1 = Rule("E1")
    c = Condition()
    c.steps.add(RuleTermStep("", "PLUS"))
    c.steps.add(RuleTermStep("", "T1"))
    c.steps.add(RuleTermStep("", "E1"))
    c.steps.add(RuleTermStep("", "E1"))
    e1.conditions.add(c)

    c = Condition()
    c.steps.add(CodeStep(""))
    e1.conditions.add(c)
    rules.add(e1)

    val t = Rule("T")
    c = Condition()
    c.steps.add(RuleTermStep("", "F"))
    c.steps.add(RuleTermStep("p", "T1"))
    c.steps.add(CodeStep("code code 4"))
    t.conditions.add(c)
    rules.add(t)


    val t1 = Rule("T1")
    c = Condition()
    c.steps.add(RuleTermStep("", "MUL"))
    c.steps.add(RuleTermStep("", "F"))
    c.steps.add(RuleTermStep("", "T1"))
    t1.conditions.add(c)

    c = Condition()
    c.steps.add(CodeStep(""))
    t1.conditions.add(c)
    rules.add(t1)


    val f = Rule("F")
    c = Condition()
    c.steps.add(RuleTermStep("", "OP_B"))
    c.steps.add(RuleTermStep("", "E"))
    c.steps.add(RuleTermStep("", "CL_B"))
    f.conditions.add(c)

    c = Condition()
    c.steps.add(RuleTermStep("","NUM"))
    f.conditions.add(c)
    rules.add(f)

    return rules
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

fun main() {

    val rules = generateOwnRules2()
    val tokens = listOf("PLUS", "MUL", "NUM", "OP_B", "CL_B", "EPS") //need add EPS
    val table = createTable(rules, tokens, "E")
    table.buildFirst()
    table.buildFollow()
    println("")

}