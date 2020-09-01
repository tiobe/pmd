/**
 * BSD-style license; for more info see http://pmd.sourceforge.net/license.html
 */

package net.sourceforge.pmd.cpd;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.util.Properties;

import org.junit.Test;

import net.sourceforge.pmd.PMD;
import net.sourceforge.pmd.cpd.test.CpdTextComparisonTest;

public class MatlabTokenizerTest extends CpdTextComparisonTest {

    private Tokenizer tokenizer = newTokenizer(null);

    public MatlabTokenizerTest() {
        super(".m");
    }

    @Override
    protected String getResourcePrefix() {
        return "../lang/matlab/cpd/testdata";
    }

    @Override
    public Tokenizer newTokenizer(Properties properties) {
        return new MatlabTokenizer();
    }
    
    @Test
    public void testLongSample() {
        doTest("sample-matlab");
    }

    @Test
    public void testIgnoreBetweenSpecialComments() {
        doTest("specialComments");

    }

    @Test
    public void testLatexFormatting() throws IOException {
        SourceCode sourceCode = new SourceCode(new SourceCode.StringCodeLoader("function MyFunction()" + PMD.EOL
                + "  t = ProfileTranslation.t(1):step:ProfileTranslation.t(end) + time_extension;" + PMD.EOL
                + "  x   = zeros(nrt, 1);" + PMD.EOL
                + "  figure;" + PMD.EOL
                + "  subplot(4, 2, 1)" + PMD.EOL
                + "  plot(t, x);" + PMD.EOL
                + "  xlabel('$\\phi$', 'Interpreter', 'latex');" + PMD.EOL
                + "  ylabel('$x$', 'Interpreter', 'latex');" + PMD.EOL
                + "  grid on;" + PMD.EOL
                + "  hold on;" + PMD.EOL
                + "  plot(wpt, wpx, 'ro');" + PMD.EOL
                + "end"
        ));
        Tokens tokens = new Tokens();
        tokenizer.tokenize(sourceCode, tokens); // should not result in parse error
        TokenEntry.getEOF();
        assertEquals(12, tokens.getTokens().get(tokens.getTokens().size() - 2).getBeginLine());
    }

    @Test
    public void testUncPath() throws IOException {
        SourceCode sourceCode = new SourceCode(new SourceCode.StringCodeLoader("paths = {..." + PMD.EOL
                + "    '\\\\192.168.1.101\\My\\UNC_PATH\\20180615_123456\\'; ..." + PMD.EOL
                + "    };" + PMD.EOL

        ));
        Tokens tokens = new Tokens();
        tokenizer.tokenize(sourceCode, tokens); // should not result in parse error
        TokenEntry.getEOF();
        assertEquals(3, tokens.getTokens().get(tokens.getTokens().size() - 2).getBeginLine());
    }

    @Test
    public void testBackslashInString() throws IOException {
        SourceCode sourceCode = new SourceCode(new SourceCode.StringCodeLoader(
                "path = strrep(copySource, '\\', '_');" + PMD.EOL + ";" + PMD.EOL
        ));
        Tokens tokens = new Tokens();
        tokenizer.tokenize(sourceCode, tokens); // should not result in parse error
        TokenEntry.getEOF();
        assertEquals(2, tokens.getTokens().get(tokens.getTokens().size() - 2).getBeginLine());
    }

    @Test
    public void testFormfeed() throws IOException {
        SourceCode sourceCode = new SourceCode(new SourceCode.StringCodeLoader("\f" + PMD.EOL
                + "test = 3;" + PMD.EOL
        ));
        Tokens tokens = new Tokens();
        tokenizer.tokenize(sourceCode, tokens); // should not result in parse error
        TokenEntry.getEOF();
        assertEquals(5, tokens.size()); // 5 tokens: "test", "=", "3", ";", "EOF"
    }

    @Test
    public void testComments() {
        doTest("comments");
    }

    @Test
    public void testBlockComments() {
        doTest("multilineComments");
    }

    @Test
    public void testQuestionMark() {
        doTest("questionMark");
    }

    @Test
    public void testDoubleQuotedStrings() {
        doTest("doubleQuotedStrings");
    }

    @Test
    public void testTabWidth() {
        doTest("tabWidth");
    }
}
