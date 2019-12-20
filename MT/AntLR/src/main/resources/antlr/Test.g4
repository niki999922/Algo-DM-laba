grammar Test;


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


words returns [StringBuilder val]
    : {$val = new StringBuilder();} (w=word {$val.append($w.str); System.out.println($w.str);})+
    ;

word returns [String str]
    : LB WORD* word WORD* RB word?
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

WS
   : [ \t\r\n]+ -> skip
   ;

NUMBER : [0-9]+;