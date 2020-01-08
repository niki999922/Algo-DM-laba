package ru.ifmo.antll1.generator

class TablerStringBuilder(private var content: String = "", private val delimiter:String = "") {
    operator fun plus(str: String): TablerStringBuilder {
        content += str + delimiter
        return this
    }

    fun add(tabs : Int, str: String): TablerStringBuilder {
        for (i in 0 until tabs) {
            content += TAB
        }
        content += str + delimiter
        return this
    }

    override fun toString() : String {
        return content
    }

    companion object {
        const val TAB = "    "
    }
}