// Generated from /Users/nikita/Algo-DM-laba/MT/ParserGenerator/src/resources/realAntlr/Test.g4 by ANTLR 4.7.2
package antlr;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link TestParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface TestVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link TestParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr(TestParser.ExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link TestParser#exprP}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprP(TestParser.ExprPContext ctx);
	/**
	 * Visit a parse tree produced by {@link TestParser#rule1}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRule1(TestParser.Rule1Context ctx);
	/**
	 * Visit a parse tree produced by {@link TestParser#rule2}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRule2(TestParser.Rule2Context ctx);
}