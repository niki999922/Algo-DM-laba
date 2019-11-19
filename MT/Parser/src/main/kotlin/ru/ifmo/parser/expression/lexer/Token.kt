package ru.ifmo.parser.expression.lexer

enum class Token(val title: String) {
    ADD("+"),
    SUB("-"),
    NEGATIVE("-()"),
    MUL("*"),
    L_SHIFT("<<"),
    R_SHIFT(">>"),
    LPAREN("("),
    RPAREN(")"),
    CONST("number"),
    END("end")
}