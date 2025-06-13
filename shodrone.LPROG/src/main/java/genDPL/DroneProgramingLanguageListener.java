// Generated from C:/Users/Sousa/IdeaProjects/sem4pi-2024-2025-sem4pi_2024_2025_g33/shodrone.LPROG/src/main/java/antlr/DroneProgramingLanguage.g4 by ANTLR 4.13.2
package genDPL;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link DroneProgramingLanguageParser}.
 */
public interface DroneProgramingLanguageListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link DroneProgramingLanguageParser#start}.
	 * @param ctx the parse tree
	 */
	void enterStart(DroneProgramingLanguageParser.StartContext ctx);
	/**
	 * Exit a parse tree produced by {@link DroneProgramingLanguageParser#start}.
	 * @param ctx the parse tree
	 */
	void exitStart(DroneProgramingLanguageParser.StartContext ctx);
	/**
	 * Enter a parse tree produced by {@link DroneProgramingLanguageParser#drone_version}.
	 * @param ctx the parse tree
	 */
	void enterDrone_version(DroneProgramingLanguageParser.Drone_versionContext ctx);
	/**
	 * Exit a parse tree produced by {@link DroneProgramingLanguageParser#drone_version}.
	 * @param ctx the parse tree
	 */
	void exitDrone_version(DroneProgramingLanguageParser.Drone_versionContext ctx);
	/**
	 * Enter a parse tree produced by {@link DroneProgramingLanguageParser#type_section}.
	 * @param ctx the parse tree
	 */
	void enterType_section(DroneProgramingLanguageParser.Type_sectionContext ctx);
	/**
	 * Exit a parse tree produced by {@link DroneProgramingLanguageParser#type_section}.
	 * @param ctx the parse tree
	 */
	void exitType_section(DroneProgramingLanguageParser.Type_sectionContext ctx);
	/**
	 * Enter a parse tree produced by {@link DroneProgramingLanguageParser#type_declaration}.
	 * @param ctx the parse tree
	 */
	void enterType_declaration(DroneProgramingLanguageParser.Type_declarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link DroneProgramingLanguageParser#type_declaration}.
	 * @param ctx the parse tree
	 */
	void exitType_declaration(DroneProgramingLanguageParser.Type_declarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link DroneProgramingLanguageParser#type_value}.
	 * @param ctx the parse tree
	 */
	void enterType_value(DroneProgramingLanguageParser.Type_valueContext ctx);
	/**
	 * Exit a parse tree produced by {@link DroneProgramingLanguageParser#type_value}.
	 * @param ctx the parse tree
	 */
	void exitType_value(DroneProgramingLanguageParser.Type_valueContext ctx);
	/**
	 * Enter a parse tree produced by {@link DroneProgramingLanguageParser#variables_section}.
	 * @param ctx the parse tree
	 */
	void enterVariables_section(DroneProgramingLanguageParser.Variables_sectionContext ctx);
	/**
	 * Exit a parse tree produced by {@link DroneProgramingLanguageParser#variables_section}.
	 * @param ctx the parse tree
	 */
	void exitVariables_section(DroneProgramingLanguageParser.Variables_sectionContext ctx);
	/**
	 * Enter a parse tree produced by {@link DroneProgramingLanguageParser#variable_declaration}.
	 * @param ctx the parse tree
	 */
	void enterVariable_declaration(DroneProgramingLanguageParser.Variable_declarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link DroneProgramingLanguageParser#variable_declaration}.
	 * @param ctx the parse tree
	 */
	void exitVariable_declaration(DroneProgramingLanguageParser.Variable_declarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link DroneProgramingLanguageParser#instructions_section}.
	 * @param ctx the parse tree
	 */
	void enterInstructions_section(DroneProgramingLanguageParser.Instructions_sectionContext ctx);
	/**
	 * Exit a parse tree produced by {@link DroneProgramingLanguageParser#instructions_section}.
	 * @param ctx the parse tree
	 */
	void exitInstructions_section(DroneProgramingLanguageParser.Instructions_sectionContext ctx);
	/**
	 * Enter a parse tree produced by {@link DroneProgramingLanguageParser#instruction}.
	 * @param ctx the parse tree
	 */
	void enterInstruction(DroneProgramingLanguageParser.InstructionContext ctx);
	/**
	 * Exit a parse tree produced by {@link DroneProgramingLanguageParser#instruction}.
	 * @param ctx the parse tree
	 */
	void exitInstruction(DroneProgramingLanguageParser.InstructionContext ctx);
	/**
	 * Enter a parse tree produced by {@link DroneProgramingLanguageParser#argument_list}.
	 * @param ctx the parse tree
	 */
	void enterArgument_list(DroneProgramingLanguageParser.Argument_listContext ctx);
	/**
	 * Exit a parse tree produced by {@link DroneProgramingLanguageParser#argument_list}.
	 * @param ctx the parse tree
	 */
	void exitArgument_list(DroneProgramingLanguageParser.Argument_listContext ctx);
	/**
	 * Enter a parse tree produced by {@link DroneProgramingLanguageParser#argument}.
	 * @param ctx the parse tree
	 */
	void enterArgument(DroneProgramingLanguageParser.ArgumentContext ctx);
	/**
	 * Exit a parse tree produced by {@link DroneProgramingLanguageParser#argument}.
	 * @param ctx the parse tree
	 */
	void exitArgument(DroneProgramingLanguageParser.ArgumentContext ctx);
	/**
	 * Enter a parse tree produced by {@link DroneProgramingLanguageParser#placeholder}.
	 * @param ctx the parse tree
	 */
	void enterPlaceholder(DroneProgramingLanguageParser.PlaceholderContext ctx);
	/**
	 * Exit a parse tree produced by {@link DroneProgramingLanguageParser#placeholder}.
	 * @param ctx the parse tree
	 */
	void exitPlaceholder(DroneProgramingLanguageParser.PlaceholderContext ctx);
	/**
	 * Enter a parse tree produced by {@link DroneProgramingLanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(DroneProgramingLanguageParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link DroneProgramingLanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(DroneProgramingLanguageParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link DroneProgramingLanguageParser#term}.
	 * @param ctx the parse tree
	 */
	void enterTerm(DroneProgramingLanguageParser.TermContext ctx);
	/**
	 * Exit a parse tree produced by {@link DroneProgramingLanguageParser#term}.
	 * @param ctx the parse tree
	 */
	void exitTerm(DroneProgramingLanguageParser.TermContext ctx);
	/**
	 * Enter a parse tree produced by {@link DroneProgramingLanguageParser#tuple}.
	 * @param ctx the parse tree
	 */
	void enterTuple(DroneProgramingLanguageParser.TupleContext ctx);
	/**
	 * Exit a parse tree produced by {@link DroneProgramingLanguageParser#tuple}.
	 * @param ctx the parse tree
	 */
	void exitTuple(DroneProgramingLanguageParser.TupleContext ctx);
	/**
	 * Enter a parse tree produced by {@link DroneProgramingLanguageParser#array}.
	 * @param ctx the parse tree
	 */
	void enterArray(DroneProgramingLanguageParser.ArrayContext ctx);
	/**
	 * Exit a parse tree produced by {@link DroneProgramingLanguageParser#array}.
	 * @param ctx the parse tree
	 */
	void exitArray(DroneProgramingLanguageParser.ArrayContext ctx);
	/**
	 * Enter a parse tree produced by {@link DroneProgramingLanguageParser#op}.
	 * @param ctx the parse tree
	 */
	void enterOp(DroneProgramingLanguageParser.OpContext ctx);
	/**
	 * Exit a parse tree produced by {@link DroneProgramingLanguageParser#op}.
	 * @param ctx the parse tree
	 */
	void exitOp(DroneProgramingLanguageParser.OpContext ctx);
}