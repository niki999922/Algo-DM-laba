package ru.ifmo.antll1.generator.math

open class Node(val text: String) {
    val children = mutableListOf<Node>()
}

class SNode(text: String) : Node(text) {
    var res: Int = 0
}

class HNode(text: String) : Node(text) {
    var res: Int = 0
}

class H1Node(text: String) : Node(text) {
    var res: Int = 0
}

class ENode(text: String) : Node(text) {
    var res: Int = 0
}

class E1Node(text: String) : Node(text) {
    var res: Int = 0
}

class TNode(text: String) : Node(text) {
    var res: Int = 0
}

class T1Node(text: String) : Node(text) {
    var res: Int = 0
}

class LNode(text: String) : Node(text) {
    var res: Int = 0
}

class L1Node(text: String) : Node(text) {
    var res: Int = 0
}

class FNode(text: String) : Node(text) {
    var res: Int = 0
}

