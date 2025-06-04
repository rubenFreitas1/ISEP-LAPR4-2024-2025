// Generated from C:/ISEP-PROJETOS/lapr4_projeto/shodrone.LPROG/src/main/java/antlr/ShowProposalPlaceholder.g4 by ANTLR 4.13.2
package genShowProposalPlaceholder;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;


@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class ShowProposalPlaceholderParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, GREETINGS=6, TITLE_PHRASE=7, PREFEREMCE_PHRASE=8, 
		SUBSCRIBE_PHRASE=9, LAST_PHRASE=10, REGARDS=11, LINE_1_FORMAT=12, VIP_LINE1_PLACEHOLDER=13, 
		LINE_2_FORMAT=14, LINE3_PLACEHOLDER=15, LINK_PLACEHOLDER=16, CLOSING_FORMAT_PLACEHOLDER=17, 
		INSURANCE_AMOUNT_PLACEHOLDER=18, SHOW_DATE_FORMAT=19, SHOW_DATE_PLACEHOLDER_LINE=20, 
		SHOW_DATE_PLACEHOLDER=21, FIGURE_ITEM_PLACEHOLDER=22, FIGURE_POSITION_PLACEHOLDER=23, 
		FIGURE_NAME_PLACEHOLDER=24, PERSON_NAME_PLACEHOLDER=25, CRM_MANAGER_PLACEHOLDER=26, 
		COMPANY_PLACEHOLDER=27, ADDRESS_PLACEHOLDER=28, VAT_NUMBER_PLACEHOLDER=29, 
		DRONE_ITEM_FORMAT=30, DRONE_ITEM_PLACEHOLDER=31, DRONE_MODEL_PLACEHOLDER=32, 
		DRONE_MODEL_QUANTITY_PLACEHOLDER=33, GPS_LINE=34, GPS_LINE_PLACEHOLDER=35, 
		GPS_PLACEHOLDER=36, ATTACHMENT_LINE=37, ATTACHMENT_PLACEHOLDER=38, SHOW_PROPOSAL_PLACEHOLDER=39, 
		REFERENCE_LINE=40, REFERENCE_PLACEHOLDER=41, PROPOSAL_PLACEHOLDER=42, 
		DATE_PLACEHOLDER=43, TIME_LINE=44, TIME_PLACEHOLDER_LINE=45, TIME_PLACEHOLDER=46, 
		DURATION_LINE=47, DURATION_MINUTES=48, DURATION_PLACEHOLDER_LINE=49, DURATION_PLACEHOLDER=50, 
		PAGE_BREAK=51, NEWLINE=52;
	public static final int
		RULE_proposal = 0, RULE_header = 1, RULE_greeting = 2, RULE_companyInfo = 3, 
		RULE_personName = 4, RULE_personNamePlaceholder = 5, RULE_company = 6, 
		RULE_companyPlaceHolder = 7, RULE_address = 8, RULE_addressPlaceHolder = 9, 
		RULE_vatNumber = 10, RULE_vatNumberPlaceHolder = 11, RULE_reference = 12, 
		RULE_referencePlaceHolder = 13, RULE_titleProposal = 14, RULE_body = 15, 
		RULE_line_1 = 16, RULE_normal_line1 = 17, RULE_vip_line1 = 18, RULE_vip_line1_Placeholder = 19, 
		RULE_line_2 = 20, RULE_line_3 = 21, RULE_line3_placeholder = 22, RULE_closing = 23, 
		RULE_closing_placeholder = 24, RULE_signature = 25, RULE_crmManagerName = 26, 
		RULE_managerName_Placeholder = 27, RULE_signature_option = 28, RULE_preferencePhrase = 29, 
		RULE_subscribePhrase = 30, RULE_lastPhrase = 31, RULE_regards = 32, RULE_showDetails = 33, 
		RULE_attachment = 34, RULE_attachment_placeholder = 35, RULE_location = 36, 
		RULE_location_placeholder = 37, RULE_date = 38, RULE_date_placeholder = 39, 
		RULE_time = 40, RULE_time_placeholder = 41, RULE_duration = 42, RULE_duration_placeholder = 43, 
		RULE_droneList = 44, RULE_droneListPlaceholders = 45, RULE_figureList = 46, 
		RULE_figureListPlaceholder = 47;
	private static String[] makeRuleNames() {
		return new String[] {
			"proposal", "header", "greeting", "companyInfo", "personName", "personNamePlaceholder", 
			"company", "companyPlaceHolder", "address", "addressPlaceHolder", "vatNumber", 
			"vatNumberPlaceHolder", "reference", "referencePlaceHolder", "titleProposal", 
			"body", "line_1", "normal_line1", "vip_line1", "vip_line1_Placeholder", 
			"line_2", "line_3", "line3_placeholder", "closing", "closing_placeholder", 
			"signature", "crmManagerName", "managerName_Placeholder", "signature_option", 
			"preferencePhrase", "subscribePhrase", "lastPhrase", "regards", "showDetails", 
			"attachment", "attachment_placeholder", "location", "location_placeholder", 
			"date", "date_placeholder", "time", "time_placeholder", "duration", "duration_placeholder", 
			"droneList", "droneListPlaceholders", "figureList", "figureListPlaceholder"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'CRM Manager'", "'#List of used drones'", "'#Lista de drones utilizados'", 
			"'#Lista de figuras'", "'#List of figures'", null, null, null, null, 
			"'Looking forward to hearing from you soon.'", null, null, null, null, 
			null, "'[link to show video]'", null, null, null, null, "'[date of the event]'", 
			null, "'[position in show]'", "'[figure name]'", "'[Customer Representative Name]'", 
			"'[CRM Manager Name]'", null, "'[Address with postal code and country]'", 
			"'[VAT Number]'", null, null, "'[model]'", "'[quantity]'", null, null, 
			"'[GPS coordinates of the location]'", null, null, "'[show proposal number]'", 
			null, null, "'[proposal number]'", "'[date]'", null, null, "'[time of the event]'", 
			null, null, null, "'[duration]'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, "GREETINGS", "TITLE_PHRASE", "PREFEREMCE_PHRASE", 
			"SUBSCRIBE_PHRASE", "LAST_PHRASE", "REGARDS", "LINE_1_FORMAT", "VIP_LINE1_PLACEHOLDER", 
			"LINE_2_FORMAT", "LINE3_PLACEHOLDER", "LINK_PLACEHOLDER", "CLOSING_FORMAT_PLACEHOLDER", 
			"INSURANCE_AMOUNT_PLACEHOLDER", "SHOW_DATE_FORMAT", "SHOW_DATE_PLACEHOLDER_LINE", 
			"SHOW_DATE_PLACEHOLDER", "FIGURE_ITEM_PLACEHOLDER", "FIGURE_POSITION_PLACEHOLDER", 
			"FIGURE_NAME_PLACEHOLDER", "PERSON_NAME_PLACEHOLDER", "CRM_MANAGER_PLACEHOLDER", 
			"COMPANY_PLACEHOLDER", "ADDRESS_PLACEHOLDER", "VAT_NUMBER_PLACEHOLDER", 
			"DRONE_ITEM_FORMAT", "DRONE_ITEM_PLACEHOLDER", "DRONE_MODEL_PLACEHOLDER", 
			"DRONE_MODEL_QUANTITY_PLACEHOLDER", "GPS_LINE", "GPS_LINE_PLACEHOLDER", 
			"GPS_PLACEHOLDER", "ATTACHMENT_LINE", "ATTACHMENT_PLACEHOLDER", "SHOW_PROPOSAL_PLACEHOLDER", 
			"REFERENCE_LINE", "REFERENCE_PLACEHOLDER", "PROPOSAL_PLACEHOLDER", "DATE_PLACEHOLDER", 
			"TIME_LINE", "TIME_PLACEHOLDER_LINE", "TIME_PLACEHOLDER", "DURATION_LINE", 
			"DURATION_MINUTES", "DURATION_PLACEHOLDER_LINE", "DURATION_PLACEHOLDER", 
			"PAGE_BREAK", "NEWLINE"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "ShowProposalPlaceholder.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public ShowProposalPlaceholderParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ProposalContext extends ParserRuleContext {
		public HeaderContext header() {
			return getRuleContext(HeaderContext.class,0);
		}
		public List<TerminalNode> NEWLINE() { return getTokens(ShowProposalPlaceholderParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(ShowProposalPlaceholderParser.NEWLINE, i);
		}
		public ReferenceContext reference() {
			return getRuleContext(ReferenceContext.class,0);
		}
		public BodyContext body() {
			return getRuleContext(BodyContext.class,0);
		}
		public ClosingContext closing() {
			return getRuleContext(ClosingContext.class,0);
		}
		public SignatureContext signature() {
			return getRuleContext(SignatureContext.class,0);
		}
		public TerminalNode PAGE_BREAK() { return getToken(ShowProposalPlaceholderParser.PAGE_BREAK, 0); }
		public ShowDetailsContext showDetails() {
			return getRuleContext(ShowDetailsContext.class,0);
		}
		public TerminalNode EOF() { return getToken(ShowProposalPlaceholderParser.EOF, 0); }
		public ProposalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_proposal; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShowProposalPlaceholderListener ) ((ShowProposalPlaceholderListener)listener).enterProposal(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShowProposalPlaceholderListener ) ((ShowProposalPlaceholderListener)listener).exitProposal(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ShowProposalPlaceholderVisitor ) return ((ShowProposalPlaceholderVisitor<? extends T>)visitor).visitProposal(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProposalContext proposal() throws RecognitionException {
		ProposalContext _localctx = new ProposalContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_proposal);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(96);
			header();
			setState(97);
			match(NEWLINE);
			setState(98);
			reference();
			setState(99);
			match(NEWLINE);
			setState(100);
			match(NEWLINE);
			setState(101);
			body();
			setState(102);
			match(NEWLINE);
			setState(103);
			match(NEWLINE);
			setState(104);
			closing();
			setState(105);
			match(NEWLINE);
			setState(106);
			match(NEWLINE);
			setState(107);
			signature();
			setState(108);
			match(NEWLINE);
			setState(109);
			match(NEWLINE);
			setState(110);
			match(PAGE_BREAK);
			setState(111);
			match(NEWLINE);
			setState(112);
			match(NEWLINE);
			setState(113);
			showDetails();
			setState(114);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class HeaderContext extends ParserRuleContext {
		public GreetingContext greeting() {
			return getRuleContext(GreetingContext.class,0);
		}
		public TerminalNode NEWLINE() { return getToken(ShowProposalPlaceholderParser.NEWLINE, 0); }
		public CompanyInfoContext companyInfo() {
			return getRuleContext(CompanyInfoContext.class,0);
		}
		public HeaderContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_header; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShowProposalPlaceholderListener ) ((ShowProposalPlaceholderListener)listener).enterHeader(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShowProposalPlaceholderListener ) ((ShowProposalPlaceholderListener)listener).exitHeader(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ShowProposalPlaceholderVisitor ) return ((ShowProposalPlaceholderVisitor<? extends T>)visitor).visitHeader(this);
			else return visitor.visitChildren(this);
		}
	}

	public final HeaderContext header() throws RecognitionException {
		HeaderContext _localctx = new HeaderContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_header);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(116);
			greeting();
			setState(117);
			match(NEWLINE);
			setState(118);
			companyInfo();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class GreetingContext extends ParserRuleContext {
		public TerminalNode GREETINGS() { return getToken(ShowProposalPlaceholderParser.GREETINGS, 0); }
		public GreetingContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_greeting; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShowProposalPlaceholderListener ) ((ShowProposalPlaceholderListener)listener).enterGreeting(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShowProposalPlaceholderListener ) ((ShowProposalPlaceholderListener)listener).exitGreeting(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ShowProposalPlaceholderVisitor ) return ((ShowProposalPlaceholderVisitor<? extends T>)visitor).visitGreeting(this);
			else return visitor.visitChildren(this);
		}
	}

	public final GreetingContext greeting() throws RecognitionException {
		GreetingContext _localctx = new GreetingContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_greeting);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(120);
			match(GREETINGS);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CompanyInfoContext extends ParserRuleContext {
		public CompanyContext company() {
			return getRuleContext(CompanyContext.class,0);
		}
		public List<TerminalNode> NEWLINE() { return getTokens(ShowProposalPlaceholderParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(ShowProposalPlaceholderParser.NEWLINE, i);
		}
		public AddressContext address() {
			return getRuleContext(AddressContext.class,0);
		}
		public VatNumberContext vatNumber() {
			return getRuleContext(VatNumberContext.class,0);
		}
		public PersonNameContext personName() {
			return getRuleContext(PersonNameContext.class,0);
		}
		public CompanyInfoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_companyInfo; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShowProposalPlaceholderListener ) ((ShowProposalPlaceholderListener)listener).enterCompanyInfo(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShowProposalPlaceholderListener ) ((ShowProposalPlaceholderListener)listener).exitCompanyInfo(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ShowProposalPlaceholderVisitor ) return ((ShowProposalPlaceholderVisitor<? extends T>)visitor).visitCompanyInfo(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CompanyInfoContext companyInfo() throws RecognitionException {
		CompanyInfoContext _localctx = new CompanyInfoContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_companyInfo);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(125);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==PERSON_NAME_PLACEHOLDER) {
				{
				setState(122);
				personName();
				setState(123);
				match(NEWLINE);
				}
			}

			setState(127);
			company();
			setState(128);
			match(NEWLINE);
			setState(129);
			address();
			setState(130);
			match(NEWLINE);
			setState(131);
			vatNumber();
			setState(132);
			match(NEWLINE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class PersonNameContext extends ParserRuleContext {
		public PersonNamePlaceholderContext personNamePlaceholder() {
			return getRuleContext(PersonNamePlaceholderContext.class,0);
		}
		public PersonNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_personName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShowProposalPlaceholderListener ) ((ShowProposalPlaceholderListener)listener).enterPersonName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShowProposalPlaceholderListener ) ((ShowProposalPlaceholderListener)listener).exitPersonName(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ShowProposalPlaceholderVisitor ) return ((ShowProposalPlaceholderVisitor<? extends T>)visitor).visitPersonName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PersonNameContext personName() throws RecognitionException {
		PersonNameContext _localctx = new PersonNameContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_personName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(134);
			personNamePlaceholder();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class PersonNamePlaceholderContext extends ParserRuleContext {
		public TerminalNode PERSON_NAME_PLACEHOLDER() { return getToken(ShowProposalPlaceholderParser.PERSON_NAME_PLACEHOLDER, 0); }
		public PersonNamePlaceholderContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_personNamePlaceholder; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShowProposalPlaceholderListener ) ((ShowProposalPlaceholderListener)listener).enterPersonNamePlaceholder(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShowProposalPlaceholderListener ) ((ShowProposalPlaceholderListener)listener).exitPersonNamePlaceholder(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ShowProposalPlaceholderVisitor ) return ((ShowProposalPlaceholderVisitor<? extends T>)visitor).visitPersonNamePlaceholder(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PersonNamePlaceholderContext personNamePlaceholder() throws RecognitionException {
		PersonNamePlaceholderContext _localctx = new PersonNamePlaceholderContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_personNamePlaceholder);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(136);
			match(PERSON_NAME_PLACEHOLDER);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CompanyContext extends ParserRuleContext {
		public CompanyPlaceHolderContext companyPlaceHolder() {
			return getRuleContext(CompanyPlaceHolderContext.class,0);
		}
		public CompanyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_company; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShowProposalPlaceholderListener ) ((ShowProposalPlaceholderListener)listener).enterCompany(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShowProposalPlaceholderListener ) ((ShowProposalPlaceholderListener)listener).exitCompany(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ShowProposalPlaceholderVisitor ) return ((ShowProposalPlaceholderVisitor<? extends T>)visitor).visitCompany(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CompanyContext company() throws RecognitionException {
		CompanyContext _localctx = new CompanyContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_company);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(138);
			companyPlaceHolder();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CompanyPlaceHolderContext extends ParserRuleContext {
		public TerminalNode COMPANY_PLACEHOLDER() { return getToken(ShowProposalPlaceholderParser.COMPANY_PLACEHOLDER, 0); }
		public CompanyPlaceHolderContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_companyPlaceHolder; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShowProposalPlaceholderListener ) ((ShowProposalPlaceholderListener)listener).enterCompanyPlaceHolder(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShowProposalPlaceholderListener ) ((ShowProposalPlaceholderListener)listener).exitCompanyPlaceHolder(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ShowProposalPlaceholderVisitor ) return ((ShowProposalPlaceholderVisitor<? extends T>)visitor).visitCompanyPlaceHolder(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CompanyPlaceHolderContext companyPlaceHolder() throws RecognitionException {
		CompanyPlaceHolderContext _localctx = new CompanyPlaceHolderContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_companyPlaceHolder);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(140);
			match(COMPANY_PLACEHOLDER);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class AddressContext extends ParserRuleContext {
		public AddressPlaceHolderContext addressPlaceHolder() {
			return getRuleContext(AddressPlaceHolderContext.class,0);
		}
		public AddressContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_address; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShowProposalPlaceholderListener ) ((ShowProposalPlaceholderListener)listener).enterAddress(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShowProposalPlaceholderListener ) ((ShowProposalPlaceholderListener)listener).exitAddress(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ShowProposalPlaceholderVisitor ) return ((ShowProposalPlaceholderVisitor<? extends T>)visitor).visitAddress(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AddressContext address() throws RecognitionException {
		AddressContext _localctx = new AddressContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_address);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(142);
			addressPlaceHolder();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class AddressPlaceHolderContext extends ParserRuleContext {
		public TerminalNode ADDRESS_PLACEHOLDER() { return getToken(ShowProposalPlaceholderParser.ADDRESS_PLACEHOLDER, 0); }
		public AddressPlaceHolderContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_addressPlaceHolder; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShowProposalPlaceholderListener ) ((ShowProposalPlaceholderListener)listener).enterAddressPlaceHolder(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShowProposalPlaceholderListener ) ((ShowProposalPlaceholderListener)listener).exitAddressPlaceHolder(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ShowProposalPlaceholderVisitor ) return ((ShowProposalPlaceholderVisitor<? extends T>)visitor).visitAddressPlaceHolder(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AddressPlaceHolderContext addressPlaceHolder() throws RecognitionException {
		AddressPlaceHolderContext _localctx = new AddressPlaceHolderContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_addressPlaceHolder);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(144);
			match(ADDRESS_PLACEHOLDER);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class VatNumberContext extends ParserRuleContext {
		public VatNumberPlaceHolderContext vatNumberPlaceHolder() {
			return getRuleContext(VatNumberPlaceHolderContext.class,0);
		}
		public VatNumberContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_vatNumber; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShowProposalPlaceholderListener ) ((ShowProposalPlaceholderListener)listener).enterVatNumber(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShowProposalPlaceholderListener ) ((ShowProposalPlaceholderListener)listener).exitVatNumber(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ShowProposalPlaceholderVisitor ) return ((ShowProposalPlaceholderVisitor<? extends T>)visitor).visitVatNumber(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VatNumberContext vatNumber() throws RecognitionException {
		VatNumberContext _localctx = new VatNumberContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_vatNumber);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(146);
			vatNumberPlaceHolder();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class VatNumberPlaceHolderContext extends ParserRuleContext {
		public TerminalNode VAT_NUMBER_PLACEHOLDER() { return getToken(ShowProposalPlaceholderParser.VAT_NUMBER_PLACEHOLDER, 0); }
		public VatNumberPlaceHolderContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_vatNumberPlaceHolder; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShowProposalPlaceholderListener ) ((ShowProposalPlaceholderListener)listener).enterVatNumberPlaceHolder(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShowProposalPlaceholderListener ) ((ShowProposalPlaceholderListener)listener).exitVatNumberPlaceHolder(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ShowProposalPlaceholderVisitor ) return ((ShowProposalPlaceholderVisitor<? extends T>)visitor).visitVatNumberPlaceHolder(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VatNumberPlaceHolderContext vatNumberPlaceHolder() throws RecognitionException {
		VatNumberPlaceHolderContext _localctx = new VatNumberPlaceHolderContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_vatNumberPlaceHolder);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(148);
			match(VAT_NUMBER_PLACEHOLDER);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ReferenceContext extends ParserRuleContext {
		public ReferencePlaceHolderContext referencePlaceHolder() {
			return getRuleContext(ReferencePlaceHolderContext.class,0);
		}
		public TerminalNode NEWLINE() { return getToken(ShowProposalPlaceholderParser.NEWLINE, 0); }
		public TitleProposalContext titleProposal() {
			return getRuleContext(TitleProposalContext.class,0);
		}
		public ReferenceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_reference; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShowProposalPlaceholderListener ) ((ShowProposalPlaceholderListener)listener).enterReference(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShowProposalPlaceholderListener ) ((ShowProposalPlaceholderListener)listener).exitReference(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ShowProposalPlaceholderVisitor ) return ((ShowProposalPlaceholderVisitor<? extends T>)visitor).visitReference(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ReferenceContext reference() throws RecognitionException {
		ReferenceContext _localctx = new ReferenceContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_reference);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(150);
			referencePlaceHolder();
			setState(151);
			match(NEWLINE);
			setState(152);
			titleProposal();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ReferencePlaceHolderContext extends ParserRuleContext {
		public TerminalNode REFERENCE_PLACEHOLDER() { return getToken(ShowProposalPlaceholderParser.REFERENCE_PLACEHOLDER, 0); }
		public ReferencePlaceHolderContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_referencePlaceHolder; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShowProposalPlaceholderListener ) ((ShowProposalPlaceholderListener)listener).enterReferencePlaceHolder(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShowProposalPlaceholderListener ) ((ShowProposalPlaceholderListener)listener).exitReferencePlaceHolder(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ShowProposalPlaceholderVisitor ) return ((ShowProposalPlaceholderVisitor<? extends T>)visitor).visitReferencePlaceHolder(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ReferencePlaceHolderContext referencePlaceHolder() throws RecognitionException {
		ReferencePlaceHolderContext _localctx = new ReferencePlaceHolderContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_referencePlaceHolder);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(154);
			match(REFERENCE_PLACEHOLDER);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TitleProposalContext extends ParserRuleContext {
		public TerminalNode TITLE_PHRASE() { return getToken(ShowProposalPlaceholderParser.TITLE_PHRASE, 0); }
		public TitleProposalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_titleProposal; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShowProposalPlaceholderListener ) ((ShowProposalPlaceholderListener)listener).enterTitleProposal(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShowProposalPlaceholderListener ) ((ShowProposalPlaceholderListener)listener).exitTitleProposal(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ShowProposalPlaceholderVisitor ) return ((ShowProposalPlaceholderVisitor<? extends T>)visitor).visitTitleProposal(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TitleProposalContext titleProposal() throws RecognitionException {
		TitleProposalContext _localctx = new TitleProposalContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_titleProposal);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(156);
			match(TITLE_PHRASE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class BodyContext extends ParserRuleContext {
		public Line_1Context line_1() {
			return getRuleContext(Line_1Context.class,0);
		}
		public List<TerminalNode> NEWLINE() { return getTokens(ShowProposalPlaceholderParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(ShowProposalPlaceholderParser.NEWLINE, i);
		}
		public Line_2Context line_2() {
			return getRuleContext(Line_2Context.class,0);
		}
		public Line_3Context line_3() {
			return getRuleContext(Line_3Context.class,0);
		}
		public BodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_body; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShowProposalPlaceholderListener ) ((ShowProposalPlaceholderListener)listener).enterBody(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShowProposalPlaceholderListener ) ((ShowProposalPlaceholderListener)listener).exitBody(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ShowProposalPlaceholderVisitor ) return ((ShowProposalPlaceholderVisitor<? extends T>)visitor).visitBody(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BodyContext body() throws RecognitionException {
		BodyContext _localctx = new BodyContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_body);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(158);
			line_1();
			setState(159);
			match(NEWLINE);
			setState(160);
			line_2();
			setState(161);
			match(NEWLINE);
			setState(162);
			line_3();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Line_1Context extends ParserRuleContext {
		public Normal_line1Context normal_line1() {
			return getRuleContext(Normal_line1Context.class,0);
		}
		public Vip_line1Context vip_line1() {
			return getRuleContext(Vip_line1Context.class,0);
		}
		public Line_1Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_line_1; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShowProposalPlaceholderListener ) ((ShowProposalPlaceholderListener)listener).enterLine_1(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShowProposalPlaceholderListener ) ((ShowProposalPlaceholderListener)listener).exitLine_1(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ShowProposalPlaceholderVisitor ) return ((ShowProposalPlaceholderVisitor<? extends T>)visitor).visitLine_1(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Line_1Context line_1() throws RecognitionException {
		Line_1Context _localctx = new Line_1Context(_ctx, getState());
		enterRule(_localctx, 32, RULE_line_1);
		try {
			setState(166);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LINE_1_FORMAT:
				enterOuterAlt(_localctx, 1);
				{
				setState(164);
				normal_line1();
				}
				break;
			case VIP_LINE1_PLACEHOLDER:
				enterOuterAlt(_localctx, 2);
				{
				setState(165);
				vip_line1();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Normal_line1Context extends ParserRuleContext {
		public TerminalNode LINE_1_FORMAT() { return getToken(ShowProposalPlaceholderParser.LINE_1_FORMAT, 0); }
		public Normal_line1Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_normal_line1; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShowProposalPlaceholderListener ) ((ShowProposalPlaceholderListener)listener).enterNormal_line1(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShowProposalPlaceholderListener ) ((ShowProposalPlaceholderListener)listener).exitNormal_line1(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ShowProposalPlaceholderVisitor ) return ((ShowProposalPlaceholderVisitor<? extends T>)visitor).visitNormal_line1(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Normal_line1Context normal_line1() throws RecognitionException {
		Normal_line1Context _localctx = new Normal_line1Context(_ctx, getState());
		enterRule(_localctx, 34, RULE_normal_line1);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(168);
			match(LINE_1_FORMAT);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Vip_line1Context extends ParserRuleContext {
		public Vip_line1_PlaceholderContext vip_line1_Placeholder() {
			return getRuleContext(Vip_line1_PlaceholderContext.class,0);
		}
		public Vip_line1Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_vip_line1; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShowProposalPlaceholderListener ) ((ShowProposalPlaceholderListener)listener).enterVip_line1(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShowProposalPlaceholderListener ) ((ShowProposalPlaceholderListener)listener).exitVip_line1(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ShowProposalPlaceholderVisitor ) return ((ShowProposalPlaceholderVisitor<? extends T>)visitor).visitVip_line1(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Vip_line1Context vip_line1() throws RecognitionException {
		Vip_line1Context _localctx = new Vip_line1Context(_ctx, getState());
		enterRule(_localctx, 36, RULE_vip_line1);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(170);
			vip_line1_Placeholder();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Vip_line1_PlaceholderContext extends ParserRuleContext {
		public TerminalNode VIP_LINE1_PLACEHOLDER() { return getToken(ShowProposalPlaceholderParser.VIP_LINE1_PLACEHOLDER, 0); }
		public Vip_line1_PlaceholderContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_vip_line1_Placeholder; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShowProposalPlaceholderListener ) ((ShowProposalPlaceholderListener)listener).enterVip_line1_Placeholder(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShowProposalPlaceholderListener ) ((ShowProposalPlaceholderListener)listener).exitVip_line1_Placeholder(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ShowProposalPlaceholderVisitor ) return ((ShowProposalPlaceholderVisitor<? extends T>)visitor).visitVip_line1_Placeholder(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Vip_line1_PlaceholderContext vip_line1_Placeholder() throws RecognitionException {
		Vip_line1_PlaceholderContext _localctx = new Vip_line1_PlaceholderContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_vip_line1_Placeholder);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(172);
			match(VIP_LINE1_PLACEHOLDER);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Line_2Context extends ParserRuleContext {
		public TerminalNode LINE_2_FORMAT() { return getToken(ShowProposalPlaceholderParser.LINE_2_FORMAT, 0); }
		public Line_2Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_line_2; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShowProposalPlaceholderListener ) ((ShowProposalPlaceholderListener)listener).enterLine_2(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShowProposalPlaceholderListener ) ((ShowProposalPlaceholderListener)listener).exitLine_2(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ShowProposalPlaceholderVisitor ) return ((ShowProposalPlaceholderVisitor<? extends T>)visitor).visitLine_2(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Line_2Context line_2() throws RecognitionException {
		Line_2Context _localctx = new Line_2Context(_ctx, getState());
		enterRule(_localctx, 40, RULE_line_2);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(174);
			match(LINE_2_FORMAT);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Line_3Context extends ParserRuleContext {
		public Line3_placeholderContext line3_placeholder() {
			return getRuleContext(Line3_placeholderContext.class,0);
		}
		public Line_3Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_line_3; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShowProposalPlaceholderListener ) ((ShowProposalPlaceholderListener)listener).enterLine_3(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShowProposalPlaceholderListener ) ((ShowProposalPlaceholderListener)listener).exitLine_3(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ShowProposalPlaceholderVisitor ) return ((ShowProposalPlaceholderVisitor<? extends T>)visitor).visitLine_3(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Line_3Context line_3() throws RecognitionException {
		Line_3Context _localctx = new Line_3Context(_ctx, getState());
		enterRule(_localctx, 42, RULE_line_3);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(176);
			line3_placeholder();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Line3_placeholderContext extends ParserRuleContext {
		public TerminalNode LINE3_PLACEHOLDER() { return getToken(ShowProposalPlaceholderParser.LINE3_PLACEHOLDER, 0); }
		public Line3_placeholderContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_line3_placeholder; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShowProposalPlaceholderListener ) ((ShowProposalPlaceholderListener)listener).enterLine3_placeholder(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShowProposalPlaceholderListener ) ((ShowProposalPlaceholderListener)listener).exitLine3_placeholder(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ShowProposalPlaceholderVisitor ) return ((ShowProposalPlaceholderVisitor<? extends T>)visitor).visitLine3_placeholder(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Line3_placeholderContext line3_placeholder() throws RecognitionException {
		Line3_placeholderContext _localctx = new Line3_placeholderContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_line3_placeholder);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(178);
			match(LINE3_PLACEHOLDER);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ClosingContext extends ParserRuleContext {
		public Closing_placeholderContext closing_placeholder() {
			return getRuleContext(Closing_placeholderContext.class,0);
		}
		public ClosingContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_closing; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShowProposalPlaceholderListener ) ((ShowProposalPlaceholderListener)listener).enterClosing(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShowProposalPlaceholderListener ) ((ShowProposalPlaceholderListener)listener).exitClosing(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ShowProposalPlaceholderVisitor ) return ((ShowProposalPlaceholderVisitor<? extends T>)visitor).visitClosing(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ClosingContext closing() throws RecognitionException {
		ClosingContext _localctx = new ClosingContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_closing);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(180);
			closing_placeholder();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Closing_placeholderContext extends ParserRuleContext {
		public TerminalNode CLOSING_FORMAT_PLACEHOLDER() { return getToken(ShowProposalPlaceholderParser.CLOSING_FORMAT_PLACEHOLDER, 0); }
		public Closing_placeholderContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_closing_placeholder; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShowProposalPlaceholderListener ) ((ShowProposalPlaceholderListener)listener).enterClosing_placeholder(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShowProposalPlaceholderListener ) ((ShowProposalPlaceholderListener)listener).exitClosing_placeholder(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ShowProposalPlaceholderVisitor ) return ((ShowProposalPlaceholderVisitor<? extends T>)visitor).visitClosing_placeholder(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Closing_placeholderContext closing_placeholder() throws RecognitionException {
		Closing_placeholderContext _localctx = new Closing_placeholderContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_closing_placeholder);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(182);
			match(CLOSING_FORMAT_PLACEHOLDER);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class SignatureContext extends ParserRuleContext {
		public Signature_optionContext signature_option() {
			return getRuleContext(Signature_optionContext.class,0);
		}
		public List<TerminalNode> NEWLINE() { return getTokens(ShowProposalPlaceholderParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(ShowProposalPlaceholderParser.NEWLINE, i);
		}
		public RegardsContext regards() {
			return getRuleContext(RegardsContext.class,0);
		}
		public CrmManagerNameContext crmManagerName() {
			return getRuleContext(CrmManagerNameContext.class,0);
		}
		public SignatureContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_signature; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShowProposalPlaceholderListener ) ((ShowProposalPlaceholderListener)listener).enterSignature(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShowProposalPlaceholderListener ) ((ShowProposalPlaceholderListener)listener).exitSignature(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ShowProposalPlaceholderVisitor ) return ((ShowProposalPlaceholderVisitor<? extends T>)visitor).visitSignature(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SignatureContext signature() throws RecognitionException {
		SignatureContext _localctx = new SignatureContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_signature);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(184);
			signature_option();
			setState(185);
			match(NEWLINE);
			setState(186);
			regards();
			setState(187);
			match(NEWLINE);
			setState(188);
			match(NEWLINE);
			setState(189);
			crmManagerName();
			setState(190);
			match(NEWLINE);
			setState(191);
			match(T__0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CrmManagerNameContext extends ParserRuleContext {
		public ManagerName_PlaceholderContext managerName_Placeholder() {
			return getRuleContext(ManagerName_PlaceholderContext.class,0);
		}
		public CrmManagerNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_crmManagerName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShowProposalPlaceholderListener ) ((ShowProposalPlaceholderListener)listener).enterCrmManagerName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShowProposalPlaceholderListener ) ((ShowProposalPlaceholderListener)listener).exitCrmManagerName(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ShowProposalPlaceholderVisitor ) return ((ShowProposalPlaceholderVisitor<? extends T>)visitor).visitCrmManagerName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CrmManagerNameContext crmManagerName() throws RecognitionException {
		CrmManagerNameContext _localctx = new CrmManagerNameContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_crmManagerName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(193);
			managerName_Placeholder();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ManagerName_PlaceholderContext extends ParserRuleContext {
		public TerminalNode CRM_MANAGER_PLACEHOLDER() { return getToken(ShowProposalPlaceholderParser.CRM_MANAGER_PLACEHOLDER, 0); }
		public ManagerName_PlaceholderContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_managerName_Placeholder; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShowProposalPlaceholderListener ) ((ShowProposalPlaceholderListener)listener).enterManagerName_Placeholder(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShowProposalPlaceholderListener ) ((ShowProposalPlaceholderListener)listener).exitManagerName_Placeholder(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ShowProposalPlaceholderVisitor ) return ((ShowProposalPlaceholderVisitor<? extends T>)visitor).visitManagerName_Placeholder(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ManagerName_PlaceholderContext managerName_Placeholder() throws RecognitionException {
		ManagerName_PlaceholderContext _localctx = new ManagerName_PlaceholderContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_managerName_Placeholder);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(195);
			match(CRM_MANAGER_PLACEHOLDER);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Signature_optionContext extends ParserRuleContext {
		public PreferencePhraseContext preferencePhrase() {
			return getRuleContext(PreferencePhraseContext.class,0);
		}
		public List<TerminalNode> NEWLINE() { return getTokens(ShowProposalPlaceholderParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(ShowProposalPlaceholderParser.NEWLINE, i);
		}
		public SubscribePhraseContext subscribePhrase() {
			return getRuleContext(SubscribePhraseContext.class,0);
		}
		public LastPhraseContext lastPhrase() {
			return getRuleContext(LastPhraseContext.class,0);
		}
		public Signature_optionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_signature_option; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShowProposalPlaceholderListener ) ((ShowProposalPlaceholderListener)listener).enterSignature_option(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShowProposalPlaceholderListener ) ((ShowProposalPlaceholderListener)listener).exitSignature_option(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ShowProposalPlaceholderVisitor ) return ((ShowProposalPlaceholderVisitor<? extends T>)visitor).visitSignature_option(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Signature_optionContext signature_option() throws RecognitionException {
		Signature_optionContext _localctx = new Signature_optionContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_signature_option);
		try {
			setState(206);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case PREFEREMCE_PHRASE:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(197);
				preferencePhrase();
				setState(198);
				match(NEWLINE);
				setState(199);
				match(NEWLINE);
				setState(200);
				subscribePhrase();
				setState(201);
				match(NEWLINE);
				}
				}
				break;
			case LAST_PHRASE:
				enterOuterAlt(_localctx, 2);
				{
				setState(203);
				lastPhrase();
				setState(204);
				match(NEWLINE);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class PreferencePhraseContext extends ParserRuleContext {
		public TerminalNode PREFEREMCE_PHRASE() { return getToken(ShowProposalPlaceholderParser.PREFEREMCE_PHRASE, 0); }
		public PreferencePhraseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_preferencePhrase; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShowProposalPlaceholderListener ) ((ShowProposalPlaceholderListener)listener).enterPreferencePhrase(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShowProposalPlaceholderListener ) ((ShowProposalPlaceholderListener)listener).exitPreferencePhrase(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ShowProposalPlaceholderVisitor ) return ((ShowProposalPlaceholderVisitor<? extends T>)visitor).visitPreferencePhrase(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PreferencePhraseContext preferencePhrase() throws RecognitionException {
		PreferencePhraseContext _localctx = new PreferencePhraseContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_preferencePhrase);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(208);
			match(PREFEREMCE_PHRASE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class SubscribePhraseContext extends ParserRuleContext {
		public TerminalNode SUBSCRIBE_PHRASE() { return getToken(ShowProposalPlaceholderParser.SUBSCRIBE_PHRASE, 0); }
		public SubscribePhraseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_subscribePhrase; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShowProposalPlaceholderListener ) ((ShowProposalPlaceholderListener)listener).enterSubscribePhrase(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShowProposalPlaceholderListener ) ((ShowProposalPlaceholderListener)listener).exitSubscribePhrase(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ShowProposalPlaceholderVisitor ) return ((ShowProposalPlaceholderVisitor<? extends T>)visitor).visitSubscribePhrase(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SubscribePhraseContext subscribePhrase() throws RecognitionException {
		SubscribePhraseContext _localctx = new SubscribePhraseContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_subscribePhrase);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(210);
			match(SUBSCRIBE_PHRASE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class LastPhraseContext extends ParserRuleContext {
		public TerminalNode LAST_PHRASE() { return getToken(ShowProposalPlaceholderParser.LAST_PHRASE, 0); }
		public LastPhraseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lastPhrase; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShowProposalPlaceholderListener ) ((ShowProposalPlaceholderListener)listener).enterLastPhrase(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShowProposalPlaceholderListener ) ((ShowProposalPlaceholderListener)listener).exitLastPhrase(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ShowProposalPlaceholderVisitor ) return ((ShowProposalPlaceholderVisitor<? extends T>)visitor).visitLastPhrase(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LastPhraseContext lastPhrase() throws RecognitionException {
		LastPhraseContext _localctx = new LastPhraseContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_lastPhrase);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(212);
			match(LAST_PHRASE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class RegardsContext extends ParserRuleContext {
		public TerminalNode REGARDS() { return getToken(ShowProposalPlaceholderParser.REGARDS, 0); }
		public RegardsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_regards; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShowProposalPlaceholderListener ) ((ShowProposalPlaceholderListener)listener).enterRegards(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShowProposalPlaceholderListener ) ((ShowProposalPlaceholderListener)listener).exitRegards(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ShowProposalPlaceholderVisitor ) return ((ShowProposalPlaceholderVisitor<? extends T>)visitor).visitRegards(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RegardsContext regards() throws RecognitionException {
		RegardsContext _localctx = new RegardsContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_regards);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(214);
			match(REGARDS);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ShowDetailsContext extends ParserRuleContext {
		public AttachmentContext attachment() {
			return getRuleContext(AttachmentContext.class,0);
		}
		public List<TerminalNode> NEWLINE() { return getTokens(ShowProposalPlaceholderParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(ShowProposalPlaceholderParser.NEWLINE, i);
		}
		public LocationContext location() {
			return getRuleContext(LocationContext.class,0);
		}
		public DateContext date() {
			return getRuleContext(DateContext.class,0);
		}
		public TimeContext time() {
			return getRuleContext(TimeContext.class,0);
		}
		public DurationContext duration() {
			return getRuleContext(DurationContext.class,0);
		}
		public DroneListContext droneList() {
			return getRuleContext(DroneListContext.class,0);
		}
		public FigureListContext figureList() {
			return getRuleContext(FigureListContext.class,0);
		}
		public ShowDetailsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_showDetails; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShowProposalPlaceholderListener ) ((ShowProposalPlaceholderListener)listener).enterShowDetails(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShowProposalPlaceholderListener ) ((ShowProposalPlaceholderListener)listener).exitShowDetails(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ShowProposalPlaceholderVisitor ) return ((ShowProposalPlaceholderVisitor<? extends T>)visitor).visitShowDetails(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ShowDetailsContext showDetails() throws RecognitionException {
		ShowDetailsContext _localctx = new ShowDetailsContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_showDetails);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(216);
			attachment();
			setState(217);
			match(NEWLINE);
			setState(218);
			match(NEWLINE);
			setState(219);
			location();
			setState(220);
			match(NEWLINE);
			setState(221);
			date();
			setState(222);
			match(NEWLINE);
			setState(223);
			time();
			setState(224);
			match(NEWLINE);
			setState(225);
			duration();
			setState(226);
			match(NEWLINE);
			setState(227);
			match(NEWLINE);
			setState(228);
			droneList();
			setState(229);
			match(NEWLINE);
			setState(230);
			match(NEWLINE);
			setState(231);
			figureList();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class AttachmentContext extends ParserRuleContext {
		public Attachment_placeholderContext attachment_placeholder() {
			return getRuleContext(Attachment_placeholderContext.class,0);
		}
		public AttachmentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_attachment; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShowProposalPlaceholderListener ) ((ShowProposalPlaceholderListener)listener).enterAttachment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShowProposalPlaceholderListener ) ((ShowProposalPlaceholderListener)listener).exitAttachment(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ShowProposalPlaceholderVisitor ) return ((ShowProposalPlaceholderVisitor<? extends T>)visitor).visitAttachment(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AttachmentContext attachment() throws RecognitionException {
		AttachmentContext _localctx = new AttachmentContext(_ctx, getState());
		enterRule(_localctx, 68, RULE_attachment);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(233);
			attachment_placeholder();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Attachment_placeholderContext extends ParserRuleContext {
		public TerminalNode ATTACHMENT_PLACEHOLDER() { return getToken(ShowProposalPlaceholderParser.ATTACHMENT_PLACEHOLDER, 0); }
		public Attachment_placeholderContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_attachment_placeholder; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShowProposalPlaceholderListener ) ((ShowProposalPlaceholderListener)listener).enterAttachment_placeholder(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShowProposalPlaceholderListener ) ((ShowProposalPlaceholderListener)listener).exitAttachment_placeholder(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ShowProposalPlaceholderVisitor ) return ((ShowProposalPlaceholderVisitor<? extends T>)visitor).visitAttachment_placeholder(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Attachment_placeholderContext attachment_placeholder() throws RecognitionException {
		Attachment_placeholderContext _localctx = new Attachment_placeholderContext(_ctx, getState());
		enterRule(_localctx, 70, RULE_attachment_placeholder);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(235);
			match(ATTACHMENT_PLACEHOLDER);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class LocationContext extends ParserRuleContext {
		public Location_placeholderContext location_placeholder() {
			return getRuleContext(Location_placeholderContext.class,0);
		}
		public LocationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_location; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShowProposalPlaceholderListener ) ((ShowProposalPlaceholderListener)listener).enterLocation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShowProposalPlaceholderListener ) ((ShowProposalPlaceholderListener)listener).exitLocation(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ShowProposalPlaceholderVisitor ) return ((ShowProposalPlaceholderVisitor<? extends T>)visitor).visitLocation(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LocationContext location() throws RecognitionException {
		LocationContext _localctx = new LocationContext(_ctx, getState());
		enterRule(_localctx, 72, RULE_location);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(237);
			location_placeholder();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Location_placeholderContext extends ParserRuleContext {
		public TerminalNode GPS_LINE_PLACEHOLDER() { return getToken(ShowProposalPlaceholderParser.GPS_LINE_PLACEHOLDER, 0); }
		public Location_placeholderContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_location_placeholder; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShowProposalPlaceholderListener ) ((ShowProposalPlaceholderListener)listener).enterLocation_placeholder(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShowProposalPlaceholderListener ) ((ShowProposalPlaceholderListener)listener).exitLocation_placeholder(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ShowProposalPlaceholderVisitor ) return ((ShowProposalPlaceholderVisitor<? extends T>)visitor).visitLocation_placeholder(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Location_placeholderContext location_placeholder() throws RecognitionException {
		Location_placeholderContext _localctx = new Location_placeholderContext(_ctx, getState());
		enterRule(_localctx, 74, RULE_location_placeholder);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(239);
			match(GPS_LINE_PLACEHOLDER);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DateContext extends ParserRuleContext {
		public Date_placeholderContext date_placeholder() {
			return getRuleContext(Date_placeholderContext.class,0);
		}
		public DateContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_date; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShowProposalPlaceholderListener ) ((ShowProposalPlaceholderListener)listener).enterDate(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShowProposalPlaceholderListener ) ((ShowProposalPlaceholderListener)listener).exitDate(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ShowProposalPlaceholderVisitor ) return ((ShowProposalPlaceholderVisitor<? extends T>)visitor).visitDate(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DateContext date() throws RecognitionException {
		DateContext _localctx = new DateContext(_ctx, getState());
		enterRule(_localctx, 76, RULE_date);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(241);
			date_placeholder();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Date_placeholderContext extends ParserRuleContext {
		public TerminalNode SHOW_DATE_PLACEHOLDER_LINE() { return getToken(ShowProposalPlaceholderParser.SHOW_DATE_PLACEHOLDER_LINE, 0); }
		public Date_placeholderContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_date_placeholder; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShowProposalPlaceholderListener ) ((ShowProposalPlaceholderListener)listener).enterDate_placeholder(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShowProposalPlaceholderListener ) ((ShowProposalPlaceholderListener)listener).exitDate_placeholder(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ShowProposalPlaceholderVisitor ) return ((ShowProposalPlaceholderVisitor<? extends T>)visitor).visitDate_placeholder(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Date_placeholderContext date_placeholder() throws RecognitionException {
		Date_placeholderContext _localctx = new Date_placeholderContext(_ctx, getState());
		enterRule(_localctx, 78, RULE_date_placeholder);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(243);
			match(SHOW_DATE_PLACEHOLDER_LINE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TimeContext extends ParserRuleContext {
		public Time_placeholderContext time_placeholder() {
			return getRuleContext(Time_placeholderContext.class,0);
		}
		public TimeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_time; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShowProposalPlaceholderListener ) ((ShowProposalPlaceholderListener)listener).enterTime(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShowProposalPlaceholderListener ) ((ShowProposalPlaceholderListener)listener).exitTime(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ShowProposalPlaceholderVisitor ) return ((ShowProposalPlaceholderVisitor<? extends T>)visitor).visitTime(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TimeContext time() throws RecognitionException {
		TimeContext _localctx = new TimeContext(_ctx, getState());
		enterRule(_localctx, 80, RULE_time);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(245);
			time_placeholder();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Time_placeholderContext extends ParserRuleContext {
		public TerminalNode TIME_PLACEHOLDER_LINE() { return getToken(ShowProposalPlaceholderParser.TIME_PLACEHOLDER_LINE, 0); }
		public Time_placeholderContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_time_placeholder; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShowProposalPlaceholderListener ) ((ShowProposalPlaceholderListener)listener).enterTime_placeholder(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShowProposalPlaceholderListener ) ((ShowProposalPlaceholderListener)listener).exitTime_placeholder(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ShowProposalPlaceholderVisitor ) return ((ShowProposalPlaceholderVisitor<? extends T>)visitor).visitTime_placeholder(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Time_placeholderContext time_placeholder() throws RecognitionException {
		Time_placeholderContext _localctx = new Time_placeholderContext(_ctx, getState());
		enterRule(_localctx, 82, RULE_time_placeholder);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(247);
			match(TIME_PLACEHOLDER_LINE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DurationContext extends ParserRuleContext {
		public Duration_placeholderContext duration_placeholder() {
			return getRuleContext(Duration_placeholderContext.class,0);
		}
		public DurationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_duration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShowProposalPlaceholderListener ) ((ShowProposalPlaceholderListener)listener).enterDuration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShowProposalPlaceholderListener ) ((ShowProposalPlaceholderListener)listener).exitDuration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ShowProposalPlaceholderVisitor ) return ((ShowProposalPlaceholderVisitor<? extends T>)visitor).visitDuration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DurationContext duration() throws RecognitionException {
		DurationContext _localctx = new DurationContext(_ctx, getState());
		enterRule(_localctx, 84, RULE_duration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(249);
			duration_placeholder();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Duration_placeholderContext extends ParserRuleContext {
		public TerminalNode DURATION_PLACEHOLDER_LINE() { return getToken(ShowProposalPlaceholderParser.DURATION_PLACEHOLDER_LINE, 0); }
		public Duration_placeholderContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_duration_placeholder; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShowProposalPlaceholderListener ) ((ShowProposalPlaceholderListener)listener).enterDuration_placeholder(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShowProposalPlaceholderListener ) ((ShowProposalPlaceholderListener)listener).exitDuration_placeholder(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ShowProposalPlaceholderVisitor ) return ((ShowProposalPlaceholderVisitor<? extends T>)visitor).visitDuration_placeholder(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Duration_placeholderContext duration_placeholder() throws RecognitionException {
		Duration_placeholderContext _localctx = new Duration_placeholderContext(_ctx, getState());
		enterRule(_localctx, 86, RULE_duration_placeholder);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(251);
			match(DURATION_PLACEHOLDER_LINE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DroneListContext extends ParserRuleContext {
		public TerminalNode NEWLINE() { return getToken(ShowProposalPlaceholderParser.NEWLINE, 0); }
		public DroneListPlaceholdersContext droneListPlaceholders() {
			return getRuleContext(DroneListPlaceholdersContext.class,0);
		}
		public DroneListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_droneList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShowProposalPlaceholderListener ) ((ShowProposalPlaceholderListener)listener).enterDroneList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShowProposalPlaceholderListener ) ((ShowProposalPlaceholderListener)listener).exitDroneList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ShowProposalPlaceholderVisitor ) return ((ShowProposalPlaceholderVisitor<? extends T>)visitor).visitDroneList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DroneListContext droneList() throws RecognitionException {
		DroneListContext _localctx = new DroneListContext(_ctx, getState());
		enterRule(_localctx, 88, RULE_droneList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(253);
			_la = _input.LA(1);
			if ( !(_la==T__1 || _la==T__2) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(254);
			match(NEWLINE);
			setState(255);
			droneListPlaceholders();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DroneListPlaceholdersContext extends ParserRuleContext {
		public List<TerminalNode> DRONE_ITEM_PLACEHOLDER() { return getTokens(ShowProposalPlaceholderParser.DRONE_ITEM_PLACEHOLDER); }
		public TerminalNode DRONE_ITEM_PLACEHOLDER(int i) {
			return getToken(ShowProposalPlaceholderParser.DRONE_ITEM_PLACEHOLDER, i);
		}
		public List<TerminalNode> NEWLINE() { return getTokens(ShowProposalPlaceholderParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(ShowProposalPlaceholderParser.NEWLINE, i);
		}
		public DroneListPlaceholdersContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_droneListPlaceholders; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShowProposalPlaceholderListener ) ((ShowProposalPlaceholderListener)listener).enterDroneListPlaceholders(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShowProposalPlaceholderListener ) ((ShowProposalPlaceholderListener)listener).exitDroneListPlaceholders(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ShowProposalPlaceholderVisitor ) return ((ShowProposalPlaceholderVisitor<? extends T>)visitor).visitDroneListPlaceholders(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DroneListPlaceholdersContext droneListPlaceholders() throws RecognitionException {
		DroneListPlaceholdersContext _localctx = new DroneListPlaceholdersContext(_ctx, getState());
		enterRule(_localctx, 90, RULE_droneListPlaceholders);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(257);
			match(DRONE_ITEM_PLACEHOLDER);
			setState(262);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(258);
					match(NEWLINE);
					setState(259);
					match(DRONE_ITEM_PLACEHOLDER);
					}
					} 
				}
				setState(264);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class FigureListContext extends ParserRuleContext {
		public TerminalNode NEWLINE() { return getToken(ShowProposalPlaceholderParser.NEWLINE, 0); }
		public FigureListPlaceholderContext figureListPlaceholder() {
			return getRuleContext(FigureListPlaceholderContext.class,0);
		}
		public FigureListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_figureList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShowProposalPlaceholderListener ) ((ShowProposalPlaceholderListener)listener).enterFigureList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShowProposalPlaceholderListener ) ((ShowProposalPlaceholderListener)listener).exitFigureList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ShowProposalPlaceholderVisitor ) return ((ShowProposalPlaceholderVisitor<? extends T>)visitor).visitFigureList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FigureListContext figureList() throws RecognitionException {
		FigureListContext _localctx = new FigureListContext(_ctx, getState());
		enterRule(_localctx, 92, RULE_figureList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(265);
			_la = _input.LA(1);
			if ( !(_la==T__3 || _la==T__4) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(266);
			match(NEWLINE);
			setState(267);
			figureListPlaceholder();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class FigureListPlaceholderContext extends ParserRuleContext {
		public List<TerminalNode> FIGURE_ITEM_PLACEHOLDER() { return getTokens(ShowProposalPlaceholderParser.FIGURE_ITEM_PLACEHOLDER); }
		public TerminalNode FIGURE_ITEM_PLACEHOLDER(int i) {
			return getToken(ShowProposalPlaceholderParser.FIGURE_ITEM_PLACEHOLDER, i);
		}
		public List<TerminalNode> NEWLINE() { return getTokens(ShowProposalPlaceholderParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(ShowProposalPlaceholderParser.NEWLINE, i);
		}
		public FigureListPlaceholderContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_figureListPlaceholder; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShowProposalPlaceholderListener ) ((ShowProposalPlaceholderListener)listener).enterFigureListPlaceholder(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShowProposalPlaceholderListener ) ((ShowProposalPlaceholderListener)listener).exitFigureListPlaceholder(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ShowProposalPlaceholderVisitor ) return ((ShowProposalPlaceholderVisitor<? extends T>)visitor).visitFigureListPlaceholder(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FigureListPlaceholderContext figureListPlaceholder() throws RecognitionException {
		FigureListPlaceholderContext _localctx = new FigureListPlaceholderContext(_ctx, getState());
		enterRule(_localctx, 94, RULE_figureListPlaceholder);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(269);
			match(FIGURE_ITEM_PLACEHOLDER);
			setState(274);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NEWLINE) {
				{
				{
				setState(270);
				match(NEWLINE);
				setState(271);
				match(FIGURE_ITEM_PLACEHOLDER);
				}
				}
				setState(276);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\u0004\u00014\u0116\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007\u0012"+
		"\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002\u0015\u0007\u0015"+
		"\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017\u0002\u0018\u0007\u0018"+
		"\u0002\u0019\u0007\u0019\u0002\u001a\u0007\u001a\u0002\u001b\u0007\u001b"+
		"\u0002\u001c\u0007\u001c\u0002\u001d\u0007\u001d\u0002\u001e\u0007\u001e"+
		"\u0002\u001f\u0007\u001f\u0002 \u0007 \u0002!\u0007!\u0002\"\u0007\"\u0002"+
		"#\u0007#\u0002$\u0007$\u0002%\u0007%\u0002&\u0007&\u0002\'\u0007\'\u0002"+
		"(\u0007(\u0002)\u0007)\u0002*\u0007*\u0002+\u0007+\u0002,\u0007,\u0002"+
		"-\u0007-\u0002.\u0007.\u0002/\u0007/\u0001\u0000\u0001\u0000\u0001\u0000"+
		"\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000"+
		"\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000"+
		"\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0002\u0001\u0002\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0003\u0003~\b\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0004"+
		"\u0001\u0004\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0001\u0007"+
		"\u0001\u0007\u0001\b\u0001\b\u0001\t\u0001\t\u0001\n\u0001\n\u0001\u000b"+
		"\u0001\u000b\u0001\f\u0001\f\u0001\f\u0001\f\u0001\r\u0001\r\u0001\u000e"+
		"\u0001\u000e\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f"+
		"\u0001\u000f\u0001\u0010\u0001\u0010\u0003\u0010\u00a7\b\u0010\u0001\u0011"+
		"\u0001\u0011\u0001\u0012\u0001\u0012\u0001\u0013\u0001\u0013\u0001\u0014"+
		"\u0001\u0014\u0001\u0015\u0001\u0015\u0001\u0016\u0001\u0016\u0001\u0017"+
		"\u0001\u0017\u0001\u0018\u0001\u0018\u0001\u0019\u0001\u0019\u0001\u0019"+
		"\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u0019"+
		"\u0001\u001a\u0001\u001a\u0001\u001b\u0001\u001b\u0001\u001c\u0001\u001c"+
		"\u0001\u001c\u0001\u001c\u0001\u001c\u0001\u001c\u0001\u001c\u0001\u001c"+
		"\u0001\u001c\u0003\u001c\u00cf\b\u001c\u0001\u001d\u0001\u001d\u0001\u001e"+
		"\u0001\u001e\u0001\u001f\u0001\u001f\u0001 \u0001 \u0001!\u0001!\u0001"+
		"!\u0001!\u0001!\u0001!\u0001!\u0001!\u0001!\u0001!\u0001!\u0001!\u0001"+
		"!\u0001!\u0001!\u0001!\u0001!\u0001\"\u0001\"\u0001#\u0001#\u0001$\u0001"+
		"$\u0001%\u0001%\u0001&\u0001&\u0001\'\u0001\'\u0001(\u0001(\u0001)\u0001"+
		")\u0001*\u0001*\u0001+\u0001+\u0001,\u0001,\u0001,\u0001,\u0001-\u0001"+
		"-\u0001-\u0005-\u0105\b-\n-\f-\u0108\t-\u0001.\u0001.\u0001.\u0001.\u0001"+
		"/\u0001/\u0001/\u0005/\u0111\b/\n/\f/\u0114\t/\u0001/\u0000\u00000\u0000"+
		"\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018\u001a\u001c"+
		"\u001e \"$&(*,.02468:<>@BDFHJLNPRTVXZ\\^\u0000\u0002\u0001\u0000\u0002"+
		"\u0003\u0001\u0000\u0004\u0005\u00ea\u0000`\u0001\u0000\u0000\u0000\u0002"+
		"t\u0001\u0000\u0000\u0000\u0004x\u0001\u0000\u0000\u0000\u0006}\u0001"+
		"\u0000\u0000\u0000\b\u0086\u0001\u0000\u0000\u0000\n\u0088\u0001\u0000"+
		"\u0000\u0000\f\u008a\u0001\u0000\u0000\u0000\u000e\u008c\u0001\u0000\u0000"+
		"\u0000\u0010\u008e\u0001\u0000\u0000\u0000\u0012\u0090\u0001\u0000\u0000"+
		"\u0000\u0014\u0092\u0001\u0000\u0000\u0000\u0016\u0094\u0001\u0000\u0000"+
		"\u0000\u0018\u0096\u0001\u0000\u0000\u0000\u001a\u009a\u0001\u0000\u0000"+
		"\u0000\u001c\u009c\u0001\u0000\u0000\u0000\u001e\u009e\u0001\u0000\u0000"+
		"\u0000 \u00a6\u0001\u0000\u0000\u0000\"\u00a8\u0001\u0000\u0000\u0000"+
		"$\u00aa\u0001\u0000\u0000\u0000&\u00ac\u0001\u0000\u0000\u0000(\u00ae"+
		"\u0001\u0000\u0000\u0000*\u00b0\u0001\u0000\u0000\u0000,\u00b2\u0001\u0000"+
		"\u0000\u0000.\u00b4\u0001\u0000\u0000\u00000\u00b6\u0001\u0000\u0000\u0000"+
		"2\u00b8\u0001\u0000\u0000\u00004\u00c1\u0001\u0000\u0000\u00006\u00c3"+
		"\u0001\u0000\u0000\u00008\u00ce\u0001\u0000\u0000\u0000:\u00d0\u0001\u0000"+
		"\u0000\u0000<\u00d2\u0001\u0000\u0000\u0000>\u00d4\u0001\u0000\u0000\u0000"+
		"@\u00d6\u0001\u0000\u0000\u0000B\u00d8\u0001\u0000\u0000\u0000D\u00e9"+
		"\u0001\u0000\u0000\u0000F\u00eb\u0001\u0000\u0000\u0000H\u00ed\u0001\u0000"+
		"\u0000\u0000J\u00ef\u0001\u0000\u0000\u0000L\u00f1\u0001\u0000\u0000\u0000"+
		"N\u00f3\u0001\u0000\u0000\u0000P\u00f5\u0001\u0000\u0000\u0000R\u00f7"+
		"\u0001\u0000\u0000\u0000T\u00f9\u0001\u0000\u0000\u0000V\u00fb\u0001\u0000"+
		"\u0000\u0000X\u00fd\u0001\u0000\u0000\u0000Z\u0101\u0001\u0000\u0000\u0000"+
		"\\\u0109\u0001\u0000\u0000\u0000^\u010d\u0001\u0000\u0000\u0000`a\u0003"+
		"\u0002\u0001\u0000ab\u00054\u0000\u0000bc\u0003\u0018\f\u0000cd\u0005"+
		"4\u0000\u0000de\u00054\u0000\u0000ef\u0003\u001e\u000f\u0000fg\u00054"+
		"\u0000\u0000gh\u00054\u0000\u0000hi\u0003.\u0017\u0000ij\u00054\u0000"+
		"\u0000jk\u00054\u0000\u0000kl\u00032\u0019\u0000lm\u00054\u0000\u0000"+
		"mn\u00054\u0000\u0000no\u00053\u0000\u0000op\u00054\u0000\u0000pq\u0005"+
		"4\u0000\u0000qr\u0003B!\u0000rs\u0005\u0000\u0000\u0001s\u0001\u0001\u0000"+
		"\u0000\u0000tu\u0003\u0004\u0002\u0000uv\u00054\u0000\u0000vw\u0003\u0006"+
		"\u0003\u0000w\u0003\u0001\u0000\u0000\u0000xy\u0005\u0006\u0000\u0000"+
		"y\u0005\u0001\u0000\u0000\u0000z{\u0003\b\u0004\u0000{|\u00054\u0000\u0000"+
		"|~\u0001\u0000\u0000\u0000}z\u0001\u0000\u0000\u0000}~\u0001\u0000\u0000"+
		"\u0000~\u007f\u0001\u0000\u0000\u0000\u007f\u0080\u0003\f\u0006\u0000"+
		"\u0080\u0081\u00054\u0000\u0000\u0081\u0082\u0003\u0010\b\u0000\u0082"+
		"\u0083\u00054\u0000\u0000\u0083\u0084\u0003\u0014\n\u0000\u0084\u0085"+
		"\u00054\u0000\u0000\u0085\u0007\u0001\u0000\u0000\u0000\u0086\u0087\u0003"+
		"\n\u0005\u0000\u0087\t\u0001\u0000\u0000\u0000\u0088\u0089\u0005\u0019"+
		"\u0000\u0000\u0089\u000b\u0001\u0000\u0000\u0000\u008a\u008b\u0003\u000e"+
		"\u0007\u0000\u008b\r\u0001\u0000\u0000\u0000\u008c\u008d\u0005\u001b\u0000"+
		"\u0000\u008d\u000f\u0001\u0000\u0000\u0000\u008e\u008f\u0003\u0012\t\u0000"+
		"\u008f\u0011\u0001\u0000\u0000\u0000\u0090\u0091\u0005\u001c\u0000\u0000"+
		"\u0091\u0013\u0001\u0000\u0000\u0000\u0092\u0093\u0003\u0016\u000b\u0000"+
		"\u0093\u0015\u0001\u0000\u0000\u0000\u0094\u0095\u0005\u001d\u0000\u0000"+
		"\u0095\u0017\u0001\u0000\u0000\u0000\u0096\u0097\u0003\u001a\r\u0000\u0097"+
		"\u0098\u00054\u0000\u0000\u0098\u0099\u0003\u001c\u000e\u0000\u0099\u0019"+
		"\u0001\u0000\u0000\u0000\u009a\u009b\u0005)\u0000\u0000\u009b\u001b\u0001"+
		"\u0000\u0000\u0000\u009c\u009d\u0005\u0007\u0000\u0000\u009d\u001d\u0001"+
		"\u0000\u0000\u0000\u009e\u009f\u0003 \u0010\u0000\u009f\u00a0\u00054\u0000"+
		"\u0000\u00a0\u00a1\u0003(\u0014\u0000\u00a1\u00a2\u00054\u0000\u0000\u00a2"+
		"\u00a3\u0003*\u0015\u0000\u00a3\u001f\u0001\u0000\u0000\u0000\u00a4\u00a7"+
		"\u0003\"\u0011\u0000\u00a5\u00a7\u0003$\u0012\u0000\u00a6\u00a4\u0001"+
		"\u0000\u0000\u0000\u00a6\u00a5\u0001\u0000\u0000\u0000\u00a7!\u0001\u0000"+
		"\u0000\u0000\u00a8\u00a9\u0005\f\u0000\u0000\u00a9#\u0001\u0000\u0000"+
		"\u0000\u00aa\u00ab\u0003&\u0013\u0000\u00ab%\u0001\u0000\u0000\u0000\u00ac"+
		"\u00ad\u0005\r\u0000\u0000\u00ad\'\u0001\u0000\u0000\u0000\u00ae\u00af"+
		"\u0005\u000e\u0000\u0000\u00af)\u0001\u0000\u0000\u0000\u00b0\u00b1\u0003"+
		",\u0016\u0000\u00b1+\u0001\u0000\u0000\u0000\u00b2\u00b3\u0005\u000f\u0000"+
		"\u0000\u00b3-\u0001\u0000\u0000\u0000\u00b4\u00b5\u00030\u0018\u0000\u00b5"+
		"/\u0001\u0000\u0000\u0000\u00b6\u00b7\u0005\u0011\u0000\u0000\u00b71\u0001"+
		"\u0000\u0000\u0000\u00b8\u00b9\u00038\u001c\u0000\u00b9\u00ba\u00054\u0000"+
		"\u0000\u00ba\u00bb\u0003@ \u0000\u00bb\u00bc\u00054\u0000\u0000\u00bc"+
		"\u00bd\u00054\u0000\u0000\u00bd\u00be\u00034\u001a\u0000\u00be\u00bf\u0005"+
		"4\u0000\u0000\u00bf\u00c0\u0005\u0001\u0000\u0000\u00c03\u0001\u0000\u0000"+
		"\u0000\u00c1\u00c2\u00036\u001b\u0000\u00c25\u0001\u0000\u0000\u0000\u00c3"+
		"\u00c4\u0005\u001a\u0000\u0000\u00c47\u0001\u0000\u0000\u0000\u00c5\u00c6"+
		"\u0003:\u001d\u0000\u00c6\u00c7\u00054\u0000\u0000\u00c7\u00c8\u00054"+
		"\u0000\u0000\u00c8\u00c9\u0003<\u001e\u0000\u00c9\u00ca\u00054\u0000\u0000"+
		"\u00ca\u00cf\u0001\u0000\u0000\u0000\u00cb\u00cc\u0003>\u001f\u0000\u00cc"+
		"\u00cd\u00054\u0000\u0000\u00cd\u00cf\u0001\u0000\u0000\u0000\u00ce\u00c5"+
		"\u0001\u0000\u0000\u0000\u00ce\u00cb\u0001\u0000\u0000\u0000\u00cf9\u0001"+
		"\u0000\u0000\u0000\u00d0\u00d1\u0005\b\u0000\u0000\u00d1;\u0001\u0000"+
		"\u0000\u0000\u00d2\u00d3\u0005\t\u0000\u0000\u00d3=\u0001\u0000\u0000"+
		"\u0000\u00d4\u00d5\u0005\n\u0000\u0000\u00d5?\u0001\u0000\u0000\u0000"+
		"\u00d6\u00d7\u0005\u000b\u0000\u0000\u00d7A\u0001\u0000\u0000\u0000\u00d8"+
		"\u00d9\u0003D\"\u0000\u00d9\u00da\u00054\u0000\u0000\u00da\u00db\u0005"+
		"4\u0000\u0000\u00db\u00dc\u0003H$\u0000\u00dc\u00dd\u00054\u0000\u0000"+
		"\u00dd\u00de\u0003L&\u0000\u00de\u00df\u00054\u0000\u0000\u00df\u00e0"+
		"\u0003P(\u0000\u00e0\u00e1\u00054\u0000\u0000\u00e1\u00e2\u0003T*\u0000"+
		"\u00e2\u00e3\u00054\u0000\u0000\u00e3\u00e4\u00054\u0000\u0000\u00e4\u00e5"+
		"\u0003X,\u0000\u00e5\u00e6\u00054\u0000\u0000\u00e6\u00e7\u00054\u0000"+
		"\u0000\u00e7\u00e8\u0003\\.\u0000\u00e8C\u0001\u0000\u0000\u0000\u00e9"+
		"\u00ea\u0003F#\u0000\u00eaE\u0001\u0000\u0000\u0000\u00eb\u00ec\u0005"+
		"&\u0000\u0000\u00ecG\u0001\u0000\u0000\u0000\u00ed\u00ee\u0003J%\u0000"+
		"\u00eeI\u0001\u0000\u0000\u0000\u00ef\u00f0\u0005#\u0000\u0000\u00f0K"+
		"\u0001\u0000\u0000\u0000\u00f1\u00f2\u0003N\'\u0000\u00f2M\u0001\u0000"+
		"\u0000\u0000\u00f3\u00f4\u0005\u0014\u0000\u0000\u00f4O\u0001\u0000\u0000"+
		"\u0000\u00f5\u00f6\u0003R)\u0000\u00f6Q\u0001\u0000\u0000\u0000\u00f7"+
		"\u00f8\u0005-\u0000\u0000\u00f8S\u0001\u0000\u0000\u0000\u00f9\u00fa\u0003"+
		"V+\u0000\u00faU\u0001\u0000\u0000\u0000\u00fb\u00fc\u00051\u0000\u0000"+
		"\u00fcW\u0001\u0000\u0000\u0000\u00fd\u00fe\u0007\u0000\u0000\u0000\u00fe"+
		"\u00ff\u00054\u0000\u0000\u00ff\u0100\u0003Z-\u0000\u0100Y\u0001\u0000"+
		"\u0000\u0000\u0101\u0106\u0005\u001f\u0000\u0000\u0102\u0103\u00054\u0000"+
		"\u0000\u0103\u0105\u0005\u001f\u0000\u0000\u0104\u0102\u0001\u0000\u0000"+
		"\u0000\u0105\u0108\u0001\u0000\u0000\u0000\u0106\u0104\u0001\u0000\u0000"+
		"\u0000\u0106\u0107\u0001\u0000\u0000\u0000\u0107[\u0001\u0000\u0000\u0000"+
		"\u0108\u0106\u0001\u0000\u0000\u0000\u0109\u010a\u0007\u0001\u0000\u0000"+
		"\u010a\u010b\u00054\u0000\u0000\u010b\u010c\u0003^/\u0000\u010c]\u0001"+
		"\u0000\u0000\u0000\u010d\u0112\u0005\u0016\u0000\u0000\u010e\u010f\u0005"+
		"4\u0000\u0000\u010f\u0111\u0005\u0016\u0000\u0000\u0110\u010e\u0001\u0000"+
		"\u0000\u0000\u0111\u0114\u0001\u0000\u0000\u0000\u0112\u0110\u0001\u0000"+
		"\u0000\u0000\u0112\u0113\u0001\u0000\u0000\u0000\u0113_\u0001\u0000\u0000"+
		"\u0000\u0114\u0112\u0001\u0000\u0000\u0000\u0005}\u00a6\u00ce\u0106\u0112";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}