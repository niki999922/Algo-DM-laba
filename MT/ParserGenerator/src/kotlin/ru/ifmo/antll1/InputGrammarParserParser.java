// Generated from /Users/nikita/Algo-DM-laba/MT/ParserGenerator/src/resources/realAntlr/InputGrammarParser.g4 by ANTLR 4.7.2
package ru.ifmo.antll1;

import java.util.LinkedList;
import java.util.ArrayList;
import java.util.Collections;
import ru.ifmo.antll1.*;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class InputGrammarParserParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		GRAMMAR=1, HEADER=2, RULES=3, START=4, TOKENS=5, IGNORE=6, IMPORT=7, RETURNS=8, 
		SEMICOLON=9, OPEN_CLOSURE=10, CLOSE_CLOSURE=11, OPEN_BRACKET=12, CLOSE_BRACKET=13, 
		EQLUALLY=14, COMMA=15, COLON=16, OR=17, WORD=18, CODE=19, REGEXP=20, WS=21;
	public static final int
		RULE_grammarFile = 0, RULE_grammarName = 1, RULE_headers = 2, RULE_startRule = 3, 
		RULE_rulesQ = 4, RULE_ruleQ = 5, RULE_parameters = 6, RULE_returnValue = 7, 
		RULE_condition = 8, RULE_step = 9, RULE_tokensss = 10, RULE_ignoreTokens = 11;
	private static String[] makeRuleNames() {
		return new String[] {
			"grammarFile", "grammarName", "headers", "startRule", "rulesQ", "ruleQ", 
			"parameters", "returnValue", "condition", "step", "tokensss", "ignoreTokens"
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

	@Override
	public String getGrammarFileName() { return "InputGrammarParser.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public InputGrammarParserParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class GrammarFileContext extends ParserRuleContext {
		public Grammar grammar;
		public GrammarNameContext gn;
		public HeadersContext h;
		public StartRuleContext sr;
		public RulesQContext r;
		public TokensssContext t;
		public IgnoreTokensContext ig;
		public GrammarNameContext grammarName() {
			return getRuleContext(GrammarNameContext.class,0);
		}
		public HeadersContext headers() {
			return getRuleContext(HeadersContext.class,0);
		}
		public StartRuleContext startRule() {
			return getRuleContext(StartRuleContext.class,0);
		}
		public RulesQContext rulesQ() {
			return getRuleContext(RulesQContext.class,0);
		}
		public TokensssContext tokensss() {
			return getRuleContext(TokensssContext.class,0);
		}
		public IgnoreTokensContext ignoreTokens() {
			return getRuleContext(IgnoreTokensContext.class,0);
		}
		public GrammarFileContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_grammarFile; }
	}

	public final GrammarFileContext grammarFile() throws RecognitionException {
		GrammarFileContext _localctx = new GrammarFileContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_grammarFile);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(24);
			((GrammarFileContext)_localctx).gn = grammarName();
			setState(25);
			((GrammarFileContext)_localctx).h = headers();
			setState(26);
			((GrammarFileContext)_localctx).sr = startRule();
			setState(27);
			((GrammarFileContext)_localctx).r = rulesQ();
			setState(28);
			((GrammarFileContext)_localctx).t = tokensss();
			setState(29);
			((GrammarFileContext)_localctx).ig = ignoreTokens();
			 ((GrammarFileContext)_localctx).grammar =  new Grammar();
			      _localctx.grammar.grammarName = ((GrammarFileContext)_localctx).gn.name;
			      _localctx.grammar.getHeaders().addAll(((GrammarFileContext)_localctx).h.list);
			      _localctx.grammar.startRule = ((GrammarFileContext)_localctx).sr.name;
			      _localctx.grammar.getRules().addAll(((GrammarFileContext)_localctx).r.list);
			      _localctx.grammar.getTokens().addAll(((GrammarFileContext)_localctx).t.list);
			      _localctx.grammar.getIgnore().addAll(((GrammarFileContext)_localctx).ig.list); 
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

	public static class GrammarNameContext extends ParserRuleContext {
		public String name;
		public Token w2;
		public TerminalNode GRAMMAR() { return getToken(InputGrammarParserParser.GRAMMAR, 0); }
		public TerminalNode SEMICOLON() { return getToken(InputGrammarParserParser.SEMICOLON, 0); }
		public TerminalNode WORD() { return getToken(InputGrammarParserParser.WORD, 0); }
		public GrammarNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_grammarName; }
	}

	public final GrammarNameContext grammarName() throws RecognitionException {
		GrammarNameContext _localctx = new GrammarNameContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_grammarName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(32);
			match(GRAMMAR);
			setState(33);
			((GrammarNameContext)_localctx).w2 = match(WORD);
			 ((GrammarNameContext)_localctx).name =  ((GrammarNameContext)_localctx).w2.getText(); 
			setState(35);
			match(SEMICOLON);
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

	public static class HeadersContext extends ParserRuleContext {
		public ArrayList<String> list;
		public Token importW;
		public TerminalNode HEADER() { return getToken(InputGrammarParserParser.HEADER, 0); }
		public TerminalNode OPEN_CLOSURE() { return getToken(InputGrammarParserParser.OPEN_CLOSURE, 0); }
		public TerminalNode CLOSE_CLOSURE() { return getToken(InputGrammarParserParser.CLOSE_CLOSURE, 0); }
		public List<TerminalNode> IMPORT() { return getTokens(InputGrammarParserParser.IMPORT); }
		public TerminalNode IMPORT(int i) {
			return getToken(InputGrammarParserParser.IMPORT, i);
		}
		public List<TerminalNode> SEMICOLON() { return getTokens(InputGrammarParserParser.SEMICOLON); }
		public TerminalNode SEMICOLON(int i) {
			return getToken(InputGrammarParserParser.SEMICOLON, i);
		}
		public List<TerminalNode> WORD() { return getTokens(InputGrammarParserParser.WORD); }
		public TerminalNode WORD(int i) {
			return getToken(InputGrammarParserParser.WORD, i);
		}
		public HeadersContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_headers; }
	}

	public final HeadersContext headers() throws RecognitionException {
		HeadersContext _localctx = new HeadersContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_headers);
		int _la;
		try {
			setState(52);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case START:
				enterOuterAlt(_localctx, 1);
				{
				 ((HeadersContext)_localctx).list =  new ArrayList<String>(); 
				}
				break;
			case HEADER:
				enterOuterAlt(_localctx, 2);
				{
				setState(38);
				match(HEADER);
				 ArrayList<String> listRes = new ArrayList<>(); 
				setState(40);
				match(OPEN_CLOSURE);
				setState(47);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==IMPORT) {
					{
					{
					setState(41);
					match(IMPORT);
					setState(42);
					((HeadersContext)_localctx).importW = match(WORD);
					 listRes.add(((HeadersContext)_localctx).importW.getText()); 
					setState(44);
					match(SEMICOLON);
					}
					}
					setState(49);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(50);
				match(CLOSE_CLOSURE);
				 ((HeadersContext)_localctx).list =  listRes; 
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

	public static class StartRuleContext extends ParserRuleContext {
		public String name;
		public Token w2;
		public TerminalNode START() { return getToken(InputGrammarParserParser.START, 0); }
		public TerminalNode EQLUALLY() { return getToken(InputGrammarParserParser.EQLUALLY, 0); }
		public TerminalNode SEMICOLON() { return getToken(InputGrammarParserParser.SEMICOLON, 0); }
		public TerminalNode WORD() { return getToken(InputGrammarParserParser.WORD, 0); }
		public StartRuleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_startRule; }
	}

	public final StartRuleContext startRule() throws RecognitionException {
		StartRuleContext _localctx = new StartRuleContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_startRule);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(54);
			match(START);
			setState(55);
			match(EQLUALLY);
			setState(56);
			((StartRuleContext)_localctx).w2 = match(WORD);
			 ((StartRuleContext)_localctx).name =  ((StartRuleContext)_localctx).w2.getText(); 
			setState(58);
			match(SEMICOLON);
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

	public static class RulesQContext extends ParserRuleContext {
		public ArrayList<Rule> list;
		public RuleQContext r;
		public TerminalNode RULES() { return getToken(InputGrammarParserParser.RULES, 0); }
		public TerminalNode OPEN_CLOSURE() { return getToken(InputGrammarParserParser.OPEN_CLOSURE, 0); }
		public TerminalNode CLOSE_CLOSURE() { return getToken(InputGrammarParserParser.CLOSE_CLOSURE, 0); }
		public List<RuleQContext> ruleQ() {
			return getRuleContexts(RuleQContext.class);
		}
		public RuleQContext ruleQ(int i) {
			return getRuleContext(RuleQContext.class,i);
		}
		public RulesQContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rulesQ; }
	}

	public final RulesQContext rulesQ() throws RecognitionException {
		RulesQContext _localctx = new RulesQContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_rulesQ);
		int _la;
		try {
			setState(74);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case EOF:
			case TOKENS:
			case IGNORE:
				enterOuterAlt(_localctx, 1);
				{
				 ((RulesQContext)_localctx).list =  new ArrayList<Rule>(); 
				}
				break;
			case RULES:
				enterOuterAlt(_localctx, 2);
				{
				setState(61);
				match(RULES);
				 ArrayList<Rule> listRes = new ArrayList<>(); 
				setState(63);
				match(OPEN_CLOSURE);
				setState(69);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==WORD) {
					{
					{
					setState(64);
					((RulesQContext)_localctx).r = ruleQ();
					 listRes.add(((RulesQContext)_localctx).r.ruleq); 
					}
					}
					setState(71);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(72);
				match(CLOSE_CLOSURE);
				 ((RulesQContext)_localctx).list =  listRes; 
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

	public static class RuleQContext extends ParserRuleContext {
		public Rule ruleq;
		public Token w1;
		public ParametersContext par;
		public ReturnValueContext ret;
		public ConditionContext c1;
		public ConditionContext c2;
		public TerminalNode OPEN_BRACKET() { return getToken(InputGrammarParserParser.OPEN_BRACKET, 0); }
		public TerminalNode CLOSE_BRACKET() { return getToken(InputGrammarParserParser.CLOSE_BRACKET, 0); }
		public TerminalNode RETURNS() { return getToken(InputGrammarParserParser.RETURNS, 0); }
		public TerminalNode COLON() { return getToken(InputGrammarParserParser.COLON, 0); }
		public TerminalNode SEMICOLON() { return getToken(InputGrammarParserParser.SEMICOLON, 0); }
		public TerminalNode WORD() { return getToken(InputGrammarParserParser.WORD, 0); }
		public ParametersContext parameters() {
			return getRuleContext(ParametersContext.class,0);
		}
		public ReturnValueContext returnValue() {
			return getRuleContext(ReturnValueContext.class,0);
		}
		public List<ConditionContext> condition() {
			return getRuleContexts(ConditionContext.class);
		}
		public ConditionContext condition(int i) {
			return getRuleContext(ConditionContext.class,i);
		}
		public List<TerminalNode> OR() { return getTokens(InputGrammarParserParser.OR); }
		public TerminalNode OR(int i) {
			return getToken(InputGrammarParserParser.OR, i);
		}
		public RuleQContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ruleQ; }
	}

	public final RuleQContext ruleQ() throws RecognitionException {
		RuleQContext _localctx = new RuleQContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_ruleQ);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(76);
			((RuleQContext)_localctx).w1 = match(WORD);
			((RuleQContext)_localctx).ruleq =  new Rule(((RuleQContext)_localctx).w1.getText());
			setState(78);
			match(OPEN_BRACKET);
			setState(79);
			((RuleQContext)_localctx).par = parameters();
			setState(80);
			match(CLOSE_BRACKET);
			setState(81);
			match(RETURNS);
			setState(82);
			((RuleQContext)_localctx).ret = returnValue();
			 _localctx.ruleq.getParameters().addAll(((RuleQContext)_localctx).par.list); _localctx.ruleq.returnType = ((RuleQContext)_localctx).ret.returnType; 
			setState(84);
			match(COLON);
			setState(96);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==WORD || _la==CODE) {
				{
				setState(85);
				((RuleQContext)_localctx).c1 = condition();
				 _localctx.ruleq.getConditions().add(((RuleQContext)_localctx).c1.cond); 
				setState(93);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==OR) {
					{
					{
					setState(87);
					match(OR);
					setState(88);
					((RuleQContext)_localctx).c2 = condition();
					 _localctx.ruleq.getConditions().add(((RuleQContext)_localctx).c2.cond); 
					}
					}
					setState(95);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(98);
			match(SEMICOLON);
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

	public static class ParametersContext extends ParserRuleContext {
		public ArrayList<Parameter> list;
		public Token var1;
		public Token type1;
		public Token var2;
		public Token type2;
		public List<TerminalNode> COLON() { return getTokens(InputGrammarParserParser.COLON); }
		public TerminalNode COLON(int i) {
			return getToken(InputGrammarParserParser.COLON, i);
		}
		public List<TerminalNode> WORD() { return getTokens(InputGrammarParserParser.WORD); }
		public TerminalNode WORD(int i) {
			return getToken(InputGrammarParserParser.WORD, i);
		}
		public List<TerminalNode> COMMA() { return getTokens(InputGrammarParserParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(InputGrammarParserParser.COMMA, i);
		}
		public ParametersContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parameters; }
	}

	public final ParametersContext parameters() throws RecognitionException {
		ParametersContext _localctx = new ParametersContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_parameters);
		int _la;
		try {
			setState(117);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case CLOSE_BRACKET:
				enterOuterAlt(_localctx, 1);
				{
				 ((ParametersContext)_localctx).list =  new ArrayList<Parameter>(); 
				}
				break;
			case WORD:
				enterOuterAlt(_localctx, 2);
				{
				setState(101);
				((ParametersContext)_localctx).var1 = match(WORD);
				 ArrayList<Parameter> listRes = new ArrayList<>(); 
				setState(103);
				match(COLON);
				setState(104);
				((ParametersContext)_localctx).type1 = match(WORD);
				 listRes.add(new Parameter(((ParametersContext)_localctx).var1.getText(), ((ParametersContext)_localctx).type1.getText())); 
				setState(113);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(106);
					match(COMMA);
					setState(107);
					((ParametersContext)_localctx).var2 = match(WORD);
					setState(108);
					match(COLON);
					setState(109);
					((ParametersContext)_localctx).type2 = match(WORD);
					 listRes.add(new Parameter(((ParametersContext)_localctx).var2.getText(), ((ParametersContext)_localctx).type2.getText())); 
					}
					}
					setState(115);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				 ((ParametersContext)_localctx).list =  listRes; 
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

	public static class ReturnValueContext extends ParserRuleContext {
		public ReturnField returnType;
		public Token var1;
		public Token type1;
		public TerminalNode COLON() { return getToken(InputGrammarParserParser.COLON, 0); }
		public List<TerminalNode> WORD() { return getTokens(InputGrammarParserParser.WORD); }
		public TerminalNode WORD(int i) {
			return getToken(InputGrammarParserParser.WORD, i);
		}
		public ReturnValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_returnValue; }
	}

	public final ReturnValueContext returnValue() throws RecognitionException {
		ReturnValueContext _localctx = new ReturnValueContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_returnValue);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(119);
			((ReturnValueContext)_localctx).var1 = match(WORD);
			setState(120);
			match(COLON);
			setState(121);
			((ReturnValueContext)_localctx).type1 = match(WORD);
			 ((ReturnValueContext)_localctx).returnType =  new ReturnField(((ReturnValueContext)_localctx).var1.getText(), ((ReturnValueContext)_localctx).type1.getText()); 
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

	public static class ConditionContext extends ParserRuleContext {
		public Condition cond;
		public StepContext s;
		public List<StepContext> step() {
			return getRuleContexts(StepContext.class);
		}
		public StepContext step(int i) {
			return getRuleContext(StepContext.class,i);
		}
		public ConditionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_condition; }
	}

	public final ConditionContext condition() throws RecognitionException {
		ConditionContext _localctx = new ConditionContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_condition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			 ArrayList<Step> listRes = new ArrayList<>(); 
			setState(128); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(125);
				((ConditionContext)_localctx).s = step();
				 listRes.add(((ConditionContext)_localctx).s.stepq); 
				}
				}
				setState(130); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==WORD || _la==CODE );
			 ((ConditionContext)_localctx).cond =  new Condition(); _localctx.cond.getSteps().addAll(listRes); 
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

	public static class StepContext extends ParserRuleContext {
		public Step stepq;
		public Token c;
		public Token w1;
		public Token w2;
		public Token w3;
		public Token w4;
		public TerminalNode CODE() { return getToken(InputGrammarParserParser.CODE, 0); }
		public List<TerminalNode> WORD() { return getTokens(InputGrammarParserParser.WORD); }
		public TerminalNode WORD(int i) {
			return getToken(InputGrammarParserParser.WORD, i);
		}
		public TerminalNode EQLUALLY() { return getToken(InputGrammarParserParser.EQLUALLY, 0); }
		public TerminalNode OPEN_BRACKET() { return getToken(InputGrammarParserParser.OPEN_BRACKET, 0); }
		public TerminalNode CLOSE_BRACKET() { return getToken(InputGrammarParserParser.CLOSE_BRACKET, 0); }
		public List<TerminalNode> COMMA() { return getTokens(InputGrammarParserParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(InputGrammarParserParser.COMMA, i);
		}
		public StepContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_step; }
	}

	public final StepContext step() throws RecognitionException {
		StepContext _localctx = new StepContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_step);
		int _la;
		try {
			setState(178);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(134);
				((StepContext)_localctx).c = match(CODE);
				 ((StepContext)_localctx).stepq =  new CodeStep(((StepContext)_localctx).c.getText()); 
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(136);
				((StepContext)_localctx).w1 = match(WORD);
				 ((StepContext)_localctx).stepq =  new RuleTermStep("", ((StepContext)_localctx).w1.getText()); 
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(138);
				((StepContext)_localctx).w1 = match(WORD);
				setState(139);
				match(EQLUALLY);
				setState(140);
				((StepContext)_localctx).w2 = match(WORD);
				 ((StepContext)_localctx).stepq =  new RuleTermStep(((StepContext)_localctx).w1.getText(), ((StepContext)_localctx).w2.getText()); 
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(142);
				((StepContext)_localctx).w1 = match(WORD);
				setState(143);
				match(EQLUALLY);
				setState(144);
				((StepContext)_localctx).w2 = match(WORD);
				 String tmp_str = ((StepContext)_localctx).w2.getText() + "("; 
				setState(146);
				match(OPEN_BRACKET);
				setState(157);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==WORD) {
					{
					setState(147);
					((StepContext)_localctx).w3 = match(WORD);
					 tmp_str = tmp_str + ((StepContext)_localctx).w3.getText(); 
					setState(154);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMMA) {
						{
						{
						setState(149);
						match(COMMA);
						setState(150);
						((StepContext)_localctx).w4 = match(WORD);
						 tmp_str = tmp_str + ", " + ((StepContext)_localctx).w4.getText(); 
						}
						}
						setState(156);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(159);
				match(CLOSE_BRACKET);
				 tmp_str = tmp_str + ")"; ((StepContext)_localctx).stepq =  new RuleTermStep(((StepContext)_localctx).w1.getText(), tmp_str); 
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(161);
				((StepContext)_localctx).w2 = match(WORD);
				 String tmp_str = ((StepContext)_localctx).w2.getText() + "("; 
				setState(163);
				match(OPEN_BRACKET);
				setState(174);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==WORD) {
					{
					setState(164);
					((StepContext)_localctx).w3 = match(WORD);
					 tmp_str = tmp_str + ((StepContext)_localctx).w3.getText(); 
					setState(171);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMMA) {
						{
						{
						setState(166);
						match(COMMA);
						setState(167);
						((StepContext)_localctx).w4 = match(WORD);
						 tmp_str = tmp_str + ", " + ((StepContext)_localctx).w4.getText(); 
						}
						}
						setState(173);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(176);
				match(CLOSE_BRACKET);
				 tmp_str = tmp_str + ")"; ((StepContext)_localctx).stepq =  new RuleTermStep("", tmp_str); 
				}
				break;
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

	public static class TokensssContext extends ParserRuleContext {
		public ArrayList<TokenQ> list;
		public Token tokenName;
		public Token regexp;
		public TerminalNode TOKENS() { return getToken(InputGrammarParserParser.TOKENS, 0); }
		public TerminalNode OPEN_CLOSURE() { return getToken(InputGrammarParserParser.OPEN_CLOSURE, 0); }
		public TerminalNode CLOSE_CLOSURE() { return getToken(InputGrammarParserParser.CLOSE_CLOSURE, 0); }
		public List<TerminalNode> EQLUALLY() { return getTokens(InputGrammarParserParser.EQLUALLY); }
		public TerminalNode EQLUALLY(int i) {
			return getToken(InputGrammarParserParser.EQLUALLY, i);
		}
		public List<TerminalNode> SEMICOLON() { return getTokens(InputGrammarParserParser.SEMICOLON); }
		public TerminalNode SEMICOLON(int i) {
			return getToken(InputGrammarParserParser.SEMICOLON, i);
		}
		public List<TerminalNode> WORD() { return getTokens(InputGrammarParserParser.WORD); }
		public TerminalNode WORD(int i) {
			return getToken(InputGrammarParserParser.WORD, i);
		}
		public List<TerminalNode> REGEXP() { return getTokens(InputGrammarParserParser.REGEXP); }
		public TerminalNode REGEXP(int i) {
			return getToken(InputGrammarParserParser.REGEXP, i);
		}
		public TokensssContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tokensss; }
	}

	public final TokensssContext tokensss() throws RecognitionException {
		TokensssContext _localctx = new TokensssContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_tokensss);
		int _la;
		try {
			setState(196);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case EOF:
			case IGNORE:
				enterOuterAlt(_localctx, 1);
				{
				 ((TokensssContext)_localctx).list =  new ArrayList<TokenQ>(); 
				}
				break;
			case TOKENS:
				enterOuterAlt(_localctx, 2);
				{
				setState(181);
				match(TOKENS);
				 ArrayList<TokenQ> listRes = new ArrayList<>(); 
				setState(183);
				match(OPEN_CLOSURE);
				setState(191);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==WORD) {
					{
					{
					setState(184);
					((TokensssContext)_localctx).tokenName = match(WORD);
					setState(185);
					match(EQLUALLY);
					setState(186);
					((TokensssContext)_localctx).regexp = match(REGEXP);
					 listRes.add(new TokenQ(((TokensssContext)_localctx).tokenName.getText(), ((TokensssContext)_localctx).regexp.getText())); 
					setState(188);
					match(SEMICOLON);
					}
					}
					setState(193);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(194);
				match(CLOSE_CLOSURE);
				 ((TokensssContext)_localctx).list =  listRes; 
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

	public static class IgnoreTokensContext extends ParserRuleContext {
		public ArrayList<Ignore> list;
		public Token w1;
		public Token w2;
		public TerminalNode IGNORE() { return getToken(InputGrammarParserParser.IGNORE, 0); }
		public TerminalNode OPEN_CLOSURE() { return getToken(InputGrammarParserParser.OPEN_CLOSURE, 0); }
		public TerminalNode CLOSE_CLOSURE() { return getToken(InputGrammarParserParser.CLOSE_CLOSURE, 0); }
		public TerminalNode SEMICOLON() { return getToken(InputGrammarParserParser.SEMICOLON, 0); }
		public List<TerminalNode> WORD() { return getTokens(InputGrammarParserParser.WORD); }
		public TerminalNode WORD(int i) {
			return getToken(InputGrammarParserParser.WORD, i);
		}
		public List<TerminalNode> COMMA() { return getTokens(InputGrammarParserParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(InputGrammarParserParser.COMMA, i);
		}
		public IgnoreTokensContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ignoreTokens; }
	}

	public final IgnoreTokensContext ignoreTokens() throws RecognitionException {
		IgnoreTokensContext _localctx = new IgnoreTokensContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_ignoreTokens);
		int _la;
		try {
			setState(217);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case EOF:
				enterOuterAlt(_localctx, 1);
				{
				 ((IgnoreTokensContext)_localctx).list =  new ArrayList<Ignore>(); 
				}
				break;
			case IGNORE:
				enterOuterAlt(_localctx, 2);
				{
				setState(199);
				match(IGNORE);
				 ArrayList<Ignore> listRes = new ArrayList<>(); 
				setState(201);
				match(OPEN_CLOSURE);
				setState(213);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==WORD) {
					{
					setState(202);
					((IgnoreTokensContext)_localctx).w1 = match(WORD);
					 listRes.add(new Ignore(((IgnoreTokensContext)_localctx).w1.getText())); 
					setState(209);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMMA) {
						{
						{
						setState(204);
						match(COMMA);
						setState(205);
						((IgnoreTokensContext)_localctx).w2 = match(WORD);
						 listRes.add(new Ignore(((IgnoreTokensContext)_localctx).w2.getText())); 
						}
						}
						setState(211);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(212);
					match(SEMICOLON);
					}
				}

				setState(215);
				match(CLOSE_CLOSURE);
				 ((IgnoreTokensContext)_localctx).list =  listRes; 
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\27\u00de\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3"+
		"\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\7\4\60\n\4\f\4\16\4\63\13\4\3\4\3"+
		"\4\5\4\67\n\4\3\5\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\7\6"+
		"F\n\6\f\6\16\6I\13\6\3\6\3\6\5\6M\n\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7"+
		"\3\7\3\7\3\7\3\7\3\7\3\7\3\7\7\7^\n\7\f\7\16\7a\13\7\5\7c\n\7\3\7\3\7"+
		"\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\7\br\n\b\f\b\16\bu\13\b\3"+
		"\b\5\bx\n\b\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\6\n\u0083\n\n\r\n\16\n"+
		"\u0084\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\3\13\3\13\3\13\3\13\7\13\u009b\n\13\f\13\16\13\u009e\13"+
		"\13\5\13\u00a0\n\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13"+
		"\7\13\u00ac\n\13\f\13\16\13\u00af\13\13\5\13\u00b1\n\13\3\13\3\13\5\13"+
		"\u00b5\n\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\7\f\u00c0\n\f\f\f\16\f"+
		"\u00c3\13\f\3\f\3\f\5\f\u00c7\n\f\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r"+
		"\7\r\u00d2\n\r\f\r\16\r\u00d5\13\r\3\r\5\r\u00d8\n\r\3\r\3\r\5\r\u00dc"+
		"\n\r\3\r\2\2\16\2\4\6\b\n\f\16\20\22\24\26\30\2\2\2\u00e7\2\32\3\2\2\2"+
		"\4\"\3\2\2\2\6\66\3\2\2\2\b8\3\2\2\2\nL\3\2\2\2\fN\3\2\2\2\16w\3\2\2\2"+
		"\20y\3\2\2\2\22~\3\2\2\2\24\u00b4\3\2\2\2\26\u00c6\3\2\2\2\30\u00db\3"+
		"\2\2\2\32\33\5\4\3\2\33\34\5\6\4\2\34\35\5\b\5\2\35\36\5\n\6\2\36\37\5"+
		"\26\f\2\37 \5\30\r\2 !\b\2\1\2!\3\3\2\2\2\"#\7\3\2\2#$\7\24\2\2$%\b\3"+
		"\1\2%&\7\13\2\2&\5\3\2\2\2\'\67\b\4\1\2()\7\4\2\2)*\b\4\1\2*\61\7\f\2"+
		"\2+,\7\t\2\2,-\7\24\2\2-.\b\4\1\2.\60\7\13\2\2/+\3\2\2\2\60\63\3\2\2\2"+
		"\61/\3\2\2\2\61\62\3\2\2\2\62\64\3\2\2\2\63\61\3\2\2\2\64\65\7\r\2\2\65"+
		"\67\b\4\1\2\66\'\3\2\2\2\66(\3\2\2\2\67\7\3\2\2\289\7\6\2\29:\7\20\2\2"+
		":;\7\24\2\2;<\b\5\1\2<=\7\13\2\2=\t\3\2\2\2>M\b\6\1\2?@\7\5\2\2@A\b\6"+
		"\1\2AG\7\f\2\2BC\5\f\7\2CD\b\6\1\2DF\3\2\2\2EB\3\2\2\2FI\3\2\2\2GE\3\2"+
		"\2\2GH\3\2\2\2HJ\3\2\2\2IG\3\2\2\2JK\7\r\2\2KM\b\6\1\2L>\3\2\2\2L?\3\2"+
		"\2\2M\13\3\2\2\2NO\7\24\2\2OP\b\7\1\2PQ\7\16\2\2QR\5\16\b\2RS\7\17\2\2"+
		"ST\7\n\2\2TU\5\20\t\2UV\b\7\1\2Vb\7\22\2\2WX\5\22\n\2X_\b\7\1\2YZ\7\23"+
		"\2\2Z[\5\22\n\2[\\\b\7\1\2\\^\3\2\2\2]Y\3\2\2\2^a\3\2\2\2_]\3\2\2\2_`"+
		"\3\2\2\2`c\3\2\2\2a_\3\2\2\2bW\3\2\2\2bc\3\2\2\2cd\3\2\2\2de\7\13\2\2"+
		"e\r\3\2\2\2fx\b\b\1\2gh\7\24\2\2hi\b\b\1\2ij\7\22\2\2jk\7\24\2\2ks\b\b"+
		"\1\2lm\7\21\2\2mn\7\24\2\2no\7\22\2\2op\7\24\2\2pr\b\b\1\2ql\3\2\2\2r"+
		"u\3\2\2\2sq\3\2\2\2st\3\2\2\2tv\3\2\2\2us\3\2\2\2vx\b\b\1\2wf\3\2\2\2"+
		"wg\3\2\2\2x\17\3\2\2\2yz\7\24\2\2z{\7\22\2\2{|\7\24\2\2|}\b\t\1\2}\21"+
		"\3\2\2\2~\u0082\b\n\1\2\177\u0080\5\24\13\2\u0080\u0081\b\n\1\2\u0081"+
		"\u0083\3\2\2\2\u0082\177\3\2\2\2\u0083\u0084\3\2\2\2\u0084\u0082\3\2\2"+
		"\2\u0084\u0085\3\2\2\2\u0085\u0086\3\2\2\2\u0086\u0087\b\n\1\2\u0087\23"+
		"\3\2\2\2\u0088\u0089\7\25\2\2\u0089\u00b5\b\13\1\2\u008a\u008b\7\24\2"+
		"\2\u008b\u00b5\b\13\1\2\u008c\u008d\7\24\2\2\u008d\u008e\7\20\2\2\u008e"+
		"\u008f\7\24\2\2\u008f\u00b5\b\13\1\2\u0090\u0091\7\24\2\2\u0091\u0092"+
		"\7\20\2\2\u0092\u0093\7\24\2\2\u0093\u0094\b\13\1\2\u0094\u009f\7\16\2"+
		"\2\u0095\u0096\7\24\2\2\u0096\u009c\b\13\1\2\u0097\u0098\7\21\2\2\u0098"+
		"\u0099\7\24\2\2\u0099\u009b\b\13\1\2\u009a\u0097\3\2\2\2\u009b\u009e\3"+
		"\2\2\2\u009c\u009a\3\2\2\2\u009c\u009d\3\2\2\2\u009d\u00a0\3\2\2\2\u009e"+
		"\u009c\3\2\2\2\u009f\u0095\3\2\2\2\u009f\u00a0\3\2\2\2\u00a0\u00a1\3\2"+
		"\2\2\u00a1\u00a2\7\17\2\2\u00a2\u00b5\b\13\1\2\u00a3\u00a4\7\24\2\2\u00a4"+
		"\u00a5\b\13\1\2\u00a5\u00b0\7\16\2\2\u00a6\u00a7\7\24\2\2\u00a7\u00ad"+
		"\b\13\1\2\u00a8\u00a9\7\21\2\2\u00a9\u00aa\7\24\2\2\u00aa\u00ac\b\13\1"+
		"\2\u00ab\u00a8\3\2\2\2\u00ac\u00af\3\2\2\2\u00ad\u00ab\3\2\2\2\u00ad\u00ae"+
		"\3\2\2\2\u00ae\u00b1\3\2\2\2\u00af\u00ad\3\2\2\2\u00b0\u00a6\3\2\2\2\u00b0"+
		"\u00b1\3\2\2\2\u00b1\u00b2\3\2\2\2\u00b2\u00b3\7\17\2\2\u00b3\u00b5\b"+
		"\13\1\2\u00b4\u0088\3\2\2\2\u00b4\u008a\3\2\2\2\u00b4\u008c\3\2\2\2\u00b4"+
		"\u0090\3\2\2\2\u00b4\u00a3\3\2\2\2\u00b5\25\3\2\2\2\u00b6\u00c7\b\f\1"+
		"\2\u00b7\u00b8\7\7\2\2\u00b8\u00b9\b\f\1\2\u00b9\u00c1\7\f\2\2\u00ba\u00bb"+
		"\7\24\2\2\u00bb\u00bc\7\20\2\2\u00bc\u00bd\7\26\2\2\u00bd\u00be\b\f\1"+
		"\2\u00be\u00c0\7\13\2\2\u00bf\u00ba\3\2\2\2\u00c0\u00c3\3\2\2\2\u00c1"+
		"\u00bf\3\2\2\2\u00c1\u00c2\3\2\2\2\u00c2\u00c4\3\2\2\2\u00c3\u00c1\3\2"+
		"\2\2\u00c4\u00c5\7\r\2\2\u00c5\u00c7\b\f\1\2\u00c6\u00b6\3\2\2\2\u00c6"+
		"\u00b7\3\2\2\2\u00c7\27\3\2\2\2\u00c8\u00dc\b\r\1\2\u00c9\u00ca\7\b\2"+
		"\2\u00ca\u00cb\b\r\1\2\u00cb\u00d7\7\f\2\2\u00cc\u00cd\7\24\2\2\u00cd"+
		"\u00d3\b\r\1\2\u00ce\u00cf\7\21\2\2\u00cf\u00d0\7\24\2\2\u00d0\u00d2\b"+
		"\r\1\2\u00d1\u00ce\3\2\2\2\u00d2\u00d5\3\2\2\2\u00d3\u00d1\3\2\2\2\u00d3"+
		"\u00d4\3\2\2\2\u00d4\u00d6\3\2\2\2\u00d5\u00d3\3\2\2\2\u00d6\u00d8\7\13"+
		"\2\2\u00d7\u00cc\3\2\2\2\u00d7\u00d8\3\2\2\2\u00d8\u00d9\3\2\2\2\u00d9"+
		"\u00da\7\r\2\2\u00da\u00dc\b\r\1\2\u00db\u00c8\3\2\2\2\u00db\u00c9\3\2"+
		"\2\2\u00dc\31\3\2\2\2\25\61\66GL_bsw\u0084\u009c\u009f\u00ad\u00b0\u00b4"+
		"\u00c1\u00c6\u00d3\u00d7\u00db";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}