grammar PascalGrammar;

//all program
program: programName programContext DOT EOF;

// program name
programName: PROGRAM NAME_STRING SEMICOLON;

programContext: (constContext | varContext | functionProcedureContext)* main;

//const
constContext: CONST constant+;
constant: NAME_STRING COLON type EQUALS constantValue SEMICOLON;
constantValue:  (NUMBER | STRING_N);

//var
varContext: VAR variable;
variable: variableRow+;
variableRow:  namesList COLON type SEMICOLON;

//function
functionProcedureContext : (procedureHeader | functionHeader) varContext? main SEMICOLON;
functionHeader : FUNCTION NAME_STRING OPEN_BRACKET arguments CLOSE_BRACKET COLON type SEMICOLON;

//procedure
procedureHeader : PROCEDURE NAME_STRING OPEN_BRACKET arguments CLOSE_BRACKET SEMICOLON;

//arguments function or procedure
arguments : (namesList COLON type (COMMA namesList COLON type)*)?;

//begin end part
main: BEGIN contextMain END;

contextMain : (statement SEMICOLON?)*;

statement : assignmentStatement | functionCall | logicCicleStatments;

assignmentStatement : varWrapper ASSIGN expression;

//expression
expression: simpleExpression (operationPr3 expression)?;
simpleExpression : term (operationPr2 simpleExpression)? ;
term : signedFactor (operationPr1 term)* ;
signedFactor : (ADD | SUB)? factor ;
factor : varWrapper | OPEN_BRACKET expression CLOSE_BRACKET | functionCall | unsignedConstant | NOT factor | bool;
bool : (TRUE | FALSE);
unsignedConstant : NUMBER;
functionCall : NAME_STRING OPEN_BRACKET parameterList CLOSE_BRACKET;
parameterList : expression (COMMA expression)*;


// priority operations
operationPr1 : MUL | DIVS | MODS | AND;
operationPr2 : ADD | SUB | OR;
operationPr3 : EQUALS | N_EQUAL | LT | LE | GE | GT;

varWrapper : NAME_STRING | STRING_N;

logicCicleStatments: ifStatement | cycleStatement;

ifStatement : IF expression THEN (statement (ELSE contextMain)? | BEGIN contextMain END (ELSE statement)?);

cycleStatement : whileStatement | forStatement;

whileStatement: WHILE OPEN_BRACKET expression CLOSE_BRACKET DO (statement | BEGIN contextMain END SEMICOLON);
forStatement : FOR varWrapper ASSIGN expression (TO | DOWNTO) expression DO ( statement | BEGIN contextMain END SEMICOLON);


namesList : NAME_STRING (COMMA NAME_STRING)*;
type : (INTEGER | BOOLEAN | STRING | REAL | CHAR);


fragment A : ('a' | 'A');
fragment B : ('b' | 'B');
fragment C : ('c' | 'C');
fragment D : ('d' | 'D');
fragment E : ('e' | 'E');
fragment F : ('f' | 'F');
fragment G : ('g' | 'G');
fragment H : ('h' | 'H');
fragment I : ('i' | 'I');
fragment J : ('j' | 'J');
fragment K : ('k' | 'K');
fragment L : ('l' | 'L');
fragment M : ('m' | 'M');
fragment N : ('n' | 'N');
fragment O : ('o' | 'O');
fragment P : ('p' | 'P');
fragment Q : ('q' | 'Q');
fragment R : ('r' | 'R');
fragment S : ('s' | 'S');
fragment T : ('t' | 'T');
fragment U : ('u' | 'U');
fragment V : ('v' | 'V');
fragment W : ('w' | 'W');
fragment X : ('x' | 'X');
fragment Y : ('y' | 'Y');
fragment Z : ('z' | 'Z');

fragment DIGITS : ('0' .. '9')+;
fragment SIGN : ('+' | '-');


PROGRAM : P R O G R A M;
FUNCTION  : F U N C T I O N;
PROCEDURE  : P R O C E D U R E;
CONST: C O N S T;
INTEGER : I N T E G E R;
BOOLEAN : B O O L E A N;
STRING : S T R I N G;
REAL : R E A L;
CHAR: C H A R;
VAR : V A R;
BEGIN : B E G I N;
END: E N D;
TRUE: T R U E;
FALSE: F A L S E;
OR : O R;
AND : A N D;
NOT : N O T;
IF : I F;
THEN : T H E N;
ELSE : E L S E;
FOR : F O R;
TO : T O;
DOWNTO : D O W N T O;
WHILE : W H I L E;
DO : D O;


ADD : '+';
SUB : '-';
MUL : '*';
DIVS : D I V;
MODS : M O D;


EQUALS : '=';
N_EQUAL : '<>';
GT : '>';
GE : '>=';
LT : '<';
LE : '<=';


OPEN_BRACKET : '(';
CLOSE_BRACKET : ')';
DOT : '.';
COLON: ':';
SEMICOLON : ';';
COMMA : ',';
ASSIGN : ':=';
NUMBER : (SIGN)? DIGITS (DOT DIGITS)?;
STRING_N : '\'' ('\'\'' | ~ ('\''))* '\'';
NAME_STRING : ('a' .. 'z' | 'A' .. 'Z' | '_') ('a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_')*;


COMMENT_1: '(*' .*? '*)' -> skip;
COMMENT_2: '{' .*? '}' -> skip;
WS : [ \t\r\n] -> skip;