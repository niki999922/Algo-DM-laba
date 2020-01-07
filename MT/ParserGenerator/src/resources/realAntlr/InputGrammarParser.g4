grammar InputGrammarParser;

@headers{
    import java.util.LinkedList;
    import java.util.ArrayList;
    import java.util.Collections;
    import ru.ifmo.antll1.*;
    import sheeeeeeeeeeeeeeeeeeeeeeeet;

}

grammarFile returns [Grammar grammar]
    : gn=grammarName h=headers sr=startRule r=rulesQ t=tokensss ig=ignoreTokens
      {
      $grammar = new Grammar();
      $grammar.grammarName = $gn.name;
      $grammar.headers.add($h.list);
      $grammar.startRule = $sr.name;
      $grammar.rules.add($r.list);
      $grammar.tokens.add($t.list);
      $grammar.ignore.add($ig.list);
       }
    ;

grammarName returns [String name]
    : GRAMMAR w2=WORD { $name = $w2; } SEMICOLON
    ;

headers returns [ArrayList<String> list]
    : { $list = new ArrayList<String>(); }
    | HEADERS { ArrayList<String> listRes = new ArrayList<>(); } OPEN_CLOSURE (IMPORT importW=WORD { listRes.add($importW); } SEMICOLON)* CLOSE_CLOSURE { $list = listRes; }
    ;

startRule returns [String name]
    : START EQLUALLY w2=WORD { $name = $w2; } SEMICOLON
    ;

rulesQ returns [ArrayList<Rule> list]
    : { $list = new ArrayList<Rule>(); }
    | RULES { ArrayList<Rule> listRes = new ArrayList<>(); } OPEN_CLOSURE (r=ruleQ { listRes.add($r.ruleq); })* CLOSE_CLOSURE { $list = listRes; }
    ;

ruleQ returns [Rule ruleq]
    : w1=WORD {$ruleq = new Rule($w1);} OPEN_BRACKET par=parameters CLOSE_BRACKET RETURNS ret=returnValue { $ruleq.parameters.add($par.list); $ruleq.returnType = $ret.returnType; } COLON (c1=condition { $ruleq.conditions.add($c1.cond); } (OR c2=condition { $ruleq.conditions.add($c2.cond); })* )? SEMICOLON
    ;

parameters returns [ArrayList<Parameter> list]
    : { $list = new ArrayList<Parameter>(); }
    | var1=WORD { ArrayList<Parameter> listRes = new ArrayList<>(); } COLON type1=WORD { listRes.add(new Parameter($var1, $type1)); } (COMMA var2=WORD COLON type2=WORD { listRes.add(new Parameter($var2, $type2)); })* { $list = listRes; }
    ;

returnValue returns [ReturnField returnType]
    : var1=WORD COLON type1=WORD { $returnType = new ReturnField($var1, $type1); }
    ;


condition returns [Condition cond]
    : { ArrayList<Step> listRes = new ArrayList<>(); } (s=step { listRest.add($s.stepq) })+ { $cond = new Condition().add(listRes); }
    ;

step returns [Step stepq]
    : c=CODE { $stepq = new CodeStep($c); }
    | w1=WORD { $stepq = new RunTermStep("", $w1); }
    | w1=WORD EQLUALLY w2=WORD { $stepq = new RunTermStep($w1, $w2); }
    | w1=WORD EQLUALLY w2=WORD { String tmp_str = $w2 + "("; } OPEN_BRACKET (w3=WORD { tmp_str = tmp_str + $w3; } (COMMA w4=WORD { tmp_str = tmp_str + ", " + $w4; })*)? CLOSE_BRACKET { tmp_str = tmp_str + ")"; $stepq = new RunTermStep($w1, tmp_str); }
    | w2=WORD { String tmp_str = $w2 + "("; } OPEN_BRACKET (w3=WORD { tmp_str = tmp_str + $w3; } (COMMA w4=WORD { tmp_str = tmp_str + ", " + $w4; })*)? CLOSE_BRACKET { tmp_str = tmp_str + ")"; $stepq = new RunTermStep("", tmp_str); }
    ;

tokensss returns [ArrayList<Token> list]
    : { $list = new ArrayList<Token>(); }
    | TOKENS { ArrayList<Token> listRes = new ArrayList<>(); } OPEN_CLOSURE (tokenName=WORD EQLUALLY regexp=REGEXP { listRes.add(new Token($tokenName, $regexp)); } SEMICOLON)* CLOSE_CLOSURE { $list = listRes; }
    ;

ignoreTokens returns [ArrayList<Ignore> list]
    : { $list = new ArrayList<Ignore>(); }
    | IGNORE { ArrayList<Ignore> listRes = new ArrayList<>(); } OPEN_CLOSURE (w1=WORD (COMMA w2=WORD { listRes.add(new Ignore($w2)); })* SEMICOLON { listRes.add(new Ignore($w1)); } )? CLOSE_CLOSURE { $list = listRes; }
    ;

GRAMMAR: 'grammar';
HEADERS: 'headers';
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
