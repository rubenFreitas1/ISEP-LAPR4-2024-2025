# US 373 - Get Show Info

## 1. Context

* This functionality allows the Customer to access the system and retrieve detailed information about their shows, including the drone models used, figures performed, and overall duration of the show.
* This user story ensures that the system provides a clear and accessible way for customers to track their show history and upcoming scheduled events, promoting transparency and improving customer experience.

## 2. Requirements

**US 373** As a Customer, I want to get the details of a show (scheduled or in the past), including the drone models, figures, duration, etc.


**Acceptance Criteria:**

- US373.1 The system must display all the show of the customer(the ones that are scheduled or in the past)
- US373.2 The system should display details of the show including drone models, figures, duration, etc.

*There is no dependencies attached to this US*

**Forum Insight:**

>>Gostaria de pedir um esclarecimento relativamente à US373 – Get show info, onde se refere que o cliente pode consultar os detalhes de um espetáculo (agendado ou já realizado), incluindo os modelos de drones, figuras, duração, etc.\
Ao analisar o enunciado completo, não encontrei nenhum caso de uso que peça explicitamente a funcionalidade de agendar um show. A única referência ao agendamento está na página 10, linhas 39–40, onde é referido: “Upon acceptance of the show proposal by the customer, the show is scheduled by the CRM team. This probably involves some negotiation with the customer. The date and time are stored in the system.”\
Com base nesta indicação, podemos assumir que o agendamento do espetáculo ocorre imediatamente após a aceitação da proposta? Ou pretende-se que exista uma funcionalidade separada e explícita para o agendamento do Show, com possibilidade de alteração da data e hora por parte do CRM Collaborator?
> 
> Leu mal o documento dos requisitos. Figura 1, segundo caso de uso a contar de cima.\
Pode-se concluir que o agendamento ocorre após a aceitação pelo cliente. A alteração do agendamento não é referida em lado algum.

>>Gostava de perceber se na US 373, para listar os detalhes dos shows, se o cliente apenas pode ver as informações relativas aos seus shows ou a todos.
> 
> Eu vou fingir que não fez esta questão, porque é má demais. Passa-lhe pela cabeça que os representantes de um cliente podem ver os dados dos agendamentos de outros clientes?!... A sério?\
Que confiança pode alguém ter num fornecedor que faz uma questão dessas?!