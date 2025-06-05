grammar DroneProgramingLanguage;

// Parser Rules
program: item* EOF;

item: variableDeclaration
    | instruction
    | textLine
    ;

textLine: token* NEWLINE;

token: IDENTIFIER
     | INTEGER
     | FLOAT
     | STRING
     | PI
     | PUNCT
     | SPECIAL
     ;

variableDeclaration: dataType IDENTIFIER '=' value ';';

instruction: IDENTIFIER '(' parameterList? ')' ';';

parameterList: parameter (',' parameter)*;

parameter: value;

value: coordinate
     | coordinateArray
     | vectorExpression
     | numericValue
     | stringValue
     | IDENTIFIER
     ;

coordinate: '(' numericValue ',' numericValue ',' numericValue ')';

coordinateArray: '(' '(' coordinateList ')' ')';

coordinateList: coordinate (',' coordinate)*;

vectorExpression: coordinate '-' coordinate;

numericValue: mathExpression;

mathExpression: mathTerm (('+'|'-') mathTerm)*;

mathTerm: mathFactor (('*'|'/') mathFactor)*;

mathFactor: FLOAT
          | INTEGER
          | PI
          | IDENTIFIER
          | '(' mathExpression ')'
          ;

stringValue: STRING;

dataType: 'Coord' | 'Point' | 'Position'
        | 'Vector' | 'Direction'
        | 'Speed' | 'LinearVelocity'
        | 'RotSpeed' | 'AngularVelocity'
        | 'Duration' | 'Time'
        | 'Length' | 'Distance'
        | 'Color'
        ;

// Lexer Rules
IDENTIFIER: [a-zA-Z_][a-zA-Z0-9_]*;
FLOAT: '-'? [0-9]+ '.' [0-9]+;
INTEGER: '-'? [0-9]+;
STRING: '"' (~["\r\n])* '"';
PI: 'PI';

// Special characters commonly found in documentation
SPECIAL: [<>];
PUNCT: [.,;:()\-/=];

NEWLINE: '\r'? '\n';

// Whitespace
WS: [ \t]+ -> skip;