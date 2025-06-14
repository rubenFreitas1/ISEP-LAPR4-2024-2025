package shodrone.DPL.Plugin.java;

import lombok.Getter;
import org.antlr.v4.runtime.tree.ParseTreeListener;
@Getter
public class DPLListener extends DroneProgramingLanguageBaseListener implements ParseTreeListener {

    private boolean isValid = true;

    @Override
    public void enterStart(DroneProgramingLanguageParser.StartContext ctx) {
        if (ctx == null) {
            isValid = false;
            System.err.println("Erro: Contexto de início é nulo.");
            return;
        }
        System.out.println("Iniciando o programa...");
    }

    @Override
    public void exitStart(DroneProgramingLanguageParser.StartContext ctx) {
        if (!isValid) {
            System.err.println("Erro: O programa contém erros de sintaxe.");
            return;
        }
        System.out.println("Finalizando o programa...");
    }

    @Override
    public void enterDrone_version(DroneProgramingLanguageParser.Drone_versionContext ctx) {
        if (ctx == null) {
            isValid = false;
            System.err.println("Erro: Contexto de versão do drone é nulo.");
            return;
        }
        System.out.println("Versão da linguagem detectada: " + ctx.getText());
    }

    @Override
    public void enterType_section(DroneProgramingLanguageParser.Type_sectionContext ctx) {
        if (ctx == null) {
            isValid = false;
            System.err.println("Erro: Contexto de seção de tipos é nulo.");
            return;
        }
        System.out.println("Seção de tipos iniciada.");
    }

    @Override
    public void enterType_declaration(DroneProgramingLanguageParser.Type_declarationContext ctx) {
        if (ctx == null) {
            isValid = false;
            System.err.println("Erro: Contexto de declaração de tipo é nulo.");
            return;
        }
        System.out.println("Declaração de tipo: " + ctx.getText());
    }

    @Override
    public void enterVariables_section(DroneProgramingLanguageParser.Variables_sectionContext ctx) {
        if (ctx == null) {
            isValid = false;
            System.err.println("Erro: Contexto de seção de variáveis é nulo.");
            return;
        }
        System.out.println("Seção de variáveis iniciada.");
    }

    @Override
    public void enterVariable_declaration(DroneProgramingLanguageParser.Variable_declarationContext ctx) {
        if (ctx == null) {
            isValid = false;
            System.err.println("Erro: Contexto de declaração de variável é nulo.");
            return;
        }
        System.out.println("Declaração de variável: " + ctx.getText());
    }

    @Override
    public void enterInstructions_section(DroneProgramingLanguageParser.Instructions_sectionContext ctx) {
        if (ctx == null) {
            isValid = false;
            System.err.println("Erro: Contexto de seção de instruções é nulo.");
            return;
        }
        System.out.println("Seção de instruções iniciada.");
    }

    @Override
    public void enterInstruction(DroneProgramingLanguageParser.InstructionContext ctx) {
        if (ctx == null) {
            isValid = false;
            System.err.println("Erro: Contexto de instrução é nulo.");
            return;
        }
        System.out.println("Instrução detectada: " + ctx.getText());
    }

    @Override
    public void enterExpression(DroneProgramingLanguageParser.ExpressionContext ctx) {
        if (ctx == null) {
            isValid = false;
            System.err.println("Erro: Contexto de expressão é nulo.");
            return;
        }
        System.out.println("Expressão detectada: " + ctx.getText());
    }

    @Override
    public void enterTuple(DroneProgramingLanguageParser.TupleContext ctx) {
        if (ctx == null) {
            isValid = false;
            System.err.println("Erro: Contexto de tupla é nulo.");
            return;
        }
        System.out.println("Tupla detectada: " + ctx.getText());
    }

    @Override
    public void enterArray(DroneProgramingLanguageParser.ArrayContext ctx) {
        if (ctx == null) {
            isValid = false;
            System.err.println("Erro: Contexto de array é nulo.");
            return;
        }
        System.out.println("Array detectado: " + ctx.getText());
    }

    @Override
    public void enterPlaceholder(DroneProgramingLanguageParser.PlaceholderContext ctx) {
        if (ctx == null) {
            isValid = false;
            System.err.println("Erro: Contexto de placeholder é nulo.");
            return;
        }
        System.out.println("Placeholder detectado: " + ctx.getText());
    }

    @Override
    public void enterOp(DroneProgramingLanguageParser.OpContext ctx) {
        if (ctx == null) {
            System.out.println("Operador detectado: " + ctx.getText());
        }
    }
}
