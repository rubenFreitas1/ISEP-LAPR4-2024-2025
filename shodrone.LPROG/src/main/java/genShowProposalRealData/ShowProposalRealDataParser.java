// Generated from C:/ISEP-PROJETOS/lapr4_projeto/shodrone.LPROG/src/main/java/antlr/ShowProposalRealData.g4 by ANTLR 4.13.2
package genShowProposalRealData;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;

import org.antlr.v4.runtime.tree.*;
import java.util.List;


@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class ShowProposalRealDataParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, T__26=27, T__27=28, T__28=29, T__29=30, T__30=31, 
		T__31=32, T__32=33, T__33=34, T__34=35, T__35=36, T__36=37, T__37=38, 
		T__38=39, T__39=40, T__40=41, T__41=42, T__42=43, T__43=44, T__44=45, 
		T__45=46, T__46=47, T__47=48, T__48=49, T__49=50, T__50=51, T__51=52, 
		T__52=53, GPS=54, DATE=55, TIME=56, VAT_NUMBER=57, NEWLINE=58, INT=59, 
		DIGIT=60, LINK=61, DASH=62, MESSAGE=63, LETTER=64;
	public static final int
		RULE_proposal = 0, RULE_proposalNewTry = 1, RULE_proposalWithRep = 2, 
		RULE_proposalWithoutRep = 3, RULE_header = 4, RULE_greeting = 5, RULE_companyInfo = 6, 
		RULE_companyInfoWithoutRep = 7, RULE_vatNumber = 8, RULE_reference = 9, 
		RULE_realReference = 10, RULE_titleProposal = 11, RULE_body = 12, RULE_line_1 = 13, 
		RULE_normal_line1 = 14, RULE_vip_line1 = 15, RULE_line_2 = 16, RULE_line_3 = 17, 
		RULE_closing = 18, RULE_signature = 19, RULE_signature_option = 20, RULE_preferencePhrase = 21, 
		RULE_subscribePhrase = 22, RULE_lastPhrase = 23, RULE_regards = 24, RULE_showDetails = 25, 
		RULE_attachment = 26, RULE_location = 27, RULE_date = 28, RULE_time = 29, 
		RULE_duration = 30, RULE_droneList = 31, RULE_droneListReal = 32, RULE_figureList = 33, 
		RULE_figureListReal = 34, RULE_descriptionName = 35;
	private static String[] makeRuleNames() {
		return new String[] {
			"proposal", "proposalNewTry", "proposalWithRep", "proposalWithoutRep", 
			"header", "greeting", "companyInfo", "companyInfoWithoutRep", "vatNumber", 
			"reference", "realReference", "titleProposal", "body", "line_1", "normal_line1", 
			"vip_line1", "line_2", "line_3", "closing", "signature", "signature_option", 
			"preferencePhrase", "subscribePhrase", "lastPhrase", "regards", "showDetails", 
			"attachment", "location", "date", "time", "duration", "droneList", "droneListReal", 
			"figureList", "figureListReal", "descriptionName"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'[page break]'", "'\\f'", "'Dear Sirs,'", "'Exmos. Senhores'", 
			"'Dear,'", "'Reference '", "'Refer\\u00EAncia '", "' / '", "'Show Proposal'", 
			"'Proposta de Show'", "'A Shodrone tem o prazer de submeter \\u00E0 V/ aprecia\\u00E7\\u00E3o uma proposta para execu\\u00E7\\u00E3o de um show a\\u00E9reo com drones, conforme descri\\u00E7\\u00E3o abaixo.'", 
			"'Shodrone is pleased to submit for your consideration a proposal for the execution of an aerial show with drones, as described below.'", 
			"' is a VIP client and Shodrone is pleased to submit for your consideration a proposal for the execution of an aerial show with drones, as described below.'", 
			"' \\u00E9 um cliente VIP e a Shodrone tem o prazer de submeter \\u00E0 vossa aprecia\\u00E7\\u00E3o uma proposta para a execu\\u00E7\\u00E3o de um espet\\u00E1culo a\\u00E9reo com drones, tal como descrito abaixo.'", 
			"'Shodrone is a company that prioritizes safety, which is why it uses the most advanced AI technology to support the development of its shows, with all shows being previously and carefully tested/simulated with AI-Test technology before being presented to the client.'", 
			"'A Shodrone \\u00E9 uma empresa que d\\u00E1 prioridade \\u00E0 seguran\\u00E7a, pelo que usa a mais avan\\u00E7ada tecnologia de IA para apoiar o desenvolvimento dos seus shows, sendo que todos os shows s\\u00E3o pr\\u00E9via e cuidadosamente testados/simulados com a tecnologia AI-Test antes de serem apresentados ao cliente.'", 
			"'In the link '", "' there is a video with a simulation of the proposed show.'", 
			"'No link '", "' encontra-se um v\\u00EDdeo com a simula\\u00E7\\u00E3o do show proposto.'", 
			"'Com a aplica\\u00E7\\u00E3o do AI-Test, um exclusivo da Shodrone, temos a confian\\u00E7a de oferecer um seguro de responsabilidade civil no valor de '", 
			"' para o show. Os dados detalhados do show s\\u00E3o apresentados em anexo.'", 
			"'With the application of AI-Test, a Shodrone exclusive, we are confident in offering liability insurance in the amount of '", 
			"' for the show. Detailed show data is presented in the attachment.'", 
			"'CRM Manager'", "'Being certain that we will be the target of your preference.'", 
			"'Estando certos que seremos alvo da V/ prefer\\u00EAncia.'", "'We subscribe at your disposal.'", 
			"'Subscrevemo-nos ao dispor.'", "'Looking forward to hearing from you soon.'", 
			"'Best regards,'", "'Melhores cumprimentos,'", "'Attachment - Show Details '", 
			"'Anexo - Detalhes do Show '", "'Location - '", "'Local de realiza\\u00E7\\u00E3o - '", 
			"'Date - '", "'Data - '", "'Time - '", "'Hora - '", "'Duration - '", 
			"'Dura\\u00E7\\u00E3o - '", "' minutes'", "' minutos'", "'#List of used drones'", 
			"'#Lista de drones utilizados'", "'#Lista de figuras'", "'#List of figures'", 
			"'_'", "','", "'.'", "' '", "':'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, "GPS", "DATE", "TIME", "VAT_NUMBER", 
			"NEWLINE", "INT", "DIGIT", "LINK", "DASH", "MESSAGE", "LETTER"
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
	public String getGrammarFileName() { return "ShowProposalRealData.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public ShowProposalRealDataParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ProposalContext extends ParserRuleContext {
		public HeaderContext header() {
			return getRuleContext(HeaderContext.class,0);
		}
		public List<TerminalNode> NEWLINE() { return getTokens(ShowProposalRealDataParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(ShowProposalRealDataParser.NEWLINE, i);
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
		public ShowDetailsContext showDetails() {
			return getRuleContext(ShowDetailsContext.class,0);
		}
		public TerminalNode EOF() { return getToken(ShowProposalRealDataParser.EOF, 0); }
		public ProposalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_proposal; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShowProposalRealDataListener ) ((ShowProposalRealDataListener)listener).enterProposal(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShowProposalRealDataListener ) ((ShowProposalRealDataListener)listener).exitProposal(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ShowProposalRealDataVisitor ) return ((ShowProposalRealDataVisitor<? extends T>)visitor).visitProposal(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProposalContext proposal() throws RecognitionException {
		ProposalContext _localctx = new ProposalContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_proposal);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(72);
			header();
			setState(73);
			match(NEWLINE);
			setState(74);
			reference();
			setState(75);
			match(NEWLINE);
			setState(76);
			match(NEWLINE);
			setState(77);
			body();
			setState(78);
			match(NEWLINE);
			setState(79);
			match(NEWLINE);
			setState(80);
			closing();
			setState(81);
			match(NEWLINE);
			setState(82);
			match(NEWLINE);
			setState(83);
			signature();
			setState(84);
			match(NEWLINE);
			setState(85);
			match(NEWLINE);
			setState(88);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__0:
				{
				setState(86);
				match(T__0);
				}
				break;
			case T__1:
				{
				{
				setState(87);
				match(T__1);
				}
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(90);
			match(NEWLINE);
			setState(91);
			match(NEWLINE);
			setState(92);
			showDetails();
			setState(93);
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
	public static class ProposalNewTryContext extends ParserRuleContext {
		public ProposalWithRepContext proposalWithRep() {
			return getRuleContext(ProposalWithRepContext.class,0);
		}
		public ProposalWithoutRepContext proposalWithoutRep() {
			return getRuleContext(ProposalWithoutRepContext.class,0);
		}
		public ProposalNewTryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_proposalNewTry; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShowProposalRealDataListener ) ((ShowProposalRealDataListener)listener).enterProposalNewTry(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShowProposalRealDataListener ) ((ShowProposalRealDataListener)listener).exitProposalNewTry(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ShowProposalRealDataVisitor ) return ((ShowProposalRealDataVisitor<? extends T>)visitor).visitProposalNewTry(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProposalNewTryContext proposalNewTry() throws RecognitionException {
		ProposalNewTryContext _localctx = new ProposalNewTryContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_proposalNewTry);
		try {
			setState(97);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(95);
				proposalWithRep();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(96);
				proposalWithoutRep();
				}
				break;
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
	public static class ProposalWithRepContext extends ParserRuleContext {
		public GreetingContext greeting() {
			return getRuleContext(GreetingContext.class,0);
		}
		public TerminalNode NEWLINE() { return getToken(ShowProposalRealDataParser.NEWLINE, 0); }
		public CompanyInfoContext companyInfo() {
			return getRuleContext(CompanyInfoContext.class,0);
		}
		public ProposalWithRepContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_proposalWithRep; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShowProposalRealDataListener ) ((ShowProposalRealDataListener)listener).enterProposalWithRep(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShowProposalRealDataListener ) ((ShowProposalRealDataListener)listener).exitProposalWithRep(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ShowProposalRealDataVisitor ) return ((ShowProposalRealDataVisitor<? extends T>)visitor).visitProposalWithRep(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProposalWithRepContext proposalWithRep() throws RecognitionException {
		ProposalWithRepContext _localctx = new ProposalWithRepContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_proposalWithRep);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(99);
			greeting();
			setState(100);
			match(NEWLINE);
			setState(101);
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
	public static class ProposalWithoutRepContext extends ParserRuleContext {
		public GreetingContext greeting() {
			return getRuleContext(GreetingContext.class,0);
		}
		public TerminalNode NEWLINE() { return getToken(ShowProposalRealDataParser.NEWLINE, 0); }
		public CompanyInfoWithoutRepContext companyInfoWithoutRep() {
			return getRuleContext(CompanyInfoWithoutRepContext.class,0);
		}
		public ProposalWithoutRepContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_proposalWithoutRep; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShowProposalRealDataListener ) ((ShowProposalRealDataListener)listener).enterProposalWithoutRep(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShowProposalRealDataListener ) ((ShowProposalRealDataListener)listener).exitProposalWithoutRep(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ShowProposalRealDataVisitor ) return ((ShowProposalRealDataVisitor<? extends T>)visitor).visitProposalWithoutRep(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProposalWithoutRepContext proposalWithoutRep() throws RecognitionException {
		ProposalWithoutRepContext _localctx = new ProposalWithoutRepContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_proposalWithoutRep);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(103);
			greeting();
			setState(104);
			match(NEWLINE);
			setState(105);
			companyInfoWithoutRep();
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
		public TerminalNode NEWLINE() { return getToken(ShowProposalRealDataParser.NEWLINE, 0); }
		public CompanyInfoContext companyInfo() {
			return getRuleContext(CompanyInfoContext.class,0);
		}
		public CompanyInfoWithoutRepContext companyInfoWithoutRep() {
			return getRuleContext(CompanyInfoWithoutRepContext.class,0);
		}
		public HeaderContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_header; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShowProposalRealDataListener ) ((ShowProposalRealDataListener)listener).enterHeader(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShowProposalRealDataListener ) ((ShowProposalRealDataListener)listener).exitHeader(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ShowProposalRealDataVisitor ) return ((ShowProposalRealDataVisitor<? extends T>)visitor).visitHeader(this);
			else return visitor.visitChildren(this);
		}
	}

	public final HeaderContext header() throws RecognitionException {
		HeaderContext _localctx = new HeaderContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_header);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(107);
			greeting();
			setState(108);
			match(NEWLINE);
			setState(111);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				{
				setState(109);
				companyInfo();
				}
				break;
			case 2:
				{
				setState(110);
				companyInfoWithoutRep();
				}
				break;
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
	public static class GreetingContext extends ParserRuleContext {
		public GreetingContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_greeting; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShowProposalRealDataListener ) ((ShowProposalRealDataListener)listener).enterGreeting(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShowProposalRealDataListener ) ((ShowProposalRealDataListener)listener).exitGreeting(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ShowProposalRealDataVisitor ) return ((ShowProposalRealDataVisitor<? extends T>)visitor).visitGreeting(this);
			else return visitor.visitChildren(this);
		}
	}

	public final GreetingContext greeting() throws RecognitionException {
		GreetingContext _localctx = new GreetingContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_greeting);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(113);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 56L) != 0)) ) {
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
		public List<DescriptionNameContext> descriptionName() {
			return getRuleContexts(DescriptionNameContext.class);
		}
		public DescriptionNameContext descriptionName(int i) {
			return getRuleContext(DescriptionNameContext.class,i);
		}
		public List<TerminalNode> NEWLINE() { return getTokens(ShowProposalRealDataParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(ShowProposalRealDataParser.NEWLINE, i);
		}
		public VatNumberContext vatNumber() {
			return getRuleContext(VatNumberContext.class,0);
		}
		public CompanyInfoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_companyInfo; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShowProposalRealDataListener ) ((ShowProposalRealDataListener)listener).enterCompanyInfo(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShowProposalRealDataListener ) ((ShowProposalRealDataListener)listener).exitCompanyInfo(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ShowProposalRealDataVisitor ) return ((ShowProposalRealDataVisitor<? extends T>)visitor).visitCompanyInfo(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CompanyInfoContext companyInfo() throws RecognitionException {
		CompanyInfoContext _localctx = new CompanyInfoContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_companyInfo);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(115);
			descriptionName();
			setState(116);
			match(NEWLINE);
			setState(117);
			descriptionName();
			setState(118);
			match(NEWLINE);
			setState(119);
			vatNumber();
			setState(120);
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
	public static class CompanyInfoWithoutRepContext extends ParserRuleContext {
		public List<DescriptionNameContext> descriptionName() {
			return getRuleContexts(DescriptionNameContext.class);
		}
		public DescriptionNameContext descriptionName(int i) {
			return getRuleContext(DescriptionNameContext.class,i);
		}
		public List<TerminalNode> NEWLINE() { return getTokens(ShowProposalRealDataParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(ShowProposalRealDataParser.NEWLINE, i);
		}
		public VatNumberContext vatNumber() {
			return getRuleContext(VatNumberContext.class,0);
		}
		public CompanyInfoWithoutRepContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_companyInfoWithoutRep; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShowProposalRealDataListener ) ((ShowProposalRealDataListener)listener).enterCompanyInfoWithoutRep(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShowProposalRealDataListener ) ((ShowProposalRealDataListener)listener).exitCompanyInfoWithoutRep(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ShowProposalRealDataVisitor ) return ((ShowProposalRealDataVisitor<? extends T>)visitor).visitCompanyInfoWithoutRep(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CompanyInfoWithoutRepContext companyInfoWithoutRep() throws RecognitionException {
		CompanyInfoWithoutRepContext _localctx = new CompanyInfoWithoutRepContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_companyInfoWithoutRep);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(122);
			descriptionName();
			setState(123);
			match(NEWLINE);
			setState(124);
			descriptionName();
			setState(125);
			match(NEWLINE);
			setState(126);
			descriptionName();
			setState(127);
			match(NEWLINE);
			setState(128);
			vatNumber();
			setState(129);
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
	public static class VatNumberContext extends ParserRuleContext {
		public TerminalNode VAT_NUMBER() { return getToken(ShowProposalRealDataParser.VAT_NUMBER, 0); }
		public VatNumberContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_vatNumber; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShowProposalRealDataListener ) ((ShowProposalRealDataListener)listener).enterVatNumber(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShowProposalRealDataListener ) ((ShowProposalRealDataListener)listener).exitVatNumber(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ShowProposalRealDataVisitor ) return ((ShowProposalRealDataVisitor<? extends T>)visitor).visitVatNumber(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VatNumberContext vatNumber() throws RecognitionException {
		VatNumberContext _localctx = new VatNumberContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_vatNumber);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(131);
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
	public static class ReferenceContext extends ParserRuleContext {
		public RealReferenceContext realReference() {
			return getRuleContext(RealReferenceContext.class,0);
		}
		public TerminalNode NEWLINE() { return getToken(ShowProposalRealDataParser.NEWLINE, 0); }
		public TitleProposalContext titleProposal() {
			return getRuleContext(TitleProposalContext.class,0);
		}
		public ReferenceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_reference; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShowProposalRealDataListener ) ((ShowProposalRealDataListener)listener).enterReference(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShowProposalRealDataListener ) ((ShowProposalRealDataListener)listener).exitReference(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ShowProposalRealDataVisitor ) return ((ShowProposalRealDataVisitor<? extends T>)visitor).visitReference(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ReferenceContext reference() throws RecognitionException {
		ReferenceContext _localctx = new ReferenceContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_reference);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(133);
			realReference();
			setState(134);
			match(NEWLINE);
			setState(135);
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
		public TerminalNode INT() { return getToken(ShowProposalRealDataParser.INT, 0); }
		public TerminalNode DATE() { return getToken(ShowProposalRealDataParser.DATE, 0); }
		public RealReferenceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_realReference; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShowProposalRealDataListener ) ((ShowProposalRealDataListener)listener).enterRealReference(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShowProposalRealDataListener ) ((ShowProposalRealDataListener)listener).exitRealReference(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ShowProposalRealDataVisitor ) return ((ShowProposalRealDataVisitor<? extends T>)visitor).visitRealReference(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RealReferenceContext realReference() throws RecognitionException {
		RealReferenceContext _localctx = new RealReferenceContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_realReference);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(137);
			_la = _input.LA(1);
			if ( !(_la==T__5 || _la==T__6) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(138);
			match(INT);
			setState(139);
			match(T__7);
			setState(140);
			match(DATE);
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
			if ( listener instanceof ShowProposalRealDataListener ) ((ShowProposalRealDataListener)listener).enterTitleProposal(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShowProposalRealDataListener ) ((ShowProposalRealDataListener)listener).exitTitleProposal(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ShowProposalRealDataVisitor ) return ((ShowProposalRealDataVisitor<? extends T>)visitor).visitTitleProposal(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TitleProposalContext titleProposal() throws RecognitionException {
		TitleProposalContext _localctx = new TitleProposalContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_titleProposal);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(142);
			_la = _input.LA(1);
			if ( !(_la==T__8 || _la==T__9) ) {
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
		public List<TerminalNode> NEWLINE() { return getTokens(ShowProposalRealDataParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(ShowProposalRealDataParser.NEWLINE, i);
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
			if ( listener instanceof ShowProposalRealDataListener ) ((ShowProposalRealDataListener)listener).enterBody(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShowProposalRealDataListener ) ((ShowProposalRealDataListener)listener).exitBody(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ShowProposalRealDataVisitor ) return ((ShowProposalRealDataVisitor<? extends T>)visitor).visitBody(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BodyContext body() throws RecognitionException {
		BodyContext _localctx = new BodyContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_body);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(144);
			line_1();
			setState(145);
			match(NEWLINE);
			setState(146);
			line_2();
			setState(147);
			match(NEWLINE);
			setState(148);
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
			if ( listener instanceof ShowProposalRealDataListener ) ((ShowProposalRealDataListener)listener).enterLine_1(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShowProposalRealDataListener ) ((ShowProposalRealDataListener)listener).exitLine_1(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ShowProposalRealDataVisitor ) return ((ShowProposalRealDataVisitor<? extends T>)visitor).visitLine_1(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Line_1Context line_1() throws RecognitionException {
		Line_1Context _localctx = new Line_1Context(_ctx, getState());
		enterRule(_localctx, 26, RULE_line_1);
		try {
			setState(152);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__10:
			case T__11:
				enterOuterAlt(_localctx, 1);
				{
				setState(150);
				normal_line1();
				}
				break;
			case T__48:
			case T__49:
			case T__50:
			case T__51:
			case T__52:
			case INT:
			case DIGIT:
			case DASH:
			case MESSAGE:
				enterOuterAlt(_localctx, 2);
				{
				setState(151);
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
		public Normal_line1Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_normal_line1; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShowProposalRealDataListener ) ((ShowProposalRealDataListener)listener).enterNormal_line1(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShowProposalRealDataListener ) ((ShowProposalRealDataListener)listener).exitNormal_line1(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ShowProposalRealDataVisitor ) return ((ShowProposalRealDataVisitor<? extends T>)visitor).visitNormal_line1(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Normal_line1Context normal_line1() throws RecognitionException {
		Normal_line1Context _localctx = new Normal_line1Context(_ctx, getState());
		enterRule(_localctx, 28, RULE_normal_line1);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(154);
			_la = _input.LA(1);
			if ( !(_la==T__10 || _la==T__11) ) {
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
	public static class Vip_line1Context extends ParserRuleContext {
		public DescriptionNameContext descriptionName() {
			return getRuleContext(DescriptionNameContext.class,0);
		}
		public Vip_line1Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_vip_line1; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShowProposalRealDataListener ) ((ShowProposalRealDataListener)listener).enterVip_line1(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShowProposalRealDataListener ) ((ShowProposalRealDataListener)listener).exitVip_line1(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ShowProposalRealDataVisitor ) return ((ShowProposalRealDataVisitor<? extends T>)visitor).visitVip_line1(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Vip_line1Context vip_line1() throws RecognitionException {
		Vip_line1Context _localctx = new Vip_line1Context(_ctx, getState());
		enterRule(_localctx, 30, RULE_vip_line1);
		try {
			setState(162);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(156);
				descriptionName();
				setState(157);
				match(T__12);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(159);
				descriptionName();
				setState(160);
				match(T__13);
				}
				break;
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
		public Line_2Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_line_2; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShowProposalRealDataListener ) ((ShowProposalRealDataListener)listener).enterLine_2(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShowProposalRealDataListener ) ((ShowProposalRealDataListener)listener).exitLine_2(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ShowProposalRealDataVisitor ) return ((ShowProposalRealDataVisitor<? extends T>)visitor).visitLine_2(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Line_2Context line_2() throws RecognitionException {
		Line_2Context _localctx = new Line_2Context(_ctx, getState());
		enterRule(_localctx, 32, RULE_line_2);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(164);
			_la = _input.LA(1);
			if ( !(_la==T__14 || _la==T__15) ) {
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
	public static class Line_3Context extends ParserRuleContext {
		public TerminalNode LINK() { return getToken(ShowProposalRealDataParser.LINK, 0); }
		public Line_3Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_line_3; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShowProposalRealDataListener ) ((ShowProposalRealDataListener)listener).enterLine_3(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShowProposalRealDataListener ) ((ShowProposalRealDataListener)listener).exitLine_3(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ShowProposalRealDataVisitor ) return ((ShowProposalRealDataVisitor<? extends T>)visitor).visitLine_3(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Line_3Context line_3() throws RecognitionException {
		Line_3Context _localctx = new Line_3Context(_ctx, getState());
		enterRule(_localctx, 34, RULE_line_3);
		try {
			setState(172);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__16:
				enterOuterAlt(_localctx, 1);
				{
				setState(166);
				match(T__16);
				setState(167);
				match(LINK);
				setState(168);
				match(T__17);
				}
				break;
			case T__18:
				enterOuterAlt(_localctx, 2);
				{
				setState(169);
				match(T__18);
				setState(170);
				match(LINK);
				setState(171);
				match(T__19);
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
	public static class ClosingContext extends ParserRuleContext {
		public TerminalNode INT() { return getToken(ShowProposalRealDataParser.INT, 0); }
		public ClosingContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_closing; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShowProposalRealDataListener ) ((ShowProposalRealDataListener)listener).enterClosing(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShowProposalRealDataListener ) ((ShowProposalRealDataListener)listener).exitClosing(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ShowProposalRealDataVisitor ) return ((ShowProposalRealDataVisitor<? extends T>)visitor).visitClosing(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ClosingContext closing() throws RecognitionException {
		ClosingContext _localctx = new ClosingContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_closing);
		try {
			setState(180);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__20:
				enterOuterAlt(_localctx, 1);
				{
				setState(174);
				match(T__20);
				setState(175);
				match(INT);
				setState(176);
				match(T__21);
				}
				break;
			case T__22:
				enterOuterAlt(_localctx, 2);
				{
				setState(177);
				match(T__22);
				setState(178);
				match(INT);
				setState(179);
				match(T__23);
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
	public static class SignatureContext extends ParserRuleContext {
		public Signature_optionContext signature_option() {
			return getRuleContext(Signature_optionContext.class,0);
		}
		public List<TerminalNode> NEWLINE() { return getTokens(ShowProposalRealDataParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(ShowProposalRealDataParser.NEWLINE, i);
		}
		public RegardsContext regards() {
			return getRuleContext(RegardsContext.class,0);
		}
		public DescriptionNameContext descriptionName() {
			return getRuleContext(DescriptionNameContext.class,0);
		}
		public SignatureContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_signature; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShowProposalRealDataListener ) ((ShowProposalRealDataListener)listener).enterSignature(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShowProposalRealDataListener ) ((ShowProposalRealDataListener)listener).exitSignature(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ShowProposalRealDataVisitor ) return ((ShowProposalRealDataVisitor<? extends T>)visitor).visitSignature(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SignatureContext signature() throws RecognitionException {
		SignatureContext _localctx = new SignatureContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_signature);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(182);
			signature_option();
			setState(183);
			match(NEWLINE);
			setState(184);
			regards();
			setState(185);
			match(NEWLINE);
			setState(186);
			match(NEWLINE);
			setState(187);
			descriptionName();
			setState(188);
			match(NEWLINE);
			setState(189);
			match(T__24);
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
		public List<TerminalNode> NEWLINE() { return getTokens(ShowProposalRealDataParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(ShowProposalRealDataParser.NEWLINE, i);
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
			if ( listener instanceof ShowProposalRealDataListener ) ((ShowProposalRealDataListener)listener).enterSignature_option(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShowProposalRealDataListener ) ((ShowProposalRealDataListener)listener).exitSignature_option(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ShowProposalRealDataVisitor ) return ((ShowProposalRealDataVisitor<? extends T>)visitor).visitSignature_option(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Signature_optionContext signature_option() throws RecognitionException {
		Signature_optionContext _localctx = new Signature_optionContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_signature_option);
		try {
			setState(200);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__25:
			case T__26:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(191);
				preferencePhrase();
				setState(192);
				match(NEWLINE);
				setState(193);
				match(NEWLINE);
				setState(194);
				subscribePhrase();
				setState(195);
				match(NEWLINE);
				}
				}
				break;
			case T__29:
				enterOuterAlt(_localctx, 2);
				{
				setState(197);
				lastPhrase();
				setState(198);
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
			if ( listener instanceof ShowProposalRealDataListener ) ((ShowProposalRealDataListener)listener).enterPreferencePhrase(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShowProposalRealDataListener ) ((ShowProposalRealDataListener)listener).exitPreferencePhrase(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ShowProposalRealDataVisitor ) return ((ShowProposalRealDataVisitor<? extends T>)visitor).visitPreferencePhrase(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PreferencePhraseContext preferencePhrase() throws RecognitionException {
		PreferencePhraseContext _localctx = new PreferencePhraseContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_preferencePhrase);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(202);
			_la = _input.LA(1);
			if ( !(_la==T__25 || _la==T__26) ) {
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
			if ( listener instanceof ShowProposalRealDataListener ) ((ShowProposalRealDataListener)listener).enterSubscribePhrase(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShowProposalRealDataListener ) ((ShowProposalRealDataListener)listener).exitSubscribePhrase(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ShowProposalRealDataVisitor ) return ((ShowProposalRealDataVisitor<? extends T>)visitor).visitSubscribePhrase(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SubscribePhraseContext subscribePhrase() throws RecognitionException {
		SubscribePhraseContext _localctx = new SubscribePhraseContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_subscribePhrase);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(204);
			_la = _input.LA(1);
			if ( !(_la==T__27 || _la==T__28) ) {
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
			if ( listener instanceof ShowProposalRealDataListener ) ((ShowProposalRealDataListener)listener).enterLastPhrase(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShowProposalRealDataListener ) ((ShowProposalRealDataListener)listener).exitLastPhrase(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ShowProposalRealDataVisitor ) return ((ShowProposalRealDataVisitor<? extends T>)visitor).visitLastPhrase(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LastPhraseContext lastPhrase() throws RecognitionException {
		LastPhraseContext _localctx = new LastPhraseContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_lastPhrase);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(206);
			match(T__29);
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
			if ( listener instanceof ShowProposalRealDataListener ) ((ShowProposalRealDataListener)listener).enterRegards(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShowProposalRealDataListener ) ((ShowProposalRealDataListener)listener).exitRegards(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ShowProposalRealDataVisitor ) return ((ShowProposalRealDataVisitor<? extends T>)visitor).visitRegards(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RegardsContext regards() throws RecognitionException {
		RegardsContext _localctx = new RegardsContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_regards);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(208);
			_la = _input.LA(1);
			if ( !(_la==T__30 || _la==T__31) ) {
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
		public AttachmentContext attachment() {
			return getRuleContext(AttachmentContext.class,0);
		}
		public List<TerminalNode> NEWLINE() { return getTokens(ShowProposalRealDataParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(ShowProposalRealDataParser.NEWLINE, i);
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
			if ( listener instanceof ShowProposalRealDataListener ) ((ShowProposalRealDataListener)listener).enterShowDetails(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShowProposalRealDataListener ) ((ShowProposalRealDataListener)listener).exitShowDetails(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ShowProposalRealDataVisitor ) return ((ShowProposalRealDataVisitor<? extends T>)visitor).visitShowDetails(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ShowDetailsContext showDetails() throws RecognitionException {
		ShowDetailsContext _localctx = new ShowDetailsContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_showDetails);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(210);
			attachment();
			setState(211);
			match(NEWLINE);
			setState(212);
			match(NEWLINE);
			setState(213);
			location();
			setState(214);
			match(NEWLINE);
			setState(215);
			date();
			setState(216);
			match(NEWLINE);
			setState(217);
			time();
			setState(218);
			match(NEWLINE);
			setState(219);
			duration();
			setState(220);
			match(NEWLINE);
			setState(221);
			match(NEWLINE);
			setState(222);
			droneList();
			setState(223);
			match(NEWLINE);
			setState(224);
			match(NEWLINE);
			setState(225);
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
		public TerminalNode INT() { return getToken(ShowProposalRealDataParser.INT, 0); }
		public AttachmentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_attachment; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShowProposalRealDataListener ) ((ShowProposalRealDataListener)listener).enterAttachment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShowProposalRealDataListener ) ((ShowProposalRealDataListener)listener).exitAttachment(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ShowProposalRealDataVisitor ) return ((ShowProposalRealDataVisitor<? extends T>)visitor).visitAttachment(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AttachmentContext attachment() throws RecognitionException {
		AttachmentContext _localctx = new AttachmentContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_attachment);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(227);
			_la = _input.LA(1);
			if ( !(_la==T__32 || _la==T__33) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(228);
			match(INT);
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
		public TerminalNode GPS() { return getToken(ShowProposalRealDataParser.GPS, 0); }
		public LocationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_location; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShowProposalRealDataListener ) ((ShowProposalRealDataListener)listener).enterLocation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShowProposalRealDataListener ) ((ShowProposalRealDataListener)listener).exitLocation(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ShowProposalRealDataVisitor ) return ((ShowProposalRealDataVisitor<? extends T>)visitor).visitLocation(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LocationContext location() throws RecognitionException {
		LocationContext _localctx = new LocationContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_location);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(230);
			_la = _input.LA(1);
			if ( !(_la==T__34 || _la==T__35) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(231);
			match(GPS);
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
		public TerminalNode DATE() { return getToken(ShowProposalRealDataParser.DATE, 0); }
		public DateContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_date; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShowProposalRealDataListener ) ((ShowProposalRealDataListener)listener).enterDate(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShowProposalRealDataListener ) ((ShowProposalRealDataListener)listener).exitDate(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ShowProposalRealDataVisitor ) return ((ShowProposalRealDataVisitor<? extends T>)visitor).visitDate(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DateContext date() throws RecognitionException {
		DateContext _localctx = new DateContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_date);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(233);
			_la = _input.LA(1);
			if ( !(_la==T__36 || _la==T__37) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(234);
			match(DATE);
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
		public TerminalNode TIME() { return getToken(ShowProposalRealDataParser.TIME, 0); }
		public TimeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_time; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShowProposalRealDataListener ) ((ShowProposalRealDataListener)listener).enterTime(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShowProposalRealDataListener ) ((ShowProposalRealDataListener)listener).exitTime(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ShowProposalRealDataVisitor ) return ((ShowProposalRealDataVisitor<? extends T>)visitor).visitTime(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TimeContext time() throws RecognitionException {
		TimeContext _localctx = new TimeContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_time);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(236);
			_la = _input.LA(1);
			if ( !(_la==T__38 || _la==T__39) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(237);
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
		public TerminalNode INT() { return getToken(ShowProposalRealDataParser.INT, 0); }
		public DurationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_duration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShowProposalRealDataListener ) ((ShowProposalRealDataListener)listener).enterDuration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShowProposalRealDataListener ) ((ShowProposalRealDataListener)listener).exitDuration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ShowProposalRealDataVisitor ) return ((ShowProposalRealDataVisitor<? extends T>)visitor).visitDuration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DurationContext duration() throws RecognitionException {
		DurationContext _localctx = new DurationContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_duration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(239);
			_la = _input.LA(1);
			if ( !(_la==T__40 || _la==T__41) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(240);
			match(INT);
			setState(241);
			_la = _input.LA(1);
			if ( !(_la==T__42 || _la==T__43) ) {
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
	public static class DroneListContext extends ParserRuleContext {
		public TerminalNode NEWLINE() { return getToken(ShowProposalRealDataParser.NEWLINE, 0); }
		public List<DroneListRealContext> droneListReal() {
			return getRuleContexts(DroneListRealContext.class);
		}
		public DroneListRealContext droneListReal(int i) {
			return getRuleContext(DroneListRealContext.class,i);
		}
		public DroneListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_droneList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShowProposalRealDataListener ) ((ShowProposalRealDataListener)listener).enterDroneList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShowProposalRealDataListener ) ((ShowProposalRealDataListener)listener).exitDroneList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ShowProposalRealDataVisitor ) return ((ShowProposalRealDataVisitor<? extends T>)visitor).visitDroneList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DroneListContext droneList() throws RecognitionException {
		DroneListContext _localctx = new DroneListContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_droneList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(243);
			_la = _input.LA(1);
			if ( !(_la==T__44 || _la==T__45) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(244);
			match(NEWLINE);
			setState(246); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(245);
				droneListReal();
				}
				}
				setState(248); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & -2864852312961056768L) != 0) );
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
		public DescriptionNameContext descriptionName() {
			return getRuleContext(DescriptionNameContext.class,0);
		}
		public TerminalNode NEWLINE() { return getToken(ShowProposalRealDataParser.NEWLINE, 0); }
		public DroneListRealContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_droneListReal; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShowProposalRealDataListener ) ((ShowProposalRealDataListener)listener).enterDroneListReal(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShowProposalRealDataListener ) ((ShowProposalRealDataListener)listener).exitDroneListReal(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ShowProposalRealDataVisitor ) return ((ShowProposalRealDataVisitor<? extends T>)visitor).visitDroneListReal(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DroneListRealContext droneListReal() throws RecognitionException {
		DroneListRealContext _localctx = new DroneListRealContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_droneListReal);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(250);
			descriptionName();
			setState(252);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				{
				setState(251);
				match(NEWLINE);
				}
				break;
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
		public TerminalNode NEWLINE() { return getToken(ShowProposalRealDataParser.NEWLINE, 0); }
		public List<FigureListRealContext> figureListReal() {
			return getRuleContexts(FigureListRealContext.class);
		}
		public FigureListRealContext figureListReal(int i) {
			return getRuleContext(FigureListRealContext.class,i);
		}
		public FigureListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_figureList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShowProposalRealDataListener ) ((ShowProposalRealDataListener)listener).enterFigureList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShowProposalRealDataListener ) ((ShowProposalRealDataListener)listener).exitFigureList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ShowProposalRealDataVisitor ) return ((ShowProposalRealDataVisitor<? extends T>)visitor).visitFigureList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FigureListContext figureList() throws RecognitionException {
		FigureListContext _localctx = new FigureListContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_figureList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(254);
			_la = _input.LA(1);
			if ( !(_la==T__46 || _la==T__47) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(255);
			match(NEWLINE);
			setState(257); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(256);
				figureListReal();
				}
				}
				setState(259); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & -2864852312961056768L) != 0) );
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
		public DescriptionNameContext descriptionName() {
			return getRuleContext(DescriptionNameContext.class,0);
		}
		public TerminalNode NEWLINE() { return getToken(ShowProposalRealDataParser.NEWLINE, 0); }
		public FigureListRealContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_figureListReal; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShowProposalRealDataListener ) ((ShowProposalRealDataListener)listener).enterFigureListReal(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShowProposalRealDataListener ) ((ShowProposalRealDataListener)listener).exitFigureListReal(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ShowProposalRealDataVisitor ) return ((ShowProposalRealDataVisitor<? extends T>)visitor).visitFigureListReal(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FigureListRealContext figureListReal() throws RecognitionException {
		FigureListRealContext _localctx = new FigureListRealContext(_ctx, getState());
		enterRule(_localctx, 68, RULE_figureListReal);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(261);
			descriptionName();
			setState(263);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==NEWLINE) {
				{
				setState(262);
				match(NEWLINE);
				}
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
	public static class DescriptionNameContext extends ParserRuleContext {
		public List<TerminalNode> MESSAGE() { return getTokens(ShowProposalRealDataParser.MESSAGE); }
		public TerminalNode MESSAGE(int i) {
			return getToken(ShowProposalRealDataParser.MESSAGE, i);
		}
		public List<TerminalNode> INT() { return getTokens(ShowProposalRealDataParser.INT); }
		public TerminalNode INT(int i) {
			return getToken(ShowProposalRealDataParser.INT, i);
		}
		public List<TerminalNode> DIGIT() { return getTokens(ShowProposalRealDataParser.DIGIT); }
		public TerminalNode DIGIT(int i) {
			return getToken(ShowProposalRealDataParser.DIGIT, i);
		}
		public List<TerminalNode> DASH() { return getTokens(ShowProposalRealDataParser.DASH); }
		public TerminalNode DASH(int i) {
			return getToken(ShowProposalRealDataParser.DASH, i);
		}
		public DescriptionNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_descriptionName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShowProposalRealDataListener ) ((ShowProposalRealDataListener)listener).enterDescriptionName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShowProposalRealDataListener ) ((ShowProposalRealDataListener)listener).exitDescriptionName(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ShowProposalRealDataVisitor ) return ((ShowProposalRealDataVisitor<? extends T>)visitor).visitDescriptionName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DescriptionNameContext descriptionName() throws RecognitionException {
		DescriptionNameContext _localctx = new DescriptionNameContext(_ctx, getState());
		enterRule(_localctx, 70, RULE_descriptionName);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(266); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(265);
					_la = _input.LA(1);
					if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & -2864852312961056768L) != 0)) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(268); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
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
		"\u0004\u0001@\u010f\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
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
		"#\u0007#\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001"+
		"\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001"+
		"\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0003\u0000Y\b"+
		"\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001"+
		"\u0001\u0001\u0001\u0003\u0001b\b\u0001\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0003\u0004p\b\u0004\u0001"+
		"\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\b\u0001\b\u0001\t\u0001\t\u0001\t\u0001\t\u0001\n\u0001\n\u0001\n\u0001"+
		"\n\u0001\n\u0001\u000b\u0001\u000b\u0001\f\u0001\f\u0001\f\u0001\f\u0001"+
		"\f\u0001\f\u0001\r\u0001\r\u0003\r\u0099\b\r\u0001\u000e\u0001\u000e\u0001"+
		"\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0003"+
		"\u000f\u00a3\b\u000f\u0001\u0010\u0001\u0010\u0001\u0011\u0001\u0011\u0001"+
		"\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0003\u0011\u00ad\b\u0011\u0001"+
		"\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0003"+
		"\u0012\u00b5\b\u0012\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001"+
		"\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0014\u0001"+
		"\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001"+
		"\u0014\u0001\u0014\u0003\u0014\u00c9\b\u0014\u0001\u0015\u0001\u0015\u0001"+
		"\u0016\u0001\u0016\u0001\u0017\u0001\u0017\u0001\u0018\u0001\u0018\u0001"+
		"\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0001"+
		"\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0001"+
		"\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u001a\u0001"+
		"\u001a\u0001\u001a\u0001\u001b\u0001\u001b\u0001\u001b\u0001\u001c\u0001"+
		"\u001c\u0001\u001c\u0001\u001d\u0001\u001d\u0001\u001d\u0001\u001e\u0001"+
		"\u001e\u0001\u001e\u0001\u001e\u0001\u001f\u0001\u001f\u0001\u001f\u0004"+
		"\u001f\u00f7\b\u001f\u000b\u001f\f\u001f\u00f8\u0001 \u0001 \u0003 \u00fd"+
		"\b \u0001!\u0001!\u0001!\u0004!\u0102\b!\u000b!\f!\u0103\u0001\"\u0001"+
		"\"\u0003\"\u0108\b\"\u0001#\u0004#\u010b\b#\u000b#\f#\u010c\u0001#\u0000"+
		"\u0000$\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018"+
		"\u001a\u001c\u001e \"$&(*,.02468:<>@BDF\u0000\u0011\u0001\u0000\u0003"+
		"\u0005\u0001\u0000\u0006\u0007\u0001\u0000\t\n\u0001\u0000\u000b\f\u0001"+
		"\u0000\u000f\u0010\u0001\u0000\u001a\u001b\u0001\u0000\u001c\u001d\u0001"+
		"\u0000\u001f \u0001\u0000!\"\u0001\u0000#$\u0001\u0000%&\u0001\u0000\'"+
		"(\u0001\u0000)*\u0001\u0000+,\u0001\u0000-.\u0001\u0000/0\u0003\u0000"+
		"15;<>?\u00f7\u0000H\u0001\u0000\u0000\u0000\u0002a\u0001\u0000\u0000\u0000"+
		"\u0004c\u0001\u0000\u0000\u0000\u0006g\u0001\u0000\u0000\u0000\bk\u0001"+
		"\u0000\u0000\u0000\nq\u0001\u0000\u0000\u0000\fs\u0001\u0000\u0000\u0000"+
		"\u000ez\u0001\u0000\u0000\u0000\u0010\u0083\u0001\u0000\u0000\u0000\u0012"+
		"\u0085\u0001\u0000\u0000\u0000\u0014\u0089\u0001\u0000\u0000\u0000\u0016"+
		"\u008e\u0001\u0000\u0000\u0000\u0018\u0090\u0001\u0000\u0000\u0000\u001a"+
		"\u0098\u0001\u0000\u0000\u0000\u001c\u009a\u0001\u0000\u0000\u0000\u001e"+
		"\u00a2\u0001\u0000\u0000\u0000 \u00a4\u0001\u0000\u0000\u0000\"\u00ac"+
		"\u0001\u0000\u0000\u0000$\u00b4\u0001\u0000\u0000\u0000&\u00b6\u0001\u0000"+
		"\u0000\u0000(\u00c8\u0001\u0000\u0000\u0000*\u00ca\u0001\u0000\u0000\u0000"+
		",\u00cc\u0001\u0000\u0000\u0000.\u00ce\u0001\u0000\u0000\u00000\u00d0"+
		"\u0001\u0000\u0000\u00002\u00d2\u0001\u0000\u0000\u00004\u00e3\u0001\u0000"+
		"\u0000\u00006\u00e6\u0001\u0000\u0000\u00008\u00e9\u0001\u0000\u0000\u0000"+
		":\u00ec\u0001\u0000\u0000\u0000<\u00ef\u0001\u0000\u0000\u0000>\u00f3"+
		"\u0001\u0000\u0000\u0000@\u00fa\u0001\u0000\u0000\u0000B\u00fe\u0001\u0000"+
		"\u0000\u0000D\u0105\u0001\u0000\u0000\u0000F\u010a\u0001\u0000\u0000\u0000"+
		"HI\u0003\b\u0004\u0000IJ\u0005:\u0000\u0000JK\u0003\u0012\t\u0000KL\u0005"+
		":\u0000\u0000LM\u0005:\u0000\u0000MN\u0003\u0018\f\u0000NO\u0005:\u0000"+
		"\u0000OP\u0005:\u0000\u0000PQ\u0003$\u0012\u0000QR\u0005:\u0000\u0000"+
		"RS\u0005:\u0000\u0000ST\u0003&\u0013\u0000TU\u0005:\u0000\u0000UX\u0005"+
		":\u0000\u0000VY\u0005\u0001\u0000\u0000WY\u0005\u0002\u0000\u0000XV\u0001"+
		"\u0000\u0000\u0000XW\u0001\u0000\u0000\u0000YZ\u0001\u0000\u0000\u0000"+
		"Z[\u0005:\u0000\u0000[\\\u0005:\u0000\u0000\\]\u00032\u0019\u0000]^\u0005"+
		"\u0000\u0000\u0001^\u0001\u0001\u0000\u0000\u0000_b\u0003\u0004\u0002"+
		"\u0000`b\u0003\u0006\u0003\u0000a_\u0001\u0000\u0000\u0000a`\u0001\u0000"+
		"\u0000\u0000b\u0003\u0001\u0000\u0000\u0000cd\u0003\n\u0005\u0000de\u0005"+
		":\u0000\u0000ef\u0003\f\u0006\u0000f\u0005\u0001\u0000\u0000\u0000gh\u0003"+
		"\n\u0005\u0000hi\u0005:\u0000\u0000ij\u0003\u000e\u0007\u0000j\u0007\u0001"+
		"\u0000\u0000\u0000kl\u0003\n\u0005\u0000lo\u0005:\u0000\u0000mp\u0003"+
		"\f\u0006\u0000np\u0003\u000e\u0007\u0000om\u0001\u0000\u0000\u0000on\u0001"+
		"\u0000\u0000\u0000p\t\u0001\u0000\u0000\u0000qr\u0007\u0000\u0000\u0000"+
		"r\u000b\u0001\u0000\u0000\u0000st\u0003F#\u0000tu\u0005:\u0000\u0000u"+
		"v\u0003F#\u0000vw\u0005:\u0000\u0000wx\u0003\u0010\b\u0000xy\u0005:\u0000"+
		"\u0000y\r\u0001\u0000\u0000\u0000z{\u0003F#\u0000{|\u0005:\u0000\u0000"+
		"|}\u0003F#\u0000}~\u0005:\u0000\u0000~\u007f\u0003F#\u0000\u007f\u0080"+
		"\u0005:\u0000\u0000\u0080\u0081\u0003\u0010\b\u0000\u0081\u0082\u0005"+
		":\u0000\u0000\u0082\u000f\u0001\u0000\u0000\u0000\u0083\u0084\u00059\u0000"+
		"\u0000\u0084\u0011\u0001\u0000\u0000\u0000\u0085\u0086\u0003\u0014\n\u0000"+
		"\u0086\u0087\u0005:\u0000\u0000\u0087\u0088\u0003\u0016\u000b\u0000\u0088"+
		"\u0013\u0001\u0000\u0000\u0000\u0089\u008a\u0007\u0001\u0000\u0000\u008a"+
		"\u008b\u0005;\u0000\u0000\u008b\u008c\u0005\b\u0000\u0000\u008c\u008d"+
		"\u00057\u0000\u0000\u008d\u0015\u0001\u0000\u0000\u0000\u008e\u008f\u0007"+
		"\u0002\u0000\u0000\u008f\u0017\u0001\u0000\u0000\u0000\u0090\u0091\u0003"+
		"\u001a\r\u0000\u0091\u0092\u0005:\u0000\u0000\u0092\u0093\u0003 \u0010"+
		"\u0000\u0093\u0094\u0005:\u0000\u0000\u0094\u0095\u0003\"\u0011\u0000"+
		"\u0095\u0019\u0001\u0000\u0000\u0000\u0096\u0099\u0003\u001c\u000e\u0000"+
		"\u0097\u0099\u0003\u001e\u000f\u0000\u0098\u0096\u0001\u0000\u0000\u0000"+
		"\u0098\u0097\u0001\u0000\u0000\u0000\u0099\u001b\u0001\u0000\u0000\u0000"+
		"\u009a\u009b\u0007\u0003\u0000\u0000\u009b\u001d\u0001\u0000\u0000\u0000"+
		"\u009c\u009d\u0003F#\u0000\u009d\u009e\u0005\r\u0000\u0000\u009e\u00a3"+
		"\u0001\u0000\u0000\u0000\u009f\u00a0\u0003F#\u0000\u00a0\u00a1\u0005\u000e"+
		"\u0000\u0000\u00a1\u00a3\u0001\u0000\u0000\u0000\u00a2\u009c\u0001\u0000"+
		"\u0000\u0000\u00a2\u009f\u0001\u0000\u0000\u0000\u00a3\u001f\u0001\u0000"+
		"\u0000\u0000\u00a4\u00a5\u0007\u0004\u0000\u0000\u00a5!\u0001\u0000\u0000"+
		"\u0000\u00a6\u00a7\u0005\u0011\u0000\u0000\u00a7\u00a8\u0005=\u0000\u0000"+
		"\u00a8\u00ad\u0005\u0012\u0000\u0000\u00a9\u00aa\u0005\u0013\u0000\u0000"+
		"\u00aa\u00ab\u0005=\u0000\u0000\u00ab\u00ad\u0005\u0014\u0000\u0000\u00ac"+
		"\u00a6\u0001\u0000\u0000\u0000\u00ac\u00a9\u0001\u0000\u0000\u0000\u00ad"+
		"#\u0001\u0000\u0000\u0000\u00ae\u00af\u0005\u0015\u0000\u0000\u00af\u00b0"+
		"\u0005;\u0000\u0000\u00b0\u00b5\u0005\u0016\u0000\u0000\u00b1\u00b2\u0005"+
		"\u0017\u0000\u0000\u00b2\u00b3\u0005;\u0000\u0000\u00b3\u00b5\u0005\u0018"+
		"\u0000\u0000\u00b4\u00ae\u0001\u0000\u0000\u0000\u00b4\u00b1\u0001\u0000"+
		"\u0000\u0000\u00b5%\u0001\u0000\u0000\u0000\u00b6\u00b7\u0003(\u0014\u0000"+
		"\u00b7\u00b8\u0005:\u0000\u0000\u00b8\u00b9\u00030\u0018\u0000\u00b9\u00ba"+
		"\u0005:\u0000\u0000\u00ba\u00bb\u0005:\u0000\u0000\u00bb\u00bc\u0003F"+
		"#\u0000\u00bc\u00bd\u0005:\u0000\u0000\u00bd\u00be\u0005\u0019\u0000\u0000"+
		"\u00be\'\u0001\u0000\u0000\u0000\u00bf\u00c0\u0003*\u0015\u0000\u00c0"+
		"\u00c1\u0005:\u0000\u0000\u00c1\u00c2\u0005:\u0000\u0000\u00c2\u00c3\u0003"+
		",\u0016\u0000\u00c3\u00c4\u0005:\u0000\u0000\u00c4\u00c9\u0001\u0000\u0000"+
		"\u0000\u00c5\u00c6\u0003.\u0017\u0000\u00c6\u00c7\u0005:\u0000\u0000\u00c7"+
		"\u00c9\u0001\u0000\u0000\u0000\u00c8\u00bf\u0001\u0000\u0000\u0000\u00c8"+
		"\u00c5\u0001\u0000\u0000\u0000\u00c9)\u0001\u0000\u0000\u0000\u00ca\u00cb"+
		"\u0007\u0005\u0000\u0000\u00cb+\u0001\u0000\u0000\u0000\u00cc\u00cd\u0007"+
		"\u0006\u0000\u0000\u00cd-\u0001\u0000\u0000\u0000\u00ce\u00cf\u0005\u001e"+
		"\u0000\u0000\u00cf/\u0001\u0000\u0000\u0000\u00d0\u00d1\u0007\u0007\u0000"+
		"\u0000\u00d11\u0001\u0000\u0000\u0000\u00d2\u00d3\u00034\u001a\u0000\u00d3"+
		"\u00d4\u0005:\u0000\u0000\u00d4\u00d5\u0005:\u0000\u0000\u00d5\u00d6\u0003"+
		"6\u001b\u0000\u00d6\u00d7\u0005:\u0000\u0000\u00d7\u00d8\u00038\u001c"+
		"\u0000\u00d8\u00d9\u0005:\u0000\u0000\u00d9\u00da\u0003:\u001d\u0000\u00da"+
		"\u00db\u0005:\u0000\u0000\u00db\u00dc\u0003<\u001e\u0000\u00dc\u00dd\u0005"+
		":\u0000\u0000\u00dd\u00de\u0005:\u0000\u0000\u00de\u00df\u0003>\u001f"+
		"\u0000\u00df\u00e0\u0005:\u0000\u0000\u00e0\u00e1\u0005:\u0000\u0000\u00e1"+
		"\u00e2\u0003B!\u0000\u00e23\u0001\u0000\u0000\u0000\u00e3\u00e4\u0007"+
		"\b\u0000\u0000\u00e4\u00e5\u0005;\u0000\u0000\u00e55\u0001\u0000\u0000"+
		"\u0000\u00e6\u00e7\u0007\t\u0000\u0000\u00e7\u00e8\u00056\u0000\u0000"+
		"\u00e87\u0001\u0000\u0000\u0000\u00e9\u00ea\u0007\n\u0000\u0000\u00ea"+
		"\u00eb\u00057\u0000\u0000\u00eb9\u0001\u0000\u0000\u0000\u00ec\u00ed\u0007"+
		"\u000b\u0000\u0000\u00ed\u00ee\u00058\u0000\u0000\u00ee;\u0001\u0000\u0000"+
		"\u0000\u00ef\u00f0\u0007\f\u0000\u0000\u00f0\u00f1\u0005;\u0000\u0000"+
		"\u00f1\u00f2\u0007\r\u0000\u0000\u00f2=\u0001\u0000\u0000\u0000\u00f3"+
		"\u00f4\u0007\u000e\u0000\u0000\u00f4\u00f6\u0005:\u0000\u0000\u00f5\u00f7"+
		"\u0003@ \u0000\u00f6\u00f5\u0001\u0000\u0000\u0000\u00f7\u00f8\u0001\u0000"+
		"\u0000\u0000\u00f8\u00f6\u0001\u0000\u0000\u0000\u00f8\u00f9\u0001\u0000"+
		"\u0000\u0000\u00f9?\u0001\u0000\u0000\u0000\u00fa\u00fc\u0003F#\u0000"+
		"\u00fb\u00fd\u0005:\u0000\u0000\u00fc\u00fb\u0001\u0000\u0000\u0000\u00fc"+
		"\u00fd\u0001\u0000\u0000\u0000\u00fdA\u0001\u0000\u0000\u0000\u00fe\u00ff"+
		"\u0007\u000f\u0000\u0000\u00ff\u0101\u0005:\u0000\u0000\u0100\u0102\u0003"+
		"D\"\u0000\u0101\u0100\u0001\u0000\u0000\u0000\u0102\u0103\u0001\u0000"+
		"\u0000\u0000\u0103\u0101\u0001\u0000\u0000\u0000\u0103\u0104\u0001\u0000"+
		"\u0000\u0000\u0104C\u0001\u0000\u0000\u0000\u0105\u0107\u0003F#\u0000"+
		"\u0106\u0108\u0005:\u0000\u0000\u0107\u0106\u0001\u0000\u0000\u0000\u0107"+
		"\u0108\u0001\u0000\u0000\u0000\u0108E\u0001\u0000\u0000\u0000\u0109\u010b"+
		"\u0007\u0010\u0000\u0000\u010a\u0109\u0001\u0000\u0000\u0000\u010b\u010c"+
		"\u0001\u0000\u0000\u0000\u010c\u010a\u0001\u0000\u0000\u0000\u010c\u010d"+
		"\u0001\u0000\u0000\u0000\u010dG\u0001\u0000\u0000\u0000\rXao\u0098\u00a2"+
		"\u00ac\u00b4\u00c8\u00f8\u00fc\u0103\u0107\u010c";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}