# US 236 - Edit a show request

## 1. Context

* In the Shodrone CRM system, a show request is created by a CRM Collaborator when a customer expresses interest in scheduling a drone show. This request includes details such as customer identity, event location, date and time, tentative number of drones, duration, and a document describing the sequence of figures and exclusivity requirements.
* User Story US236 is focused on allowing CRM Collaborators to edit show requests — but strictly only those that do not yet have an associated proposal. This ensures consistency and integrity of the negotiation and proposal process, preventing retroactive changes that could impact agreed terms or design work already underway.

## 2. Requirements

**US236** - As CRM Collaborator, I want to edit a show requests of a client.

**Acceptance Criteria:**

- US230.1 The system must guarantee only show requests without a proposal can be edited.

**Dependencies/References:**

* This user story depends on user story US230 because to edit a show request the show request must already be registered in the system

**Forum Insight:**

>>Boa tarde,/
Ao editar um show request, acha relevante registar essa edição no seu histórico, uma vez que se trata de um acontecimento relacionado com o próprio show request?/
Muito obrigado,/
Gabriel Sotto Mayor
>
> Boa tarde,/
Parece-me apropriado registar as alterações do show request./
Cumprimentos,/
Angelo Martins

>>Boa tarde,
Relativamente à user story US236 – Edit Show Requests, gostaria de confirmar alguns pontos:\
1 Que campos de um show request podem ser editados?
   É possível editar todos os dados inseridos no momento da criação ou há campos que devem permanecer inalteráveis?\
2 O CRM Collaborator pode editar qualquer show request, ou apenas os criados por si?\
3 Deve existir algum registo dessa edição?\
Cumprimentos,
> 
>Boa tarde,\
1 O enunciado da US236 tem boas indicações sobre o que pode ser alterado. Não me parece razoável alterar o cliente.\
2 No enunciado não são indicadas restrições.\
3 Era muito mau se não houvesse.\
Cumprimentos,\
Angelo Martins

>>Boa tarde,\
Na us 236, todos os campos de um show request podem ser editados ? ou o cliente apenas quer que seja possivel editar alguns campos em especifico ?
Um show request pode ser editato para cancelar o pedido?\
Obrigado.
> 
> Boa tarde,\
1 Não vai alterar o cliente...\
2 Não.\
Cumprimentos,\
Angelo Martins

## 3. Analysis

![System Sequence Diagram](images/system-sequence-diagram-US236.svg)

## 4. Design


### 4.1. Sequence Diagram

![Sequence Diagram](images/sequence-diagram-US236.svg)

### 4.3. Applied Patterns

### 4.4. Acceptance Tests

Include here the main tests used to validate the functionality. Focus on how they relate to the acceptance criteria. May be automated or manual tests.

**Test 1:** *Verifies that it is not possible to ...*

**Refers to Acceptance Criteria:** US101.1


```
@Test(expected = IllegalArgumentException.class)
public void ensureXxxxYyyy() {
...
}
````

## 5. Implementation

*In this section the team should present, if necessary, some evidencies that the implementation is according to the design. It should also describe and explain other important artifacts necessary to fully understand the implementation like, for instance, configuration files.*

*It is also a best practice to include a listing (with a brief summary) of the major commits regarding this requirement.*

## 6. Integration/Demonstration

*In this section the team should describe the efforts realized in order to integrate this functionality with the other parts/components of the system*

*It is also important to explain any scripts or instructions required to execute an demonstrate this functionality*

## 7. Observations

*This section should be used to include any content that does not fit any of the previous sections.*

*The team should present here, for instance, a critical prespective on the developed work including the analysis of alternative solutioons or related works*

*The team should include in this section statements/references regarding third party works that were used in the development this work.*
