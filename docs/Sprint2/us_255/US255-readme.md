# US 255 - Configuration of proposal templates

## 1. Context

* At Shodrone, each proposal sent to a client follows a standardized format, often with placeholders that need to be filled with specific customer and event information.
* To automate and validate the generation of proposals, the CRM team requires a domain-specific language (DSL) capable of expressing and verifying proposal templates. This DSL will describe the structure, placeholders, and mandatory fields in a formal way. It must also allow validation of template files and potentially support automatic generation of filled proposals.

## 2. Requirements

**US255** - As a CRM manager, I want to define a language to specify proposal templates.


**Acceptance Criteria:**

- US255.1  A formal grammar (.g4 file) must be defined using ANTLR4, representing the structure of proposal templates
- US255.2  If a template has missing or misplaced placeholders, the parser must reject it and provide an error message.
- US255.3  The grammar must support optional fields (e.g., [Customer Representative Name]) where applicable.

**Dependencies/References:**

* This user story does not depend on any user story.

**Forum Insight:**

>> Também deve ser aceite um template semelhante ao ficheiro 3 mas em português?
>
> As templates são aquelas. Ninguém lhe disse que podia criar templates para a empresa. Acho que está bem claro que é uma responsabilidade do CRM Manager.

>> A proposta de um show deve conter os drones que vão ser usadas, ou somente as figuras?
>
> Deve conter indicação dos tipos de drones e respectiva quantidade.





