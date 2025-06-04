// Generated from C:/ISEP-PROJETOS/lapr4_projeto/shodrone.LPROG/src/main/java/antlr/ShowProposalPlaceholder.g4 by ANTLR 4.13.2
package genShowProposalPlaceholder;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link ShowProposalPlaceholderParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface ShowProposalPlaceholderVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link ShowProposalPlaceholderParser#proposal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProposal(ShowProposalPlaceholderParser.ProposalContext ctx);
	/**
	 * Visit a parse tree produced by {@link ShowProposalPlaceholderParser#header}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitHeader(ShowProposalPlaceholderParser.HeaderContext ctx);
	/**
	 * Visit a parse tree produced by {@link ShowProposalPlaceholderParser#greeting}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGreeting(ShowProposalPlaceholderParser.GreetingContext ctx);
	/**
	 * Visit a parse tree produced by {@link ShowProposalPlaceholderParser#companyInfo}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompanyInfo(ShowProposalPlaceholderParser.CompanyInfoContext ctx);
	/**
	 * Visit a parse tree produced by {@link ShowProposalPlaceholderParser#personName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPersonName(ShowProposalPlaceholderParser.PersonNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link ShowProposalPlaceholderParser#personNamePlaceholder}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPersonNamePlaceholder(ShowProposalPlaceholderParser.PersonNamePlaceholderContext ctx);
	/**
	 * Visit a parse tree produced by {@link ShowProposalPlaceholderParser#company}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompany(ShowProposalPlaceholderParser.CompanyContext ctx);
	/**
	 * Visit a parse tree produced by {@link ShowProposalPlaceholderParser#companyPlaceHolder}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompanyPlaceHolder(ShowProposalPlaceholderParser.CompanyPlaceHolderContext ctx);
	/**
	 * Visit a parse tree produced by {@link ShowProposalPlaceholderParser#address}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAddress(ShowProposalPlaceholderParser.AddressContext ctx);
	/**
	 * Visit a parse tree produced by {@link ShowProposalPlaceholderParser#addressPlaceHolder}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAddressPlaceHolder(ShowProposalPlaceholderParser.AddressPlaceHolderContext ctx);
	/**
	 * Visit a parse tree produced by {@link ShowProposalPlaceholderParser#vatNumber}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVatNumber(ShowProposalPlaceholderParser.VatNumberContext ctx);
	/**
	 * Visit a parse tree produced by {@link ShowProposalPlaceholderParser#vatNumberPlaceHolder}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVatNumberPlaceHolder(ShowProposalPlaceholderParser.VatNumberPlaceHolderContext ctx);
	/**
	 * Visit a parse tree produced by {@link ShowProposalPlaceholderParser#reference}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReference(ShowProposalPlaceholderParser.ReferenceContext ctx);
	/**
	 * Visit a parse tree produced by {@link ShowProposalPlaceholderParser#referencePlaceHolder}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReferencePlaceHolder(ShowProposalPlaceholderParser.ReferencePlaceHolderContext ctx);
	/**
	 * Visit a parse tree produced by {@link ShowProposalPlaceholderParser#titleProposal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTitleProposal(ShowProposalPlaceholderParser.TitleProposalContext ctx);
	/**
	 * Visit a parse tree produced by {@link ShowProposalPlaceholderParser#body}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBody(ShowProposalPlaceholderParser.BodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link ShowProposalPlaceholderParser#line_1}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLine_1(ShowProposalPlaceholderParser.Line_1Context ctx);
	/**
	 * Visit a parse tree produced by {@link ShowProposalPlaceholderParser#normal_line1}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNormal_line1(ShowProposalPlaceholderParser.Normal_line1Context ctx);
	/**
	 * Visit a parse tree produced by {@link ShowProposalPlaceholderParser#vip_line1}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVip_line1(ShowProposalPlaceholderParser.Vip_line1Context ctx);
	/**
	 * Visit a parse tree produced by {@link ShowProposalPlaceholderParser#vip_line1_Placeholder}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVip_line1_Placeholder(ShowProposalPlaceholderParser.Vip_line1_PlaceholderContext ctx);
	/**
	 * Visit a parse tree produced by {@link ShowProposalPlaceholderParser#line_2}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLine_2(ShowProposalPlaceholderParser.Line_2Context ctx);
	/**
	 * Visit a parse tree produced by {@link ShowProposalPlaceholderParser#line_3}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLine_3(ShowProposalPlaceholderParser.Line_3Context ctx);
	/**
	 * Visit a parse tree produced by {@link ShowProposalPlaceholderParser#line3_placeholder}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLine3_placeholder(ShowProposalPlaceholderParser.Line3_placeholderContext ctx);
	/**
	 * Visit a parse tree produced by {@link ShowProposalPlaceholderParser#closing}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClosing(ShowProposalPlaceholderParser.ClosingContext ctx);
	/**
	 * Visit a parse tree produced by {@link ShowProposalPlaceholderParser#closing_placeholder}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClosing_placeholder(ShowProposalPlaceholderParser.Closing_placeholderContext ctx);
	/**
	 * Visit a parse tree produced by {@link ShowProposalPlaceholderParser#signature}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSignature(ShowProposalPlaceholderParser.SignatureContext ctx);
	/**
	 * Visit a parse tree produced by {@link ShowProposalPlaceholderParser#crmManagerName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCrmManagerName(ShowProposalPlaceholderParser.CrmManagerNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link ShowProposalPlaceholderParser#managerName_Placeholder}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitManagerName_Placeholder(ShowProposalPlaceholderParser.ManagerName_PlaceholderContext ctx);
	/**
	 * Visit a parse tree produced by {@link ShowProposalPlaceholderParser#signature_option}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSignature_option(ShowProposalPlaceholderParser.Signature_optionContext ctx);
	/**
	 * Visit a parse tree produced by {@link ShowProposalPlaceholderParser#preferencePhrase}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPreferencePhrase(ShowProposalPlaceholderParser.PreferencePhraseContext ctx);
	/**
	 * Visit a parse tree produced by {@link ShowProposalPlaceholderParser#subscribePhrase}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSubscribePhrase(ShowProposalPlaceholderParser.SubscribePhraseContext ctx);
	/**
	 * Visit a parse tree produced by {@link ShowProposalPlaceholderParser#lastPhrase}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLastPhrase(ShowProposalPlaceholderParser.LastPhraseContext ctx);
	/**
	 * Visit a parse tree produced by {@link ShowProposalPlaceholderParser#regards}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRegards(ShowProposalPlaceholderParser.RegardsContext ctx);
	/**
	 * Visit a parse tree produced by {@link ShowProposalPlaceholderParser#showDetails}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitShowDetails(ShowProposalPlaceholderParser.ShowDetailsContext ctx);
	/**
	 * Visit a parse tree produced by {@link ShowProposalPlaceholderParser#attachment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAttachment(ShowProposalPlaceholderParser.AttachmentContext ctx);
	/**
	 * Visit a parse tree produced by {@link ShowProposalPlaceholderParser#attachment_placeholder}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAttachment_placeholder(ShowProposalPlaceholderParser.Attachment_placeholderContext ctx);
	/**
	 * Visit a parse tree produced by {@link ShowProposalPlaceholderParser#location}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLocation(ShowProposalPlaceholderParser.LocationContext ctx);
	/**
	 * Visit a parse tree produced by {@link ShowProposalPlaceholderParser#location_placeholder}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLocation_placeholder(ShowProposalPlaceholderParser.Location_placeholderContext ctx);
	/**
	 * Visit a parse tree produced by {@link ShowProposalPlaceholderParser#date}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDate(ShowProposalPlaceholderParser.DateContext ctx);
	/**
	 * Visit a parse tree produced by {@link ShowProposalPlaceholderParser#date_placeholder}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDate_placeholder(ShowProposalPlaceholderParser.Date_placeholderContext ctx);
	/**
	 * Visit a parse tree produced by {@link ShowProposalPlaceholderParser#time}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTime(ShowProposalPlaceholderParser.TimeContext ctx);
	/**
	 * Visit a parse tree produced by {@link ShowProposalPlaceholderParser#time_placeholder}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTime_placeholder(ShowProposalPlaceholderParser.Time_placeholderContext ctx);
	/**
	 * Visit a parse tree produced by {@link ShowProposalPlaceholderParser#duration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDuration(ShowProposalPlaceholderParser.DurationContext ctx);
	/**
	 * Visit a parse tree produced by {@link ShowProposalPlaceholderParser#duration_placeholder}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDuration_placeholder(ShowProposalPlaceholderParser.Duration_placeholderContext ctx);
	/**
	 * Visit a parse tree produced by {@link ShowProposalPlaceholderParser#droneList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDroneList(ShowProposalPlaceholderParser.DroneListContext ctx);
	/**
	 * Visit a parse tree produced by {@link ShowProposalPlaceholderParser#droneListPlaceholders}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDroneListPlaceholders(ShowProposalPlaceholderParser.DroneListPlaceholdersContext ctx);
	/**
	 * Visit a parse tree produced by {@link ShowProposalPlaceholderParser#figureList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFigureList(ShowProposalPlaceholderParser.FigureListContext ctx);
	/**
	 * Visit a parse tree produced by {@link ShowProposalPlaceholderParser#figureListPlaceholder}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFigureListPlaceholder(ShowProposalPlaceholderParser.FigureListPlaceholderContext ctx);
}