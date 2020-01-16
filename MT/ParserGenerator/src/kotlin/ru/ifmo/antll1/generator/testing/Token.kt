package ru.ifmo.antll1.generator.testing

enum class Token(val title: String) {
    WS("[ \t\n\r]+"),
    WS2("[ \t\n\r]+"),
    TOKEN1("[1-9][0-9]*"),
    TOKEN2("[+]"),
    TOKEN3("[-]"),
    END("end")
}
