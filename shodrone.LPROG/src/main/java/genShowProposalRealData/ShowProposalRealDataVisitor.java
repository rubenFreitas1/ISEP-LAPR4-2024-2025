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
	 * Visit a parse tree produced by {@link ShowProposalRealDataParser#personName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPersonName(ShowProposalRealDataParser.PersonNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link ShowProposalRealDataParser#realPersonName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRealPersonName(ShowProposalRealDataParser.RealPersonNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link ShowProposalRealDataParser#company}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompany(ShowProposalRealDataParser.CompanyContext ctx);
	/**
	 * Visit a parse tree produced by {@link ShowProposalRealDataParser#realCompanyName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRealCompanyName(ShowProposalRealDataParser.RealCompanyNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link ShowProposalRealDataParser#address}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAddress(ShowProposalRealDataParser.AddressContext ctx);
	/**
	 * Visit a parse tree produced by {@link ShowProposalRealDataParser#realAddress}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRealAddress(ShowProposalRealDataParser.RealAddressContext ctx);
	/**
	 * Visit a parse tree produced by {@link ShowProposalRealDataParser#vatNumber}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVatNumber(ShowProposalRealDataParser.VatNumberContext ctx);
	/**
	 * Visit a parse tree produced by {@link ShowProposalRealDataParser#realVatNumber}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRealVatNumber(ShowProposalRealDataParser.RealVatNumberContext ctx);
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
	 * Visit a parse tree produced by {@link ShowProposalRealDataParser#real_vip_line1}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReal_vip_line1(ShowProposalRealDataParser.Real_vip_line1Context ctx);
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
	 * Visit a parse tree produced by {@link ShowProposalRealDataParser#real_line3}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReal_line3(ShowProposalRealDataParser.Real_line3Context ctx);
	/**
	 * Visit a parse tree produced by {@link ShowProposalRealDataParser#closing}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClosing(ShowProposalRealDataParser.ClosingContext ctx);
	/**
	 * Visit a parse tree produced by {@link ShowProposalRealDataParser#real_closing}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReal_closing(ShowProposalRealDataParser.Real_closingContext ctx);
	/**
	 * Visit a parse tree produced by {@link ShowProposalRealDataParser#signature}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSignature(ShowProposalRealDataParser.SignatureContext ctx);
	/**
	 * Visit a parse tree produced by {@link ShowProposalRealDataParser#crmManagerName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCrmManagerName(ShowProposalRealDataParser.CrmManagerNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link ShowProposalRealDataParser#realManagerName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRealManagerName(ShowProposalRealDataParser.RealManagerNameContext ctx);
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
	 * Visit a parse tree produced by {@link ShowProposalRealDataParser#real_attachment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReal_attachment(ShowProposalRealDataParser.Real_attachmentContext ctx);
	/**
	 * Visit a parse tree produced by {@link ShowProposalRealDataParser#location}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLocation(ShowProposalRealDataParser.LocationContext ctx);
	/**
	 * Visit a parse tree produced by {@link ShowProposalRealDataParser#location_real}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLocation_real(ShowProposalRealDataParser.Location_realContext ctx);
	/**
	 * Visit a parse tree produced by {@link ShowProposalRealDataParser#date}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDate(ShowProposalRealDataParser.DateContext ctx);
	/**
	 * Visit a parse tree produced by {@link ShowProposalRealDataParser#date_real}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDate_real(ShowProposalRealDataParser.Date_realContext ctx);
	/**
	 * Visit a parse tree produced by {@link ShowProposalRealDataParser#time}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTime(ShowProposalRealDataParser.TimeContext ctx);
	/**
	 * Visit a parse tree produced by {@link ShowProposalRealDataParser#time_real}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTime_real(ShowProposalRealDataParser.Time_realContext ctx);
	/**
	 * Visit a parse tree produced by {@link ShowProposalRealDataParser#duration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDuration(ShowProposalRealDataParser.DurationContext ctx);
	/**
	 * Visit a parse tree produced by {@link ShowProposalRealDataParser#duration_real}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDuration_real(ShowProposalRealDataParser.Duration_realContext ctx);
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
}