// Generated from /Users/nikita/Algo-DM-laba/MT/AntLR/src/main/resources/antlr/PascalGrammar.g4 by ANTLR 4.7.2
package antlr;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.ATN;
import org.antlr.v4.runtime.atn.ATNDeserializer;
import org.antlr.v4.runtime.atn.ParserATNSimulator;
import org.antlr.v4.runtime.atn.PredictionContextCache;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.tree.ParseTreeListener;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.List;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class PascalGrammarParser extends Parser {
    public static final int
            PROGRAM = 1, FUNCTION = 2, PROCEDURE = 3, CONST = 4, INTEGER = 5, BOOLEAN = 6, STRING = 7,
            REAL = 8, CHAR = 9, VAR = 10, BEGIN = 11, END = 12, TRUE = 13, FALSE = 14, OR = 15, AND = 16,
            NOT = 17, IF = 18, THEN = 19, ELSE = 20, FOR = 21, TO = 22, DOWNTO = 23, WHILE = 24, DO = 25,
            ADD = 26, SUB = 27, MUL = 28, DIVS = 29, MODS = 30, EQUALS = 31, N_EQUAL = 32, GT = 33,
            GE = 34, LT = 35, LE = 36, OPEN_BRACKET = 37, CLOSE_BRACKET = 38, DOT = 39, COLON = 40,
            SEMICOLON = 41, COMMA = 42, ASSIGN = 43, NUMBER = 44, STRING_N = 45, NAME_STRING = 46,
            COMMENT_1 = 47, COMMENT_2 = 48, WS = 49;
    public static final int
            RULE_program = 0, RULE_programName = 1, RULE_programContext = 2, RULE_constContext = 3,
            RULE_constant = 4, RULE_constantValue = 5, RULE_varContext = 6, RULE_variable = 7,
            RULE_variableRow = 8, RULE_functionProcedureContext = 9, RULE_functionHeader = 10,
            RULE_procedureHeader = 11, RULE_arguments = 12, RULE_main = 13, RULE_contextMain = 14,
            RULE_statement = 15, RULE_assignmentStatement = 16, RULE_expression = 17,
            RULE_simpleExpression = 18, RULE_term = 19, RULE_signedFactor = 20, RULE_factor = 21,
            RULE_bool = 22, RULE_unsignedConstant = 23, RULE_functionCall = 24, RULE_parameterList = 25,
            RULE_operationPr1 = 26, RULE_operationPr2 = 27, RULE_operationPr3 = 28,
            RULE_varWrapper = 29, RULE_logicCicleStatments = 30, RULE_ifStatement = 31,
            RULE_cycleStatement = 32, RULE_whileStatement = 33, RULE_forStatement = 34,
            RULE_namesList = 35, RULE_type = 36;
    public static final String[] ruleNames = makeRuleNames();
    /**
     * @deprecated Use {@link #VOCABULARY} instead.
     */
    @Deprecated
    public static final String[] tokenNames;
    public static final String _serializedATN =
            "\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\63\u0139\4\2\t\2" +
                    "\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13" +
                    "\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22" +
                    "\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31" +
                    "\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!" +
                    "\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3" +
                    "\3\3\4\3\4\3\4\7\4Y\n\4\f\4\16\4\\\13\4\3\4\3\4\3\5\3\5\6\5b\n\5\r\5\16" +
                    "\5c\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\b\3\b\3\b\3\t\6\ts\n\t\r\t\16" +
                    "\tt\3\n\3\n\3\n\3\n\3\n\3\13\3\13\5\13~\n\13\3\13\5\13\u0081\n\13\3\13" +
                    "\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r" +
                    "\3\r\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\7\16\u009e\n\16\f\16\16\16" +
                    "\u00a1\13\16\5\16\u00a3\n\16\3\17\3\17\3\17\3\17\3\20\3\20\5\20\u00ab" +
                    "\n\20\7\20\u00ad\n\20\f\20\16\20\u00b0\13\20\3\21\3\21\3\21\5\21\u00b5" +
                    "\n\21\3\22\3\22\3\22\3\22\3\23\3\23\3\23\3\23\5\23\u00bf\n\23\3\24\3\24" +
                    "\3\24\3\24\5\24\u00c5\n\24\3\25\3\25\3\25\3\25\7\25\u00cb\n\25\f\25\16" +
                    "\25\u00ce\13\25\3\26\5\26\u00d1\n\26\3\26\3\26\3\27\3\27\3\27\3\27\3\27" +
                    "\3\27\3\27\3\27\3\27\3\27\5\27\u00df\n\27\3\30\3\30\3\31\3\31\3\32\3\32" +
                    "\3\32\3\32\3\32\3\33\3\33\3\33\7\33\u00ed\n\33\f\33\16\33\u00f0\13\33" +
                    "\3\34\3\34\3\35\3\35\3\36\3\36\3\37\3\37\3 \3 \5 \u00fc\n \3!\3!\3!\3" +
                    "!\3!\3!\5!\u0104\n!\3!\3!\3!\3!\3!\5!\u010b\n!\5!\u010d\n!\3\"\3\"\5\"" +
                    "\u0111\n\"\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\5#\u011e\n#\3$\3$\3$\3$\3" +
                    "$\3$\3$\3$\3$\3$\3$\3$\3$\5$\u012d\n$\3%\3%\3%\7%\u0132\n%\f%\16%\u0135" +
                    "\13%\3&\3&\3&\2\2\'\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60" +
                    "\62\64\668:<>@BDFHJ\2\13\3\2./\3\2\34\35\3\2\17\20\4\2\22\22\36 \4\2\21" +
                    "\21\34\35\3\2!&\3\2/\60\3\2\30\31\3\2\7\13\2\u0132\2L\3\2\2\2\4Q\3\2\2" +
                    "\2\6Z\3\2\2\2\b_\3\2\2\2\ne\3\2\2\2\fl\3\2\2\2\16n\3\2\2\2\20r\3\2\2\2" +
                    "\22v\3\2\2\2\24}\3\2\2\2\26\u0085\3\2\2\2\30\u008e\3\2\2\2\32\u00a2\3" +
                    "\2\2\2\34\u00a4\3\2\2\2\36\u00ae\3\2\2\2 \u00b4\3\2\2\2\"\u00b6\3\2\2" +
                    "\2$\u00ba\3\2\2\2&\u00c0\3\2\2\2(\u00c6\3\2\2\2*\u00d0\3\2\2\2,\u00de" +
                    "\3\2\2\2.\u00e0\3\2\2\2\60\u00e2\3\2\2\2\62\u00e4\3\2\2\2\64\u00e9\3\2" +
                    "\2\2\66\u00f1\3\2\2\28\u00f3\3\2\2\2:\u00f5\3\2\2\2<\u00f7\3\2\2\2>\u00fb" +
                    "\3\2\2\2@\u00fd\3\2\2\2B\u0110\3\2\2\2D\u0112\3\2\2\2F\u011f\3\2\2\2H" +
                    "\u012e\3\2\2\2J\u0136\3\2\2\2LM\5\4\3\2MN\5\6\4\2NO\7)\2\2OP\7\2\2\3P" +
                    "\3\3\2\2\2QR\7\3\2\2RS\7\60\2\2ST\7+\2\2T\5\3\2\2\2UY\5\b\5\2VY\5\16\b" +
                    "\2WY\5\24\13\2XU\3\2\2\2XV\3\2\2\2XW\3\2\2\2Y\\\3\2\2\2ZX\3\2\2\2Z[\3" +
                    "\2\2\2[]\3\2\2\2\\Z\3\2\2\2]^\5\34\17\2^\7\3\2\2\2_a\7\6\2\2`b\5\n\6\2" +
                    "a`\3\2\2\2bc\3\2\2\2ca\3\2\2\2cd\3\2\2\2d\t\3\2\2\2ef\7\60\2\2fg\7*\2" +
                    "\2gh\5J&\2hi\7!\2\2ij\5\f\7\2jk\7+\2\2k\13\3\2\2\2lm\t\2\2\2m\r\3\2\2" +
                    "\2no\7\f\2\2op\5\20\t\2p\17\3\2\2\2qs\5\22\n\2rq\3\2\2\2st\3\2\2\2tr\3" +
                    "\2\2\2tu\3\2\2\2u\21\3\2\2\2vw\5H%\2wx\7*\2\2xy\5J&\2yz\7+\2\2z\23\3\2" +
                    "\2\2{~\5\30\r\2|~\5\26\f\2}{\3\2\2\2}|\3\2\2\2~\u0080\3\2\2\2\177\u0081" +
                    "\5\16\b\2\u0080\177\3\2\2\2\u0080\u0081\3\2\2\2\u0081\u0082\3\2\2\2\u0082" +
                    "\u0083\5\34\17\2\u0083\u0084\7+\2\2\u0084\25\3\2\2\2\u0085\u0086\7\4\2" +
                    "\2\u0086\u0087\7\60\2\2\u0087\u0088\7\'\2\2\u0088\u0089\5\32\16\2\u0089" +
                    "\u008a\7(\2\2\u008a\u008b\7*\2\2\u008b\u008c\5J&\2\u008c\u008d\7+\2\2" +
                    "\u008d\27\3\2\2\2\u008e\u008f\7\5\2\2\u008f\u0090\7\60\2\2\u0090\u0091" +
                    "\7\'\2\2\u0091\u0092\5\32\16\2\u0092\u0093\7(\2\2\u0093\u0094\7+\2\2\u0094" +
                    "\31\3\2\2\2\u0095\u0096\5H%\2\u0096\u0097\7*\2\2\u0097\u009f\5J&\2\u0098" +
                    "\u0099\7,\2\2\u0099\u009a\5H%\2\u009a\u009b\7*\2\2\u009b\u009c\5J&\2\u009c" +
                    "\u009e\3\2\2\2\u009d\u0098\3\2\2\2\u009e\u00a1\3\2\2\2\u009f\u009d\3\2" +
                    "\2\2\u009f\u00a0\3\2\2\2\u00a0\u00a3\3\2\2\2\u00a1\u009f\3\2\2\2\u00a2" +
                    "\u0095\3\2\2\2\u00a2\u00a3\3\2\2\2\u00a3\33\3\2\2\2\u00a4\u00a5\7\r\2" +
                    "\2\u00a5\u00a6\5\36\20\2\u00a6\u00a7\7\16\2\2\u00a7\35\3\2\2\2\u00a8\u00aa" +
                    "\5 \21\2\u00a9\u00ab\7+\2\2\u00aa\u00a9\3\2\2\2\u00aa\u00ab\3\2\2\2\u00ab" +
                    "\u00ad\3\2\2\2\u00ac\u00a8\3\2\2\2\u00ad\u00b0\3\2\2\2\u00ae\u00ac\3\2" +
                    "\2\2\u00ae\u00af\3\2\2\2\u00af\37\3\2\2\2\u00b0\u00ae\3\2\2\2\u00b1\u00b5" +
                    "\5\"\22\2\u00b2\u00b5\5\62\32\2\u00b3\u00b5\5> \2\u00b4\u00b1\3\2\2\2" +
                    "\u00b4\u00b2\3\2\2\2\u00b4\u00b3\3\2\2\2\u00b5!\3\2\2\2\u00b6\u00b7\5" +
                    "<\37\2\u00b7\u00b8\7-\2\2\u00b8\u00b9\5$\23\2\u00b9#\3\2\2\2\u00ba\u00be" +
                    "\5&\24\2\u00bb\u00bc\5:\36\2\u00bc\u00bd\5$\23\2\u00bd\u00bf\3\2\2\2\u00be" +
                    "\u00bb\3\2\2\2\u00be\u00bf\3\2\2\2\u00bf%\3\2\2\2\u00c0\u00c4\5(\25\2" +
                    "\u00c1\u00c2\58\35\2\u00c2\u00c3\5&\24\2\u00c3\u00c5\3\2\2\2\u00c4\u00c1" +
                    "\3\2\2\2\u00c4\u00c5\3\2\2\2\u00c5\'\3\2\2\2\u00c6\u00cc\5*\26\2\u00c7" +
                    "\u00c8\5\66\34\2\u00c8\u00c9\5(\25\2\u00c9\u00cb\3\2\2\2\u00ca\u00c7\3" +
                    "\2\2\2\u00cb\u00ce\3\2\2\2\u00cc\u00ca\3\2\2\2\u00cc\u00cd\3\2\2\2\u00cd" +
                    ")\3\2\2\2\u00ce\u00cc\3\2\2\2\u00cf\u00d1\t\3\2\2\u00d0\u00cf\3\2\2\2" +
                    "\u00d0\u00d1\3\2\2\2\u00d1\u00d2\3\2\2\2\u00d2\u00d3\5,\27\2\u00d3+\3" +
                    "\2\2\2\u00d4\u00df\5<\37\2\u00d5\u00d6\7\'\2\2\u00d6\u00d7\5$\23\2\u00d7" +
                    "\u00d8\7(\2\2\u00d8\u00df\3\2\2\2\u00d9\u00df\5\62\32\2\u00da\u00df\5" +
                    "\60\31\2\u00db\u00dc\7\23\2\2\u00dc\u00df\5,\27\2\u00dd\u00df\5.\30\2" +
                    "\u00de\u00d4\3\2\2\2\u00de\u00d5\3\2\2\2\u00de\u00d9\3\2\2\2\u00de\u00da" +
                    "\3\2\2\2\u00de\u00db\3\2\2\2\u00de\u00dd\3\2\2\2\u00df-\3\2\2\2\u00e0" +
                    "\u00e1\t\4\2\2\u00e1/\3\2\2\2\u00e2\u00e3\7.\2\2\u00e3\61\3\2\2\2\u00e4" +
                    "\u00e5\7\60\2\2\u00e5\u00e6\7\'\2\2\u00e6\u00e7\5\64\33\2\u00e7\u00e8" +
                    "\7(\2\2\u00e8\63\3\2\2\2\u00e9\u00ee\5$\23\2\u00ea\u00eb\7,\2\2\u00eb" +
                    "\u00ed\5$\23\2\u00ec\u00ea\3\2\2\2\u00ed\u00f0\3\2\2\2\u00ee\u00ec\3\2" +
                    "\2\2\u00ee\u00ef\3\2\2\2\u00ef\65\3\2\2\2\u00f0\u00ee\3\2\2\2\u00f1\u00f2" +
                    "\t\5\2\2\u00f2\67\3\2\2\2\u00f3\u00f4\t\6\2\2\u00f49\3\2\2\2\u00f5\u00f6" +
                    "\t\7\2\2\u00f6;\3\2\2\2\u00f7\u00f8\t\b\2\2\u00f8=\3\2\2\2\u00f9\u00fc" +
                    "\5@!\2\u00fa\u00fc\5B\"\2\u00fb\u00f9\3\2\2\2\u00fb\u00fa\3\2\2\2\u00fc" +
                    "?\3\2\2\2\u00fd\u00fe\7\24\2\2\u00fe\u00ff\5$\23\2\u00ff\u010c\7\25\2" +
                    "\2\u0100\u0103\5 \21\2\u0101\u0102\7\26\2\2\u0102\u0104\5\36\20\2\u0103" +
                    "\u0101\3\2\2\2\u0103\u0104\3\2\2\2\u0104\u010d\3\2\2\2\u0105\u0106\7\r" +
                    "\2\2\u0106\u0107\5\36\20\2\u0107\u010a\7\16\2\2\u0108\u0109\7\26\2\2\u0109" +
                    "\u010b\5 \21\2\u010a\u0108\3\2\2\2\u010a\u010b\3\2\2\2\u010b\u010d\3\2" +
                    "\2\2\u010c\u0100\3\2\2\2\u010c\u0105\3\2\2\2\u010dA\3\2\2\2\u010e\u0111" +
                    "\5D#\2\u010f\u0111\5F$\2\u0110\u010e\3\2\2\2\u0110\u010f\3\2\2\2\u0111" +
                    "C\3\2\2\2\u0112\u0113\7\32\2\2\u0113\u0114\7\'\2\2\u0114\u0115\5$\23\2" +
                    "\u0115\u0116\7(\2\2\u0116\u011d\7\33\2\2\u0117\u011e\5 \21\2\u0118\u0119" +
                    "\7\r\2\2\u0119\u011a\5\36\20\2\u011a\u011b\7\16\2\2\u011b\u011c\7+\2\2" +
                    "\u011c\u011e\3\2\2\2\u011d\u0117\3\2\2\2\u011d\u0118\3\2\2\2\u011eE\3" +
                    "\2\2\2\u011f\u0120\7\27\2\2\u0120\u0121\5<\37\2\u0121\u0122\7-\2\2\u0122" +
                    "\u0123\5$\23\2\u0123\u0124\t\t\2\2\u0124\u0125\5$\23\2\u0125\u012c\7\33" +
                    "\2\2\u0126\u012d\5 \21\2\u0127\u0128\7\r\2\2\u0128\u0129\5\36\20\2\u0129" +
                    "\u012a\7\16\2\2\u012a\u012b\7+\2\2\u012b\u012d\3\2\2\2\u012c\u0126\3\2" +
                    "\2\2\u012c\u0127\3\2\2\2\u012dG\3\2\2\2\u012e\u0133\7\60\2\2\u012f\u0130" +
                    "\7,\2\2\u0130\u0132\7\60\2\2\u0131\u012f\3\2\2\2\u0132\u0135\3\2\2\2\u0133" +
                    "\u0131\3\2\2\2\u0133\u0134\3\2\2\2\u0134I\3\2\2\2\u0135\u0133\3\2\2\2" +
                    "\u0136\u0137\t\n\2\2\u0137K\3\2\2\2\33XZct}\u0080\u009f\u00a2\u00aa\u00ae" +
                    "\u00b4\u00be\u00c4\u00cc\u00d0\u00de\u00ee\u00fb\u0103\u010a\u010c\u0110" +
                    "\u011d\u012c\u0133";
    public static final ATN _ATN =
            new ATNDeserializer().deserialize(_serializedATN.toCharArray());
    protected static final DFA[] _decisionToDFA;
    protected static final PredictionContextCache _sharedContextCache =
            new PredictionContextCache();
    private static final String[] _LITERAL_NAMES = makeLiteralNames();
    private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
    public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

    static {
        RuntimeMetaData.checkVersion("4.7.2", RuntimeMetaData.VERSION);
    }

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

    static {
        _decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
        for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
            _decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
        }
    }

    public PascalGrammarParser(TokenStream input) {
        super(input);
        _interp = new ParserATNSimulator(this, _ATN, _decisionToDFA, _sharedContextCache);
    }

    private static String[] makeRuleNames() {
        return new String[]{
                "program", "programName", "programContext", "constContext", "constant",
                "constantValue", "varContext", "variable", "variableRow", "functionProcedureContext",
                "functionHeader", "procedureHeader", "arguments", "main", "contextMain",
                "statement", "assignmentStatement", "expression", "simpleExpression",
                "term", "signedFactor", "factor", "bool", "unsignedConstant", "functionCall",
                "parameterList", "operationPr1", "operationPr2", "operationPr3", "varWrapper",
                "logicCicleStatments", "ifStatement", "cycleStatement", "whileStatement",
                "forStatement", "namesList", "type"
        };
    }

    private static String[] makeLiteralNames() {
        return new String[]{
                null, null, null, null, null, null, null, null, null, null, null, null,
                null, null, null, null, null, null, null, null, null, null, null, null,
                null, null, "'+'", "'-'", "'*'", null, null, "'='", "'<>'", "'>'", "'>='",
                "'<'", "'<='", "'('", "')'", "'.'", "':'", "';'", "','", "':='"
        };
    }

    private static String[] makeSymbolicNames() {
        return new String[]{
                null, "PROGRAM", "FUNCTION", "PROCEDURE", "CONST", "INTEGER", "BOOLEAN",
                "STRING", "REAL", "CHAR", "VAR", "BEGIN", "END", "TRUE", "FALSE", "OR",
                "AND", "NOT", "IF", "THEN", "ELSE", "FOR", "TO", "DOWNTO", "WHILE", "DO",
                "ADD", "SUB", "MUL", "DIVS", "MODS", "EQUALS", "N_EQUAL", "GT", "GE",
                "LT", "LE", "OPEN_BRACKET", "CLOSE_BRACKET", "DOT", "COLON", "SEMICOLON",
                "COMMA", "ASSIGN", "NUMBER", "STRING_N", "NAME_STRING", "COMMENT_1",
                "COMMENT_2", "WS"
        };
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
    public String getGrammarFileName() {
        return "PascalGrammar.g4";
    }

    @Override
    public String[] getRuleNames() {
        return ruleNames;
    }

    @Override
    public String getSerializedATN() {
        return _serializedATN;
    }

    @Override
    public ATN getATN() {
        return _ATN;
    }

    public final ProgramContext program() throws RecognitionException {
        ProgramContext _localctx = new ProgramContext(_ctx, getState());
        enterRule(_localctx, 0, RULE_program);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(74);
                programName();
                setState(75);
                programContext();
                setState(76);
                match(DOT);
                setState(77);
                match(EOF);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final ProgramNameContext programName() throws RecognitionException {
        ProgramNameContext _localctx = new ProgramNameContext(_ctx, getState());
        enterRule(_localctx, 2, RULE_programName);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(79);
                match(PROGRAM);
                setState(80);
                match(NAME_STRING);
                setState(81);
                match(SEMICOLON);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final ProgramContextContext programContext() throws RecognitionException {
        ProgramContextContext _localctx = new ProgramContextContext(_ctx, getState());
        enterRule(_localctx, 4, RULE_programContext);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(88);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << FUNCTION) | (1L << PROCEDURE) | (1L << CONST) | (1L << VAR))) != 0)) {
                    {
                        setState(86);
                        _errHandler.sync(this);
                        switch (_input.LA(1)) {
                            case CONST: {
                                setState(83);
                                constContext();
                            }
                            break;
                            case VAR: {
                                setState(84);
                                varContext();
                            }
                            break;
                            case FUNCTION:
                            case PROCEDURE: {
                                setState(85);
                                functionProcedureContext();
                            }
                            break;
                            default:
                                throw new NoViableAltException(this);
                        }
                    }
                    setState(90);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                }
                setState(91);
                main();
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final ConstContextContext constContext() throws RecognitionException {
        ConstContextContext _localctx = new ConstContextContext(_ctx, getState());
        enterRule(_localctx, 6, RULE_constContext);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(93);
                match(CONST);
                setState(95);
                _errHandler.sync(this);
                _la = _input.LA(1);
                do {
                    {
                        {
                            setState(94);
                            constant();
                        }
                    }
                    setState(97);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                } while (_la == NAME_STRING);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final ConstantContext constant() throws RecognitionException {
        ConstantContext _localctx = new ConstantContext(_ctx, getState());
        enterRule(_localctx, 8, RULE_constant);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(99);
                match(NAME_STRING);
                setState(100);
                match(COLON);
                setState(101);
                type();
                setState(102);
                match(EQUALS);
                setState(103);
                constantValue();
                setState(104);
                match(SEMICOLON);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final ConstantValueContext constantValue() throws RecognitionException {
        ConstantValueContext _localctx = new ConstantValueContext(_ctx, getState());
        enterRule(_localctx, 10, RULE_constantValue);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(106);
                _la = _input.LA(1);
                if (!(_la == NUMBER || _la == STRING_N)) {
                    _errHandler.recoverInline(this);
                } else {
                    if (_input.LA(1) == Token.EOF) matchedEOF = true;
                    _errHandler.reportMatch(this);
                    consume();
                }
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final VarContextContext varContext() throws RecognitionException {
        VarContextContext _localctx = new VarContextContext(_ctx, getState());
        enterRule(_localctx, 12, RULE_varContext);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(108);
                match(VAR);
                setState(109);
                variable();
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final VariableContext variable() throws RecognitionException {
        VariableContext _localctx = new VariableContext(_ctx, getState());
        enterRule(_localctx, 14, RULE_variable);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(112);
                _errHandler.sync(this);
                _la = _input.LA(1);
                do {
                    {
                        {
                            setState(111);
                            variableRow();
                        }
                    }
                    setState(114);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                } while (_la == NAME_STRING);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final VariableRowContext variableRow() throws RecognitionException {
        VariableRowContext _localctx = new VariableRowContext(_ctx, getState());
        enterRule(_localctx, 16, RULE_variableRow);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(116);
                namesList();
                setState(117);
                match(COLON);
                setState(118);
                type();
                setState(119);
                match(SEMICOLON);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final FunctionProcedureContextContext functionProcedureContext() throws RecognitionException {
        FunctionProcedureContextContext _localctx = new FunctionProcedureContextContext(_ctx, getState());
        enterRule(_localctx, 18, RULE_functionProcedureContext);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(123);
                _errHandler.sync(this);
                switch (_input.LA(1)) {
                    case PROCEDURE: {
                        setState(121);
                        procedureHeader();
                    }
                    break;
                    case FUNCTION: {
                        setState(122);
                        functionHeader();
                    }
                    break;
                    default:
                        throw new NoViableAltException(this);
                }
                setState(126);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == VAR) {
                    {
                        setState(125);
                        varContext();
                    }
                }

                setState(128);
                main();
                setState(129);
                match(SEMICOLON);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final FunctionHeaderContext functionHeader() throws RecognitionException {
        FunctionHeaderContext _localctx = new FunctionHeaderContext(_ctx, getState());
        enterRule(_localctx, 20, RULE_functionHeader);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(131);
                match(FUNCTION);
                setState(132);
                match(NAME_STRING);
                setState(133);
                match(OPEN_BRACKET);
                setState(134);
                arguments();
                setState(135);
                match(CLOSE_BRACKET);
                setState(136);
                match(COLON);
                setState(137);
                type();
                setState(138);
                match(SEMICOLON);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final ProcedureHeaderContext procedureHeader() throws RecognitionException {
        ProcedureHeaderContext _localctx = new ProcedureHeaderContext(_ctx, getState());
        enterRule(_localctx, 22, RULE_procedureHeader);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(140);
                match(PROCEDURE);
                setState(141);
                match(NAME_STRING);
                setState(142);
                match(OPEN_BRACKET);
                setState(143);
                arguments();
                setState(144);
                match(CLOSE_BRACKET);
                setState(145);
                match(SEMICOLON);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final ArgumentsContext arguments() throws RecognitionException {
        ArgumentsContext _localctx = new ArgumentsContext(_ctx, getState());
        enterRule(_localctx, 24, RULE_arguments);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(160);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == NAME_STRING) {
                    {
                        setState(147);
                        namesList();
                        setState(148);
                        match(COLON);
                        setState(149);
                        type();
                        setState(157);
                        _errHandler.sync(this);
                        _la = _input.LA(1);
                        while (_la == COMMA) {
                            {
                                {
                                    setState(150);
                                    match(COMMA);
                                    setState(151);
                                    namesList();
                                    setState(152);
                                    match(COLON);
                                    setState(153);
                                    type();
                                }
                            }
                            setState(159);
                            _errHandler.sync(this);
                            _la = _input.LA(1);
                        }
                    }
                }

            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final MainContext main() throws RecognitionException {
        MainContext _localctx = new MainContext(_ctx, getState());
        enterRule(_localctx, 26, RULE_main);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(162);
                match(BEGIN);
                setState(163);
                contextMain();
                setState(164);
                match(END);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final ContextMainContext contextMain() throws RecognitionException {
        ContextMainContext _localctx = new ContextMainContext(_ctx, getState());
        enterRule(_localctx, 28, RULE_contextMain);
        try {
            int _alt;
            enterOuterAlt(_localctx, 1);
            {
                setState(172);
                _errHandler.sync(this);
                _alt = getInterpreter().adaptivePredict(_input, 9, _ctx);
                while (_alt != 2 && _alt != org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER) {
                    if (_alt == 1) {
                        {
                            {
                                setState(166);
                                statement();
                                setState(168);
                                _errHandler.sync(this);
                                switch (getInterpreter().adaptivePredict(_input, 8, _ctx)) {
                                    case 1: {
                                        setState(167);
                                        match(SEMICOLON);
                                    }
                                    break;
                                }
                            }
                        }
                    }
                    setState(174);
                    _errHandler.sync(this);
                    _alt = getInterpreter().adaptivePredict(_input, 9, _ctx);
                }
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final StatementContext statement() throws RecognitionException {
        StatementContext _localctx = new StatementContext(_ctx, getState());
        enterRule(_localctx, 30, RULE_statement);
        try {
            setState(178);
            _errHandler.sync(this);
            switch (getInterpreter().adaptivePredict(_input, 10, _ctx)) {
                case 1:
                    enterOuterAlt(_localctx, 1);
                {
                    setState(175);
                    assignmentStatement();
                }
                break;
                case 2:
                    enterOuterAlt(_localctx, 2);
                {
                    setState(176);
                    functionCall();
                }
                break;
                case 3:
                    enterOuterAlt(_localctx, 3);
                {
                    setState(177);
                    logicCicleStatments();
                }
                break;
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final AssignmentStatementContext assignmentStatement() throws RecognitionException {
        AssignmentStatementContext _localctx = new AssignmentStatementContext(_ctx, getState());
        enterRule(_localctx, 32, RULE_assignmentStatement);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(180);
                varWrapper();
                setState(181);
                match(ASSIGN);
                setState(182);
                expression();
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final ExpressionContext expression() throws RecognitionException {
        ExpressionContext _localctx = new ExpressionContext(_ctx, getState());
        enterRule(_localctx, 34, RULE_expression);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(184);
                simpleExpression();
                setState(188);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << EQUALS) | (1L << N_EQUAL) | (1L << GT) | (1L << GE) | (1L << LT) | (1L << LE))) != 0)) {
                    {
                        setState(185);
                        operationPr3();
                        setState(186);
                        expression();
                    }
                }

            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final SimpleExpressionContext simpleExpression() throws RecognitionException {
        SimpleExpressionContext _localctx = new SimpleExpressionContext(_ctx, getState());
        enterRule(_localctx, 36, RULE_simpleExpression);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(190);
                term();
                setState(194);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << OR) | (1L << ADD) | (1L << SUB))) != 0)) {
                    {
                        setState(191);
                        operationPr2();
                        setState(192);
                        simpleExpression();
                    }
                }

            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final TermContext term() throws RecognitionException {
        TermContext _localctx = new TermContext(_ctx, getState());
        enterRule(_localctx, 38, RULE_term);
        try {
            int _alt;
            enterOuterAlt(_localctx, 1);
            {
                setState(196);
                signedFactor();
                setState(202);
                _errHandler.sync(this);
                _alt = getInterpreter().adaptivePredict(_input, 13, _ctx);
                while (_alt != 2 && _alt != org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER) {
                    if (_alt == 1) {
                        {
                            {
                                setState(197);
                                operationPr1();
                                setState(198);
                                term();
                            }
                        }
                    }
                    setState(204);
                    _errHandler.sync(this);
                    _alt = getInterpreter().adaptivePredict(_input, 13, _ctx);
                }
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final SignedFactorContext signedFactor() throws RecognitionException {
        SignedFactorContext _localctx = new SignedFactorContext(_ctx, getState());
        enterRule(_localctx, 40, RULE_signedFactor);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(206);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == ADD || _la == SUB) {
                    {
                        setState(205);
                        _la = _input.LA(1);
                        if (!(_la == ADD || _la == SUB)) {
                            _errHandler.recoverInline(this);
                        } else {
                            if (_input.LA(1) == Token.EOF) matchedEOF = true;
                            _errHandler.reportMatch(this);
                            consume();
                        }
                    }
                }

                setState(208);
                factor();
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final FactorContext factor() throws RecognitionException {
        FactorContext _localctx = new FactorContext(_ctx, getState());
        enterRule(_localctx, 42, RULE_factor);
        try {
            setState(220);
            _errHandler.sync(this);
            switch (getInterpreter().adaptivePredict(_input, 15, _ctx)) {
                case 1:
                    enterOuterAlt(_localctx, 1);
                {
                    setState(210);
                    varWrapper();
                }
                break;
                case 2:
                    enterOuterAlt(_localctx, 2);
                {
                    setState(211);
                    match(OPEN_BRACKET);
                    setState(212);
                    expression();
                    setState(213);
                    match(CLOSE_BRACKET);
                }
                break;
                case 3:
                    enterOuterAlt(_localctx, 3);
                {
                    setState(215);
                    functionCall();
                }
                break;
                case 4:
                    enterOuterAlt(_localctx, 4);
                {
                    setState(216);
                    unsignedConstant();
                }
                break;
                case 5:
                    enterOuterAlt(_localctx, 5);
                {
                    setState(217);
                    match(NOT);
                    setState(218);
                    factor();
                }
                break;
                case 6:
                    enterOuterAlt(_localctx, 6);
                {
                    setState(219);
                    bool();
                }
                break;
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final BoolContext bool() throws RecognitionException {
        BoolContext _localctx = new BoolContext(_ctx, getState());
        enterRule(_localctx, 44, RULE_bool);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(222);
                _la = _input.LA(1);
                if (!(_la == TRUE || _la == FALSE)) {
                    _errHandler.recoverInline(this);
                } else {
                    if (_input.LA(1) == Token.EOF) matchedEOF = true;
                    _errHandler.reportMatch(this);
                    consume();
                }
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final UnsignedConstantContext unsignedConstant() throws RecognitionException {
        UnsignedConstantContext _localctx = new UnsignedConstantContext(_ctx, getState());
        enterRule(_localctx, 46, RULE_unsignedConstant);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(224);
                match(NUMBER);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final FunctionCallContext functionCall() throws RecognitionException {
        FunctionCallContext _localctx = new FunctionCallContext(_ctx, getState());
        enterRule(_localctx, 48, RULE_functionCall);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(226);
                match(NAME_STRING);
                setState(227);
                match(OPEN_BRACKET);
                setState(228);
                parameterList();
                setState(229);
                match(CLOSE_BRACKET);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final ParameterListContext parameterList() throws RecognitionException {
        ParameterListContext _localctx = new ParameterListContext(_ctx, getState());
        enterRule(_localctx, 50, RULE_parameterList);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(231);
                expression();
                setState(236);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while (_la == COMMA) {
                    {
                        {
                            setState(232);
                            match(COMMA);
                            setState(233);
                            expression();
                        }
                    }
                    setState(238);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                }
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final OperationPr1Context operationPr1() throws RecognitionException {
        OperationPr1Context _localctx = new OperationPr1Context(_ctx, getState());
        enterRule(_localctx, 52, RULE_operationPr1);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(239);
                _la = _input.LA(1);
                if (!((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << AND) | (1L << MUL) | (1L << DIVS) | (1L << MODS))) != 0))) {
                    _errHandler.recoverInline(this);
                } else {
                    if (_input.LA(1) == Token.EOF) matchedEOF = true;
                    _errHandler.reportMatch(this);
                    consume();
                }
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final OperationPr2Context operationPr2() throws RecognitionException {
        OperationPr2Context _localctx = new OperationPr2Context(_ctx, getState());
        enterRule(_localctx, 54, RULE_operationPr2);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(241);
                _la = _input.LA(1);
                if (!((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << OR) | (1L << ADD) | (1L << SUB))) != 0))) {
                    _errHandler.recoverInline(this);
                } else {
                    if (_input.LA(1) == Token.EOF) matchedEOF = true;
                    _errHandler.reportMatch(this);
                    consume();
                }
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final OperationPr3Context operationPr3() throws RecognitionException {
        OperationPr3Context _localctx = new OperationPr3Context(_ctx, getState());
        enterRule(_localctx, 56, RULE_operationPr3);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(243);
                _la = _input.LA(1);
                if (!((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << EQUALS) | (1L << N_EQUAL) | (1L << GT) | (1L << GE) | (1L << LT) | (1L << LE))) != 0))) {
                    _errHandler.recoverInline(this);
                } else {
                    if (_input.LA(1) == Token.EOF) matchedEOF = true;
                    _errHandler.reportMatch(this);
                    consume();
                }
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final VarWrapperContext varWrapper() throws RecognitionException {
        VarWrapperContext _localctx = new VarWrapperContext(_ctx, getState());
        enterRule(_localctx, 58, RULE_varWrapper);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(245);
                _la = _input.LA(1);
                if (!(_la == STRING_N || _la == NAME_STRING)) {
                    _errHandler.recoverInline(this);
                } else {
                    if (_input.LA(1) == Token.EOF) matchedEOF = true;
                    _errHandler.reportMatch(this);
                    consume();
                }
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final LogicCicleStatmentsContext logicCicleStatments() throws RecognitionException {
        LogicCicleStatmentsContext _localctx = new LogicCicleStatmentsContext(_ctx, getState());
        enterRule(_localctx, 60, RULE_logicCicleStatments);
        try {
            setState(249);
            _errHandler.sync(this);
            switch (_input.LA(1)) {
                case IF:
                    enterOuterAlt(_localctx, 1);
                {
                    setState(247);
                    ifStatement();
                }
                break;
                case FOR:
                case WHILE:
                    enterOuterAlt(_localctx, 2);
                {
                    setState(248);
                    cycleStatement();
                }
                break;
                default:
                    throw new NoViableAltException(this);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final IfStatementContext ifStatement() throws RecognitionException {
        IfStatementContext _localctx = new IfStatementContext(_ctx, getState());
        enterRule(_localctx, 62, RULE_ifStatement);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(251);
                match(IF);
                setState(252);
                expression();
                setState(253);
                match(THEN);
                setState(266);
                _errHandler.sync(this);
                switch (_input.LA(1)) {
                    case IF:
                    case FOR:
                    case WHILE:
                    case STRING_N:
                    case NAME_STRING: {
                        setState(254);
                        statement();
                        setState(257);
                        _errHandler.sync(this);
                        switch (getInterpreter().adaptivePredict(_input, 18, _ctx)) {
                            case 1: {
                                setState(255);
                                match(ELSE);
                                setState(256);
                                contextMain();
                            }
                            break;
                        }
                    }
                    break;
                    case BEGIN: {
                        setState(259);
                        match(BEGIN);
                        setState(260);
                        contextMain();
                        setState(261);
                        match(END);
                        setState(264);
                        _errHandler.sync(this);
                        switch (getInterpreter().adaptivePredict(_input, 19, _ctx)) {
                            case 1: {
                                setState(262);
                                match(ELSE);
                                setState(263);
                                statement();
                            }
                            break;
                        }
                    }
                    break;
                    default:
                        throw new NoViableAltException(this);
                }
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final CycleStatementContext cycleStatement() throws RecognitionException {
        CycleStatementContext _localctx = new CycleStatementContext(_ctx, getState());
        enterRule(_localctx, 64, RULE_cycleStatement);
        try {
            setState(270);
            _errHandler.sync(this);
            switch (_input.LA(1)) {
                case WHILE:
                    enterOuterAlt(_localctx, 1);
                {
                    setState(268);
                    whileStatement();
                }
                break;
                case FOR:
                    enterOuterAlt(_localctx, 2);
                {
                    setState(269);
                    forStatement();
                }
                break;
                default:
                    throw new NoViableAltException(this);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final WhileStatementContext whileStatement() throws RecognitionException {
        WhileStatementContext _localctx = new WhileStatementContext(_ctx, getState());
        enterRule(_localctx, 66, RULE_whileStatement);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(272);
                match(WHILE);
                setState(273);
                match(OPEN_BRACKET);
                setState(274);
                expression();
                setState(275);
                match(CLOSE_BRACKET);
                setState(276);
                match(DO);
                setState(283);
                _errHandler.sync(this);
                switch (_input.LA(1)) {
                    case IF:
                    case FOR:
                    case WHILE:
                    case STRING_N:
                    case NAME_STRING: {
                        setState(277);
                        statement();
                    }
                    break;
                    case BEGIN: {
                        setState(278);
                        match(BEGIN);
                        setState(279);
                        contextMain();
                        setState(280);
                        match(END);
                        setState(281);
                        match(SEMICOLON);
                    }
                    break;
                    default:
                        throw new NoViableAltException(this);
                }
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final ForStatementContext forStatement() throws RecognitionException {
        ForStatementContext _localctx = new ForStatementContext(_ctx, getState());
        enterRule(_localctx, 68, RULE_forStatement);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(285);
                match(FOR);
                setState(286);
                varWrapper();
                setState(287);
                match(ASSIGN);
                setState(288);
                expression();
                setState(289);
                _la = _input.LA(1);
                if (!(_la == TO || _la == DOWNTO)) {
                    _errHandler.recoverInline(this);
                } else {
                    if (_input.LA(1) == Token.EOF) matchedEOF = true;
                    _errHandler.reportMatch(this);
                    consume();
                }
                setState(290);
                expression();
                setState(291);
                match(DO);
                setState(298);
                _errHandler.sync(this);
                switch (_input.LA(1)) {
                    case IF:
                    case FOR:
                    case WHILE:
                    case STRING_N:
                    case NAME_STRING: {
                        setState(292);
                        statement();
                    }
                    break;
                    case BEGIN: {
                        setState(293);
                        match(BEGIN);
                        setState(294);
                        contextMain();
                        setState(295);
                        match(END);
                        setState(296);
                        match(SEMICOLON);
                    }
                    break;
                    default:
                        throw new NoViableAltException(this);
                }
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final NamesListContext namesList() throws RecognitionException {
        NamesListContext _localctx = new NamesListContext(_ctx, getState());
        enterRule(_localctx, 70, RULE_namesList);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(300);
                match(NAME_STRING);
                setState(305);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while (_la == COMMA) {
                    {
                        {
                            setState(301);
                            match(COMMA);
                            setState(302);
                            match(NAME_STRING);
                        }
                    }
                    setState(307);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                }
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final TypeContext type() throws RecognitionException {
        TypeContext _localctx = new TypeContext(_ctx, getState());
        enterRule(_localctx, 72, RULE_type);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(308);
                _la = _input.LA(1);
                if (!((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INTEGER) | (1L << BOOLEAN) | (1L << STRING) | (1L << REAL) | (1L << CHAR))) != 0))) {
                    _errHandler.recoverInline(this);
                } else {
                    if (_input.LA(1) == Token.EOF) matchedEOF = true;
                    _errHandler.reportMatch(this);
                    consume();
                }
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class ProgramContext extends ParserRuleContext {
        public ProgramContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public ProgramNameContext programName() {
            return getRuleContext(ProgramNameContext.class, 0);
        }

        public ProgramContextContext programContext() {
            return getRuleContext(ProgramContextContext.class, 0);
        }

        public TerminalNode DOT() {
            return getToken(PascalGrammarParser.DOT, 0);
        }

        public TerminalNode EOF() {
            return getToken(PascalGrammarParser.EOF, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_program;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PascalGrammarListener) ((PascalGrammarListener) listener).enterProgram(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PascalGrammarListener) ((PascalGrammarListener) listener).exitProgram(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof PascalGrammarVisitor)
                return ((PascalGrammarVisitor<? extends T>) visitor).visitProgram(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class ProgramNameContext extends ParserRuleContext {
        public ProgramNameContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public TerminalNode PROGRAM() {
            return getToken(PascalGrammarParser.PROGRAM, 0);
        }

        public TerminalNode NAME_STRING() {
            return getToken(PascalGrammarParser.NAME_STRING, 0);
        }

        public TerminalNode SEMICOLON() {
            return getToken(PascalGrammarParser.SEMICOLON, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_programName;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PascalGrammarListener) ((PascalGrammarListener) listener).enterProgramName(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PascalGrammarListener) ((PascalGrammarListener) listener).exitProgramName(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof PascalGrammarVisitor)
                return ((PascalGrammarVisitor<? extends T>) visitor).visitProgramName(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class ProgramContextContext extends ParserRuleContext {
        public ProgramContextContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public MainContext main() {
            return getRuleContext(MainContext.class, 0);
        }

        public List<ConstContextContext> constContext() {
            return getRuleContexts(ConstContextContext.class);
        }

        public ConstContextContext constContext(int i) {
            return getRuleContext(ConstContextContext.class, i);
        }

        public List<VarContextContext> varContext() {
            return getRuleContexts(VarContextContext.class);
        }

        public VarContextContext varContext(int i) {
            return getRuleContext(VarContextContext.class, i);
        }

        public List<FunctionProcedureContextContext> functionProcedureContext() {
            return getRuleContexts(FunctionProcedureContextContext.class);
        }

        public FunctionProcedureContextContext functionProcedureContext(int i) {
            return getRuleContext(FunctionProcedureContextContext.class, i);
        }

        @Override
        public int getRuleIndex() {
            return RULE_programContext;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PascalGrammarListener) ((PascalGrammarListener) listener).enterProgramContext(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PascalGrammarListener) ((PascalGrammarListener) listener).exitProgramContext(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof PascalGrammarVisitor)
                return ((PascalGrammarVisitor<? extends T>) visitor).visitProgramContext(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class ConstContextContext extends ParserRuleContext {
        public ConstContextContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public TerminalNode CONST() {
            return getToken(PascalGrammarParser.CONST, 0);
        }

        public List<ConstantContext> constant() {
            return getRuleContexts(ConstantContext.class);
        }

        public ConstantContext constant(int i) {
            return getRuleContext(ConstantContext.class, i);
        }

        @Override
        public int getRuleIndex() {
            return RULE_constContext;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PascalGrammarListener) ((PascalGrammarListener) listener).enterConstContext(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PascalGrammarListener) ((PascalGrammarListener) listener).exitConstContext(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof PascalGrammarVisitor)
                return ((PascalGrammarVisitor<? extends T>) visitor).visitConstContext(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class ConstantContext extends ParserRuleContext {
        public ConstantContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public TerminalNode NAME_STRING() {
            return getToken(PascalGrammarParser.NAME_STRING, 0);
        }

        public TerminalNode COLON() {
            return getToken(PascalGrammarParser.COLON, 0);
        }

        public TypeContext type() {
            return getRuleContext(TypeContext.class, 0);
        }

        public TerminalNode EQUALS() {
            return getToken(PascalGrammarParser.EQUALS, 0);
        }

        public ConstantValueContext constantValue() {
            return getRuleContext(ConstantValueContext.class, 0);
        }

        public TerminalNode SEMICOLON() {
            return getToken(PascalGrammarParser.SEMICOLON, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_constant;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PascalGrammarListener) ((PascalGrammarListener) listener).enterConstant(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PascalGrammarListener) ((PascalGrammarListener) listener).exitConstant(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof PascalGrammarVisitor)
                return ((PascalGrammarVisitor<? extends T>) visitor).visitConstant(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class ConstantValueContext extends ParserRuleContext {
        public ConstantValueContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public TerminalNode NUMBER() {
            return getToken(PascalGrammarParser.NUMBER, 0);
        }

        public TerminalNode STRING_N() {
            return getToken(PascalGrammarParser.STRING_N, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_constantValue;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PascalGrammarListener) ((PascalGrammarListener) listener).enterConstantValue(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PascalGrammarListener) ((PascalGrammarListener) listener).exitConstantValue(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof PascalGrammarVisitor)
                return ((PascalGrammarVisitor<? extends T>) visitor).visitConstantValue(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class VarContextContext extends ParserRuleContext {
        public VarContextContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public TerminalNode VAR() {
            return getToken(PascalGrammarParser.VAR, 0);
        }

        public VariableContext variable() {
            return getRuleContext(VariableContext.class, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_varContext;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PascalGrammarListener) ((PascalGrammarListener) listener).enterVarContext(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PascalGrammarListener) ((PascalGrammarListener) listener).exitVarContext(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof PascalGrammarVisitor)
                return ((PascalGrammarVisitor<? extends T>) visitor).visitVarContext(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class VariableContext extends ParserRuleContext {
        public VariableContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public List<VariableRowContext> variableRow() {
            return getRuleContexts(VariableRowContext.class);
        }

        public VariableRowContext variableRow(int i) {
            return getRuleContext(VariableRowContext.class, i);
        }

        @Override
        public int getRuleIndex() {
            return RULE_variable;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PascalGrammarListener) ((PascalGrammarListener) listener).enterVariable(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PascalGrammarListener) ((PascalGrammarListener) listener).exitVariable(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof PascalGrammarVisitor)
                return ((PascalGrammarVisitor<? extends T>) visitor).visitVariable(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class VariableRowContext extends ParserRuleContext {
        public VariableRowContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public NamesListContext namesList() {
            return getRuleContext(NamesListContext.class, 0);
        }

        public TerminalNode COLON() {
            return getToken(PascalGrammarParser.COLON, 0);
        }

        public TypeContext type() {
            return getRuleContext(TypeContext.class, 0);
        }

        public TerminalNode SEMICOLON() {
            return getToken(PascalGrammarParser.SEMICOLON, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_variableRow;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PascalGrammarListener) ((PascalGrammarListener) listener).enterVariableRow(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PascalGrammarListener) ((PascalGrammarListener) listener).exitVariableRow(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof PascalGrammarVisitor)
                return ((PascalGrammarVisitor<? extends T>) visitor).visitVariableRow(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class FunctionProcedureContextContext extends ParserRuleContext {
        public FunctionProcedureContextContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public MainContext main() {
            return getRuleContext(MainContext.class, 0);
        }

        public TerminalNode SEMICOLON() {
            return getToken(PascalGrammarParser.SEMICOLON, 0);
        }

        public ProcedureHeaderContext procedureHeader() {
            return getRuleContext(ProcedureHeaderContext.class, 0);
        }

        public FunctionHeaderContext functionHeader() {
            return getRuleContext(FunctionHeaderContext.class, 0);
        }

        public VarContextContext varContext() {
            return getRuleContext(VarContextContext.class, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_functionProcedureContext;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PascalGrammarListener)
                ((PascalGrammarListener) listener).enterFunctionProcedureContext(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PascalGrammarListener)
                ((PascalGrammarListener) listener).exitFunctionProcedureContext(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof PascalGrammarVisitor)
                return ((PascalGrammarVisitor<? extends T>) visitor).visitFunctionProcedureContext(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class FunctionHeaderContext extends ParserRuleContext {
        public FunctionHeaderContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public TerminalNode FUNCTION() {
            return getToken(PascalGrammarParser.FUNCTION, 0);
        }

        public TerminalNode NAME_STRING() {
            return getToken(PascalGrammarParser.NAME_STRING, 0);
        }

        public TerminalNode OPEN_BRACKET() {
            return getToken(PascalGrammarParser.OPEN_BRACKET, 0);
        }

        public ArgumentsContext arguments() {
            return getRuleContext(ArgumentsContext.class, 0);
        }

        public TerminalNode CLOSE_BRACKET() {
            return getToken(PascalGrammarParser.CLOSE_BRACKET, 0);
        }

        public TerminalNode COLON() {
            return getToken(PascalGrammarParser.COLON, 0);
        }

        public TypeContext type() {
            return getRuleContext(TypeContext.class, 0);
        }

        public TerminalNode SEMICOLON() {
            return getToken(PascalGrammarParser.SEMICOLON, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_functionHeader;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PascalGrammarListener) ((PascalGrammarListener) listener).enterFunctionHeader(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PascalGrammarListener) ((PascalGrammarListener) listener).exitFunctionHeader(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof PascalGrammarVisitor)
                return ((PascalGrammarVisitor<? extends T>) visitor).visitFunctionHeader(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class ProcedureHeaderContext extends ParserRuleContext {
        public ProcedureHeaderContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public TerminalNode PROCEDURE() {
            return getToken(PascalGrammarParser.PROCEDURE, 0);
        }

        public TerminalNode NAME_STRING() {
            return getToken(PascalGrammarParser.NAME_STRING, 0);
        }

        public TerminalNode OPEN_BRACKET() {
            return getToken(PascalGrammarParser.OPEN_BRACKET, 0);
        }

        public ArgumentsContext arguments() {
            return getRuleContext(ArgumentsContext.class, 0);
        }

        public TerminalNode CLOSE_BRACKET() {
            return getToken(PascalGrammarParser.CLOSE_BRACKET, 0);
        }

        public TerminalNode SEMICOLON() {
            return getToken(PascalGrammarParser.SEMICOLON, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_procedureHeader;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PascalGrammarListener)
                ((PascalGrammarListener) listener).enterProcedureHeader(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PascalGrammarListener) ((PascalGrammarListener) listener).exitProcedureHeader(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof PascalGrammarVisitor)
                return ((PascalGrammarVisitor<? extends T>) visitor).visitProcedureHeader(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class ArgumentsContext extends ParserRuleContext {
        public ArgumentsContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public List<NamesListContext> namesList() {
            return getRuleContexts(NamesListContext.class);
        }

        public NamesListContext namesList(int i) {
            return getRuleContext(NamesListContext.class, i);
        }

        public List<TerminalNode> COLON() {
            return getTokens(PascalGrammarParser.COLON);
        }

        public TerminalNode COLON(int i) {
            return getToken(PascalGrammarParser.COLON, i);
        }

        public List<TypeContext> type() {
            return getRuleContexts(TypeContext.class);
        }

        public TypeContext type(int i) {
            return getRuleContext(TypeContext.class, i);
        }

        public List<TerminalNode> COMMA() {
            return getTokens(PascalGrammarParser.COMMA);
        }

        public TerminalNode COMMA(int i) {
            return getToken(PascalGrammarParser.COMMA, i);
        }

        @Override
        public int getRuleIndex() {
            return RULE_arguments;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PascalGrammarListener) ((PascalGrammarListener) listener).enterArguments(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PascalGrammarListener) ((PascalGrammarListener) listener).exitArguments(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof PascalGrammarVisitor)
                return ((PascalGrammarVisitor<? extends T>) visitor).visitArguments(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class MainContext extends ParserRuleContext {
        public MainContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public TerminalNode BEGIN() {
            return getToken(PascalGrammarParser.BEGIN, 0);
        }

        public ContextMainContext contextMain() {
            return getRuleContext(ContextMainContext.class, 0);
        }

        public TerminalNode END() {
            return getToken(PascalGrammarParser.END, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_main;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PascalGrammarListener) ((PascalGrammarListener) listener).enterMain(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PascalGrammarListener) ((PascalGrammarListener) listener).exitMain(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof PascalGrammarVisitor)
                return ((PascalGrammarVisitor<? extends T>) visitor).visitMain(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class ContextMainContext extends ParserRuleContext {
        public ContextMainContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public List<StatementContext> statement() {
            return getRuleContexts(StatementContext.class);
        }

        public StatementContext statement(int i) {
            return getRuleContext(StatementContext.class, i);
        }

        public List<TerminalNode> SEMICOLON() {
            return getTokens(PascalGrammarParser.SEMICOLON);
        }

        public TerminalNode SEMICOLON(int i) {
            return getToken(PascalGrammarParser.SEMICOLON, i);
        }

        @Override
        public int getRuleIndex() {
            return RULE_contextMain;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PascalGrammarListener) ((PascalGrammarListener) listener).enterContextMain(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PascalGrammarListener) ((PascalGrammarListener) listener).exitContextMain(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof PascalGrammarVisitor)
                return ((PascalGrammarVisitor<? extends T>) visitor).visitContextMain(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class StatementContext extends ParserRuleContext {
        public StatementContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public AssignmentStatementContext assignmentStatement() {
            return getRuleContext(AssignmentStatementContext.class, 0);
        }

        public FunctionCallContext functionCall() {
            return getRuleContext(FunctionCallContext.class, 0);
        }

        public LogicCicleStatmentsContext logicCicleStatments() {
            return getRuleContext(LogicCicleStatmentsContext.class, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_statement;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PascalGrammarListener) ((PascalGrammarListener) listener).enterStatement(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PascalGrammarListener) ((PascalGrammarListener) listener).exitStatement(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof PascalGrammarVisitor)
                return ((PascalGrammarVisitor<? extends T>) visitor).visitStatement(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class AssignmentStatementContext extends ParserRuleContext {
        public AssignmentStatementContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public VarWrapperContext varWrapper() {
            return getRuleContext(VarWrapperContext.class, 0);
        }

        public TerminalNode ASSIGN() {
            return getToken(PascalGrammarParser.ASSIGN, 0);
        }

        public ExpressionContext expression() {
            return getRuleContext(ExpressionContext.class, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_assignmentStatement;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PascalGrammarListener)
                ((PascalGrammarListener) listener).enterAssignmentStatement(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PascalGrammarListener)
                ((PascalGrammarListener) listener).exitAssignmentStatement(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof PascalGrammarVisitor)
                return ((PascalGrammarVisitor<? extends T>) visitor).visitAssignmentStatement(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class ExpressionContext extends ParserRuleContext {
        public ExpressionContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public SimpleExpressionContext simpleExpression() {
            return getRuleContext(SimpleExpressionContext.class, 0);
        }

        public OperationPr3Context operationPr3() {
            return getRuleContext(OperationPr3Context.class, 0);
        }

        public ExpressionContext expression() {
            return getRuleContext(ExpressionContext.class, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_expression;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PascalGrammarListener) ((PascalGrammarListener) listener).enterExpression(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PascalGrammarListener) ((PascalGrammarListener) listener).exitExpression(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof PascalGrammarVisitor)
                return ((PascalGrammarVisitor<? extends T>) visitor).visitExpression(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class SimpleExpressionContext extends ParserRuleContext {
        public SimpleExpressionContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public TermContext term() {
            return getRuleContext(TermContext.class, 0);
        }

        public OperationPr2Context operationPr2() {
            return getRuleContext(OperationPr2Context.class, 0);
        }

        public SimpleExpressionContext simpleExpression() {
            return getRuleContext(SimpleExpressionContext.class, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_simpleExpression;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PascalGrammarListener)
                ((PascalGrammarListener) listener).enterSimpleExpression(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PascalGrammarListener)
                ((PascalGrammarListener) listener).exitSimpleExpression(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof PascalGrammarVisitor)
                return ((PascalGrammarVisitor<? extends T>) visitor).visitSimpleExpression(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class TermContext extends ParserRuleContext {
        public TermContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public SignedFactorContext signedFactor() {
            return getRuleContext(SignedFactorContext.class, 0);
        }

        public List<OperationPr1Context> operationPr1() {
            return getRuleContexts(OperationPr1Context.class);
        }

        public OperationPr1Context operationPr1(int i) {
            return getRuleContext(OperationPr1Context.class, i);
        }

        public List<TermContext> term() {
            return getRuleContexts(TermContext.class);
        }

        public TermContext term(int i) {
            return getRuleContext(TermContext.class, i);
        }

        @Override
        public int getRuleIndex() {
            return RULE_term;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PascalGrammarListener) ((PascalGrammarListener) listener).enterTerm(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PascalGrammarListener) ((PascalGrammarListener) listener).exitTerm(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof PascalGrammarVisitor)
                return ((PascalGrammarVisitor<? extends T>) visitor).visitTerm(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class SignedFactorContext extends ParserRuleContext {
        public SignedFactorContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public FactorContext factor() {
            return getRuleContext(FactorContext.class, 0);
        }

        public TerminalNode ADD() {
            return getToken(PascalGrammarParser.ADD, 0);
        }

        public TerminalNode SUB() {
            return getToken(PascalGrammarParser.SUB, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_signedFactor;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PascalGrammarListener) ((PascalGrammarListener) listener).enterSignedFactor(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PascalGrammarListener) ((PascalGrammarListener) listener).exitSignedFactor(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof PascalGrammarVisitor)
                return ((PascalGrammarVisitor<? extends T>) visitor).visitSignedFactor(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class FactorContext extends ParserRuleContext {
        public FactorContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public VarWrapperContext varWrapper() {
            return getRuleContext(VarWrapperContext.class, 0);
        }

        public TerminalNode OPEN_BRACKET() {
            return getToken(PascalGrammarParser.OPEN_BRACKET, 0);
        }

        public ExpressionContext expression() {
            return getRuleContext(ExpressionContext.class, 0);
        }

        public TerminalNode CLOSE_BRACKET() {
            return getToken(PascalGrammarParser.CLOSE_BRACKET, 0);
        }

        public FunctionCallContext functionCall() {
            return getRuleContext(FunctionCallContext.class, 0);
        }

        public UnsignedConstantContext unsignedConstant() {
            return getRuleContext(UnsignedConstantContext.class, 0);
        }

        public TerminalNode NOT() {
            return getToken(PascalGrammarParser.NOT, 0);
        }

        public FactorContext factor() {
            return getRuleContext(FactorContext.class, 0);
        }

        public BoolContext bool() {
            return getRuleContext(BoolContext.class, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_factor;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PascalGrammarListener) ((PascalGrammarListener) listener).enterFactor(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PascalGrammarListener) ((PascalGrammarListener) listener).exitFactor(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof PascalGrammarVisitor)
                return ((PascalGrammarVisitor<? extends T>) visitor).visitFactor(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class BoolContext extends ParserRuleContext {
        public BoolContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public TerminalNode TRUE() {
            return getToken(PascalGrammarParser.TRUE, 0);
        }

        public TerminalNode FALSE() {
            return getToken(PascalGrammarParser.FALSE, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_bool;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PascalGrammarListener) ((PascalGrammarListener) listener).enterBool(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PascalGrammarListener) ((PascalGrammarListener) listener).exitBool(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof PascalGrammarVisitor)
                return ((PascalGrammarVisitor<? extends T>) visitor).visitBool(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class UnsignedConstantContext extends ParserRuleContext {
        public UnsignedConstantContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public TerminalNode NUMBER() {
            return getToken(PascalGrammarParser.NUMBER, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_unsignedConstant;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PascalGrammarListener)
                ((PascalGrammarListener) listener).enterUnsignedConstant(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PascalGrammarListener)
                ((PascalGrammarListener) listener).exitUnsignedConstant(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof PascalGrammarVisitor)
                return ((PascalGrammarVisitor<? extends T>) visitor).visitUnsignedConstant(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class FunctionCallContext extends ParserRuleContext {
        public FunctionCallContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public TerminalNode NAME_STRING() {
            return getToken(PascalGrammarParser.NAME_STRING, 0);
        }

        public TerminalNode OPEN_BRACKET() {
            return getToken(PascalGrammarParser.OPEN_BRACKET, 0);
        }

        public ParameterListContext parameterList() {
            return getRuleContext(ParameterListContext.class, 0);
        }

        public TerminalNode CLOSE_BRACKET() {
            return getToken(PascalGrammarParser.CLOSE_BRACKET, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_functionCall;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PascalGrammarListener) ((PascalGrammarListener) listener).enterFunctionCall(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PascalGrammarListener) ((PascalGrammarListener) listener).exitFunctionCall(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof PascalGrammarVisitor)
                return ((PascalGrammarVisitor<? extends T>) visitor).visitFunctionCall(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class ParameterListContext extends ParserRuleContext {
        public ParameterListContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public List<ExpressionContext> expression() {
            return getRuleContexts(ExpressionContext.class);
        }

        public ExpressionContext expression(int i) {
            return getRuleContext(ExpressionContext.class, i);
        }

        public List<TerminalNode> COMMA() {
            return getTokens(PascalGrammarParser.COMMA);
        }

        public TerminalNode COMMA(int i) {
            return getToken(PascalGrammarParser.COMMA, i);
        }

        @Override
        public int getRuleIndex() {
            return RULE_parameterList;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PascalGrammarListener) ((PascalGrammarListener) listener).enterParameterList(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PascalGrammarListener) ((PascalGrammarListener) listener).exitParameterList(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof PascalGrammarVisitor)
                return ((PascalGrammarVisitor<? extends T>) visitor).visitParameterList(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class OperationPr1Context extends ParserRuleContext {
        public OperationPr1Context(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public TerminalNode MUL() {
            return getToken(PascalGrammarParser.MUL, 0);
        }

        public TerminalNode DIVS() {
            return getToken(PascalGrammarParser.DIVS, 0);
        }

        public TerminalNode MODS() {
            return getToken(PascalGrammarParser.MODS, 0);
        }

        public TerminalNode AND() {
            return getToken(PascalGrammarParser.AND, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_operationPr1;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PascalGrammarListener) ((PascalGrammarListener) listener).enterOperationPr1(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PascalGrammarListener) ((PascalGrammarListener) listener).exitOperationPr1(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof PascalGrammarVisitor)
                return ((PascalGrammarVisitor<? extends T>) visitor).visitOperationPr1(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class OperationPr2Context extends ParserRuleContext {
        public OperationPr2Context(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public TerminalNode ADD() {
            return getToken(PascalGrammarParser.ADD, 0);
        }

        public TerminalNode SUB() {
            return getToken(PascalGrammarParser.SUB, 0);
        }

        public TerminalNode OR() {
            return getToken(PascalGrammarParser.OR, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_operationPr2;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PascalGrammarListener) ((PascalGrammarListener) listener).enterOperationPr2(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PascalGrammarListener) ((PascalGrammarListener) listener).exitOperationPr2(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof PascalGrammarVisitor)
                return ((PascalGrammarVisitor<? extends T>) visitor).visitOperationPr2(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class OperationPr3Context extends ParserRuleContext {
        public OperationPr3Context(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public TerminalNode EQUALS() {
            return getToken(PascalGrammarParser.EQUALS, 0);
        }

        public TerminalNode N_EQUAL() {
            return getToken(PascalGrammarParser.N_EQUAL, 0);
        }

        public TerminalNode LT() {
            return getToken(PascalGrammarParser.LT, 0);
        }

        public TerminalNode LE() {
            return getToken(PascalGrammarParser.LE, 0);
        }

        public TerminalNode GE() {
            return getToken(PascalGrammarParser.GE, 0);
        }

        public TerminalNode GT() {
            return getToken(PascalGrammarParser.GT, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_operationPr3;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PascalGrammarListener) ((PascalGrammarListener) listener).enterOperationPr3(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PascalGrammarListener) ((PascalGrammarListener) listener).exitOperationPr3(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof PascalGrammarVisitor)
                return ((PascalGrammarVisitor<? extends T>) visitor).visitOperationPr3(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class VarWrapperContext extends ParserRuleContext {
        public VarWrapperContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public TerminalNode NAME_STRING() {
            return getToken(PascalGrammarParser.NAME_STRING, 0);
        }

        public TerminalNode STRING_N() {
            return getToken(PascalGrammarParser.STRING_N, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_varWrapper;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PascalGrammarListener) ((PascalGrammarListener) listener).enterVarWrapper(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PascalGrammarListener) ((PascalGrammarListener) listener).exitVarWrapper(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof PascalGrammarVisitor)
                return ((PascalGrammarVisitor<? extends T>) visitor).visitVarWrapper(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class LogicCicleStatmentsContext extends ParserRuleContext {
        public LogicCicleStatmentsContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public IfStatementContext ifStatement() {
            return getRuleContext(IfStatementContext.class, 0);
        }

        public CycleStatementContext cycleStatement() {
            return getRuleContext(CycleStatementContext.class, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_logicCicleStatments;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PascalGrammarListener)
                ((PascalGrammarListener) listener).enterLogicCicleStatments(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PascalGrammarListener)
                ((PascalGrammarListener) listener).exitLogicCicleStatments(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof PascalGrammarVisitor)
                return ((PascalGrammarVisitor<? extends T>) visitor).visitLogicCicleStatments(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class IfStatementContext extends ParserRuleContext {
        public IfStatementContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public TerminalNode IF() {
            return getToken(PascalGrammarParser.IF, 0);
        }

        public ExpressionContext expression() {
            return getRuleContext(ExpressionContext.class, 0);
        }

        public TerminalNode THEN() {
            return getToken(PascalGrammarParser.THEN, 0);
        }

        public StatementContext statement() {
            return getRuleContext(StatementContext.class, 0);
        }

        public TerminalNode BEGIN() {
            return getToken(PascalGrammarParser.BEGIN, 0);
        }

        public ContextMainContext contextMain() {
            return getRuleContext(ContextMainContext.class, 0);
        }

        public TerminalNode END() {
            return getToken(PascalGrammarParser.END, 0);
        }

        public TerminalNode ELSE() {
            return getToken(PascalGrammarParser.ELSE, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_ifStatement;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PascalGrammarListener) ((PascalGrammarListener) listener).enterIfStatement(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PascalGrammarListener) ((PascalGrammarListener) listener).exitIfStatement(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof PascalGrammarVisitor)
                return ((PascalGrammarVisitor<? extends T>) visitor).visitIfStatement(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class CycleStatementContext extends ParserRuleContext {
        public CycleStatementContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public WhileStatementContext whileStatement() {
            return getRuleContext(WhileStatementContext.class, 0);
        }

        public ForStatementContext forStatement() {
            return getRuleContext(ForStatementContext.class, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_cycleStatement;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PascalGrammarListener) ((PascalGrammarListener) listener).enterCycleStatement(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PascalGrammarListener) ((PascalGrammarListener) listener).exitCycleStatement(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof PascalGrammarVisitor)
                return ((PascalGrammarVisitor<? extends T>) visitor).visitCycleStatement(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class WhileStatementContext extends ParserRuleContext {
        public WhileStatementContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public TerminalNode WHILE() {
            return getToken(PascalGrammarParser.WHILE, 0);
        }

        public TerminalNode OPEN_BRACKET() {
            return getToken(PascalGrammarParser.OPEN_BRACKET, 0);
        }

        public ExpressionContext expression() {
            return getRuleContext(ExpressionContext.class, 0);
        }

        public TerminalNode CLOSE_BRACKET() {
            return getToken(PascalGrammarParser.CLOSE_BRACKET, 0);
        }

        public TerminalNode DO() {
            return getToken(PascalGrammarParser.DO, 0);
        }

        public StatementContext statement() {
            return getRuleContext(StatementContext.class, 0);
        }

        public TerminalNode BEGIN() {
            return getToken(PascalGrammarParser.BEGIN, 0);
        }

        public ContextMainContext contextMain() {
            return getRuleContext(ContextMainContext.class, 0);
        }

        public TerminalNode END() {
            return getToken(PascalGrammarParser.END, 0);
        }

        public TerminalNode SEMICOLON() {
            return getToken(PascalGrammarParser.SEMICOLON, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_whileStatement;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PascalGrammarListener) ((PascalGrammarListener) listener).enterWhileStatement(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PascalGrammarListener) ((PascalGrammarListener) listener).exitWhileStatement(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof PascalGrammarVisitor)
                return ((PascalGrammarVisitor<? extends T>) visitor).visitWhileStatement(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class ForStatementContext extends ParserRuleContext {
        public ForStatementContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public TerminalNode FOR() {
            return getToken(PascalGrammarParser.FOR, 0);
        }

        public VarWrapperContext varWrapper() {
            return getRuleContext(VarWrapperContext.class, 0);
        }

        public TerminalNode ASSIGN() {
            return getToken(PascalGrammarParser.ASSIGN, 0);
        }

        public List<ExpressionContext> expression() {
            return getRuleContexts(ExpressionContext.class);
        }

        public ExpressionContext expression(int i) {
            return getRuleContext(ExpressionContext.class, i);
        }

        public TerminalNode DO() {
            return getToken(PascalGrammarParser.DO, 0);
        }

        public TerminalNode TO() {
            return getToken(PascalGrammarParser.TO, 0);
        }

        public TerminalNode DOWNTO() {
            return getToken(PascalGrammarParser.DOWNTO, 0);
        }

        public StatementContext statement() {
            return getRuleContext(StatementContext.class, 0);
        }

        public TerminalNode BEGIN() {
            return getToken(PascalGrammarParser.BEGIN, 0);
        }

        public ContextMainContext contextMain() {
            return getRuleContext(ContextMainContext.class, 0);
        }

        public TerminalNode END() {
            return getToken(PascalGrammarParser.END, 0);
        }

        public TerminalNode SEMICOLON() {
            return getToken(PascalGrammarParser.SEMICOLON, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_forStatement;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PascalGrammarListener) ((PascalGrammarListener) listener).enterForStatement(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PascalGrammarListener) ((PascalGrammarListener) listener).exitForStatement(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof PascalGrammarVisitor)
                return ((PascalGrammarVisitor<? extends T>) visitor).visitForStatement(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class NamesListContext extends ParserRuleContext {
        public NamesListContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public List<TerminalNode> NAME_STRING() {
            return getTokens(PascalGrammarParser.NAME_STRING);
        }

        public TerminalNode NAME_STRING(int i) {
            return getToken(PascalGrammarParser.NAME_STRING, i);
        }

        public List<TerminalNode> COMMA() {
            return getTokens(PascalGrammarParser.COMMA);
        }

        public TerminalNode COMMA(int i) {
            return getToken(PascalGrammarParser.COMMA, i);
        }

        @Override
        public int getRuleIndex() {
            return RULE_namesList;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PascalGrammarListener) ((PascalGrammarListener) listener).enterNamesList(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PascalGrammarListener) ((PascalGrammarListener) listener).exitNamesList(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof PascalGrammarVisitor)
                return ((PascalGrammarVisitor<? extends T>) visitor).visitNamesList(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class TypeContext extends ParserRuleContext {
        public TypeContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public TerminalNode INTEGER() {
            return getToken(PascalGrammarParser.INTEGER, 0);
        }

        public TerminalNode BOOLEAN() {
            return getToken(PascalGrammarParser.BOOLEAN, 0);
        }

        public TerminalNode STRING() {
            return getToken(PascalGrammarParser.STRING, 0);
        }

        public TerminalNode REAL() {
            return getToken(PascalGrammarParser.REAL, 0);
        }

        public TerminalNode CHAR() {
            return getToken(PascalGrammarParser.CHAR, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_type;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PascalGrammarListener) ((PascalGrammarListener) listener).enterType(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PascalGrammarListener) ((PascalGrammarListener) listener).exitType(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof PascalGrammarVisitor)
                return ((PascalGrammarVisitor<? extends T>) visitor).visitType(this);
            else return visitor.visitChildren(this);
        }
    }
}