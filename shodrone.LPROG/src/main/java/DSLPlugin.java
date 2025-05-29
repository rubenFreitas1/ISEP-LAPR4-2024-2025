import genDSL.DroneShowDSLBaseVisitor;
import genDSL.DroneShowDSLParser;

public class DSLPlugin extends DroneShowDSLBaseVisitor<Void> {

    @Override
    public Void visitTypeDeclaration(DroneShowDSLParser.TypeDeclarationContext ctx) {
        String droneType = ctx.IDENTIFIER().getText();
        System.out.println("➤ Tipo de drone declarado: " + droneType);
        return null;
    }

    @Override
    public Void visitObjectCreation(DroneShowDSLParser.ObjectCreationContext ctx) {
        String shape = ctx.shapeType().getText();
        String name = ctx.IDENTIFIER().getText();
        System.out.println("➤ Criado objeto: " + shape + " com nome " + name);
        return null;
    }

    @Override
    public Void visitVariableAssignment(DroneShowDSLParser.VariableAssignmentContext ctx) {
        String varName = ctx.IDENTIFIER().getText();
        System.out.println("➤ Atribuição à variável: " + varName);
        return super.visitVariableAssignment(ctx);
    }

    @Override
    public Void visitPauseStatement(DroneShowDSLParser.PauseStatementContext ctx) {
        String seconds = ctx.expression().getText();
        System.out.println("⏸ Pausa de " + seconds + " segundos.");
        return null;
    }
}
