grammar ShowProposal;

//Regra principal do programa
proposal
    : header
      NEWLINE
      reference
      NEWLINE NEWLINE
      body
      NEWLINE NEWLINE
      closing
      NEWLINE NEWLINE
      signature
      NEWLINE NEWLINE
      PAGE_BREAK
      NEWLINE NEWLINE
      showDetails
      EOF
    ;

//Regra para o header (cabeçalho da proposta)
header
    : greeting NEWLINE companyInfo
    ;

// Diferentes opções de greeting usados nas templates do show proposal
greeting
    : 'Dear,'
    | 'Dear Sirs,'
    | 'Exmos. Senhores'
    ;

//Informações da empresa
companyInfo
    : (personName NEWLINE)?
      company NEWLINE
      address NEWLINE
      vatNumber NEWLINE
    ;


//Informações do representante da empresa (aceita o nome do representante ou o placeholder)
personName
    : PERSON_NAME
    | '[Customer Representative Name]'
    | '[CRM Manager Name]'
    ;

//Informações da empresa (aceita o nome da empresa ou o placeholder)
company
    : WORD
    | '[Company name]'
    | '[' 'Company' ' ' 'Name' ']'
    ;

//Informações do endereço da empresa (aceita o endereço ou o placeholder)
address
    : ADDRESS_LINE
    | '[Address with postal code and country]'
    ;

//Informações do número de contribuinte da empresa (aceita o número de contribuinte ou o placeholder)
vatNumber
    : VAT_NUMBER
    | '[VAT Number]'
    ;

//Informações da referência da proposta (aceita a referência ou o placeholder)
reference
    : REFERENCE NEWLINE titleProposal
    ;

//Titulos das propostas presentes nos templates do show proposal
titleProposal
    : 'Show Proposal'
    | 'Proposta de Show'
    ;

//Regras para as linhas do corpo da proposta
body
    : line_1 NEWLINE line_2 NEWLINE line_3
    ;

//Primeira linha do corpo da proposta
line_1
    : LINE_1_FORMAT
    ;

//Segunda linha do corpo da proposta
line_2
    : LINE_2_FORMAT
    ;

//Terceira linha do corpo da proposta
line_3
    : LINE_3_FORMAT
    ;

//Linha que fecha o corpo da proposta
closing
    : CLOSING_FORMAT
    ;

//Regra para aceitar as frases de signature da proposta, e tambem o final da pagina da proposta
signature
    : signature_option NEWLINE
      regards NEWLINE
      NEWLINE personName
      NEWLINE 'CRM Manager'
    ;

//Regra para aceitar as diferentes opções de signature da proposta
signature_option
    : (preferencePhrase NEWLINE NEWLINE subscribePhrase NEWLINE)
    | lastPhrase NEWLINE
    ;

//Frases que podem aparecer na primeira linha da signature da proposta
preferencePhrase
    : 'Being certain that we will be the target of your preference.'
    | 'Estando certos que seremos alvo da V/ preferência.'
    ;

//Frases que podem aparecer na segunda linha da signature da proposta
subscribePhrase
    : 'We subscribe at your disposal.'
    | 'Subscrevemo-nos ao dispor.'
    | 'Looking forward to hearing from you soon.'
    ;

//Frase que aparece na ultima linha da signature da proposta
lastPhrase
    : 'Looking forward to hearing from you soon.'
    ;

//Frases que podem aparecer no final da proposta
regards
    : 'Best regards,'
    | 'Melhores cumprimentos,'
    ;

//Regras para aceitar as diferentes opções de detalhes do show proposal
showDetails
    : ATTACHMENT
     NEWLINE NEWLINE
     location NEWLINE
     date NEWLINE
     time NEWLINE
     duration NEWLINE NEWLINE
     droneList NEWLINE NEWLINE
     figureList
    ;

//Regra para aceitar as diferentes opções de localização do show (dados como também placeholder)
location
    : GPS_VALUE
    ;

//Regra para aceitar as diferentes opções de data do show (dados como também placeholder)
date
    :
      SHOW_DATE_FORMAT
    ;

//Regra para aceitar as diferentes opções de hora do show (dados como também placeholder)
time
    :
      TIME
    ;

//Regra para aceitar as diferentes opções de duração do show (dados como também placeholder)
duration
    :
      DURATION
    ;

//Regra para aceitar a lista de drones (dados como também placeholder)
droneList
    : ('#List of used drones' | '#Lista de drones utilizados') NEWLINE
      DRONE_ITEM (NEWLINE DRONE_ITEM)*
    ;

//Regra para aceitar a lista de figuras (dados como também placeholder)
figureList
    : ('#Lista de figuras' | '#List of figures') NEWLINE FIGURE_ITEM (NEWLINE FIGURE_ITEM)*
    ;

//Token da primeira linha do corpo da proposta
LINE_1_FORMAT: 'A Shodrone tem o prazer de submeter à V/ apreciação uma proposta para execução de um show aéreo com drones, conforme descrição abaixo.'
               | 'Shodrone is pleased to submit for your consideration a proposal for the execution of an aerial show with drones, as described below.'
               | (WORD | '[Company Name]') ' is a VIP client and Shodrone is pleased to submit for your consideration a proposal for the execution of an aerial show with drones, as described below.';

