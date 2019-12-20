// Generated from /Users/nikita/Algo-DM-laba/MT/AntLR/src/main/resources/antlr/PascalGrammar.g4 by ANTLR 4.7.2
package antlr;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link PascalGrammarParser}.
 */
public interface PascalGrammarListener extends ParseTreeListener {
    /**
     * Enter a parse tree produced by {@link PascalGrammarParser#program}.
     *
     * @param ctx the parse tree
     */
    void enterProgram(PascalGrammarParser.ProgramContext ctx);

    /**
     * Exit a parse tree produced by {@link PascalGrammarParser#program}.
     *
     * @param ctx the parse tree
     */
    void exitProgram(PascalGrammarParser.ProgramContext ctx);

    /**
     * Enter a parse tree produced by {@link PascalGrammarParser#programName}.
     *
     * @param ctx the parse tree
     */
    void enterProgramName(PascalGrammarParser.ProgramNameContext ctx);

    /**
     * Exit a parse tree produced by {@link PascalGrammarParser#programName}.
     *
     * @param ctx the parse tree
     */
    void exitProgramName(PascalGrammarParser.ProgramNameContext ctx);

    /**
     * Enter a parse tree produced by {@link PascalGrammarParser#programContext}.
     *
     * @param ctx the parse tree
     */
    void enterProgramContext(PascalGrammarParser.ProgramContextContext ctx);

    /**
     * Exit a parse tree produced by {@link PascalGrammarParser#programContext}.
     *
     * @param ctx the parse tree
     */
    void exitProgramContext(PascalGrammarParser.ProgramContextContext ctx);

    /**
     * Enter a parse tree produced by {@link PascalGrammarParser#constContext}.
     *
     * @param ctx the parse tree
     */
    void enterConstContext(PascalGrammarParser.ConstContextContext ctx);

    /**
     * Exit a parse tree produced by {@link PascalGrammarParser#constContext}.
     *
     * @param ctx the parse tree
     */
    void exitConstContext(PascalGrammarParser.ConstContextContext ctx);

    /**
     * Enter a parse tree produced by {@link PascalGrammarParser#constant}.
     *
     * @param ctx the parse tree
     */
    void enterConstant(PascalGrammarParser.ConstantContext ctx);

    /**
     * Exit a parse tree produced by {@link PascalGrammarParser#constant}.
     *
     * @param ctx the parse tree
     */
    void exitConstant(PascalGrammarParser.ConstantContext ctx);

    /**
     * Enter a parse tree produced by {@link PascalGrammarParser#constantValue}.
     *
     * @param ctx the parse tree
     */
    void enterConstantValue(PascalGrammarParser.ConstantValueContext ctx);

    /**
     * Exit a parse tree produced by {@link PascalGrammarParser#constantValue}.
     *
     * @param ctx the parse tree
     */
    void exitConstantValue(PascalGrammarParser.ConstantValueContext ctx);

    /**
     * Enter a parse tree produced by {@link PascalGrammarParser#varContext}.
     *
     * @param ctx the parse tree
     */
    void enterVarContext(PascalGrammarParser.VarContextContext ctx);

    /**
     * Exit a parse tree produced by {@link PascalGrammarParser#varContext}.
     *
     * @param ctx the parse tree
     */
    void exitVarContext(PascalGrammarParser.VarContextContext ctx);

    /**
     * Enter a parse tree produced by {@link PascalGrammarParser#variable}.
     *
     * @param ctx the parse tree
     */
    void enterVariable(PascalGrammarParser.VariableContext ctx);

    /**
     * Exit a parse tree produced by {@link PascalGrammarParser#variable}.
     *
     * @param ctx the parse tree
     */
    void exitVariable(PascalGrammarParser.VariableContext ctx);

    /**
     * Enter a parse tree produced by {@link PascalGrammarParser#variableRow}.
     *
     * @param ctx the parse tree
     */
    void enterVariableRow(PascalGrammarParser.VariableRowContext ctx);

    /**
     * Exit a parse tree produced by {@link PascalGrammarParser#variableRow}.
     *
     * @param ctx the parse tree
     */
    void exitVariableRow(PascalGrammarParser.VariableRowContext ctx);

