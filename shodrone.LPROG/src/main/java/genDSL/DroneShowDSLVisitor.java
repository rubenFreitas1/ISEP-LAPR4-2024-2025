package genDSL;// Generated from C:/Users/Sousa/IdeaProjects/sem4pi-2024-2025-sem4pi_2024_2025_g33/shodrone.LPROG/src/main/antlr/DroneShowDSL.g4 by ANTLR 4.13.2
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link DroneShowDSLParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface DroneShowDSLVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link DroneShowDSLParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(DroneShowDSLParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link DroneShowDSLParser#version_id}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVersion_id(DroneShowDSLParser.Version_idContext ctx);
	/**
	 * Visit a parse tree produced by {@link DroneShowDSLParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(DroneShowDSLParser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link DroneShowDSLParser#declaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclaration(DroneShowDSLParser.DeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link DroneShowDSLParser#typeDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeDeclaration(DroneShowDSLParser.TypeDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link DroneShowDSLParser#variableAssignment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableAssignment(DroneShowDSLParser.VariableAssignmentContext ctx);
	/**
	 * Visit a parse tree produced by {@link DroneShowDSLParser#variableType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableType(DroneShowDSLParser.VariableTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link DroneShowDSLParser#value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValue(DroneShowDSLParser.ValueContext ctx);
	/**
	 * Visit a parse tree produced by {@link DroneShowDSLParser#coordinate}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCoordinate(DroneShowDSLParser.CoordinateContext ctx);
	/**
	 * Visit a parse tree produced by {@link DroneShowDSLParser#objectCreation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitObjectCreation(DroneShowDSLParser.ObjectCreationContext ctx);
	/**
	 * Visit a parse tree produced by {@link DroneShowDSLParser#shapeType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitShapeType(DroneShowDSLParser.ShapeTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link DroneShowDSLParser#argumentList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArgumentList(DroneShowDSLParser.ArgumentListContext ctx);
	/**
	 * Visit a parse tree produced by {@link DroneShowDSLParser#argument}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArgument(DroneShowDSLParser.ArgumentContext ctx);
	/**
	 * Visit a parse tree produced by {@link DroneShowDSLParser#methodCall}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethodCall(DroneShowDSLParser.MethodCallContext ctx);
	/**
	 * Visit a parse tree produced by {@link DroneShowDSLParser#method}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethod(DroneShowDSLParser.MethodContext ctx);
	/**
	 * Visit a parse tree produced by {@link DroneShowDSLParser#groupBlock}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGroupBlock(DroneShowDSLParser.GroupBlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link DroneShowDSLParser#pauseStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPauseStatement(DroneShowDSLParser.PauseStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link DroneShowDSLParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(DroneShowDSLParser.ExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link DroneShowDSLParser#operator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOperator(DroneShowDSLParser.OperatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link DroneShowDSLParser#identifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdentifier(DroneShowDSLParser.IdentifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link DroneShowDSLParser#number}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumber(DroneShowDSLParser.NumberContext ctx);
	/**
	 * Visit a parse tree produced by {@link DroneShowDSLParser#color}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitColor(DroneShowDSLParser.ColorContext ctx);
}