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
      ('[page break]' | ('\f'))
      NEWLINE NEWLINE
      showDetails
      EOF
    ;

proposalNewTry: proposalWithRep | proposalWithoutRep;

proposalWithRep: greeting NEWLINE companyInfo ;
proposalWithoutRep: greeting NEWLINE companyInfoWithoutRep ;

//Regra para o header (cabeçalho da proposta)
header
    : greeting NEWLINE (companyInfo | companyInfoWithoutRep);

// Diferentes opções de greeting usados nas templates do show proposal
greeting
    :('Dear Sirs,' | 'Exmos. Senhores' | 'Dear,');

//Informações da empresa (Customer Name, Adress)
companyInfo
    :
      descriptionName NEWLINE
      descriptionName NEWLINE
      vatNumber NEWLINE
    ;

//Informações da empresa (Representante, Customer Name, Adress)
companyInfoWithoutRep
    : descriptionName NEWLINE
      descriptionName NEWLINE
      descriptionName NEWLINE
      vatNumber NEWLINE
    ;


//Informações do número de contribuinte da empresa (aceita o número de contribuinte)
vatNumber
    : VAT_NUMBER
    ;


//Informações da referência da proposta (aceita a referência)
reference
    : realReference NEWLINE titleProposal
    ;

//Regra da referencia com dados reais
realReference: ('Reference '|'Referência ') INT ' / ' DATE;


//Titulos das propostas presentes nos templates do show proposal
titleProposal
    : 'Show Proposal'
    | 'Proposta de Show';

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
normal_line1:'A Shodrone tem o prazer de submeter à V/ apreciação uma proposta para execução de um show aéreo com drones, conforme descrição abaixo.'
            | 'Shodrone is pleased to submit for your consideration a proposal for the execution of an aerial show with drones, as described below.';

//Regra da Primeira linha em que o customer é vip
vip_line1: descriptionName ' is a VIP client and Shodrone is pleased to submit for your consideration a proposal for the execution of an aerial show with drones, as described below.'
        | descriptionName ' é um cliente VIP e a Shodrone tem o prazer de submeter à vossa apreciação uma proposta para a execução de um espetáculo aéreo com drones, tal como descrito abaixo.';


//Segunda linha do corpo da proposta
line_2
    :'Shodrone is a company that prioritizes safety, which is why it uses the most advanced AI technology to support the development of its shows, with all shows being previously and carefully tested/simulated with AI-Test technology before being presented to the client.'
    | 'A Shodrone é uma empresa que dá prioridade à segurança, pelo que usa a mais avançada tecnologia de IA para apoiar o desenvolvimento dos seus shows, sendo que todos os shows são prévia e cuidadosamente testados/simulados com a tecnologia AI-Test antes de serem apresentados ao cliente.'
    ;

//Terceira linha do corpo da proposta
line_3
    :'In the link ' LINK ' there is a video with a simulation of the proposed show.'
    |'No link ' LINK ' encontra-se um vídeo com a simulação do show proposto.'
    ;


//Linha que fecha o corpo da proposta
closing
    :  'Com a aplicação do AI-Test, um exclusivo da Shodrone, temos a confiança de oferecer um seguro de responsabilidade civil no valor de ' INT ' para o show. Os dados detalhados do show são apresentados em anexo.'
    | 'With the application of AI-Test, a Shodrone exclusive, we are confident in offering liability insurance in the amount of ' INT ' for the show. Detailed show data is presented in the attachment.';




//Regra para aceitar as frases de signature da proposta, e tambem o final da pagina da proposta
signature
    : signature_option NEWLINE
      regards NEWLINE
      NEWLINE descriptionName
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
    :'We subscribe at your disposal.'
    | 'Subscrevemo-nos ao dispor.'
    ;

//Frase que aparece na ultima linha da signature da proposta
lastPhrase:'Looking forward to hearing from you soon.';


//Frases que podem aparecer no final da proposta
regards
    : 'Best regards,'
    | 'Melhores cumprimentos,';


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
attachment: ('Attachment - Show Details ' | 'Anexo - Detalhes do Show ') INT;


//Regra para aceitar as diferentes opções de localização do show (dados reais)
location
    : ('Location - ' | 'Local de realização - ') GPS
    ;

//Regra para aceitar as diferentes opções de data do show (dados reais)
date
    : ('Date - ' | 'Data - ') DATE;


//Regra para aceitar as diferentes opções de hora do show (dados reais)
time
    :('Time - ' | 'Hora - ') TIME;

//Regra para aceitar as diferentes opções de duração do show (dados reais)
duration
    : ('Duration - ' | 'Duração - ')  INT (' minutes' | ' minutos')
    ;

//Regra para aceitar a lista de drones (dados reais)
droneList
    : ('#List of used drones' | '#Lista de drones utilizados') NEWLINE
      droneListReal+
    ;

//Regra para linha da lista de drones (dados reais)
droneListReal
    : descriptionName NEWLINE?;

//Regra para aceitar a lista de figuras (dados reais)
figureList
    : ('#Lista de figuras' | '#List of figures') NEWLINE
    figureListReal+
    ;

//Regra para linha de lista de figuras (dados reais)
figureListReal
    : descriptionName NEWLINE?;


descriptionName : (MESSAGE | INT | DIGIT | '_' | DASH | ',' | '.' | ' ' | ':')+;


//Linha com dados reais da localização
GPS:(('-'|'+')?[0-9]+('.'[0-9]+)?', '('-'|'+')?[0-9]+('.'[0-9]+)?);


//Token do formato de uma data
DATE: ('0'[1-9]|[12][0-9]|'3'[01])'-'('0'[1-9]|'1'[0-2])'-20'[2-9][0-9];



//Linha completa da hora do show com dados reais
TIME: ([0-9][0-9]':'[0-9][0-9]);




//Token de um número de contribuinte português
VAT_NUMBER: 'PT' INT;

NEWLINE: '\n';

INT: [0-9]+(('.'|',')[0-9]+)?;
DIGIT: [0-9];


//Token do formato do link
LINK: ('http' | 'https') '://' ~[ \t\r\n]+;

DASH: '–' | '-';


MESSAGE: LETTER+;

LETTER: [a-zA-Zà-öÀ-Öø-ÿ];

//Token de uma nova linha
