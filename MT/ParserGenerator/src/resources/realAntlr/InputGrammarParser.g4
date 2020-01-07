grammar InputGrammarParser;

@header {
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.Collections;
import ru.ifmo.antll1.*;
}

grammarFile returns [Grammar grammar]
    : gn=grammarName h=headers sr=startRule r=rulesQ t=tokensss ig=ignoreTokens
      { $grammar = new Grammar();
      $grammar.grammarName = $gn.name;
      $grammar.getHeaders().addAll($h.list);
      $grammar.startRule = $sr.name;
      $grammar.getRules().addAll($r.list);
      $grammar.getTokens().addAll($t.list);
      $grammar.getIgnore().addAll($ig.list); }
    ;

grammarName returns [String name]
    : GRAMMAR w2=WORD { $name = $w2.getText(); } SEMICOLON
    ;

headers returns [ArrayList<String> list]
    : { $list = new ArrayList<String>(); }
    | HEADER { ArrayList<String> listRes = new ArrayList<>(); } OPEN_CLOSURE (IMPORT importW=WORD { listRes.add($importW.getText()); } SEMICOLON)* CLOSE_CLOSURE { $list = listRes; }
    ;

startRule returns [String name]
    : START EQLUALLY w2=WORD { $name = $w2.getText(); } SEMICOLON
    ;

rulesQ returns [ArrayList<Rule> list]
    : { $list = new ArrayList<Rule>(); }
    | RULES { ArrayList<Rule> listRes = new ArrayList<>(); } OPEN_CLOSURE (r=ruleQ { listRes.add($r.ruleq); })* CLOSE_CLOSURE { $list = listRes; }
    ;

ruleQ returns [Rule ruleq]
    : w1=WORD {$ruleq = new Rule($w1.getText());} OPEN_BRACKET par=parameters CLOSE_BRACKET RETURNS ret=returnValue { $ruleq.getParameters().addAll($par.list); $ruleq.returnType = $ret.returnType; } COLON (c1=condition { $ruleq.getConditions().add($c1.cond); } (OR c2=condition { $ruleq.getConditions().add($c2.cond); })* )? SEMICOLON
    ;

parameters returns [ArrayList<Parameter> list]
    : { $list = new ArrayList<Parameter>(); }
    | var1=WORD { ArrayList<Parameter> listRes = new ArrayList<>(); } COLON type1=WORD { listRes.add(new Parameter($var1.getText(), $type1.getText())); } (COMMA var2=WORD COLON type2=WORD { listRes.add(new Parameter($var2.getText(), $type2.getText())); })* { $list = listRes; }
    ;

returnValue returns [ReturnField returnType]
    : var1=WORD COLON type1=WORD { $returnType = new ReturnField($var1.getText(), $type1.getText()); }
    ;


condition returns [Condition cond]
    : { ArrayList<Step> listRes = new ArrayList<>(); } (s=step { listRes.add($s.stepq); })+ { $cond = new Condition(); $cond.getSteps().addAll(listRes); }
    ;

step returns [Step stepq]
    : c=CODE { $stepq = new CodeStep($c.getText()); }
    | w1=WORD { $stepq = new RuleTermStep("", $w1.getText()); }
    | w1=WORD EQLUALLY w2=WORD { $stepq = new RuleTermStep($w1.getText(), $w2.getText()); }
    | w1=WORD EQLUALLY w2=WORD { String tmp_str = $w2.getText() + "("; } OPEN_BRACKET (w3=WORD { tmp_str = tmp_str + $w3.getText(); } (COMMA w4=WORD { tmp_str = tmp_str + ", " + $w4.getText(); })*)? CLOSE_BRACKET { tmp_str = tmp_str + ")"; $stepq = new RuleTermStep($w1.getText(), tmp_str); }
    | w2=WORD { String tmp_str = $w2.getText() + "("; } OPEN_BRACKET (w3=WORD { tmp_str = tmp_str + $w3.getText(); } (COMMA w4=WORD { tmp_str = tmp_str + ", " + $w4.getText(); })*)? CLOSE_BRACKET { tmp_str = tmp_str + ")"; $stepq = new RuleTermStep("", tmp_str); }
    ;

tokensss returns [ArrayList<TokenQ> list]
    : { $list = new ArrayList<TokenQ>(); }
    | TOKENS { ArrayList<TokenQ> listRes = new ArrayList<>(); } OPEN_CLOSURE (tokenName=WORD EQLUALLY regexp=REGEXP { listRes.add(new TokenQ($tokenName.getText(), $regexp.getText())); } SEMICOLON)* CLOSE_CLOSURE { $list = listRes; }
    ;

ignoreTokens returns [ArrayList<Ignore> list]
    : { $list = new ArrayList<Ignore>(); }
    | IGNORE { ArrayList<Ignore> listRes = new ArrayList<>(); } OPEN_CLOSURE (w1=WORD { listRes.add(new Ignore($w1.getText())); } (COMMA w2=WORD { listRes.add(new Ignore($w2.getText())); })* SEMICOLON )? CLOSE_CLOSURE { $list = listRes; }
    ;

GRAMMAR: 'grammar';
HEADER: 'header';
RULES  : 'rules'  ;
START  : 'start'  ;
TOKENS : 'tokens' ;
IGNORE : 'ignore' ;
IMPORT : 'import' ;
RETURNS: 'returns' ;

SEMICOLON    : ';';
OPEN_CLOSURE : '{';
CLOSE_CLOSURE: '}';
OPEN_BRACKET : '(';
CLOSE_BRACKET: ')';
EQLUALLY     : '=';
COMMA        : ',';
COLON        : ':';
OR           : '|';

WORD  : [a-zA-Z]+;
CODE  : '{' (~[{}]+ CODE?)* '}';
REGEXP: '"'(~["])+'"';
WS    : [ \t\r\n]+ -> skip;
