/*
 * BSD-style license; for more info see http://pmd.sourceforge.net/license.html
 */

package net.sourceforge.pmd.lang.apex.ast;

/**
 * @author Clément Fournier
 *
 * @deprecated The functionality of this adapter will be moved into the base apex visitor, so this class will
 *             go away with PMD 7.
 */
@Deprecated
public class ApexParserVisitorReducedAdapter extends ApexParserVisitorAdapter {


    @Override
    public final Object visit(ASTUserInterface node, Object data) {
        return visit((ASTUserClassOrInterface<?>) node, data);
    }


    @Override
    public final Object visit(ASTUserClass node, Object data) {
        return visit((ASTUserClassOrInterface<?>) node, data);
    }


    public Object visit(ASTUserClassOrInterface<?> node, Object data) {
        return visit((ApexNode<?>) node, data);
    }

}
