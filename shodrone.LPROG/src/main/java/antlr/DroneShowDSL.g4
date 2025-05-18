grammar DroneShowDSL;

// Regra principal do programa
start
    : 'DSL' 'version' version ';' statement* EOF
    ;

// Versão do DSL no formato x.y.z
version
    : VERSION_ID
    ;

// Conjunto de declarações válidas no programa
statement
    : declaration
    | objectCreation
    | methodCall
    | groupBlock
    | pauseStatement
    | beforeBlock
    | afterBlock
    ;

// Bloco de comandos que ocorrem antes da execução principal
beforeBlock
    : 'before' statement* 'endbefore'
    ;

// Bloco de comandos que ocorrem após a execução principal
afterBlock
    : 'after' statement* 'endafter'
    ;

// Declaração de variáveis ou tipos
declaration
    : typeDeclaration
    | variableAssignment
    ;

// Declaração de tipo de drone
typeDeclaration
    : 'DroneType' IDENTIFIER ';'
    ;

// Atribuição de valor a variáveis de posição, velocidade ou distância
variableAssignment
    : variableType IDENTIFIER '=' expressionOrCoordinate ';'
    ;

// Tipos permitidos para variáveis
variableType
    : 'Position'
    | 'Velocity'
    | 'Distance'
    ;

// Valor pode ser uma expressão matemática ou uma coordenada 3D
expressionOrCoordinate
    : expression
    | coordinate
    ;

// Definição de uma coordenada 3D
coordinate
    : '(' expression ',' expression ',' expression ')'
    ;

// Criação de objetos do tipo Line, Rectangle, Circle ou Circumference
objectCreation
    : shapeType IDENTIFIER '(' params ')' ';'
    ;

// Tipos de formas suportadas
shapeType
    : 'Line'
    | 'Rectangle'
    | 'Circle'
    | 'Circumference'
    ;

// Parâmetros usados na criação dos objetos
params
    : expression (',' expression)*
    ;

// Chamada de métodos para objetos
methodCall
    : IDENTIFIER '.' methodName (methodCallTail)? ';'
    ;

// Parâmetros da chamada de método (se houver)
methodCallTail
    : '(' methodParams? ')'
    ;

// Métodos disponíveis para objetos
methodName
    : 'lightsOn'
    | 'lightsOff'
    | 'move'
    | 'movePos'
    | 'rotate'
    ;

// Parâmetros dos métodos, que podem ser cores, coordenadas ou expressões
methodParams
    : colorParam
    | coordinateParam
    | expressionParams
    ;

// Coordenada seguida de expressões (ex: move((0,0,1), 50, 3.0))
coordinateParam
    : coordinate (',' expression)*
    ;

// Um ou mais valores de expressão numérica
expressionParams
    : expression (',' expression)*
    ;

// Parâmetro de cor
colorParam
    : COLOR
    ;

// Bloco de instruções agrupadas
groupBlock
    : 'group' statement* 'endgroup'
    ;

// Pausa no programa
pauseStatement
    : 'pause' '(' expression ')' ';'
    ;

// Regras de expressão matemática
expression
    : primary                                      #PrimaryExpr
    | '-' expression                               #NegExpr
    | expression ('*' | '/') expression            #MultExpr
    | expression ('+' | '-') expression            #AddExpr
    ;

// Elementos básicos de uma expressão
primary
    : NUMBER
    | FLOAT
    | PI
    | IDENTIFIER
    | '(' expression ')'
    ;

// Cores disponíveis
COLOR
    : 'RED'
    | 'GREEN'
    | 'BLUE'
    | 'YELLOW'
    ;

// Constante PI
PI  : 'PI' ;

// Números com ponto decimal
FLOAT
    : [0-9]+ '.' [0-9]+
    ;

// Identificador da versão (ex: 1.0.0)
VERSION_ID
    : [0-9]+ '.' [0-9]+ '.' [0-9]+
    ;

// Número inteiro
NUMBER
    : [0-9]+
    ;

// Identificadores de variáveis, funções etc.
IDENTIFIER
    : [a-zA-Z][a-zA-Z0-9_]*
    ;

// Espaços em branco ignorados
WS
    : [ \t\r\n]+ -> skip
    ;

// Comentários de linha
COMMENT
    : '//' ~[\r\n]* -> skip
    ;

// Comentários de bloco
MULTILINE_COMMENT
    : '/*' .*? '*/' -> skip
    ;

// Cadeias de texto (ainda não usadas no DSL atual)
STRING
    : '"' (~["\\] | '\\' .)* '"'
    ;
