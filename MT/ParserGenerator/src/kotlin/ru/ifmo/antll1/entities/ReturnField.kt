package ru.ifmo.antll1.entities

data class ReturnField(val name: String, val type : String, var initInfo: String) {
    fun isEmpty() = name == "none" && type == "none"
}