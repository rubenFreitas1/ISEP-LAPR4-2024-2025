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
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, T__26=27, LINE_1_FORMAT=28, LINE_2_FORMAT=29, LINE_3_FORMAT=30, 
		CLOSING_FORMAT=31, SHOW_DATE_FORMAT=32, FIGURE_ITEM=33, LINK=34, DRONE_ITEM=35, 
		GPS_VALUE=36, ATTACHMENT=37, REFERENCE=38, DATE=39, TIME=40, DURATION=41, 
		PERSON_NAME=42, VAT_NUMBER=43, WORD=44, PAGE_BREAK=45, NEWLINE=46, WS=47, 
		ADDRESS_LINE=48;
	public static final int
		RULE_proposal = 0, RULE_header = 1, RULE_greeting = 2, RULE_companyInfo = 3, 
		RULE_personName = 4, RULE_company = 5, RULE_address = 6, RULE_vatNumber = 7, 
		RULE_reference = 8, RULE_titleProposal = 9, RULE_body = 10, RULE_line_1 = 11, 
		RULE_line_2 = 12, RULE_line_3 = 13, RULE_closing = 14, RULE_signature = 15, 
		RULE_signature_option = 16, RULE_preferencePhrase = 17, RULE_subscribePhrase = 18, 
		RULE_lastPhrase = 19, RULE_regards = 20, RULE_showDetails = 21, RULE_location = 22, 
		RULE_date = 23, RULE_time = 24, RULE_duration = 25, RULE_droneList = 26, 
		RULE_figureList = 27;
	private static String[] makeRuleNames() {
		return new String[] {
			"proposal", "header", "greeting", "companyInfo", "personName", "company", 
			"address", "vatNumber", "reference", "titleProposal", "body", "line_1", 
			"line_2", "line_3", "closing", "signature", "signature_option", "preferencePhrase", 
			"subscribePhrase", "lastPhrase", "regards", "showDetails", "location", 
			"date", "time", "duration", "droneList", "figureList"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'Dear,'", "'Dear Sirs,'", "'Exmos. Senhores'", "'[Customer Representative Name]'", 
			"'[CRM Manager Name]'", "'[Company name]'", "'['", "'Company'", "' '", 
			"'Name'", "']'", "'[Address with postal code and country]'", "'[VAT Number]'", 
			"'Show Proposal'", "'Proposta de Show'", "'CRM Manager'", "'Being certain that we will be the target of your preference.'", 
			"'Estando certos que seremos alvo da V/ prefer\\u00C3\\u00AAncia.'", 
			"'We subscribe at your disposal.'", "'Subscrevemo-nos ao dispor.'", "'Looking forward to hearing from you soon.'", 
			"'Best regards,'", "'Melhores cumprimentos,'", "'#List of used drones'", 
			"'#Lista de drones utilizados'", "'#Lista de figuras'", "'#List of figures'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, "LINE_1_FORMAT", "LINE_2_FORMAT", "LINE_3_FORMAT", 
			"CLOSING_FORMAT", "SHOW_DATE_FORMAT", "FIGURE_ITEM", "LINK", "DRONE_ITEM", 
			"GPS_VALUE", "ATTACHMENT", "REFERENCE", "DATE", "TIME", "DURATION", "PERSON_NAME", 
			"VAT_NUMBER", "WORD", "PAGE_BREAK", "NEWLINE", "WS", "ADDRESS_LINE"
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
			setState(56);
			header();
			setState(57);
			match(NEWLINE);
			setState(58);
			reference();
			setState(59);
			match(NEWLINE);
			setState(60);
			match(NEWLINE);
			setState(61);
			body();
			setState(62);
			match(NEWLINE);
			setState(63);
			match(NEWLINE);
			setState(64);
			closing();
			setState(65);
			match(NEWLINE);
			setState(66);
			match(NEWLINE);
			setState(67);
			signature();
			setState(68);
			match(NEWLINE);
			setState(69);
			match(NEWLINE);
			setState(70);
			match(PAGE_BREAK);
			setState(71);
			match(NEWLINE);
			setState(72);
			match(NEWLINE);
			setState(73);
			showDetails();
			setState(74);
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
			setState(76);
			greeting();
			setState(77);
			match(NEWLINE);
			setState(78);
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
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(80);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 14L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
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
			setState(85);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 4398046511152L) != 0)) {
				{
				setState(82);
				personName();
				setState(83);
				match(NEWLINE);
				}
			}

			setState(87);
			company();
			setState(88);
			match(NEWLINE);
			setState(89);
			address();
			setState(90);
			match(NEWLINE);
			setState(91);
			vatNumber();
			setState(92);
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
		public TerminalNode PERSON_NAME() { return getToken(ShowProposalParser.PERSON_NAME, 0); }
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
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(94);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 4398046511152L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
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
	public static class CompanyContext extends ParserRuleContext {
		public TerminalNode WORD() { return getToken(ShowProposalParser.WORD, 0); }
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
		enterRule(_localctx, 10, RULE_company);
		try {
			setState(103);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case WORD:
				enterOuterAlt(_localctx, 1);
				{
				setState(96);
				match(WORD);
				}
				break;
			case T__5:
				enterOuterAlt(_localctx, 2);
				{
				setState(97);
				match(T__5);
				}
				break;
			case T__6:
				enterOuterAlt(_localctx, 3);
				{
				setState(98);
				match(T__6);
				setState(99);
				match(T__7);
				setState(100);
				match(T__8);
				setState(101);
				match(T__9);
				setState(102);
				match(T__10);
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
	public static class AddressContext extends ParserRuleContext {
		public TerminalNode ADDRESS_LINE() { return getToken(ShowProposalParser.ADDRESS_LINE, 0); }
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
		enterRule(_localctx, 12, RULE_address);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(105);
			_la = _input.LA(1);
			if ( !(_la==T__11 || _la==ADDRESS_LINE) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
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
	public static class VatNumberContext extends ParserRuleContext {
		public TerminalNode VAT_NUMBER() { return getToken(ShowProposalParser.VAT_NUMBER, 0); }
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
		enterRule(_localctx, 14, RULE_vatNumber);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(107);
			_la = _input.LA(1);
			if ( !(_la==T__12 || _la==VAT_NUMBER) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
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
	public static class ReferenceContext extends ParserRuleContext {
		public TerminalNode REFERENCE() { return getToken(ShowProposalParser.REFERENCE, 0); }
		public TerminalNode NEWLINE() { return getToken(ShowProposalParser.NEWLINE, 0); }
		public TitleProposalContext titleProposal() {
			return getRuleContext(TitleProposalContext.class,0);
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
		enterRule(_localctx, 16, RULE_reference);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(109);
			match(REFERENCE);
			setState(110);
			match(NEWLINE);
			setState(111);
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
	public static class TitleProposalContext extends ParserRuleContext {
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
		enterRule(_localctx, 18, RULE_titleProposal);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(113);
			_la = _input.LA(1);
			if ( !(_la==T__13 || _la==T__14) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
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
		enterRule(_localctx, 20, RULE_body);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(115);
			line_1();
			setState(116);
			match(NEWLINE);
			setState(117);
			line_2();
			setState(118);
			match(NEWLINE);
			setState(119);
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
		public TerminalNode LINE_1_FORMAT() { return getToken(ShowProposalParser.LINE_1_FORMAT, 0); }
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
		enterRule(_localctx, 22, RULE_line_1);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(121);
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
		enterRule(_localctx, 24, RULE_line_2);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(123);
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
		public TerminalNode LINE_3_FORMAT() { return getToken(ShowProposalParser.LINE_3_FORMAT, 0); }
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
		enterRule(_localctx, 26, RULE_line_3);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(125);
			match(LINE_3_FORMAT);
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
		public TerminalNode CLOSING_FORMAT() { return getToken(ShowProposalParser.CLOSING_FORMAT, 0); }
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
		enterRule(_localctx, 28, RULE_closing);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(127);
			match(CLOSING_FORMAT);
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
		public PersonNameContext personName() {
			return getRuleContext(PersonNameContext.class,0);
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
		enterRule(_localctx, 30, RULE_signature);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(129);
			signature_option();
			setState(130);
			match(NEWLINE);
			setState(131);
			regards();
			setState(132);
			match(NEWLINE);
			setState(133);
			match(NEWLINE);
			setState(134);
			personName();
			setState(135);
			match(NEWLINE);
			setState(136);
			match(T__15);
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
		enterRule(_localctx, 32, RULE_signature_option);
		try {
			setState(147);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__16:
			case T__17:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(138);
				preferencePhrase();
				setState(139);
				match(NEWLINE);
				setState(140);
				match(NEWLINE);
				setState(141);
				subscribePhrase();
				setState(142);
				match(NEWLINE);
				}
				}
				break;
			case T__20:
				enterOuterAlt(_localctx, 2);
				{
				setState(144);
				lastPhrase();
				setState(145);
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
		enterRule(_localctx, 34, RULE_preferencePhrase);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(149);
			_la = _input.LA(1);
			if ( !(_la==T__16 || _la==T__17) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
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
	public static class SubscribePhraseContext extends ParserRuleContext {
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
		enterRule(_localctx, 36, RULE_subscribePhrase);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(151);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 3670016L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
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
	public static class LastPhraseContext extends ParserRuleContext {
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
		enterRule(_localctx, 38, RULE_lastPhrase);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(153);
			match(T__20);
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
		enterRule(_localctx, 40, RULE_regards);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(155);
			_la = _input.LA(1);
			if ( !(_la==T__21 || _la==T__22) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
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
	public static class ShowDetailsContext extends ParserRuleContext {
		public TerminalNode ATTACHMENT() { return getToken(ShowProposalParser.ATTACHMENT, 0); }
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
		enterRule(_localctx, 42, RULE_showDetails);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(157);
			match(ATTACHMENT);
			setState(158);
			match(NEWLINE);
			setState(159);
			match(NEWLINE);
			setState(160);
			location();
			setState(161);
			match(NEWLINE);
			setState(162);
			date();
			setState(163);
			match(NEWLINE);
			setState(164);
			time();
			setState(165);
			match(NEWLINE);
			setState(166);
			duration();
			setState(167);
			match(NEWLINE);
			setState(168);
			match(NEWLINE);
			setState(169);
			droneList();
			setState(170);
			match(NEWLINE);
			setState(171);
			match(NEWLINE);
			setState(172);
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
	public static class LocationContext extends ParserRuleContext {
		public TerminalNode GPS_VALUE() { return getToken(ShowProposalParser.GPS_VALUE, 0); }
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
		enterRule(_localctx, 44, RULE_location);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(174);
			match(GPS_VALUE);
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
		public TerminalNode SHOW_DATE_FORMAT() { return getToken(ShowProposalParser.SHOW_DATE_FORMAT, 0); }
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
		enterRule(_localctx, 46, RULE_date);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(176);
			match(SHOW_DATE_FORMAT);
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
		public TerminalNode TIME() { return getToken(ShowProposalParser.TIME, 0); }
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
		enterRule(_localctx, 48, RULE_time);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(178);
			match(TIME);
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
		public TerminalNode DURATION() { return getToken(ShowProposalParser.DURATION, 0); }
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
		enterRule(_localctx, 50, RULE_duration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(180);
			match(DURATION);
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
		public List<TerminalNode> NEWLINE() { return getTokens(ShowProposalParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(ShowProposalParser.NEWLINE, i);
		}
		public List<TerminalNode> DRONE_ITEM() { return getTokens(ShowProposalParser.DRONE_ITEM); }
		public TerminalNode DRONE_ITEM(int i) {
			return getToken(ShowProposalParser.DRONE_ITEM, i);
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
		enterRule(_localctx, 52, RULE_droneList);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(182);
			_la = _input.LA(1);
			if ( !(_la==T__23 || _la==T__24) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(183);
			match(NEWLINE);
			setState(184);
			match(DRONE_ITEM);
			setState(189);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(185);
					match(NEWLINE);
					setState(186);
					match(DRONE_ITEM);
					}
					} 
				}
				setState(191);
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
		public List<TerminalNode> NEWLINE() { return getTokens(ShowProposalParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(ShowProposalParser.NEWLINE, i);
		}
		public List<TerminalNode> FIGURE_ITEM() { return getTokens(ShowProposalParser.FIGURE_ITEM); }
		public TerminalNode FIGURE_ITEM(int i) {
			return getToken(ShowProposalParser.FIGURE_ITEM, i);
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
		enterRule(_localctx, 54, RULE_figureList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(192);
			_la = _input.LA(1);
			if ( !(_la==T__25 || _la==T__26) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(193);
			match(NEWLINE);
			setState(194);
			match(FIGURE_ITEM);
			setState(199);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NEWLINE) {
				{
				{
				setState(195);
				match(NEWLINE);
				setState(196);
				match(FIGURE_ITEM);
				}
				}
				setState(201);
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
		"\u0004\u00010\u00cb\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007\u0012"+
		"\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002\u0015\u0007\u0015"+
		"\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017\u0002\u0018\u0007\u0018"+
		"\u0002\u0019\u0007\u0019\u0002\u001a\u0007\u001a\u0002\u001b\u0007\u001b"+
		"\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000"+
		"\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000"+
		"\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000"+
		"\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0003\u0003"+
		"V\b\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0003\u0005"+
		"h\b\u0005\u0001\u0006\u0001\u0006\u0001\u0007\u0001\u0007\u0001\b\u0001"+
		"\b\u0001\b\u0001\b\u0001\t\u0001\t\u0001\n\u0001\n\u0001\n\u0001\n\u0001"+
		"\n\u0001\n\u0001\u000b\u0001\u000b\u0001\f\u0001\f\u0001\r\u0001\r\u0001"+
		"\u000e\u0001\u000e\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001"+
		"\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u0010\u0001"+
		"\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001"+
		"\u0010\u0001\u0010\u0003\u0010\u0094\b\u0010\u0001\u0011\u0001\u0011\u0001"+
		"\u0012\u0001\u0012\u0001\u0013\u0001\u0013\u0001\u0014\u0001\u0014\u0001"+
		"\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001"+
		"\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001"+
		"\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0016\u0001"+
		"\u0016\u0001\u0017\u0001\u0017\u0001\u0018\u0001\u0018\u0001\u0019\u0001"+
		"\u0019\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001a\u0005"+
		"\u001a\u00bc\b\u001a\n\u001a\f\u001a\u00bf\t\u001a\u0001\u001b\u0001\u001b"+
		"\u0001\u001b\u0001\u001b\u0001\u001b\u0005\u001b\u00c6\b\u001b\n\u001b"+
		"\f\u001b\u00c9\t\u001b\u0001\u001b\u0000\u0000\u001c\u0000\u0002\u0004"+
		"\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018\u001a\u001c\u001e \""+
		"$&(*,.0246\u0000\n\u0001\u0000\u0001\u0003\u0002\u0000\u0004\u0005**\u0002"+
		"\u0000\f\f00\u0002\u0000\r\r++\u0001\u0000\u000e\u000f\u0001\u0000\u0011"+
		"\u0012\u0001\u0000\u0013\u0015\u0001\u0000\u0016\u0017\u0001\u0000\u0018"+
		"\u0019\u0001\u0000\u001a\u001b\u00b4\u00008\u0001\u0000\u0000\u0000\u0002"+
		"L\u0001\u0000\u0000\u0000\u0004P\u0001\u0000\u0000\u0000\u0006U\u0001"+
		"\u0000\u0000\u0000\b^\u0001\u0000\u0000\u0000\ng\u0001\u0000\u0000\u0000"+
		"\fi\u0001\u0000\u0000\u0000\u000ek\u0001\u0000\u0000\u0000\u0010m\u0001"+
		"\u0000\u0000\u0000\u0012q\u0001\u0000\u0000\u0000\u0014s\u0001\u0000\u0000"+
		"\u0000\u0016y\u0001\u0000\u0000\u0000\u0018{\u0001\u0000\u0000\u0000\u001a"+
		"}\u0001\u0000\u0000\u0000\u001c\u007f\u0001\u0000\u0000\u0000\u001e\u0081"+
		"\u0001\u0000\u0000\u0000 \u0093\u0001\u0000\u0000\u0000\"\u0095\u0001"+
		"\u0000\u0000\u0000$\u0097\u0001\u0000\u0000\u0000&\u0099\u0001\u0000\u0000"+
		"\u0000(\u009b\u0001\u0000\u0000\u0000*\u009d\u0001\u0000\u0000\u0000,"+
		"\u00ae\u0001\u0000\u0000\u0000.\u00b0\u0001\u0000\u0000\u00000\u00b2\u0001"+
		"\u0000\u0000\u00002\u00b4\u0001\u0000\u0000\u00004\u00b6\u0001\u0000\u0000"+
		"\u00006\u00c0\u0001\u0000\u0000\u000089\u0003\u0002\u0001\u00009:\u0005"+
		".\u0000\u0000:;\u0003\u0010\b\u0000;<\u0005.\u0000\u0000<=\u0005.\u0000"+
		"\u0000=>\u0003\u0014\n\u0000>?\u0005.\u0000\u0000?@\u0005.\u0000\u0000"+
		"@A\u0003\u001c\u000e\u0000AB\u0005.\u0000\u0000BC\u0005.\u0000\u0000C"+
		"D\u0003\u001e\u000f\u0000DE\u0005.\u0000\u0000EF\u0005.\u0000\u0000FG"+
		"\u0005-\u0000\u0000GH\u0005.\u0000\u0000HI\u0005.\u0000\u0000IJ\u0003"+
		"*\u0015\u0000JK\u0005\u0000\u0000\u0001K\u0001\u0001\u0000\u0000\u0000"+
		"LM\u0003\u0004\u0002\u0000MN\u0005.\u0000\u0000NO\u0003\u0006\u0003\u0000"+
		"O\u0003\u0001\u0000\u0000\u0000PQ\u0007\u0000\u0000\u0000Q\u0005\u0001"+
		"\u0000\u0000\u0000RS\u0003\b\u0004\u0000ST\u0005.\u0000\u0000TV\u0001"+
		"\u0000\u0000\u0000UR\u0001\u0000\u0000\u0000UV\u0001\u0000\u0000\u0000"+
		"VW\u0001\u0000\u0000\u0000WX\u0003\n\u0005\u0000XY\u0005.\u0000\u0000"+
		"YZ\u0003\f\u0006\u0000Z[\u0005.\u0000\u0000[\\\u0003\u000e\u0007\u0000"+
		"\\]\u0005.\u0000\u0000]\u0007\u0001\u0000\u0000\u0000^_\u0007\u0001\u0000"+
		"\u0000_\t\u0001\u0000\u0000\u0000`h\u0005,\u0000\u0000ah\u0005\u0006\u0000"+
		"\u0000bc\u0005\u0007\u0000\u0000cd\u0005\b\u0000\u0000de\u0005\t\u0000"+
		"\u0000ef\u0005\n\u0000\u0000fh\u0005\u000b\u0000\u0000g`\u0001\u0000\u0000"+
		"\u0000ga\u0001\u0000\u0000\u0000gb\u0001\u0000\u0000\u0000h\u000b\u0001"+
		"\u0000\u0000\u0000ij\u0007\u0002\u0000\u0000j\r\u0001\u0000\u0000\u0000"+
		"kl\u0007\u0003\u0000\u0000l\u000f\u0001\u0000\u0000\u0000mn\u0005&\u0000"+
		"\u0000no\u0005.\u0000\u0000op\u0003\u0012\t\u0000p\u0011\u0001\u0000\u0000"+
		"\u0000qr\u0007\u0004\u0000\u0000r\u0013\u0001\u0000\u0000\u0000st\u0003"+
		"\u0016\u000b\u0000tu\u0005.\u0000\u0000uv\u0003\u0018\f\u0000vw\u0005"+
		".\u0000\u0000wx\u0003\u001a\r\u0000x\u0015\u0001\u0000\u0000\u0000yz\u0005"+
		"\u001c\u0000\u0000z\u0017\u0001\u0000\u0000\u0000{|\u0005\u001d\u0000"+
		"\u0000|\u0019\u0001\u0000\u0000\u0000}~\u0005\u001e\u0000\u0000~\u001b"+
		"\u0001\u0000\u0000\u0000\u007f\u0080\u0005\u001f\u0000\u0000\u0080\u001d"+
		"\u0001\u0000\u0000\u0000\u0081\u0082\u0003 \u0010\u0000\u0082\u0083\u0005"+
		".\u0000\u0000\u0083\u0084\u0003(\u0014\u0000\u0084\u0085\u0005.\u0000"+
		"\u0000\u0085\u0086\u0005.\u0000\u0000\u0086\u0087\u0003\b\u0004\u0000"+
		"\u0087\u0088\u0005.\u0000\u0000\u0088\u0089\u0005\u0010\u0000\u0000\u0089"+
		"\u001f\u0001\u0000\u0000\u0000\u008a\u008b\u0003\"\u0011\u0000\u008b\u008c"+
		"\u0005.\u0000\u0000\u008c\u008d\u0005.\u0000\u0000\u008d\u008e\u0003$"+
		"\u0012\u0000\u008e\u008f\u0005.\u0000\u0000\u008f\u0094\u0001\u0000\u0000"+
		"\u0000\u0090\u0091\u0003&\u0013\u0000\u0091\u0092\u0005.\u0000\u0000\u0092"+
		"\u0094\u0001\u0000\u0000\u0000\u0093\u008a\u0001\u0000\u0000\u0000\u0093"+
		"\u0090\u0001\u0000\u0000\u0000\u0094!\u0001\u0000\u0000\u0000\u0095\u0096"+
		"\u0007\u0005\u0000\u0000\u0096#\u0001\u0000\u0000\u0000\u0097\u0098\u0007"+
		"\u0006\u0000\u0000\u0098%\u0001\u0000\u0000\u0000\u0099\u009a\u0005\u0015"+
		"\u0000\u0000\u009a\'\u0001\u0000\u0000\u0000\u009b\u009c\u0007\u0007\u0000"+
		"\u0000\u009c)\u0001\u0000\u0000\u0000\u009d\u009e\u0005%\u0000\u0000\u009e"+
		"\u009f\u0005.\u0000\u0000\u009f\u00a0\u0005.\u0000\u0000\u00a0\u00a1\u0003"+
		",\u0016\u0000\u00a1\u00a2\u0005.\u0000\u0000\u00a2\u00a3\u0003.\u0017"+
		"\u0000\u00a3\u00a4\u0005.\u0000\u0000\u00a4\u00a5\u00030\u0018\u0000\u00a5"+
		"\u00a6\u0005.\u0000\u0000\u00a6\u00a7\u00032\u0019\u0000\u00a7\u00a8\u0005"+
		".\u0000\u0000\u00a8\u00a9\u0005.\u0000\u0000\u00a9\u00aa\u00034\u001a"+
		"\u0000\u00aa\u00ab\u0005.\u0000\u0000\u00ab\u00ac\u0005.\u0000\u0000\u00ac"+
		"\u00ad\u00036\u001b\u0000\u00ad+\u0001\u0000\u0000\u0000\u00ae\u00af\u0005"+
		"$\u0000\u0000\u00af-\u0001\u0000\u0000\u0000\u00b0\u00b1\u0005 \u0000"+
		"\u0000\u00b1/\u0001\u0000\u0000\u0000\u00b2\u00b3\u0005(\u0000\u0000\u00b3"+
		"1\u0001\u0000\u0000\u0000\u00b4\u00b5\u0005)\u0000\u0000\u00b53\u0001"+
		"\u0000\u0000\u0000\u00b6\u00b7\u0007\b\u0000\u0000\u00b7\u00b8\u0005."+
		"\u0000\u0000\u00b8\u00bd\u0005#\u0000\u0000\u00b9\u00ba\u0005.\u0000\u0000"+
		"\u00ba\u00bc\u0005#\u0000\u0000\u00bb\u00b9\u0001\u0000\u0000\u0000\u00bc"+
		"\u00bf\u0001\u0000\u0000\u0000\u00bd\u00bb\u0001\u0000\u0000\u0000\u00bd"+
		"\u00be\u0001\u0000\u0000\u0000\u00be5\u0001\u0000\u0000\u0000\u00bf\u00bd"+
		"\u0001\u0000\u0000\u0000\u00c0\u00c1\u0007\t\u0000\u0000\u00c1\u00c2\u0005"+
		".\u0000\u0000\u00c2\u00c7\u0005!\u0000\u0000\u00c3\u00c4\u0005.\u0000"+
		"\u0000\u00c4\u00c6\u0005!\u0000\u0000\u00c5\u00c3\u0001\u0000\u0000\u0000"+
		"\u00c6\u00c9\u0001\u0000\u0000\u0000\u00c7\u00c5\u0001\u0000\u0000\u0000"+
		"\u00c7\u00c8\u0001\u0000\u0000\u0000\u00c87\u0001\u0000\u0000\u0000\u00c9"+
		"\u00c7\u0001\u0000\u0000\u0000\u0005Ug\u0093\u00bd\u00c7";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}