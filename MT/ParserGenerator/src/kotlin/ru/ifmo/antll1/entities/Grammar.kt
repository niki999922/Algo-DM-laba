package ru.ifmo.antll1.entities

class Grammar {
    public val tokens = mutableListOf<TokenQ>()
    public val rules = mutableListOf<Rule>()
    public val ignore = mutableListOf<Ignore>()

    lateinit var headers : CodeStep
    lateinit var startRule: String
    lateinit var grammarName: String

    fun buildFirst() {

    }

}

fun generateOwnRules(): List<Rule> {
    val rules = mutableListOf<Rule>()
    val e = Rule("E")
    var c =Condition()
    c.steps.add(RuleTermStep("r","T"))
    c.steps.add(CodeStep("code code 1"))
    c.steps.add(RuleTermStep("","E1"))
    c.steps.add(CodeStep("code code 2"))
    e.conditions.add(c)
    rules.add(e)

    val e1 = Rule("E1")
    c =Condition()
    c.steps.add(RuleTermStep("","PLUS"))
    c.steps.add(RuleTermStep("","T"))
    c.steps.add(CodeStep("code code 3"))
    c.steps.add(RuleTermStep("","E1"))
    e1.conditions.add(c)

    c =Condition()
    c.steps.add(CodeStep(""))
    e1.conditions.add(c)
    rules.add(e1)

    val t = Rule("T")
    c =Condition()
    c.steps.add(RuleTermStep("","F"))
    c.steps.add(RuleTermStep("p","T1"))
    c.steps.add(CodeStep("code code 4"))
    t.conditions.add(c)
    rules.add(t)



    val t1 = Rule("T1")
    c =Condition()
    c.steps.add(RuleTermStep("","MUL"))
    c.steps.add(RuleTermStep("","F"))
    c.steps.add(RuleTermStep("","T1"))
    t1.conditions.add(c)

    c =Condition()
    c.steps.add(CodeStep(""))
    t1.conditions.add(c)
    rules.add(t1)


    val f = Rule("F")
    c =Condition()
    c.steps.add(RuleTermStep("","OP_B"))
    c.steps.add(RuleTermStep("","E"))
    c.steps.add(RuleTermStep("","CL_B"))
    f.conditions.add(c)

    c = Condition()
    c.steps.add(CodeStep("NUM"))
    f.conditions.add(c)
    rules.add(f)


    rules.add(Rule("E"))

    return rules
}

fun main() {
    val rules = generateOwnRules()

}