package ru.ifmo.antll1.entities.table

import ru.ifmo.antll1.entities.TokenQ
import java.lang.Exception

class Table(val tokens: List<String>, val startRule: String) {
    val rules = mutableMapOf<String, FFTable>()

    fun buildFirst() {
        var changed = true
        while (changed) {
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
                        lineTable.firstColumn += dif
                    }
                }
            }
        }
    }

    fun buildFollow() {
        if (!rules.any { (name, fftable) ->
                if (name == startRule) {
                    fftable.followColumn.add("END")
                    return@any true
                }
                return@any false
            }
        ) {
            throw Exception("Can't find start rule \"${startRule}\"")
        }

        var changed = true
        while (changed) {
            changed = false
            rules.forEach { (_, fftable) ->
                fftable.conditions.forEach { lineTable ->
                    if (!(lineTable.steps.size == 1 && lineTable.steps[0] == "EPS")) {
                        for (ind in 0 until lineTable.steps.size) {
                            var step = lineTable.steps[ind]
                            if (tokens.contains(step)) {
                                continue
                            }
                            val setFromTerm = mutableSetOf<String>()
                            val localInd = ind + 1
                            setFromTerm += collectFirstForFollow(localInd, lineTable.steps.size, fftable, lineTable)

                            val diff = setFromTerm - rules[step]!!.getFollows()
                            if (diff.isNotEmpty()) {
                                changed = true
                                rules[step]!!.followColumn += diff
                            }
                        }
                    }
                }
            }
        }
    }

    private fun collectFirstForFollow(localInd: Int, sizeSteps: Int, fftable: FFTable, lineTable: LineTable): Set<String> {
        val setFromTerm = mutableSetOf<String>()

        if (localInd == sizeSteps) {
            setFromTerm += fftable.getFollows()
        } else {
            if (tokens.contains(lineTable.steps[localInd])) {
                setFromTerm += lineTable.steps[localInd]
            } else {
                var tokenLeftName: Set<String> = rules[lineTable.steps[localInd]]!!.getTokens()

                setFromTerm += (tokenLeftName - "EPS")
                if (tokenLeftName.contains("EPS")) {
                    setFromTerm += collectFirstForFollow(localInd + 1,sizeSteps,fftable,lineTable)
                }
            }
        }
        return setFromTerm
    }
}