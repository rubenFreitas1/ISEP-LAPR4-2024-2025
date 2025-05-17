grammar DroneShowDSL;

program
    : 'DSL' 'version' version ';' statement* EOF
    ;

version
    : VERSION_ID
    ;

statement
    : declaration
    | objectCreation
    | methodCall
    | groupBlock
    | pauseStatement
    | beforeBlock
    | afterBlock
    ;

beforeBlock
    : 'before' statement* 'endbefore'
    ;

afterBlock
    : 'after' statement* 'endafter'
    ;


declaration
    : typeDeclaration
    | variableAssignment
    ;

typeDeclaration
    : 'DroneType' IDENTIFIER ';'
    ;

variableAssignment
    : variableType IDENTIFIER '=' expressionOrCoordinate ';'
    ;

variableType
    : 'Position'
    | 'Velocity'
    | 'Distance'
    ;

expressionOrCoordinate
    : expression
    | coordinate
    ;

coordinate
    : '(' expression ',' expression ',' expression ')'
    ;

objectCreation
    : shapeType IDENTIFIER '(' params ')' ';'
    ;

shapeType
    : 'Line'
    | 'Rectangle'
    | 'Circle'
    | 'Circumference'
    ;

params
    : expression (',' expression)*
    ;

methodCall
    : IDENTIFIER '.' methodName (methodCallTail)? ';'
    ;

methodCallTail
    : '(' methodParams? ')'
    ;


methodName
    : 'lightsOn'
    | 'lightsOff'
    | 'move'
    | 'movePos'
    | 'rotate'
    ;

methodParams
    : colorParam
    | coordinateParam
    | expressionParams
    ;

coordinateParam
    : coordinate (',' expression)*
    ;

expressionParams
    : expression (',' expression)*
    ;

colorParam
    : COLOR
    ;

groupBlock
    : 'group' statement* 'endgroup'
    ;

pauseStatement
    : 'pause' '(' expression ')' ';'
    ;

expression
    : primary                                      #PrimaryExpr
    | '-' expression                               #NegExpr
    | expression ('*' | '/') expression            #MultExpr
    | expression ('+' | '-') expression            #AddExpr
    ;

primary
    : NUMBER
    | FLOAT
    | PI
    | IDENTIFIER
    | '(' expression ')'
    ;

COLOR
    : 'RED'
    | 'GREEN'
    | 'BLUE'
    | 'YELLOW'
    ;

PI  : 'PI' ;

// Redefine the tokens to ensure FLOAT has priority over VERSION_ID
FLOAT
    : [0-9]+ '.' [0-9]+
    ;

VERSION_ID
    : [0-9]+ '.' [0-9]+ '.' [0-9]+
    ;

NUMBER
    : [0-9]+
    ;

IDENTIFIER
    : [a-zA-Z][a-zA-Z0-9_]*
    ;

WS
    : [ \t\r\n]+ -> skip
    ;

COMMENT
    : '//' ~[\r\n]* -> skip
    ;

MULTILINE_COMMENT
    : '/*' .*? '*/' -> skip
    ;

STRING
    : '"' (~["\\] | '\\' .)* '"'
    ;
