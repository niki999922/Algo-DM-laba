// Generated from /Users/nikita/Algo-DM-laba/MT/ParserGenerator/src/resources/realAntlr/InputGrammarParser.g4 by ANTLR 4.7.2
package ru.ifmo.antll1.grammar.parser;

import java.util.LinkedList;
import java.util.ArrayList;
import java.util.Collections;
import ru.ifmo.antll1.entities.*;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class InputGrammarParserLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.7.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		GRAMMAR=1, HEADER=2, RULES=3, START=4, TOKENS=5, IGNORE=6, IMPORT=7, RETURNS=8, 
		SEMICOLON=9, OPEN_CLOSURE=10, CLOSE_CLOSURE=11, OPEN_STUPID_BRACKET=12, 
		CLOSE_STUPID_BRACKET=13, OPEN_BRACKET=14, CLOSE_BRACKET=15, EQLUALLY=16, 
		COMMA=17, COLON=18, OR=19, WORDARGFUN=20, WORD=21, NUMBER=22, CODE=23, 
		REGEXP=24, WS=25, COMMENT=26, LINE_COMMENT=27;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"GRAMMAR", "HEADER", "RULES", "START", "TOKENS", "IGNORE", "IMPORT", 
			"RETURNS", "SEMICOLON", "OPEN_CLOSURE", "CLOSE_CLOSURE", "OPEN_STUPID_BRACKET", 
			"CLOSE_STUPID_BRACKET", "OPEN_BRACKET", "CLOSE_BRACKET", "EQLUALLY", 
			"COMMA", "COLON", "OR", "WORDARGFUN", "WORD", "NUMBER", "CODE", "REGEXP", 
			"WS", "COMMENT", "LINE_COMMENT"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'grammar'", "'header'", "'rules'", "'start'", "'tokens'", "'ignore'", 
			"'import'", "'returns'", "';'", "'{'", "'}'", "'['", "']'", "'('", "')'", 
			"'='", "','", "':'", "'|'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "GRAMMAR", "HEADER", "RULES", "START", "TOKENS", "IGNORE", "IMPORT", 
			"RETURNS", "SEMICOLON", "OPEN_CLOSURE", "CLOSE_CLOSURE", "OPEN_STUPID_BRACKET", 
			"CLOSE_STUPID_BRACKET", "OPEN_BRACKET", "CLOSE_BRACKET", "EQLUALLY", 
			"COMMA", "COLON", "OR", "WORDARGFUN", "WORD", "NUMBER", "CODE", "REGEXP", 
			"WS", "COMMENT", "LINE_COMMENT"
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


	public InputGrammarParserLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "InputGrammarParser.g4"; }

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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\35\u00e0\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5"+
		"\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3"+
		"\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\13\3\13\3"+
		"\f\3\f\3\r\3\r\3\16\3\16\3\17\3\17\3\20\3\20\3\21\3\21\3\22\3\22\3\23"+
		"\3\23\3\24\3\24\3\25\3\25\6\25\u008a\n\25\r\25\16\25\u008b\3\25\5\25\u008f"+
		"\n\25\7\25\u0091\n\25\f\25\16\25\u0094\13\25\3\25\3\25\3\26\3\26\7\26"+
		"\u009a\n\26\f\26\16\26\u009d\13\26\3\27\3\27\7\27\u00a1\n\27\f\27\16\27"+
		"\u00a4\13\27\3\27\5\27\u00a7\n\27\3\30\3\30\6\30\u00ab\n\30\r\30\16\30"+
		"\u00ac\3\30\5\30\u00b0\n\30\7\30\u00b2\n\30\f\30\16\30\u00b5\13\30\3\30"+
		"\3\30\3\31\3\31\6\31\u00bb\n\31\r\31\16\31\u00bc\3\31\3\31\3\32\6\32\u00c2"+
		"\n\32\r\32\16\32\u00c3\3\32\3\32\3\33\3\33\3\33\3\33\7\33\u00cc\n\33\f"+
		"\33\16\33\u00cf\13\33\3\33\3\33\3\33\3\33\3\33\3\34\3\34\3\34\3\34\7\34"+
		"\u00da\n\34\f\34\16\34\u00dd\13\34\3\34\3\34\3\u00cd\2\35\3\3\5\4\7\5"+
		"\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23"+
		"%\24\'\25)\26+\27-\30/\31\61\32\63\33\65\34\67\35\3\2\n\4\2}}\177\177"+
		"\4\2C\\c|\6\2\62;C\\aac|\3\2\63;\3\2\62;\3\2$$\5\2\13\f\17\17\"\"\4\2"+
		"\f\f\17\17\2\u00ec\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13"+
		"\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2"+
		"\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2"+
		"!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3"+
		"\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2"+
		"\39\3\2\2\2\5A\3\2\2\2\7H\3\2\2\2\tN\3\2\2\2\13T\3\2\2\2\r[\3\2\2\2\17"+
		"b\3\2\2\2\21i\3\2\2\2\23q\3\2\2\2\25s\3\2\2\2\27u\3\2\2\2\31w\3\2\2\2"+
		"\33y\3\2\2\2\35{\3\2\2\2\37}\3\2\2\2!\177\3\2\2\2#\u0081\3\2\2\2%\u0083"+
		"\3\2\2\2\'\u0085\3\2\2\2)\u0087\3\2\2\2+\u0097\3\2\2\2-\u00a6\3\2\2\2"+
		"/\u00a8\3\2\2\2\61\u00b8\3\2\2\2\63\u00c1\3\2\2\2\65\u00c7\3\2\2\2\67"+
		"\u00d5\3\2\2\29:\7i\2\2:;\7t\2\2;<\7c\2\2<=\7o\2\2=>\7o\2\2>?\7c\2\2?"+
		"@\7t\2\2@\4\3\2\2\2AB\7j\2\2BC\7g\2\2CD\7c\2\2DE\7f\2\2EF\7g\2\2FG\7t"+
		"\2\2G\6\3\2\2\2HI\7t\2\2IJ\7w\2\2JK\7n\2\2KL\7g\2\2LM\7u\2\2M\b\3\2\2"+
		"\2NO\7u\2\2OP\7v\2\2PQ\7c\2\2QR\7t\2\2RS\7v\2\2S\n\3\2\2\2TU\7v\2\2UV"+
		"\7q\2\2VW\7m\2\2WX\7g\2\2XY\7p\2\2YZ\7u\2\2Z\f\3\2\2\2[\\\7k\2\2\\]\7"+
		"i\2\2]^\7p\2\2^_\7q\2\2_`\7t\2\2`a\7g\2\2a\16\3\2\2\2bc\7k\2\2cd\7o\2"+
		"\2de\7r\2\2ef\7q\2\2fg\7t\2\2gh\7v\2\2h\20\3\2\2\2ij\7t\2\2jk\7g\2\2k"+
		"l\7v\2\2lm\7w\2\2mn\7t\2\2no\7p\2\2op\7u\2\2p\22\3\2\2\2qr\7=\2\2r\24"+
		"\3\2\2\2st\7}\2\2t\26\3\2\2\2uv\7\177\2\2v\30\3\2\2\2wx\7]\2\2x\32\3\2"+
		"\2\2yz\7_\2\2z\34\3\2\2\2{|\7*\2\2|\36\3\2\2\2}~\7+\2\2~ \3\2\2\2\177"+
		"\u0080\7?\2\2\u0080\"\3\2\2\2\u0081\u0082\7.\2\2\u0082$\3\2\2\2\u0083"+
		"\u0084\7<\2\2\u0084&\3\2\2\2\u0085\u0086\7~\2\2\u0086(\3\2\2\2\u0087\u0092"+
		"\7&\2\2\u0088\u008a\n\2\2\2\u0089\u0088\3\2\2\2\u008a\u008b\3\2\2\2\u008b"+
		"\u0089\3\2\2\2\u008b\u008c\3\2\2\2\u008c\u008e\3\2\2\2\u008d\u008f\5)"+
		"\25\2\u008e\u008d\3\2\2\2\u008e\u008f\3\2\2\2\u008f\u0091\3\2\2\2\u0090"+
		"\u0089\3\2\2\2\u0091\u0094\3\2\2\2\u0092\u0090\3\2\2\2\u0092\u0093\3\2"+
		"\2\2\u0093\u0095\3\2\2\2\u0094\u0092\3\2\2\2\u0095\u0096\7&\2\2\u0096"+
		"*\3\2\2\2\u0097\u009b\t\3\2\2\u0098\u009a\t\4\2\2\u0099\u0098\3\2\2\2"+
		"\u009a\u009d\3\2\2\2\u009b\u0099\3\2\2\2\u009b\u009c\3\2\2\2\u009c,\3"+
		"\2\2\2\u009d\u009b\3\2\2\2\u009e\u00a2\t\5\2\2\u009f\u00a1\t\6\2\2\u00a0"+
		"\u009f\3\2\2\2\u00a1\u00a4\3\2\2\2\u00a2\u00a0\3\2\2\2\u00a2\u00a3\3\2"+
		"\2\2\u00a3\u00a7\3\2\2\2\u00a4\u00a2\3\2\2\2\u00a5\u00a7\7\62\2\2\u00a6"+
		"\u009e\3\2\2\2\u00a6\u00a5\3\2\2\2\u00a7.\3\2\2\2\u00a8\u00b3\7}\2\2\u00a9"+
		"\u00ab\n\2\2\2\u00aa\u00a9\3\2\2\2\u00ab\u00ac\3\2\2\2\u00ac\u00aa\3\2"+
		"\2\2\u00ac\u00ad\3\2\2\2\u00ad\u00af\3\2\2\2\u00ae\u00b0\5/\30\2\u00af"+
		"\u00ae\3\2\2\2\u00af\u00b0\3\2\2\2\u00b0\u00b2\3\2\2\2\u00b1\u00aa\3\2"+
		"\2\2\u00b2\u00b5\3\2\2\2\u00b3\u00b1\3\2\2\2\u00b3\u00b4\3\2\2\2\u00b4"+
		"\u00b6\3\2\2\2\u00b5\u00b3\3\2\2\2\u00b6\u00b7\7\177\2\2\u00b7\60\3\2"+
		"\2\2\u00b8\u00ba\7$\2\2\u00b9\u00bb\n\7\2\2\u00ba\u00b9\3\2\2\2\u00bb"+
		"\u00bc\3\2\2\2\u00bc\u00ba\3\2\2\2\u00bc\u00bd\3\2\2\2\u00bd\u00be\3\2"+
		"\2\2\u00be\u00bf\7$\2\2\u00bf\62\3\2\2\2\u00c0\u00c2\t\b\2\2\u00c1\u00c0"+
		"\3\2\2\2\u00c2\u00c3\3\2\2\2\u00c3\u00c1\3\2\2\2\u00c3\u00c4\3\2\2\2\u00c4"+
		"\u00c5\3\2\2\2\u00c5\u00c6\b\32\2\2\u00c6\64\3\2\2\2\u00c7\u00c8\7\61"+
		"\2\2\u00c8\u00c9\7,\2\2\u00c9\u00cd\3\2\2\2\u00ca\u00cc\13\2\2\2\u00cb"+
		"\u00ca\3\2\2\2\u00cc\u00cf\3\2\2\2\u00cd\u00ce\3\2\2\2\u00cd\u00cb\3\2"+
		"\2\2\u00ce\u00d0\3\2\2\2\u00cf\u00cd\3\2\2\2\u00d0\u00d1\7,\2\2\u00d1"+
		"\u00d2\7\61\2\2\u00d2\u00d3\3\2\2\2\u00d3\u00d4\b\33\2\2\u00d4\66\3\2"+
		"\2\2\u00d5\u00d6\7\61\2\2\u00d6\u00d7\7\61\2\2\u00d7\u00db\3\2\2\2\u00d8"+
		"\u00da\n\t\2\2\u00d9\u00d8\3\2\2\2\u00da\u00dd\3\2\2\2\u00db\u00d9\3\2"+
		"\2\2\u00db\u00dc\3\2\2\2\u00dc\u00de\3\2\2\2\u00dd\u00db\3\2\2\2\u00de"+
		"\u00df\b\34\2\2\u00df8\3\2\2\2\20\2\u008b\u008e\u0092\u009b\u00a2\u00a6"+
		"\u00ac\u00af\u00b3\u00bc\u00c3\u00cd\u00db\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}