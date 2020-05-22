/*
 * BSD-style license; for more info see http://pmd.sourceforge.net/license.html
 */

package net.sourceforge.pmd.lang.apex.ast;

import net.sourceforge.pmd.annotation.InternalApi;

import apex.jorje.semantic.ast.expression.SuperMethodCallExpression;

public class ASTSuperMethodCallExpression extends AbstractApexNode<SuperMethodCallExpression> {

    @Deprecated
    @InternalApi
    public ASTSuperMethodCallExpression(SuperMethodCallExpression superMethodCallExpression) {
        super(superMethodCallExpression);
    }

    @Override
    public Object jjtAccept(ApexParserVisitor visitor, Object data) {
        return visitor.visit(this, data);
    }
}
