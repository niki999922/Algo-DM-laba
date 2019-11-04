package ru.ifmo.parser

import java.awt.Graphics

interface Node {
    fun node(): String
    fun paint(graphic: Graphics, left: Int, right: Int, top: Int, bottom: Int)
}