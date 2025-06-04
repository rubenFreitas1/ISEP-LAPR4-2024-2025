grammar ShowProposalRealData;

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


//Informações do representante da empresa (aceita o nome do representante)
personName
    : realPersonName
    ;

//Regra para o nome real da pessoa
realPersonName: PERSON_NAME;


//Informações da empresa (aceita o nome da empresa)
company
    : realCompanyName
    ;

//Regra para o nome da empresa
realCompanyName : WORD ;

//Informações do endereço da empresa (aceita o endereço)
address
    : realAddress
    ;

//Regra para linha do endereço real da empresa
realAddress: ADDRESS_LINE;

//Informações do número de contribuinte da empresa (aceita o número de contribuinte)
vatNumber
    : realVatNumber
    ;

//Regra do número de contribuinte da empresa
realVatNumber: VAT_NUMBER;


//Informações da referência da proposta (aceita a referência)
reference
    : realReference NEWLINE titleProposal
    ;

//Regra da referencia com dados reais
realReference: REAL_REFERENCE;


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

//Regra da Primeira linha normal
normal_line1:LINE_1_FORMAT;

//Regra da Primeira linha em que o customer é vip
vip_line1: real_vip_line1;

//Linha em que o customer é vip (dados reais)
real_vip_line1: REAL_VIP_LINE1;

//Segunda linha do corpo da proposta
line_2
    : LINE_2_FORMAT
    ;

//Terceira linha do corpo da proposta
line_3
    : real_line3
    ;

//Terceira linha do corpo da proposta com dados reais
real_line3:REAL_LINE3;


//Linha que fecha o corpo da proposta
closing
    : real_closing
    ;

//Linha que fecha o corpo da proposta com dados reais
real_closing: REAL_CLOSING_FORMAT;


//Regra para aceitar as frases de signature da proposta, e tambem o final da pagina da proposta
signature
    : signature_option NEWLINE
      regards NEWLINE
      NEWLINE crmManagerName
      NEWLINE 'CRM Manager'
    ;

//Regra para o nome do crm Manager
crmManagerName: realManagerName;

//Regra para o crm Manager que será dados reais
realManagerName:PERSON_NAME;

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

//Linha do anexo do Proposal // Informação do Show
attachment: real_attachment;

//Linha do anexo com dados reais
real_attachment: ATTACHMENT_REAL;

//Regra para aceitar as diferentes opções de localização do show (dados reais)
location
    : location_real
    ;

//Regra para dados reais da localização
location_real: GPS_LINE_REAL;


//Regra para aceitar as diferentes opções de data do show (dados reais)
date
    :date_real
    ;

//Regra para dados reais da data
date_real:SHOW_DATE_REAL_LINE;


//Regra para aceitar as diferentes opções de hora do show (dados reais)
time
    :time_real
    ;

//Regra para dados reais da hora do show
time_real:TIME_REAL_LINE;


//Regra para aceitar as diferentes opções de duração do show (dados reais)
duration
    :duration_real
    ;

//Regra para dados reais da duração do show
duration_real:DURATION_REAL_LINE;


//Regra para aceitar a lista de drones (dados reais)
droneList
    : ('#List of used drones' | '#Lista de drones utilizados') NEWLINE
      droneListReal
    ;

//Regra para linha da lista de drones (dados reais)
droneListReal
    : DRONE_ITEM_REAL (NEWLINE DRONE_ITEM_REAL)*
    ;

//Regra para aceitar a lista de figuras (dados reais)
figureList
    : ('#Lista de figuras' | '#List of figures') NEWLINE
    figureListReal
    ;

//Regra para linha de lista de figuras (dados reais)
figureListReal
    : FIGURE_ITEM_REAL (NEWLINE FIGURE_ITEM_REAL)*
    ;

//Diferentes Greetings aceites
GREETINGS:'Dear,'
         | 'Dear Sirs,'
         | 'Exmos. Senhores';


//Título do Show Proposal
TITLE_PHRASE:'Show Proposal'
            | 'Proposta de Show';

//Frases possiveis da preferência
PREFEREMCE_PHRASE:'Being certain that we will be the target of your preference.'
                  | 'Estando certos que seremos alvo da V/ preferência.'
                  ;

//Frases possiveis de subscrição
SUBSCRIBE_PHRASE:'We subscribe at your disposal.'
                  | 'Subscrevemo-nos ao dispor.'
                  ;

//Ultima frase aceita da primeira pagina do proposal
LAST_PHRASE:'Looking forward to hearing from you soon.';


//Exemplos de Cumprimentos
REGARDS:'Best regards,'
       | 'Melhores cumprimentos,';

