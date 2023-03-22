/**
 * BSD-style license; for more info see http://pmd.sourceforge.net/license.html
 */

package net.sourceforge.pmd.lang.coco.cpd;

import org.antlr.v4.runtime.CharStream;

import net.sourceforge.pmd.cpd.AntlrTokenizer;
import net.sourceforge.pmd.cpd.SourceCode;
import net.sourceforge.pmd.cpd.token.AntlrTokenFilter;
import net.sourceforge.pmd.lang.antlr.AntlrTokenManager;
import net.sourceforge.pmd.lang.coco.ast.CocoLexer;

/**
 * The Coco Tokenizer.
 */
public class CocoTokenizer extends AntlrTokenizer {

    @Override
    protected AntlrTokenManager getLexerForSource(SourceCode sourceCode) {
        CharStream charStream = AntlrTokenizer.getCharStreamFromSourceCode(sourceCode);
        return new AntlrTokenManager(new CocoLexer(charStream), sourceCode.getFileName());
    }

    @Override
    protected AntlrTokenFilter getTokenFilter(final AntlrTokenManager tokenManager) {
        return new AntlrTokenFilter(tokenManager);
    }
}
