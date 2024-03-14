/**
 * BSD-style license; for more info see http://pmd.sourceforge.net/license.html
 */

package net.sourceforge.pmd.cpd;

import java.util.Properties;

import org.junit.Test;

import net.sourceforge.pmd.cpd.test.CpdTextComparisonTest;

public class PowershellTokenizerTest extends CpdTextComparisonTest {
    public PowershellTokenizerTest() {
        super(".ps1");
    }

    @Override
    protected String getResourcePrefix() {
        return "../lang/powershell/cpd/testdata";
    }

    @Override
    public Tokenizer newTokenizer(Properties properties) {
        return new PowershellTokenizer();
    }

    @Test
    public void testInitMachine() {
        doTest("Initialize-Machine-Signed");
    }

    @Test
    public void testInstallVS() {
        doTest("Install-VS");
    }

    @Test
    public void testStringLiterals() {
        doTest("String-Literal-Test");
    }
}
