grammar InputGrammarParser;

@header {
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.Collections;
import ru.ifmo.antll1.entities.*;
}

grammarFile returns [Grammar grammar]
    : gn=grammarName h=headers sr=startRule r=rulesQ t=tokensss ig=ignoreTokens
      { $grammar = new Grammar();
      $grammar.grammarName = $gn.name;
      $grammar.headers = $h.code;
      $grammar.startRule = $sr.name;
      $grammar.getRules().addAll($r.list);
      $grammar.getTokens().addAll($t.list);
      $grammar.getIgnore().addAll($ig.list); }
    ;

grammarName returns [String name]
    : GRAMMAR w2=WORD { $name = $w2.getText(); } SEMICOLON
    ;

headers returns [CodeStep code]
    : { $code = new CodeStep(""); }
    | HEADER codet=CODE { $code = new CodeStep($codet.getText()); }
    ;

startRule returns [String name]
    : START EQLUALLY w2=WORD { $name = $w2.getText(); } SEMICOLON
    ;

rulesQ returns [ArrayList<Rule> list]
    : { $list = new ArrayList<Rule>(); }
    | RULES { ArrayList<Rule> listRes = new ArrayList<>(); } OPEN_STUPID_BRACKET (r=ruleQ { listRes.add($r.ruleq); })* CLOSE_STUPID_BRACKET { $list = listRes; }
    ;

ruleQ returns [Rule ruleq]
    : w1=WORD {$ruleq = new Rule($w1.getText());} OPEN_BRACKET par=parameters CLOSE_BRACKET RETURNS ret=returnValue { $ruleq.getParameters().addAll($par.list); $ruleq.returnType = $ret.returnType; } COLON (c1=condition { $ruleq.getConditions().add($c1.cond); } (OR c2=condition { $ruleq.getConditions().add($c2.cond); })* )? SEMICOLON
    | w1=WORD {$ruleq = new Rule($w1.getText());} OPEN_BRACKET par=parameters CLOSE_BRACKET { $ruleq.getParameters().addAll($par.list); $ruleq.returnType = new ReturnField("none", "none", ""); } COLON (c1=condition { $ruleq.getConditions().add($c1.cond); } (OR c2=condition { $ruleq.getConditions().add($c2.cond); })* )? SEMICOLON
    ;

parameters returns [ArrayList<Parameter> list]
    : { $list = new ArrayList<Parameter>(); }
    | var1=WORD { ArrayList<Parameter> listRes = new ArrayList<>(); } COLON type1=WORD { listRes.add(new Parameter($var1.getText(), $type1.getText())); } (COMMA var2=WORD COLON type2=WORD { listRes.add(new Parameter($var2.getText(), $type2.getText())); })* { $list = listRes; }
    ;

returnValue returns [ReturnField returnType]
    : var1=WORD COLON type1=WORD { $returnType = new ReturnField($var1.getText(), $type1.getText(), ""); }
    | var1=WORD COLON type1=WORD codeInit=CODE  { $returnType = new ReturnField($var1.getText(), $type1.getText(), $codeInit.getText().substring(1,$codeInit.getText().length() - 1)); }
    ;


condition returns [Condition cond]
    : { ArrayList<Step> listRes = new ArrayList<>(); } (s=step { listRes.add($s.stepq); })+ { $cond = new Condition(); $cond.getSteps().addAll(listRes); }
    ;

