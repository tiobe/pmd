/**
 * BSD-style license; for more info see http://pmd.sourceforge.net/license.html
 */

package net.sourceforge.pmd.cpd;

/**
 * Language implementation for Powershell
 */
public class PowershellLanguage extends AbstractLanguage {

    /**
     * Creates a new Powershell language instance.
     */
    public PowershellLanguage() {
        super("Powershell", "powershell", new PowershellTokenizer(), ".ps1");
    }
}
