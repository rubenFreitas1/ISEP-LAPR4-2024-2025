// Generated from C:/ISEP-PROJETOS/lapr4_projeto/shodrone.LPROG/src/main/java/antlr/ShowProposal.g4 by ANTLR 4.13.2
package genShowProposal;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link ShowProposalParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface ShowProposalVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link ShowProposalParser#proposal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProposal(ShowProposalParser.ProposalContext ctx);
	/**
	 * Visit a parse tree produced by {@link ShowProposalParser#header}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitHeader(ShowProposalParser.HeaderContext ctx);
	/**
	 * Visit a parse tree produced by {@link ShowProposalParser#greeting}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGreeting(ShowProposalParser.GreetingContext ctx);
	/**
	 * Visit a parse tree produced by {@link ShowProposalParser#companyInfo}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompanyInfo(ShowProposalParser.CompanyInfoContext ctx);
	/**
	 * Visit a parse tree produced by {@link ShowProposalParser#personName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPersonName(ShowProposalParser.PersonNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link ShowProposalParser#company}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompany(ShowProposalParser.CompanyContext ctx);
	/**
	 * Visit a parse tree produced by {@link ShowProposalParser#address}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAddress(ShowProposalParser.AddressContext ctx);
	/**
	 * Visit a parse tree produced by {@link ShowProposalParser#vatNumber}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVatNumber(ShowProposalParser.VatNumberContext ctx);
	/**
	 * Visit a parse tree produced by {@link ShowProposalParser#reference}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReference(ShowProposalParser.ReferenceContext ctx);
	/**
	 * Visit a parse tree produced by {@link ShowProposalParser#titleProposal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTitleProposal(ShowProposalParser.TitleProposalContext ctx);
	/**
	 * Visit a parse tree produced by {@link ShowProposalParser#body}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBody(ShowProposalParser.BodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link ShowProposalParser#line_1}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLine_1(ShowProposalParser.Line_1Context ctx);
	/**
	 * Visit a parse tree produced by {@link ShowProposalParser#line_2}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLine_2(ShowProposalParser.Line_2Context ctx);
	/**
	 * Visit a parse tree produced by {@link ShowProposalParser#line_3}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLine_3(ShowProposalParser.Line_3Context ctx);
	/**
	 * Visit a parse tree produced by {@link ShowProposalParser#closing}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClosing(ShowProposalParser.ClosingContext ctx);
	/**
	 * Visit a parse tree produced by {@link ShowProposalParser#signature}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSignature(ShowProposalParser.SignatureContext ctx);
	/**
	 * Visit a parse tree produced by {@link ShowProposalParser#signature_option}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSignature_option(ShowProposalParser.Signature_optionContext ctx);
	/**
	 * Visit a parse tree produced by {@link ShowProposalParser#preferencePhrase}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPreferencePhrase(ShowProposalParser.PreferencePhraseContext ctx);
	/**
	 * Visit a parse tree produced by {@link ShowProposalParser#subscribePhrase}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSubscribePhrase(ShowProposalParser.SubscribePhraseContext ctx);
	/**
	 * Visit a parse tree produced by {@link ShowProposalParser#lastPhrase}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLastPhrase(ShowProposalParser.LastPhraseContext ctx);
	/**
	 * Visit a parse tree produced by {@link ShowProposalParser#regards}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRegards(ShowProposalParser.RegardsContext ctx);
	/**
	 * Visit a parse tree produced by {@link ShowProposalParser#showDetails}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitShowDetails(ShowProposalParser.ShowDetailsContext ctx);
	/**
	 * Visit a parse tree produced by {@link ShowProposalParser#location}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLocation(ShowProposalParser.LocationContext ctx);
	/**
	 * Visit a parse tree produced by {@link ShowProposalParser#date}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDate(ShowProposalParser.DateContext ctx);
	/**
	 * Visit a parse tree produced by {@link ShowProposalParser#time}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTime(ShowProposalParser.TimeContext ctx);
	/**
	 * Visit a parse tree produced by {@link ShowProposalParser#duration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDuration(ShowProposalParser.DurationContext ctx);
	/**
	 * Visit a parse tree produced by {@link ShowProposalParser#droneList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDroneList(ShowProposalParser.DroneListContext ctx);
	/**
	 * Visit a parse tree produced by {@link ShowProposalParser#figureList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFigureList(ShowProposalParser.FigureListContext ctx);
}