package ru.ifmo.antll1.entities.table

import ru.ifmo.antll1.entities.TokenQ

class Table(tokens: List<String>) {
    val rules = mutableMapOf<String, FFTable>()

    fun buildFirst() {
        var changed = true
        while(changed) {
            changed = false
            rules.forEach { (_, fftable) ->
                fftable.conditions.forEach { lineTable ->
                    val setFromTerm = mutableSetOf<String>()
                    if (lineTable.steps.size == 1 && lineTable.steps[0] == "EPS") {
                        setFromTerm += "EPS"
                    } else {
                        val Ftoken = lineTable.steps[0]
                        if (rules.containsKey(Ftoken)) {
                            setFromTerm += rules[Ftoken]!!.getTokens()
                        } else {
                            setFromTerm += Ftoken
                        }
                    }
                    val dif = setFromTerm - lineTable.getTokens()
                    if (dif.isNotEmpty()) {
                        changed = true
                        lineTable.firstColumn += setFromTerm
                    }
                }
            }
        }
    }

    fun buildFollow
}