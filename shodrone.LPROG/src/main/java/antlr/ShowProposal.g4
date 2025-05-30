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
    : GREETINGS
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
    : realPersonName
    | personNamePlaceholder
    ;

realPersonName: PERSON_NAME;

personNamePlaceholder
    : PERSON_NAME_PLACEHOLDER
    ;

//Informações da empresa (aceita o nome da empresa ou o placeholder)
company
    : realCompanyName
    | companyPlaceHolder
    ;

realCompanyName : WORD ;

companyPlaceHolder: COMPANY_PLACEHOLDER;



//Informações do endereço da empresa (aceita o endereço ou o placeholder)
address
    : realAddress
    | addressPlaceHolder
    ;

realAddress: ADDRESS_LINE;

addressPlaceHolder: ADDRESS_PLACEHOLDER;

//Informações do número de contribuinte da empresa (aceita o número de contribuinte ou o placeholder)
vatNumber
    : realVatNumber
    | vatNumberPlaceHolder
    ;

realVatNumber: VAT_NUMBER;

vatNumberPlaceHolder: VAT_NUMBER_PLACEHOLDER;

//Informações da referência da proposta (aceita a referência ou o placeholder)
reference
    : (realReference | referencePlaceHolder) NEWLINE titleProposal
    ;


realReference: REAL_REFERENCE;

referencePlaceHolder: REFERENCE_PLACEHOLDER;

//Titulos das propostas presentes nos templates do show proposal
titleProposal
    : TITLE_PHRASE
    ;

//Regras para as linhas do corpo da proposta
body
    : line_1 NEWLINE line_2 NEWLINE line_3
    ;

//Primeira linha do corpo da proposta
line_1
    : normal_line1
    | vip_line1
    ;

normal_line1:LINE_1_FORMAT;

vip_line1: real_vip_line1 | vip_line1_Placeholder;

real_vip_line1: REAL_VIP_LINE1;

vip_line1_Placeholder: VIP_LINE1_PLACEHOLDER;

//Segunda linha do corpo da proposta
line_2
    : LINE_2_FORMAT
    ;

//Terceira linha do corpo da proposta
line_3
    : real_line3
    | line3_placeholder
    ;

//Terceira linha do corpo da proposta com dados reais
real_line3:REAL_LINE3;

//Terceira linha do corpo da proposta com placeholder
line3_placeholder:LINE3_PLACEHOLDER;

//Linha que fecha o corpo da proposta
closing
    : real_closing
    | closing_placeholder
    ;

real_closing: REAL_CLOSING_FORMAT;

closing_placeholder: CLOSING_FORMAT_PLACEHOLDER;

//Regra para aceitar as frases de signature da proposta, e tambem o final da pagina da proposta
signature
    : signature_option NEWLINE
      regards NEWLINE
      NEWLINE crmManagerName
      NEWLINE 'CRM Manager'
    ;

crmManagerName: realManagerName | managerName_Placeholder;

realManagerName:PERSON_NAME;

managerName_Placeholder: CRM_MANAGER_PLACEHOLDER;


//Regra para aceitar as diferentes opções de signature da proposta
signature_option
    : (preferencePhrase NEWLINE NEWLINE subscribePhrase NEWLINE)
    | lastPhrase NEWLINE
    ;

//Frases que podem aparecer na primeira linha da signature da proposta
preferencePhrase
    : PREFEREMCE_PHRASE
    ;

//Frases que podem aparecer na segunda linha da signature da proposta
subscribePhrase
    : SUBSCRIBE_PHRASE
    ;

//Frase que aparece na ultima linha da signature da proposta
lastPhrase
    : LAST_PHRASE
    ;

//Frases que podem aparecer no final da proposta
regards
    : REGARDS
    ;

//Regras para aceitar as diferentes opções de detalhes do show proposal
showDetails
    : attachment
     NEWLINE NEWLINE
     location NEWLINE
     date NEWLINE
     time NEWLINE
     duration NEWLINE NEWLINE
     droneList NEWLINE NEWLINE
     figureList
    ;

attachment: real_attachment | attachment_placeholder;

real_attachment: ATTACHMENT_REAL;

attachment_placeholder: ATTACHMENT_PLACEHOLDER;

//Regra para aceitar as diferentes opções de localização do show (dados como também placeholder)
location
    : location_real | location_placeholder
    ;

location_real: GPS_LINE_REAL;

location_placeholder: GPS_LINE_PLACEHOLDER;

//Regra para aceitar as diferentes opções de data do show (dados como também placeholder)
date
    :date_real | date_placeholder
    ;

date_real:SHOW_DATE_REAL_LINE;

date_placeholder:SHOW_DATE_PLACEHOLDER_LINE;

//Regra para aceitar as diferentes opções de hora do show (dados como também placeholder)
time
    :time_real | time_placeholder
    ;
