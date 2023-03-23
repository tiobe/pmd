/*
 * BSD-style license; for more info see http://pmd.sourceforge.net/license.html
 */

package net.sourceforge.pmd.cpd;

import java.util.Properties;

import org.junit.Test;

import net.sourceforge.pmd.cpd.test.CpdTextComparisonTest;
import net.sourceforge.pmd.lang.coco.cpd.CocoTokenizer;

public class CocoTokenizerTest extends CpdTextComparisonTest {
    public CocoTokenizerTest() {
        super(".coco");
    }

    @Override
    protected String getResourcePrefix() {
        return "../lang/coco/cpd/testdata";
    }

    @Override
    public Tokenizer newTokenizer(Properties properties) {
        CocoTokenizer tok = new CocoTokenizer();
        return tok;
    }

    @Test
    public void testSimpleMachine() {
        doTest("simple_machine");
    }

    @Test
    public void testEnum() {
        doTest("enum");
    }
}
