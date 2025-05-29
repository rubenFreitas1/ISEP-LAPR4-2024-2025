// Generated from D:/Utilizadores/JoseRibeiro/Desktop/Universidade/2ºano_4ºsemestre/PROJETO_SEM4/shodrone.LPROG/src/main/java/antlr/DroneShowDSL.g4 by ANTLR 4.13.2
package genDSL;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link DroneShowDSLParser}.
 */
public interface DroneShowDSLListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link DroneShowDSLParser#start}.
	 * @param ctx the parse tree
	 */
	void enterStart(DroneShowDSLParser.StartContext ctx);
	/**
	 * Exit a parse tree produced by {@link DroneShowDSLParser#start}.
	 * @param ctx the parse tree
	 */
	void exitStart(DroneShowDSLParser.StartContext ctx);
	/**
	 * Enter a parse tree produced by {@link DroneShowDSLParser#version}.
	 * @param ctx the parse tree
	 */
	void enterVersion(DroneShowDSLParser.VersionContext ctx);
	/**
	 * Exit a parse tree produced by {@link DroneShowDSLParser#version}.
	 * @param ctx the parse tree
	 */
	void exitVersion(DroneShowDSLParser.VersionContext ctx);
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
	 * Enter a parse tree produced by {@link DroneShowDSLParser#beforeBlock}.
	 * @param ctx the parse tree
	 */
	void enterBeforeBlock(DroneShowDSLParser.BeforeBlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link DroneShowDSLParser#beforeBlock}.
	 * @param ctx the parse tree
	 */
	void exitBeforeBlock(DroneShowDSLParser.BeforeBlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link DroneShowDSLParser#afterBlock}.
	 * @param ctx the parse tree
	 */
	void enterAfterBlock(DroneShowDSLParser.AfterBlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link DroneShowDSLParser#afterBlock}.
	 * @param ctx the parse tree
	 */
	void exitAfterBlock(DroneShowDSLParser.AfterBlockContext ctx);
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
	 * Enter a parse tree produced by {@link DroneShowDSLParser#expressionOrCoordinate}.
	 * @param ctx the parse tree
	 */
	void enterExpressionOrCoordinate(DroneShowDSLParser.ExpressionOrCoordinateContext ctx);
	/**
	 * Exit a parse tree produced by {@link DroneShowDSLParser#expressionOrCoordinate}.
	 * @param ctx the parse tree
	 */
	void exitExpressionOrCoordinate(DroneShowDSLParser.ExpressionOrCoordinateContext ctx);
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
	 * Enter a parse tree produced by {@link DroneShowDSLParser#params}.
	 * @param ctx the parse tree
	 */
	void enterParams(DroneShowDSLParser.ParamsContext ctx);
	/**
	 * Exit a parse tree produced by {@link DroneShowDSLParser#params}.
	 * @param ctx the parse tree
	 */
	void exitParams(DroneShowDSLParser.ParamsContext ctx);
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
	 * Enter a parse tree produced by {@link DroneShowDSLParser#methodCallTail}.
	 * @param ctx the parse tree
	 */
	void enterMethodCallTail(DroneShowDSLParser.MethodCallTailContext ctx);
	/**
	 * Exit a parse tree produced by {@link DroneShowDSLParser#methodCallTail}.
	 * @param ctx the parse tree
	 */
	void exitMethodCallTail(DroneShowDSLParser.MethodCallTailContext ctx);
	/**
	 * Enter a parse tree produced by {@link DroneShowDSLParser#methodName}.
	 * @param ctx the parse tree
	 */
	void enterMethodName(DroneShowDSLParser.MethodNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link DroneShowDSLParser#methodName}.
	 * @param ctx the parse tree
	 */
	void exitMethodName(DroneShowDSLParser.MethodNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link DroneShowDSLParser#methodParams}.
	 * @param ctx the parse tree
	 */
	void enterMethodParams(DroneShowDSLParser.MethodParamsContext ctx);
	/**
	 * Exit a parse tree produced by {@link DroneShowDSLParser#methodParams}.
	 * @param ctx the parse tree
	 */
	void exitMethodParams(DroneShowDSLParser.MethodParamsContext ctx);
	/**
	 * Enter a parse tree produced by {@link DroneShowDSLParser#coordinateParam}.
	 * @param ctx the parse tree
	 */
	void enterCoordinateParam(DroneShowDSLParser.CoordinateParamContext ctx);
	/**
	 * Exit a parse tree produced by {@link DroneShowDSLParser#coordinateParam}.
	 * @param ctx the parse tree
	 */
	void exitCoordinateParam(DroneShowDSLParser.CoordinateParamContext ctx);
	/**
	 * Enter a parse tree produced by {@link DroneShowDSLParser#expressionParams}.
	 * @param ctx the parse tree
	 */
	void enterExpressionParams(DroneShowDSLParser.ExpressionParamsContext ctx);
	/**
	 * Exit a parse tree produced by {@link DroneShowDSLParser#expressionParams}.
	 * @param ctx the parse tree
	 */
	void exitExpressionParams(DroneShowDSLParser.ExpressionParamsContext ctx);
	/**
	 * Enter a parse tree produced by {@link DroneShowDSLParser#colorParam}.
	 * @param ctx the parse tree
	 */
	void enterColorParam(DroneShowDSLParser.ColorParamContext ctx);
	/**
	 * Exit a parse tree produced by {@link DroneShowDSLParser#colorParam}.
	 * @param ctx the parse tree
	 */
	void exitColorParam(DroneShowDSLParser.ColorParamContext ctx);
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
	 * Enter a parse tree produced by the {@code MultExpr}
	 * labeled alternative in {@link DroneShowDSLParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterMultExpr(DroneShowDSLParser.MultExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code MultExpr}
	 * labeled alternative in {@link DroneShowDSLParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitMultExpr(DroneShowDSLParser.MultExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code NegExpr}
	 * labeled alternative in {@link DroneShowDSLParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterNegExpr(DroneShowDSLParser.NegExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code NegExpr}
	 * labeled alternative in {@link DroneShowDSLParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitNegExpr(DroneShowDSLParser.NegExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code PrimaryExpr}
	 * labeled alternative in {@link DroneShowDSLParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterPrimaryExpr(DroneShowDSLParser.PrimaryExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code PrimaryExpr}
	 * labeled alternative in {@link DroneShowDSLParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitPrimaryExpr(DroneShowDSLParser.PrimaryExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code AddExpr}
	 * labeled alternative in {@link DroneShowDSLParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterAddExpr(DroneShowDSLParser.AddExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AddExpr}
	 * labeled alternative in {@link DroneShowDSLParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitAddExpr(DroneShowDSLParser.AddExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link DroneShowDSLParser#primary}.
	 * @param ctx the parse tree
	 */
	void enterPrimary(DroneShowDSLParser.PrimaryContext ctx);
	/**
	 * Exit a parse tree produced by {@link DroneShowDSLParser#primary}.
	 * @param ctx the parse tree
	 */
	void exitPrimary(DroneShowDSLParser.PrimaryContext ctx);
}