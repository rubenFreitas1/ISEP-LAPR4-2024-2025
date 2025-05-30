// Generated from C:/ISEP-PROJETOS/lapr4_projeto/shodrone.LPROG/src/main/java/antlr/ShowProposal.g4 by ANTLR 4.13.2
package genShowProposal;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;


@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class ShowProposalParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, GREETINGS=6, TITLE_PHRASE=7, PREFEREMCE_PHRASE=8, 
		SUBSCRIBE_PHRASE=9, LAST_PHRASE=10, REGARDS=11, LINE_1_FORMAT=12, REAL_VIP_LINE1=13, 
		VIP_LINE1_PLACEHOLDER=14, LINE_2_FORMAT=15, REAL_LINE3=16, LINE3_PLACEHOLDER=17, 
		LINK_PLACEHOLDER=18, REAL_CLOSING_FORMAT=19, CLOSING_FORMAT_PLACEHOLDER=20, 
		INSURANCE_AMOUNT_PLACEHOLDER=21, SHOW_DATE_FORMAT=22, SHOW_DATE_REAL_LINE=23, 
		SHOW_DATE_PLACEHOLDER_LINE=24, SHOW_DATE_PLACEHOLDER=25, FIGURE_ITEM_REAL=26, 
		FIGURE_ITEM_PLACEHOLDER=27, FIGURE_POSITION_PLACEHOLDER=28, FIGURE_NAME_PLACEHOLDER=29, 
		PERSON_NAME_PLACEHOLDER=30, CRM_MANAGER_PLACEHOLDER=31, COMPANY_PLACEHOLDER=32, 
		ADDRESS_PLACEHOLDER=33, VAT_NUMBER_PLACEHOLDER=34, LINK=35, DRONE_ITEM_FORMAT=36, 
		DRONE_ITEM_REAL=37, DRONE_ITEM_PLACEHOLDER=38, DRONE_MODEL_PLACEHOLDER=39, 
		DRONE_MODEL_QUANTITY_PLACEHOLDER=40, GPS_LINE=41, GPS_LINE_REAL=42, GPS_LINE_PLACEHOLDER=43, 
		GPS_PLACEHOLDER=44, ATTACHMENT_LINE=45, ATTACHMENT_REAL=46, ATTACHMENT_PLACEHOLDER=47, 
		SHOW_PROPOSAL_PLACEHOLDER=48, REFERENCE_LINE=49, REAL_REFERENCE=50, REFERENCE_PLACEHOLDER=51, 
		PROPOSAL_PLACEHOLDER=52, DATE_PLACEHOLDER=53, DATE=54, TIME_LINE=55, TIME_REAL_LINE=56, 
		TIME_PLACEHOLDER_LINE=57, TIME_PLACEHOLDER=58, DURATION_LINE=59, DURATION_MINUTES=60, 
		DURATION_REAL_LINE=61, DURATION_PLACEHOLDER_LINE=62, DURATION_PLACEHOLDER=63, 
		PERSON_NAME=64, VAT_NUMBER=65, WORD=66, PAGE_BREAK=67, NEWLINE=68, WS=69, 
		ADDRESS_LINE=70;
	public static final int
		RULE_proposal = 0, RULE_header = 1, RULE_greeting = 2, RULE_companyInfo = 3, 
		RULE_personName = 4, RULE_realPersonName = 5, RULE_personNamePlaceholder = 6, 
		RULE_company = 7, RULE_realCompanyName = 8, RULE_companyPlaceHolder = 9, 
		RULE_address = 10, RULE_realAddress = 11, RULE_addressPlaceHolder = 12, 
		RULE_vatNumber = 13, RULE_realVatNumber = 14, RULE_vatNumberPlaceHolder = 15, 
		RULE_reference = 16, RULE_realReference = 17, RULE_referencePlaceHolder = 18, 
		RULE_titleProposal = 19, RULE_body = 20, RULE_line_1 = 21, RULE_normal_line1 = 22, 
		RULE_vip_line1 = 23, RULE_real_vip_line1 = 24, RULE_vip_line1_Placeholder = 25, 
		RULE_line_2 = 26, RULE_line_3 = 27, RULE_real_line3 = 28, RULE_line3_placeholder = 29, 
		RULE_closing = 30, RULE_real_closing = 31, RULE_closing_placeholder = 32, 
		RULE_signature = 33, RULE_crmManagerName = 34, RULE_realManagerName = 35, 
		RULE_managerName_Placeholder = 36, RULE_signature_option = 37, RULE_preferencePhrase = 38, 
		RULE_subscribePhrase = 39, RULE_lastPhrase = 40, RULE_regards = 41, RULE_showDetails = 42, 
		RULE_attachment = 43, RULE_real_attachment = 44, RULE_attachment_placeholder = 45, 
		RULE_location = 46, RULE_location_real = 47, RULE_location_placeholder = 48, 
		RULE_date = 49, RULE_date_real = 50, RULE_date_placeholder = 51, RULE_time = 52, 
		RULE_time_real = 53, RULE_time_placeholder = 54, RULE_duration = 55, RULE_duration_real = 56, 
		RULE_duration_placeholder = 57, RULE_droneList = 58, RULE_droneListReal = 59, 
		RULE_droneListPlaceholders = 60, RULE_figureList = 61, RULE_figureListReal = 62, 
		RULE_figureListPlaceholder = 63;
	private static String[] makeRuleNames() {
		return new String[] {
			"proposal", "header", "greeting", "companyInfo", "personName", "realPersonName", 
			"personNamePlaceholder", "company", "realCompanyName", "companyPlaceHolder", 
			"address", "realAddress", "addressPlaceHolder", "vatNumber", "realVatNumber", 
			"vatNumberPlaceHolder", "reference", "realReference", "referencePlaceHolder", 
			"titleProposal", "body", "line_1", "normal_line1", "vip_line1", "real_vip_line1", 
			"vip_line1_Placeholder", "line_2", "line_3", "real_line3", "line3_placeholder", 
			"closing", "real_closing", "closing_placeholder", "signature", "crmManagerName", 
			"realManagerName", "managerName_Placeholder", "signature_option", "preferencePhrase", 
			"subscribePhrase", "lastPhrase", "regards", "showDetails", "attachment", 
			"real_attachment", "attachment_placeholder", "location", "location_real", 
			"location_placeholder", "date", "date_real", "date_placeholder", "time", 
			"time_real", "time_placeholder", "duration", "duration_real", "duration_placeholder", 
			"droneList", "droneListReal", "droneListPlaceholders", "figureList", 
			"figureListReal", "figureListPlaceholder"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'CRM Manager'", "'#List of used drones'", "'#Lista de drones utilizados'", 
			"'#Lista de figuras'", "'#List of figures'", null, null, null, null, 
			"'Looking forward to hearing from you soon.'", null, null, null, null, 
			null, null, null, "'[link to show video]'", null, null, null, null, null, 
			null, "'[date of the event]'", null, null, "'[position in show]'", "'[figure name]'", 
			"'[Customer Representative Name]'", "'[CRM Manager Name]'", null, "'[Address with postal code and country]'", 
			"'[VAT Number]'", null, null, null, null, "'[model]'", "'[quantity]'", 
			null, null, null, "'[GPS coordinates of the location]'", null, null, 
			null, "'[show proposal number]'", null, null, null, "'[proposal number]'", 
			"'[date]'", null, null, null, null, "'[time of the event]'", null, null, 
			null, null, "'[duration]'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, "GREETINGS", "TITLE_PHRASE", "PREFEREMCE_PHRASE", 
			"SUBSCRIBE_PHRASE", "LAST_PHRASE", "REGARDS", "LINE_1_FORMAT", "REAL_VIP_LINE1", 
			"VIP_LINE1_PLACEHOLDER", "LINE_2_FORMAT", "REAL_LINE3", "LINE3_PLACEHOLDER", 
			"LINK_PLACEHOLDER", "REAL_CLOSING_FORMAT", "CLOSING_FORMAT_PLACEHOLDER", 
			"INSURANCE_AMOUNT_PLACEHOLDER", "SHOW_DATE_FORMAT", "SHOW_DATE_REAL_LINE", 
			"SHOW_DATE_PLACEHOLDER_LINE", "SHOW_DATE_PLACEHOLDER", "FIGURE_ITEM_REAL", 
			"FIGURE_ITEM_PLACEHOLDER", "FIGURE_POSITION_PLACEHOLDER", "FIGURE_NAME_PLACEHOLDER", 
			"PERSON_NAME_PLACEHOLDER", "CRM_MANAGER_PLACEHOLDER", "COMPANY_PLACEHOLDER", 
			"ADDRESS_PLACEHOLDER", "VAT_NUMBER_PLACEHOLDER", "LINK", "DRONE_ITEM_FORMAT", 
			"DRONE_ITEM_REAL", "DRONE_ITEM_PLACEHOLDER", "DRONE_MODEL_PLACEHOLDER", 
			"DRONE_MODEL_QUANTITY_PLACEHOLDER", "GPS_LINE", "GPS_LINE_REAL", "GPS_LINE_PLACEHOLDER", 
			"GPS_PLACEHOLDER", "ATTACHMENT_LINE", "ATTACHMENT_REAL", "ATTACHMENT_PLACEHOLDER", 
			"SHOW_PROPOSAL_PLACEHOLDER", "REFERENCE_LINE", "REAL_REFERENCE", "REFERENCE_PLACEHOLDER", 
			"PROPOSAL_PLACEHOLDER", "DATE_PLACEHOLDER", "DATE", "TIME_LINE", "TIME_REAL_LINE", 
			"TIME_PLACEHOLDER_LINE", "TIME_PLACEHOLDER", "DURATION_LINE", "DURATION_MINUTES", 
			"DURATION_REAL_LINE", "DURATION_PLACEHOLDER_LINE", "DURATION_PLACEHOLDER", 
			"PERSON_NAME", "VAT_NUMBER", "WORD", "PAGE_BREAK", "NEWLINE", "WS", "ADDRESS_LINE"
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
	public String getGrammarFileName() { return "ShowProposal.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public ShowProposalParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ProposalContext extends ParserRuleContext {
		public HeaderContext header() {
			return getRuleContext(HeaderContext.class,0);
		}
		public List<TerminalNode> NEWLINE() { return getTokens(ShowProposalParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(ShowProposalParser.NEWLINE, i);
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
		public TerminalNode PAGE_BREAK() { return getToken(ShowProposalParser.PAGE_BREAK, 0); }
		public ShowDetailsContext showDetails() {
			return getRuleContext(ShowDetailsContext.class,0);
		}
		public TerminalNode EOF() { return getToken(ShowProposalParser.EOF, 0); }
		public ProposalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_proposal; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShowProposalListener ) ((ShowProposalListener)listener).enterProposal(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShowProposalListener ) ((ShowProposalListener)listener).exitProposal(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ShowProposalVisitor ) return ((ShowProposalVisitor<? extends T>)visitor).visitProposal(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProposalContext proposal() throws RecognitionException {
		ProposalContext _localctx = new ProposalContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_proposal);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(128);
			header();
			setState(129);
			match(NEWLINE);
			setState(130);
			reference();
			setState(131);
			match(NEWLINE);
			setState(132);
			match(NEWLINE);
			setState(133);
			body();
			setState(134);
			match(NEWLINE);
			setState(135);
			match(NEWLINE);
			setState(136);
			closing();
			setState(137);
			match(NEWLINE);
			setState(138);
			match(NEWLINE);
			setState(139);
			signature();
			setState(140);
			match(NEWLINE);
			setState(141);
			match(NEWLINE);
			setState(142);
			match(PAGE_BREAK);
			setState(143);
			match(NEWLINE);
			setState(144);
			match(NEWLINE);
			setState(145);
			showDetails();
			setState(146);
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
		public TerminalNode NEWLINE() { return getToken(ShowProposalParser.NEWLINE, 0); }
		public CompanyInfoContext companyInfo() {
			return getRuleContext(CompanyInfoContext.class,0);
		}
		public HeaderContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_header; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShowProposalListener ) ((ShowProposalListener)listener).enterHeader(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShowProposalListener ) ((ShowProposalListener)listener).exitHeader(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ShowProposalVisitor ) return ((ShowProposalVisitor<? extends T>)visitor).visitHeader(this);
			else return visitor.visitChildren(this);
		}
	}

	public final HeaderContext header() throws RecognitionException {
		HeaderContext _localctx = new HeaderContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_header);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(148);
			greeting();
			setState(149);
			match(NEWLINE);
			setState(150);
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
		public TerminalNode GREETINGS() { return getToken(ShowProposalParser.GREETINGS, 0); }
		public GreetingContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_greeting; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShowProposalListener ) ((ShowProposalListener)listener).enterGreeting(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShowProposalListener ) ((ShowProposalListener)listener).exitGreeting(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ShowProposalVisitor ) return ((ShowProposalVisitor<? extends T>)visitor).visitGreeting(this);
			else return visitor.visitChildren(this);
		}
	}

	public final GreetingContext greeting() throws RecognitionException {
		GreetingContext _localctx = new GreetingContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_greeting);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(152);
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
		public List<TerminalNode> NEWLINE() { return getTokens(ShowProposalParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(ShowProposalParser.NEWLINE, i);
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
			if ( listener instanceof ShowProposalListener ) ((ShowProposalListener)listener).enterCompanyInfo(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShowProposalListener ) ((ShowProposalListener)listener).exitCompanyInfo(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ShowProposalVisitor ) return ((ShowProposalVisitor<? extends T>)visitor).visitCompanyInfo(this);
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
			setState(157);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==PERSON_NAME_PLACEHOLDER || _la==PERSON_NAME) {
				{
				setState(154);
				personName();
				setState(155);
				match(NEWLINE);
				}
			}

			setState(159);
			company();
			setState(160);
			match(NEWLINE);
			setState(161);
			address();
			setState(162);
			match(NEWLINE);
			setState(163);
			vatNumber();
			setState(164);
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
		public RealPersonNameContext realPersonName() {
			return getRuleContext(RealPersonNameContext.class,0);
		}
		public PersonNamePlaceholderContext personNamePlaceholder() {
			return getRuleContext(PersonNamePlaceholderContext.class,0);
		}
		public PersonNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_personName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShowProposalListener ) ((ShowProposalListener)listener).enterPersonName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShowProposalListener ) ((ShowProposalListener)listener).exitPersonName(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ShowProposalVisitor ) return ((ShowProposalVisitor<? extends T>)visitor).visitPersonName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PersonNameContext personName() throws RecognitionException {
		PersonNameContext _localctx = new PersonNameContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_personName);
		try {
			setState(168);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case PERSON_NAME:
				enterOuterAlt(_localctx, 1);
				{
				setState(166);
				realPersonName();
				}
				break;
			case PERSON_NAME_PLACEHOLDER:
				enterOuterAlt(_localctx, 2);
				{
				setState(167);
				personNamePlaceholder();
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
	public static class RealPersonNameContext extends ParserRuleContext {
		public TerminalNode PERSON_NAME() { return getToken(ShowProposalParser.PERSON_NAME, 0); }
		public RealPersonNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_realPersonName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShowProposalListener ) ((ShowProposalListener)listener).enterRealPersonName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShowProposalListener ) ((ShowProposalListener)listener).exitRealPersonName(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ShowProposalVisitor ) return ((ShowProposalVisitor<? extends T>)visitor).visitRealPersonName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RealPersonNameContext realPersonName() throws RecognitionException {
		RealPersonNameContext _localctx = new RealPersonNameContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_realPersonName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(170);
			match(PERSON_NAME);
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
		public TerminalNode PERSON_NAME_PLACEHOLDER() { return getToken(ShowProposalParser.PERSON_NAME_PLACEHOLDER, 0); }
		public PersonNamePlaceholderContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_personNamePlaceholder; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShowProposalListener ) ((ShowProposalListener)listener).enterPersonNamePlaceholder(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShowProposalListener ) ((ShowProposalListener)listener).exitPersonNamePlaceholder(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ShowProposalVisitor ) return ((ShowProposalVisitor<? extends T>)visitor).visitPersonNamePlaceholder(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PersonNamePlaceholderContext personNamePlaceholder() throws RecognitionException {
		PersonNamePlaceholderContext _localctx = new PersonNamePlaceholderContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_personNamePlaceholder);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(172);
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
		public RealCompanyNameContext realCompanyName() {
			return getRuleContext(RealCompanyNameContext.class,0);
		}
		public CompanyPlaceHolderContext companyPlaceHolder() {
			return getRuleContext(CompanyPlaceHolderContext.class,0);
		}
		public CompanyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_company; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShowProposalListener ) ((ShowProposalListener)listener).enterCompany(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShowProposalListener ) ((ShowProposalListener)listener).exitCompany(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ShowProposalVisitor ) return ((ShowProposalVisitor<? extends T>)visitor).visitCompany(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CompanyContext company() throws RecognitionException {
		CompanyContext _localctx = new CompanyContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_company);
		try {
			setState(176);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case WORD:
				enterOuterAlt(_localctx, 1);
				{
				setState(174);
				realCompanyName();
				}
				break;
			case COMPANY_PLACEHOLDER:
				enterOuterAlt(_localctx, 2);
				{
				setState(175);
				companyPlaceHolder();
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
	public static class RealCompanyNameContext extends ParserRuleContext {
		public TerminalNode WORD() { return getToken(ShowProposalParser.WORD, 0); }
		public RealCompanyNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_realCompanyName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShowProposalListener ) ((ShowProposalListener)listener).enterRealCompanyName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShowProposalListener ) ((ShowProposalListener)listener).exitRealCompanyName(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ShowProposalVisitor ) return ((ShowProposalVisitor<? extends T>)visitor).visitRealCompanyName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RealCompanyNameContext realCompanyName() throws RecognitionException {
		RealCompanyNameContext _localctx = new RealCompanyNameContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_realCompanyName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(178);
			match(WORD);
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
		public TerminalNode COMPANY_PLACEHOLDER() { return getToken(ShowProposalParser.COMPANY_PLACEHOLDER, 0); }
		public CompanyPlaceHolderContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_companyPlaceHolder; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShowProposalListener ) ((ShowProposalListener)listener).enterCompanyPlaceHolder(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShowProposalListener ) ((ShowProposalListener)listener).exitCompanyPlaceHolder(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ShowProposalVisitor ) return ((ShowProposalVisitor<? extends T>)visitor).visitCompanyPlaceHolder(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CompanyPlaceHolderContext companyPlaceHolder() throws RecognitionException {
		CompanyPlaceHolderContext _localctx = new CompanyPlaceHolderContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_companyPlaceHolder);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(180);
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
		public RealAddressContext realAddress() {
			return getRuleContext(RealAddressContext.class,0);
		}
		public AddressPlaceHolderContext addressPlaceHolder() {
			return getRuleContext(AddressPlaceHolderContext.class,0);
		}
		public AddressContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_address; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShowProposalListener ) ((ShowProposalListener)listener).enterAddress(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShowProposalListener ) ((ShowProposalListener)listener).exitAddress(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ShowProposalVisitor ) return ((ShowProposalVisitor<? extends T>)visitor).visitAddress(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AddressContext address() throws RecognitionException {
		AddressContext _localctx = new AddressContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_address);
		try {
			setState(184);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ADDRESS_LINE:
				enterOuterAlt(_localctx, 1);
				{
				setState(182);
				realAddress();
				}
				break;
			case ADDRESS_PLACEHOLDER:
				enterOuterAlt(_localctx, 2);
				{
				setState(183);
				addressPlaceHolder();
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
	public static class RealAddressContext extends ParserRuleContext {
		public TerminalNode ADDRESS_LINE() { return getToken(ShowProposalParser.ADDRESS_LINE, 0); }
		public RealAddressContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_realAddress; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShowProposalListener ) ((ShowProposalListener)listener).enterRealAddress(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShowProposalListener ) ((ShowProposalListener)listener).exitRealAddress(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ShowProposalVisitor ) return ((ShowProposalVisitor<? extends T>)visitor).visitRealAddress(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RealAddressContext realAddress() throws RecognitionException {
		RealAddressContext _localctx = new RealAddressContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_realAddress);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(186);
			match(ADDRESS_LINE);
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
		public TerminalNode ADDRESS_PLACEHOLDER() { return getToken(ShowProposalParser.ADDRESS_PLACEHOLDER, 0); }
		public AddressPlaceHolderContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_addressPlaceHolder; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShowProposalListener ) ((ShowProposalListener)listener).enterAddressPlaceHolder(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShowProposalListener ) ((ShowProposalListener)listener).exitAddressPlaceHolder(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ShowProposalVisitor ) return ((ShowProposalVisitor<? extends T>)visitor).visitAddressPlaceHolder(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AddressPlaceHolderContext addressPlaceHolder() throws RecognitionException {
		AddressPlaceHolderContext _localctx = new AddressPlaceHolderContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_addressPlaceHolder);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(188);
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
		public RealVatNumberContext realVatNumber() {
			return getRuleContext(RealVatNumberContext.class,0);
		}
		public VatNumberPlaceHolderContext vatNumberPlaceHolder() {
			return getRuleContext(VatNumberPlaceHolderContext.class,0);
		}
		public VatNumberContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_vatNumber; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShowProposalListener ) ((ShowProposalListener)listener).enterVatNumber(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShowProposalListener ) ((ShowProposalListener)listener).exitVatNumber(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ShowProposalVisitor ) return ((ShowProposalVisitor<? extends T>)visitor).visitVatNumber(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VatNumberContext vatNumber() throws RecognitionException {
		VatNumberContext _localctx = new VatNumberContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_vatNumber);
		try {
			setState(192);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case VAT_NUMBER:
				enterOuterAlt(_localctx, 1);
				{
				setState(190);
				realVatNumber();
				}
				break;
			case VAT_NUMBER_PLACEHOLDER:
				enterOuterAlt(_localctx, 2);
				{
				setState(191);
				vatNumberPlaceHolder();
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
	public static class RealVatNumberContext extends ParserRuleContext {
		public TerminalNode VAT_NUMBER() { return getToken(ShowProposalParser.VAT_NUMBER, 0); }
		public RealVatNumberContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_realVatNumber; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShowProposalListener ) ((ShowProposalListener)listener).enterRealVatNumber(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShowProposalListener ) ((ShowProposalListener)listener).exitRealVatNumber(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ShowProposalVisitor ) return ((ShowProposalVisitor<? extends T>)visitor).visitRealVatNumber(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RealVatNumberContext realVatNumber() throws RecognitionException {
		RealVatNumberContext _localctx = new RealVatNumberContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_realVatNumber);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(194);
			match(VAT_NUMBER);
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
		public TerminalNode VAT_NUMBER_PLACEHOLDER() { return getToken(ShowProposalParser.VAT_NUMBER_PLACEHOLDER, 0); }
		public VatNumberPlaceHolderContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_vatNumberPlaceHolder; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShowProposalListener ) ((ShowProposalListener)listener).enterVatNumberPlaceHolder(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShowProposalListener ) ((ShowProposalListener)listener).exitVatNumberPlaceHolder(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ShowProposalVisitor ) return ((ShowProposalVisitor<? extends T>)visitor).visitVatNumberPlaceHolder(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VatNumberPlaceHolderContext vatNumberPlaceHolder() throws RecognitionException {
		VatNumberPlaceHolderContext _localctx = new VatNumberPlaceHolderContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_vatNumberPlaceHolder);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(196);
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
		public TerminalNode NEWLINE() { return getToken(ShowProposalParser.NEWLINE, 0); }
		public TitleProposalContext titleProposal() {
			return getRuleContext(TitleProposalContext.class,0);
		}
		public RealReferenceContext realReference() {
			return getRuleContext(RealReferenceContext.class,0);
		}
		public ReferencePlaceHolderContext referencePlaceHolder() {
			return getRuleContext(ReferencePlaceHolderContext.class,0);
		}
		public ReferenceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_reference; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShowProposalListener ) ((ShowProposalListener)listener).enterReference(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShowProposalListener ) ((ShowProposalListener)listener).exitReference(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ShowProposalVisitor ) return ((ShowProposalVisitor<? extends T>)visitor).visitReference(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ReferenceContext reference() throws RecognitionException {
		ReferenceContext _localctx = new ReferenceContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_reference);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(200);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case REAL_REFERENCE:
				{
				setState(198);
				realReference();
				}
				break;
			case REFERENCE_PLACEHOLDER:
				{
				setState(199);
				referencePlaceHolder();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(202);
			match(NEWLINE);
			setState(203);
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
	public static class RealReferenceContext extends ParserRuleContext {
		public TerminalNode REAL_REFERENCE() { return getToken(ShowProposalParser.REAL_REFERENCE, 0); }
		public RealReferenceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_realReference; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShowProposalListener ) ((ShowProposalListener)listener).enterRealReference(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShowProposalListener ) ((ShowProposalListener)listener).exitRealReference(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ShowProposalVisitor ) return ((ShowProposalVisitor<? extends T>)visitor).visitRealReference(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RealReferenceContext realReference() throws RecognitionException {
		RealReferenceContext _localctx = new RealReferenceContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_realReference);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(205);
			match(REAL_REFERENCE);
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
		public TerminalNode REFERENCE_PLACEHOLDER() { return getToken(ShowProposalParser.REFERENCE_PLACEHOLDER, 0); }
		public ReferencePlaceHolderContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_referencePlaceHolder; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShowProposalListener ) ((ShowProposalListener)listener).enterReferencePlaceHolder(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShowProposalListener ) ((ShowProposalListener)listener).exitReferencePlaceHolder(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ShowProposalVisitor ) return ((ShowProposalVisitor<? extends T>)visitor).visitReferencePlaceHolder(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ReferencePlaceHolderContext referencePlaceHolder() throws RecognitionException {
		ReferencePlaceHolderContext _localctx = new ReferencePlaceHolderContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_referencePlaceHolder);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(207);
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
		public TerminalNode TITLE_PHRASE() { return getToken(ShowProposalParser.TITLE_PHRASE, 0); }
		public TitleProposalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_titleProposal; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShowProposalListener ) ((ShowProposalListener)listener).enterTitleProposal(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShowProposalListener ) ((ShowProposalListener)listener).exitTitleProposal(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ShowProposalVisitor ) return ((ShowProposalVisitor<? extends T>)visitor).visitTitleProposal(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TitleProposalContext titleProposal() throws RecognitionException {
		TitleProposalContext _localctx = new TitleProposalContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_titleProposal);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(209);
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
		public List<TerminalNode> NEWLINE() { return getTokens(ShowProposalParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(ShowProposalParser.NEWLINE, i);
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
			if ( listener instanceof ShowProposalListener ) ((ShowProposalListener)listener).enterBody(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShowProposalListener ) ((ShowProposalListener)listener).exitBody(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ShowProposalVisitor ) return ((ShowProposalVisitor<? extends T>)visitor).visitBody(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BodyContext body() throws RecognitionException {
		BodyContext _localctx = new BodyContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_body);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(211);
			line_1();
			setState(212);
			match(NEWLINE);
			setState(213);
			line_2();
			setState(214);
			match(NEWLINE);
			setState(215);
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
			if ( listener instanceof ShowProposalListener ) ((ShowProposalListener)listener).enterLine_1(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShowProposalListener ) ((ShowProposalListener)listener).exitLine_1(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ShowProposalVisitor ) return ((ShowProposalVisitor<? extends T>)visitor).visitLine_1(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Line_1Context line_1() throws RecognitionException {
		Line_1Context _localctx = new Line_1Context(_ctx, getState());
		enterRule(_localctx, 42, RULE_line_1);
		try {
			setState(219);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LINE_1_FORMAT:
				enterOuterAlt(_localctx, 1);
				{
				setState(217);
				normal_line1();
				}
				break;
			case REAL_VIP_LINE1:
			case VIP_LINE1_PLACEHOLDER:
				enterOuterAlt(_localctx, 2);
				{
				setState(218);
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
		public TerminalNode LINE_1_FORMAT() { return getToken(ShowProposalParser.LINE_1_FORMAT, 0); }
		public Normal_line1Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_normal_line1; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShowProposalListener ) ((ShowProposalListener)listener).enterNormal_line1(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShowProposalListener ) ((ShowProposalListener)listener).exitNormal_line1(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ShowProposalVisitor ) return ((ShowProposalVisitor<? extends T>)visitor).visitNormal_line1(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Normal_line1Context normal_line1() throws RecognitionException {
		Normal_line1Context _localctx = new Normal_line1Context(_ctx, getState());
		enterRule(_localctx, 44, RULE_normal_line1);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(221);
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
		public Real_vip_line1Context real_vip_line1() {
			return getRuleContext(Real_vip_line1Context.class,0);
		}
		public Vip_line1_PlaceholderContext vip_line1_Placeholder() {
			return getRuleContext(Vip_line1_PlaceholderContext.class,0);
		}
		public Vip_line1Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_vip_line1; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShowProposalListener ) ((ShowProposalListener)listener).enterVip_line1(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShowProposalListener ) ((ShowProposalListener)listener).exitVip_line1(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ShowProposalVisitor ) return ((ShowProposalVisitor<? extends T>)visitor).visitVip_line1(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Vip_line1Context vip_line1() throws RecognitionException {
		Vip_line1Context _localctx = new Vip_line1Context(_ctx, getState());
		enterRule(_localctx, 46, RULE_vip_line1);
		try {
			setState(225);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case REAL_VIP_LINE1:
				enterOuterAlt(_localctx, 1);
				{
				setState(223);
				real_vip_line1();
				}
				break;
			case VIP_LINE1_PLACEHOLDER:
				enterOuterAlt(_localctx, 2);
				{
				setState(224);
				vip_line1_Placeholder();
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
	public static class Real_vip_line1Context extends ParserRuleContext {
		public TerminalNode REAL_VIP_LINE1() { return getToken(ShowProposalParser.REAL_VIP_LINE1, 0); }
		public Real_vip_line1Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_real_vip_line1; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShowProposalListener ) ((ShowProposalListener)listener).enterReal_vip_line1(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShowProposalListener ) ((ShowProposalListener)listener).exitReal_vip_line1(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ShowProposalVisitor ) return ((ShowProposalVisitor<? extends T>)visitor).visitReal_vip_line1(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Real_vip_line1Context real_vip_line1() throws RecognitionException {
		Real_vip_line1Context _localctx = new Real_vip_line1Context(_ctx, getState());
		enterRule(_localctx, 48, RULE_real_vip_line1);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(227);
			match(REAL_VIP_LINE1);
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
		public TerminalNode VIP_LINE1_PLACEHOLDER() { return getToken(ShowProposalParser.VIP_LINE1_PLACEHOLDER, 0); }
		public Vip_line1_PlaceholderContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_vip_line1_Placeholder; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShowProposalListener ) ((ShowProposalListener)listener).enterVip_line1_Placeholder(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShowProposalListener ) ((ShowProposalListener)listener).exitVip_line1_Placeholder(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ShowProposalVisitor ) return ((ShowProposalVisitor<? extends T>)visitor).visitVip_line1_Placeholder(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Vip_line1_PlaceholderContext vip_line1_Placeholder() throws RecognitionException {
		Vip_line1_PlaceholderContext _localctx = new Vip_line1_PlaceholderContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_vip_line1_Placeholder);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(229);
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
		public TerminalNode LINE_2_FORMAT() { return getToken(ShowProposalParser.LINE_2_FORMAT, 0); }
		public Line_2Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_line_2; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShowProposalListener ) ((ShowProposalListener)listener).enterLine_2(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShowProposalListener ) ((ShowProposalListener)listener).exitLine_2(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ShowProposalVisitor ) return ((ShowProposalVisitor<? extends T>)visitor).visitLine_2(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Line_2Context line_2() throws RecognitionException {
		Line_2Context _localctx = new Line_2Context(_ctx, getState());
		enterRule(_localctx, 52, RULE_line_2);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(231);
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
		public Real_line3Context real_line3() {
			return getRuleContext(Real_line3Context.class,0);
		}
		public Line3_placeholderContext line3_placeholder() {
			return getRuleContext(Line3_placeholderContext.class,0);
		}
		public Line_3Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_line_3; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShowProposalListener ) ((ShowProposalListener)listener).enterLine_3(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShowProposalListener ) ((ShowProposalListener)listener).exitLine_3(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ShowProposalVisitor ) return ((ShowProposalVisitor<? extends T>)visitor).visitLine_3(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Line_3Context line_3() throws RecognitionException {
		Line_3Context _localctx = new Line_3Context(_ctx, getState());
		enterRule(_localctx, 54, RULE_line_3);
		try {
			setState(235);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case REAL_LINE3:
				enterOuterAlt(_localctx, 1);
				{
				setState(233);
				real_line3();
				}
				break;
			case LINE3_PLACEHOLDER:
				enterOuterAlt(_localctx, 2);
				{
				setState(234);
				line3_placeholder();
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
	public static class Real_line3Context extends ParserRuleContext {
		public TerminalNode REAL_LINE3() { return getToken(ShowProposalParser.REAL_LINE3, 0); }
		public Real_line3Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_real_line3; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShowProposalListener ) ((ShowProposalListener)listener).enterReal_line3(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShowProposalListener ) ((ShowProposalListener)listener).exitReal_line3(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ShowProposalVisitor ) return ((ShowProposalVisitor<? extends T>)visitor).visitReal_line3(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Real_line3Context real_line3() throws RecognitionException {
		Real_line3Context _localctx = new Real_line3Context(_ctx, getState());
		enterRule(_localctx, 56, RULE_real_line3);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(237);
			match(REAL_LINE3);
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
		public TerminalNode LINE3_PLACEHOLDER() { return getToken(ShowProposalParser.LINE3_PLACEHOLDER, 0); }
		public Line3_placeholderContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_line3_placeholder; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShowProposalListener ) ((ShowProposalListener)listener).enterLine3_placeholder(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShowProposalListener ) ((ShowProposalListener)listener).exitLine3_placeholder(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ShowProposalVisitor ) return ((ShowProposalVisitor<? extends T>)visitor).visitLine3_placeholder(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Line3_placeholderContext line3_placeholder() throws RecognitionException {
		Line3_placeholderContext _localctx = new Line3_placeholderContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_line3_placeholder);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(239);
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
		public Real_closingContext real_closing() {
			return getRuleContext(Real_closingContext.class,0);
		}
		public Closing_placeholderContext closing_placeholder() {
			return getRuleContext(Closing_placeholderContext.class,0);
		}
		public ClosingContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_closing; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShowProposalListener ) ((ShowProposalListener)listener).enterClosing(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShowProposalListener ) ((ShowProposalListener)listener).exitClosing(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ShowProposalVisitor ) return ((ShowProposalVisitor<? extends T>)visitor).visitClosing(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ClosingContext closing() throws RecognitionException {
		ClosingContext _localctx = new ClosingContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_closing);
		try {
			setState(243);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case REAL_CLOSING_FORMAT:
				enterOuterAlt(_localctx, 1);
				{
				setState(241);
				real_closing();
				}
				break;
			case CLOSING_FORMAT_PLACEHOLDER:
				enterOuterAlt(_localctx, 2);
				{
				setState(242);
				closing_placeholder();
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
	public static class Real_closingContext extends ParserRuleContext {
		public TerminalNode REAL_CLOSING_FORMAT() { return getToken(ShowProposalParser.REAL_CLOSING_FORMAT, 0); }
		public Real_closingContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_real_closing; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShowProposalListener ) ((ShowProposalListener)listener).enterReal_closing(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShowProposalListener ) ((ShowProposalListener)listener).exitReal_closing(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ShowProposalVisitor ) return ((ShowProposalVisitor<? extends T>)visitor).visitReal_closing(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Real_closingContext real_closing() throws RecognitionException {
		Real_closingContext _localctx = new Real_closingContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_real_closing);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(245);
			match(REAL_CLOSING_FORMAT);
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
		public TerminalNode CLOSING_FORMAT_PLACEHOLDER() { return getToken(ShowProposalParser.CLOSING_FORMAT_PLACEHOLDER, 0); }
		public Closing_placeholderContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_closing_placeholder; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShowProposalListener ) ((ShowProposalListener)listener).enterClosing_placeholder(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShowProposalListener ) ((ShowProposalListener)listener).exitClosing_placeholder(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ShowProposalVisitor ) return ((ShowProposalVisitor<? extends T>)visitor).visitClosing_placeholder(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Closing_placeholderContext closing_placeholder() throws RecognitionException {
		Closing_placeholderContext _localctx = new Closing_placeholderContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_closing_placeholder);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(247);
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
		public List<TerminalNode> NEWLINE() { return getTokens(ShowProposalParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(ShowProposalParser.NEWLINE, i);
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
			if ( listener instanceof ShowProposalListener ) ((ShowProposalListener)listener).enterSignature(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShowProposalListener ) ((ShowProposalListener)listener).exitSignature(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ShowProposalVisitor ) return ((ShowProposalVisitor<? extends T>)visitor).visitSignature(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SignatureContext signature() throws RecognitionException {
		SignatureContext _localctx = new SignatureContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_signature);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(249);
			signature_option();
			setState(250);
			match(NEWLINE);
			setState(251);
			regards();
			setState(252);
			match(NEWLINE);
			setState(253);
			match(NEWLINE);
			setState(254);
			crmManagerName();
			setState(255);
			match(NEWLINE);
			setState(256);
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
		public RealManagerNameContext realManagerName() {
			return getRuleContext(RealManagerNameContext.class,0);
		}
		public ManagerName_PlaceholderContext managerName_Placeholder() {
			return getRuleContext(ManagerName_PlaceholderContext.class,0);
		}
		public CrmManagerNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_crmManagerName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShowProposalListener ) ((ShowProposalListener)listener).enterCrmManagerName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShowProposalListener ) ((ShowProposalListener)listener).exitCrmManagerName(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ShowProposalVisitor ) return ((ShowProposalVisitor<? extends T>)visitor).visitCrmManagerName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CrmManagerNameContext crmManagerName() throws RecognitionException {
		CrmManagerNameContext _localctx = new CrmManagerNameContext(_ctx, getState());
		enterRule(_localctx, 68, RULE_crmManagerName);
		try {
			setState(260);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case PERSON_NAME:
				enterOuterAlt(_localctx, 1);
				{
				setState(258);
				realManagerName();
				}
				break;
			case CRM_MANAGER_PLACEHOLDER:
				enterOuterAlt(_localctx, 2);
				{
				setState(259);
				managerName_Placeholder();
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
	public static class RealManagerNameContext extends ParserRuleContext {
		public TerminalNode PERSON_NAME() { return getToken(ShowProposalParser.PERSON_NAME, 0); }
		public RealManagerNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_realManagerName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShowProposalListener ) ((ShowProposalListener)listener).enterRealManagerName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShowProposalListener ) ((ShowProposalListener)listener).exitRealManagerName(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ShowProposalVisitor ) return ((ShowProposalVisitor<? extends T>)visitor).visitRealManagerName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RealManagerNameContext realManagerName() throws RecognitionException {
		RealManagerNameContext _localctx = new RealManagerNameContext(_ctx, getState());
		enterRule(_localctx, 70, RULE_realManagerName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(262);
			match(PERSON_NAME);
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
		public TerminalNode CRM_MANAGER_PLACEHOLDER() { return getToken(ShowProposalParser.CRM_MANAGER_PLACEHOLDER, 0); }
		public ManagerName_PlaceholderContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_managerName_Placeholder; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShowProposalListener ) ((ShowProposalListener)listener).enterManagerName_Placeholder(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShowProposalListener ) ((ShowProposalListener)listener).exitManagerName_Placeholder(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ShowProposalVisitor ) return ((ShowProposalVisitor<? extends T>)visitor).visitManagerName_Placeholder(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ManagerName_PlaceholderContext managerName_Placeholder() throws RecognitionException {
		ManagerName_PlaceholderContext _localctx = new ManagerName_PlaceholderContext(_ctx, getState());
		enterRule(_localctx, 72, RULE_managerName_Placeholder);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(264);
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
		public List<TerminalNode> NEWLINE() { return getTokens(ShowProposalParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(ShowProposalParser.NEWLINE, i);
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
			if ( listener instanceof ShowProposalListener ) ((ShowProposalListener)listener).enterSignature_option(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShowProposalListener ) ((ShowProposalListener)listener).exitSignature_option(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ShowProposalVisitor ) return ((ShowProposalVisitor<? extends T>)visitor).visitSignature_option(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Signature_optionContext signature_option() throws RecognitionException {
		Signature_optionContext _localctx = new Signature_optionContext(_ctx, getState());
		enterRule(_localctx, 74, RULE_signature_option);
		try {
			setState(275);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case PREFEREMCE_PHRASE:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(266);
				preferencePhrase();
				setState(267);
				match(NEWLINE);
				setState(268);
				match(NEWLINE);
				setState(269);
				subscribePhrase();
				setState(270);
				match(NEWLINE);
				}
				}
				break;
			case LAST_PHRASE:
				enterOuterAlt(_localctx, 2);
				{
				setState(272);
				lastPhrase();
				setState(273);
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
		public TerminalNode PREFEREMCE_PHRASE() { return getToken(ShowProposalParser.PREFEREMCE_PHRASE, 0); }
		public PreferencePhraseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_preferencePhrase; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShowProposalListener ) ((ShowProposalListener)listener).enterPreferencePhrase(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShowProposalListener ) ((ShowProposalListener)listener).exitPreferencePhrase(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ShowProposalVisitor ) return ((ShowProposalVisitor<? extends T>)visitor).visitPreferencePhrase(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PreferencePhraseContext preferencePhrase() throws RecognitionException {
		PreferencePhraseContext _localctx = new PreferencePhraseContext(_ctx, getState());
		enterRule(_localctx, 76, RULE_preferencePhrase);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(277);
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
		public TerminalNode SUBSCRIBE_PHRASE() { return getToken(ShowProposalParser.SUBSCRIBE_PHRASE, 0); }
		public SubscribePhraseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_subscribePhrase; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShowProposalListener ) ((ShowProposalListener)listener).enterSubscribePhrase(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShowProposalListener ) ((ShowProposalListener)listener).exitSubscribePhrase(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ShowProposalVisitor ) return ((ShowProposalVisitor<? extends T>)visitor).visitSubscribePhrase(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SubscribePhraseContext subscribePhrase() throws RecognitionException {
		SubscribePhraseContext _localctx = new SubscribePhraseContext(_ctx, getState());
		enterRule(_localctx, 78, RULE_subscribePhrase);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(279);
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
		public TerminalNode LAST_PHRASE() { return getToken(ShowProposalParser.LAST_PHRASE, 0); }
		public LastPhraseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lastPhrase; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShowProposalListener ) ((ShowProposalListener)listener).enterLastPhrase(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShowProposalListener ) ((ShowProposalListener)listener).exitLastPhrase(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ShowProposalVisitor ) return ((ShowProposalVisitor<? extends T>)visitor).visitLastPhrase(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LastPhraseContext lastPhrase() throws RecognitionException {
		LastPhraseContext _localctx = new LastPhraseContext(_ctx, getState());
		enterRule(_localctx, 80, RULE_lastPhrase);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(281);
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
		public TerminalNode REGARDS() { return getToken(ShowProposalParser.REGARDS, 0); }
		public RegardsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_regards; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShowProposalListener ) ((ShowProposalListener)listener).enterRegards(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShowProposalListener ) ((ShowProposalListener)listener).exitRegards(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ShowProposalVisitor ) return ((ShowProposalVisitor<? extends T>)visitor).visitRegards(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RegardsContext regards() throws RecognitionException {
		RegardsContext _localctx = new RegardsContext(_ctx, getState());
		enterRule(_localctx, 82, RULE_regards);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(283);
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
		public List<TerminalNode> NEWLINE() { return getTokens(ShowProposalParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(ShowProposalParser.NEWLINE, i);
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
			if ( listener instanceof ShowProposalListener ) ((ShowProposalListener)listener).enterShowDetails(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShowProposalListener ) ((ShowProposalListener)listener).exitShowDetails(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ShowProposalVisitor ) return ((ShowProposalVisitor<? extends T>)visitor).visitShowDetails(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ShowDetailsContext showDetails() throws RecognitionException {
		ShowDetailsContext _localctx = new ShowDetailsContext(_ctx, getState());
		enterRule(_localctx, 84, RULE_showDetails);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(285);
			attachment();
			setState(286);
			match(NEWLINE);
			setState(287);
			match(NEWLINE);
			setState(288);
			location();
			setState(289);
			match(NEWLINE);
			setState(290);
			date();
			setState(291);
			match(NEWLINE);
			setState(292);
			time();
			setState(293);
			match(NEWLINE);
			setState(294);
			duration();
			setState(295);
			match(NEWLINE);
			setState(296);
			match(NEWLINE);
			setState(297);
			droneList();
			setState(298);
			match(NEWLINE);
			setState(299);
			match(NEWLINE);
			setState(300);
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
		public Real_attachmentContext real_attachment() {
			return getRuleContext(Real_attachmentContext.class,0);
		}
		public Attachment_placeholderContext attachment_placeholder() {
			return getRuleContext(Attachment_placeholderContext.class,0);
		}
		public AttachmentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_attachment; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShowProposalListener ) ((ShowProposalListener)listener).enterAttachment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShowProposalListener ) ((ShowProposalListener)listener).exitAttachment(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ShowProposalVisitor ) return ((ShowProposalVisitor<? extends T>)visitor).visitAttachment(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AttachmentContext attachment() throws RecognitionException {
		AttachmentContext _localctx = new AttachmentContext(_ctx, getState());
		enterRule(_localctx, 86, RULE_attachment);
		try {
			setState(304);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ATTACHMENT_REAL:
				enterOuterAlt(_localctx, 1);
				{
				setState(302);
				real_attachment();
				}
				break;
			case ATTACHMENT_PLACEHOLDER:
				enterOuterAlt(_localctx, 2);
				{
				setState(303);
				attachment_placeholder();
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
	public static class Real_attachmentContext extends ParserRuleContext {
		public TerminalNode ATTACHMENT_REAL() { return getToken(ShowProposalParser.ATTACHMENT_REAL, 0); }
		public Real_attachmentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_real_attachment; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShowProposalListener ) ((ShowProposalListener)listener).enterReal_attachment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShowProposalListener ) ((ShowProposalListener)listener).exitReal_attachment(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ShowProposalVisitor ) return ((ShowProposalVisitor<? extends T>)visitor).visitReal_attachment(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Real_attachmentContext real_attachment() throws RecognitionException {
		Real_attachmentContext _localctx = new Real_attachmentContext(_ctx, getState());
		enterRule(_localctx, 88, RULE_real_attachment);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(306);
			match(ATTACHMENT_REAL);
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
		public TerminalNode ATTACHMENT_PLACEHOLDER() { return getToken(ShowProposalParser.ATTACHMENT_PLACEHOLDER, 0); }
		public Attachment_placeholderContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_attachment_placeholder; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShowProposalListener ) ((ShowProposalListener)listener).enterAttachment_placeholder(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShowProposalListener ) ((ShowProposalListener)listener).exitAttachment_placeholder(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ShowProposalVisitor ) return ((ShowProposalVisitor<? extends T>)visitor).visitAttachment_placeholder(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Attachment_placeholderContext attachment_placeholder() throws RecognitionException {
		Attachment_placeholderContext _localctx = new Attachment_placeholderContext(_ctx, getState());
		enterRule(_localctx, 90, RULE_attachment_placeholder);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(308);
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
		public Location_realContext location_real() {
			return getRuleContext(Location_realContext.class,0);
		}
		public Location_placeholderContext location_placeholder() {
			return getRuleContext(Location_placeholderContext.class,0);
		}
		public LocationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_location; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShowProposalListener ) ((ShowProposalListener)listener).enterLocation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShowProposalListener ) ((ShowProposalListener)listener).exitLocation(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ShowProposalVisitor ) return ((ShowProposalVisitor<? extends T>)visitor).visitLocation(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LocationContext location() throws RecognitionException {
		LocationContext _localctx = new LocationContext(_ctx, getState());
		enterRule(_localctx, 92, RULE_location);
		try {
			setState(312);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case GPS_LINE_REAL:
				enterOuterAlt(_localctx, 1);
				{
				setState(310);
				location_real();
				}
				break;
			case GPS_LINE_PLACEHOLDER:
				enterOuterAlt(_localctx, 2);
				{
				setState(311);
				location_placeholder();
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
	public static class Location_realContext extends ParserRuleContext {
		public TerminalNode GPS_LINE_REAL() { return getToken(ShowProposalParser.GPS_LINE_REAL, 0); }
		public Location_realContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_location_real; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShowProposalListener ) ((ShowProposalListener)listener).enterLocation_real(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShowProposalListener ) ((ShowProposalListener)listener).exitLocation_real(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ShowProposalVisitor ) return ((ShowProposalVisitor<? extends T>)visitor).visitLocation_real(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Location_realContext location_real() throws RecognitionException {
		Location_realContext _localctx = new Location_realContext(_ctx, getState());
		enterRule(_localctx, 94, RULE_location_real);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(314);
			match(GPS_LINE_REAL);
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
		public TerminalNode GPS_LINE_PLACEHOLDER() { return getToken(ShowProposalParser.GPS_LINE_PLACEHOLDER, 0); }
		public Location_placeholderContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_location_placeholder; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShowProposalListener ) ((ShowProposalListener)listener).enterLocation_placeholder(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShowProposalListener ) ((ShowProposalListener)listener).exitLocation_placeholder(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ShowProposalVisitor ) return ((ShowProposalVisitor<? extends T>)visitor).visitLocation_placeholder(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Location_placeholderContext location_placeholder() throws RecognitionException {
		Location_placeholderContext _localctx = new Location_placeholderContext(_ctx, getState());
		enterRule(_localctx, 96, RULE_location_placeholder);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(316);
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
		public Date_realContext date_real() {
			return getRuleContext(Date_realContext.class,0);
		}
		public Date_placeholderContext date_placeholder() {
			return getRuleContext(Date_placeholderContext.class,0);
		}
		public DateContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_date; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShowProposalListener ) ((ShowProposalListener)listener).enterDate(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShowProposalListener ) ((ShowProposalListener)listener).exitDate(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ShowProposalVisitor ) return ((ShowProposalVisitor<? extends T>)visitor).visitDate(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DateContext date() throws RecognitionException {
		DateContext _localctx = new DateContext(_ctx, getState());
		enterRule(_localctx, 98, RULE_date);
		try {
			setState(320);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case SHOW_DATE_REAL_LINE:
				enterOuterAlt(_localctx, 1);
				{
				setState(318);
				date_real();
				}
				break;
			case SHOW_DATE_PLACEHOLDER_LINE:
				enterOuterAlt(_localctx, 2);
				{
				setState(319);
				date_placeholder();
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
	public static class Date_realContext extends ParserRuleContext {
		public TerminalNode SHOW_DATE_REAL_LINE() { return getToken(ShowProposalParser.SHOW_DATE_REAL_LINE, 0); }
		public Date_realContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_date_real; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShowProposalListener ) ((ShowProposalListener)listener).enterDate_real(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShowProposalListener ) ((ShowProposalListener)listener).exitDate_real(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ShowProposalVisitor ) return ((ShowProposalVisitor<? extends T>)visitor).visitDate_real(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Date_realContext date_real() throws RecognitionException {
		Date_realContext _localctx = new Date_realContext(_ctx, getState());
		enterRule(_localctx, 100, RULE_date_real);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(322);
			match(SHOW_DATE_REAL_LINE);
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
		public TerminalNode SHOW_DATE_PLACEHOLDER_LINE() { return getToken(ShowProposalParser.SHOW_DATE_PLACEHOLDER_LINE, 0); }
		public Date_placeholderContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_date_placeholder; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShowProposalListener ) ((ShowProposalListener)listener).enterDate_placeholder(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShowProposalListener ) ((ShowProposalListener)listener).exitDate_placeholder(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ShowProposalVisitor ) return ((ShowProposalVisitor<? extends T>)visitor).visitDate_placeholder(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Date_placeholderContext date_placeholder() throws RecognitionException {
		Date_placeholderContext _localctx = new Date_placeholderContext(_ctx, getState());
		enterRule(_localctx, 102, RULE_date_placeholder);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(324);
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
		public Time_realContext time_real() {
			return getRuleContext(Time_realContext.class,0);
		}
		public Time_placeholderContext time_placeholder() {
			return getRuleContext(Time_placeholderContext.class,0);
		}
		public TimeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_time; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShowProposalListener ) ((ShowProposalListener)listener).enterTime(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShowProposalListener ) ((ShowProposalListener)listener).exitTime(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ShowProposalVisitor ) return ((ShowProposalVisitor<? extends T>)visitor).visitTime(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TimeContext time() throws RecognitionException {
		TimeContext _localctx = new TimeContext(_ctx, getState());
		enterRule(_localctx, 104, RULE_time);
		try {
			setState(328);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case TIME_REAL_LINE:
				enterOuterAlt(_localctx, 1);
				{
				setState(326);
				time_real();
				}
				break;
			case TIME_PLACEHOLDER_LINE:
				enterOuterAlt(_localctx, 2);
				{
				setState(327);
				time_placeholder();
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
	public static class Time_realContext extends ParserRuleContext {
		public TerminalNode TIME_REAL_LINE() { return getToken(ShowProposalParser.TIME_REAL_LINE, 0); }
		public Time_realContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_time_real; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShowProposalListener ) ((ShowProposalListener)listener).enterTime_real(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShowProposalListener ) ((ShowProposalListener)listener).exitTime_real(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ShowProposalVisitor ) return ((ShowProposalVisitor<? extends T>)visitor).visitTime_real(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Time_realContext time_real() throws RecognitionException {
		Time_realContext _localctx = new Time_realContext(_ctx, getState());
		enterRule(_localctx, 106, RULE_time_real);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(330);
			match(TIME_REAL_LINE);
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
		public TerminalNode TIME_PLACEHOLDER_LINE() { return getToken(ShowProposalParser.TIME_PLACEHOLDER_LINE, 0); }
		public Time_placeholderContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_time_placeholder; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShowProposalListener ) ((ShowProposalListener)listener).enterTime_placeholder(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShowProposalListener ) ((ShowProposalListener)listener).exitTime_placeholder(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ShowProposalVisitor ) return ((ShowProposalVisitor<? extends T>)visitor).visitTime_placeholder(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Time_placeholderContext time_placeholder() throws RecognitionException {
		Time_placeholderContext _localctx = new Time_placeholderContext(_ctx, getState());
		enterRule(_localctx, 108, RULE_time_placeholder);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(332);
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
		public Duration_realContext duration_real() {
			return getRuleContext(Duration_realContext.class,0);
		}
		public Duration_placeholderContext duration_placeholder() {
			return getRuleContext(Duration_placeholderContext.class,0);
		}
		public DurationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_duration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShowProposalListener ) ((ShowProposalListener)listener).enterDuration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShowProposalListener ) ((ShowProposalListener)listener).exitDuration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ShowProposalVisitor ) return ((ShowProposalVisitor<? extends T>)visitor).visitDuration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DurationContext duration() throws RecognitionException {
		DurationContext _localctx = new DurationContext(_ctx, getState());
		enterRule(_localctx, 110, RULE_duration);
		try {
			setState(336);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case DURATION_REAL_LINE:
				enterOuterAlt(_localctx, 1);
				{
				setState(334);
				duration_real();
				}
				break;
			case DURATION_PLACEHOLDER_LINE:
				enterOuterAlt(_localctx, 2);
				{
				setState(335);
				duration_placeholder();
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
	public static class Duration_realContext extends ParserRuleContext {
		public TerminalNode DURATION_REAL_LINE() { return getToken(ShowProposalParser.DURATION_REAL_LINE, 0); }
		public Duration_realContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_duration_real; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShowProposalListener ) ((ShowProposalListener)listener).enterDuration_real(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShowProposalListener ) ((ShowProposalListener)listener).exitDuration_real(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ShowProposalVisitor ) return ((ShowProposalVisitor<? extends T>)visitor).visitDuration_real(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Duration_realContext duration_real() throws RecognitionException {
		Duration_realContext _localctx = new Duration_realContext(_ctx, getState());
		enterRule(_localctx, 112, RULE_duration_real);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(338);
			match(DURATION_REAL_LINE);
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
		public TerminalNode DURATION_PLACEHOLDER_LINE() { return getToken(ShowProposalParser.DURATION_PLACEHOLDER_LINE, 0); }
		public Duration_placeholderContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_duration_placeholder; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShowProposalListener ) ((ShowProposalListener)listener).enterDuration_placeholder(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShowProposalListener ) ((ShowProposalListener)listener).exitDuration_placeholder(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ShowProposalVisitor ) return ((ShowProposalVisitor<? extends T>)visitor).visitDuration_placeholder(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Duration_placeholderContext duration_placeholder() throws RecognitionException {
		Duration_placeholderContext _localctx = new Duration_placeholderContext(_ctx, getState());
		enterRule(_localctx, 114, RULE_duration_placeholder);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(340);
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
		public TerminalNode NEWLINE() { return getToken(ShowProposalParser.NEWLINE, 0); }
		public DroneListRealContext droneListReal() {
			return getRuleContext(DroneListRealContext.class,0);
		}
		public DroneListPlaceholdersContext droneListPlaceholders() {
			return getRuleContext(DroneListPlaceholdersContext.class,0);
		}
		public DroneListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_droneList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShowProposalListener ) ((ShowProposalListener)listener).enterDroneList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShowProposalListener ) ((ShowProposalListener)listener).exitDroneList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ShowProposalVisitor ) return ((ShowProposalVisitor<? extends T>)visitor).visitDroneList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DroneListContext droneList() throws RecognitionException {
		DroneListContext _localctx = new DroneListContext(_ctx, getState());
		enterRule(_localctx, 116, RULE_droneList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(342);
			_la = _input.LA(1);
			if ( !(_la==T__1 || _la==T__2) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(343);
			match(NEWLINE);
			setState(346);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case DRONE_ITEM_REAL:
				{
				setState(344);
				droneListReal();
				}
				break;
			case DRONE_ITEM_PLACEHOLDER:
				{
				setState(345);
				droneListPlaceholders();
				}
				break;
			default:
				throw new NoViableAltException(this);
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
	public static class DroneListRealContext extends ParserRuleContext {
		public List<TerminalNode> DRONE_ITEM_REAL() { return getTokens(ShowProposalParser.DRONE_ITEM_REAL); }
		public TerminalNode DRONE_ITEM_REAL(int i) {
			return getToken(ShowProposalParser.DRONE_ITEM_REAL, i);
		}
		public List<TerminalNode> NEWLINE() { return getTokens(ShowProposalParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(ShowProposalParser.NEWLINE, i);
		}
		public DroneListRealContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_droneListReal; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShowProposalListener ) ((ShowProposalListener)listener).enterDroneListReal(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShowProposalListener ) ((ShowProposalListener)listener).exitDroneListReal(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ShowProposalVisitor ) return ((ShowProposalVisitor<? extends T>)visitor).visitDroneListReal(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DroneListRealContext droneListReal() throws RecognitionException {
		DroneListRealContext _localctx = new DroneListRealContext(_ctx, getState());
		enterRule(_localctx, 118, RULE_droneListReal);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(348);
			match(DRONE_ITEM_REAL);
			setState(353);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,18,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(349);
					match(NEWLINE);
					setState(350);
					match(DRONE_ITEM_REAL);
					}
					} 
				}
				setState(355);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,18,_ctx);
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
	public static class DroneListPlaceholdersContext extends ParserRuleContext {
		public List<TerminalNode> DRONE_ITEM_PLACEHOLDER() { return getTokens(ShowProposalParser.DRONE_ITEM_PLACEHOLDER); }
		public TerminalNode DRONE_ITEM_PLACEHOLDER(int i) {
			return getToken(ShowProposalParser.DRONE_ITEM_PLACEHOLDER, i);
		}
		public List<TerminalNode> NEWLINE() { return getTokens(ShowProposalParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(ShowProposalParser.NEWLINE, i);
		}
		public DroneListPlaceholdersContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_droneListPlaceholders; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShowProposalListener ) ((ShowProposalListener)listener).enterDroneListPlaceholders(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShowProposalListener ) ((ShowProposalListener)listener).exitDroneListPlaceholders(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ShowProposalVisitor ) return ((ShowProposalVisitor<? extends T>)visitor).visitDroneListPlaceholders(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DroneListPlaceholdersContext droneListPlaceholders() throws RecognitionException {
		DroneListPlaceholdersContext _localctx = new DroneListPlaceholdersContext(_ctx, getState());
		enterRule(_localctx, 120, RULE_droneListPlaceholders);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(356);
			match(DRONE_ITEM_PLACEHOLDER);
			setState(361);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,19,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(357);
					match(NEWLINE);
					setState(358);
					match(DRONE_ITEM_PLACEHOLDER);
					}
					} 
				}
				setState(363);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,19,_ctx);
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
		public TerminalNode NEWLINE() { return getToken(ShowProposalParser.NEWLINE, 0); }
		public FigureListRealContext figureListReal() {
			return getRuleContext(FigureListRealContext.class,0);
		}
		public FigureListPlaceholderContext figureListPlaceholder() {
			return getRuleContext(FigureListPlaceholderContext.class,0);
		}
		public FigureListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_figureList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShowProposalListener ) ((ShowProposalListener)listener).enterFigureList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShowProposalListener ) ((ShowProposalListener)listener).exitFigureList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ShowProposalVisitor ) return ((ShowProposalVisitor<? extends T>)visitor).visitFigureList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FigureListContext figureList() throws RecognitionException {
		FigureListContext _localctx = new FigureListContext(_ctx, getState());
		enterRule(_localctx, 122, RULE_figureList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(364);
			_la = _input.LA(1);
			if ( !(_la==T__3 || _la==T__4) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(365);
			match(NEWLINE);
			setState(368);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case FIGURE_ITEM_REAL:
				{
				setState(366);
				figureListReal();
				}
				break;
			case FIGURE_ITEM_PLACEHOLDER:
				{
				setState(367);
				figureListPlaceholder();
				}
				break;
			default:
				throw new NoViableAltException(this);
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
	public static class FigureListRealContext extends ParserRuleContext {
		public List<TerminalNode> FIGURE_ITEM_REAL() { return getTokens(ShowProposalParser.FIGURE_ITEM_REAL); }
		public TerminalNode FIGURE_ITEM_REAL(int i) {
			return getToken(ShowProposalParser.FIGURE_ITEM_REAL, i);
		}
		public List<TerminalNode> NEWLINE() { return getTokens(ShowProposalParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(ShowProposalParser.NEWLINE, i);
		}
		public FigureListRealContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_figureListReal; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShowProposalListener ) ((ShowProposalListener)listener).enterFigureListReal(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShowProposalListener ) ((ShowProposalListener)listener).exitFigureListReal(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ShowProposalVisitor ) return ((ShowProposalVisitor<? extends T>)visitor).visitFigureListReal(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FigureListRealContext figureListReal() throws RecognitionException {
		FigureListRealContext _localctx = new FigureListRealContext(_ctx, getState());
		enterRule(_localctx, 124, RULE_figureListReal);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(370);
			match(FIGURE_ITEM_REAL);
			setState(375);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NEWLINE) {
				{
				{
				setState(371);
				match(NEWLINE);
				setState(372);
				match(FIGURE_ITEM_REAL);
				}
				}
				setState(377);
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

	@SuppressWarnings("CheckReturnValue")
	public static class FigureListPlaceholderContext extends ParserRuleContext {
		public List<TerminalNode> FIGURE_ITEM_PLACEHOLDER() { return getTokens(ShowProposalParser.FIGURE_ITEM_PLACEHOLDER); }
		public TerminalNode FIGURE_ITEM_PLACEHOLDER(int i) {
			return getToken(ShowProposalParser.FIGURE_ITEM_PLACEHOLDER, i);
		}
		public List<TerminalNode> NEWLINE() { return getTokens(ShowProposalParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(ShowProposalParser.NEWLINE, i);
		}
		public FigureListPlaceholderContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_figureListPlaceholder; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShowProposalListener ) ((ShowProposalListener)listener).enterFigureListPlaceholder(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShowProposalListener ) ((ShowProposalListener)listener).exitFigureListPlaceholder(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ShowProposalVisitor ) return ((ShowProposalVisitor<? extends T>)visitor).visitFigureListPlaceholder(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FigureListPlaceholderContext figureListPlaceholder() throws RecognitionException {
		FigureListPlaceholderContext _localctx = new FigureListPlaceholderContext(_ctx, getState());
		enterRule(_localctx, 126, RULE_figureListPlaceholder);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(378);
			match(FIGURE_ITEM_PLACEHOLDER);
			setState(383);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NEWLINE) {
				{
				{
				setState(379);
				match(NEWLINE);
				setState(380);
				match(FIGURE_ITEM_PLACEHOLDER);
				}
				}
				setState(385);
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
		"\u0004\u0001F\u0183\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
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
		"-\u0007-\u0002.\u0007.\u0002/\u0007/\u00020\u00070\u00021\u00071\u0002"+
		"2\u00072\u00023\u00073\u00024\u00074\u00025\u00075\u00026\u00076\u0002"+
		"7\u00077\u00028\u00078\u00029\u00079\u0002:\u0007:\u0002;\u0007;\u0002"+
		"<\u0007<\u0002=\u0007=\u0002>\u0007>\u0002?\u0007?\u0001\u0000\u0001\u0000"+
		"\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000"+
		"\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000"+
		"\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0002\u0001\u0002"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0003\u0003\u009e\b\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0004\u0001\u0004\u0003\u0004\u00a9\b\u0004\u0001\u0005\u0001\u0005"+
		"\u0001\u0006\u0001\u0006\u0001\u0007\u0001\u0007\u0003\u0007\u00b1\b\u0007"+
		"\u0001\b\u0001\b\u0001\t\u0001\t\u0001\n\u0001\n\u0003\n\u00b9\b\n\u0001"+
		"\u000b\u0001\u000b\u0001\f\u0001\f\u0001\r\u0001\r\u0003\r\u00c1\b\r\u0001"+
		"\u000e\u0001\u000e\u0001\u000f\u0001\u000f\u0001\u0010\u0001\u0010\u0003"+
		"\u0010\u00c9\b\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0011\u0001"+
		"\u0011\u0001\u0012\u0001\u0012\u0001\u0013\u0001\u0013\u0001\u0014\u0001"+
		"\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0015\u0001"+
		"\u0015\u0003\u0015\u00dc\b\u0015\u0001\u0016\u0001\u0016\u0001\u0017\u0001"+
		"\u0017\u0003\u0017\u00e2\b\u0017\u0001\u0018\u0001\u0018\u0001\u0019\u0001"+
		"\u0019\u0001\u001a\u0001\u001a\u0001\u001b\u0001\u001b\u0003\u001b\u00ec"+
		"\b\u001b\u0001\u001c\u0001\u001c\u0001\u001d\u0001\u001d\u0001\u001e\u0001"+
		"\u001e\u0003\u001e\u00f4\b\u001e\u0001\u001f\u0001\u001f\u0001 \u0001"+
		" \u0001!\u0001!\u0001!\u0001!\u0001!\u0001!\u0001!\u0001!\u0001!\u0001"+
		"\"\u0001\"\u0003\"\u0105\b\"\u0001#\u0001#\u0001$\u0001$\u0001%\u0001"+
		"%\u0001%\u0001%\u0001%\u0001%\u0001%\u0001%\u0001%\u0003%\u0114\b%\u0001"+
		"&\u0001&\u0001\'\u0001\'\u0001(\u0001(\u0001)\u0001)\u0001*\u0001*\u0001"+
		"*\u0001*\u0001*\u0001*\u0001*\u0001*\u0001*\u0001*\u0001*\u0001*\u0001"+
		"*\u0001*\u0001*\u0001*\u0001*\u0001+\u0001+\u0003+\u0131\b+\u0001,\u0001"+
		",\u0001-\u0001-\u0001.\u0001.\u0003.\u0139\b.\u0001/\u0001/\u00010\u0001"+
		"0\u00011\u00011\u00031\u0141\b1\u00012\u00012\u00013\u00013\u00014\u0001"+
		"4\u00034\u0149\b4\u00015\u00015\u00016\u00016\u00017\u00017\u00037\u0151"+
		"\b7\u00018\u00018\u00019\u00019\u0001:\u0001:\u0001:\u0001:\u0003:\u015b"+
		"\b:\u0001;\u0001;\u0001;\u0005;\u0160\b;\n;\f;\u0163\t;\u0001<\u0001<"+
		"\u0001<\u0005<\u0168\b<\n<\f<\u016b\t<\u0001=\u0001=\u0001=\u0001=\u0003"+
		"=\u0171\b=\u0001>\u0001>\u0001>\u0005>\u0176\b>\n>\f>\u0179\t>\u0001?"+
		"\u0001?\u0001?\u0005?\u017e\b?\n?\f?\u0181\t?\u0001?\u0000\u0000@\u0000"+
		"\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018\u001a\u001c"+
		"\u001e \"$&(*,.02468:<>@BDFHJLNPRTVXZ\\^`bdfhjlnprtvxz|~\u0000\u0002\u0001"+
		"\u0000\u0002\u0003\u0001\u0000\u0004\u0005\u0159\u0000\u0080\u0001\u0000"+
		"\u0000\u0000\u0002\u0094\u0001\u0000\u0000\u0000\u0004\u0098\u0001\u0000"+
		"\u0000\u0000\u0006\u009d\u0001\u0000\u0000\u0000\b\u00a8\u0001\u0000\u0000"+
		"\u0000\n\u00aa\u0001\u0000\u0000\u0000\f\u00ac\u0001\u0000\u0000\u0000"+
		"\u000e\u00b0\u0001\u0000\u0000\u0000\u0010\u00b2\u0001\u0000\u0000\u0000"+
		"\u0012\u00b4\u0001\u0000\u0000\u0000\u0014\u00b8\u0001\u0000\u0000\u0000"+
		"\u0016\u00ba\u0001\u0000\u0000\u0000\u0018\u00bc\u0001\u0000\u0000\u0000"+
		"\u001a\u00c0\u0001\u0000\u0000\u0000\u001c\u00c2\u0001\u0000\u0000\u0000"+
		"\u001e\u00c4\u0001\u0000\u0000\u0000 \u00c8\u0001\u0000\u0000\u0000\""+
		"\u00cd\u0001\u0000\u0000\u0000$\u00cf\u0001\u0000\u0000\u0000&\u00d1\u0001"+
		"\u0000\u0000\u0000(\u00d3\u0001\u0000\u0000\u0000*\u00db\u0001\u0000\u0000"+
		"\u0000,\u00dd\u0001\u0000\u0000\u0000.\u00e1\u0001\u0000\u0000\u00000"+
		"\u00e3\u0001\u0000\u0000\u00002\u00e5\u0001\u0000\u0000\u00004\u00e7\u0001"+
		"\u0000\u0000\u00006\u00eb\u0001\u0000\u0000\u00008\u00ed\u0001\u0000\u0000"+
		"\u0000:\u00ef\u0001\u0000\u0000\u0000<\u00f3\u0001\u0000\u0000\u0000>"+
		"\u00f5\u0001\u0000\u0000\u0000@\u00f7\u0001\u0000\u0000\u0000B\u00f9\u0001"+
		"\u0000\u0000\u0000D\u0104\u0001\u0000\u0000\u0000F\u0106\u0001\u0000\u0000"+
		"\u0000H\u0108\u0001\u0000\u0000\u0000J\u0113\u0001\u0000\u0000\u0000L"+
		"\u0115\u0001\u0000\u0000\u0000N\u0117\u0001\u0000\u0000\u0000P\u0119\u0001"+
		"\u0000\u0000\u0000R\u011b\u0001\u0000\u0000\u0000T\u011d\u0001\u0000\u0000"+
		"\u0000V\u0130\u0001\u0000\u0000\u0000X\u0132\u0001\u0000\u0000\u0000Z"+
		"\u0134\u0001\u0000\u0000\u0000\\\u0138\u0001\u0000\u0000\u0000^\u013a"+
		"\u0001\u0000\u0000\u0000`\u013c\u0001\u0000\u0000\u0000b\u0140\u0001\u0000"+
		"\u0000\u0000d\u0142\u0001\u0000\u0000\u0000f\u0144\u0001\u0000\u0000\u0000"+
		"h\u0148\u0001\u0000\u0000\u0000j\u014a\u0001\u0000\u0000\u0000l\u014c"+
		"\u0001\u0000\u0000\u0000n\u0150\u0001\u0000\u0000\u0000p\u0152\u0001\u0000"+
		"\u0000\u0000r\u0154\u0001\u0000\u0000\u0000t\u0156\u0001\u0000\u0000\u0000"+
		"v\u015c\u0001\u0000\u0000\u0000x\u0164\u0001\u0000\u0000\u0000z\u016c"+
		"\u0001\u0000\u0000\u0000|\u0172\u0001\u0000\u0000\u0000~\u017a\u0001\u0000"+
		"\u0000\u0000\u0080\u0081\u0003\u0002\u0001\u0000\u0081\u0082\u0005D\u0000"+
		"\u0000\u0082\u0083\u0003 \u0010\u0000\u0083\u0084\u0005D\u0000\u0000\u0084"+
		"\u0085\u0005D\u0000\u0000\u0085\u0086\u0003(\u0014\u0000\u0086\u0087\u0005"+
		"D\u0000\u0000\u0087\u0088\u0005D\u0000\u0000\u0088\u0089\u0003<\u001e"+
		"\u0000\u0089\u008a\u0005D\u0000\u0000\u008a\u008b\u0005D\u0000\u0000\u008b"+
		"\u008c\u0003B!\u0000\u008c\u008d\u0005D\u0000\u0000\u008d\u008e\u0005"+
		"D\u0000\u0000\u008e\u008f\u0005C\u0000\u0000\u008f\u0090\u0005D\u0000"+
		"\u0000\u0090\u0091\u0005D\u0000\u0000\u0091\u0092\u0003T*\u0000\u0092"+
		"\u0093\u0005\u0000\u0000\u0001\u0093\u0001\u0001\u0000\u0000\u0000\u0094"+
		"\u0095\u0003\u0004\u0002\u0000\u0095\u0096\u0005D\u0000\u0000\u0096\u0097"+
		"\u0003\u0006\u0003\u0000\u0097\u0003\u0001\u0000\u0000\u0000\u0098\u0099"+
		"\u0005\u0006\u0000\u0000\u0099\u0005\u0001\u0000\u0000\u0000\u009a\u009b"+
		"\u0003\b\u0004\u0000\u009b\u009c\u0005D\u0000\u0000\u009c\u009e\u0001"+
		"\u0000\u0000\u0000\u009d\u009a\u0001\u0000\u0000\u0000\u009d\u009e\u0001"+
		"\u0000\u0000\u0000\u009e\u009f\u0001\u0000\u0000\u0000\u009f\u00a0\u0003"+
		"\u000e\u0007\u0000\u00a0\u00a1\u0005D\u0000\u0000\u00a1\u00a2\u0003\u0014"+
		"\n\u0000\u00a2\u00a3\u0005D\u0000\u0000\u00a3\u00a4\u0003\u001a\r\u0000"+
		"\u00a4\u00a5\u0005D\u0000\u0000\u00a5\u0007\u0001\u0000\u0000\u0000\u00a6"+
		"\u00a9\u0003\n\u0005\u0000\u00a7\u00a9\u0003\f\u0006\u0000\u00a8\u00a6"+
		"\u0001\u0000\u0000\u0000\u00a8\u00a7\u0001\u0000\u0000\u0000\u00a9\t\u0001"+
		"\u0000\u0000\u0000\u00aa\u00ab\u0005@\u0000\u0000\u00ab\u000b\u0001\u0000"+
		"\u0000\u0000\u00ac\u00ad\u0005\u001e\u0000\u0000\u00ad\r\u0001\u0000\u0000"+
		"\u0000\u00ae\u00b1\u0003\u0010\b\u0000\u00af\u00b1\u0003\u0012\t\u0000"+
		"\u00b0\u00ae\u0001\u0000\u0000\u0000\u00b0\u00af\u0001\u0000\u0000\u0000"+
		"\u00b1\u000f\u0001\u0000\u0000\u0000\u00b2\u00b3\u0005B\u0000\u0000\u00b3"+
		"\u0011\u0001\u0000\u0000\u0000\u00b4\u00b5\u0005 \u0000\u0000\u00b5\u0013"+
		"\u0001\u0000\u0000\u0000\u00b6\u00b9\u0003\u0016\u000b\u0000\u00b7\u00b9"+
		"\u0003\u0018\f\u0000\u00b8\u00b6\u0001\u0000\u0000\u0000\u00b8\u00b7\u0001"+
		"\u0000\u0000\u0000\u00b9\u0015\u0001\u0000\u0000\u0000\u00ba\u00bb\u0005"+
		"F\u0000\u0000\u00bb\u0017\u0001\u0000\u0000\u0000\u00bc\u00bd\u0005!\u0000"+
		"\u0000\u00bd\u0019\u0001\u0000\u0000\u0000\u00be\u00c1\u0003\u001c\u000e"+
		"\u0000\u00bf\u00c1\u0003\u001e\u000f\u0000\u00c0\u00be\u0001\u0000\u0000"+
		"\u0000\u00c0\u00bf\u0001\u0000\u0000\u0000\u00c1\u001b\u0001\u0000\u0000"+
		"\u0000\u00c2\u00c3\u0005A\u0000\u0000\u00c3\u001d\u0001\u0000\u0000\u0000"+
		"\u00c4\u00c5\u0005\"\u0000\u0000\u00c5\u001f\u0001\u0000\u0000\u0000\u00c6"+
		"\u00c9\u0003\"\u0011\u0000\u00c7\u00c9\u0003$\u0012\u0000\u00c8\u00c6"+
		"\u0001\u0000\u0000\u0000\u00c8\u00c7\u0001\u0000\u0000\u0000\u00c9\u00ca"+
		"\u0001\u0000\u0000\u0000\u00ca\u00cb\u0005D\u0000\u0000\u00cb\u00cc\u0003"+
		"&\u0013\u0000\u00cc!\u0001\u0000\u0000\u0000\u00cd\u00ce\u00052\u0000"+
		"\u0000\u00ce#\u0001\u0000\u0000\u0000\u00cf\u00d0\u00053\u0000\u0000\u00d0"+
		"%\u0001\u0000\u0000\u0000\u00d1\u00d2\u0005\u0007\u0000\u0000\u00d2\'"+
		"\u0001\u0000\u0000\u0000\u00d3\u00d4\u0003*\u0015\u0000\u00d4\u00d5\u0005"+
		"D\u0000\u0000\u00d5\u00d6\u00034\u001a\u0000\u00d6\u00d7\u0005D\u0000"+
		"\u0000\u00d7\u00d8\u00036\u001b\u0000\u00d8)\u0001\u0000\u0000\u0000\u00d9"+
		"\u00dc\u0003,\u0016\u0000\u00da\u00dc\u0003.\u0017\u0000\u00db\u00d9\u0001"+
		"\u0000\u0000\u0000\u00db\u00da\u0001\u0000\u0000\u0000\u00dc+\u0001\u0000"+
		"\u0000\u0000\u00dd\u00de\u0005\f\u0000\u0000\u00de-\u0001\u0000\u0000"+
		"\u0000\u00df\u00e2\u00030\u0018\u0000\u00e0\u00e2\u00032\u0019\u0000\u00e1"+
		"\u00df\u0001\u0000\u0000\u0000\u00e1\u00e0\u0001\u0000\u0000\u0000\u00e2"+
		"/\u0001\u0000\u0000\u0000\u00e3\u00e4\u0005\r\u0000\u0000\u00e41\u0001"+
		"\u0000\u0000\u0000\u00e5\u00e6\u0005\u000e\u0000\u0000\u00e63\u0001\u0000"+
		"\u0000\u0000\u00e7\u00e8\u0005\u000f\u0000\u0000\u00e85\u0001\u0000\u0000"+
		"\u0000\u00e9\u00ec\u00038\u001c\u0000\u00ea\u00ec\u0003:\u001d\u0000\u00eb"+
		"\u00e9\u0001\u0000\u0000\u0000\u00eb\u00ea\u0001\u0000\u0000\u0000\u00ec"+
		"7\u0001\u0000\u0000\u0000\u00ed\u00ee\u0005\u0010\u0000\u0000\u00ee9\u0001"+
		"\u0000\u0000\u0000\u00ef\u00f0\u0005\u0011\u0000\u0000\u00f0;\u0001\u0000"+
		"\u0000\u0000\u00f1\u00f4\u0003>\u001f\u0000\u00f2\u00f4\u0003@ \u0000"+
		"\u00f3\u00f1\u0001\u0000\u0000\u0000\u00f3\u00f2\u0001\u0000\u0000\u0000"+
		"\u00f4=\u0001\u0000\u0000\u0000\u00f5\u00f6\u0005\u0013\u0000\u0000\u00f6"+
		"?\u0001\u0000\u0000\u0000\u00f7\u00f8\u0005\u0014\u0000\u0000\u00f8A\u0001"+
		"\u0000\u0000\u0000\u00f9\u00fa\u0003J%\u0000\u00fa\u00fb\u0005D\u0000"+
		"\u0000\u00fb\u00fc\u0003R)\u0000\u00fc\u00fd\u0005D\u0000\u0000\u00fd"+
		"\u00fe\u0005D\u0000\u0000\u00fe\u00ff\u0003D\"\u0000\u00ff\u0100\u0005"+
		"D\u0000\u0000\u0100\u0101\u0005\u0001\u0000\u0000\u0101C\u0001\u0000\u0000"+
		"\u0000\u0102\u0105\u0003F#\u0000\u0103\u0105\u0003H$\u0000\u0104\u0102"+
		"\u0001\u0000\u0000\u0000\u0104\u0103\u0001\u0000\u0000\u0000\u0105E\u0001"+
		"\u0000\u0000\u0000\u0106\u0107\u0005@\u0000\u0000\u0107G\u0001\u0000\u0000"+
		"\u0000\u0108\u0109\u0005\u001f\u0000\u0000\u0109I\u0001\u0000\u0000\u0000"+
		"\u010a\u010b\u0003L&\u0000\u010b\u010c\u0005D\u0000\u0000\u010c\u010d"+
		"\u0005D\u0000\u0000\u010d\u010e\u0003N\'\u0000\u010e\u010f\u0005D\u0000"+
		"\u0000\u010f\u0114\u0001\u0000\u0000\u0000\u0110\u0111\u0003P(\u0000\u0111"+
		"\u0112\u0005D\u0000\u0000\u0112\u0114\u0001\u0000\u0000\u0000\u0113\u010a"+
		"\u0001\u0000\u0000\u0000\u0113\u0110\u0001\u0000\u0000\u0000\u0114K\u0001"+
		"\u0000\u0000\u0000\u0115\u0116\u0005\b\u0000\u0000\u0116M\u0001\u0000"+
		"\u0000\u0000\u0117\u0118\u0005\t\u0000\u0000\u0118O\u0001\u0000\u0000"+
		"\u0000\u0119\u011a\u0005\n\u0000\u0000\u011aQ\u0001\u0000\u0000\u0000"+
		"\u011b\u011c\u0005\u000b\u0000\u0000\u011cS\u0001\u0000\u0000\u0000\u011d"+
		"\u011e\u0003V+\u0000\u011e\u011f\u0005D\u0000\u0000\u011f\u0120\u0005"+
		"D\u0000\u0000\u0120\u0121\u0003\\.\u0000\u0121\u0122\u0005D\u0000\u0000"+
		"\u0122\u0123\u0003b1\u0000\u0123\u0124\u0005D\u0000\u0000\u0124\u0125"+
		"\u0003h4\u0000\u0125\u0126\u0005D\u0000\u0000\u0126\u0127\u0003n7\u0000"+
		"\u0127\u0128\u0005D\u0000\u0000\u0128\u0129\u0005D\u0000\u0000\u0129\u012a"+
		"\u0003t:\u0000\u012a\u012b\u0005D\u0000\u0000\u012b\u012c\u0005D\u0000"+
		"\u0000\u012c\u012d\u0003z=\u0000\u012dU\u0001\u0000\u0000\u0000\u012e"+
		"\u0131\u0003X,\u0000\u012f\u0131\u0003Z-\u0000\u0130\u012e\u0001\u0000"+
		"\u0000\u0000\u0130\u012f\u0001\u0000\u0000\u0000\u0131W\u0001\u0000\u0000"+
		"\u0000\u0132\u0133\u0005.\u0000\u0000\u0133Y\u0001\u0000\u0000\u0000\u0134"+
		"\u0135\u0005/\u0000\u0000\u0135[\u0001\u0000\u0000\u0000\u0136\u0139\u0003"+
		"^/\u0000\u0137\u0139\u0003`0\u0000\u0138\u0136\u0001\u0000\u0000\u0000"+
		"\u0138\u0137\u0001\u0000\u0000\u0000\u0139]\u0001\u0000\u0000\u0000\u013a"+
		"\u013b\u0005*\u0000\u0000\u013b_\u0001\u0000\u0000\u0000\u013c\u013d\u0005"+
		"+\u0000\u0000\u013da\u0001\u0000\u0000\u0000\u013e\u0141\u0003d2\u0000"+
		"\u013f\u0141\u0003f3\u0000\u0140\u013e\u0001\u0000\u0000\u0000\u0140\u013f"+
		"\u0001\u0000\u0000\u0000\u0141c\u0001\u0000\u0000\u0000\u0142\u0143\u0005"+
		"\u0017\u0000\u0000\u0143e\u0001\u0000\u0000\u0000\u0144\u0145\u0005\u0018"+
		"\u0000\u0000\u0145g\u0001\u0000\u0000\u0000\u0146\u0149\u0003j5\u0000"+
		"\u0147\u0149\u0003l6\u0000\u0148\u0146\u0001\u0000\u0000\u0000\u0148\u0147"+
		"\u0001\u0000\u0000\u0000\u0149i\u0001\u0000\u0000\u0000\u014a\u014b\u0005"+
		"8\u0000\u0000\u014bk\u0001\u0000\u0000\u0000\u014c\u014d\u00059\u0000"+
		"\u0000\u014dm\u0001\u0000\u0000\u0000\u014e\u0151\u0003p8\u0000\u014f"+
		"\u0151\u0003r9\u0000\u0150\u014e\u0001\u0000\u0000\u0000\u0150\u014f\u0001"+
		"\u0000\u0000\u0000\u0151o\u0001\u0000\u0000\u0000\u0152\u0153\u0005=\u0000"+
		"\u0000\u0153q\u0001\u0000\u0000\u0000\u0154\u0155\u0005>\u0000\u0000\u0155"+
		"s\u0001\u0000\u0000\u0000\u0156\u0157\u0007\u0000\u0000\u0000\u0157\u015a"+
		"\u0005D\u0000\u0000\u0158\u015b\u0003v;\u0000\u0159\u015b\u0003x<\u0000"+
		"\u015a\u0158\u0001\u0000\u0000\u0000\u015a\u0159\u0001\u0000\u0000\u0000"+
		"\u015bu\u0001\u0000\u0000\u0000\u015c\u0161\u0005%\u0000\u0000\u015d\u015e"+
		"\u0005D\u0000\u0000\u015e\u0160\u0005%\u0000\u0000\u015f\u015d\u0001\u0000"+
		"\u0000\u0000\u0160\u0163\u0001\u0000\u0000\u0000\u0161\u015f\u0001\u0000"+
		"\u0000\u0000\u0161\u0162\u0001\u0000\u0000\u0000\u0162w\u0001\u0000\u0000"+
		"\u0000\u0163\u0161\u0001\u0000\u0000\u0000\u0164\u0169\u0005&\u0000\u0000"+
		"\u0165\u0166\u0005D\u0000\u0000\u0166\u0168\u0005&\u0000\u0000\u0167\u0165"+
		"\u0001\u0000\u0000\u0000\u0168\u016b\u0001\u0000\u0000\u0000\u0169\u0167"+
		"\u0001\u0000\u0000\u0000\u0169\u016a\u0001\u0000\u0000\u0000\u016ay\u0001"+
		"\u0000\u0000\u0000\u016b\u0169\u0001\u0000\u0000\u0000\u016c\u016d\u0007"+
		"\u0001\u0000\u0000\u016d\u0170\u0005D\u0000\u0000\u016e\u0171\u0003|>"+
		"\u0000\u016f\u0171\u0003~?\u0000\u0170\u016e\u0001\u0000\u0000\u0000\u0170"+
		"\u016f\u0001\u0000\u0000\u0000\u0171{\u0001\u0000\u0000\u0000\u0172\u0177"+
		"\u0005\u001a\u0000\u0000\u0173\u0174\u0005D\u0000\u0000\u0174\u0176\u0005"+
		"\u001a\u0000\u0000\u0175\u0173\u0001\u0000\u0000\u0000\u0176\u0179\u0001"+
		"\u0000\u0000\u0000\u0177\u0175\u0001\u0000\u0000\u0000\u0177\u0178\u0001"+
		"\u0000\u0000\u0000\u0178}\u0001\u0000\u0000\u0000\u0179\u0177\u0001\u0000"+
		"\u0000\u0000\u017a\u017f\u0005\u001b\u0000\u0000\u017b\u017c\u0005D\u0000"+
		"\u0000\u017c\u017e\u0005\u001b\u0000\u0000\u017d\u017b\u0001\u0000\u0000"+
		"\u0000\u017e\u0181\u0001\u0000\u0000\u0000\u017f\u017d\u0001\u0000\u0000"+
		"\u0000\u017f\u0180\u0001\u0000\u0000\u0000\u0180\u007f\u0001\u0000\u0000"+
		"\u0000\u0181\u017f\u0001\u0000\u0000\u0000\u0017\u009d\u00a8\u00b0\u00b8"+
		"\u00c0\u00c8\u00db\u00e1\u00eb\u00f3\u0104\u0113\u0130\u0138\u0140\u0148"+
		"\u0150\u015a\u0161\u0169\u0170\u0177\u017f";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}