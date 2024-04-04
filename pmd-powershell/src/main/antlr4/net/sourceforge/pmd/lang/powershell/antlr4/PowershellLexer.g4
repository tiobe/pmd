lexer grammar PowershellLexer;

channels { COMMENTS_CHANNEL }

// Case-insensitive alphabet
fragment A: [aA];
fragment B: [bB];
fragment C: [cC];
fragment D: [dD];
fragment E: [eE];
fragment F: [fF];
fragment G: [gG];
fragment H: [hH];
fragment I: [iI];
fragment J: [jJ];
fragment K: [kK];
fragment L: [lL];
fragment M: [mM];
fragment N: [nN];
fragment O: [oO];
fragment P: [pP];
fragment Q: [qQ];
fragment R: [rR];
fragment S: [sS];
fragment T: [tT];
fragment U: [uU];
fragment V: [vV];
fragment W: [wW];
fragment X: [xX];
fragment Y: [yY];
fragment Z: [zZ];

// B.1.5 Keywords

// Note: Because Powershell is case-insensitive, keywords are built out of the above case-insensitive
// alphabet rules.

KEYWORD
   : BEGIN
   | BREAK
   | CATCH
   | CLASS
   | CONTINUE
   | DATA
   | DEFINE
   | DO
   | DYNAMIC_PARAM
   | ELSE
   | ELSEIF
   | END
   | EXIT
   | FILTER
   | FINALLY
   | FOR
   | FOREACH
   | FROM
   | FUNCTION
   | IF
   | IN
   | INLINE_SCRIPT
   | PARALLEL
   | PARAM
   | PROCESS
   | RETURN
   | SWITCH
   | THROW
   | TRAP
   | TRY
   | UNTIL
   | USING
   | VAR
   | WHILE
   | WORKFLOW
   ;

BREAK: B R E A K;
CATCH: C A T C H;
CLASS: C L A S S;
CONTINUE: C O N T I N U E;
DATA: D A T A;
DEFINE: D E F I N E;
DO: D O;
FILTER: F I L T E R;
FINALLY: F I N A L L Y;
FOREACH: F O R E A C H;
FROM: F R O M;
IN: I N;
PARAM: P A R A M;
RETURN: R E T U R N;
THROW: T H R O W;
TRAP: T R A P;
TRY: T R Y;
UNTIL: U N T I L;
USING: U S I N G;
VAR: V A R;
WHILE: W H I L E;
WORKFLOW: W O R K F L O W;
ELSE: E L S E;
ELSEIF: E L S E I F;
END: E N D;
EXIT: E X I T;
FOR: F O R;
FUNCTION: F U N C T I O N;
IF: I F;
INLINE_SCRIPT: I N L I N E S C R I P T;
LONG_TYPE_SUFFIX: L;
PARALLEL: P A R A L L E L;
DYNAMIC_PARAM: D Y N A M I C P A R A M;
BEGIN: B E G I N;
PROCESS: P R O C E S S;
SWITCH: S W I T C H;

AND: A N D;
BAND: B A N D;
BNOT: B N O T;
BOR: B O R;
BXOR: B X O R;
NOT: N O T;
OR: O R;
XOR: X O R;

BACKSLASH: '\\';
COLON: ':';
COMMA: ',';
PLUS: '+';
EQUALS: '=';
BACKTICK: '`';
QUESTION_MARK: '?';
UNDERSCORE: '_';
ENDASH: '\u2013';
EMDASH: '\u2014';
HORIZONTAL_BAR: '\u2015';

NUMERIC_MULTIPLIER
   : K B
   | M B
   | G B
   | T B
   | P B
   ;

fragment DEC_DGT
   : [0-9_]
   ;

fragment BIN_DGT
   : [0-1_]
   ;

fragment OCT_DGT
   : [0-7_]
   ;

fragment HEX_DGT
   : [0-9a-f_]
   ;

R_PAREN
   : ')'
   {
        if (!_modeStack.isEmpty()) {
            popMode();
        }
   }
   ;

L_PAREN
   : '('
   ;

DASH
   : '-'
   | ENDASH
   | EMDASH
   | HORIZONTAL_BAR
   ;

DASHDASH
   : DASH DASH
   ;

DECIMAL_TYPE_SUFFIX
   : D
   | L
   ;

DOLLAR
   : '$'
   ;

// B.1.6 Variables
VARIABLE
   : VARIABLE_PART ('.' VARIABLE_PART)*
   ;

BRACED_VARIABLE
   : '${' VARIABLE_SCOPE? BRACED_VARIABLE_CHARACTER+ '}'
   ;

fragment VARIABLE_CHARACTER
   : UNICODE_LETTER_OR_DIGIT
   | UNDERSCORE
   | QUESTION_MARK
   ;

