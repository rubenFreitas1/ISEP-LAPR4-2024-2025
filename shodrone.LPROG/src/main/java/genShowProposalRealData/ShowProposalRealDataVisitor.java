// Generated from C:/ISEP-PROJETOS/lapr4_projeto/shodrone.LPROG/src/main/java/antlr/ShowProposalRealData.g4 by ANTLR 4.13.2
package genShowProposalRealData;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link ShowProposalRealDataParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface ShowProposalRealDataVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link ShowProposalRealDataParser#proposal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProposal(ShowProposalRealDataParser.ProposalContext ctx);
	/**
	 * Visit a parse tree produced by {@link ShowProposalRealDataParser#proposalNewTry}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProposalNewTry(ShowProposalRealDataParser.ProposalNewTryContext ctx);
	/**
	 * Visit a parse tree produced by {@link ShowProposalRealDataParser#proposalWithRep}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProposalWithRep(ShowProposalRealDataParser.ProposalWithRepContext ctx);
	/**
	 * Visit a parse tree produced by {@link ShowProposalRealDataParser#proposalWithoutRep}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProposalWithoutRep(ShowProposalRealDataParser.ProposalWithoutRepContext ctx);
	/**
	 * Visit a parse tree produced by {@link ShowProposalRealDataParser#header}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitHeader(ShowProposalRealDataParser.HeaderContext ctx);
	/**
	 * Visit a parse tree produced by {@link ShowProposalRealDataParser#greeting}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGreeting(ShowProposalRealDataParser.GreetingContext ctx);
	/**
	 * Visit a parse tree produced by {@link ShowProposalRealDataParser#companyInfo}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompanyInfo(ShowProposalRealDataParser.CompanyInfoContext ctx);
	/**
	 * Visit a parse tree produced by {@link ShowProposalRealDataParser#companyInfoWithoutRep}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompanyInfoWithoutRep(ShowProposalRealDataParser.CompanyInfoWithoutRepContext ctx);
	/**
	 * Visit a parse tree produced by {@link ShowProposalRealDataParser#vatNumber}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVatNumber(ShowProposalRealDataParser.VatNumberContext ctx);
	/**
	 * Visit a parse tree produced by {@link ShowProposalRealDataParser#reference}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReference(ShowProposalRealDataParser.ReferenceContext ctx);
	/**
	 * Visit a parse tree produced by {@link ShowProposalRealDataParser#realReference}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRealReference(ShowProposalRealDataParser.RealReferenceContext ctx);
	/**
	 * Visit a parse tree produced by {@link ShowProposalRealDataParser#titleProposal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTitleProposal(ShowProposalRealDataParser.TitleProposalContext ctx);
	/**
	 * Visit a parse tree produced by {@link ShowProposalRealDataParser#body}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBody(ShowProposalRealDataParser.BodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link ShowProposalRealDataParser#line_1}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLine_1(ShowProposalRealDataParser.Line_1Context ctx);
	/**
	 * Visit a parse tree produced by {@link ShowProposalRealDataParser#normal_line1}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNormal_line1(ShowProposalRealDataParser.Normal_line1Context ctx);
	/**
	 * Visit a parse tree produced by {@link ShowProposalRealDataParser#vip_line1}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVip_line1(ShowProposalRealDataParser.Vip_line1Context ctx);
	/**
	 * Visit a parse tree produced by {@link ShowProposalRealDataParser#line_2}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLine_2(ShowProposalRealDataParser.Line_2Context ctx);
	/**
	 * Visit a parse tree produced by {@link ShowProposalRealDataParser#line_3}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLine_3(ShowProposalRealDataParser.Line_3Context ctx);
	/**
	 * Visit a parse tree produced by {@link ShowProposalRealDataParser#closing}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClosing(ShowProposalRealDataParser.ClosingContext ctx);
	/**
	 * Visit a parse tree produced by {@link ShowProposalRealDataParser#signature}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSignature(ShowProposalRealDataParser.SignatureContext ctx);
	/**
	 * Visit a parse tree produced by {@link ShowProposalRealDataParser#signature_option}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSignature_option(ShowProposalRealDataParser.Signature_optionContext ctx);
	/**
	 * Visit a parse tree produced by {@link ShowProposalRealDataParser#preferencePhrase}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPreferencePhrase(ShowProposalRealDataParser.PreferencePhraseContext ctx);
	/**
	 * Visit a parse tree produced by {@link ShowProposalRealDataParser#subscribePhrase}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSubscribePhrase(ShowProposalRealDataParser.SubscribePhraseContext ctx);
	/**
	 * Visit a parse tree produced by {@link ShowProposalRealDataParser#lastPhrase}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLastPhrase(ShowProposalRealDataParser.LastPhraseContext ctx);
	/**
	 * Visit a parse tree produced by {@link ShowProposalRealDataParser#regards}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRegards(ShowProposalRealDataParser.RegardsContext ctx);
	/**
	 * Visit a parse tree produced by {@link ShowProposalRealDataParser#showDetails}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitShowDetails(ShowProposalRealDataParser.ShowDetailsContext ctx);
	/**
	 * Visit a parse tree produced by {@link ShowProposalRealDataParser#attachment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAttachment(ShowProposalRealDataParser.AttachmentContext ctx);
	/**
	 * Visit a parse tree produced by {@link ShowProposalRealDataParser#location}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLocation(ShowProposalRealDataParser.LocationContext ctx);
	/**
	 * Visit a parse tree produced by {@link ShowProposalRealDataParser#date}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDate(ShowProposalRealDataParser.DateContext ctx);
	/**
	 * Visit a parse tree produced by {@link ShowProposalRealDataParser#time}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTime(ShowProposalRealDataParser.TimeContext ctx);
	/**
	 * Visit a parse tree produced by {@link ShowProposalRealDataParser#duration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDuration(ShowProposalRealDataParser.DurationContext ctx);
	/**
	 * Visit a parse tree produced by {@link ShowProposalRealDataParser#droneList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDroneList(ShowProposalRealDataParser.DroneListContext ctx);
	/**
	 * Visit a parse tree produced by {@link ShowProposalRealDataParser#droneListReal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDroneListReal(ShowProposalRealDataParser.DroneListRealContext ctx);
	/**
	 * Visit a parse tree produced by {@link ShowProposalRealDataParser#figureList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFigureList(ShowProposalRealDataParser.FigureListContext ctx);
	/**
	 * Visit a parse tree produced by {@link ShowProposalRealDataParser#figureListReal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFigureListReal(ShowProposalRealDataParser.FigureListRealContext ctx);
	/**
	 * Visit a parse tree produced by {@link ShowProposalRealDataParser#descriptionName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDescriptionName(ShowProposalRealDataParser.DescriptionNameContext ctx);
}