    /**
     * Enter a parse tree produced by {@link PascalGrammarParser#functionProcedureContext}.
     *
     * @param ctx the parse tree
     */
    void enterFunctionProcedureContext(PascalGrammarParser.FunctionProcedureContextContext ctx);

    /**
     * Exit a parse tree produced by {@link PascalGrammarParser#functionProcedureContext}.
     *
     * @param ctx the parse tree
     */
    void exitFunctionProcedureContext(PascalGrammarParser.FunctionProcedureContextContext ctx);

    /**
     * Enter a parse tree produced by {@link PascalGrammarParser#functionHeader}.
     *
     * @param ctx the parse tree
     */
    void enterFunctionHeader(PascalGrammarParser.FunctionHeaderContext ctx);

    /**
     * Exit a parse tree produced by {@link PascalGrammarParser#functionHeader}.
     *
     * @param ctx the parse tree
     */
    void exitFunctionHeader(PascalGrammarParser.FunctionHeaderContext ctx);

    /**
     * Enter a parse tree produced by {@link PascalGrammarParser#procedureHeader}.
     *
     * @param ctx the parse tree
     */
    void enterProcedureHeader(PascalGrammarParser.ProcedureHeaderContext ctx);

    /**
     * Exit a parse tree produced by {@link PascalGrammarParser#procedureHeader}.
     *
     * @param ctx the parse tree
     */
    void exitProcedureHeader(PascalGrammarParser.ProcedureHeaderContext ctx);

    /**
     * Enter a parse tree produced by {@link PascalGrammarParser#arguments}.
     *
     * @param ctx the parse tree
     */
    void enterArguments(PascalGrammarParser.ArgumentsContext ctx);

    /**
     * Exit a parse tree produced by {@link PascalGrammarParser#arguments}.
     *
     * @param ctx the parse tree
     */
    void exitArguments(PascalGrammarParser.ArgumentsContext ctx);

    /**
     * Enter a parse tree produced by {@link PascalGrammarParser#main}.
     *
     * @param ctx the parse tree
     */
    void enterMain(PascalGrammarParser.MainContext ctx);

    /**
     * Exit a parse tree produced by {@link PascalGrammarParser#main}.
     *
     * @param ctx the parse tree
     */
    void exitMain(PascalGrammarParser.MainContext ctx);

    /**
     * Enter a parse tree produced by {@link PascalGrammarParser#contextMain}.
     *
     * @param ctx the parse tree
     */
    void enterContextMain(PascalGrammarParser.ContextMainContext ctx);

    /**
     * Exit a parse tree produced by {@link PascalGrammarParser#contextMain}.
     *
     * @param ctx the parse tree
     */
    void exitContextMain(PascalGrammarParser.ContextMainContext ctx);

    /**
     * Enter a parse tree produced by {@link PascalGrammarParser#statement}.
     *
     * @param ctx the parse tree
     */
    void enterStatement(PascalGrammarParser.StatementContext ctx);

    /**
     * Exit a parse tree produced by {@link PascalGrammarParser#statement}.
     *
     * @param ctx the parse tree
     */
    void exitStatement(PascalGrammarParser.StatementContext ctx);

    /**
     * Enter a parse tree produced by {@link PascalGrammarParser#assignmentStatement}.
     *
     * @param ctx the parse tree
     */
    void enterAssignmentStatement(PascalGrammarParser.AssignmentStatementContext ctx);

    /**
     * Exit a parse tree produced by {@link PascalGrammarParser#assignmentStatement}.
     *
     * @param ctx the parse tree
     */
    void exitAssignmentStatement(PascalGrammarParser.AssignmentStatementContext ctx);

    /**
     * Enter a parse tree produced by {@link PascalGrammarParser#expression}.
     *
     * @param ctx the parse tree
     */
    void enterExpression(PascalGrammarParser.ExpressionContext ctx);

    /**
     * Exit a parse tree produced by {@link PascalGrammarParser#expression}.
     *
     * @param ctx the parse tree
     */
    void exitExpression(PascalGrammarParser.ExpressionContext ctx);

    /**
     * Enter a parse tree produced by {@link PascalGrammarParser#simpleExpression}.
     *
     * @param ctx the parse tree
     */
    void enterSimpleExpression(PascalGrammarParser.SimpleExpressionContext ctx);

