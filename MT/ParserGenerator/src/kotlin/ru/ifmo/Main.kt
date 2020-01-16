package ru.ifmo

import ru.ifmo.antll1.Antll1ParserGenerator
import java.nio.file.Paths

fun main() {
    Antll1ParserGenerator.generate(
//        Paths.get("/Users/nikita/Algo-DM-laba/MT/ParserGenerator/src/resources/myAntlr/PacalLogic.gll"),
        Paths.get("/Users/nikita/Algo-DM-laba/MT/ParserGenerator/src/resources/myAntlr/MathExpression.gll"),
        Paths.get("/Users/nikita/Algo-DM-laba/MT/ParserGenerator/src/kotlin"),
        "ru.ifmo.antll1.generator.math"
    )
}