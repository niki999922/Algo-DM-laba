package ru.ifmo.antll1

data class Rule(val name: String) {
    val parameters = mutableListOf<Parameter>()
    lateinit var returnType: ReturnField
    val conditions = mutableListOf<Condition>()
}