    /**
     * Exit a parse tree produced by {@link PascalGrammarParser#simpleExpression}.
     *
     * @param ctx the parse tree
     */
    void exitSimpleExpression(PascalGrammarParser.SimpleExpressionContext ctx);

    /**
     * Enter a parse tree produced by {@link PascalGrammarParser#term}.
     *
     * @param ctx the parse tree
     */
    void enterTerm(PascalGrammarParser.TermContext ctx);

    /**
     * Exit a parse tree produced by {@link PascalGrammarParser#term}.
     *
     * @param ctx the parse tree
     */
    void exitTerm(PascalGrammarParser.TermContext ctx);

    /**
     * Enter a parse tree produced by {@link PascalGrammarParser#signedFactor}.
     *
     * @param ctx the parse tree
     */
    void enterSignedFactor(PascalGrammarParser.SignedFactorContext ctx);

    /**
     * Exit a parse tree produced by {@link PascalGrammarParser#signedFactor}.
     *
     * @param ctx the parse tree
     */
    void exitSignedFactor(PascalGrammarParser.SignedFactorContext ctx);

    /**
     * Enter a parse tree produced by {@link PascalGrammarParser#factor}.
     *
     * @param ctx the parse tree
     */
    void enterFactor(PascalGrammarParser.FactorContext ctx);

    /**
     * Exit a parse tree produced by {@link PascalGrammarParser#factor}.
     *
     * @param ctx the parse tree
     */
    void exitFactor(PascalGrammarParser.FactorContext ctx);

    /**
     * Enter a parse tree produced by {@link PascalGrammarParser#bool}.
     *
     * @param ctx the parse tree
     */
    void enterBool(PascalGrammarParser.BoolContext ctx);

    /**
     * Exit a parse tree produced by {@link PascalGrammarParser#bool}.
     *
     * @param ctx the parse tree
     */
    void exitBool(PascalGrammarParser.BoolContext ctx);

    /**
     * Enter a parse tree produced by {@link PascalGrammarParser#unsignedConstant}.
     *
     * @param ctx the parse tree
     */
    void enterUnsignedConstant(PascalGrammarParser.UnsignedConstantContext ctx);

    /**
     * Exit a parse tree produced by {@link PascalGrammarParser#unsignedConstant}.
     *
     * @param ctx the parse tree
     */
    void exitUnsignedConstant(PascalGrammarParser.UnsignedConstantContext ctx);

    /**
     * Enter a parse tree produced by {@link PascalGrammarParser#functionCall}.
     *
     * @param ctx the parse tree
     */
    void enterFunctionCall(PascalGrammarParser.FunctionCallContext ctx);

    /**
     * Exit a parse tree produced by {@link PascalGrammarParser#functionCall}.
     *
     * @param ctx the parse tree
     */
    void exitFunctionCall(PascalGrammarParser.FunctionCallContext ctx);

    /**
     * Enter a parse tree produced by {@link PascalGrammarParser#parameterList}.
     *
     * @param ctx the parse tree
     */
    void enterParameterList(PascalGrammarParser.ParameterListContext ctx);

    /**
     * Exit a parse tree produced by {@link PascalGrammarParser#parameterList}.
     *
     * @param ctx the parse tree
     */
    void exitParameterList(PascalGrammarParser.ParameterListContext ctx);

    /**
     * Enter a parse tree produced by {@link PascalGrammarParser#operationPr1}.
     *
     * @param ctx the parse tree
     */
    void enterOperationPr1(PascalGrammarParser.OperationPr1Context ctx);

    /**
     * Exit a parse tree produced by {@link PascalGrammarParser#operationPr1}.
     *
     * @param ctx the parse tree
     */
    void exitOperationPr1(PascalGrammarParser.OperationPr1Context ctx);

    /**
     * Enter a parse tree produced by {@link PascalGrammarParser#operationPr2}.
     *
     * @param ctx the parse tree
     */
    void enterOperationPr2(PascalGrammarParser.OperationPr2Context ctx);

