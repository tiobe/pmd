/**
 * BSD-style license; for more info see http://pmd.sourceforge.net/license.html
 */

package net.sourceforge.pmd.cpd;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;

import org.junit.Test;

import net.sourceforge.pmd.PMD;
import net.sourceforge.pmd.cpd.test.CpdTextComparisonTest;

public class EcmascriptTokenizerTest extends CpdTextComparisonTest {

    public EcmascriptTokenizerTest() {
        super(".js");
    }

    @Override
    public Tokenizer newTokenizer(Properties properties) {
        return new EcmascriptTokenizer();
    }

    @Override
    protected String getResourcePrefix() {
        return "../lang/ecmascript/cpd/testdata";
    }

    @Test
    public void testSimple() {
        doTest("simple");
    }

    @Test
    public void testSimplewithSemis() {
        doTest("simpleWithSemis");
    }

    @Test
    public void testIgnoreBetweenSpecialComments() {
        doTest("specialComments");
    }

    /**
     * See: https://sourceforge.net/p/pmd/bugs/1239/
     */
    @Test
    public void parseStringNotAsMultiline() {
        doTest("lineContinuations");
    }

    @Test
    public void testIgnoreSingleLineComments() {
        doTest("singleLineCommentIgnore");
    }

    @Test
    public void testIgnoreMultiLineComments() {
        doTest("multilineCommentIgnore");
    }

    @Test
    public void testTemplateStrings() {
        doTest("templateStrings");
    }

    @Test
    public void testDecorators() throws IOException {
        Tokenizer t = new EcmascriptTokenizer();
        SourceCode sourceCode = new SourceCode(new SourceCode.StringCodeLoader("// A simple decorator" + PMD.EOL
                + "@annotation" + PMD.EOL
                + "class MyClass { }" + PMD.EOL
                + "" + PMD.EOL
                + "function annotation(target) {" + PMD.EOL
                + "   // Add a property on target" + PMD.EOL
                + "   target.annotated = true;" + PMD.EOL
                + "}" + PMD.EOL
        ));
        final Tokens tokens = new Tokens();
        t.tokenize(sourceCode, tokens);
        assertEquals("@annotation", tokens.getTokens().get(0).toString());
    }

    @Test
    public void testUnicodeJSX() throws IOException {
        final Tokenizer t = new EcmascriptTokenizer();
        final InputStream resourceAsStream = EcmascriptTokenizer.class.getResourceAsStream("/net/sourceforge/pmd/cpd/js/Login.js");
        final SourceCode sourceCode = new SourceCode(new SourceCode.ReaderCodeLoader(new InputStreamReader(resourceAsStream), "UTF-8"));
        final Tokens tokens = new Tokens();
        t.tokenize(sourceCode, tokens); // should not result in error
    }

    public void testTabWidth() {
        doTest("tabWidth");
    }
}
