grammar ShowProposalPlaceholder;

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


//Informações do representante da empresa
personName
    : personNamePlaceholder
    ;

//Placeholder do Customer
personNamePlaceholder
    : PERSON_NAME_PLACEHOLDER
    ;

//Informações da empresa
company
    : companyPlaceHolder
    ;

//Placeholder da Company
companyPlaceHolder: COMPANY_PLACEHOLDER;

//Informações do endereço da empresa
address
    : addressPlaceHolder
    ;

//Placeholder do address
addressPlaceHolder: ADDRESS_PLACEHOLDER;

//Informações do número de contribuinte da empresa
vatNumber
    : vatNumberPlaceHolder
    ;

//Placeholder do vat number
vatNumberPlaceHolder: VAT_NUMBER_PLACEHOLDER;

//Informação da referência
reference
    : referencePlaceHolder NEWLINE titleProposal
    ;

//Placeholder da referencia
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

//Regra da Primeira linha normal
normal_line1:LINE_1_FORMAT;

//Regra da Primeira linha em que o customer é vip
vip_line1: vip_line1_Placeholder;

//Linha em que o customer é vip em PLACEHOLDER
vip_line1_Placeholder: VIP_LINE1_PLACEHOLDER;

//Segunda linha do corpo da proposta
line_2
    : LINE_2_FORMAT
    ;

//Terceira linha do corpo da proposta
line_3
    : line3_placeholder
    ;

//Terceira linha do corpo da proposta com placeholder
line3_placeholder:LINE3_PLACEHOLDER;

//Regra para linha que fecha o corpo da proposta
closing
    : closing_placeholder
    ;

//Linha que fecha o corpo (Placeholder)
closing_placeholder: CLOSING_FORMAT_PLACEHOLDER;


//Regra para aceitar as frases de signature da proposta, e tambem o final da pagina da proposta
signature
    : signature_option NEWLINE
      regards NEWLINE
      NEWLINE crmManagerName
      NEWLINE 'CRM Manager'
    ;

//Regra para o nome do crm Manager
crmManagerName: managerName_Placeholder;

//Regra para o crm Manager que será Placeholder
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

//Primeira linha de segunda pagina do Proposal // Informação do Show
attachment: attachment_placeholder;

//Placeholder do Attachment
attachment_placeholder: ATTACHMENT_PLACEHOLDER;

//Regra para aceitar a location
location
    : location_placeholder
    ;

//Regra para o placeholder da Location
location_placeholder: GPS_LINE_PLACEHOLDER;

//Regra para aceitar a data
date
    :date_placeholder
    ;

//Regra para o placeholder da data
date_placeholder:SHOW_DATE_PLACEHOLDER_LINE;

//Regra para aceitar o tempo
time
    : time_placeholder
    ;

//Regra para o placeholder do tempo
time_placeholder:TIME_PLACEHOLDER_LINE;

//Regra para aceitar a duração
duration
    : duration_placeholder
    ;

//Regra para o placeholder da duração
duration_placeholder:DURATION_PLACEHOLDER_LINE;

//Regra para aceitar a lista de drones
droneList
    : ('#List of used drones' | '#Lista de drones utilizados') NEWLINE
      droneListPlaceholders
    ;

//Regra para a linha da lista de drones // formato Placeholders
droneListPlaceholders
    : DRONE_ITEM_PLACEHOLDER (NEWLINE DRONE_ITEM_PLACEHOLDER)*
    ;

//Regra para aceitar a lista de figuras
figureList
    : ('#Lista de figuras' | '#List of figures') NEWLINE
        figureListPlaceholder
    ;

//Regra para a linha da lista de figuras // formato Placeholders
figureListPlaceholder
    : FIGURE_ITEM_PLACEHOLDER (NEWLINE FIGURE_ITEM_PLACEHOLDER)*
    ;

//Diferentes Greetings aceites
GREETINGS:'Dear,'
         | 'Dear Sirs,'
         | 'Exmos. Senhores';

//Titulo do Show Proposal
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

//Token da primeira linha do corpo da proposta em que a company seja Vip (Placeholder)
VIP_LINE1_PLACEHOLDER: COMPANY_PLACEHOLDER ' is a VIP client and Shodrone is pleased to submit for your consideration a proposal for the execution of an aerial show with drones, as described below.'
                     | COMPANY_PLACEHOLDER ' é um cliente VIP e a Shodrone tem o prazer de submeter à vossa apreciação uma proposta para a execução de um espetáculo aéreo com drones, tal como descrito abaixo.';


//Token da segunda linha do corpo da proposta
LINE_2_FORMAT: 'Shodrone is a company that prioritizes safety, which is why it uses the most advanced AI technology to support the development of its shows, with all shows being previously and carefully tested/simulated with AI-Test technology before being presented to the client.'
               | 'A Shodrone é uma empresa que dá prioridade à segurança, pelo que usa a mais avançada tecnologia de IA para apoiar o desenvolvimento dos seus shows, sendo que todos os shows são prévia e cuidadosamente testados/simulados com a tecnologia AI-Test antes de serem apresentados ao cliente.'
               ;


