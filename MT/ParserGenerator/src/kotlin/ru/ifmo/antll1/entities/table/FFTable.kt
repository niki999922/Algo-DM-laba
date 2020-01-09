package ru.ifmo.antll1.entities.table

class FFTable {
    var conditions = mutableListOf<LineTable>()
    val followColumn = mutableListOf<String>()

    fun getTokens(): Set<String> {
        val set = mutableSetOf<String>()
        conditions.forEach {
            set += it.getTokens()
        }
        return set
    }

    fun getFollows() = followColumn.toSet()

}