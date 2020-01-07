package ru.ifmo.antll1

class Grammar {
    public val headers = mutableListOf<String>()
    public val tokens = mutableListOf<Token>()
    public val rules = mutableListOf<Rule>()
    public val ignore = mutableListOf<Ignore>()

    lateinit var startRule: String
    lateinit var grammarName: String
}