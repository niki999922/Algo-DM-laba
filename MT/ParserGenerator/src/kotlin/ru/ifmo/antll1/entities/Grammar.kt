package ru.ifmo.antll1.entities

class Grammar {
    public val tokens = mutableListOf<TokenQ>()
    public val rules = mutableListOf<Rule>()
    public val ignore = mutableListOf<Ignore>()

    lateinit var headers : CodeStep
    lateinit var startRule: String
    lateinit var grammarName: String
}