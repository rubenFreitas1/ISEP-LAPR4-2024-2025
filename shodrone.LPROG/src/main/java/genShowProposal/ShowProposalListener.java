// Generated from C:/ISEP-PROJETOS/lapr4_projeto/shodrone.LPROG/src/main/java/antlr/ShowProposal.g4 by ANTLR 4.13.2
package genShowProposal;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link ShowProposalParser}.
 */
public interface ShowProposalListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link ShowProposalParser#proposal}.
	 * @param ctx the parse tree
	 */
	void enterProposal(ShowProposalParser.ProposalContext ctx);
	/**
	 * Exit a parse tree produced by {@link ShowProposalParser#proposal}.
	 * @param ctx the parse tree
	 */
	void exitProposal(ShowProposalParser.ProposalContext ctx);
	/**
	 * Enter a parse tree produced by {@link ShowProposalParser#header}.
	 * @param ctx the parse tree
	 */
	void enterHeader(ShowProposalParser.HeaderContext ctx);
	/**
	 * Exit a parse tree produced by {@link ShowProposalParser#header}.
	 * @param ctx the parse tree
	 */
	void exitHeader(ShowProposalParser.HeaderContext ctx);
	/**
	 * Enter a parse tree produced by {@link ShowProposalParser#greeting}.
	 * @param ctx the parse tree
	 */
	void enterGreeting(ShowProposalParser.GreetingContext ctx);
	/**
	 * Exit a parse tree produced by {@link ShowProposalParser#greeting}.
	 * @param ctx the parse tree
	 */
	void exitGreeting(ShowProposalParser.GreetingContext ctx);
	/**
	 * Enter a parse tree produced by {@link ShowProposalParser#companyInfo}.
	 * @param ctx the parse tree
	 */
	void enterCompanyInfo(ShowProposalParser.CompanyInfoContext ctx);
	/**
	 * Exit a parse tree produced by {@link ShowProposalParser#companyInfo}.
	 * @param ctx the parse tree
	 */
	void exitCompanyInfo(ShowProposalParser.CompanyInfoContext ctx);
	/**
	 * Enter a parse tree produced by {@link ShowProposalParser#personName}.
	 * @param ctx the parse tree
	 */
	void enterPersonName(ShowProposalParser.PersonNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link ShowProposalParser#personName}.
	 * @param ctx the parse tree
	 */
	void exitPersonName(ShowProposalParser.PersonNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link ShowProposalParser#realPersonName}.
	 * @param ctx the parse tree
	 */
	void enterRealPersonName(ShowProposalParser.RealPersonNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link ShowProposalParser#realPersonName}.
	 * @param ctx the parse tree
	 */
	void exitRealPersonName(ShowProposalParser.RealPersonNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link ShowProposalParser#personNamePlaceholder}.
	 * @param ctx the parse tree
	 */
	void enterPersonNamePlaceholder(ShowProposalParser.PersonNamePlaceholderContext ctx);
	/**
	 * Exit a parse tree produced by {@link ShowProposalParser#personNamePlaceholder}.
	 * @param ctx the parse tree
	 */
	void exitPersonNamePlaceholder(ShowProposalParser.PersonNamePlaceholderContext ctx);
	/**
	 * Enter a parse tree produced by {@link ShowProposalParser#company}.
	 * @param ctx the parse tree
	 */
	void enterCompany(ShowProposalParser.CompanyContext ctx);
	/**
	 * Exit a parse tree produced by {@link ShowProposalParser#company}.
	 * @param ctx the parse tree
	 */
	void exitCompany(ShowProposalParser.CompanyContext ctx);
	/**
	 * Enter a parse tree produced by {@link ShowProposalParser#realCompanyName}.
	 * @param ctx the parse tree
	 */
	void enterRealCompanyName(ShowProposalParser.RealCompanyNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link ShowProposalParser#realCompanyName}.
	 * @param ctx the parse tree
	 */
	void exitRealCompanyName(ShowProposalParser.RealCompanyNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link ShowProposalParser#companyPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void enterCompanyPlaceHolder(ShowProposalParser.CompanyPlaceHolderContext ctx);
	/**
	 * Exit a parse tree produced by {@link ShowProposalParser#companyPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void exitCompanyPlaceHolder(ShowProposalParser.CompanyPlaceHolderContext ctx);
	/**
	 * Enter a parse tree produced by {@link ShowProposalParser#address}.
	 * @param ctx the parse tree
	 */
	void enterAddress(ShowProposalParser.AddressContext ctx);
	/**
	 * Exit a parse tree produced by {@link ShowProposalParser#address}.
	 * @param ctx the parse tree
	 */
	void exitAddress(ShowProposalParser.AddressContext ctx);
	/**
	 * Enter a parse tree produced by {@link ShowProposalParser#realAddress}.
	 * @param ctx the parse tree
	 */
	void enterRealAddress(ShowProposalParser.RealAddressContext ctx);
	/**
	 * Exit a parse tree produced by {@link ShowProposalParser#realAddress}.
	 * @param ctx the parse tree
	 */
	void exitRealAddress(ShowProposalParser.RealAddressContext ctx);
	/**
	 * Enter a parse tree produced by {@link ShowProposalParser#addressPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void enterAddressPlaceHolder(ShowProposalParser.AddressPlaceHolderContext ctx);
	/**
	 * Exit a parse tree produced by {@link ShowProposalParser#addressPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void exitAddressPlaceHolder(ShowProposalParser.AddressPlaceHolderContext ctx);
	/**
	 * Enter a parse tree produced by {@link ShowProposalParser#vatNumber}.
	 * @param ctx the parse tree
	 */
	void enterVatNumber(ShowProposalParser.VatNumberContext ctx);
	/**
	 * Exit a parse tree produced by {@link ShowProposalParser#vatNumber}.
	 * @param ctx the parse tree
	 */
	void exitVatNumber(ShowProposalParser.VatNumberContext ctx);
	/**
	 * Enter a parse tree produced by {@link ShowProposalParser#realVatNumber}.
	 * @param ctx the parse tree
	 */
	void enterRealVatNumber(ShowProposalParser.RealVatNumberContext ctx);
	/**
	 * Exit a parse tree produced by {@link ShowProposalParser#realVatNumber}.
	 * @param ctx the parse tree
	 */
	void exitRealVatNumber(ShowProposalParser.RealVatNumberContext ctx);
	/**
	 * Enter a parse tree produced by {@link ShowProposalParser#vatNumberPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void enterVatNumberPlaceHolder(ShowProposalParser.VatNumberPlaceHolderContext ctx);
	/**
	 * Exit a parse tree produced by {@link ShowProposalParser#vatNumberPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void exitVatNumberPlaceHolder(ShowProposalParser.VatNumberPlaceHolderContext ctx);
	/**
	 * Enter a parse tree produced by {@link ShowProposalParser#reference}.
	 * @param ctx the parse tree
	 */
	void enterReference(ShowProposalParser.ReferenceContext ctx);
	/**
	 * Exit a parse tree produced by {@link ShowProposalParser#reference}.
	 * @param ctx the parse tree
	 */
	void exitReference(ShowProposalParser.ReferenceContext ctx);
	/**
	 * Enter a parse tree produced by {@link ShowProposalParser#realReference}.
	 * @param ctx the parse tree
	 */
	void enterRealReference(ShowProposalParser.RealReferenceContext ctx);
	/**
	 * Exit a parse tree produced by {@link ShowProposalParser#realReference}.
	 * @param ctx the parse tree
	 */
	void exitRealReference(ShowProposalParser.RealReferenceContext ctx);
	/**
	 * Enter a parse tree produced by {@link ShowProposalParser#referencePlaceHolder}.
	 * @param ctx the parse tree
	 */
	void enterReferencePlaceHolder(ShowProposalParser.ReferencePlaceHolderContext ctx);
	/**
	 * Exit a parse tree produced by {@link ShowProposalParser#referencePlaceHolder}.
	 * @param ctx the parse tree
	 */
	void exitReferencePlaceHolder(ShowProposalParser.ReferencePlaceHolderContext ctx);
	/**
	 * Enter a parse tree produced by {@link ShowProposalParser#titleProposal}.
	 * @param ctx the parse tree
	 */
	void enterTitleProposal(ShowProposalParser.TitleProposalContext ctx);
	/**
	 * Exit a parse tree produced by {@link ShowProposalParser#titleProposal}.
	 * @param ctx the parse tree
	 */
	void exitTitleProposal(ShowProposalParser.TitleProposalContext ctx);
	/**
	 * Enter a parse tree produced by {@link ShowProposalParser#body}.
	 * @param ctx the parse tree
	 */
	void enterBody(ShowProposalParser.BodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link ShowProposalParser#body}.
	 * @param ctx the parse tree
	 */
	void exitBody(ShowProposalParser.BodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link ShowProposalParser#line_1}.
	 * @param ctx the parse tree
	 */
	void enterLine_1(ShowProposalParser.Line_1Context ctx);
	/**
	 * Exit a parse tree produced by {@link ShowProposalParser#line_1}.
	 * @param ctx the parse tree
	 */
	void exitLine_1(ShowProposalParser.Line_1Context ctx);
	/**
	 * Enter a parse tree produced by {@link ShowProposalParser#normal_line1}.
	 * @param ctx the parse tree
	 */
	void enterNormal_line1(ShowProposalParser.Normal_line1Context ctx);
	/**
	 * Exit a parse tree produced by {@link ShowProposalParser#normal_line1}.
	 * @param ctx the parse tree
	 */
	void exitNormal_line1(ShowProposalParser.Normal_line1Context ctx);
	/**
	 * Enter a parse tree produced by {@link ShowProposalParser#vip_line1}.
	 * @param ctx the parse tree
	 */
	void enterVip_line1(ShowProposalParser.Vip_line1Context ctx);
	/**
	 * Exit a parse tree produced by {@link ShowProposalParser#vip_line1}.
	 * @param ctx the parse tree
	 */
	void exitVip_line1(ShowProposalParser.Vip_line1Context ctx);
	/**
	 * Enter a parse tree produced by {@link ShowProposalParser#real_vip_line1}.
	 * @param ctx the parse tree
	 */
	void enterReal_vip_line1(ShowProposalParser.Real_vip_line1Context ctx);
	/**
	 * Exit a parse tree produced by {@link ShowProposalParser#real_vip_line1}.
	 * @param ctx the parse tree
	 */
	void exitReal_vip_line1(ShowProposalParser.Real_vip_line1Context ctx);
	/**
	 * Enter a parse tree produced by {@link ShowProposalParser#vip_line1_Placeholder}.
	 * @param ctx the parse tree
	 */
	void enterVip_line1_Placeholder(ShowProposalParser.Vip_line1_PlaceholderContext ctx);
	/**
	 * Exit a parse tree produced by {@link ShowProposalParser#vip_line1_Placeholder}.
	 * @param ctx the parse tree
	 */
	void exitVip_line1_Placeholder(ShowProposalParser.Vip_line1_PlaceholderContext ctx);
	/**
	 * Enter a parse tree produced by {@link ShowProposalParser#line_2}.
	 * @param ctx the parse tree
	 */
	void enterLine_2(ShowProposalParser.Line_2Context ctx);
	/**
	 * Exit a parse tree produced by {@link ShowProposalParser#line_2}.
	 * @param ctx the parse tree
	 */
	void exitLine_2(ShowProposalParser.Line_2Context ctx);
	/**
	 * Enter a parse tree produced by {@link ShowProposalParser#line_3}.
	 * @param ctx the parse tree
	 */
	void enterLine_3(ShowProposalParser.Line_3Context ctx);
	/**
	 * Exit a parse tree produced by {@link ShowProposalParser#line_3}.
	 * @param ctx the parse tree
	 */
	void exitLine_3(ShowProposalParser.Line_3Context ctx);
	/**
	 * Enter a parse tree produced by {@link ShowProposalParser#real_line3}.
	 * @param ctx the parse tree
	 */
	void enterReal_line3(ShowProposalParser.Real_line3Context ctx);
	/**
	 * Exit a parse tree produced by {@link ShowProposalParser#real_line3}.
	 * @param ctx the parse tree
	 */
	void exitReal_line3(ShowProposalParser.Real_line3Context ctx);
	/**
	 * Enter a parse tree produced by {@link ShowProposalParser#line3_placeholder}.
	 * @param ctx the parse tree
	 */
	void enterLine3_placeholder(ShowProposalParser.Line3_placeholderContext ctx);
	/**
	 * Exit a parse tree produced by {@link ShowProposalParser#line3_placeholder}.
	 * @param ctx the parse tree
	 */
	void exitLine3_placeholder(ShowProposalParser.Line3_placeholderContext ctx);
	/**
	 * Enter a parse tree produced by {@link ShowProposalParser#closing}.
	 * @param ctx the parse tree
	 */
	void enterClosing(ShowProposalParser.ClosingContext ctx);
	/**
	 * Exit a parse tree produced by {@link ShowProposalParser#closing}.
	 * @param ctx the parse tree
	 */
	void exitClosing(ShowProposalParser.ClosingContext ctx);
	/**
	 * Enter a parse tree produced by {@link ShowProposalParser#real_closing}.
	 * @param ctx the parse tree
	 */
	void enterReal_closing(ShowProposalParser.Real_closingContext ctx);
	/**
	 * Exit a parse tree produced by {@link ShowProposalParser#real_closing}.
	 * @param ctx the parse tree
	 */
	void exitReal_closing(ShowProposalParser.Real_closingContext ctx);
	/**
	 * Enter a parse tree produced by {@link ShowProposalParser#closing_placeholder}.
	 * @param ctx the parse tree
	 */
	void enterClosing_placeholder(ShowProposalParser.Closing_placeholderContext ctx);
	/**
	 * Exit a parse tree produced by {@link ShowProposalParser#closing_placeholder}.
	 * @param ctx the parse tree
	 */
	void exitClosing_placeholder(ShowProposalParser.Closing_placeholderContext ctx);
	/**
	 * Enter a parse tree produced by {@link ShowProposalParser#signature}.
	 * @param ctx the parse tree
	 */
	void enterSignature(ShowProposalParser.SignatureContext ctx);
	/**
	 * Exit a parse tree produced by {@link ShowProposalParser#signature}.
	 * @param ctx the parse tree
	 */
	void exitSignature(ShowProposalParser.SignatureContext ctx);
	/**
	 * Enter a parse tree produced by {@link ShowProposalParser#crmManagerName}.
	 * @param ctx the parse tree
	 */
	void enterCrmManagerName(ShowProposalParser.CrmManagerNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link ShowProposalParser#crmManagerName}.
	 * @param ctx the parse tree
	 */
	void exitCrmManagerName(ShowProposalParser.CrmManagerNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link ShowProposalParser#realManagerName}.
	 * @param ctx the parse tree
	 */
	void enterRealManagerName(ShowProposalParser.RealManagerNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link ShowProposalParser#realManagerName}.
	 * @param ctx the parse tree
	 */
	void exitRealManagerName(ShowProposalParser.RealManagerNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link ShowProposalParser#managerName_Placeholder}.
	 * @param ctx the parse tree
	 */
	void enterManagerName_Placeholder(ShowProposalParser.ManagerName_PlaceholderContext ctx);
	/**
	 * Exit a parse tree produced by {@link ShowProposalParser#managerName_Placeholder}.
	 * @param ctx the parse tree
	 */
	void exitManagerName_Placeholder(ShowProposalParser.ManagerName_PlaceholderContext ctx);
	/**
	 * Enter a parse tree produced by {@link ShowProposalParser#signature_option}.
	 * @param ctx the parse tree
	 */
	void enterSignature_option(ShowProposalParser.Signature_optionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ShowProposalParser#signature_option}.
	 * @param ctx the parse tree
	 */
	void exitSignature_option(ShowProposalParser.Signature_optionContext ctx);
	/**
	 * Enter a parse tree produced by {@link ShowProposalParser#preferencePhrase}.
	 * @param ctx the parse tree
	 */
	void enterPreferencePhrase(ShowProposalParser.PreferencePhraseContext ctx);
	/**
	 * Exit a parse tree produced by {@link ShowProposalParser#preferencePhrase}.
	 * @param ctx the parse tree
	 */
	void exitPreferencePhrase(ShowProposalParser.PreferencePhraseContext ctx);
	/**
	 * Enter a parse tree produced by {@link ShowProposalParser#subscribePhrase}.
	 * @param ctx the parse tree
	 */
	void enterSubscribePhrase(ShowProposalParser.SubscribePhraseContext ctx);
	/**
	 * Exit a parse tree produced by {@link ShowProposalParser#subscribePhrase}.
	 * @param ctx the parse tree
	 */
	void exitSubscribePhrase(ShowProposalParser.SubscribePhraseContext ctx);
	/**
	 * Enter a parse tree produced by {@link ShowProposalParser#lastPhrase}.
	 * @param ctx the parse tree
	 */
	void enterLastPhrase(ShowProposalParser.LastPhraseContext ctx);
	/**
	 * Exit a parse tree produced by {@link ShowProposalParser#lastPhrase}.
	 * @param ctx the parse tree
	 */
	void exitLastPhrase(ShowProposalParser.LastPhraseContext ctx);
	/**
	 * Enter a parse tree produced by {@link ShowProposalParser#regards}.
	 * @param ctx the parse tree
	 */
	void enterRegards(ShowProposalParser.RegardsContext ctx);
	/**
	 * Exit a parse tree produced by {@link ShowProposalParser#regards}.
	 * @param ctx the parse tree
	 */
	void exitRegards(ShowProposalParser.RegardsContext ctx);
	/**
	 * Enter a parse tree produced by {@link ShowProposalParser#showDetails}.
	 * @param ctx the parse tree
	 */
	void enterShowDetails(ShowProposalParser.ShowDetailsContext ctx);
	/**
	 * Exit a parse tree produced by {@link ShowProposalParser#showDetails}.
	 * @param ctx the parse tree
	 */
	void exitShowDetails(ShowProposalParser.ShowDetailsContext ctx);
	/**
	 * Enter a parse tree produced by {@link ShowProposalParser#attachment}.
	 * @param ctx the parse tree
	 */
	void enterAttachment(ShowProposalParser.AttachmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link ShowProposalParser#attachment}.
	 * @param ctx the parse tree
	 */
	void exitAttachment(ShowProposalParser.AttachmentContext ctx);
	/**
	 * Enter a parse tree produced by {@link ShowProposalParser#real_attachment}.
	 * @param ctx the parse tree
	 */
	void enterReal_attachment(ShowProposalParser.Real_attachmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link ShowProposalParser#real_attachment}.
	 * @param ctx the parse tree
	 */
	void exitReal_attachment(ShowProposalParser.Real_attachmentContext ctx);
	/**
	 * Enter a parse tree produced by {@link ShowProposalParser#attachment_placeholder}.
	 * @param ctx the parse tree
	 */
	void enterAttachment_placeholder(ShowProposalParser.Attachment_placeholderContext ctx);
	/**
	 * Exit a parse tree produced by {@link ShowProposalParser#attachment_placeholder}.
	 * @param ctx the parse tree
	 */
	void exitAttachment_placeholder(ShowProposalParser.Attachment_placeholderContext ctx);
	/**
	 * Enter a parse tree produced by {@link ShowProposalParser#location}.
	 * @param ctx the parse tree
	 */
	void enterLocation(ShowProposalParser.LocationContext ctx);
	/**
	 * Exit a parse tree produced by {@link ShowProposalParser#location}.
	 * @param ctx the parse tree
	 */
	void exitLocation(ShowProposalParser.LocationContext ctx);
	/**
	 * Enter a parse tree produced by {@link ShowProposalParser#location_real}.
	 * @param ctx the parse tree
	 */
	void enterLocation_real(ShowProposalParser.Location_realContext ctx);
	/**
	 * Exit a parse tree produced by {@link ShowProposalParser#location_real}.
	 * @param ctx the parse tree
	 */
	void exitLocation_real(ShowProposalParser.Location_realContext ctx);
	/**
	 * Enter a parse tree produced by {@link ShowProposalParser#location_placeholder}.
	 * @param ctx the parse tree
	 */
	void enterLocation_placeholder(ShowProposalParser.Location_placeholderContext ctx);
	/**
	 * Exit a parse tree produced by {@link ShowProposalParser#location_placeholder}.
	 * @param ctx the parse tree
	 */
	void exitLocation_placeholder(ShowProposalParser.Location_placeholderContext ctx);
	/**
	 * Enter a parse tree produced by {@link ShowProposalParser#date}.
	 * @param ctx the parse tree
	 */
	void enterDate(ShowProposalParser.DateContext ctx);
	/**
	 * Exit a parse tree produced by {@link ShowProposalParser#date}.
	 * @param ctx the parse tree
	 */
	void exitDate(ShowProposalParser.DateContext ctx);
	/**
	 * Enter a parse tree produced by {@link ShowProposalParser#date_real}.
	 * @param ctx the parse tree
	 */
	void enterDate_real(ShowProposalParser.Date_realContext ctx);
	/**
	 * Exit a parse tree produced by {@link ShowProposalParser#date_real}.
	 * @param ctx the parse tree
	 */
	void exitDate_real(ShowProposalParser.Date_realContext ctx);
	/**
	 * Enter a parse tree produced by {@link ShowProposalParser#date_placeholder}.
	 * @param ctx the parse tree
	 */
	void enterDate_placeholder(ShowProposalParser.Date_placeholderContext ctx);
	/**
	 * Exit a parse tree produced by {@link ShowProposalParser#date_placeholder}.
	 * @param ctx the parse tree
	 */
	void exitDate_placeholder(ShowProposalParser.Date_placeholderContext ctx);
	/**
	 * Enter a parse tree produced by {@link ShowProposalParser#time}.
	 * @param ctx the parse tree
	 */
	void enterTime(ShowProposalParser.TimeContext ctx);
	/**
	 * Exit a parse tree produced by {@link ShowProposalParser#time}.
	 * @param ctx the parse tree
	 */
	void exitTime(ShowProposalParser.TimeContext ctx);
	/**
	 * Enter a parse tree produced by {@link ShowProposalParser#time_real}.
	 * @param ctx the parse tree
	 */
	void enterTime_real(ShowProposalParser.Time_realContext ctx);
	/**
	 * Exit a parse tree produced by {@link ShowProposalParser#time_real}.
	 * @param ctx the parse tree
	 */
	void exitTime_real(ShowProposalParser.Time_realContext ctx);
	/**
	 * Enter a parse tree produced by {@link ShowProposalParser#time_placeholder}.
	 * @param ctx the parse tree
	 */
	void enterTime_placeholder(ShowProposalParser.Time_placeholderContext ctx);
	/**
	 * Exit a parse tree produced by {@link ShowProposalParser#time_placeholder}.
	 * @param ctx the parse tree
	 */
	void exitTime_placeholder(ShowProposalParser.Time_placeholderContext ctx);
	/**
	 * Enter a parse tree produced by {@link ShowProposalParser#duration}.
	 * @param ctx the parse tree
	 */
	void enterDuration(ShowProposalParser.DurationContext ctx);
	/**
	 * Exit a parse tree produced by {@link ShowProposalParser#duration}.
	 * @param ctx the parse tree
	 */
	void exitDuration(ShowProposalParser.DurationContext ctx);
	/**
	 * Enter a parse tree produced by {@link ShowProposalParser#duration_real}.
	 * @param ctx the parse tree
	 */
	void enterDuration_real(ShowProposalParser.Duration_realContext ctx);
	/**
	 * Exit a parse tree produced by {@link ShowProposalParser#duration_real}.
	 * @param ctx the parse tree
	 */
	void exitDuration_real(ShowProposalParser.Duration_realContext ctx);
	/**
	 * Enter a parse tree produced by {@link ShowProposalParser#duration_placeholder}.
	 * @param ctx the parse tree
	 */
	void enterDuration_placeholder(ShowProposalParser.Duration_placeholderContext ctx);
	/**
	 * Exit a parse tree produced by {@link ShowProposalParser#duration_placeholder}.
	 * @param ctx the parse tree
	 */
	void exitDuration_placeholder(ShowProposalParser.Duration_placeholderContext ctx);
	/**
	 * Enter a parse tree produced by {@link ShowProposalParser#droneList}.
	 * @param ctx the parse tree
	 */
	void enterDroneList(ShowProposalParser.DroneListContext ctx);
	/**
	 * Exit a parse tree produced by {@link ShowProposalParser#droneList}.
	 * @param ctx the parse tree
	 */
	void exitDroneList(ShowProposalParser.DroneListContext ctx);
	/**
	 * Enter a parse tree produced by {@link ShowProposalParser#droneListReal}.
	 * @param ctx the parse tree
	 */
	void enterDroneListReal(ShowProposalParser.DroneListRealContext ctx);
	/**
	 * Exit a parse tree produced by {@link ShowProposalParser#droneListReal}.
	 * @param ctx the parse tree
	 */
	void exitDroneListReal(ShowProposalParser.DroneListRealContext ctx);
	/**
	 * Enter a parse tree produced by {@link ShowProposalParser#droneListPlaceholders}.
	 * @param ctx the parse tree
	 */
	void enterDroneListPlaceholders(ShowProposalParser.DroneListPlaceholdersContext ctx);
	/**
	 * Exit a parse tree produced by {@link ShowProposalParser#droneListPlaceholders}.
	 * @param ctx the parse tree
	 */
	void exitDroneListPlaceholders(ShowProposalParser.DroneListPlaceholdersContext ctx);
	/**
	 * Enter a parse tree produced by {@link ShowProposalParser#figureList}.
	 * @param ctx the parse tree
	 */
	void enterFigureList(ShowProposalParser.FigureListContext ctx);
	/**
	 * Exit a parse tree produced by {@link ShowProposalParser#figureList}.
	 * @param ctx the parse tree
	 */
	void exitFigureList(ShowProposalParser.FigureListContext ctx);
	/**
	 * Enter a parse tree produced by {@link ShowProposalParser#figureListReal}.
	 * @param ctx the parse tree
	 */
	void enterFigureListReal(ShowProposalParser.FigureListRealContext ctx);
	/**
	 * Exit a parse tree produced by {@link ShowProposalParser#figureListReal}.
	 * @param ctx the parse tree
	 */
	void exitFigureListReal(ShowProposalParser.FigureListRealContext ctx);
	/**
	 * Enter a parse tree produced by {@link ShowProposalParser#figureListPlaceholder}.
	 * @param ctx the parse tree
	 */
	void enterFigureListPlaceholder(ShowProposalParser.FigureListPlaceholderContext ctx);
	/**
	 * Exit a parse tree produced by {@link ShowProposalParser#figureListPlaceholder}.
	 * @param ctx the parse tree
	 */
	void exitFigureListPlaceholder(ShowProposalParser.FigureListPlaceholderContext ctx);
}