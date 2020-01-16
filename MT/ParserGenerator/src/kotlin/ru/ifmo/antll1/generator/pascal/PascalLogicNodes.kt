package ru.ifmo.antll1.generator.pascal

open class Node(val text: String) {
    val children = mutableListOf<Node>()
}

class rule_sNode(text: String) : Node(text)

class rule_s1Node(text: String) : Node(text)

class rule_eNode(text: String) : Node(text)

class rule_e1Node(text: String) : Node(text)

class rule_fNode(text: String) : Node(text)

class rule_f1Node(text: String) : Node(text)

class rule_nNode(text: String) : Node(text)

class rule_vNode(text: String) : Node(text)

