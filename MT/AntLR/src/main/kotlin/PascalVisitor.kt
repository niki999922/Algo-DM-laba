import antlr.PascalGrammarBaseVisitor
import antlr.PascalGrammarParser

class PascalVisitor : PascalGrammarBaseVisitor<String>() {
    companion object {
        var funName = ""
    }

    override fun visitProgram(ctx: PascalGrammarParser.ProgramContext): String {
        return "${visit(ctx.getChild(0))}\n" +
                visit(ctx.getChild(1))
    }

    override fun visitProgramName(ctx: PascalGrammarParser.ProgramNameContext) =
        "#include <stdio.h>\n#include <stdbool.h>\n"

    override fun visitProgramContext(ctx: PascalGrammarParser.ProgramContextContext): String {
        val sb = StringBuilder()
        for (i in 0 until ctx.children.size - 1) {
            sb.append("${visit(ctx.getChild(i))}\n")
        }
        sb.append("int main() {")
        sb.append(visit(ctx.getChild(ctx.children.size - 1)))
        sb.append("\nreturn 0;\n}")
        return sb.toString()
    }

    override fun visitConstContext(ctx: PascalGrammarParser.ConstContextContext): String {
        val sb = StringBuilder()
        for (i in 1 until ctx.children.size) {
            sb.append("${visit(ctx.getChild(i))}\n")
        }
        return sb.toString()
    }

