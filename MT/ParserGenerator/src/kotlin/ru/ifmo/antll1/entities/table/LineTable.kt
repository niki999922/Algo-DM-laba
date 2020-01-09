package ru.ifmo.antll1.entities.table

import ru.ifmo.antll1.entities.TokenQ

class LineTable {
    val firstColumn = mutableListOf<String>()
    val followColumn = mutableListOf<String>()
    val steps = mutableListOf<String>()

    fun getTokens()= firstColumn.toSet()
}