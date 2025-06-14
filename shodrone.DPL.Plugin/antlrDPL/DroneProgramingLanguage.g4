grammar DroneProgramingLanguage;

start: drone_version type_section variables_section instructions_section EOF;

drone_version: (WORDS | DECIMAL)+ 'programming language version' DECIMAL NEWLINE*;

type_section: 'Types' NEWLINE* type_declaration*;
type_declaration: WORDS+ '-' type_value NEWLINE*;
type_value: tuple | DECIMAL | WORDS;

variables_section: 'Variables' NEWLINE* variable_declaration*;
variable_declaration: WORDS+ (WORDS+)? '=' expression ';' NEWLINE*;

instructions_section: 'Instructions' NEWLINE* instruction*;
instruction: WORDS+ '(' argument_list? ')' ';' NEWLINE*;

argument_list: argument (', ' argument)*;
argument: expression | placeholder | tuple | array;

placeholder: '<' WORDS+ '>';

expression: term (op term)*;
term: DECIMAL | WORDS | 'PI' | tuple | array;

tuple: '(' DECIMAL (', ' DECIMAL)* ')';
array: '(' tuple (', ' tuple)* ')';

op: '+' | '-' | '*' | '/';

DECIMAL: [\-]?[0-9]+ ('.' [0-9]+)?;
WORDS: [a-zA-Z_][a-zA-Z_0-9]*;
NEWLINE: [\r\n]+;
WS: [ \t]+ -> skip;
COMMENT: '//' ~[\r\n]* -> skip;