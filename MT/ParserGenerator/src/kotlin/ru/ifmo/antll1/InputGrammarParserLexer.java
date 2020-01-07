// Generated from /Users/nikita/Algo-DM-laba/MT/ParserGenerator/src/resources/realAntlr/InputGrammarParser.g4 by ANTLR 4.7.2
package ru.ifmo.antll1;

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
		SEMICOLON=9, OPEN_CLOSURE=10, CLOSE_CLOSURE=11, OPEN_BRACKET=12, CLOSE_BRACKET=13, 
		EQLUALLY=14, COMMA=15, COLON=16, OR=17, WORD=18, CODE=19, REGEXP=20, WS=21;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"GRAMMAR", "HEADER", "RULES", "START", "TOKENS", "IGNORE", "IMPORT", 
			"RETURNS", "SEMICOLON", "OPEN_CLOSURE", "CLOSE_CLOSURE", "OPEN_BRACKET", 
			"CLOSE_BRACKET", "EQLUALLY", "COMMA", "COLON", "OR", "WORD", "CODE", 
			"REGEXP", "WS"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'grammar'", "'header'", "'rules'", "'start'", "'tokens'", "'ignore'", 
			"'import'", "'returns'", "';'", "'{'", "'}'", "'('", "')'", "'='", "','", 
			"':'", "'|'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "GRAMMAR", "HEADER", "RULES", "START", "TOKENS", "IGNORE", "IMPORT", 
			"RETURNS", "SEMICOLON", "OPEN_CLOSURE", "CLOSE_CLOSURE", "OPEN_BRACKET", 
			"CLOSE_BRACKET", "EQLUALLY", "COMMA", "COLON", "OR", "WORD", "CODE", 
			"REGEXP", "WS"
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\27\u009b\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\3\2\3\2\3\2\3\2\3\2\3\2"+
		"\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3"+
		"\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7"+
		"\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3"+
		"\13\3\13\3\f\3\f\3\r\3\r\3\16\3\16\3\17\3\17\3\20\3\20\3\21\3\21\3\22"+
		"\3\22\3\23\6\23y\n\23\r\23\16\23z\3\24\3\24\6\24\177\n\24\r\24\16\24\u0080"+
		"\3\24\5\24\u0084\n\24\7\24\u0086\n\24\f\24\16\24\u0089\13\24\3\24\3\24"+
		"\3\25\3\25\6\25\u008f\n\25\r\25\16\25\u0090\3\25\3\25\3\26\6\26\u0096"+
		"\n\26\r\26\16\26\u0097\3\26\3\26\2\2\27\3\3\5\4\7\5\t\6\13\7\r\b\17\t"+
		"\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27"+
		"\3\2\6\4\2C\\c|\4\2}}\177\177\3\2$$\5\2\13\f\17\17\"\"\2\u00a0\2\3\3\2"+
		"\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17"+
		"\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2"+
		"\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3"+
		"\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\3-\3\2\2\2\5\65\3\2\2\2\7<\3"+
		"\2\2\2\tB\3\2\2\2\13H\3\2\2\2\rO\3\2\2\2\17V\3\2\2\2\21]\3\2\2\2\23e\3"+
		"\2\2\2\25g\3\2\2\2\27i\3\2\2\2\31k\3\2\2\2\33m\3\2\2\2\35o\3\2\2\2\37"+
		"q\3\2\2\2!s\3\2\2\2#u\3\2\2\2%x\3\2\2\2\'|\3\2\2\2)\u008c\3\2\2\2+\u0095"+
		"\3\2\2\2-.\7i\2\2./\7t\2\2/\60\7c\2\2\60\61\7o\2\2\61\62\7o\2\2\62\63"+
		"\7c\2\2\63\64\7t\2\2\64\4\3\2\2\2\65\66\7j\2\2\66\67\7g\2\2\678\7c\2\2"+
		"89\7f\2\29:\7g\2\2:;\7t\2\2;\6\3\2\2\2<=\7t\2\2=>\7w\2\2>?\7n\2\2?@\7"+
		"g\2\2@A\7u\2\2A\b\3\2\2\2BC\7u\2\2CD\7v\2\2DE\7c\2\2EF\7t\2\2FG\7v\2\2"+
		"G\n\3\2\2\2HI\7v\2\2IJ\7q\2\2JK\7m\2\2KL\7g\2\2LM\7p\2\2MN\7u\2\2N\f\3"+
		"\2\2\2OP\7k\2\2PQ\7i\2\2QR\7p\2\2RS\7q\2\2ST\7t\2\2TU\7g\2\2U\16\3\2\2"+
		"\2VW\7k\2\2WX\7o\2\2XY\7r\2\2YZ\7q\2\2Z[\7t\2\2[\\\7v\2\2\\\20\3\2\2\2"+
		"]^\7t\2\2^_\7g\2\2_`\7v\2\2`a\7w\2\2ab\7t\2\2bc\7p\2\2cd\7u\2\2d\22\3"+
		"\2\2\2ef\7=\2\2f\24\3\2\2\2gh\7}\2\2h\26\3\2\2\2ij\7\177\2\2j\30\3\2\2"+
		"\2kl\7*\2\2l\32\3\2\2\2mn\7+\2\2n\34\3\2\2\2op\7?\2\2p\36\3\2\2\2qr\7"+
		".\2\2r \3\2\2\2st\7<\2\2t\"\3\2\2\2uv\7~\2\2v$\3\2\2\2wy\t\2\2\2xw\3\2"+
		"\2\2yz\3\2\2\2zx\3\2\2\2z{\3\2\2\2{&\3\2\2\2|\u0087\7}\2\2}\177\n\3\2"+
		"\2~}\3\2\2\2\177\u0080\3\2\2\2\u0080~\3\2\2\2\u0080\u0081\3\2\2\2\u0081"+
		"\u0083\3\2\2\2\u0082\u0084\5\'\24\2\u0083\u0082\3\2\2\2\u0083\u0084\3"+
		"\2\2\2\u0084\u0086\3\2\2\2\u0085~\3\2\2\2\u0086\u0089\3\2\2\2\u0087\u0085"+
		"\3\2\2\2\u0087\u0088\3\2\2\2\u0088\u008a\3\2\2\2\u0089\u0087\3\2\2\2\u008a"+
		"\u008b\7\177\2\2\u008b(\3\2\2\2\u008c\u008e\7$\2\2\u008d\u008f\n\4\2\2"+
		"\u008e\u008d\3\2\2\2\u008f\u0090\3\2\2\2\u0090\u008e\3\2\2\2\u0090\u0091"+
		"\3\2\2\2\u0091\u0092\3\2\2\2\u0092\u0093\7$\2\2\u0093*\3\2\2\2\u0094\u0096"+
		"\t\5\2\2\u0095\u0094\3\2\2\2\u0096\u0097\3\2\2\2\u0097\u0095\3\2\2\2\u0097"+
		"\u0098\3\2\2\2\u0098\u0099\3\2\2\2\u0099\u009a\b\26\2\2\u009a,\3\2\2\2"+
		"\t\2z\u0080\u0083\u0087\u0090\u0097\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}