step returns [Step stepq]
    : c=CODE { $stepq = new CodeStep($c.getText()); }
    | w1=WORD { $stepq = new RuleTermStep($w1.getText().toLowerCase(), $w1.getText()); }
    | w1=WORD EQLUALLY w2=WORD { $stepq = new RuleTermStep($w1.getText(), $w2.getText()); }
    | w1=WORD EQLUALLY w2=WORD { String tmp_str = $w2.getText() + "("; } OPEN_BRACKET (w3=(WORDARGFUN | NUMBER | WORD) { if ($w3.getText().charAt(0) != '$') {tmp_str = tmp_str + $w3.getText();} else {tmp_str = tmp_str + $w3.getText().substring(1, $w3.getText().length() - 1);} } (COMMA w4=(WORDARGFUN | NUMBER | WORD)  { if ($w4.getText().charAt(0) != '$') {tmp_str = tmp_str + $w4.getText();} else {tmp_str = tmp_str + $w4.getText().substring(1, $w4.getText().length() - 1);} })*)? CLOSE_BRACKET { tmp_str = tmp_str + ")"; $stepq = new RuleTermStep($w1.getText(), tmp_str); }
    | w2=WORD { String tmp_str = $w2.getText() + "("; } OPEN_BRACKET (w3=(WORDARGFUN | NUMBER | WORD)   { if ($w3.getText().charAt(0) != '$') {tmp_str = tmp_str + $w3.getText();} else {tmp_str = tmp_str + $w3.getText().substring(1, $w3.getText().length() - 1);} } (COMMA w4=(WORDARGFUN | NUMBER | WORD)  { if ($w4.getText().charAt(0) != '$') {tmp_str = tmp_str + $w4.getText();} else {tmp_str = tmp_str + $w4.getText().substring(1, $w4.getText().length() - 1);} })*)? CLOSE_BRACKET { tmp_str = tmp_str + ")"; $stepq = new RuleTermStep($w2.getText().toLowerCase(), tmp_str); }
    ;

tokensss returns [ArrayList<TokenQ> list]
    : { $list = new ArrayList<TokenQ>(); }
    | TOKENS { ArrayList<TokenQ> listRes = new ArrayList<>(); } OPEN_STUPID_BRACKET (tokenName=WORD EQLUALLY regexp=REGEXP { listRes.add(new TokenQ($tokenName.getText(), $regexp.getText().substring(1, $regexp.getText().length() - 1))); } SEMICOLON)* CLOSE_STUPID_BRACKET { $list = listRes; }
    ;

ignoreTokens returns [ArrayList<Ignore> list]
    : { $list = new ArrayList<Ignore>(); }
    | IGNORE { ArrayList<Ignore> listRes = new ArrayList<>(); } OPEN_STUPID_BRACKET (w1=WORD { listRes.add(new Ignore($w1.getText())); } (COMMA w2=WORD { listRes.add(new Ignore($w2.getText())); })* SEMICOLON )? CLOSE_STUPID_BRACKET { $list = listRes; }
    ;

GRAMMAR: 'grammar';
HEADER : 'header' ;
RULES  : 'rules'  ;
START  : 'start'  ;
TOKENS : 'tokens' ;
IGNORE : 'ignore' ;
IMPORT : 'import' ;
RETURNS: 'returns';

SEMICOLON    : ';';
OPEN_CLOSURE : '{';
CLOSE_CLOSURE: '}';
OPEN_STUPID_BRACKET: '[';
CLOSE_STUPID_BRACKET: ']';
OPEN_BRACKET : '(';
CLOSE_BRACKET: ')';
EQLUALLY     : '=';
COMMA        : ',';
COLON        : ':';
OR           : '|';

//TEXTWITHDOT  : ([a-zA-Z0-9]+('.'|'('')')?)+  ;
WORDARGFUN : '$'(~[{}]+ WORDARGFUN?)* '$';
WORD  : [a-zA-Z][a-zA-Z0-9_]*  ;

//BOOMBRAIN1  : [a-zA-Z0-9.]+ ;
//BOOMBRAIN2  : [^,]+')'  ;
NUMBER  : [1-9][0-9]* | '0' ;
CODE  : '{' (~[{}]+ CODE?)* '}';
REGEXP: '"'(~["])+'"'          ;

WS          : [ \t\r\n]+    -> skip;
COMMENT     : '/*' .*? '*/' -> skip;
LINE_COMMENT: '//' ~[\r\n]* -> skip;