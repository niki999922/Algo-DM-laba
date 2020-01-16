package ru.ifmo.antll1.generator.testing

interface Lexer {
    fun next(): Token
    fun token(): Token
    fun context(): String
    fun tokenDescription(): String
}
