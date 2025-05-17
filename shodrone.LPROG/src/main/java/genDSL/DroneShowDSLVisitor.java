// Generated from D:/Utilizadores/JoseRibeiro/Desktop/Universidade/2ºano_4ºsemestre/PROJETO_SEM4/shodrone.LPROG/src/main/java/antlr/DroneShowDSL.g4 by ANTLR 4.13.2
package genDSL;
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
	 * Visit a parse tree produced by {@link DroneShowDSLParser#version}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVersion(DroneShowDSLParser.VersionContext ctx);
	/**
	 * Visit a parse tree produced by {@link DroneShowDSLParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(DroneShowDSLParser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link DroneShowDSLParser#beforeBlock}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBeforeBlock(DroneShowDSLParser.BeforeBlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link DroneShowDSLParser#afterBlock}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAfterBlock(DroneShowDSLParser.AfterBlockContext ctx);
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
	 * Visit a parse tree produced by {@link DroneShowDSLParser#expressionOrCoordinate}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionOrCoordinate(DroneShowDSLParser.ExpressionOrCoordinateContext ctx);
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
	 * Visit a parse tree produced by {@link DroneShowDSLParser#params}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParams(DroneShowDSLParser.ParamsContext ctx);
	/**
	 * Visit a parse tree produced by {@link DroneShowDSLParser#methodCall}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethodCall(DroneShowDSLParser.MethodCallContext ctx);
	/**
	 * Visit a parse tree produced by {@link DroneShowDSLParser#methodCallTail}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethodCallTail(DroneShowDSLParser.MethodCallTailContext ctx);
	/**
	 * Visit a parse tree produced by {@link DroneShowDSLParser#methodName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethodName(DroneShowDSLParser.MethodNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link DroneShowDSLParser#methodParams}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethodParams(DroneShowDSLParser.MethodParamsContext ctx);
	/**
	 * Visit a parse tree produced by {@link DroneShowDSLParser#coordinateParam}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCoordinateParam(DroneShowDSLParser.CoordinateParamContext ctx);
	/**
	 * Visit a parse tree produced by {@link DroneShowDSLParser#expressionParams}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionParams(DroneShowDSLParser.ExpressionParamsContext ctx);
	/**
	 * Visit a parse tree produced by {@link DroneShowDSLParser#colorParam}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitColorParam(DroneShowDSLParser.ColorParamContext ctx);
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
	 * Visit a parse tree produced by the {@code MultExpr}
	 * labeled alternative in {@link DroneShowDSLParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultExpr(DroneShowDSLParser.MultExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code NegExpr}
	 * labeled alternative in {@link DroneShowDSLParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNegExpr(DroneShowDSLParser.NegExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code PrimaryExpr}
	 * labeled alternative in {@link DroneShowDSLParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimaryExpr(DroneShowDSLParser.PrimaryExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code AddExpr}
	 * labeled alternative in {@link DroneShowDSLParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAddExpr(DroneShowDSLParser.AddExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link DroneShowDSLParser#primary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimary(DroneShowDSLParser.PrimaryContext ctx);
}