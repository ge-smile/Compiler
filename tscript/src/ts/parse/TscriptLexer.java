// Generated from Tscript.g by ANTLR 4.4

  package ts.parse;
  import ts.Location;
  import ts.tree.*;
  import static ts.parse.TreeBuilder.*;
  import java.util.List;
  import java.util.ArrayList;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class TscriptLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.4", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		NUMERIC_LITERAL=1, STRING_LITERAL=2, BOOLEANL_LITERAL=3, NULLL_LITERAL=4, 
		NaN_LITERAL=5, LPAREN=6, RPAREN=7, SEMICOLON=8, EQUAL=9, PLUS=10, MINUS=11, 
		ASTERISK=12, SLASH=13, NOT=14, EQUALITY=15, SMALLER=16, LARGER=17, COMMA=18, 
		PRINT=19, VAR=20, IDENTIFIER=21, WhiteSpace=22;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"'\\u0000'", "'\\u0001'", "'\\u0002'", "'\\u0003'", "'\\u0004'", "'\\u0005'", 
		"'\\u0006'", "'\\u0007'", "'\b'", "'\t'", "'\n'", "'\\u000B'", "'\f'", 
		"'\r'", "'\\u000E'", "'\\u000F'", "'\\u0010'", "'\\u0011'", "'\\u0012'", 
		"'\\u0013'", "'\\u0014'", "'\\u0015'", "'\\u0016'"
	};
	public static final String[] ruleNames = {
		"IdentifierCharacters", "SpaceTokens", "SpaceChars", "EndOfLineComment", 
		"LineTerminator", "DecimalDigit", "NonZeroDigit", "ExponentPart", "ExponentIndicator", 
		"SignedInteger", "HexIntegerLiteral", "HexDigit", "DecimalIntegerLiteral", 
		"DecimalDigits", "DecimalLiteral", "DoubleStringCharacters", "SingleStringCharacters", 
		"DoubleStringCharacter", "SingleStringCharacter", "LineContinuation", 
		"EscapeSequence", "CharacterEscapeSequence", "SingleEscapeCharacter", 
		"NonEscapeCharacter", "EscapeCharacter", "HexEscapeSequence", "UnicodeEscapeSequence", 
		"NUMERIC_LITERAL", "STRING_LITERAL", "BOOLEANL_LITERAL", "NULLL_LITERAL", 
		"NaN_LITERAL", "LPAREN", "RPAREN", "SEMICOLON", "EQUAL", "PLUS", "MINUS", 
		"ASTERISK", "SLASH", "NOT", "EQUALITY", "SMALLER", "LARGER", "COMMA", 
		"PRINT", "VAR", "IDENTIFIER", "WhiteSpace"
	};


	  // grab location info (filename/line/column) from token
	  // in order to stick into AST nodes for later error reporting
	  public Location loc(final Token token)
	  {
	    return new Location(getSourceName(), token.getLine(),
	      token.getCharPositionInLine());
	  }

	  // a program is a list of statements
	  // i.e. root of AST is stored here
	  // set by the action for the start symbol
	  private List<Statement> semanticValue;
	  public List<Statement> getSemanticValue()
	  {
	    return semanticValue;
	  }


	public TscriptLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Tscript.g"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\30\u015f\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t"+
		" \4!\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t"+
		"+\4,\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\3\2\3\2\7\2h\n"+
		"\2\f\2\16\2k\13\2\3\3\3\3\3\3\5\3p\n\3\3\4\3\4\3\5\3\5\3\5\3\5\7\5x\n"+
		"\5\f\5\16\5{\13\5\3\5\3\5\5\5\177\n\5\3\6\3\6\3\6\5\6\u0084\n\6\3\7\3"+
		"\7\3\b\3\b\3\t\3\t\3\t\3\n\3\n\3\13\3\13\3\13\3\13\3\13\5\13\u0094\n\13"+
		"\3\f\3\f\3\f\6\f\u0099\n\f\r\f\16\f\u009a\3\r\3\r\3\16\3\16\3\16\7\16"+
		"\u00a2\n\16\f\16\16\16\u00a5\13\16\5\16\u00a7\n\16\3\17\3\17\3\17\3\17"+
		"\5\17\u00ad\n\17\3\20\3\20\3\20\7\20\u00b2\n\20\f\20\16\20\u00b5\13\20"+
		"\3\20\7\20\u00b8\n\20\f\20\16\20\u00bb\13\20\3\20\3\20\3\20\7\20\u00c0"+
		"\n\20\f\20\16\20\u00c3\13\20\3\20\3\20\7\20\u00c7\n\20\f\20\16\20\u00ca"+
		"\13\20\5\20\u00cc\n\20\3\21\3\21\7\21\u00d0\n\21\f\21\16\21\u00d3\13\21"+
		"\3\22\3\22\7\22\u00d7\n\22\f\22\16\22\u00da\13\22\3\23\3\23\3\23\3\23"+
		"\5\23\u00e0\n\23\3\24\3\24\3\24\3\24\5\24\u00e6\n\24\3\25\3\25\3\25\3"+
		"\26\3\26\3\26\3\26\5\26\u00ef\n\26\3\27\3\27\5\27\u00f3\n\27\3\30\3\30"+
		"\3\31\3\31\3\32\3\32\3\32\5\32\u00fc\n\32\3\33\3\33\3\33\3\33\3\34\3\34"+
		"\3\34\3\34\3\34\3\34\3\35\3\35\5\35\u010a\n\35\3\36\3\36\7\36\u010e\n"+
		"\36\f\36\16\36\u0111\13\36\3\36\3\36\3\36\7\36\u0116\n\36\f\36\16\36\u0119"+
		"\13\36\3\36\5\36\u011c\n\36\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3"+
		"\37\5\37\u0127\n\37\3 \3 \3 \3 \3 \3!\3!\3!\3!\3\"\3\"\3#\3#\3$\3$\3%"+
		"\3%\3&\3&\3\'\3\'\3(\3(\3)\3)\3*\3*\3+\3+\3+\3,\3,\3-\3-\3.\3.\3/\3/\3"+
		"/\3/\3/\3/\3\60\3\60\3\60\3\60\3\61\3\61\3\62\6\62\u015a\n\62\r\62\16"+
		"\62\u015b\3\62\3\62\2\2\63\3\2\5\2\7\2\t\2\13\2\r\2\17\2\21\2\23\2\25"+
		"\2\27\2\31\2\33\2\35\2\37\2!\2#\2%\2\'\2)\2+\2-\2/\2\61\2\63\2\65\2\67"+
		"\29\3;\4=\5?\6A\7C\bE\tG\nI\13K\fM\rO\16Q\17S\20U\21W\22Y\23[\24]\25_"+
		"\26a\27c\30\3\2#\6\2&&C\\aac|\7\2&&\62;C\\aac|\5\2\13\13\16\16\"\"\4\2"+
		"\f\f\17\17\3\2\62;\3\2\63;\4\2GGgg\3\2--\3\2//\3\2\62\62\4\2ZZzz\5\2\62"+
		";CHch\3\2\60\60\6\2\f\f\17\17$$^^\3\2^^\6\2\f\f\17\17))^^\13\2$$))^^d"+
		"dhhppttvvxx\16\2\f\f\17\17$$))\62;^^ddhhppttvxzz\4\2wwzz\3\2zz\3\2ww\3"+
		"\2$$\3\2))\3\2**\3\2++\3\2==\3\2??\3\2,,\3\2\61\61\3\2##\3\2>>\3\2@@\3"+
		"\2..\u0167\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3"+
		"\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O\3\2\2"+
		"\2\2Q\3\2\2\2\2S\3\2\2\2\2U\3\2\2\2\2W\3\2\2\2\2Y\3\2\2\2\2[\3\2\2\2\2"+
		"]\3\2\2\2\2_\3\2\2\2\2a\3\2\2\2\2c\3\2\2\2\3e\3\2\2\2\5o\3\2\2\2\7q\3"+
		"\2\2\2\ts\3\2\2\2\13\u0083\3\2\2\2\r\u0085\3\2\2\2\17\u0087\3\2\2\2\21"+
		"\u0089\3\2\2\2\23\u008c\3\2\2\2\25\u0093\3\2\2\2\27\u0095\3\2\2\2\31\u009c"+
		"\3\2\2\2\33\u00a6\3\2\2\2\35\u00ac\3\2\2\2\37\u00cb\3\2\2\2!\u00cd\3\2"+
		"\2\2#\u00d4\3\2\2\2%\u00df\3\2\2\2\'\u00e5\3\2\2\2)\u00e7\3\2\2\2+\u00ee"+
		"\3\2\2\2-\u00f2\3\2\2\2/\u00f4\3\2\2\2\61\u00f6\3\2\2\2\63\u00fb\3\2\2"+
		"\2\65\u00fd\3\2\2\2\67\u0101\3\2\2\29\u0109\3\2\2\2;\u011b\3\2\2\2=\u0126"+
		"\3\2\2\2?\u0128\3\2\2\2A\u012d\3\2\2\2C\u0131\3\2\2\2E\u0133\3\2\2\2G"+
		"\u0135\3\2\2\2I\u0137\3\2\2\2K\u0139\3\2\2\2M\u013b\3\2\2\2O\u013d\3\2"+
		"\2\2Q\u013f\3\2\2\2S\u0141\3\2\2\2U\u0143\3\2\2\2W\u0146\3\2\2\2Y\u0148"+
		"\3\2\2\2[\u014a\3\2\2\2]\u014c\3\2\2\2_\u0152\3\2\2\2a\u0156\3\2\2\2c"+
		"\u0159\3\2\2\2ei\t\2\2\2fh\t\3\2\2gf\3\2\2\2hk\3\2\2\2ig\3\2\2\2ij\3\2"+
		"\2\2j\4\3\2\2\2ki\3\2\2\2lp\5\7\4\2mp\5\13\6\2np\5\t\5\2ol\3\2\2\2om\3"+
		"\2\2\2on\3\2\2\2p\6\3\2\2\2qr\t\4\2\2r\b\3\2\2\2st\7\61\2\2tu\7\61\2\2"+
		"uy\3\2\2\2vx\n\5\2\2wv\3\2\2\2x{\3\2\2\2yw\3\2\2\2yz\3\2\2\2z~\3\2\2\2"+
		"{y\3\2\2\2|\177\5\13\6\2}\177\7\2\2\3~|\3\2\2\2~}\3\2\2\2\177\n\3\2\2"+
		"\2\u0080\u0081\7\17\2\2\u0081\u0084\7\f\2\2\u0082\u0084\t\5\2\2\u0083"+
		"\u0080\3\2\2\2\u0083\u0082\3\2\2\2\u0084\f\3\2\2\2\u0085\u0086\t\6\2\2"+
		"\u0086\16\3\2\2\2\u0087\u0088\t\7\2\2\u0088\20\3\2\2\2\u0089\u008a\5\23"+
		"\n\2\u008a\u008b\5\25\13\2\u008b\22\3\2\2\2\u008c\u008d\t\b\2\2\u008d"+
		"\24\3\2\2\2\u008e\u0094\5\35\17\2\u008f\u0090\t\t\2\2\u0090\u0094\5\35"+
		"\17\2\u0091\u0092\t\n\2\2\u0092\u0094\5\35\17\2\u0093\u008e\3\2\2\2\u0093"+
		"\u008f\3\2\2\2\u0093\u0091\3\2\2\2\u0094\26\3\2\2\2\u0095\u0096\t\13\2"+
		"\2\u0096\u0098\t\f\2\2\u0097\u0099\5\31\r\2\u0098\u0097\3\2\2\2\u0099"+
		"\u009a\3\2\2\2\u009a\u0098\3\2\2\2\u009a\u009b\3\2\2\2\u009b\30\3\2\2"+
		"\2\u009c\u009d\t\r\2\2\u009d\32\3\2\2\2\u009e\u00a7\t\13\2\2\u009f\u00a3"+
		"\5\17\b\2\u00a0\u00a2\5\35\17\2\u00a1\u00a0\3\2\2\2\u00a2\u00a5\3\2\2"+
		"\2\u00a3\u00a1\3\2\2\2\u00a3\u00a4\3\2\2\2\u00a4\u00a7\3\2\2\2\u00a5\u00a3"+
		"\3\2\2\2\u00a6\u009e\3\2\2\2\u00a6\u009f\3\2\2\2\u00a7\34\3\2\2\2\u00a8"+
		"\u00ad\5\r\7\2\u00a9\u00aa\5\r\7\2\u00aa\u00ab\5\35\17\2\u00ab\u00ad\3"+
		"\2\2\2\u00ac\u00a8\3\2\2\2\u00ac\u00a9\3\2\2\2\u00ad\36\3\2\2\2\u00ae"+
		"\u00af\5\33\16\2\u00af\u00b3\t\16\2\2\u00b0\u00b2\5\35\17\2\u00b1\u00b0"+
		"\3\2\2\2\u00b2\u00b5\3\2\2\2\u00b3\u00b1\3\2\2\2\u00b3\u00b4\3\2\2\2\u00b4"+
		"\u00b9\3\2\2\2\u00b5\u00b3\3\2\2\2\u00b6\u00b8\5\21\t\2\u00b7\u00b6\3"+
		"\2\2\2\u00b8\u00bb\3\2\2\2\u00b9\u00b7\3\2\2\2\u00b9\u00ba\3\2\2\2\u00ba"+
		"\u00cc\3\2\2\2\u00bb\u00b9\3\2\2\2\u00bc\u00bd\t\16\2\2\u00bd\u00c1\5"+
		"\35\17\2\u00be\u00c0\5\21\t\2\u00bf\u00be\3\2\2\2\u00c0\u00c3\3\2\2\2"+
		"\u00c1\u00bf\3\2\2\2\u00c1\u00c2\3\2\2\2\u00c2\u00cc\3\2\2\2\u00c3\u00c1"+
		"\3\2\2\2\u00c4\u00c8\5\33\16\2\u00c5\u00c7\5\21\t\2\u00c6\u00c5\3\2\2"+
		"\2\u00c7\u00ca\3\2\2\2\u00c8\u00c6\3\2\2\2\u00c8\u00c9\3\2\2\2\u00c9\u00cc"+
		"\3\2\2\2\u00ca\u00c8\3\2\2\2\u00cb\u00ae\3\2\2\2\u00cb\u00bc\3\2\2\2\u00cb"+
		"\u00c4\3\2\2\2\u00cc \3\2\2\2\u00cd\u00d1\5%\23\2\u00ce\u00d0\5!\21\2"+
		"\u00cf\u00ce\3\2\2\2\u00d0\u00d3\3\2\2\2\u00d1\u00cf\3\2\2\2\u00d1\u00d2"+
		"\3\2\2\2\u00d2\"\3\2\2\2\u00d3\u00d1\3\2\2\2\u00d4\u00d8\5\'\24\2\u00d5"+
		"\u00d7\5#\22\2\u00d6\u00d5\3\2\2\2\u00d7\u00da\3\2\2\2\u00d8\u00d6\3\2"+
		"\2\2\u00d8\u00d9\3\2\2\2\u00d9$\3\2\2\2\u00da\u00d8\3\2\2\2\u00db\u00e0"+
		"\n\17\2\2\u00dc\u00dd\t\20\2\2\u00dd\u00e0\5+\26\2\u00de\u00e0\5)\25\2"+
		"\u00df\u00db\3\2\2\2\u00df\u00dc\3\2\2\2\u00df\u00de\3\2\2\2\u00e0&\3"+
		"\2\2\2\u00e1\u00e6\n\21\2\2\u00e2\u00e3\t\20\2\2\u00e3\u00e6\5+\26\2\u00e4"+
		"\u00e6\5)\25\2\u00e5\u00e1\3\2\2\2\u00e5\u00e2\3\2\2\2\u00e5\u00e4\3\2"+
		"\2\2\u00e6(\3\2\2\2\u00e7\u00e8\t\20\2\2\u00e8\u00e9\5\13\6\2\u00e9*\3"+
		"\2\2\2\u00ea\u00ef\5-\27\2\u00eb\u00ef\t\13\2\2\u00ec\u00ef\5\65\33\2"+
		"\u00ed\u00ef\5\67\34\2\u00ee\u00ea\3\2\2\2\u00ee\u00eb\3\2\2\2\u00ee\u00ec"+
		"\3\2\2\2\u00ee\u00ed\3\2\2\2\u00ef,\3\2\2\2\u00f0\u00f3\5/\30\2\u00f1"+
		"\u00f3\5\61\31\2\u00f2\u00f0\3\2\2\2\u00f2\u00f1\3\2\2\2\u00f3.\3\2\2"+
		"\2\u00f4\u00f5\t\22\2\2\u00f5\60\3\2\2\2\u00f6\u00f7\n\23\2\2\u00f7\62"+
		"\3\2\2\2\u00f8\u00fc\5/\30\2\u00f9\u00fc\5\r\7\2\u00fa\u00fc\t\24\2\2"+
		"\u00fb\u00f8\3\2\2\2\u00fb\u00f9\3\2\2\2\u00fb\u00fa\3\2\2\2\u00fc\64"+
		"\3\2\2\2\u00fd\u00fe\t\25\2\2\u00fe\u00ff\5\31\r\2\u00ff\u0100\5\31\r"+
		"\2\u0100\66\3\2\2\2\u0101\u0102\t\26\2\2\u0102\u0103\5\31\r\2\u0103\u0104"+
		"\5\31\r\2\u0104\u0105\5\31\r\2\u0105\u0106\5\31\r\2\u01068\3\2\2\2\u0107"+
		"\u010a\5\37\20\2\u0108\u010a\5\27\f\2\u0109\u0107\3\2\2\2\u0109\u0108"+
		"\3\2\2\2\u010a:\3\2\2\2\u010b\u010f\t\27\2\2\u010c\u010e\5%\23\2\u010d"+
		"\u010c\3\2\2\2\u010e\u0111\3\2\2\2\u010f\u010d\3\2\2\2\u010f\u0110\3\2"+
		"\2\2\u0110\u0112\3\2\2\2\u0111\u010f\3\2\2\2\u0112\u011c\t\27\2\2\u0113"+
		"\u0117\t\30\2\2\u0114\u0116\5#\22\2\u0115\u0114\3\2\2\2\u0116\u0119\3"+
		"\2\2\2\u0117\u0115\3\2\2\2\u0117\u0118\3\2\2\2\u0118\u011a\3\2\2\2\u0119"+
		"\u0117\3\2\2\2\u011a\u011c\t\30\2\2\u011b\u010b\3\2\2\2\u011b\u0113\3"+
		"\2\2\2\u011c<\3\2\2\2\u011d\u011e\7v\2\2\u011e\u011f\7t\2\2\u011f\u0120"+
		"\7w\2\2\u0120\u0127\7g\2\2\u0121\u0122\7h\2\2\u0122\u0123\7c\2\2\u0123"+
		"\u0124\7n\2\2\u0124\u0125\7u\2\2\u0125\u0127\7g\2\2\u0126\u011d\3\2\2"+
		"\2\u0126\u0121\3\2\2\2\u0127>\3\2\2\2\u0128\u0129\7p\2\2\u0129\u012a\7"+
		"w\2\2\u012a\u012b\7n\2\2\u012b\u012c\7n\2\2\u012c@\3\2\2\2\u012d\u012e"+
		"\7P\2\2\u012e\u012f\7c\2\2\u012f\u0130\7P\2\2\u0130B\3\2\2\2\u0131\u0132"+
		"\t\31\2\2\u0132D\3\2\2\2\u0133\u0134\t\32\2\2\u0134F\3\2\2\2\u0135\u0136"+
		"\t\33\2\2\u0136H\3\2\2\2\u0137\u0138\t\34\2\2\u0138J\3\2\2\2\u0139\u013a"+
		"\t\t\2\2\u013aL\3\2\2\2\u013b\u013c\t\n\2\2\u013cN\3\2\2\2\u013d\u013e"+
		"\t\35\2\2\u013eP\3\2\2\2\u013f\u0140\t\36\2\2\u0140R\3\2\2\2\u0141\u0142"+
		"\t\37\2\2\u0142T\3\2\2\2\u0143\u0144\t\34\2\2\u0144\u0145\t\34\2\2\u0145"+
		"V\3\2\2\2\u0146\u0147\t \2\2\u0147X\3\2\2\2\u0148\u0149\t!\2\2\u0149Z"+
		"\3\2\2\2\u014a\u014b\t\"\2\2\u014b\\\3\2\2\2\u014c\u014d\7r\2\2\u014d"+
		"\u014e\7t\2\2\u014e\u014f\7k\2\2\u014f\u0150\7p\2\2\u0150\u0151\7v\2\2"+
		"\u0151^\3\2\2\2\u0152\u0153\7x\2\2\u0153\u0154\7c\2\2\u0154\u0155\7t\2"+
		"\2\u0155`\3\2\2\2\u0156\u0157\5\3\2\2\u0157b\3\2\2\2\u0158\u015a\5\5\3"+
		"\2\u0159\u0158\3\2\2\2\u015a\u015b\3\2\2\2\u015b\u0159\3\2\2\2\u015b\u015c"+
		"\3\2\2\2\u015c\u015d\3\2\2\2\u015d\u015e\b\62\2\2\u015ed\3\2\2\2\37\2"+
		"ioy~\u0083\u0093\u009a\u00a3\u00a6\u00ac\u00b3\u00b9\u00c1\u00c8\u00cb"+
		"\u00d1\u00d8\u00df\u00e5\u00ee\u00f2\u00fb\u0109\u010f\u0117\u011b\u0126"+
		"\u015b\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}