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
	 * Visit a parse tree produced by {@link ShowProposalParser#realPersonName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRealPersonName(ShowProposalParser.RealPersonNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link ShowProposalParser#personNamePlaceholder}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPersonNamePlaceholder(ShowProposalParser.PersonNamePlaceholderContext ctx);
	/**
	 * Visit a parse tree produced by {@link ShowProposalParser#company}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompany(ShowProposalParser.CompanyContext ctx);
	/**
	 * Visit a parse tree produced by {@link ShowProposalParser#realCompanyName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRealCompanyName(ShowProposalParser.RealCompanyNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link ShowProposalParser#companyPlaceHolder}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompanyPlaceHolder(ShowProposalParser.CompanyPlaceHolderContext ctx);
	/**
	 * Visit a parse tree produced by {@link ShowProposalParser#address}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAddress(ShowProposalParser.AddressContext ctx);
	/**
	 * Visit a parse tree produced by {@link ShowProposalParser#realAddress}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRealAddress(ShowProposalParser.RealAddressContext ctx);
	/**
	 * Visit a parse tree produced by {@link ShowProposalParser#addressPlaceHolder}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAddressPlaceHolder(ShowProposalParser.AddressPlaceHolderContext ctx);
	/**
	 * Visit a parse tree produced by {@link ShowProposalParser#vatNumber}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVatNumber(ShowProposalParser.VatNumberContext ctx);
	/**
	 * Visit a parse tree produced by {@link ShowProposalParser#realVatNumber}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRealVatNumber(ShowProposalParser.RealVatNumberContext ctx);
	/**
	 * Visit a parse tree produced by {@link ShowProposalParser#vatNumberPlaceHolder}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVatNumberPlaceHolder(ShowProposalParser.VatNumberPlaceHolderContext ctx);
	/**
	 * Visit a parse tree produced by {@link ShowProposalParser#reference}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReference(ShowProposalParser.ReferenceContext ctx);
	/**
	 * Visit a parse tree produced by {@link ShowProposalParser#realReference}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRealReference(ShowProposalParser.RealReferenceContext ctx);
	/**
	 * Visit a parse tree produced by {@link ShowProposalParser#referencePlaceHolder}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReferencePlaceHolder(ShowProposalParser.ReferencePlaceHolderContext ctx);
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
	 * Visit a parse tree produced by {@link ShowProposalParser#normal_line1}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNormal_line1(ShowProposalParser.Normal_line1Context ctx);
	/**
	 * Visit a parse tree produced by {@link ShowProposalParser#vip_line1}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVip_line1(ShowProposalParser.Vip_line1Context ctx);
	/**
	 * Visit a parse tree produced by {@link ShowProposalParser#real_vip_line1}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReal_vip_line1(ShowProposalParser.Real_vip_line1Context ctx);
	/**
	 * Visit a parse tree produced by {@link ShowProposalParser#vip_line1_Placeholder}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVip_line1_Placeholder(ShowProposalParser.Vip_line1_PlaceholderContext ctx);
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
	 * Visit a parse tree produced by {@link ShowProposalParser#real_line3}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReal_line3(ShowProposalParser.Real_line3Context ctx);
	/**
	 * Visit a parse tree produced by {@link ShowProposalParser#line3_placeholder}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLine3_placeholder(ShowProposalParser.Line3_placeholderContext ctx);
	/**
	 * Visit a parse tree produced by {@link ShowProposalParser#closing}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClosing(ShowProposalParser.ClosingContext ctx);
	/**
	 * Visit a parse tree produced by {@link ShowProposalParser#real_closing}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReal_closing(ShowProposalParser.Real_closingContext ctx);
	/**
	 * Visit a parse tree produced by {@link ShowProposalParser#closing_placeholder}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClosing_placeholder(ShowProposalParser.Closing_placeholderContext ctx);
	/**
	 * Visit a parse tree produced by {@link ShowProposalParser#signature}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSignature(ShowProposalParser.SignatureContext ctx);
	/**
	 * Visit a parse tree produced by {@link ShowProposalParser#crmManagerName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCrmManagerName(ShowProposalParser.CrmManagerNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link ShowProposalParser#realManagerName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRealManagerName(ShowProposalParser.RealManagerNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link ShowProposalParser#managerName_Placeholder}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitManagerName_Placeholder(ShowProposalParser.ManagerName_PlaceholderContext ctx);
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
	 * Visit a parse tree produced by {@link ShowProposalParser#attachment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAttachment(ShowProposalParser.AttachmentContext ctx);
	/**
	 * Visit a parse tree produced by {@link ShowProposalParser#real_attachment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReal_attachment(ShowProposalParser.Real_attachmentContext ctx);
	/**
	 * Visit a parse tree produced by {@link ShowProposalParser#attachment_placeholder}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAttachment_placeholder(ShowProposalParser.Attachment_placeholderContext ctx);
	/**
	 * Visit a parse tree produced by {@link ShowProposalParser#location}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLocation(ShowProposalParser.LocationContext ctx);
	/**
	 * Visit a parse tree produced by {@link ShowProposalParser#location_real}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLocation_real(ShowProposalParser.Location_realContext ctx);
	/**
	 * Visit a parse tree produced by {@link ShowProposalParser#location_placeholder}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLocation_placeholder(ShowProposalParser.Location_placeholderContext ctx);
	/**
	 * Visit a parse tree produced by {@link ShowProposalParser#date}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDate(ShowProposalParser.DateContext ctx);
	/**
	 * Visit a parse tree produced by {@link ShowProposalParser#date_real}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDate_real(ShowProposalParser.Date_realContext ctx);
	/**
	 * Visit a parse tree produced by {@link ShowProposalParser#date_placeholder}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDate_placeholder(ShowProposalParser.Date_placeholderContext ctx);
	/**
	 * Visit a parse tree produced by {@link ShowProposalParser#time}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTime(ShowProposalParser.TimeContext ctx);
	/**
	 * Visit a parse tree produced by {@link ShowProposalParser#time_real}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTime_real(ShowProposalParser.Time_realContext ctx);
	/**
	 * Visit a parse tree produced by {@link ShowProposalParser#time_placeholder}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTime_placeholder(ShowProposalParser.Time_placeholderContext ctx);
	/**
	 * Visit a parse tree produced by {@link ShowProposalParser#duration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDuration(ShowProposalParser.DurationContext ctx);
	/**
	 * Visit a parse tree produced by {@link ShowProposalParser#duration_real}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDuration_real(ShowProposalParser.Duration_realContext ctx);
	/**
	 * Visit a parse tree produced by {@link ShowProposalParser#duration_placeholder}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDuration_placeholder(ShowProposalParser.Duration_placeholderContext ctx);
	/**
	 * Visit a parse tree produced by {@link ShowProposalParser#droneList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDroneList(ShowProposalParser.DroneListContext ctx);
	/**
	 * Visit a parse tree produced by {@link ShowProposalParser#droneListReal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDroneListReal(ShowProposalParser.DroneListRealContext ctx);
	/**
	 * Visit a parse tree produced by {@link ShowProposalParser#droneListPlaceholders}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDroneListPlaceholders(ShowProposalParser.DroneListPlaceholdersContext ctx);
	/**
	 * Visit a parse tree produced by {@link ShowProposalParser#figureList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFigureList(ShowProposalParser.FigureListContext ctx);
	/**
	 * Visit a parse tree produced by {@link ShowProposalParser#figureListReal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFigureListReal(ShowProposalParser.FigureListRealContext ctx);
	/**
	 * Visit a parse tree produced by {@link ShowProposalParser#figureListPlaceholder}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFigureListPlaceholder(ShowProposalParser.FigureListPlaceholderContext ctx);
}