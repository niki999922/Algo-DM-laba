// Generated from /Users/nikita/Algo-DM-laba/MT/ParserGenerator/src/resources/realAntlr/InputGrammarParser.g4 by ANTLR 4.7.2
package ru.ifmo.antll1.grammar.parser;

import java.util.LinkedList;
import java.util.ArrayList;
import java.util.Collections;
import ru.ifmo.antll1.*;

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
		COMMA=17, COLON=18, OR=19, WORD=20, CODE=21, REGEXP=22, WS=23, COMMENT=24, 
		LINE_COMMENT=25;
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
			"COMMA", "COLON", "OR", "WORD", "CODE", "REGEXP", "WS", "COMMENT", "LINE_COMMENT"
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
			"COMMA", "COLON", "OR", "WORD", "CODE", "REGEXP", "WS", "COMMENT", "LINE_COMMENT"
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\33\u00c2\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6"+
		"\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3"+
		"\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\13\3\13\3\f\3\f\3\r\3\r\3\16"+
		"\3\16\3\17\3\17\3\20\3\20\3\21\3\21\3\22\3\22\3\23\3\23\3\24\3\24\3\25"+
		"\3\25\7\25\u0086\n\25\f\25\16\25\u0089\13\25\3\26\3\26\6\26\u008d\n\26"+
		"\r\26\16\26\u008e\3\26\5\26\u0092\n\26\7\26\u0094\n\26\f\26\16\26\u0097"+
		"\13\26\3\26\3\26\3\27\3\27\6\27\u009d\n\27\r\27\16\27\u009e\3\27\3\27"+
		"\3\30\6\30\u00a4\n\30\r\30\16\30\u00a5\3\30\3\30\3\31\3\31\3\31\3\31\7"+
		"\31\u00ae\n\31\f\31\16\31\u00b1\13\31\3\31\3\31\3\31\3\31\3\31\3\32\3"+
		"\32\3\32\3\32\7\32\u00bc\n\32\f\32\16\32\u00bf\13\32\3\32\3\32\3\u00af"+
		"\2\33\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35"+
		"\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33\3\2\b\3\2C|\4\2"+
		"\62;C|\4\2}}\177\177\3\2$$\5\2\13\f\17\17\"\"\4\2\f\f\17\17\2\u00c9\2"+
		"\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2"+
		"\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2"+
		"\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2"+
		"\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2"+
		"\2\61\3\2\2\2\2\63\3\2\2\2\3\65\3\2\2\2\5=\3\2\2\2\7D\3\2\2\2\tJ\3\2\2"+
		"\2\13P\3\2\2\2\rW\3\2\2\2\17^\3\2\2\2\21e\3\2\2\2\23m\3\2\2\2\25o\3\2"+
		"\2\2\27q\3\2\2\2\31s\3\2\2\2\33u\3\2\2\2\35w\3\2\2\2\37y\3\2\2\2!{\3\2"+
		"\2\2#}\3\2\2\2%\177\3\2\2\2\'\u0081\3\2\2\2)\u0083\3\2\2\2+\u008a\3\2"+
		"\2\2-\u009a\3\2\2\2/\u00a3\3\2\2\2\61\u00a9\3\2\2\2\63\u00b7\3\2\2\2\65"+
		"\66\7i\2\2\66\67\7t\2\2\678\7c\2\289\7o\2\29:\7o\2\2:;\7c\2\2;<\7t\2\2"+
		"<\4\3\2\2\2=>\7j\2\2>?\7g\2\2?@\7c\2\2@A\7f\2\2AB\7g\2\2BC\7t\2\2C\6\3"+
		"\2\2\2DE\7t\2\2EF\7w\2\2FG\7n\2\2GH\7g\2\2HI\7u\2\2I\b\3\2\2\2JK\7u\2"+
		"\2KL\7v\2\2LM\7c\2\2MN\7t\2\2NO\7v\2\2O\n\3\2\2\2PQ\7v\2\2QR\7q\2\2RS"+
		"\7m\2\2ST\7g\2\2TU\7p\2\2UV\7u\2\2V\f\3\2\2\2WX\7k\2\2XY\7i\2\2YZ\7p\2"+
		"\2Z[\7q\2\2[\\\7t\2\2\\]\7g\2\2]\16\3\2\2\2^_\7k\2\2_`\7o\2\2`a\7r\2\2"+
		"ab\7q\2\2bc\7t\2\2cd\7v\2\2d\20\3\2\2\2ef\7t\2\2fg\7g\2\2gh\7v\2\2hi\7"+
		"w\2\2ij\7t\2\2jk\7p\2\2kl\7u\2\2l\22\3\2\2\2mn\7=\2\2n\24\3\2\2\2op\7"+
		"}\2\2p\26\3\2\2\2qr\7\177\2\2r\30\3\2\2\2st\7]\2\2t\32\3\2\2\2uv\7_\2"+
		"\2v\34\3\2\2\2wx\7*\2\2x\36\3\2\2\2yz\7+\2\2z \3\2\2\2{|\7?\2\2|\"\3\2"+
		"\2\2}~\7.\2\2~$\3\2\2\2\177\u0080\7<\2\2\u0080&\3\2\2\2\u0081\u0082\7"+
		"~\2\2\u0082(\3\2\2\2\u0083\u0087\t\2\2\2\u0084\u0086\t\3\2\2\u0085\u0084"+
		"\3\2\2\2\u0086\u0089\3\2\2\2\u0087\u0085\3\2\2\2\u0087\u0088\3\2\2\2\u0088"+
		"*\3\2\2\2\u0089\u0087\3\2\2\2\u008a\u0095\7}\2\2\u008b\u008d\n\4\2\2\u008c"+
		"\u008b\3\2\2\2\u008d\u008e\3\2\2\2\u008e\u008c\3\2\2\2\u008e\u008f\3\2"+
		"\2\2\u008f\u0091\3\2\2\2\u0090\u0092\5+\26\2\u0091\u0090\3\2\2\2\u0091"+
		"\u0092\3\2\2\2\u0092\u0094\3\2\2\2\u0093\u008c\3\2\2\2\u0094\u0097\3\2"+
		"\2\2\u0095\u0093\3\2\2\2\u0095\u0096\3\2\2\2\u0096\u0098\3\2\2\2\u0097"+
		"\u0095\3\2\2\2\u0098\u0099\7\177\2\2\u0099,\3\2\2\2\u009a\u009c\7$\2\2"+
		"\u009b\u009d\n\5\2\2\u009c\u009b\3\2\2\2\u009d\u009e\3\2\2\2\u009e\u009c"+
		"\3\2\2\2\u009e\u009f\3\2\2\2\u009f\u00a0\3\2\2\2\u00a0\u00a1\7$\2\2\u00a1"+
		".\3\2\2\2\u00a2\u00a4\t\6\2\2\u00a3\u00a2\3\2\2\2\u00a4\u00a5\3\2\2\2"+
		"\u00a5\u00a3\3\2\2\2\u00a5\u00a6\3\2\2\2\u00a6\u00a7\3\2\2\2\u00a7\u00a8"+
		"\b\30\2\2\u00a8\60\3\2\2\2\u00a9\u00aa\7\61\2\2\u00aa\u00ab\7,\2\2\u00ab"+
		"\u00af\3\2\2\2\u00ac\u00ae\13\2\2\2\u00ad\u00ac\3\2\2\2\u00ae\u00b1\3"+
		"\2\2\2\u00af\u00b0\3\2\2\2\u00af\u00ad\3\2\2\2\u00b0\u00b2\3\2\2\2\u00b1"+
		"\u00af\3\2\2\2\u00b2\u00b3\7,\2\2\u00b3\u00b4\7\61\2\2\u00b4\u00b5\3\2"+
		"\2\2\u00b5\u00b6\b\31\2\2\u00b6\62\3\2\2\2\u00b7\u00b8\7\61\2\2\u00b8"+
		"\u00b9\7\61\2\2\u00b9\u00bd\3\2\2\2\u00ba\u00bc\n\7\2\2\u00bb\u00ba\3"+
		"\2\2\2\u00bc\u00bf\3\2\2\2\u00bd\u00bb\3\2\2\2\u00bd\u00be\3\2\2\2\u00be"+
		"\u00c0\3\2\2\2\u00bf\u00bd\3\2\2\2\u00c0\u00c1\b\32\2\2\u00c1\64\3\2\2"+
		"\2\13\2\u0087\u008e\u0091\u0095\u009e\u00a5\u00af\u00bd\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}