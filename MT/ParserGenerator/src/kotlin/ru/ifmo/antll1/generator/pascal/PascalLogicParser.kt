package ru.ifmo.antll1.generator.pascal
import ru.ifmo.antll1.generator.pascal.Token.*

class PascalLogicParser {
    private lateinit var lexer: Lexer

    fun parse(input: String): Node {
        lexer = PascalLogicLexerImpl(input)
        return buildrule_s()
    }

    fun buildrule_s() : rule_sNode {
        var result = rule_sNode("rule_s")
        when(lexer.token()) {
            NOT, NAME, OP_B -> {
                var rule_e = buildrule_e()
                result.children.add(rule_e)
                var rule_s1 = buildrule_s1()
                result.children.add(rule_s1)
            }
            else -> {
                throw Exception("Unexpected token rule_s: ${lexer.tokenDescription()}")
            }
        }
        return result
    }
    fun buildrule_s1() : rule_s1Node {
        var result = rule_s1Node("rule_s1")
        when(lexer.token()) {
            OR -> {
                var or = Node(lexer.context())
                result.children.add(or)
                lexer.next()
                var rule_e = buildrule_e()
                result.children.add(rule_e)
                var rule_s1 = buildrule_s1()
                result.children.add(rule_s1)
            }
            END, CL_B -> {
                
            }
            else -> {
                throw Exception("Unexpected token rule_s1: ${lexer.tokenDescription()}")
            }
        }
        return result
    }
    fun buildrule_e() : rule_eNode {
        var result = rule_eNode("rule_e")
        when(lexer.token()) {
            NOT, NAME, OP_B -> {
                var rule_f = buildrule_f()
                result.children.add(rule_f)
                var rule_e1 = buildrule_e1()
                result.children.add(rule_e1)
            }
            else -> {
                throw Exception("Unexpected token rule_e: ${lexer.tokenDescription()}")
            }
        }
        return result
    }
    fun buildrule_e1() : rule_e1Node {
        var result = rule_e1Node("rule_e1")
        when(lexer.token()) {
            XOR -> {
                var xor = Node(lexer.context())
                result.children.add(xor)
                lexer.next()
                var rule_f = buildrule_f()
                result.children.add(rule_f)
                var rule_e1 = buildrule_e1()
                result.children.add(rule_e1)
            }
            OR, END, CL_B -> {
                
            }
            else -> {
                throw Exception("Unexpected token rule_e1: ${lexer.tokenDescription()}")
            }
        }
        return result
    }
    fun buildrule_f() : rule_fNode {
        var result = rule_fNode("rule_f")
        when(lexer.token()) {
            NOT, NAME, OP_B -> {
                var rule_n = buildrule_n()
                result.children.add(rule_n)
                var rule_f1 = buildrule_f1()
                result.children.add(rule_f1)
            }
            else -> {
                throw Exception("Unexpected token rule_f: ${lexer.tokenDescription()}")
            }
        }
        return result
    }
    fun buildrule_f1() : rule_f1Node {
        var result = rule_f1Node("rule_f1")
        when(lexer.token()) {
            AND -> {
                var and = Node(lexer.context())
                result.children.add(and)
                lexer.next()
                var rule_n = buildrule_n()
                result.children.add(rule_n)
                var rule_f1 = buildrule_f1()
                result.children.add(rule_f1)
            }
            XOR, OR, END, CL_B -> {
                
            }
            else -> {
                throw Exception("Unexpected token rule_f1: ${lexer.tokenDescription()}")
            }
        }
        return result
    }
    fun buildrule_n() : rule_nNode {
        var result = rule_nNode("rule_n")
        when(lexer.token()) {
            NOT -> {
                var not = Node(lexer.context())
                result.children.add(not)
                lexer.next()
                var rule_n = buildrule_n()
                result.children.add(rule_n)
            }
            NAME, OP_B -> {
                var rule_v = buildrule_v()
                result.children.add(rule_v)
            }
            else -> {
                throw Exception("Unexpected token rule_n: ${lexer.tokenDescription()}")
            }
        }
        return result
    }
    fun buildrule_v() : rule_vNode {
        var result = rule_vNode("rule_v")
        when(lexer.token()) {
            NAME -> {
                var name = Node(lexer.context())
                result.children.add(name)
                lexer.next()
            }
            OP_B -> {
                var op_b = Node(lexer.context())
                result.children.add(op_b)
                lexer.next()
                var rule_s = buildrule_s()
                result.children.add(rule_s)
                var cl_b = Node(lexer.context())
                result.children.add(cl_b)
                lexer.next()
            }
            else -> {
                throw Exception("Unexpected token rule_v: ${lexer.tokenDescription()}")
            }
        }
        return result
    }
}
