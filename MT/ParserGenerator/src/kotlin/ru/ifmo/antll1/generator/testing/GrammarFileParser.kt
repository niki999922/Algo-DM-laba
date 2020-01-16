package ru.ifmo.antll1.generator.testing

import java.util.LinkedList;
import java.util.ArrayList;
import java.util.Collections;

import ru.ifmo.antll1.generator.testing.Token.*

class GrammarFileParser {
    private lateinit var lexer: Lexer

    fun parse(input: String): Node {
        lexer = GrammarFileLexerImpl(input)
        return buildStartRule()
    }

    fun buildStartRule() : StartRuleNode {
        var result = StartRuleNode("StartRule")
        when(lexer.token()) {
            TOKEN1 -> {
                var p = buildP()
                result.children.add(p)
                var rString = buildR(1, 2)
                result.children.add(rString)
                result.result = rString.value.toString()
                
            }
            END -> {
                
            }
            else -> {
                throw Exception("Unexpected token E: ${lexer.tokenDescription()}")
            }
        }
        return result
    }
    fun buildP() : PNode {
        var result = PNode("P")
        when(lexer.token()) {
            TOKEN1 -> {
                var token1 = Node(lexer.context())
                result.children.add(token1)
                lexer.next()
                var t2 = Node(lexer.context())
                result.children.add(t2)
                lexer.next()
                var l = 0
                var l2 = 8
                
                var ruler = buildR(l2, l)
                result.children.add(ruler)
                result.value = 7
                
            }
            TOKEN1 -> {
                var token1 = Node(lexer.context())
                result.children.add(token1)
                lexer.next()
                println("token 1")
                
                var token2 = Node(lexer.context())
                result.children.add(token2)
                lexer.next()
                println("token 1")
                result.value = 1
                
            }
            else -> {
                throw Exception("Unexpected token E: ${lexer.tokenDescription()}")
            }
        }
        return result
    }
    fun buildR(acc: Int, acc2: Int) : RNode {
        var result = RNode("R")
        when(lexer.token()) {
            TOKEN3 -> {
                var token3 = Node(lexer.context())
                result.children.add(token3)
                lexer.next()
                result.value = 13
                
            }
            END, TOKEN3 -> {
                var token3 = Node(lexer.context())
                result.children.add(token3)
                lexer.next()
                result.value = 13
                
            }
            else -> {
                throw Exception("Unexpected token E: ${lexer.tokenDescription()}")
            }
        }
        return result
    }
}
