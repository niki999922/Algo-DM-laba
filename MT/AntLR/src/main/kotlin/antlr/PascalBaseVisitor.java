// Generated from /Users/nikita/Algo-DM-laba/MT/AntLR/src/main/resources/antlr/Pascal.g4 by ANTLR 4.7.2
package antlr;

import org.antlr.v4.runtime.tree.AbstractParseTreeVisitor;

/**
 * This class provides an empty implementation of {@link PascalVisitor},
 * which can be extended to create a visitor which only needs to handle a subset
 * of the available methods.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 *            operations with no return type.
 */
public class PascalBaseVisitor<T> extends AbstractParseTreeVisitor<T> implements PascalVisitor<T> {
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override
    public T visitR(PascalParser.RContext ctx) {
        return visitChildren(ctx);
    }
}