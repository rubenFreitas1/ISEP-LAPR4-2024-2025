grammar ShowProposal;

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

header
    : greeting NEWLINE companyInfo
    ;

greeting
    : 'Dear,'
    | 'Dear Sirs,'
    | 'Exmos. Senhores'
    ;

companyInfo
    : (personName NEWLINE)?
      company NEWLINE
      address NEWLINE
      vatNumber NEWLINE
    ;

personName
    : PERSON_NAME
    | '[Customer Representative Name]'
    | '[CRM Manager Name]'
    ;

company
    : WORD
    | '[Company name]'
    | '[' 'Company' ' ' 'Name' ']'
    ;

address
    : ADDRESS_LINE
    | '[Address with postal code and country]'
    ;

vatNumber
    : VAT_NUMBER
    | '[VAT Number]'
    ;

reference
    : REFERENCE NEWLINE titleProposal
    ;

titleProposal
    : 'Show Proposal'
    | 'Proposta de Show'
    ;

body
    : line_1 NEWLINE line_2 NEWLINE line_3
    ;

line_1
    : LINE_1_FORMAT
    ;

line_2
    : LINE_2_FORMAT
    ;

line_3
    : LINE_3_FORMAT
    ;

closing
    : CLOSING_FORMAT
    ;
signature
    : signature_option NEWLINE
      regards NEWLINE
      NEWLINE personName
      NEWLINE 'CRM Manager'
    ;

signature_option
    : (preferencePhrase NEWLINE NEWLINE subscribePhrase NEWLINE)
    | lastPhrase NEWLINE
    ;

preferencePhrase
    : 'Being certain that we will be the target of your preference.'
    | 'Estando certos que seremos alvo da V/ preferência.'
    ;

subscribePhrase
    : 'We subscribe at your disposal.'
    | 'Subscrevemo-nos ao dispor.'
    | 'Looking forward to hearing from you soon.'
    ;

lastPhrase
    : 'Looking forward to hearing from you soon.'
    ;

regards
    : 'Best regards,'
    | 'Melhores cumprimentos,'
    ;

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

location
    : GPS_VALUE
    ;

date
    :
      SHOW_DATE_FORMAT
    ;

time
    :
      TIME
    ;

duration
    :
      DURATION
    ;

droneList
    : ('#List of used drones' | '#Lista de drones utilizados') NEWLINE
      DRONE_ITEM (NEWLINE DRONE_ITEM)*
    ;

figureList
    : ('#Lista de figuras' | '#List of figures') NEWLINE FIGURE_ITEM (NEWLINE FIGURE_ITEM)*
    ;

LINE_1_FORMAT: 'A Shodrone tem o prazer de submeter à V/ apreciação uma proposta para execução de um show aéreo com drones, conforme descrição abaixo.'
               | 'Shodrone is pleased to submit for your consideration a proposal for the execution of an aerial show with drones, as described below.'
               | (WORD | '[Company Name]') ' is a VIP client and Shodrone is pleased to submit for your consideration a proposal for the execution of an aerial show with drones, as described below.';

LINE_2_FORMAT: 'Shodrone is a company that prioritizes safety, which is why it uses the most advanced AI technology to support the development of its shows, with all shows being previously and carefully tested/simulated with AI-Test technology before being presented to the client.'
               | 'A Shodrone é uma empresa que dá prioridade à segurança, pelo que usa a mais avançada tecnologia de IA para apoiar o desenvolvimento dos seus shows, sendo que todos os shows são prévia e cuidadosamente testados/simulados com a tecnologia AI-Test antes de serem apresentados ao cliente.'
               ;
LINE_3_FORMAT: 'In the link ' (LINK | '[link to show video]') ' there is a video with a simulation of the proposed show.'
               |'No link ' (LINK | '[link to show video]') ' encontra-se um vídeo com a simulação do show proposto.'
               ;
CLOSING_FORMAT: 'Com a aplicação do AI-Test, um exclusivo da Shodrone, temos a confiança de oferecer um seguro de responsabilidade civil no valor de ' ([0-9]+ | '[valor do seguro]') ' para o show. Os dados detalhados do show são apresentados em anexo.'
                 | 'With the application of AI-Test, a Shodrone exclusive, we are confident in offering liability insurance in the amount of ' ([0-9]+ | '[insurance amount]') ' for the show. Detailed show data is presented in the attachment.';
SHOW_DATE_FORMAT: ('Date - ' | 'Data - ') (DATE | '[date of the event]');
FIGURE_ITEM: ([1-9][0-9]?' - 'WORD) | ('[position in show] - [figure name]');
LINK
    : ('http' 's'? '://' | 'www.') (WORD_PART | '/' | '.' | '-' | '_' | '?' | '=' | '&' | '%' | '#' | ':' | '~')+
    ;
DRONE_ITEM: ( (WORD ' - ' [0-9]+) | '[model] - [quantity]') (' units.' | ' unidades.');
GPS_VALUE:('Location - ' | 'Local de realização - ') (('-'|'+')?[0-9]+('.'[0-9]+)?', '('-'|'+')?[0-9]+('.'[0-9]+)? | '[GPS coordinates of the location]');
ATTACHMENT: ('Attachment - Show Details ' | 'Anexo - Detalhes do Show ') ([0-9]+ | '[show proposal number]');
REFERENCE: ('Reference '|'Referência ') [0-9]+ ' / ' DATE
           | ('Reference ' | 'Referência ') '[proposal number] / [date]';
DATE: ('0'[1-9]|[12][0-9]|'3'[01])'-'('0'[1-9]|'1'[0-2])'-20'[2-9][0-9];
TIME: ('Time - ' | 'Hora - ')(([0-9][0-9]':'[0-9][0-9]) | '[time of the event]');
DURATION: ('Duration - ' | 'Duração - ')(([0-5][0-9]|'60') | '[duration]') (' minutes' | ' minutos');
PERSON_NAME: NAME_PART (' ' NAME_PART)+;
VAT_NUMBER: 'PT' [0-9] [0-9] [0-9] [0-9] [0-9] [0-9] [0-9] [0-9] [0-9];
WORD: WORD_PART (' ' WORD_PART)*;
PAGE_BREAK: '\f' | '[page break]';
NEWLINE: '\r'? '\n';

fragment UPPER: [A-Z\u00C0-\u00D6\u00D8-\u00DE];
fragment LOWER: [a-z\u00E0-\u00F6\u00F8-\u00FF];
fragment LETTER: UPPER | LOWER;
fragment NAME_PART: UPPER LOWER+ ('-' UPPER LOWER+)*;
fragment WORD_PART: (LETTER | [0-9])+ ([-&',.] (LETTER | [0-9])+)*;

WS: [ \t]+ -> skip;
ADDRESS_LINE: (~[\r\n])+;
