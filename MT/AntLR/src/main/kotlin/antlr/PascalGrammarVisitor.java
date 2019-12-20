// Generated from /Users/nikita/Algo-DM-laba/MT/AntLR/src/main/resources/antlr/PascalGrammar.g4 by ANTLR 4.7.2
package antlr;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link PascalGrammarParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 *            operations with no return type.
 */
public interface PascalGrammarVisitor<T> extends ParseTreeVisitor<T> {
    /**
     * Visit a parse tree produced by {@link PascalGrammarParser#program}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitProgram(PascalGrammarParser.ProgramContext ctx);

    /**
     * Visit a parse tree produced by {@link PascalGrammarParser#programName}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitProgramName(PascalGrammarParser.ProgramNameContext ctx);

    /**
     * Visit a parse tree produced by {@link PascalGrammarParser#programContext}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitProgramContext(PascalGrammarParser.ProgramContextContext ctx);

    /**
     * Visit a parse tree produced by {@link PascalGrammarParser#constContext}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitConstContext(PascalGrammarParser.ConstContextContext ctx);

    /**
     * Visit a parse tree produced by {@link PascalGrammarParser#constant}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitConstant(PascalGrammarParser.ConstantContext ctx);

    /**
     * Visit a parse tree produced by {@link PascalGrammarParser#constantValue}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitConstantValue(PascalGrammarParser.ConstantValueContext ctx);

    /**
     * Visit a parse tree produced by {@link PascalGrammarParser#varContext}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitVarContext(PascalGrammarParser.VarContextContext ctx);

    /**
     * Visit a parse tree produced by {@link PascalGrammarParser#variable}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitVariable(PascalGrammarParser.VariableContext ctx);

    /**
     * Visit a parse tree produced by {@link PascalGrammarParser#variableRow}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitVariableRow(PascalGrammarParser.VariableRowContext ctx);

    /**
     * Visit a parse tree produced by {@link PascalGrammarParser#functionProcedureContext}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitFunctionProcedureContext(PascalGrammarParser.FunctionProcedureContextContext ctx);

    /**
     * Visit a parse tree produced by {@link PascalGrammarParser#functionHeader}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitFunctionHeader(PascalGrammarParser.FunctionHeaderContext ctx);

    /**
     * Visit a parse tree produced by {@link PascalGrammarParser#procedureHeader}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitProcedureHeader(PascalGrammarParser.ProcedureHeaderContext ctx);

    /**
     * Visit a parse tree produced by {@link PascalGrammarParser#arguments}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitArguments(PascalGrammarParser.ArgumentsContext ctx);

    /**
     * Visit a parse tree produced by {@link PascalGrammarParser#main}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitMain(PascalGrammarParser.MainContext ctx);

    /**
     * Visit a parse tree produced by {@link PascalGrammarParser#contextMain}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitContextMain(PascalGrammarParser.ContextMainContext ctx);

    /**
     * Visit a parse tree produced by {@link PascalGrammarParser#statement}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitStatement(PascalGrammarParser.StatementContext ctx);

    /**
     * Visit a parse tree produced by {@link PascalGrammarParser#assignmentStatement}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitAssignmentStatement(PascalGrammarParser.AssignmentStatementContext ctx);

    /**
     * Visit a parse tree produced by {@link PascalGrammarParser#expression}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitExpression(PascalGrammarParser.ExpressionContext ctx);

    /**
     * Visit a parse tree produced by {@link PascalGrammarParser#simpleExpression}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitSimpleExpression(PascalGrammarParser.SimpleExpressionContext ctx);

    /**
     * Visit a parse tree produced by {@link PascalGrammarParser#term}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitTerm(PascalGrammarParser.TermContext ctx);

    /**
     * Visit a parse tree produced by {@link PascalGrammarParser#signedFactor}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitSignedFactor(PascalGrammarParser.SignedFactorContext ctx);

    /**
     * Visit a parse tree produced by {@link PascalGrammarParser#factor}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitFactor(PascalGrammarParser.FactorContext ctx);

    /**
     * Visit a parse tree produced by {@link PascalGrammarParser#bool}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitBool(PascalGrammarParser.BoolContext ctx);

    /**
     * Visit a parse tree produced by {@link PascalGrammarParser#unsignedConstant}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitUnsignedConstant(PascalGrammarParser.UnsignedConstantContext ctx);

    /**
     * Visit a parse tree produced by {@link PascalGrammarParser#functionCall}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitFunctionCall(PascalGrammarParser.FunctionCallContext ctx);

    /**
     * Visit a parse tree produced by {@link PascalGrammarParser#parameterList}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitParameterList(PascalGrammarParser.ParameterListContext ctx);

    /**
     * Visit a parse tree produced by {@link PascalGrammarParser#operationPr1}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitOperationPr1(PascalGrammarParser.OperationPr1Context ctx);

    /**
     * Visit a parse tree produced by {@link PascalGrammarParser#operationPr2}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitOperationPr2(PascalGrammarParser.OperationPr2Context ctx);

    /**
     * Visit a parse tree produced by {@link PascalGrammarParser#operationPr3}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitOperationPr3(PascalGrammarParser.OperationPr3Context ctx);

    /**
     * Visit a parse tree produced by {@link PascalGrammarParser#varWrapper}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitVarWrapper(PascalGrammarParser.VarWrapperContext ctx);

    /**
     * Visit a parse tree produced by {@link PascalGrammarParser#logicCicleStatments}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitLogicCicleStatments(PascalGrammarParser.LogicCicleStatmentsContext ctx);

    /**
     * Visit a parse tree produced by {@link PascalGrammarParser#ifStatement}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitIfStatement(PascalGrammarParser.IfStatementContext ctx);

    /**
     * Visit a parse tree produced by {@link PascalGrammarParser#cycleStatement}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitCycleStatement(PascalGrammarParser.CycleStatementContext ctx);

    /**
     * Visit a parse tree produced by {@link PascalGrammarParser#whileStatement}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitWhileStatement(PascalGrammarParser.WhileStatementContext ctx);

    /**
     * Visit a parse tree produced by {@link PascalGrammarParser#forStatement}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitForStatement(PascalGrammarParser.ForStatementContext ctx);

    /**
     * Visit a parse tree produced by {@link PascalGrammarParser#namesList}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitNamesList(PascalGrammarParser.NamesListContext ctx);

    /**
     * Visit a parse tree produced by {@link PascalGrammarParser#type}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitType(PascalGrammarParser.TypeContext ctx);
}