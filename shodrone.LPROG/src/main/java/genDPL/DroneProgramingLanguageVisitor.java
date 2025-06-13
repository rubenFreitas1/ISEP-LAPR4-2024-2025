// Generated from C:/Users/Sousa/IdeaProjects/sem4pi-2024-2025-sem4pi_2024_2025_g33/shodrone.LPROG/src/main/java/antlr/DroneProgramingLanguage.g4 by ANTLR 4.13.2
package genDPL;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link DroneProgramingLanguageParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface DroneProgramingLanguageVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link DroneProgramingLanguageParser#start}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStart(DroneProgramingLanguageParser.StartContext ctx);
	/**
	 * Visit a parse tree produced by {@link DroneProgramingLanguageParser#drone_version}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDrone_version(DroneProgramingLanguageParser.Drone_versionContext ctx);
	/**
	 * Visit a parse tree produced by {@link DroneProgramingLanguageParser#type_section}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType_section(DroneProgramingLanguageParser.Type_sectionContext ctx);
	/**
	 * Visit a parse tree produced by {@link DroneProgramingLanguageParser#type_declaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType_declaration(DroneProgramingLanguageParser.Type_declarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link DroneProgramingLanguageParser#type_value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType_value(DroneProgramingLanguageParser.Type_valueContext ctx);
	/**
	 * Visit a parse tree produced by {@link DroneProgramingLanguageParser#variables_section}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariables_section(DroneProgramingLanguageParser.Variables_sectionContext ctx);
	/**
	 * Visit a parse tree produced by {@link DroneProgramingLanguageParser#variable_declaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariable_declaration(DroneProgramingLanguageParser.Variable_declarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link DroneProgramingLanguageParser#instructions_section}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInstructions_section(DroneProgramingLanguageParser.Instructions_sectionContext ctx);
	/**
	 * Visit a parse tree produced by {@link DroneProgramingLanguageParser#instruction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInstruction(DroneProgramingLanguageParser.InstructionContext ctx);
	/**
	 * Visit a parse tree produced by {@link DroneProgramingLanguageParser#argument_list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArgument_list(DroneProgramingLanguageParser.Argument_listContext ctx);
	/**
	 * Visit a parse tree produced by {@link DroneProgramingLanguageParser#argument}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArgument(DroneProgramingLanguageParser.ArgumentContext ctx);
	/**
	 * Visit a parse tree produced by {@link DroneProgramingLanguageParser#placeholder}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPlaceholder(DroneProgramingLanguageParser.PlaceholderContext ctx);
	/**
	 * Visit a parse tree produced by {@link DroneProgramingLanguageParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(DroneProgramingLanguageParser.ExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link DroneProgramingLanguageParser#term}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTerm(DroneProgramingLanguageParser.TermContext ctx);
	/**
	 * Visit a parse tree produced by {@link DroneProgramingLanguageParser#tuple}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTuple(DroneProgramingLanguageParser.TupleContext ctx);
	/**
	 * Visit a parse tree produced by {@link DroneProgramingLanguageParser#array}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArray(DroneProgramingLanguageParser.ArrayContext ctx);
	/**
	 * Visit a parse tree produced by {@link DroneProgramingLanguageParser#op}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOp(DroneProgramingLanguageParser.OpContext ctx);
}