//Token da terceira linha do corpo da proposta // com placeholder
LINE3_PLACEHOLDER: 'In the link ' LINK_PLACEHOLDER ' there is a video with a simulation of the proposed show.'
                 |'No link ' LINK_PLACEHOLDER ' encontra-se um vídeo com a simulação do show proposto.';

//Placeholder do link
LINK_PLACEHOLDER: '[link to show video]';

//Linha do Closing com o Placeholder do valor de seguro
CLOSING_FORMAT_PLACEHOLDER:'Com a aplicação do AI-Test, um exclusivo da Shodrone, temos a confiança de oferecer um seguro de responsabilidade civil no valor de ' INSURANCE_AMOUNT_PLACEHOLDER ' para o show. Os dados detalhados do show são apresentados em anexo.'
                 | 'With the application of AI-Test, a Shodrone exclusive, we are confident in offering liability insurance in the amount of ' INSURANCE_AMOUNT_PLACEHOLDER ' for the show. Detailed show data is presented in the attachment.';

//Placeholder do valor de seguro
INSURANCE_AMOUNT_PLACEHOLDER: '[valor do seguro]' | '[insurance amount]';

//Token do formato da data do show
SHOW_DATE_FORMAT: ('Date - ' | 'Data - ');

//Token do formato da linha da data com o placeholder
SHOW_DATE_PLACEHOLDER_LINE: SHOW_DATE_FORMAT SHOW_DATE_PLACEHOLDER;

//Placeholder da data
SHOW_DATE_PLACEHOLDER:'[date of the event]';

//Token do formato de cada linha na lista de figuras (PLACEHOLDER)
FIGURE_ITEM_PLACEHOLDER: FIGURE_POSITION_PLACEHOLDER ' - ' FIGURE_NAME_PLACEHOLDER;

//Placeholder da posição da figura
FIGURE_POSITION_PLACEHOLDER:'[position in show]';

//Placeholder do nome da figura
FIGURE_NAME_PLACEHOLDER:'[figure name]';

//Placeholder do customer
PERSON_NAME_PLACEHOLDER: '[Customer Representative Name]';

//Placeholder do Crm Manager
CRM_MANAGER_PLACEHOLDER: '[CRM Manager Name]';

//Placeholder da Company
COMPANY_PLACEHOLDER: '[Company name]' | '[' 'Company' ' ' 'Name' ']';

//Placeholder do address
ADDRESS_PLACEHOLDER: '[Address with postal code and country]';

//Placeholder do Vat number
VAT_NUMBER_PLACEHOLDER: '[VAT Number]' ;

//Token de unidades da linha drone item
DRONE_ITEM_FORMAT: (' units.' | ' unidades.');

//Linha da lista de drones com placeholders
DRONE_ITEM_PLACEHOLDER: DRONE_MODEL_PLACEHOLDER ' - ' DRONE_MODEL_QUANTITY_PLACEHOLDER DRONE_ITEM_FORMAT;

//Placeholder do modelo do drone
DRONE_MODEL_PLACEHOLDER:'[model]';

//Placeholder da quantidade
DRONE_MODEL_QUANTITY_PLACEHOLDER:'[quantity]';

//Token da linha da location
GPS_LINE:('Location - ' | 'Local de realização - ');

//Token da linha completa da location com o placeholder do gps
GPS_LINE_PLACEHOLDER: GPS_LINE GPS_PLACEHOLDER;

//Placeholder do gps
GPS_PLACEHOLDER: '[GPS coordinates of the location]';

//Linha do anexo
ATTACHMENT_LINE:('Attachment - Show Details ' | 'Anexo - Detalhes do Show ');

//Linha do anexo com o placeholder do show proposal number
ATTACHMENT_PLACEHOLDER: ATTACHMENT_LINE SHOW_PROPOSAL_PLACEHOLDER;

//Placeholder do numero do show proposal
SHOW_PROPOSAL_PLACEHOLDER: '[show proposal number]';

//Token da referencia
REFERENCE_LINE:('Reference '|'Referência ') ;

//Token da linha completa da referencia com os placeholders
REFERENCE_PLACEHOLDER: REFERENCE_LINE PROPOSAL_PLACEHOLDER ' / ' DATE_PLACEHOLDER;

//Placeholder do numero do proposal
PROPOSAL_PLACEHOLDER:'[proposal number]';

//Placeholder da data
DATE_PLACEHOLDER: '[date]';

//Token do time
TIME_LINE: ('Time - ' | 'Hora - ');

//Token da linha do time completo com o placeholder
TIME_PLACEHOLDER_LINE:TIME_LINE TIME_PLACEHOLDER;

//Placeholder do time
TIME_PLACEHOLDER:'[time of the event]';

//Token da duração
DURATION_LINE: ('Duration - ' | 'Duração - ');

//Token de minutos
DURATION_MINUTES:(' minutes' | ' minutos');

//Token da linha completa da duração com o placeholder
DURATION_PLACEHOLDER_LINE: DURATION_LINE DURATION_PLACEHOLDER DURATION_MINUTES;

//Placeholder da duração
DURATION_PLACEHOLDER: '[duration]';


//Token de uma quebra de página
PAGE_BREAK: '\f' | '[page break]';

//Token de uma nova linha
NEWLINE: '\r'? '\n';