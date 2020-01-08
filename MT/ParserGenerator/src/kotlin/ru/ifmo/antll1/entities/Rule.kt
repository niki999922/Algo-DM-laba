package ru.ifmo.antll1.entities

import ru.ifmo.antll1.entities.Condition
import ru.ifmo.antll1.entities.Parameter
import ru.ifmo.antll1.entities.ReturnField

data class Rule(val name: String) {
    val parameters = mutableListOf<Parameter>()
    lateinit var returnType: ReturnField
    val conditions = mutableListOf<Condition>()
}