    override fun visitConstant(ctx: PascalGrammarParser.ConstantContext): String {
        return "const ${visit(ctx.getChild(2))} ${ctx.getChild(0).text} = ${if (visit(ctx.getChild(4))[0] != '\'') visit(
            ctx.getChild(4)
        ) else "\"" + visit(ctx.getChild(4)).substring(1, visit(ctx.getChild(4)).length - 1) + "\""};"
    }

    override fun visitConstantValue(ctx: PascalGrammarParser.ConstantValueContext): String {
        return ctx.getChild(0).text
    }

    override fun visitVarContext(ctx: PascalGrammarParser.VarContextContext): String {
        return visit(ctx.getChild(1))
    }

    override fun visitVariable(ctx: PascalGrammarParser.VariableContext): String {
        val sb = StringBuilder()
        for (i in 0 until ctx.children.size) {
            sb.append("${visit(ctx.getChild(i))}\n")
        }
        return sb.toString()
    }

    override fun visitVariableRow(ctx: PascalGrammarParser.VariableRowContext): String {
        return "${visit(ctx.getChild(2))} ${visit(ctx.getChild(0))};"
    }

    override fun visitFunctionProcedureContext(ctx: PascalGrammarParser.FunctionProcedureContextContext): String {
        val sb = StringBuilder()
        sb.append("${visit(ctx.getChild(0))} {\n")
        if (ctx.getChild(1) is PascalGrammarParser.VarContextContext) {
            sb.append(visit(ctx.getChild(1)))
            sb.append("${visit(ctx.getChild(2))}\n")
        } else {
            sb.append("${visit(ctx.getChild(1))}\n")
        }
        sb.append("}\n")
        return sb.toString()
    }

    override fun visitFunctionHeader(ctx: PascalGrammarParser.FunctionHeaderContext): String {
        funName = ctx.getChild(1).text
        return "${visit(ctx.getChild(6))} ${ctx.getChild(1).text}(${visit(ctx.getChild(3))})"
    }

    override fun visitProcedureHeader(ctx: PascalGrammarParser.ProcedureHeaderContext): String {
        return "void ${ctx.getChild(1).text}(${visit(ctx.getChild(3))})"
    }

    override fun visitArguments(ctx: PascalGrammarParser.ArgumentsContext): String {
        if (ctx.children == null || ctx.children.size == 0) {
            return ""
        }
        val result = StringBuilder()
        var i = 0
        while (i < ctx.children.size) {
            val type = visit(ctx.getChild(i + 2))
            val names = ctx.getChild(i).text.split(",")
            result.append(type)
            result.append(" ")
            result.append(names[0])
            for (j in 1 until names.size) {
                result.append(", ").append(type).append(" ").append(names[j])
            }
            if (i + 4 < ctx.children.size) {
                result.append(", ")
            }
            i += 4
        }
        return result.toString()
    }

    override fun visitMain(ctx: PascalGrammarParser.MainContext): String {
        return "${visit(ctx.getChild(1))}"
    }

    override fun visitContextMain(ctx: PascalGrammarParser.ContextMainContext): String {
        val result = StringBuilder()
        if (ctx.children == null) return ""
        if (ctx.children.size != 0) {
            result.append("\n${visit(ctx.getChild(0))}")
        }
        var i = 1
        while (i < ctx.children.size) {
            if (ctx.getChild(i).text != ";") result.append("\n${visit(ctx.getChild(i))}")
            i += 1
        }
        return result.toString()
    }

    override fun visitStatement(ctx: PascalGrammarParser.StatementContext): String {
        return visit(ctx.getChild(0))
    }

    override fun visitAssignmentStatement(ctx: PascalGrammarParser.AssignmentStatementContext): String {
        if (funName == visit(ctx.getChild(0))) {
            return "return ${visit(ctx.getChild(2))};"
        }
        return visit(ctx.getChild(0)) + " = " + visit(ctx.getChild(2)) + ";"
    }

    override fun visitExpression(ctx: PascalGrammarParser.ExpressionContext): String {
        val result = StringBuilder().append(visit(ctx.getChild(0)))
        for (i in 1 until ctx.children.size) {
            result.append(" ").append(visit(ctx.getChild(i)))
        }
        return result.toString()
    }

    override fun visitSimpleExpression(ctx: PascalGrammarParser.SimpleExpressionContext): String {
        val result: StringBuilder = StringBuilder().append(visit(ctx.getChild(0)))
        for (i in 1 until ctx.children.size) {
            result.append(" ").append(visit(ctx.getChild(i)))
        }
        return result.toString()
    }

    override fun visitTerm(ctx: PascalGrammarParser.TermContext): String {
        val result: StringBuilder = StringBuilder().append(visit(ctx.getChild(0)))
        for (i in 1 until ctx.children.size) {
            result.append(" ").append(visit(ctx.getChild(i)))
        }
        return result.toString()
    }

    override fun visitSignedFactor(ctx: PascalGrammarParser.SignedFactorContext): String {
        return if (ctx.children.size == 2) {
            ctx.getChild(0).toString() + visit(ctx.getChild(1))
        } else visit(ctx.getChild(0)).toString()
    }

    override fun visitFactor(ctx: PascalGrammarParser.FactorContext): String {
        if (ctx.children.size == 1) {
            return visit(ctx.getChild(0)).toString()
        }
        return if (ctx.children.size == 2) {
            "!" + visit(ctx.getChild(1))
        } else "(" + visit(ctx.getChild(1)).toString() + ")"
    }

    override fun visitBool(ctx: PascalGrammarParser.BoolContext): String {
        return if (ctx.text.equals(("true"), ignoreCase = true)) {
            "true"
        } else "false"
    }

    override fun visitUnsignedConstant(ctx: PascalGrammarParser.UnsignedConstantContext): String {
        return ctx.text
    }

    override fun visitFunctionCall(ctx: PascalGrammarParser.FunctionCallContext): String {
        if (ctx.getChild(0).text.equals(("writeln"), ignoreCase = true)) {
            return "printf(\"%d\\n\", ${visit(ctx.getChild(2))});"
        } else {
            return "${ctx.getChild(0).text}(${visit(ctx.getChild(2))})"
        }
    }

    override fun visitParameterList(ctx: PascalGrammarParser.ParameterListContext): String {
        val result = StringBuilder(visit(ctx.getChild(0)))
        var i = 2
        while (i < ctx.children.size) {
            result.append(", ").append(visit(ctx.getChild(i)))
            i += 2
        }
        return result.toString()
    }

    override fun visitOperationPr1(ctx: PascalGrammarParser.OperationPr1Context): String {
        if (ctx.text.equals(("div"), ignoreCase = true)) {
            return "/"
        }
        if (ctx.text.equals(("mul"), ignoreCase = true)) {
            return "*"
        }
        if (ctx.text.equals(("mod"), ignoreCase = true)) {
            return "%"
        }
        return if (ctx.text.equals(("and"), ignoreCase = true)) {
            "&&"
        } else ctx.text
    }

    override fun visitOperationPr2(ctx: PascalGrammarParser.OperationPr2Context): String {
        return if (ctx.text.equals(("or"), ignoreCase = true)) {
            "||"
        } else ctx.text
    }

    override fun visitOperationPr3(ctx: PascalGrammarParser.OperationPr3Context): String {
        if (ctx.text.equals(("<>"), ignoreCase = true)) {
            return "!="
        }
        return if (ctx.text.equals(("="), ignoreCase = true)) {
            "=="
        } else ctx.text
    }

    override fun visitVarWrapper(ctx: PascalGrammarParser.VarWrapperContext): String {
        return ctx.text
    }

    override fun visitLogicCicleStatments(ctx: PascalGrammarParser.LogicCicleStatmentsContext): String {
        return visit(ctx.getChild(0))
    }

    override fun visitIfStatement(ctx: PascalGrammarParser.IfStatementContext): String {
        var result = StringBuilder("if (${visit(ctx.getChild(1))}) {")
        if (ctx.children.size == 4) {
            result.append("\n${visit(ctx.getChild(3))}\n}")
        }
        if (ctx.children.size == 6 && ctx.getChild(4).text == "else") {
            result.append("\n${visit(ctx.getChild(3))}\n} \nelse {\n${visit(ctx.getChild(5))}\n}")
        }
        if (ctx.children.size == 7 && ctx.getChild(3).text == "begin") {
            result.append("\n${visit(ctx.getChild(5))}\n} \n")
        }
        if (ctx.children.size == 9) {
            result.append("\n${visit(ctx.getChild(4))}\n} \nelse {\n${visit(ctx.getChild(5))}\n}")
        }
        return result.toString()
    }

    override fun visitCycleStatement(ctx: PascalGrammarParser.CycleStatementContext): String {
        return visit(ctx.getChild(0))
    }

    override fun visitWhileStatement(ctx: PascalGrammarParser.WhileStatementContext): String {
        val result = StringBuilder("while(${visit(ctx.getChild(2))}) {")
        if (ctx.childCount == 9) {
            result.append("\n${visit(ctx.getChild(6))}")
        } else {
            result.append("\n${visit(ctx.getChild(5))}")
        }

        return result.toString()
    }

    override fun visitForStatement(ctx: PascalGrammarParser.ForStatementContext): String {
        val result = StringBuilder(
            "for (int " + ctx.getChild(1).text.toString() + " = " + visit(ctx.getChild(3)).toString() + "; " +
                    ctx.getChild(1).text.toString() +
                    (if (ctx.getChild(4).text.equals(("to"), ignoreCase = true)) " < " else " > ") +
                    visit(ctx.getChild(5)).toString() + "; " + ctx.getChild(1).text.toString() +
                    (if (ctx.getChild(4).text.equals(("to"), ignoreCase = true)) "++" else "--").toString() +
                    ") {"
        )
        if (ctx.childCount == 8) {
            result.append("\n${visit(ctx.getChild(7))}")
        } else {
            result.append(visit(ctx.getChild(8)))
        }
        result.append("\n}")
        return result.toString()
    }

    override fun visitNamesList(ctx: PascalGrammarParser.NamesListContext): String {
        val result = StringBuilder(ctx.getChild(0).text)
        var i = 2
        while (i < ctx.children.size) {
            result.append(", ${ctx.getChild(i).text}")
            i += 2
        }
        return result.toString()
    }

    override fun visitType(ctx: PascalGrammarParser.TypeContext): String {
        val type: String = ctx.getChild(0).text
        if (type.equals("integer", ignoreCase = true)) {
            return "int"
        }
        if (type.equals("real", ignoreCase = true)) {
            return "double"
        }
        if (type.equals("boolean", ignoreCase = true)) {
            return "bool"
        }
        if (type.equals("string", ignoreCase = true)) {
            return "char *"
        }
        return if (type.equals("char", ignoreCase = true)) {
            "char"
        } else "Undefined Type"
    }
}