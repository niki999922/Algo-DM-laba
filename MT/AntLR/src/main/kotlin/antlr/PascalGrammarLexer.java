// Generated from /Users/nikita/Algo-DM-laba/MT/AntLR/src/main/resources/antlr/PascalGrammar.g4 by ANTLR 4.7.2
package antlr;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.ATN;
import org.antlr.v4.runtime.atn.ATNDeserializer;
import org.antlr.v4.runtime.atn.LexerATNSimulator;
import org.antlr.v4.runtime.atn.PredictionContextCache;
import org.antlr.v4.runtime.dfa.DFA;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class PascalGrammarLexer extends Lexer {
    public static final int
            PROGRAM = 1, FUNCTION = 2, PROCEDURE = 3, CONST = 4, INTEGER = 5, BOOLEAN = 6, STRING = 7,
            REAL = 8, CHAR = 9, VAR = 10, BEGIN = 11, END = 12, TRUE = 13, FALSE = 14, OR = 15, AND = 16,
            NOT = 17, IF = 18, THEN = 19, ELSE = 20, FOR = 21, TO = 22, DOWNTO = 23, WHILE = 24, DO = 25,
            ADD = 26, SUB = 27, MUL = 28, DIVS = 29, MODS = 30, EQUALS = 31, N_EQUAL = 32, GT = 33,
            GE = 34, LT = 35, LE = 36, OPEN_BRACKET = 37, CLOSE_BRACKET = 38, DOT = 39, COLON = 40,
            SEMICOLON = 41, COMMA = 42, ASSIGN = 43, NUMBER = 44, STRING_N = 45, NAME_STRING = 46,
            COMMENT_1 = 47, COMMENT_2 = 48, WS = 49;
    public static final String[] ruleNames = makeRuleNames();
    /**
     * @deprecated Use {@link #VOCABULARY} instead.
     */
    @Deprecated
    public static final String[] tokenNames;
    public static final String _serializedATN =
            "\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\63\u01c6\b\1\4\2" +
                    "\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4" +
                    "\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22" +
                    "\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31" +
                    "\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t" +
                    " \4!\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t" +
                    "+\4,\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64" +
                    "\t\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t" +
                    "=\4>\t>\4?\t?\4@\t@\4A\tA\4B\tB\4C\tC\4D\tD\4E\tE\4F\tF\4G\tG\4H\tH\4" +
                    "I\tI\4J\tJ\4K\tK\4L\tL\4M\tM\4N\tN\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\6" +
                    "\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13\3\f\3\f\3\r\3\r\3\16\3" +
                    "\16\3\17\3\17\3\20\3\20\3\21\3\21\3\22\3\22\3\23\3\23\3\24\3\24\3\25\3" +
                    "\25\3\26\3\26\3\27\3\27\3\30\3\30\3\31\3\31\3\32\3\32\3\33\3\33\3\34\6" +
                    "\34\u00d3\n\34\r\34\16\34\u00d4\3\35\3\35\3\36\3\36\3\36\3\36\3\36\3\36" +
                    "\3\36\3\36\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3 \3 \3 \3 \3" +
                    " \3 \3 \3 \3 \3 \3!\3!\3!\3!\3!\3!\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3#" +
                    "\3#\3#\3#\3#\3#\3#\3#\3$\3$\3$\3$\3$\3$\3$\3%\3%\3%\3%\3%\3&\3&\3&\3&" +
                    "\3&\3\'\3\'\3\'\3\'\3(\3(\3(\3(\3(\3(\3)\3)\3)\3)\3*\3*\3*\3*\3*\3+\3" +
                    "+\3+\3+\3+\3+\3,\3,\3,\3-\3-\3-\3-\3.\3.\3.\3.\3/\3/\3/\3\60\3\60\3\60" +
                    "\3\60\3\60\3\61\3\61\3\61\3\61\3\61\3\62\3\62\3\62\3\62\3\63\3\63\3\63" +
                    "\3\64\3\64\3\64\3\64\3\64\3\64\3\64\3\65\3\65\3\65\3\65\3\65\3\65\3\66" +
                    "\3\66\3\66\3\67\3\67\38\38\39\39\3:\3:\3:\3:\3;\3;\3;\3;\3<\3<\3=\3=\3" +
                    "=\3>\3>\3?\3?\3?\3@\3@\3A\3A\3A\3B\3B\3C\3C\3D\3D\3E\3E\3F\3F\3G\3G\3" +
                    "H\3H\3H\3I\5I\u0190\nI\3I\3I\3I\3I\5I\u0196\nI\3J\3J\3J\3J\7J\u019c\n" +
                    "J\fJ\16J\u019f\13J\3J\3J\3K\3K\7K\u01a5\nK\fK\16K\u01a8\13K\3L\3L\3L\3" +
                    "L\7L\u01ae\nL\fL\16L\u01b1\13L\3L\3L\3L\3L\3L\3M\3M\7M\u01ba\nM\fM\16" +
                    "M\u01bd\13M\3M\3M\3M\3M\3N\3N\3N\3N\4\u01af\u01bb\2O\3\2\5\2\7\2\t\2\13" +
                    "\2\r\2\17\2\21\2\23\2\25\2\27\2\31\2\33\2\35\2\37\2!\2#\2%\2\'\2)\2+\2" +
                    "-\2/\2\61\2\63\2\65\2\67\29\2;\3=\4?\5A\6C\7E\bG\tI\nK\13M\fO\rQ\16S\17" +
                    "U\20W\21Y\22[\23]\24_\25a\26c\27e\30g\31i\32k\33m\34o\35q\36s\37u w!y" +
                    "\"{#}$\177%\u0081&\u0083\'\u0085(\u0087)\u0089*\u008b+\u008d,\u008f-\u0091" +
                    ".\u0093/\u0095\60\u0097\61\u0099\62\u009b\63\3\2!\4\2CCcc\4\2DDdd\4\2" +
                    "EEee\4\2FFff\4\2GGgg\4\2HHhh\4\2IIii\4\2JJjj\4\2KKkk\4\2LLll\4\2MMmm\4" +
                    "\2NNnn\4\2OOoo\4\2PPpp\4\2QQqq\4\2RRrr\4\2SSss\4\2TTtt\4\2UUuu\4\2VVv" +
                    "v\4\2WWww\4\2XXxx\4\2YYyy\4\2ZZzz\4\2[[{{\4\2\\\\||\4\2--//\3\2))\5\2" +
                    "C\\aac|\6\2\62;C\\aac|\5\2\13\f\17\17\"\"\2\u01b1\2;\3\2\2\2\2=\3\2\2" +
                    "\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2" +
                    "K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2U\3\2\2\2\2W\3" +
                    "\2\2\2\2Y\3\2\2\2\2[\3\2\2\2\2]\3\2\2\2\2_\3\2\2\2\2a\3\2\2\2\2c\3\2\2" +
                    "\2\2e\3\2\2\2\2g\3\2\2\2\2i\3\2\2\2\2k\3\2\2\2\2m\3\2\2\2\2o\3\2\2\2\2" +
                    "q\3\2\2\2\2s\3\2\2\2\2u\3\2\2\2\2w\3\2\2\2\2y\3\2\2\2\2{\3\2\2\2\2}\3" +
                    "\2\2\2\2\177\3\2\2\2\2\u0081\3\2\2\2\2\u0083\3\2\2\2\2\u0085\3\2\2\2\2" +
                    "\u0087\3\2\2\2\2\u0089\3\2\2\2\2\u008b\3\2\2\2\2\u008d\3\2\2\2\2\u008f" +
                    "\3\2\2\2\2\u0091\3\2\2\2\2\u0093\3\2\2\2\2\u0095\3\2\2\2\2\u0097\3\2\2" +
                    "\2\2\u0099\3\2\2\2\2\u009b\3\2\2\2\3\u009d\3\2\2\2\5\u009f\3\2\2\2\7\u00a1" +
                    "\3\2\2\2\t\u00a3\3\2\2\2\13\u00a5\3\2\2\2\r\u00a7\3\2\2\2\17\u00a9\3\2" +
                    "\2\2\21\u00ab\3\2\2\2\23\u00ad\3\2\2\2\25\u00af\3\2\2\2\27\u00b1\3\2\2" +
                    "\2\31\u00b3\3\2\2\2\33\u00b5\3\2\2\2\35\u00b7\3\2\2\2\37\u00b9\3\2\2\2" +
                    "!\u00bb\3\2\2\2#\u00bd\3\2\2\2%\u00bf\3\2\2\2\'\u00c1\3\2\2\2)\u00c3\3" +
                    "\2\2\2+\u00c5\3\2\2\2-\u00c7\3\2\2\2/\u00c9\3\2\2\2\61\u00cb\3\2\2\2\63" +
                    "\u00cd\3\2\2\2\65\u00cf\3\2\2\2\67\u00d2\3\2\2\29\u00d6\3\2\2\2;\u00d8" +
                    "\3\2\2\2=\u00e0\3\2\2\2?\u00e9\3\2\2\2A\u00f3\3\2\2\2C\u00f9\3\2\2\2E" +
                    "\u0101\3\2\2\2G\u0109\3\2\2\2I\u0110\3\2\2\2K\u0115\3\2\2\2M\u011a\3\2" +
                    "\2\2O\u011e\3\2\2\2Q\u0124\3\2\2\2S\u0128\3\2\2\2U\u012d\3\2\2\2W\u0133" +
                    "\3\2\2\2Y\u0136\3\2\2\2[\u013a\3\2\2\2]\u013e\3\2\2\2_\u0141\3\2\2\2a" +
                    "\u0146\3\2\2\2c\u014b\3\2\2\2e\u014f\3\2\2\2g\u0152\3\2\2\2i\u0159\3\2" +
                    "\2\2k\u015f\3\2\2\2m\u0162\3\2\2\2o\u0164\3\2\2\2q\u0166\3\2\2\2s\u0168" +
                    "\3\2\2\2u\u016c\3\2\2\2w\u0170\3\2\2\2y\u0172\3\2\2\2{\u0175\3\2\2\2}" +
                    "\u0177\3\2\2\2\177\u017a\3\2\2\2\u0081\u017c\3\2\2\2\u0083\u017f\3\2\2" +
                    "\2\u0085\u0181\3\2\2\2\u0087\u0183\3\2\2\2\u0089\u0185\3\2\2\2\u008b\u0187" +
                    "\3\2\2\2\u008d\u0189\3\2\2\2\u008f\u018b\3\2\2\2\u0091\u018f\3\2\2\2\u0093" +
                    "\u0197\3\2\2\2\u0095\u01a2\3\2\2\2\u0097\u01a9\3\2\2\2\u0099\u01b7\3\2" +
                    "\2\2\u009b\u01c2\3\2\2\2\u009d\u009e\t\2\2\2\u009e\4\3\2\2\2\u009f\u00a0" +
                    "\t\3\2\2\u00a0\6\3\2\2\2\u00a1\u00a2\t\4\2\2\u00a2\b\3\2\2\2\u00a3\u00a4" +
                    "\t\5\2\2\u00a4\n\3\2\2\2\u00a5\u00a6\t\6\2\2\u00a6\f\3\2\2\2\u00a7\u00a8" +
                    "\t\7\2\2\u00a8\16\3\2\2\2\u00a9\u00aa\t\b\2\2\u00aa\20\3\2\2\2\u00ab\u00ac" +
                    "\t\t\2\2\u00ac\22\3\2\2\2\u00ad\u00ae\t\n\2\2\u00ae\24\3\2\2\2\u00af\u00b0" +
                    "\t\13\2\2\u00b0\26\3\2\2\2\u00b1\u00b2\t\f\2\2\u00b2\30\3\2\2\2\u00b3" +
                    "\u00b4\t\r\2\2\u00b4\32\3\2\2\2\u00b5\u00b6\t\16\2\2\u00b6\34\3\2\2\2" +
                    "\u00b7\u00b8\t\17\2\2\u00b8\36\3\2\2\2\u00b9\u00ba\t\20\2\2\u00ba \3\2" +
                    "\2\2\u00bb\u00bc\t\21\2\2\u00bc\"\3\2\2\2\u00bd\u00be\t\22\2\2\u00be$" +
                    "\3\2\2\2\u00bf\u00c0\t\23\2\2\u00c0&\3\2\2\2\u00c1\u00c2\t\24\2\2\u00c2" +
                    "(\3\2\2\2\u00c3\u00c4\t\25\2\2\u00c4*\3\2\2\2\u00c5\u00c6\t\26\2\2\u00c6" +
                    ",\3\2\2\2\u00c7\u00c8\t\27\2\2\u00c8.\3\2\2\2\u00c9\u00ca\t\30\2\2\u00ca" +
                    "\60\3\2\2\2\u00cb\u00cc\t\31\2\2\u00cc\62\3\2\2\2\u00cd\u00ce\t\32\2\2" +
                    "\u00ce\64\3\2\2\2\u00cf\u00d0\t\33\2\2\u00d0\66\3\2\2\2\u00d1\u00d3\4" +
                    "\62;\2\u00d2\u00d1\3\2\2\2\u00d3\u00d4\3\2\2\2\u00d4\u00d2\3\2\2\2\u00d4" +
                    "\u00d5\3\2\2\2\u00d58\3\2\2\2\u00d6\u00d7\t\34\2\2\u00d7:\3\2\2\2\u00d8" +
                    "\u00d9\5!\21\2\u00d9\u00da\5%\23\2\u00da\u00db\5\37\20\2\u00db\u00dc\5" +
                    "\17\b\2\u00dc\u00dd\5%\23\2\u00dd\u00de\5\3\2\2\u00de\u00df\5\33\16\2" +
                    "\u00df<\3\2\2\2\u00e0\u00e1\5\r\7\2\u00e1\u00e2\5+\26\2\u00e2\u00e3\5" +
                    "\35\17\2\u00e3\u00e4\5\7\4\2\u00e4\u00e5\5)\25\2\u00e5\u00e6\5\23\n\2" +
                    "\u00e6\u00e7\5\37\20\2\u00e7\u00e8\5\35\17\2\u00e8>\3\2\2\2\u00e9\u00ea" +
                    "\5!\21\2\u00ea\u00eb\5%\23\2\u00eb\u00ec\5\37\20\2\u00ec\u00ed\5\7\4\2" +
                    "\u00ed\u00ee\5\13\6\2\u00ee\u00ef\5\t\5\2\u00ef\u00f0\5+\26\2\u00f0\u00f1" +
                    "\5%\23\2\u00f1\u00f2\5\13\6\2\u00f2@\3\2\2\2\u00f3\u00f4\5\7\4\2\u00f4" +
                    "\u00f5\5\37\20\2\u00f5\u00f6\5\35\17\2\u00f6\u00f7\5\'\24\2\u00f7\u00f8" +
                    "\5)\25\2\u00f8B\3\2\2\2\u00f9\u00fa\5\23\n\2\u00fa\u00fb\5\35\17\2\u00fb" +
                    "\u00fc\5)\25\2\u00fc\u00fd\5\13\6\2\u00fd\u00fe\5\17\b\2\u00fe\u00ff\5" +
                    "\13\6\2\u00ff\u0100\5%\23\2\u0100D\3\2\2\2\u0101\u0102\5\5\3\2\u0102\u0103" +
                    "\5\37\20\2\u0103\u0104\5\37\20\2\u0104\u0105\5\31\r\2\u0105\u0106\5\13" +
                    "\6\2\u0106\u0107\5\3\2\2\u0107\u0108\5\35\17\2\u0108F\3\2\2\2\u0109\u010a" +
                    "\5\'\24\2\u010a\u010b\5)\25\2\u010b\u010c\5%\23\2\u010c\u010d\5\23\n\2" +
                    "\u010d\u010e\5\35\17\2\u010e\u010f\5\17\b\2\u010fH\3\2\2\2\u0110\u0111" +
                    "\5%\23\2\u0111\u0112\5\13\6\2\u0112\u0113\5\3\2\2\u0113\u0114\5\31\r\2" +
                    "\u0114J\3\2\2\2\u0115\u0116\5\7\4\2\u0116\u0117\5\21\t\2\u0117\u0118\5" +
                    "\3\2\2\u0118\u0119\5%\23\2\u0119L\3\2\2\2\u011a\u011b\5-\27\2\u011b\u011c" +
                    "\5\3\2\2\u011c\u011d\5%\23\2\u011dN\3\2\2\2\u011e\u011f\5\5\3\2\u011f" +
                    "\u0120\5\13\6\2\u0120\u0121\5\17\b\2\u0121\u0122\5\23\n\2\u0122\u0123" +
                    "\5\35\17\2\u0123P\3\2\2\2\u0124\u0125\5\13\6\2\u0125\u0126\5\35\17\2\u0126" +
                    "\u0127\5\t\5\2\u0127R\3\2\2\2\u0128\u0129\5)\25\2\u0129\u012a\5%\23\2" +
                    "\u012a\u012b\5+\26\2\u012b\u012c\5\13\6\2\u012cT\3\2\2\2\u012d\u012e\5" +
                    "\r\7\2\u012e\u012f\5\3\2\2\u012f\u0130\5\31\r\2\u0130\u0131\5\'\24\2\u0131" +
                    "\u0132\5\13\6\2\u0132V\3\2\2\2\u0133\u0134\5\37\20\2\u0134\u0135\5%\23" +
                    "\2\u0135X\3\2\2\2\u0136\u0137\5\3\2\2\u0137\u0138\5\35\17\2\u0138\u0139" +
                    "\5\t\5\2\u0139Z\3\2\2\2\u013a\u013b\5\35\17\2\u013b\u013c\5\37\20\2\u013c" +
                    "\u013d\5)\25\2\u013d\\\3\2\2\2\u013e\u013f\5\23\n\2\u013f\u0140\5\r\7" +
                    "\2\u0140^\3\2\2\2\u0141\u0142\5)\25\2\u0142\u0143\5\21\t\2\u0143\u0144" +
                    "\5\13\6\2\u0144\u0145\5\35\17\2\u0145`\3\2\2\2\u0146\u0147\5\13\6\2\u0147" +
                    "\u0148\5\31\r\2\u0148\u0149\5\'\24\2\u0149\u014a\5\13\6\2\u014ab\3\2\2" +
                    "\2\u014b\u014c\5\r\7\2\u014c\u014d\5\37\20\2\u014d\u014e\5%\23\2\u014e" +
                    "d\3\2\2\2\u014f\u0150\5)\25\2\u0150\u0151\5\37\20\2\u0151f\3\2\2\2\u0152" +
                    "\u0153\5\t\5\2\u0153\u0154\5\37\20\2\u0154\u0155\5/\30\2\u0155\u0156\5" +
                    "\35\17\2\u0156\u0157\5)\25\2\u0157\u0158\5\37\20\2\u0158h\3\2\2\2\u0159" +
                    "\u015a\5/\30\2\u015a\u015b\5\21\t\2\u015b\u015c\5\23\n\2\u015c\u015d\5" +
                    "\31\r\2\u015d\u015e\5\13\6\2\u015ej\3\2\2\2\u015f\u0160\5\t\5\2\u0160" +
                    "\u0161\5\37\20\2\u0161l\3\2\2\2\u0162\u0163\7-\2\2\u0163n\3\2\2\2\u0164" +
                    "\u0165\7/\2\2\u0165p\3\2\2\2\u0166\u0167\7,\2\2\u0167r\3\2\2\2\u0168\u0169" +
                    "\5\t\5\2\u0169\u016a\5\23\n\2\u016a\u016b\5-\27\2\u016bt\3\2\2\2\u016c" +
                    "\u016d\5\33\16\2\u016d\u016e\5\37\20\2\u016e\u016f\5\t\5\2\u016fv\3\2" +
                    "\2\2\u0170\u0171\7?\2\2\u0171x\3\2\2\2\u0172\u0173\7>\2\2\u0173\u0174" +
                    "\7@\2\2\u0174z\3\2\2\2\u0175\u0176\7@\2\2\u0176|\3\2\2\2\u0177\u0178\7" +
                    "@\2\2\u0178\u0179\7?\2\2\u0179~\3\2\2\2\u017a\u017b\7>\2\2\u017b\u0080" +
                    "\3\2\2\2\u017c\u017d\7>\2\2\u017d\u017e\7?\2\2\u017e\u0082\3\2\2\2\u017f" +
                    "\u0180\7*\2\2\u0180\u0084\3\2\2\2\u0181\u0182\7+\2\2\u0182\u0086\3\2\2" +
                    "\2\u0183\u0184\7\60\2\2\u0184\u0088\3\2\2\2\u0185\u0186\7<\2\2\u0186\u008a" +
                    "\3\2\2\2\u0187\u0188\7=\2\2\u0188\u008c\3\2\2\2\u0189\u018a\7.\2\2\u018a" +
                    "\u008e\3\2\2\2\u018b\u018c\7<\2\2\u018c\u018d\7?\2\2\u018d\u0090\3\2\2" +
                    "\2\u018e\u0190\59\35\2\u018f\u018e\3\2\2\2\u018f\u0190\3\2\2\2\u0190\u0191" +
                    "\3\2\2\2\u0191\u0195\5\67\34\2\u0192\u0193\5\u0087D\2\u0193\u0194\5\67" +
                    "\34\2\u0194\u0196\3\2\2\2\u0195\u0192\3\2\2\2\u0195\u0196\3\2\2\2\u0196" +
                    "\u0092\3\2\2\2\u0197\u019d\7)\2\2\u0198\u0199\7)\2\2\u0199\u019c\7)\2" +
                    "\2\u019a\u019c\n\35\2\2\u019b\u0198\3\2\2\2\u019b\u019a\3\2\2\2\u019c" +
                    "\u019f\3\2\2\2\u019d\u019b\3\2\2\2\u019d\u019e\3\2\2\2\u019e\u01a0\3\2" +
                    "\2\2\u019f\u019d\3\2\2\2\u01a0\u01a1\7)\2\2\u01a1\u0094\3\2\2\2\u01a2" +
                    "\u01a6\t\36\2\2\u01a3\u01a5\t\37\2\2\u01a4\u01a3\3\2\2\2\u01a5\u01a8\3" +
                    "\2\2\2\u01a6\u01a4\3\2\2\2\u01a6\u01a7\3\2\2\2\u01a7\u0096\3\2\2\2\u01a8" +
                    "\u01a6\3\2\2\2\u01a9\u01aa\7*\2\2\u01aa\u01ab\7,\2\2\u01ab\u01af\3\2\2" +
                    "\2\u01ac\u01ae\13\2\2\2\u01ad\u01ac\3\2\2\2\u01ae\u01b1\3\2\2\2\u01af" +
                    "\u01b0\3\2\2\2\u01af\u01ad\3\2\2\2\u01b0\u01b2\3\2\2\2\u01b1\u01af\3\2" +
                    "\2\2\u01b2\u01b3\7,\2\2\u01b3\u01b4\7+\2\2\u01b4\u01b5\3\2\2\2\u01b5\u01b6" +
                    "\bL\2\2\u01b6\u0098\3\2\2\2\u01b7\u01bb\7}\2\2\u01b8\u01ba\13\2\2\2\u01b9" +
                    "\u01b8\3\2\2\2\u01ba\u01bd\3\2\2\2\u01bb\u01bc\3\2\2\2\u01bb\u01b9\3\2" +
                    "\2\2\u01bc\u01be\3\2\2\2\u01bd\u01bb\3\2\2\2\u01be\u01bf\7\177\2\2\u01bf" +
                    "\u01c0\3\2\2\2\u01c0\u01c1\bM\2\2\u01c1\u009a\3\2\2\2\u01c2\u01c3\t \2" +
                    "\2\u01c3\u01c4\3\2\2\2\u01c4\u01c5\bN\2\2\u01c5\u009c\3\2\2\2\13\2\u00d4" +
                    "\u018f\u0195\u019b\u019d\u01a6\u01af\u01bb\3\b\2\2";
    public static final ATN _ATN =
            new ATNDeserializer().deserialize(_serializedATN.toCharArray());
    protected static final DFA[] _decisionToDFA;
    protected static final PredictionContextCache _sharedContextCache =
            new PredictionContextCache();
    private static final String[] _LITERAL_NAMES = makeLiteralNames();
    private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
    public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);
    public static String[] channelNames = {
            "DEFAULT_TOKEN_CHANNEL", "HIDDEN"
    };
    public static String[] modeNames = {
            "DEFAULT_MODE"
    };

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

    public PascalGrammarLexer(CharStream input) {
        super(input);
        _interp = new LexerATNSimulator(this, _ATN, _decisionToDFA, _sharedContextCache);
    }

    private static String[] makeRuleNames() {
        return new String[]{
                "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N",
                "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "DIGITS",
                "SIGN", "PROGRAM", "FUNCTION", "PROCEDURE", "CONST", "INTEGER", "BOOLEAN",
                "STRING", "REAL", "CHAR", "VAR", "BEGIN", "END", "TRUE", "FALSE", "OR",
                "AND", "NOT", "IF", "THEN", "ELSE", "FOR", "TO", "DOWNTO", "WHILE", "DO",
                "ADD", "SUB", "MUL", "DIVS", "MODS", "EQUALS", "N_EQUAL", "GT", "GE",
                "LT", "LE", "OPEN_BRACKET", "CLOSE_BRACKET", "DOT", "COLON", "SEMICOLON",
                "COMMA", "ASSIGN", "NUMBER", "STRING_N", "NAME_STRING", "COMMENT_1",
                "COMMENT_2", "WS"
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
    public String[] getChannelNames() {
        return channelNames;
    }

    @Override
    public String[] getModeNames() {
        return modeNames;
    }

    @Override
    public ATN getATN() {
        return _ATN;
    }
}