fragment BRACED_VARIABLE_CHARACTER
   : ~ ('}' | '`')
   | ESCAPED_CHARACTER
   ;

fragment VARIABLE_PART
   : DOLLAR DOLLAR
   | DOLLAR QUESTION_MARK
   | DOLLAR '^'
   | DOLLAR VARIABLE_SCOPE? VARIABLE_CHARACTER+
   | '@' VARIABLE_SCOPE? VARIABLE_CHARACTER+
   | BRACED_VARIABLE
   ;

VARIABLE_SCOPE
   : G L O B A L ':'
   | L O C A L ':'
   | P R I V A T E ':'
   | S C R I P T ':'
   | U S I N G ':'
   | W O R K F L O W ':'
   | VARIABLE_NAMESPACE
   ;

VARIABLE_NAMESPACE
   : VARIABLE_CHARACTER+ ':'
   ;

fragment GENERIC_TOKEN
   : GENERIC_TOKEN_PART+
   ;

fragment GENERIC_TOKEN_PART
   : VARIABLE
   | GENERIC_TOKEN_CHAR
   ;

fragment GENERIC_TOKEN_CHAR
   : ~[{}();,|&$] //Any Unicode character except {   }   (   )   ;   ,   |   &   $
   | BACKTICK
   | DOUBLE_QUOTE
   | SINGLE_QUOTE
   | WHITESPACE
   | NL
   | ESCAPED_CHARACTER
   ;

// B.1.9.1 Integer Literals

INTEGER_LITERAL
   : DECIMAL_INTEGER_LITERAL
   | HEXADECIMAL_INTEGER_LITERAL
   ;

fragment DECIMAL_INTEGER_LITERAL
   : DEC_DGT+ NUMERIC_TYPE_SUFFIX? NUMERIC_MULTIPLIER?
   ;

fragment HEXADECIMAL_INTEGER_LITERAL
   : '0x' HEX_DGT+ LONG_TYPE_SUFFIX? NUMERIC_MULTIPLIER?
   ;

fragment NUMERIC_TYPE_SUFFIX
   : LONG_TYPE_SUFFIX
   | DECIMAL_TYPE_SUFFIX
   ;

// B.1.9.2 Real Literals

REAL_LITERAL
   : DEC_DGT+ '.' DEC_DGT+ EXPONENT_PART? DECIMAL_TYPE_SUFFIX? NUMERIC_MULTIPLIER?
   | '.' DEC_DGT+ EXPONENT_PART? DECIMAL_TYPE_SUFFIX? NUMERIC_MULTIPLIER?
   | DEC_DGT+ EXPONENT_PART DECIMAL_TYPE_SUFFIX? NUMERIC_MULTIPLIER?
   ;

fragment EXPONENT_PART
   : E SIGN? DEC_DGT*
   ;

fragment SIGN
   : PLUS
   | DASH
   ;

// B.1.9.3 String Literals
SINGLE_QUOTE
   : ('\u0027' | '\u2018' // Left single quotation mark (U+2018)
   | '\u2019' // Right single quotation mark (U+2019)
   | '\u201A' // Single low-9 quotation mark (U+201A)
   | '\u201B') // Single high-reversed-9 quotation mark (U+201B)
   ;

fragment DOUBLE_QUOTE
   : ('"' | '\u201C' // Left double quotation mark
   | '\u201D' // Right double quotation mark
   | '\u201E') // Double low-9 quotation mark
   ;

EXPANDABLE_STRING_START
   : DOUBLE_QUOTE
   { _input.LA(1) != '@' }? -> pushMode(EXPANDABLE_STRING_MODE)
   ;

EXPANDABLE_HERE_STRING_END
   : DOUBLE_QUOTE '@' { _input.LA(-3) == '\n' || _input.LA(-3) == '\r' }?
   ;

VERBATIM_HERE_STRING_START
   : '@' SINGLE_QUOTE -> pushMode(VERBATIM_HERE_STRING_MODE)
   ;

EXPANDABLE_HERE_STRING_START
   : '@' DOUBLE_QUOTE -> pushMode(EXPANDABLE_HERE_STRING_MODE)
   ;

VERBATIM_STRING
   : SINGLE_QUOTE VERBATIM_STRING_PART* SINGLE_QUOTE
   ;

fragment VERBATIM_STRING_PART
   : ~ ('\u0027' | '\u2018' | '\u2019' | '\u201A' | '\u201B') // == ~(SINGLE_QUOTE), cannot use lexer rule for negation (https://github.com/antlr/antlr4/issues/70)
   | SINGLE_QUOTE SINGLE_QUOTE
   | NL
   ;

// B.1.10 Simple Names

