package ru.ifmo.antll1.generator.testing

open class Node(val text: String) {
    val children = mutableListOf<Node>()
}

class StartRuleNode(text: String) : Node(text) {
    var result: String = ""
}

class PNode(text: String) : Node(text) {
    var value: Int = 7
}

class RNode(text: String) : Node(text) {
    var value: Int = 0
}