    /**
     * Exit a parse tree produced by {@link PascalGrammarParser#operationPr2}.
     *
     * @param ctx the parse tree
     */
    void exitOperationPr2(PascalGrammarParser.OperationPr2Context ctx);

    /**
     * Enter a parse tree produced by {@link PascalGrammarParser#operationPr3}.
     *
     * @param ctx the parse tree
     */
    void enterOperationPr3(PascalGrammarParser.OperationPr3Context ctx);

    /**
     * Exit a parse tree produced by {@link PascalGrammarParser#operationPr3}.
     *
     * @param ctx the parse tree
     */
    void exitOperationPr3(PascalGrammarParser.OperationPr3Context ctx);

    /**
     * Enter a parse tree produced by {@link PascalGrammarParser#varWrapper}.
     *
     * @param ctx the parse tree
     */
    void enterVarWrapper(PascalGrammarParser.VarWrapperContext ctx);

    /**
     * Exit a parse tree produced by {@link PascalGrammarParser#varWrapper}.
     *
     * @param ctx the parse tree
     */
    void exitVarWrapper(PascalGrammarParser.VarWrapperContext ctx);

    /**
     * Enter a parse tree produced by {@link PascalGrammarParser#logicCicleStatments}.
     *
     * @param ctx the parse tree
     */
    void enterLogicCicleStatments(PascalGrammarParser.LogicCicleStatmentsContext ctx);

    /**
     * Exit a parse tree produced by {@link PascalGrammarParser#logicCicleStatments}.
     *
     * @param ctx the parse tree
     */
    void exitLogicCicleStatments(PascalGrammarParser.LogicCicleStatmentsContext ctx);

    /**
     * Enter a parse tree produced by {@link PascalGrammarParser#ifStatement}.
     *
     * @param ctx the parse tree
     */
    void enterIfStatement(PascalGrammarParser.IfStatementContext ctx);

    /**
     * Exit a parse tree produced by {@link PascalGrammarParser#ifStatement}.
     *
     * @param ctx the parse tree
     */
    void exitIfStatement(PascalGrammarParser.IfStatementContext ctx);

    /**
     * Enter a parse tree produced by {@link PascalGrammarParser#cycleStatement}.
     *
     * @param ctx the parse tree
     */
    void enterCycleStatement(PascalGrammarParser.CycleStatementContext ctx);

    /**
     * Exit a parse tree produced by {@link PascalGrammarParser#cycleStatement}.
     *
     * @param ctx the parse tree
     */
    void exitCycleStatement(PascalGrammarParser.CycleStatementContext ctx);

    /**
     * Enter a parse tree produced by {@link PascalGrammarParser#whileStatement}.
     *
     * @param ctx the parse tree
     */
    void enterWhileStatement(PascalGrammarParser.WhileStatementContext ctx);

    /**
     * Exit a parse tree produced by {@link PascalGrammarParser#whileStatement}.
     *
     * @param ctx the parse tree
     */
    void exitWhileStatement(PascalGrammarParser.WhileStatementContext ctx);

    /**
     * Enter a parse tree produced by {@link PascalGrammarParser#forStatement}.
     *
     * @param ctx the parse tree
     */
    void enterForStatement(PascalGrammarParser.ForStatementContext ctx);

    /**
     * Exit a parse tree produced by {@link PascalGrammarParser#forStatement}.
     *
     * @param ctx the parse tree
     */
    void exitForStatement(PascalGrammarParser.ForStatementContext ctx);

    /**
     * Enter a parse tree produced by {@link PascalGrammarParser#namesList}.
     *
     * @param ctx the parse tree
     */
    void enterNamesList(PascalGrammarParser.NamesListContext ctx);

    /**
     * Exit a parse tree produced by {@link PascalGrammarParser#namesList}.
     *
     * @param ctx the parse tree
     */
    void exitNamesList(PascalGrammarParser.NamesListContext ctx);

    /**
     * Enter a parse tree produced by {@link PascalGrammarParser#type}.
     *
     * @param ctx the parse tree
     */
    void enterType(PascalGrammarParser.TypeContext ctx);

    /**
     * Exit a parse tree produced by {@link PascalGrammarParser#type}.
     *
     * @param ctx the parse tree
     */
    void exitType(PascalGrammarParser.TypeContext ctx);
}