IDENTIFIER
   : ('_' | UNICODE_LETTER_OR_DIGIT) ('_' | '-' | UNICODE_LETTER_OR_DIGIT | DEC_DGT | DASH)*
   ;

SIMPLE_NAME
   : SIMPLE_NAME_FIRST_CHAR SIMPLE_NAME_CHARS
   ;

SIMPLE_NAME_FIRST_CHAR
   : UNICODE_LETTER //A Unicode character of classes Lu, Ll, Lt, Lm, or Lo
   | UNDERSCORE
   ;

SIMPLE_NAME_CHARS
   : SIMPLE_NAME_CHAR+
   ;

SIMPLE_NAME_CHAR
   : UNICODE_LETTER_OR_DIGIT // A Unicode character of classes Lu, Ll, Lt, Lm, Lo, or Nd
   | UNDERSCORE
   ;

SIGNATURE_BEGIN
   : '# SIG # Begin signature block' NL
   ;

SIGNATURE_END
   : '# SIG # End signature block' NL
   ;

// B.1.1 Line terminators

fragment CR
   : '\u000D'
   ;

fragment LF
   : '\u000A'
   ;

NL
   : (CR ~ ('\u000A') | LF | CR LF)
   -> channel(HIDDEN)
   ;

// B.1.2 Comments

COMMENT
   : (SINGLE_LINE_COMMENT | REQUIRES_COMMENT) -> channel(COMMENTS_CHANNEL)
   ;

fragment SINGLE_LINE_COMMENT
   : '#' (~ [>=\r\n] ~ [\r\n]*)? NL?
   ;

DELIMITEDCOMMENT
   : DELIMITED_COMMENT_START .*? DELIMITED_COMMENT_END -> channel(COMMENTS_CHANNEL)
   ;

DELIMITED_COMMENT_START
   : '<#' -> channel(COMMENTS_CHANNEL)
   ;

DELIMITED_COMMENT_END
   : '#>' -> channel(COMMENTS_CHANNEL)
   ;

fragment REQUIRES_COMMENT
   : '#' R E Q U I R E S WHITESPACE .*?
   ;

SIGNATUREBLOCK
   : SIGNATURE_BEGIN COMMENT+ SIGNATURE_END -> channel(COMMENTS_CHANNEL)
   ;

// B.1.3 White space

WHITESPACE
   : (Zs | Zl | Zp | '\t' | '\u000b' | '\u000c' | '`' NL)+
   -> channel(HIDDEN)
   ;

WHITESPACE_OR_NL
   : (WHITESPACE
   | NL)+
   -> channel(HIDDEN)
   ;

// Operators
OPERATOR_OR_PUNCTUATOR
   : '{'
   | '}'
   | '['
   | ']'
   | L_PAREN
   | R_PAREN
   | '@('
   | '@{'
   | '$('
   | ';'
   | '&&'
   | '||'
   | '&'
   | '|'
   | COMMA
   | '++'
   | '..'
   | '::'
   | '.'
   | '!'
   | '*'
   | '/'
   | '%'
   | PLUS
   | DASH
   | DASHDASH
   | DASH AND
   | DASH BAND
   | DASH BNOT
   | DASH BOR
   | DASH BXOR
   | DASH NOT
   | DASH OR
   | DASH XOR
   | ASSIGNMENT_OPERATOR
   | FILE_REDIRECTION_OPERATOR
   | MERGING_REDIRECTION_OPERATOR
   ;

ASSIGNMENT_OPERATOR
   : (DASH | [+*/%])? EQUALS
   ;

FILE_REDIRECTION_OPERATOR
   : [23456*]? '>' '>'?
   | '<'
   ;

MERGING_REDIRECTION_OPERATOR
   : [*123456] '>' '&' [12]
   ;

// B.1.11 Type Names

fragment TYPE_IDENTIFIER
   : TYPE_CHARACTER+
   ;

fragment TYPE_CHARACTER
   : UNICODE_LETTER_OR_DIGIT
   | UNDERSCORE
   ;

TYPE_NAME
   : TYPE_IDENTIFIER ('.' TYPE_IDENTIFIER)*
   ;

ARRAY_TYPE_NAME
   : TYPE_NAME '['
   ;

GENERIC_TYPE_NAME
   : TYPE_NAME '['
   ;

fragment GENERIC_TYPE_ARGUMENTS
   : TYPE_SPEC NL* (',' NL* WHITESPACE* TYPE_SPEC)*
   ;

TYPE_SPEC
   : ARRAY_TYPE_NAME NL* ','* ']'
   | GENERIC_TYPE_NAME NL* GENERIC_TYPE_ARGUMENTS
   | TYPE_NAME
   ;

TYPE_LITERAL
   : '[' TYPE_SPEC ']'
   ;