//Token da primeira linha do corpo da proposta
LINE_1_FORMAT: 'A Shodrone tem o prazer de submeter à V/ apreciação uma proposta para execução de um show aéreo com drones, conforme descrição abaixo.'
               | 'Shodrone is pleased to submit for your consideration a proposal for the execution of an aerial show with drones, as described below.';

//Token da primeira linha do corpo da proposta em que a empresa seja vip com dados reais
REAL_VIP_LINE1: WORD ' is a VIP client and Shodrone is pleased to submit for your consideration a proposal for the execution of an aerial show with drones, as described below.'
              | WORD ' é um cliente VIP e a Shodrone tem o prazer de submeter à vossa apreciação uma proposta para a execução de um espetáculo aéreo com drones, tal como descrito abaixo.';


//Token da segunda linha do corpo da proposta
LINE_2_FORMAT: 'Shodrone is a company that prioritizes safety, which is why it uses the most advanced AI technology to support the development of its shows, with all shows being previously and carefully tested/simulated with AI-Test technology before being presented to the client.'
               | 'A Shodrone é uma empresa que dá prioridade à segurança, pelo que usa a mais avançada tecnologia de IA para apoiar o desenvolvimento dos seus shows, sendo que todos os shows são prévia e cuidadosamente testados/simulados com a tecnologia AI-Test antes de serem apresentados ao cliente.'
               ;

//Token da terceira linha do corpo da proposta // com dados reais
REAL_LINE3:'In the link ' LINK ' there is a video with a simulation of the proposed show.'
          |'No link ' LINK ' encontra-se um vídeo com a simulação do show proposto.';


//Token da linha que fecha o corpo da proposta
REAL_CLOSING_FORMAT: 'Com a aplicação do AI-Test, um exclusivo da Shodrone, temos a confiança de oferecer um seguro de responsabilidade civil no valor de ' [0-9]+ ' para o show. Os dados detalhados do show são apresentados em anexo.'
                 | 'With the application of AI-Test, a Shodrone exclusive, we are confident in offering liability insurance in the amount of ' [0-9]+ ' for the show. Detailed show data is presented in the attachment.';


//Token do formato da data do show
SHOW_DATE_FORMAT: ('Date - ' | 'Data - ');

//Token do formato da linha da data com dados reais
SHOW_DATE_REAL_LINE: SHOW_DATE_FORMAT DATE;


//Token do formato de cada linha na lista de figuras com dados reais
FIGURE_ITEM_REAL:([1-9][0-9]?' - 'WORD);

//Token do formato do link
LINK: ('http' 's'? '://' | 'www.') (WORD_PART | '/' | '.' | '-' | '_' | '?' | '=' | '&' | '%' | '#' | ':' | '~')+;

//Token de unidades da linha drone item
DRONE_ITEM_FORMAT: (' units.' | ' unidades.');

//Linha da lista de drones com dados reais
DRONE_ITEM_REAL:(WORD ' - ' [0-9]+) DRONE_ITEM_FORMAT;

//Token da linha da localização
GPS_LINE:('Location - ' | 'Local de realização - ');

//Linha com dados reais da localização
GPS_LINE_REAL: GPS_LINE (('-'|'+')?[0-9]+('.'[0-9]+)?', '('-'|'+')?[0-9]+('.'[0-9]+)?) ;

//Linha do anexo
ATTACHMENT_LINE:('Attachment - Show Details ' | 'Anexo - Detalhes do Show ');

//Linha do anexo com os dados reais do show proposal number
ATTACHMENT_REAL: ATTACHMENT_LINE [0-9]+ ;

//Token da referência
REFERENCE_LINE:('Reference '|'Referência ') ;

//Token da linha completa da referência com dados reais
REAL_REFERENCE: REFERENCE_LINE [0-9]+ ' / ' DATE;

//Token do formato de uma data
DATE: ('0'[1-9]|[12][0-9]|'3'[01])'-'('0'[1-9]|'1'[0-2])'-20'[2-9][0-9];

//Token da hora do show
TIME_LINE: ('Time - ' | 'Hora - ');

//Linha completa da hora do show com dados reais
TIME_REAL_LINE: TIME_LINE ([0-9][0-9]':'[0-9][0-9]);

//Token da duração do show
DURATION_LINE: ('Duration - ' | 'Duração - ');

//Token de minutos
DURATION_MINUTES:(' minutes' | ' minutos');

//Linha completa da duração do show com dados reais
DURATION_REAL_LINE: DURATION_LINE ([0-5][0-9]|'60') DURATION_MINUTES;


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


//Token para a linha de endereço da empresa
ADDRESS_LINE: (~[\r\n])+;
