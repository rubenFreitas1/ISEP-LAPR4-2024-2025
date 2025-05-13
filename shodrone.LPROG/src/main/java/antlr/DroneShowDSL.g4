grammar DroneShowDSL;

// Parser Rules
program
    : VERSION_DECL version_id SEMICOLON
      statement+
      EOF
    ;

version_id
    : VERSION_ID
    ;

statement
    : declaration
    | objectCreation
    | methodCall
    | groupBlock
    | pauseStatement
    ;

declaration
    : typeDeclaration
    | variableAssignment
    ;

typeDeclaration
    : DRONE_TYPE identifier SEMICOLON
    ;

variableAssignment
    : variableType identifier EQUALS value SEMICOLON
    ;

variableType
    : POSITION
    | VELOCITY
    | DISTANCE
    ;

value
    : coordinate
    | expression
    ;

coordinate
    : LPAREN expression COMMA expression COMMA expression RPAREN
    ;

objectCreation
    : shapeType identifier LPAREN argumentList RPAREN SEMICOLON
    ;

shapeType
    : LINE
    | RECTANGLE
    | CIRCLE
    | TRIANGLE
    | CUBE
    ;

argumentList
    : argument (COMMA argument)*
    ;

argument
    : identifier
    | expression
    | coordinate
    ;

methodCall
    : identifier DOT method SEMICOLON
    ;

method
    : LIGHTS_ON LPAREN color RPAREN
    | LIGHTS_OFF
    | MOVE LPAREN coordinate COMMA expression COMMA expression RPAREN
    | ROTATE LPAREN argumentList RPAREN
    ;

groupBlock
    : GROUP
      statement+
      ENDGROUP
    ;

pauseStatement
    : PAUSE LPAREN expression RPAREN SEMICOLON
    ;

expression
    : number
    | identifier
    | expression operator expression
    | LPAREN expression RPAREN
    ;

operator
    : PLUS
    | MINUS
    | MULTIPLY
    | DIVIDE
    ;

identifier
    : IDENTIFIER
    ;

number
    : NUMBER
    ;

color
    : COLOR
    ;

// Lexer Rules
VERSION_DECL : 'DSL' WS 'version' ;
DRONE_TYPE   : 'DroneType' ;
POSITION     : 'Position' ;
VELOCITY     : 'Velocity' ;
DISTANCE     : 'Distance' ;
LINE         : 'Line' ;
RECTANGLE    : 'Rectangle' ;
CIRCLE       : 'Circle' ;
TRIANGLE     : 'Triangle' ;
CUBE         : 'Cube' ;
LIGHTS_ON    : 'lightsOn' ;
LIGHTS_OFF   : 'lightsOff' ;
MOVE         : 'move' ;
ROTATE       : 'rotate' ;
GROUP        : 'group' ;
ENDGROUP     : 'endgroup' ;
PAUSE        : 'pause' ;

LPAREN       : '(' ;
RPAREN       : ')' ;
SEMICOLON    : ';' ;
COMMA        : ',' ;
DOT          : '.' ;
EQUALS       : '=' ;
PLUS         : '+' ;
MINUS        : '-' ;
MULTIPLY     : '*' ;
DIVIDE       : '/' ;

PI           : 'PI' ;
COLOR        : 'RED' | 'GREEN' | 'BLUE' | 'YELLOW' | 'WHITE' | 'BLACK' | 'PURPLE' | 'ORANGE' ;
VERSION_ID   : [0-9]+ ('.' [0-9]+)* ;
IDENTIFIER   : [a-zA-Z][a-zA-Z0-9_]* ;
NUMBER       : '-'? [0-9]+ ('.' [0-9]+)? ;

COMMENT      : '//' ~[\r\n]* -> skip ;
BLOCK_COMMENT: '/*' .*? '*/' -> skip ;
WS           : [ \t\r\n]+ -> skip ;

