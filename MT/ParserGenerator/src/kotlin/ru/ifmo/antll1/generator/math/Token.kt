package ru.ifmo.antll1.generator.math

enum class Token(val title: String) {
    WS("[ \t\n\r]+"),
    NUMBER("[0-9]+"),
    PLUS("[+]"),
    MINUS("[-]"),
    POW("[*]{2}"),
    MUL("[*]"),
    L_SHIFT("<<"),
    R_SHIFT(">>"),
    OP_B("[(]"),
    CL_B("[)]"),
    END("end")
}