// Unicode class definitions from https://github.com/antlr/grammars-v4/blob/master/unicode/unicode16/classify.g4

UNICODE_LETTER
   : Lu
   | Ll
   | Lt
   | Lm
   | Lo
   ;

UNICODE_LETTER_OR_DIGIT
   : UNICODE_LETTER
   | Nd
   ;

fragment ESCAPED_CHARACTER
   : BACKTICK .
   ;

fragment Ll: [\p{Ll}];

fragment Lm: [\p{Lm}];

fragment Lo: [\p{Lo}];

fragment Lt: [\p{Lt}];

fragment Lu: [\p{Lu}];

fragment Nd: [\p{Nd}];

fragment Zl: [\p{Zl}];

fragment Zp: [\p{Zp}];

fragment Zs: [\p{Zs}];

mode VERBATIM_STRING_MODE;
fragment VERBATIM_MODE_STRING_PART
   : ~ ('\u0027' | '\u2018' | '\u2019' | '\u201A' | '\u201B') // == ~(SINGLE_QUOTE), cannot use SINGLE_QUOTE (https://github.com/antlr/antlr4/issues/70)
   | SINGLE_QUOTE SINGLE_QUOTE
   ;

VERBATIM_STRING_SECTION
   : VERBATIM_STRING_PART+
   ;

VERBATIM_STRING_END
   : SINGLE_QUOTE -> popMode, type(SINGLE_QUOTE)
   ;

mode VERBATIM_HERE_STRING_MODE;
VERBATIM_HERE_STRING_PART
   // Any Unicode character except newline and single quote
   : ~ ('\r' | '\n' | '\u0027' | '\u2018' | '\u2019' | '\u201A' | '\u201B')
   // NL followed by anything but single quote
   | NL ~ ('\u0027' | '\u2018' | '\u2019' | '\u201A' | '\u201B')
   // Single quote not preceded by NL
   | ~ ('\r' | '\n') SINGLE_QUOTE
   | NL SINGLE_QUOTE ~ ('@')
   | NL
   ;

VERBATIM_HERE_STRING_SECTION
   : VERBATIM_HERE_STRING_PART+
   ;

VERBATIM_HERE_STRING_END
   : SINGLE_QUOTE '@' { _input.LA(-3) == '\n' || _input.LA(-3) == '\r' }?
   -> popMode
   ;

mode EXPANDABLE_STRING_MODE;
EXPANDABLE_STRING_LITERAL_SECTION
   : EXPANDABLE_STRING_LITERAL_PART+
   ;

fragment EXPANDABLE_STRING_LITERAL_PART
   : ~('$' | '"' | '`') // Any Unicode character except $ double-quote-character ` (The BACKTICK character U+0060)
   | SIMPLE_NAME
   | DOLLAR ESCAPED_CHARACTER
   | ESCAPED_CHARACTER
   | DOUBLE_QUOTE DOUBLE_QUOTE
   | EXPANDABLE_STRING_TRAILING_DOLLAR
   ;

// Dollar as the last character of the string (or a line in a multiline string) does not need to be escaped
fragment EXPANDABLE_STRING_TRAILING_DOLLAR
   : DOLLAR { _input.LA(1) == '"' || _input.LA(1) == '\n' || _input.LA(1) == '\r' }?
   ;

SUBEXPR_START
   : '$('
    -> pushMode(DEFAULT_MODE)
   ;

EXPANDABLE_STRING_VARIABLE
   : VARIABLE -> type(VARIABLE)
   ;

EXPANDABLE_STRING_END
   : DOUBLE_QUOTE -> popMode
   ;

mode EXPANDABLE_HERE_STRING_MODE;
SUBEXPR_HERE_START
   : '$('
   -> pushMode(DEFAULT_MODE)
   ;

EXPANDABLE_HERE_STRING_SECTION
   : EXPANDABLE_HERE_STRING_PART+
   ;

EXPANDABLE_HERE_STRING_VARIABLE
   : VARIABLE -> type(VARIABLE)
   ;

fragment EXPANDABLE_HERE_STRING_PART
   : ~('\r' | '\n' | '$' | '@' | '"' | '\u201C' | '\u201D' | '\u201E')+
   | EXPANDABLE_HERE_STRING_TRAILING_DOLLAR
   | ~ ('\r' | '\n') DOUBLE_QUOTE
   | NL
   ;

fragment EXPANDABLE_HERE_STRING_TRAILING_DOLLAR
   : DOLLAR { _input.LA(1) == '\n' || _input.LA(1) == '\r'}? // Dollars at the end of a line do not need to be escaped
   ;

MODE_EXPANDABLE_HERE_STRING_END
   : EXPANDABLE_HERE_STRING_END -> popMode, type(EXPANDABLE_HERE_STRING_END)
   ;
