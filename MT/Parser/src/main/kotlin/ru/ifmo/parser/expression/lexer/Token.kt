package ru.ifmo.parser.expression.lexer

enum class Token(val title: String) {
    ADD("+"),
    SUB("-"),
    NEGATIVE("-()"),
    MUL("*"),
    LPAREN("("),
    RPAREN(")"),
    CONST("number"),
    END("end")
}