time_real:TIME_REAL_LINE;
time_placeholder:TIME_PLACEHOLDER_LINE;

//Regra para aceitar as diferentes opções de duração do show (dados como também placeholder)
duration
    :duration_real | duration_placeholder
    ;

duration_real:DURATION_REAL_LINE;

duration_placeholder:DURATION_PLACEHOLDER_LINE;

//Regra para aceitar a lista de drones (dados como também placeholder)
droneList
    : ('#List of used drones' | '#Lista de drones utilizados') NEWLINE
      (droneListReal | droneListPlaceholders)
    ;

droneListReal
    : DRONE_ITEM_REAL (NEWLINE DRONE_ITEM_REAL)*
    ;

droneListPlaceholders
    : DRONE_ITEM_PLACEHOLDER (NEWLINE DRONE_ITEM_PLACEHOLDER)*
    ;

//Regra para aceitar a lista de figuras (dados como também placeholder)
figureList
    : ('#Lista de figuras' | '#List of figures') NEWLINE
    (figureListReal | figureListPlaceholder)
    ;

figureListReal
    : FIGURE_ITEM_REAL (NEWLINE FIGURE_ITEM_REAL)*
    ;

figureListPlaceholder
    : FIGURE_ITEM_PLACEHOLDER (NEWLINE FIGURE_ITEM_PLACEHOLDER)*
    ;

GREETINGS:'Dear,'
         | 'Dear Sirs,'
         | 'Exmos. Senhores';

TITLE_PHRASE:'Show Proposal'
            | 'Proposta de Show';

PREFEREMCE_PHRASE:'Being certain that we will be the target of your preference.'
                  | 'Estando certos que seremos alvo da V/ preferência.'
                  ;

SUBSCRIBE_PHRASE:'We subscribe at your disposal.'
                  | 'Subscrevemo-nos ao dispor.'
                  ;
LAST_PHRASE:'Looking forward to hearing from you soon.';

REGARDS:'Best regards,'
       | 'Melhores cumprimentos,';

//Token da primeira linha do corpo da proposta
LINE_1_FORMAT: 'A Shodrone tem o prazer de submeter à V/ apreciação uma proposta para execução de um show aéreo com drones, conforme descrição abaixo.'
               | 'Shodrone is pleased to submit for your consideration a proposal for the execution of an aerial show with drones, as described below.';

REAL_VIP_LINE1: WORD ' is a VIP client and Shodrone is pleased to submit for your consideration a proposal for the execution of an aerial show with drones, as described below.';

VIP_LINE1_PLACEHOLDER: COMPANY_PLACEHOLDER ' is a VIP client and Shodrone is pleased to submit for your consideration a proposal for the execution of an aerial show with drones, as described below.';


//Token da segunda linha do corpo da proposta
LINE_2_FORMAT: 'Shodrone is a company that prioritizes safety, which is why it uses the most advanced AI technology to support the development of its shows, with all shows being previously and carefully tested/simulated with AI-Test technology before being presented to the client.'
               | 'A Shodrone é uma empresa que dá prioridade à segurança, pelo que usa a mais avançada tecnologia de IA para apoiar o desenvolvimento dos seus shows, sendo que todos os shows são prévia e cuidadosamente testados/simulados com a tecnologia AI-Test antes de serem apresentados ao cliente.'
               ;

//Token da terceira linha do corpo da proposta // com dados reais
REAL_LINE3:'In the link ' LINK ' there is a video with a simulation of the proposed show.'
          |'No link ' LINK ' encontra-se um vídeo com a simulação do show proposto.';

//Token da terceira linha do corpo da proposta // com placeholder
LINE3_PLACEHOLDER: 'In the link ' LINK_PLACEHOLDER ' there is a video with a simulation of the proposed show.'
                 |'No link ' LINK_PLACEHOLDER ' encontra-se um vídeo com a simulação do show proposto.';

//Placeholder do link
LINK_PLACEHOLDER: '[link to show video]';

//Token da linha que fecha o corpo da proposta
REAL_CLOSING_FORMAT: 'Com a aplicação do AI-Test, um exclusivo da Shodrone, temos a confiança de oferecer um seguro de responsabilidade civil no valor de ' [0-9]+ ' para o show. Os dados detalhados do show são apresentados em anexo.'
                 | 'With the application of AI-Test, a Shodrone exclusive, we are confident in offering liability insurance in the amount of ' [0-9]+ ' for the show. Detailed show data is presented in the attachment.';

CLOSING_FORMAT_PLACEHOLDER:'Com a aplicação do AI-Test, um exclusivo da Shodrone, temos a confiança de oferecer um seguro de responsabilidade civil no valor de ' INSURANCE_AMOUNT_PLACEHOLDER ' para o show. Os dados detalhados do show são apresentados em anexo.'
                 | 'With the application of AI-Test, a Shodrone exclusive, we are confident in offering liability insurance in the amount of ' INSURANCE_AMOUNT_PLACEHOLDER ' for the show. Detailed show data is presented in the attachment.';

