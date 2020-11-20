/**
 * BSD-style license; for more info see http://pmd.sourceforge.net/license.html
 */

package net.sourceforge.pmd.lang.dfa;

import java.util.List;

import net.sourceforge.pmd.lang.ast.Node;

/**
 * @deprecated The data flow codebase will be removed in PMD 7.
 *      The feature is unreliable, hard to use, and the implementation is
 *      unmaintainable. See https://github.com/pmd/pmd/issues/2647
 */
@Deprecated
public interface DataFlowNode {
    List<VariableAccess> getVariableAccess();

    int getLine();

    int getIndex();

    boolean isType(NodeType type);

    void setType(NodeType type);

    List<DataFlowNode> getChildren();

    List<DataFlowNode> getParents();

    List<DataFlowNode> getFlow();

    Node getNode();

    void setVariableAccess(List<VariableAccess> variableAccess);

    void addPathToChild(DataFlowNode child);

    boolean removePathToChild(DataFlowNode child);

    void reverseParentPathsTo(DataFlowNode destination);

}
