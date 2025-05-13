package genDSL;// Generated from C:/Users/Sousa/IdeaProjects/sem4pi-2024-2025-sem4pi_2024_2025_g33/shodrone.LPROG/src/main/antlr/DroneShowDSL.g4 by ANTLR 4.13.2
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link DroneShowDSLParser}.
 */
public interface DroneShowDSLListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link DroneShowDSLParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(DroneShowDSLParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link DroneShowDSLParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(DroneShowDSLParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link DroneShowDSLParser#version_id}.
	 * @param ctx the parse tree
	 */
	void enterVersion_id(DroneShowDSLParser.Version_idContext ctx);
	/**
	 * Exit a parse tree produced by {@link DroneShowDSLParser#version_id}.
	 * @param ctx the parse tree
	 */
	void exitVersion_id(DroneShowDSLParser.Version_idContext ctx);
	/**
	 * Enter a parse tree produced by {@link DroneShowDSLParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(DroneShowDSLParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link DroneShowDSLParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(DroneShowDSLParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link DroneShowDSLParser#declaration}.
	 * @param ctx the parse tree
	 */
	void enterDeclaration(DroneShowDSLParser.DeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link DroneShowDSLParser#declaration}.
	 * @param ctx the parse tree
	 */
	void exitDeclaration(DroneShowDSLParser.DeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link DroneShowDSLParser#typeDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterTypeDeclaration(DroneShowDSLParser.TypeDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link DroneShowDSLParser#typeDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitTypeDeclaration(DroneShowDSLParser.TypeDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link DroneShowDSLParser#variableAssignment}.
	 * @param ctx the parse tree
	 */
	void enterVariableAssignment(DroneShowDSLParser.VariableAssignmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link DroneShowDSLParser#variableAssignment}.
	 * @param ctx the parse tree
	 */
	void exitVariableAssignment(DroneShowDSLParser.VariableAssignmentContext ctx);
	/**
	 * Enter a parse tree produced by {@link DroneShowDSLParser#variableType}.
	 * @param ctx the parse tree
	 */
	void enterVariableType(DroneShowDSLParser.VariableTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link DroneShowDSLParser#variableType}.
	 * @param ctx the parse tree
	 */
	void exitVariableType(DroneShowDSLParser.VariableTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link DroneShowDSLParser#value}.
	 * @param ctx the parse tree
	 */
	void enterValue(DroneShowDSLParser.ValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link DroneShowDSLParser#value}.
	 * @param ctx the parse tree
	 */
	void exitValue(DroneShowDSLParser.ValueContext ctx);
	/**
	 * Enter a parse tree produced by {@link DroneShowDSLParser#coordinate}.
	 * @param ctx the parse tree
	 */
	void enterCoordinate(DroneShowDSLParser.CoordinateContext ctx);
	/**
	 * Exit a parse tree produced by {@link DroneShowDSLParser#coordinate}.
	 * @param ctx the parse tree
	 */
	void exitCoordinate(DroneShowDSLParser.CoordinateContext ctx);
	/**
	 * Enter a parse tree produced by {@link DroneShowDSLParser#objectCreation}.
	 * @param ctx the parse tree
	 */
	void enterObjectCreation(DroneShowDSLParser.ObjectCreationContext ctx);
	/**
	 * Exit a parse tree produced by {@link DroneShowDSLParser#objectCreation}.
	 * @param ctx the parse tree
	 */
	void exitObjectCreation(DroneShowDSLParser.ObjectCreationContext ctx);
	/**
	 * Enter a parse tree produced by {@link DroneShowDSLParser#shapeType}.
	 * @param ctx the parse tree
	 */
	void enterShapeType(DroneShowDSLParser.ShapeTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link DroneShowDSLParser#shapeType}.
	 * @param ctx the parse tree
	 */
	void exitShapeType(DroneShowDSLParser.ShapeTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link DroneShowDSLParser#argumentList}.
	 * @param ctx the parse tree
	 */
	void enterArgumentList(DroneShowDSLParser.ArgumentListContext ctx);
	/**
	 * Exit a parse tree produced by {@link DroneShowDSLParser#argumentList}.
	 * @param ctx the parse tree
	 */
	void exitArgumentList(DroneShowDSLParser.ArgumentListContext ctx);
	/**
	 * Enter a parse tree produced by {@link DroneShowDSLParser#argument}.
	 * @param ctx the parse tree
	 */
	void enterArgument(DroneShowDSLParser.ArgumentContext ctx);
	/**
	 * Exit a parse tree produced by {@link DroneShowDSLParser#argument}.
	 * @param ctx the parse tree
	 */
	void exitArgument(DroneShowDSLParser.ArgumentContext ctx);
	/**
	 * Enter a parse tree produced by {@link DroneShowDSLParser#methodCall}.
	 * @param ctx the parse tree
	 */
	void enterMethodCall(DroneShowDSLParser.MethodCallContext ctx);
	/**
	 * Exit a parse tree produced by {@link DroneShowDSLParser#methodCall}.
	 * @param ctx the parse tree
	 */
	void exitMethodCall(DroneShowDSLParser.MethodCallContext ctx);
	/**
	 * Enter a parse tree produced by {@link DroneShowDSLParser#method}.
	 * @param ctx the parse tree
	 */
	void enterMethod(DroneShowDSLParser.MethodContext ctx);
	/**
	 * Exit a parse tree produced by {@link DroneShowDSLParser#method}.
	 * @param ctx the parse tree
	 */
	void exitMethod(DroneShowDSLParser.MethodContext ctx);
	/**
	 * Enter a parse tree produced by {@link DroneShowDSLParser#groupBlock}.
	 * @param ctx the parse tree
	 */
	void enterGroupBlock(DroneShowDSLParser.GroupBlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link DroneShowDSLParser#groupBlock}.
	 * @param ctx the parse tree
	 */
	void exitGroupBlock(DroneShowDSLParser.GroupBlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link DroneShowDSLParser#pauseStatement}.
	 * @param ctx the parse tree
	 */
	void enterPauseStatement(DroneShowDSLParser.PauseStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link DroneShowDSLParser#pauseStatement}.
	 * @param ctx the parse tree
	 */
	void exitPauseStatement(DroneShowDSLParser.PauseStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link DroneShowDSLParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(DroneShowDSLParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link DroneShowDSLParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(DroneShowDSLParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link DroneShowDSLParser#operator}.
	 * @param ctx the parse tree
	 */
	void enterOperator(DroneShowDSLParser.OperatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link DroneShowDSLParser#operator}.
	 * @param ctx the parse tree
	 */
	void exitOperator(DroneShowDSLParser.OperatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link DroneShowDSLParser#identifier}.
	 * @param ctx the parse tree
	 */
	void enterIdentifier(DroneShowDSLParser.IdentifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link DroneShowDSLParser#identifier}.
	 * @param ctx the parse tree
	 */
	void exitIdentifier(DroneShowDSLParser.IdentifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link DroneShowDSLParser#number}.
	 * @param ctx the parse tree
	 */
	void enterNumber(DroneShowDSLParser.NumberContext ctx);
	/**
	 * Exit a parse tree produced by {@link DroneShowDSLParser#number}.
	 * @param ctx the parse tree
	 */
	void exitNumber(DroneShowDSLParser.NumberContext ctx);
	/**
	 * Enter a parse tree produced by {@link DroneShowDSLParser#color}.
	 * @param ctx the parse tree
	 */
	void enterColor(DroneShowDSLParser.ColorContext ctx);
	/**
	 * Exit a parse tree produced by {@link DroneShowDSLParser#color}.
	 * @param ctx the parse tree
	 */
	void exitColor(DroneShowDSLParser.ColorContext ctx);
}