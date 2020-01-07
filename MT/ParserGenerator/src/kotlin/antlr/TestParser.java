// Generated from /Users/nikita/Algo-DM-laba/MT/ParserGenerator/src/resources/realAntlr/Test.g4 by ANTLR 4.7.2
package antlr;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class TestParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		WORD=1, LB=2, RB=3, PLUS=4, TERM=5, WS=6, NUMBER=7;
	public static final int
		RULE_expr = 0, RULE_exprP = 1, RULE_rule1 = 2, RULE_rule2 = 3;
	private static String[] makeRuleNames() {
		return new String[] {
			"expr", "exprP", "rule1", "rule2"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, "'('", "')'", "'+'", "'lalala'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "WORD", "LB", "RB", "PLUS", "TERM", "WS", "NUMBER"
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

	@Override
	public String getGrammarFileName() { return "Test.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public TestParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class ExprContext extends ParserRuleContext {
		public int val;
		public ExprPContext exss2;
		public TerminalNode NUMBER() { return getToken(TestParser.NUMBER, 0); }
		public ExprPContext exprP() {
			return getRuleContext(ExprPContext.class,0);
		}
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TestListener ) ((TestListener)listener).enterExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TestListener ) ((TestListener)listener).exitExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TestVisitor ) return ((TestVisitor<? extends T>)visitor).visitExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		ExprContext _localctx = new ExprContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_expr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(8);
			match(NUMBER);
			{
			setState(9);
			((ExprContext)_localctx).exss2 = exprP(7);
			 Integer r = new Integer();   System.out.println("");
			    ((ExprContext)_localctx).val =  3;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExprPContext extends ParserRuleContext {
		public int i;
		public int val;
		public TerminalNode PLUS() { return getToken(TestParser.PLUS, 0); }
		public ExprPContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public ExprPContext(ParserRuleContext parent, int invokingState, int i) {
			super(parent, invokingState);
			this.i = i;
		}
		@Override public int getRuleIndex() { return RULE_exprP; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TestListener ) ((TestListener)listener).enterExprP(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TestListener ) ((TestListener)listener).exitExprP(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TestVisitor ) return ((TestVisitor<? extends T>)visitor).visitExprP(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExprPContext exprP(int i) throws RecognitionException {
		ExprPContext _localctx = new ExprPContext(_ctx, getState(), i);
		enterRule(_localctx, 2, RULE_exprP);
		try {
			setState(15);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case EOF:
				enterOuterAlt(_localctx, 1);
				{
				 val=i; 
				}
				break;
			case PLUS:
				enterOuterAlt(_localctx, 2);
				{
				setState(13);
				match(PLUS);
				 val=4; 
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Rule1Context extends ParserRuleContext {
		public StringBuilder val;
		public Rule2Context w;
		public List<Rule2Context> rule2() {
			return getRuleContexts(Rule2Context.class);
		}
		public Rule2Context rule2(int i) {
			return getRuleContext(Rule2Context.class,i);
		}
		public Rule1Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rule1; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TestListener ) ((TestListener)listener).enterRule1(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TestListener ) ((TestListener)listener).exitRule1(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TestVisitor ) return ((TestVisitor<? extends T>)visitor).visitRule1(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Rule1Context rule1() throws RecognitionException {
		Rule1Context _localctx = new Rule1Context(_ctx, getState());
		enterRule(_localctx, 4, RULE_rule1);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			((Rule1Context)_localctx).val =  new StringBuilder();
			setState(21); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(18);
				((Rule1Context)_localctx).w = rule2();
				_localctx.val.append(((Rule1Context)_localctx).w.str); System.out.println(((Rule1Context)_localctx).w.str);
				}
				}
				setState(23); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==WORD || _la==LB );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Rule2Context extends ParserRuleContext {
		public String str;
		public TerminalNode LB() { return getToken(TestParser.LB, 0); }
		public List<Rule2Context> rule2() {
			return getRuleContexts(Rule2Context.class);
		}
		public Rule2Context rule2(int i) {
			return getRuleContext(Rule2Context.class,i);
		}
		public TerminalNode RB() { return getToken(TestParser.RB, 0); }
		public List<TerminalNode> WORD() { return getTokens(TestParser.WORD); }
		public TerminalNode WORD(int i) {
			return getToken(TestParser.WORD, i);
		}
		public Rule2Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rule2; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TestListener ) ((TestListener)listener).enterRule2(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TestListener ) ((TestListener)listener).exitRule2(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TestVisitor ) return ((TestVisitor<? extends T>)visitor).visitRule2(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Rule2Context rule2() throws RecognitionException {
		Rule2Context _localctx = new Rule2Context(_ctx, getState());
		enterRule(_localctx, 6, RULE_rule2);
		int _la;
		try {
			int _alt;
			setState(44);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LB:
				enterOuterAlt(_localctx, 1);
				{
				setState(25);
				match(LB);
				setState(29);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(26);
						match(WORD);
						}
						} 
					}
					setState(31);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
				}
				setState(32);
				rule2();
				setState(36);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==WORD) {
					{
					{
					setState(33);
					match(WORD);
					}
					}
					setState(38);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(39);
				match(RB);
				setState(41);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
				case 1:
					{
					setState(40);
					rule2();
					}
					break;
				}
				}
				break;
			case WORD:
				enterOuterAlt(_localctx, 2);
				{
				setState(43);
				match(WORD);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\t\61\4\2\t\2\4\3"+
		"\t\3\4\4\t\4\4\5\t\5\3\2\3\2\3\2\3\2\3\3\3\3\3\3\5\3\22\n\3\3\4\3\4\3"+
		"\4\3\4\6\4\30\n\4\r\4\16\4\31\3\5\3\5\7\5\36\n\5\f\5\16\5!\13\5\3\5\3"+
		"\5\7\5%\n\5\f\5\16\5(\13\5\3\5\3\5\5\5,\n\5\3\5\5\5/\n\5\3\5\2\2\6\2\4"+
		"\6\b\2\2\2\62\2\n\3\2\2\2\4\21\3\2\2\2\6\23\3\2\2\2\b.\3\2\2\2\n\13\7"+
		"\t\2\2\13\f\5\4\3\2\f\r\b\2\1\2\r\3\3\2\2\2\16\22\b\3\1\2\17\20\7\6\2"+
		"\2\20\22\b\3\1\2\21\16\3\2\2\2\21\17\3\2\2\2\22\5\3\2\2\2\23\27\b\4\1"+
		"\2\24\25\5\b\5\2\25\26\b\4\1\2\26\30\3\2\2\2\27\24\3\2\2\2\30\31\3\2\2"+
		"\2\31\27\3\2\2\2\31\32\3\2\2\2\32\7\3\2\2\2\33\37\7\4\2\2\34\36\7\3\2"+
		"\2\35\34\3\2\2\2\36!\3\2\2\2\37\35\3\2\2\2\37 \3\2\2\2 \"\3\2\2\2!\37"+
		"\3\2\2\2\"&\5\b\5\2#%\7\3\2\2$#\3\2\2\2%(\3\2\2\2&$\3\2\2\2&\'\3\2\2\2"+
		"\')\3\2\2\2(&\3\2\2\2)+\7\5\2\2*,\5\b\5\2+*\3\2\2\2+,\3\2\2\2,/\3\2\2"+
		"\2-/\7\3\2\2.\33\3\2\2\2.-\3\2\2\2/\t\3\2\2\2\b\21\31\37&+.";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}