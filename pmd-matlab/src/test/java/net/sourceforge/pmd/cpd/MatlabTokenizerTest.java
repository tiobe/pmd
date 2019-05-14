/**
 * BSD-style license; for more info see http://pmd.sourceforge.net/license.html
 */

package net.sourceforge.pmd.cpd;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

import org.apache.commons.io.IOUtils;
import org.junit.Before;
import org.junit.Test;

import net.sourceforge.pmd.PMD;
import net.sourceforge.pmd.testframework.AbstractTokenizerTest;

public class MatlabTokenizerTest extends AbstractTokenizerTest {

    private static final String FILENAME = "sample-matlab.m";

    @Before
    @Override
    public void buildTokenizer() throws IOException {
        this.tokenizer = new MatlabTokenizer();
        this.sourceCode = new SourceCode(new SourceCode.StringCodeLoader(this.getSampleCode(), FILENAME));
    }

    @Override
    public String getSampleCode() throws IOException {
        return IOUtils.toString(MatlabTokenizer.class.getResourceAsStream(FILENAME), StandardCharsets.UTF_8);
    }

    @Test
    public void tokenizeTest() throws IOException {
        this.expectedTokenCount = 3925;
        super.tokenizeTest();
    }

    @Test
    public void testIgnoreBetweenSpecialComments() throws IOException {
        SourceCode sourceCode = new SourceCode(new SourceCode.StringCodeLoader("% CPD-OFF" + PMD.EOL
                + "function g = vec(op, y)" + PMD.EOL
                + "  opy = op(y);" + PMD.EOL
                + "  if ( any(size(opy) > 1) )" + PMD.EOL
                + "    g = @loopWrapperArray;" + PMD.EOL
                + "  end" + PMD.EOL
                + "  % CPD-ON" + PMD.EOL
                + "end"
        ));
        Tokens tokens = new Tokens();
        tokenizer.tokenize(sourceCode, tokens);
        TokenEntry.getEOF();
        assertEquals(2, tokens.size()); // 2 tokens: "end" + EOF
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
    public void testComments() throws IOException {
        SourceCode sourceCode = new SourceCode(new SourceCode.StringCodeLoader("classdef LC" + PMD.EOL
                + "    methods" + PMD.EOL
                + "        function [obj, c,t, s ] = Classification( obj,m,t, cm )%#codegen" + PMD.EOL
                + "        end" + PMD.EOL
                + "    end" + PMD.EOL
                + "end"));
        Tokens tokens = new Tokens();
        tokenizer.tokenize(sourceCode, tokens); // should not result in parse error
        TokenEntry.getEOF();
        assertEquals(28, tokens.size());
    }

    @Test
    public void testBlockComments() throws IOException {
        SourceCode sourceCode = new SourceCode(new SourceCode.StringCodeLoader("%{" + PMD.EOL
                + "  Name:     helloworld.m\n" + PMD.EOL
                + "  Purpose:  Say \"Hello World!\" in two different ways" + PMD.EOL
                + "%}" + PMD.EOL
                + PMD.EOL
                + "% Do it the good ol' fashioned way...command window" + PMD.EOL
                + "disp('Hello World!');\n" + PMD.EOL
                + "%" + PMD.EOL
                + "% Do it the new hip GUI way...with a message box" + PMD.EOL
                + "msgbox('Hello World!','Hello World!');"));
        Tokens tokens = new Tokens();
        tokenizer.tokenize(sourceCode, tokens); // should not result in parse error
        TokenEntry.getEOF();
        assertEquals(13, tokens.size());
    }

    @Test
    public void testQuestionMark() throws IOException {
        SourceCode sourceCode = new SourceCode(new SourceCode.StringCodeLoader("classdef Class1" + PMD.EOL
                + "properties (SetAccess = ?Class2)"));
        Tokens tokens = new Tokens();
        tokenizer.tokenize(sourceCode, tokens);
        TokenEntry.getEOF();
        assertEquals(10, tokens.size());
    }

    @Test
    public void testDoubleQuotedStrings() throws IOException {
        SourceCode sourceCode = new SourceCode(new SourceCode.StringCodeLoader(
                "error(\"This is a double-quoted string\");"));
        Tokens tokens = new Tokens();
        tokenizer.tokenize(sourceCode, tokens);
        TokenEntry.getEOF();
        assertEquals(6, tokens.size());
    }
}
