/**
 * BSD-style license; for more info see http://pmd.sourceforge.net/license.html
 */

package net.sourceforge.pmd.cpd;

import java.util.Properties;

import org.antlr.v4.runtime.CharStream;

import net.sourceforge.pmd.cpd.token.AntlrToken;
import net.sourceforge.pmd.cpd.token.AntlrTokenFilter;
import net.sourceforge.pmd.lang.antlr.AntlrTokenManager;
import net.sourceforge.pmd.lang.cs.antlr4.CSharpLexer;

/**
 * The C# tokenizer.
 */
public class CsTokenizer extends AntlrTokenizer {

    private boolean ignoreUsings = false;
    private boolean skipLiteralSequences = false;

    public void setProperties(Properties properties) {
        ignoreUsings = Boolean.parseBoolean(properties.getProperty(IGNORE_USINGS, "false"));
        skipLiteralSequences = Boolean.parseBoolean(properties.getProperty(OPTION_SKIP_LITERAL_SEQUENCES, "false"));
    }

    public void setIgnoreUsings(boolean ignoreUsings) {
        this.ignoreUsings = ignoreUsings;
    }

    public void setSkipLiteralSequences(boolean skipLiteralSequences) {
        this.skipLiteralSequences = skipLiteralSequences;
    }

    @Override
    protected AntlrTokenManager getLexerForSource(final SourceCode sourceCode) {
        final CharStream charStream = AntlrTokenizer.getCharStreamFromSourceCode(sourceCode);
        return new AntlrTokenManager(new CSharpLexer(charStream), sourceCode.getFileName());
    }

    @Override
    protected AntlrTokenFilter getTokenFilter(final AntlrTokenManager tokenManager) {
        return new CsTokenFilter(tokenManager, ignoreUsings, skipLiteralSequences);
    }

    /**
     * The {@link CsTokenFilter} extends the {@link AntlrTokenFilter} to discard
     * C#-specific tokens.
     * <p>
     * By default, it enables annotation-based CPD suppression.
     * If the --ignoreUsings flag is provided, using directives are filtered out.
     * </p>
     */
    private static class CsTokenFilter extends AntlrTokenFilter {
        private enum UsingState {
            KEYWORD, // just encountered the using keyword
            IDENTIFIER, // just encountered an identifier or var keyword
        }

        private final boolean ignoreUsings;
        private final boolean skipLiteralSequences;
        private boolean discardingUsings = false;
        private boolean discardingNL = false;
        private boolean discardingLiterals = false;
        private boolean discardCurrent = false;

        CsTokenFilter(final AntlrTokenManager tokenManager, boolean ignoreUsings, boolean skipLiteralSequences) {
            super(tokenManager);
            this.ignoreUsings = ignoreUsings;
            this.skipLiteralSequences = skipLiteralSequences;
        }

        @Override
        protected void analyzeToken(final AntlrToken currentToken) {
            skipNewLines(currentToken);
        }

        @Override
        protected void analyzeTokens(final AntlrToken currentToken, final Iterable<AntlrToken> remainingTokens) {
            discardCurrent = false;
            skipUsingDirectives(currentToken, remainingTokens);
            skipLiteralSequences(currentToken, remainingTokens);
        }

        private void skipUsingDirectives(final AntlrToken currentToken, final Iterable<AntlrToken> remainingTokens) {
            if (ignoreUsings) {
                final int type = currentToken.getKind();
                if (type == CSharpLexer.USING && isUsingDirective(remainingTokens)) {
                    discardingUsings = true;
                } else if (type == CSharpLexer.SEMICOLON && discardingUsings) {
                    discardingUsings = false;
                    discardCurrent = true;
                }
            }
        }

        private boolean isUsingDirective(final Iterable<AntlrToken> remainingTokens) {
            UsingState usingState = UsingState.KEYWORD;
            for (final AntlrToken token : remainingTokens) {
                final int type = token.getKind();
                if (usingState == UsingState.KEYWORD) {
                    // The previous token was a using keyword.
                    switch (type) {
                    case CSharpLexer.STATIC:
                        // Definitely a using directive.
                        // Example: using static System.Math;
                        return true;
                    case CSharpLexer.VAR:
                        // Definitely a using statement.
                        // Example: using var font1 = new Font("Arial", 10.0f);
                        return false;
                    case CSharpLexer.OPEN_PARENS:
                        // Definitely a using statement.
                        // Example: using (var font1 = new Font("Arial", 10.0f);
                        return false;
                    case CSharpLexer.IDENTIFIER:
                        // This is either a type for a using statement or an alias for a using directive.
                        // Example (directive): using Project = PC.MyCompany.Project;
                        // Example (statement): using Font font1 = new Font("Arial", 10.0f);
                        usingState = UsingState.IDENTIFIER;
                        break;
                    default:
                        // Some unknown construct?
                        return false;
                    }
                } else if (usingState == UsingState.IDENTIFIER) {
                    // The previous token was an identifier.
                    switch (type) {
                    case CSharpLexer.ASSIGNMENT:
                        // Definitely a using directive.
                        // Example: using Project = PC.MyCompany.Project;
                        return true;
                    case CSharpLexer.IDENTIFIER:
                        // Definitely a using statement.
                        // Example: using Font font1 = new Font("Arial", 10.0f);
                        return false;
                    case CSharpLexer.DOT:
                        // This should be considered part of the same type; revert to previous state.
                        // Example (directive): using System.Text;
                        // Example (statement): using System.Drawing.Font font1 = new Font("Arial", 10.0f);
                        usingState = UsingState.KEYWORD;
                        break;
                    case CSharpLexer.SEMICOLON:
                        // End of using directive.
                        return true;
                    default:
                        // Some unknown construct?
                        return false;
                    }
                }
            }
            return false;
        }

        private void skipNewLines(final AntlrToken currentToken) {
            discardingNL = currentToken.getKind() == CSharpLexer.NL;
        }

        private void skipLiteralSequences(final AntlrToken currentToken, final Iterable<AntlrToken> remainingTokens) {
            if (skipLiteralSequences) {
                final int type = currentToken.getType();
                if (type == CSharpLexer.OPEN_BRACE && isSequenceOfLiterals(remainingTokens)) {
                    discardingLiterals = true;
                } else if (type == CSharpLexer.CLOSE_BRACE && discardingLiterals) {
                    discardingLiterals = false;
                    discardCurrent = true;
                }
            }
        }

        private boolean isSequenceOfLiterals(final Iterable<AntlrToken> remainingTokens) {
            boolean seenLiteral = false;
            for (final AntlrToken token : remainingTokens) {
                switch (token.getType()) {
                case CSharpLexer.INTEGER_LITERAL:
                    seenLiteral = true;
                    break; // can be skipped; continue to the next token
                case CSharpLexer.COMMA:
                    break; // can be skipped; continue to the next token
                case CSharpLexer.CLOSE_BRACE:
                    // end of the list; skip all contents
                    return seenLiteral;
                default:
                    // some other token than the expected ones; this is not a sequence of literals
                    return false;
                }
            }
            return false;
        }

        @Override
        protected boolean isLanguageSpecificDiscarding() {
            return discardingUsings || discardingNL || discardingLiterals || discardCurrent;
        }
    }
}
