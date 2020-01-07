grammar Test;

expr returns [int val]
    : NUMBER (exss2=exprP[7] { Integer r = new Integer(2);   System.out.println("");
    $val = 3;})
    ;


exprP[int i] returns [int val]
    :                                              { val=i; }  // ε-правило
    | '+' { val=4; }
    ;

hm :;
//exprP[int i] returns [int val]
//    :                                              { val=i; }  // ε-правило
//    | '+' term exprq=exprP[i+term.val]        { val=exprq.val; }
//    ;
//term returns [int val]
//    : fact termP[fact.val]     {val = $termP.val; }
//    ;
//termP[int i] returns [int val]
//    :                                              { val=i; }
//    | '*' fact exprq=termP[i∗fact.val]        { val=exprq.val; }
//    ;
//fact returns [int val]
//    : '(' expr ')'                  { val=expr.val; }
//    | NUMBER                           { val=Integer.parseInt(NUM.text); }
//    ;
//
//fulex
//    : NUMBER
//    | LB expression RB
//    ;
//
//mulex
//    : fulex * mulex
//    | fulex
//    ;
//
//expression
//    : mulex PLUS expression
//    | mulex
//    ;


rule1 returns [StringBuilder val]
    : {$val = new StringBuilder();} (w=rule2 {$val.append($w.str); System.out.println($w.str);})+
    ;

rule2 returns [String str]
    : LB WORD* rule2 WORD* RB rule2?
    | WORD
    ;

WORD
    : [a-zA-Z]+
    ;

LB
    : '('
    ;

RB
    : ')'
    ;

PLUS
    : '+'
    ;

TERM
    : 'lalala'
    ;

WS
   : [ \t\r\n]+ -> skip
   ;

NUMBER : [0-9]+;