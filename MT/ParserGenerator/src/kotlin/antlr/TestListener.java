// Generated from /Users/nikita/Algo-DM-laba/MT/ParserGenerator/src/resources/realAntlr/Test.g4 by ANTLR 4.7.2
package antlr;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link TestParser}.
 */
public interface TestListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link TestParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(TestParser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link TestParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(TestParser.ExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link TestParser#exprP}.
	 * @param ctx the parse tree
	 */
	void enterExprP(TestParser.ExprPContext ctx);
	/**
	 * Exit a parse tree produced by {@link TestParser#exprP}.
	 * @param ctx the parse tree
	 */
	void exitExprP(TestParser.ExprPContext ctx);
	/**
	 * Enter a parse tree produced by {@link TestParser#rule1}.
	 * @param ctx the parse tree
	 */
	void enterRule1(TestParser.Rule1Context ctx);
	/**
	 * Exit a parse tree produced by {@link TestParser#rule1}.
	 * @param ctx the parse tree
	 */
	void exitRule1(TestParser.Rule1Context ctx);
	/**
	 * Enter a parse tree produced by {@link TestParser#rule2}.
	 * @param ctx the parse tree
	 */
	void enterRule2(TestParser.Rule2Context ctx);
	/**
	 * Exit a parse tree produced by {@link TestParser#rule2}.
	 * @param ctx the parse tree
	 */
	void exitRule2(TestParser.Rule2Context ctx);
}