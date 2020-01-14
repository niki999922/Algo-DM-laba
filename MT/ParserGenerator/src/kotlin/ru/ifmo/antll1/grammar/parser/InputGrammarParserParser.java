// Generated from /Users/nikita/Algo-DM-laba/MT/ParserGenerator/src/resources/realAntlr/InputGrammarParser.g4 by ANTLR 4.7.2
package ru.ifmo.antll1.grammar.parser;

import java.util.LinkedList;
import java.util.ArrayList;
import java.util.Collections;
import ru.ifmo.antll1.entities.*;

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
		SEMICOLON=9, OPEN_CLOSURE=10, CLOSE_CLOSURE=11, OPEN_STUPID_BRACKET=12, 
		CLOSE_STUPID_BRACKET=13, OPEN_BRACKET=14, CLOSE_BRACKET=15, EQLUALLY=16, 
		COMMA=17, COLON=18, OR=19, WORD=20, CODE=21, REGEXP=22, WS=23, COMMENT=24, 
		LINE_COMMENT=25;
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
			      _localctx.grammar.headers = ((GrammarFileContext)_localctx).h.code;
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
		public CodeStep code;
		public Token codet;
		public TerminalNode HEADER() { return getToken(InputGrammarParserParser.HEADER, 0); }
		public TerminalNode CODE() { return getToken(InputGrammarParserParser.CODE, 0); }
		public HeadersContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_headers; }
	}

	public final HeadersContext headers() throws RecognitionException {
		HeadersContext _localctx = new HeadersContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_headers);
		try {
			setState(41);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case START:
				enterOuterAlt(_localctx, 1);
				{
				 ((HeadersContext)_localctx).code =  new CodeStep(""); 
				}
				break;
			case HEADER:
				enterOuterAlt(_localctx, 2);
				{
				setState(38);
				match(HEADER);
				setState(39);
				((HeadersContext)_localctx).codet = match(CODE);
				 ((HeadersContext)_localctx).code =  new CodeStep(((HeadersContext)_localctx).codet.getText()); 
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
			setState(43);
			match(START);
			setState(44);
			match(EQLUALLY);
			setState(45);
			((StartRuleContext)_localctx).w2 = match(WORD);
			 ((StartRuleContext)_localctx).name =  ((StartRuleContext)_localctx).w2.getText(); 
			setState(47);
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
		public TerminalNode OPEN_STUPID_BRACKET() { return getToken(InputGrammarParserParser.OPEN_STUPID_BRACKET, 0); }
		public TerminalNode CLOSE_STUPID_BRACKET() { return getToken(InputGrammarParserParser.CLOSE_STUPID_BRACKET, 0); }
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
			setState(63);
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
				setState(50);
				match(RULES);
				 ArrayList<Rule> listRes = new ArrayList<>(); 
				setState(52);
				match(OPEN_STUPID_BRACKET);
				setState(58);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==WORD) {
					{
					{
					setState(53);
					((RulesQContext)_localctx).r = ruleQ();
					 listRes.add(((RulesQContext)_localctx).r.ruleq); 
					}
					}
					setState(60);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(61);
				match(CLOSE_STUPID_BRACKET);
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
			setState(111);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(65);
				((RuleQContext)_localctx).w1 = match(WORD);
				((RuleQContext)_localctx).ruleq =  new Rule(((RuleQContext)_localctx).w1.getText());
				setState(67);
				match(OPEN_BRACKET);
				setState(68);
				((RuleQContext)_localctx).par = parameters();
				setState(69);
				match(CLOSE_BRACKET);
				setState(70);
				match(RETURNS);
				setState(71);
				((RuleQContext)_localctx).ret = returnValue();
				 _localctx.ruleq.getParameters().addAll(((RuleQContext)_localctx).par.list); _localctx.ruleq.returnType = ((RuleQContext)_localctx).ret.returnType; 
				setState(73);
				match(COLON);
				setState(85);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==WORD || _la==CODE) {
					{
					setState(74);
					((RuleQContext)_localctx).c1 = condition();
					 _localctx.ruleq.getConditions().add(((RuleQContext)_localctx).c1.cond); 
					setState(82);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==OR) {
						{
						{
						setState(76);
						match(OR);
						setState(77);
						((RuleQContext)_localctx).c2 = condition();
						 _localctx.ruleq.getConditions().add(((RuleQContext)_localctx).c2.cond); 
						}
						}
						setState(84);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(87);
				match(SEMICOLON);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(89);
				((RuleQContext)_localctx).w1 = match(WORD);
				((RuleQContext)_localctx).ruleq =  new Rule(((RuleQContext)_localctx).w1.getText());
				setState(91);
				match(OPEN_BRACKET);
				setState(92);
				((RuleQContext)_localctx).par = parameters();
				setState(93);
				match(CLOSE_BRACKET);
				 _localctx.ruleq.getParameters().addAll(((RuleQContext)_localctx).par.list); _localctx.ruleq.returnType = new ReturnField("none", "none", ""); 
				setState(95);
				match(COLON);
				setState(107);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==WORD || _la==CODE) {
					{
					setState(96);
					((RuleQContext)_localctx).c1 = condition();
					 _localctx.ruleq.getConditions().add(((RuleQContext)_localctx).c1.cond); 
					setState(104);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==OR) {
						{
						{
						setState(98);
						match(OR);
						setState(99);
						((RuleQContext)_localctx).c2 = condition();
						 _localctx.ruleq.getConditions().add(((RuleQContext)_localctx).c2.cond); 
						}
						}
						setState(106);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(109);
				match(SEMICOLON);
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
			setState(130);
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
				setState(114);
				((ParametersContext)_localctx).var1 = match(WORD);
				 ArrayList<Parameter> listRes = new ArrayList<>(); 
				setState(116);
				match(COLON);
				setState(117);
				((ParametersContext)_localctx).type1 = match(WORD);
				 listRes.add(new Parameter(((ParametersContext)_localctx).var1.getText(), ((ParametersContext)_localctx).type1.getText())); 
				setState(126);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(119);
					match(COMMA);
					setState(120);
					((ParametersContext)_localctx).var2 = match(WORD);
					setState(121);
					match(COLON);
					setState(122);
					((ParametersContext)_localctx).type2 = match(WORD);
					 listRes.add(new Parameter(((ParametersContext)_localctx).var2.getText(), ((ParametersContext)_localctx).type2.getText())); 
					}
					}
					setState(128);
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
		public Token codeInit;
		public TerminalNode COLON() { return getToken(InputGrammarParserParser.COLON, 0); }
		public List<TerminalNode> WORD() { return getTokens(InputGrammarParserParser.WORD); }
		public TerminalNode WORD(int i) {
			return getToken(InputGrammarParserParser.WORD, i);
		}
		public TerminalNode CODE() { return getToken(InputGrammarParserParser.CODE, 0); }
		public ReturnValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_returnValue; }
	}

	public final ReturnValueContext returnValue() throws RecognitionException {
		ReturnValueContext _localctx = new ReturnValueContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_returnValue);
		try {
			setState(141);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(132);
				((ReturnValueContext)_localctx).var1 = match(WORD);
				setState(133);
				match(COLON);
				setState(134);
				((ReturnValueContext)_localctx).type1 = match(WORD);
				 ((ReturnValueContext)_localctx).returnType =  new ReturnField(((ReturnValueContext)_localctx).var1.getText(), ((ReturnValueContext)_localctx).type1.getText(), ""); 
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(136);
				((ReturnValueContext)_localctx).var1 = match(WORD);
				setState(137);
				match(COLON);
				setState(138);
				((ReturnValueContext)_localctx).type1 = match(WORD);
				setState(139);
				((ReturnValueContext)_localctx).codeInit = match(CODE);
				 ((ReturnValueContext)_localctx).returnType =  new ReturnField(((ReturnValueContext)_localctx).var1.getText(), ((ReturnValueContext)_localctx).type1.getText(), ((ReturnValueContext)_localctx).codeInit.getText().substring(1,((ReturnValueContext)_localctx).codeInit.getText().length() - 1)); 
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
			setState(147); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(144);
				((ConditionContext)_localctx).s = step();
				 listRes.add(((ConditionContext)_localctx).s.stepq); 
				}
				}
				setState(149); 
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
			setState(197);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(153);
				((StepContext)_localctx).c = match(CODE);
				 ((StepContext)_localctx).stepq =  new CodeStep(((StepContext)_localctx).c.getText()); 
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(155);
				((StepContext)_localctx).w1 = match(WORD);
				 ((StepContext)_localctx).stepq =  new RuleTermStep(((StepContext)_localctx).w1.getText().toLowerCase(), ((StepContext)_localctx).w1.getText()); 
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(157);
				((StepContext)_localctx).w1 = match(WORD);
				setState(158);
				match(EQLUALLY);
				setState(159);
				((StepContext)_localctx).w2 = match(WORD);
				 ((StepContext)_localctx).stepq =  new RuleTermStep(((StepContext)_localctx).w1.getText(), ((StepContext)_localctx).w2.getText()); 
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(161);
				((StepContext)_localctx).w1 = match(WORD);
				setState(162);
				match(EQLUALLY);
				setState(163);
				((StepContext)_localctx).w2 = match(WORD);
				 String tmp_str = ((StepContext)_localctx).w2.getText() + "("; 
				setState(165);
				match(OPEN_BRACKET);
				setState(176);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==WORD) {
					{
					setState(166);
					((StepContext)_localctx).w3 = match(WORD);
					 tmp_str = tmp_str + ((StepContext)_localctx).w3.getText(); 
					setState(173);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMMA) {
						{
						{
						setState(168);
						match(COMMA);
						setState(169);
						((StepContext)_localctx).w4 = match(WORD);
						 tmp_str = tmp_str + ", " + ((StepContext)_localctx).w4.getText(); 
						}
						}
						setState(175);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(178);
				match(CLOSE_BRACKET);
				 tmp_str = tmp_str + ")"; ((StepContext)_localctx).stepq =  new RuleTermStep(((StepContext)_localctx).w1.getText(), tmp_str); 
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(180);
				((StepContext)_localctx).w2 = match(WORD);
				 String tmp_str = ((StepContext)_localctx).w2.getText() + "("; 
				setState(182);
				match(OPEN_BRACKET);
				setState(193);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==WORD) {
					{
					setState(183);
					((StepContext)_localctx).w3 = match(WORD);
					 tmp_str = tmp_str + ((StepContext)_localctx).w3.getText(); 
					setState(190);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMMA) {
						{
						{
						setState(185);
						match(COMMA);
						setState(186);
						((StepContext)_localctx).w4 = match(WORD);
						 tmp_str = tmp_str + ", " + ((StepContext)_localctx).w4.getText(); 
						}
						}
						setState(192);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(195);
				match(CLOSE_BRACKET);
				 tmp_str = tmp_str + ")"; ((StepContext)_localctx).stepq =  new RuleTermStep(((StepContext)_localctx).w2.getText().toLowerCase(), tmp_str); 
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
		public TerminalNode OPEN_STUPID_BRACKET() { return getToken(InputGrammarParserParser.OPEN_STUPID_BRACKET, 0); }
		public TerminalNode CLOSE_STUPID_BRACKET() { return getToken(InputGrammarParserParser.CLOSE_STUPID_BRACKET, 0); }
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
			setState(215);
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
				setState(200);
				match(TOKENS);
				 ArrayList<TokenQ> listRes = new ArrayList<>(); 
				setState(202);
				match(OPEN_STUPID_BRACKET);
				setState(210);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==WORD) {
					{
					{
					setState(203);
					((TokensssContext)_localctx).tokenName = match(WORD);
					setState(204);
					match(EQLUALLY);
					setState(205);
					((TokensssContext)_localctx).regexp = match(REGEXP);
					 listRes.add(new TokenQ(((TokensssContext)_localctx).tokenName.getText(), ((TokensssContext)_localctx).regexp.getText().substring(1, ((TokensssContext)_localctx).regexp.getText().length() - 1))); 
					setState(207);
					match(SEMICOLON);
					}
					}
					setState(212);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(213);
				match(CLOSE_STUPID_BRACKET);
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
		public TerminalNode OPEN_STUPID_BRACKET() { return getToken(InputGrammarParserParser.OPEN_STUPID_BRACKET, 0); }
		public TerminalNode CLOSE_STUPID_BRACKET() { return getToken(InputGrammarParserParser.CLOSE_STUPID_BRACKET, 0); }
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
			setState(236);
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
				setState(218);
				match(IGNORE);
				 ArrayList<Ignore> listRes = new ArrayList<>(); 
				setState(220);
				match(OPEN_STUPID_BRACKET);
				setState(232);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==WORD) {
					{
					setState(221);
					((IgnoreTokensContext)_localctx).w1 = match(WORD);
					 listRes.add(new Ignore(((IgnoreTokensContext)_localctx).w1.getText())); 
					setState(228);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMMA) {
						{
						{
						setState(223);
						match(COMMA);
						setState(224);
						((IgnoreTokensContext)_localctx).w2 = match(WORD);
						 listRes.add(new Ignore(((IgnoreTokensContext)_localctx).w2.getText())); 
						}
						}
						setState(230);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(231);
					match(SEMICOLON);
					}
				}

				setState(234);
				match(CLOSE_STUPID_BRACKET);
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\33\u00f1\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3"+
		"\3\3\3\4\3\4\3\4\3\4\5\4,\n\4\3\5\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6"+
		"\3\6\3\6\3\6\7\6;\n\6\f\6\16\6>\13\6\3\6\3\6\5\6B\n\6\3\7\3\7\3\7\3\7"+
		"\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\7\7S\n\7\f\7\16\7V\13\7\5"+
		"\7X\n\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\7"+
		"\7i\n\7\f\7\16\7l\13\7\5\7n\n\7\3\7\3\7\5\7r\n\7\3\b\3\b\3\b\3\b\3\b\3"+
		"\b\3\b\3\b\3\b\3\b\3\b\7\b\177\n\b\f\b\16\b\u0082\13\b\3\b\5\b\u0085\n"+
		"\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\5\t\u0090\n\t\3\n\3\n\3\n\3\n\6"+
		"\n\u0096\n\n\r\n\16\n\u0097\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\7\13\u00ae\n\13"+
		"\f\13\16\13\u00b1\13\13\5\13\u00b3\n\13\3\13\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\3\13\7\13\u00bf\n\13\f\13\16\13\u00c2\13\13\5\13\u00c4"+
		"\n\13\3\13\3\13\5\13\u00c8\n\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\7"+
		"\f\u00d3\n\f\f\f\16\f\u00d6\13\f\3\f\3\f\5\f\u00da\n\f\3\r\3\r\3\r\3\r"+
		"\3\r\3\r\3\r\3\r\3\r\7\r\u00e5\n\r\f\r\16\r\u00e8\13\r\3\r\5\r\u00eb\n"+
		"\r\3\r\3\r\5\r\u00ef\n\r\3\r\2\2\16\2\4\6\b\n\f\16\20\22\24\26\30\2\2"+
		"\2\u00fd\2\32\3\2\2\2\4\"\3\2\2\2\6+\3\2\2\2\b-\3\2\2\2\nA\3\2\2\2\fq"+
		"\3\2\2\2\16\u0084\3\2\2\2\20\u008f\3\2\2\2\22\u0091\3\2\2\2\24\u00c7\3"+
		"\2\2\2\26\u00d9\3\2\2\2\30\u00ee\3\2\2\2\32\33\5\4\3\2\33\34\5\6\4\2\34"+
		"\35\5\b\5\2\35\36\5\n\6\2\36\37\5\26\f\2\37 \5\30\r\2 !\b\2\1\2!\3\3\2"+
		"\2\2\"#\7\3\2\2#$\7\26\2\2$%\b\3\1\2%&\7\13\2\2&\5\3\2\2\2\',\b\4\1\2"+
		"()\7\4\2\2)*\7\27\2\2*,\b\4\1\2+\'\3\2\2\2+(\3\2\2\2,\7\3\2\2\2-.\7\6"+
		"\2\2./\7\22\2\2/\60\7\26\2\2\60\61\b\5\1\2\61\62\7\13\2\2\62\t\3\2\2\2"+
		"\63B\b\6\1\2\64\65\7\5\2\2\65\66\b\6\1\2\66<\7\16\2\2\678\5\f\7\289\b"+
		"\6\1\29;\3\2\2\2:\67\3\2\2\2;>\3\2\2\2<:\3\2\2\2<=\3\2\2\2=?\3\2\2\2>"+
		"<\3\2\2\2?@\7\17\2\2@B\b\6\1\2A\63\3\2\2\2A\64\3\2\2\2B\13\3\2\2\2CD\7"+
		"\26\2\2DE\b\7\1\2EF\7\20\2\2FG\5\16\b\2GH\7\21\2\2HI\7\n\2\2IJ\5\20\t"+
		"\2JK\b\7\1\2KW\7\24\2\2LM\5\22\n\2MT\b\7\1\2NO\7\25\2\2OP\5\22\n\2PQ\b"+
		"\7\1\2QS\3\2\2\2RN\3\2\2\2SV\3\2\2\2TR\3\2\2\2TU\3\2\2\2UX\3\2\2\2VT\3"+
		"\2\2\2WL\3\2\2\2WX\3\2\2\2XY\3\2\2\2YZ\7\13\2\2Zr\3\2\2\2[\\\7\26\2\2"+
		"\\]\b\7\1\2]^\7\20\2\2^_\5\16\b\2_`\7\21\2\2`a\b\7\1\2am\7\24\2\2bc\5"+
		"\22\n\2cj\b\7\1\2de\7\25\2\2ef\5\22\n\2fg\b\7\1\2gi\3\2\2\2hd\3\2\2\2"+
		"il\3\2\2\2jh\3\2\2\2jk\3\2\2\2kn\3\2\2\2lj\3\2\2\2mb\3\2\2\2mn\3\2\2\2"+
		"no\3\2\2\2op\7\13\2\2pr\3\2\2\2qC\3\2\2\2q[\3\2\2\2r\r\3\2\2\2s\u0085"+
		"\b\b\1\2tu\7\26\2\2uv\b\b\1\2vw\7\24\2\2wx\7\26\2\2x\u0080\b\b\1\2yz\7"+
		"\23\2\2z{\7\26\2\2{|\7\24\2\2|}\7\26\2\2}\177\b\b\1\2~y\3\2\2\2\177\u0082"+
		"\3\2\2\2\u0080~\3\2\2\2\u0080\u0081\3\2\2\2\u0081\u0083\3\2\2\2\u0082"+
		"\u0080\3\2\2\2\u0083\u0085\b\b\1\2\u0084s\3\2\2\2\u0084t\3\2\2\2\u0085"+
		"\17\3\2\2\2\u0086\u0087\7\26\2\2\u0087\u0088\7\24\2\2\u0088\u0089\7\26"+
		"\2\2\u0089\u0090\b\t\1\2\u008a\u008b\7\26\2\2\u008b\u008c\7\24\2\2\u008c"+
		"\u008d\7\26\2\2\u008d\u008e\7\27\2\2\u008e\u0090\b\t\1\2\u008f\u0086\3"+
		"\2\2\2\u008f\u008a\3\2\2\2\u0090\21\3\2\2\2\u0091\u0095\b\n\1\2\u0092"+
		"\u0093\5\24\13\2\u0093\u0094\b\n\1\2\u0094\u0096\3\2\2\2\u0095\u0092\3"+
		"\2\2\2\u0096\u0097\3\2\2\2\u0097\u0095\3\2\2\2\u0097\u0098\3\2\2\2\u0098"+
		"\u0099\3\2\2\2\u0099\u009a\b\n\1\2\u009a\23\3\2\2\2\u009b\u009c\7\27\2"+
		"\2\u009c\u00c8\b\13\1\2\u009d\u009e\7\26\2\2\u009e\u00c8\b\13\1\2\u009f"+
		"\u00a0\7\26\2\2\u00a0\u00a1\7\22\2\2\u00a1\u00a2\7\26\2\2\u00a2\u00c8"+
		"\b\13\1\2\u00a3\u00a4\7\26\2\2\u00a4\u00a5\7\22\2\2\u00a5\u00a6\7\26\2"+
		"\2\u00a6\u00a7\b\13\1\2\u00a7\u00b2\7\20\2\2\u00a8\u00a9\7\26\2\2\u00a9"+
		"\u00af\b\13\1\2\u00aa\u00ab\7\23\2\2\u00ab\u00ac\7\26\2\2\u00ac\u00ae"+
		"\b\13\1\2\u00ad\u00aa\3\2\2\2\u00ae\u00b1\3\2\2\2\u00af\u00ad\3\2\2\2"+
		"\u00af\u00b0\3\2\2\2\u00b0\u00b3\3\2\2\2\u00b1\u00af\3\2\2\2\u00b2\u00a8"+
		"\3\2\2\2\u00b2\u00b3\3\2\2\2\u00b3\u00b4\3\2\2\2\u00b4\u00b5\7\21\2\2"+
		"\u00b5\u00c8\b\13\1\2\u00b6\u00b7\7\26\2\2\u00b7\u00b8\b\13\1\2\u00b8"+
		"\u00c3\7\20\2\2\u00b9\u00ba\7\26\2\2\u00ba\u00c0\b\13\1\2\u00bb\u00bc"+
		"\7\23\2\2\u00bc\u00bd\7\26\2\2\u00bd\u00bf\b\13\1\2\u00be\u00bb\3\2\2"+
		"\2\u00bf\u00c2\3\2\2\2\u00c0\u00be\3\2\2\2\u00c0\u00c1\3\2\2\2\u00c1\u00c4"+
		"\3\2\2\2\u00c2\u00c0\3\2\2\2\u00c3\u00b9\3\2\2\2\u00c3\u00c4\3\2\2\2\u00c4"+
		"\u00c5\3\2\2\2\u00c5\u00c6\7\21\2\2\u00c6\u00c8\b\13\1\2\u00c7\u009b\3"+
		"\2\2\2\u00c7\u009d\3\2\2\2\u00c7\u009f\3\2\2\2\u00c7\u00a3\3\2\2\2\u00c7"+
		"\u00b6\3\2\2\2\u00c8\25\3\2\2\2\u00c9\u00da\b\f\1\2\u00ca\u00cb\7\7\2"+
		"\2\u00cb\u00cc\b\f\1\2\u00cc\u00d4\7\16\2\2\u00cd\u00ce\7\26\2\2\u00ce"+
		"\u00cf\7\22\2\2\u00cf\u00d0\7\30\2\2\u00d0\u00d1\b\f\1\2\u00d1\u00d3\7"+
		"\13\2\2\u00d2\u00cd\3\2\2\2\u00d3\u00d6\3\2\2\2\u00d4\u00d2\3\2\2\2\u00d4"+
		"\u00d5\3\2\2\2\u00d5\u00d7\3\2\2\2\u00d6\u00d4\3\2\2\2\u00d7\u00d8\7\17"+
		"\2\2\u00d8\u00da\b\f\1\2\u00d9\u00c9\3\2\2\2\u00d9\u00ca\3\2\2\2\u00da"+
		"\27\3\2\2\2\u00db\u00ef\b\r\1\2\u00dc\u00dd\7\b\2\2\u00dd\u00de\b\r\1"+
		"\2\u00de\u00ea\7\16\2\2\u00df\u00e0\7\26\2\2\u00e0\u00e6\b\r\1\2\u00e1"+
		"\u00e2\7\23\2\2\u00e2\u00e3\7\26\2\2\u00e3\u00e5\b\r\1\2\u00e4\u00e1\3"+
		"\2\2\2\u00e5\u00e8\3\2\2\2\u00e6\u00e4\3\2\2\2\u00e6\u00e7\3\2\2\2\u00e7"+
		"\u00e9\3\2\2\2\u00e8\u00e6\3\2\2\2\u00e9\u00eb\7\13\2\2\u00ea\u00df\3"+
		"\2\2\2\u00ea\u00eb\3\2\2\2\u00eb\u00ec\3\2\2\2\u00ec\u00ed\7\17\2\2\u00ed"+
		"\u00ef\b\r\1\2\u00ee\u00db\3\2\2\2\u00ee\u00dc\3\2\2\2\u00ef\31\3\2\2"+
		"\2\30+<ATWjmq\u0080\u0084\u008f\u0097\u00af\u00b2\u00c0\u00c3\u00c7\u00d4"+
		"\u00d9\u00e6\u00ea\u00ee";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}