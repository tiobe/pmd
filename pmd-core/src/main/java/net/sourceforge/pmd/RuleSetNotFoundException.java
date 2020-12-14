/**
 * BSD-style license; for more info see http://pmd.sourceforge.net/license.html
 */

package net.sourceforge.pmd;

/**
 * @deprecated This is now only thrown by deprecated apis. {@link RuleSetLoader}
 *     throws {@link RuleSetLoadException} instead
 */
@Deprecated
public class RuleSetNotFoundException extends Exception {

    private static final long serialVersionUID = -4617033110919250810L;

    public RuleSetNotFoundException(String msg) {
        super(msg);
    }

    public RuleSetNotFoundException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