INSURANCE_AMOUNT_PLACEHOLDER: '[valor do seguro]' | '[insurance amount]';

//Token do formato da data do show (aceita placeholder como também dados)
SHOW_DATE_FORMAT: ('Date - ' | 'Data - ');

SHOW_DATE_REAL_LINE: SHOW_DATE_FORMAT DATE;

SHOW_DATE_PLACEHOLDER_LINE: SHOW_DATE_FORMAT SHOW_DATE_PLACEHOLDER;

SHOW_DATE_PLACEHOLDER:'[date of the event]';



//Token do formato de cada linha na lista de figuras (aceita placeholders como também dados)

FIGURE_ITEM_REAL:([1-9][0-9]?' - 'WORD);

FIGURE_ITEM_PLACEHOLDER: FIGURE_POSITION_PLACEHOLDER ' - ' FIGURE_NAME_PLACEHOLDER;

FIGURE_POSITION_PLACEHOLDER:'[position in show]';
FIGURE_NAME_PLACEHOLDER:'[figure name]';


PERSON_NAME_PLACEHOLDER: '[Customer Representative Name]';

CRM_MANAGER_PLACEHOLDER: '[CRM Manager Name]';

COMPANY_PLACEHOLDER: '[Company name]' | '[' 'Company' ' ' 'Name' ']';

ADDRESS_PLACEHOLDER: '[Address with postal code and country]';

VAT_NUMBER_PLACEHOLDER: '[VAT Number]' ;

//Token do formato do link
LINK: ('http' 's'? '://' | 'www.') (WORD_PART | '/' | '.' | '-' | '_' | '?' | '=' | '&' | '%' | '#' | ':' | '~')+;

//Token do formato de cada linha na lista de drones (aceita placeholders como também dados)
DRONE_ITEM_FORMAT: (' units.' | ' unidades.');

DRONE_ITEM_REAL:(WORD ' - ' [0-9]+) DRONE_ITEM_FORMAT;

DRONE_ITEM_PLACEHOLDER: DRONE_MODEL_PLACEHOLDER ' - ' DRONE_MODEL_QUANTITY_PLACEHOLDER DRONE_ITEM_FORMAT;

DRONE_MODEL_PLACEHOLDER:'[model]';

DRONE_MODEL_QUANTITY_PLACEHOLDER:'[quantity]';

//Token do formato da linha da location (aceita placeholders como também dados)
GPS_LINE:('Location - ' | 'Local de realização - ');

GPS_LINE_REAL: GPS_LINE (('-'|'+')?[0-9]+('.'[0-9]+)?', '('-'|'+')?[0-9]+('.'[0-9]+)?) ;

GPS_LINE_PLACEHOLDER: GPS_LINE GPS_PLACEHOLDER;

GPS_PLACEHOLDER: '[GPS coordinates of the location]';


ATTACHMENT_LINE:('Attachment - Show Details ' | 'Anexo - Detalhes do Show ');

//Token do formato do anexo (aceita placeholders como também dados)
ATTACHMENT_REAL: ATTACHMENT_LINE [0-9]+ ;

ATTACHMENT_PLACEHOLDER: ATTACHMENT_LINE SHOW_PROPOSAL_PLACEHOLDER;

SHOW_PROPOSAL_PLACEHOLDER: '[show proposal number]';

REFERENCE_LINE:('Reference '|'Referência ') ;

REAL_REFERENCE: REFERENCE_LINE [0-9]+ ' / ' DATE;

REFERENCE_PLACEHOLDER: REFERENCE_LINE PROPOSAL_PLACEHOLDER ' / ' DATE_PLACEHOLDER;

PROPOSAL_PLACEHOLDER:'[proposal number]';

DATE_PLACEHOLDER: '[date]';

//Token do formato de uma data
DATE: ('0'[1-9]|[12][0-9]|'3'[01])'-'('0'[1-9]|'1'[0-2])'-20'[2-9][0-9];

//Token do formato da hora (aceita placeholders como também dados)
TIME_LINE: ('Time - ' | 'Hora - ');
TIME_REAL_LINE: TIME_LINE ([0-9][0-9]':'[0-9][0-9]);
TIME_PLACEHOLDER_LINE:TIME_LINE TIME_PLACEHOLDER;

TIME_PLACEHOLDER:'[time of the event]';

//Token do formato da duração (aceita placeholders como também dados)
DURATION_LINE: ('Duration - ' | 'Duração - ');
DURATION_MINUTES:(' minutes' | ' minutos');

DURATION_REAL_LINE: DURATION_LINE ([0-5][0-9]|'60') DURATION_MINUTES;
DURATION_PLACEHOLDER_LINE: DURATION_LINE DURATION_PLACEHOLDER DURATION_MINUTES;
DURATION_PLACEHOLDER: '[duration]';

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