//Token da segunda linha do corpo da proposta
LINE_2_FORMAT: 'Shodrone is a company that prioritizes safety, which is why it uses the most advanced AI technology to support the development of its shows, with all shows being previously and carefully tested/simulated with AI-Test technology before being presented to the client.'
               | 'A Shodrone é uma empresa que dá prioridade à segurança, pelo que usa a mais avançada tecnologia de IA para apoiar o desenvolvimento dos seus shows, sendo que todos os shows são prévia e cuidadosamente testados/simulados com a tecnologia AI-Test antes de serem apresentados ao cliente.'
               ;

//Token da terceira linha do corpo da proposta
LINE_3_FORMAT: 'In the link ' (LINK | '[link to show video]') ' there is a video with a simulation of the proposed show.'
               |'No link ' (LINK | '[link to show video]') ' encontra-se um vídeo com a simulação do show proposto.'
               ;

//Token da linha que fecha o corpo da proposta
CLOSING_FORMAT: 'Com a aplicação do AI-Test, um exclusivo da Shodrone, temos a confiança de oferecer um seguro de responsabilidade civil no valor de ' ([0-9]+ | '[valor do seguro]') ' para o show. Os dados detalhados do show são apresentados em anexo.'
                 | 'With the application of AI-Test, a Shodrone exclusive, we are confident in offering liability insurance in the amount of ' ([0-9]+ | '[insurance amount]') ' for the show. Detailed show data is presented in the attachment.';

//Token do formato da data do show (aceita placeholder como também dados)
SHOW_DATE_FORMAT: ('Date - ' | 'Data - ') (DATE | '[date of the event]');

//Token do formato de cada linha na lista de figuras (aceita placeholders como também dados)
FIGURE_ITEM: ([1-9][0-9]?' - 'WORD) | ('[position in show] - [figure name]');

//Token do formato do link
LINK: ('http' 's'? '://' | 'www.') (WORD_PART | '/' | '.' | '-' | '_' | '?' | '=' | '&' | '%' | '#' | ':' | '~')+;

//Token do formato de cada linha na lista de drones (aceita placeholders como também dados)
DRONE_ITEM: ( (WORD ' - ' [0-9]+) | '[model] - [quantity]') (' units.' | ' unidades.');

//Token do formato da linha da location (aceita placeholders como também dados)
GPS_VALUE:('Location - ' | 'Local de realização - ') (('-'|'+')?[0-9]+('.'[0-9]+)?', '('-'|'+')?[0-9]+('.'[0-9]+)? | '[GPS coordinates of the location]');

//Token do formato do anexo (aceita placeholders como também dados)
ATTACHMENT: ('Attachment - Show Details ' | 'Anexo - Detalhes do Show ') ([0-9]+ | '[show proposal number]');

//Token do formato da referência (aceita placeholders como também dados)
REFERENCE: ('Reference '|'Referência ') [0-9]+ ' / ' DATE
           | ('Reference ' | 'Referência ') '[proposal number] / [date]';

//Token do formato de uma data
DATE: ('0'[1-9]|[12][0-9]|'3'[01])'-'('0'[1-9]|'1'[0-2])'-20'[2-9][0-9];

//Token do formato da hora (aceita placeholders como também dados)
TIME: ('Time - ' | 'Hora - ')(([0-9][0-9]':'[0-9][0-9]) | '[time of the event]');

//Token do formato da duração (aceita placeholders como também dados)
DURATION: ('Duration - ' | 'Duração - ')(([0-5][0-9]|'60') | '[duration]') (' minutes' | ' minutos');

//Token de um nome de uma pessoa
PERSON_NAME: NAME_PART (' ' NAME_PART)+;

//Token de um número de contribuinte português
VAT_NUMBER: 'PT' [0-9] [0-9] [0-9] [0-9] [0-9] [0-9] [0-9] [0-9] [0-9];

//Token de uma palavra
WORD: WORD_PART (' ' WORD_PART)*;

//Token de uma quebra de página
PAGE_BREAK: '\f' | '[page break]';

//Token de uma nova linha
NEWLINE: '\r'? '\n';

//Token para carateres maisculos e especiais
fragment UPPER: [A-Z\u00C0-\u00D6\u00D8-\u00DE];

//Token para carateres minusculos e especiais
fragment LOWER: [a-z\u00E0-\u00F6\u00F8-\u00FF];

//Token para uma letra
fragment LETTER: UPPER | LOWER;

//Token para um nome de uma pessoa (começa sempre com um UPPER)
fragment NAME_PART: UPPER LOWER+ ('-' UPPER LOWER+)*;

//Token para uma palavra que pode conter numeros (utilizado para nome de empresas, drones, figuras, etc)
fragment WORD_PART: (LETTER | [0-9])+ ([-&',.] (LETTER | [0-9])+)*;

//Token para espaços em branco
WS: [ \t]+ -> skip;

//Token para a linha de endereço da empresa
ADDRESS_LINE: (~[\r\n])+;
