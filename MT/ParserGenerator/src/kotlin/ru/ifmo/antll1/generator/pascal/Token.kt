package ru.ifmo.antll1.generator.pascal

enum class Token(val title: String) {
    WS("[ \t\n\r]+"),
    NAME("[a-zA-Z]"),
    OR("[\\|]"),
    XOR("[\\^]"),
    AND("[\\&]"),
    NOT("[!]"),
    OP_B("[(]"),
    CL_B("[)]"),
    END("end")
}
