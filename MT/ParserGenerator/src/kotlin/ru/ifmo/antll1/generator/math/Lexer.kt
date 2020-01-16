package ru.ifmo.antll1.generator.math

interface Lexer {
    fun next(): Token
    fun token(): Token
    fun context(): String
    fun tokenDescription(): String
}
