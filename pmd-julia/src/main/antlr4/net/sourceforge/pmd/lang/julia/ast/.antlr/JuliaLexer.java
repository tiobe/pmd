// Generated from d:\09_Repo\pmd\pmd-julia\src\main\antlr4\net\sourceforge\pmd\lang\julia\ast\Julia.g4 by ANTLR 4.9.2
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class JuliaLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.9.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, INT=11, FLOAT=12, COMMENTS=13, MULTILINECOMMENTS1=14, MULTILINECOMMENTS2=15, 
		MULTILINESTRING=16, NL=17, WHITESPACE=18, BEGIN=19, CATCH=20, CHAR=21, 
		DO=22, ELSE=23, ELSIF=24, END=25, EXTERNALCOMMAND=26, FINALLY=27, FOR=28, 
		FUNCTION=29, IF=30, LET=31, MACRO=32, STRING=33, STRUCT=34, TRY=35, TYPE=36, 
		WHERE=37, WHILE=38, INSTANCE_OF=39, IDENTIFIER=40, ANY=41;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
			"T__9", "Digit", "INT", "FLOAT", "COMMENTS", "MULTILINECOMMENTS1", "MULTILINECOMMENTS2", 
			"MULTILINESTRING", "NL", "WHITESPACE", "BEGIN", "CATCH", "CHAR", "DO", 
			"ELSE", "ELSIF", "END", "EXTERNALCOMMAND", "FINALLY", "FOR", "FUNCTION", 
			"IF", "LET", "MACRO", "STRING", "STRUCT", "TRY", "TYPE", "WHERE", "WHILE", 
			"INSTANCE_OF", "IDENTIFIER", "ANY"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'('", "')'", "'='", "'['", "']'", "'{'", "'}'", "'&&'", "'||'", 
			"'=='", null, null, null, null, null, null, null, null, "'begin'", "'catch'", 
			null, "'do'", "'else'", "'elsif'", "'end'", null, "'finally'", "'for'", 
			"'function'", "'if'", "'let'", "'macro'", null, "'struct'", "'try'", 
			"'type'", "'where'", "'while'", "'::'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, "INT", 
			"FLOAT", "COMMENTS", "MULTILINECOMMENTS1", "MULTILINECOMMENTS2", "MULTILINESTRING", 
			"NL", "WHITESPACE", "BEGIN", "CATCH", "CHAR", "DO", "ELSE", "ELSIF", 
			"END", "EXTERNALCOMMAND", "FINALLY", "FOR", "FUNCTION", "IF", "LET", 
			"MACRO", "STRING", "STRUCT", "TRY", "TYPE", "WHERE", "WHILE", "INSTANCE_OF", 
			"IDENTIFIER", "ANY"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}


	public JuliaLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Julia.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2+\u016e\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\3"+
		"\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\t\3\n"+
		"\3\n\3\n\3\13\3\13\3\13\3\f\3\f\3\r\6\rr\n\r\r\r\16\rs\3\16\6\16w\n\16"+
		"\r\16\16\16x\3\16\3\16\7\16}\n\16\f\16\16\16\u0080\13\16\3\17\3\17\3\17"+
		"\7\17\u0085\n\17\f\17\16\17\u0088\13\17\5\17\u008a\n\17\3\17\3\17\3\20"+
		"\3\20\3\20\3\20\7\20\u0092\n\20\f\20\16\20\u0095\13\20\3\20\3\20\3\20"+
		"\3\20\3\20\3\21\3\21\3\21\3\21\3\21\7\21\u00a1\n\21\f\21\16\21\u00a4\13"+
		"\21\3\21\3\21\3\21\3\21\3\21\3\21\3\22\3\22\3\22\3\22\3\22\3\22\3\22\7"+
		"\22\u00b3\n\22\f\22\16\22\u00b6\13\22\3\22\3\22\3\22\3\22\3\22\3\22\3"+
		"\23\5\23\u00bf\n\23\3\23\3\23\3\23\3\23\3\24\6\24\u00c6\n\24\r\24\16\24"+
		"\u00c7\3\24\3\24\3\25\3\25\3\25\3\25\3\25\3\25\3\26\3\26\3\26\3\26\3\26"+
		"\3\26\3\27\3\27\5\27\u00da\n\27\3\27\5\27\u00dd\n\27\3\27\3\27\3\30\3"+
		"\30\3\30\3\31\3\31\3\31\3\31\3\31\3\32\3\32\3\32\3\32\3\32\3\32\3\33\3"+
		"\33\3\33\3\33\3\34\3\34\7\34\u00f5\n\34\f\34\16\34\u00f8\13\34\3\34\3"+
		"\34\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\36\3\36\3\36\3\36\3\37\3"+
		"\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3 \3 \3 \3!\3!\3!\3!\3\"\3\"\3"+
		"\"\3\"\3\"\3\"\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\7#\u012a\n#\f#\16#"+
		"\u012d\13#\3#\3#\3#\7#\u0132\n#\f#\16#\u0135\13#\3#\3#\7#\u0139\n#\f#"+
		"\16#\u013c\13#\3#\3#\7#\u0140\n#\f#\16#\u0143\13#\3#\3#\3$\3$\3$\3$\3"+
		"$\3$\3$\3%\3%\3%\3%\3&\3&\3&\3&\3&\3\'\3\'\3\'\3\'\3\'\3\'\3(\3(\3(\3"+
		"(\3(\3(\3)\3)\3)\3*\3*\7*\u0168\n*\f*\16*\u016b\13*\3+\3+\n\u0093\u00a2"+
		"\u00b4\u00f6\u012b\u0133\u013a\u0141\2,\3\3\5\4\7\5\t\6\13\7\r\b\17\t"+
		"\21\n\23\13\25\f\27\2\31\r\33\16\35\17\37\20!\21#\22%\23\'\24)\25+\26"+
		"-\27/\30\61\31\63\32\65\33\67\349\35;\36=\37? A!C\"E#G$I%K&M\'O(Q)S*U"+
		"+\3\2\b\3\2\62;\5\2\f\f\17\17??\4\2\f\f\17\17\4\2\13\13\"\"\6\2&&C\\a"+
		"ac|\6\2\62;C\\aac|\2\u0184\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2"+
		"\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2"+
		"\25\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2"+
		"\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2"+
		"\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3"+
		"\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2"+
		"\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2"+
		"S\3\2\2\2\2U\3\2\2\2\3W\3\2\2\2\5Y\3\2\2\2\7[\3\2\2\2\t]\3\2\2\2\13_\3"+
		"\2\2\2\ra\3\2\2\2\17c\3\2\2\2\21e\3\2\2\2\23h\3\2\2\2\25k\3\2\2\2\27n"+
		"\3\2\2\2\31q\3\2\2\2\33v\3\2\2\2\35\u0081\3\2\2\2\37\u008d\3\2\2\2!\u009b"+
		"\3\2\2\2#\u00ab\3\2\2\2%\u00be\3\2\2\2\'\u00c5\3\2\2\2)\u00cb\3\2\2\2"+
		"+\u00d1\3\2\2\2-\u00d7\3\2\2\2/\u00e0\3\2\2\2\61\u00e3\3\2\2\2\63\u00e8"+
		"\3\2\2\2\65\u00ee\3\2\2\2\67\u00f2\3\2\2\29\u00fb\3\2\2\2;\u0103\3\2\2"+
		"\2=\u0107\3\2\2\2?\u0110\3\2\2\2A\u0113\3\2\2\2C\u0117\3\2\2\2E\u011d"+
		"\3\2\2\2G\u0146\3\2\2\2I\u014d\3\2\2\2K\u0151\3\2\2\2M\u0156\3\2\2\2O"+
		"\u015c\3\2\2\2Q\u0162\3\2\2\2S\u0165\3\2\2\2U\u016c\3\2\2\2WX\7*\2\2X"+
		"\4\3\2\2\2YZ\7+\2\2Z\6\3\2\2\2[\\\7?\2\2\\\b\3\2\2\2]^\7]\2\2^\n\3\2\2"+
		"\2_`\7_\2\2`\f\3\2\2\2ab\7}\2\2b\16\3\2\2\2cd\7\177\2\2d\20\3\2\2\2ef"+
		"\7(\2\2fg\7(\2\2g\22\3\2\2\2hi\7~\2\2ij\7~\2\2j\24\3\2\2\2kl\7?\2\2lm"+
		"\7?\2\2m\26\3\2\2\2no\t\2\2\2o\30\3\2\2\2pr\5\27\f\2qp\3\2\2\2rs\3\2\2"+
		"\2sq\3\2\2\2st\3\2\2\2t\32\3\2\2\2uw\5\27\f\2vu\3\2\2\2wx\3\2\2\2xv\3"+
		"\2\2\2xy\3\2\2\2yz\3\2\2\2z~\7\60\2\2{}\5\27\f\2|{\3\2\2\2}\u0080\3\2"+
		"\2\2~|\3\2\2\2~\177\3\2\2\2\177\34\3\2\2\2\u0080~\3\2\2\2\u0081\u0089"+
		"\7%\2\2\u0082\u0086\n\3\2\2\u0083\u0085\n\4\2\2\u0084\u0083\3\2\2\2\u0085"+
		"\u0088\3\2\2\2\u0086\u0084\3\2\2\2\u0086\u0087\3\2\2\2\u0087\u008a\3\2"+
		"\2\2\u0088\u0086\3\2\2\2\u0089\u0082\3\2\2\2\u0089\u008a\3\2\2\2\u008a"+
		"\u008b\3\2\2\2\u008b\u008c\b\17\2\2\u008c\36\3\2\2\2\u008d\u008e\7%\2"+
		"\2\u008e\u008f\7?\2\2\u008f\u0093\3\2\2\2\u0090\u0092\13\2\2\2\u0091\u0090"+
		"\3\2\2\2\u0092\u0095\3\2\2\2\u0093\u0094\3\2\2\2\u0093\u0091\3\2\2\2\u0094"+
		"\u0096\3\2\2\2\u0095\u0093\3\2\2\2\u0096\u0097\7?\2\2\u0097\u0098\7%\2"+
		"\2\u0098\u0099\3\2\2\2\u0099\u009a\b\20\2\2\u009a \3\2\2\2\u009b\u009c"+
		"\7b\2\2\u009c\u009d\7b\2\2\u009d\u009e\7b\2\2\u009e\u00a2\3\2\2\2\u009f"+
		"\u00a1\13\2\2\2\u00a0\u009f\3\2\2\2\u00a1\u00a4\3\2\2\2\u00a2\u00a3\3"+
		"\2\2\2\u00a2\u00a0\3\2\2\2\u00a3\u00a5\3\2\2\2\u00a4\u00a2\3\2\2\2\u00a5"+
		"\u00a6\7b\2\2\u00a6\u00a7\7b\2\2\u00a7\u00a8\7b\2\2\u00a8\u00a9\3\2\2"+
		"\2\u00a9\u00aa\b\21\2\2\u00aa\"\3\2\2\2\u00ab\u00ac\7$\2\2\u00ac\u00ad"+
		"\7$\2\2\u00ad\u00ae\7$\2\2\u00ae\u00b4\3\2\2\2\u00af\u00b0\7^\2\2\u00b0"+
		"\u00b3\7$\2\2\u00b1\u00b3\13\2\2\2\u00b2\u00af\3\2\2\2\u00b2\u00b1\3\2"+
		"\2\2\u00b3\u00b6\3\2\2\2\u00b4\u00b5\3\2\2\2\u00b4\u00b2\3\2\2\2\u00b5"+
		"\u00b7\3\2\2\2\u00b6\u00b4\3\2\2\2\u00b7\u00b8\7$\2\2\u00b8\u00b9\7$\2"+
		"\2\u00b9\u00ba\7$\2\2\u00ba\u00bb\3\2\2\2\u00bb\u00bc\b\22\2\2\u00bc$"+
		"\3\2\2\2\u00bd\u00bf\7\17\2\2\u00be\u00bd\3\2\2\2\u00be\u00bf\3\2\2\2"+
		"\u00bf\u00c0\3\2\2\2\u00c0\u00c1\7\f\2\2\u00c1\u00c2\3\2\2\2\u00c2\u00c3"+
		"\b\23\2\2\u00c3&\3\2\2\2\u00c4\u00c6\t\5\2\2\u00c5\u00c4\3\2\2\2\u00c6"+
		"\u00c7\3\2\2\2\u00c7\u00c5\3\2\2\2\u00c7\u00c8\3\2\2\2\u00c8\u00c9\3\2"+
		"\2\2\u00c9\u00ca\b\24\2\2\u00ca(\3\2\2\2\u00cb\u00cc\7d\2\2\u00cc\u00cd"+
		"\7g\2\2\u00cd\u00ce\7i\2\2\u00ce\u00cf\7k\2\2\u00cf\u00d0\7p\2\2\u00d0"+
		"*\3\2\2\2\u00d1\u00d2\7e\2\2\u00d2\u00d3\7c\2\2\u00d3\u00d4\7v\2\2\u00d4"+
		"\u00d5\7e\2\2\u00d5\u00d6\7j\2\2\u00d6,\3\2\2\2\u00d7\u00d9\7)\2\2\u00d8"+
		"\u00da\7^\2\2\u00d9\u00d8\3\2\2\2\u00d9\u00da\3\2\2\2\u00da\u00dc\3\2"+
		"\2\2\u00db\u00dd\13\2\2\2\u00dc\u00db\3\2\2\2\u00dc\u00dd\3\2\2\2\u00dd"+
		"\u00de\3\2\2\2\u00de\u00df\7)\2\2\u00df.\3\2\2\2\u00e0\u00e1\7f\2\2\u00e1"+
		"\u00e2\7q\2\2\u00e2\60\3\2\2\2\u00e3\u00e4\7g\2\2\u00e4\u00e5\7n\2\2\u00e5"+
		"\u00e6\7u\2\2\u00e6\u00e7\7g\2\2\u00e7\62\3\2\2\2\u00e8\u00e9\7g\2\2\u00e9"+
		"\u00ea\7n\2\2\u00ea\u00eb\7u\2\2\u00eb\u00ec\7k\2\2\u00ec\u00ed\7h\2\2"+
		"\u00ed\64\3\2\2\2\u00ee\u00ef\7g\2\2\u00ef\u00f0\7p\2\2\u00f0\u00f1\7"+
		"f\2\2\u00f1\66\3\2\2\2\u00f2\u00f6\7b\2\2\u00f3\u00f5\13\2\2\2\u00f4\u00f3"+
		"\3\2\2\2\u00f5\u00f8\3\2\2\2\u00f6\u00f7\3\2\2\2\u00f6\u00f4\3\2\2\2\u00f7"+
		"\u00f9\3\2\2\2\u00f8\u00f6\3\2\2\2\u00f9\u00fa\7b\2\2\u00fa8\3\2\2\2\u00fb"+
		"\u00fc\7h\2\2\u00fc\u00fd\7k\2\2\u00fd\u00fe\7p\2\2\u00fe\u00ff\7c\2\2"+
		"\u00ff\u0100\7n\2\2\u0100\u0101\7n\2\2\u0101\u0102\7{\2\2\u0102:\3\2\2"+
		"\2\u0103\u0104\7h\2\2\u0104\u0105\7q\2\2\u0105\u0106\7t\2\2\u0106<\3\2"+
		"\2\2\u0107\u0108\7h\2\2\u0108\u0109\7w\2\2\u0109\u010a\7p\2\2\u010a\u010b"+
		"\7e\2\2\u010b\u010c\7v\2\2\u010c\u010d\7k\2\2\u010d\u010e\7q\2\2\u010e"+
		"\u010f\7p\2\2\u010f>\3\2\2\2\u0110\u0111\7k\2\2\u0111\u0112\7h\2\2\u0112"+
		"@\3\2\2\2\u0113\u0114\7n\2\2\u0114\u0115\7g\2\2\u0115\u0116\7v\2\2\u0116"+
		"B\3\2\2\2\u0117\u0118\7o\2\2\u0118\u0119\7c\2\2\u0119\u011a\7e\2\2\u011a"+
		"\u011b\7t\2\2\u011b\u011c\7q\2\2\u011cD\3\2\2\2\u011d\u0141\7$\2\2\u011e"+
		"\u011f\7^\2\2\u011f\u0140\7^\2\2\u0120\u0121\7^\2\2\u0121\u0140\7$\2\2"+
		"\u0122\u0123\7&\2\2\u0123\u0124\7*\2\2\u0124\u013a\3\2\2\2\u0125\u0126"+
		"\7&\2\2\u0126\u0127\7*\2\2\u0127\u012b\3\2\2\2\u0128\u012a\13\2\2\2\u0129"+
		"\u0128\3\2\2\2\u012a\u012d\3\2\2\2\u012b\u012c\3\2\2\2\u012b\u0129\3\2"+
		"\2\2\u012c\u012e\3\2\2\2\u012d\u012b\3\2\2\2\u012e\u0139\7+\2\2\u012f"+
		"\u0133\7$\2\2\u0130\u0132\13\2\2\2\u0131\u0130\3\2\2\2\u0132\u0135\3\2"+
		"\2\2\u0133\u0134\3\2\2\2\u0133\u0131\3\2\2\2\u0134\u0136\3\2\2\2\u0135"+
		"\u0133\3\2\2\2\u0136\u0139\7$\2\2\u0137\u0139\13\2\2\2\u0138\u0125\3\2"+
		"\2\2\u0138\u012f\3\2\2\2\u0138\u0137\3\2\2\2\u0139\u013c\3\2\2\2\u013a"+
		"\u013b\3\2\2\2\u013a\u0138\3\2\2\2\u013b\u013d\3\2\2\2\u013c\u013a\3\2"+
		"\2\2\u013d\u0140\7+\2\2\u013e\u0140\13\2\2\2\u013f\u011e\3\2\2\2\u013f"+
		"\u0120\3\2\2\2\u013f\u0122\3\2\2\2\u013f\u013e\3\2\2\2\u0140\u0143\3\2"+
		"\2\2\u0141\u0142\3\2\2\2\u0141\u013f\3\2\2\2\u0142\u0144\3\2\2\2\u0143"+
		"\u0141\3\2\2\2\u0144\u0145\7$\2\2\u0145F\3\2\2\2\u0146\u0147\7u\2\2\u0147"+
		"\u0148\7v\2\2\u0148\u0149\7t\2\2\u0149\u014a\7w\2\2\u014a\u014b\7e\2\2"+
		"\u014b\u014c\7v\2\2\u014cH\3\2\2\2\u014d\u014e\7v\2\2\u014e\u014f\7t\2"+
		"\2\u014f\u0150\7{\2\2\u0150J\3\2\2\2\u0151\u0152\7v\2\2\u0152\u0153\7"+
		"{\2\2\u0153\u0154\7r\2\2\u0154\u0155\7g\2\2\u0155L\3\2\2\2\u0156\u0157"+
		"\7y\2\2\u0157\u0158\7j\2\2\u0158\u0159\7g\2\2\u0159\u015a\7t\2\2\u015a"+
		"\u015b\7g\2\2\u015bN\3\2\2\2\u015c\u015d\7y\2\2\u015d\u015e\7j\2\2\u015e"+
		"\u015f\7k\2\2\u015f\u0160\7n\2\2\u0160\u0161\7g\2\2\u0161P\3\2\2\2\u0162"+
		"\u0163\7<\2\2\u0163\u0164\7<\2\2\u0164R\3\2\2\2\u0165\u0169\t\6\2\2\u0166"+
		"\u0168\t\7\2\2\u0167\u0166\3\2\2\2\u0168\u016b\3\2\2\2\u0169\u0167\3\2"+
		"\2\2\u0169\u016a\3\2\2\2\u016aT\3\2\2\2\u016b\u0169\3\2\2\2\u016c\u016d"+
		"\13\2\2\2\u016dV\3\2\2\2\30\2sx~\u0086\u0089\u0093\u00a2\u00b2\u00b4\u00be"+
		"\u00c7\u00d9\u00dc\u00f6\u012b\u0133\u0138\u013a\u013f\u0141\u0169\3\b"+
		"\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}