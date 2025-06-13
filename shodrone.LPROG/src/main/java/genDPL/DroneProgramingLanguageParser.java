// Generated from C:/Users/Sousa/IdeaProjects/sem4pi-2024-2025-sem4pi_2024_2025_g33/shodrone.LPROG/src/main/java/antlr/DroneProgramingLanguage.g4 by ANTLR 4.13.2
package genDPL;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class DroneProgramingLanguageParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, DECIMAL=17, 
		WORDS=18, NEWLINE=19, WS=20, COMMENT=21;
	public static final int
		RULE_start = 0, RULE_drone_version = 1, RULE_type_section = 2, RULE_type_declaration = 3, 
		RULE_type_value = 4, RULE_variables_section = 5, RULE_variable_declaration = 6, 
		RULE_instructions_section = 7, RULE_instruction = 8, RULE_argument_list = 9, 
		RULE_argument = 10, RULE_placeholder = 11, RULE_expression = 12, RULE_term = 13, 
		RULE_tuple = 14, RULE_array = 15, RULE_op = 16;
	private static String[] makeRuleNames() {
		return new String[] {
			"start", "drone_version", "type_section", "type_declaration", "type_value", 
			"variables_section", "variable_declaration", "instructions_section", 
			"instruction", "argument_list", "argument", "placeholder", "expression", 
			"term", "tuple", "array", "op"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'programming language version'", "'Types'", "'-'", "'Variables'", 
			"'='", "';'", "'Instructions'", "'('", "')'", "', '", "'<'", "'>'", "'PI'", 
			"'+'", "'*'", "'/'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, "DECIMAL", "WORDS", "NEWLINE", "WS", "COMMENT"
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
	public String getGrammarFileName() { return "DroneProgramingLanguage.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public DroneProgramingLanguageParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class StartContext extends ParserRuleContext {
		public Drone_versionContext drone_version() {
			return getRuleContext(Drone_versionContext.class,0);
		}
		public Type_sectionContext type_section() {
			return getRuleContext(Type_sectionContext.class,0);
		}
		public Variables_sectionContext variables_section() {
			return getRuleContext(Variables_sectionContext.class,0);
		}
		public Instructions_sectionContext instructions_section() {
			return getRuleContext(Instructions_sectionContext.class,0);
		}
		public TerminalNode EOF() { return getToken(DroneProgramingLanguageParser.EOF, 0); }
		public StartContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_start; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DroneProgramingLanguageListener ) ((DroneProgramingLanguageListener)listener).enterStart(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DroneProgramingLanguageListener ) ((DroneProgramingLanguageListener)listener).exitStart(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DroneProgramingLanguageVisitor ) return ((DroneProgramingLanguageVisitor<? extends T>)visitor).visitStart(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StartContext start() throws RecognitionException {
		StartContext _localctx = new StartContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_start);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(34);
			drone_version();
			setState(35);
			type_section();
			setState(36);
			variables_section();
			setState(37);
			instructions_section();
			setState(38);
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
	public static class Drone_versionContext extends ParserRuleContext {
		public List<TerminalNode> DECIMAL() { return getTokens(DroneProgramingLanguageParser.DECIMAL); }
		public TerminalNode DECIMAL(int i) {
			return getToken(DroneProgramingLanguageParser.DECIMAL, i);
		}
		public List<TerminalNode> NEWLINE() { return getTokens(DroneProgramingLanguageParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(DroneProgramingLanguageParser.NEWLINE, i);
		}
		public List<TerminalNode> WORDS() { return getTokens(DroneProgramingLanguageParser.WORDS); }
		public TerminalNode WORDS(int i) {
			return getToken(DroneProgramingLanguageParser.WORDS, i);
		}
		public Drone_versionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_drone_version; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DroneProgramingLanguageListener ) ((DroneProgramingLanguageListener)listener).enterDrone_version(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DroneProgramingLanguageListener ) ((DroneProgramingLanguageListener)listener).exitDrone_version(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DroneProgramingLanguageVisitor ) return ((DroneProgramingLanguageVisitor<? extends T>)visitor).visitDrone_version(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Drone_versionContext drone_version() throws RecognitionException {
		Drone_versionContext _localctx = new Drone_versionContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_drone_version);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(41); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(40);
				_la = _input.LA(1);
				if ( !(_la==DECIMAL || _la==WORDS) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
				}
				setState(43); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==DECIMAL || _la==WORDS );
			setState(45);
			match(T__0);
			setState(46);
			match(DECIMAL);
			setState(50);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NEWLINE) {
				{
				{
				setState(47);
				match(NEWLINE);
				}
				}
				setState(52);
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
	public static class Type_sectionContext extends ParserRuleContext {
		public List<TerminalNode> NEWLINE() { return getTokens(DroneProgramingLanguageParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(DroneProgramingLanguageParser.NEWLINE, i);
		}
		public List<Type_declarationContext> type_declaration() {
			return getRuleContexts(Type_declarationContext.class);
		}
		public Type_declarationContext type_declaration(int i) {
			return getRuleContext(Type_declarationContext.class,i);
		}
		public Type_sectionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type_section; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DroneProgramingLanguageListener ) ((DroneProgramingLanguageListener)listener).enterType_section(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DroneProgramingLanguageListener ) ((DroneProgramingLanguageListener)listener).exitType_section(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DroneProgramingLanguageVisitor ) return ((DroneProgramingLanguageVisitor<? extends T>)visitor).visitType_section(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Type_sectionContext type_section() throws RecognitionException {
		Type_sectionContext _localctx = new Type_sectionContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_type_section);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(53);
			match(T__1);
			setState(57);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NEWLINE) {
				{
				{
				setState(54);
				match(NEWLINE);
				}
				}
				setState(59);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(63);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==WORDS) {
				{
				{
				setState(60);
				type_declaration();
				}
				}
				setState(65);
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
	public static class Type_declarationContext extends ParserRuleContext {
		public Type_valueContext type_value() {
			return getRuleContext(Type_valueContext.class,0);
		}
		public List<TerminalNode> WORDS() { return getTokens(DroneProgramingLanguageParser.WORDS); }
		public TerminalNode WORDS(int i) {
			return getToken(DroneProgramingLanguageParser.WORDS, i);
		}
		public List<TerminalNode> NEWLINE() { return getTokens(DroneProgramingLanguageParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(DroneProgramingLanguageParser.NEWLINE, i);
		}
		public Type_declarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type_declaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DroneProgramingLanguageListener ) ((DroneProgramingLanguageListener)listener).enterType_declaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DroneProgramingLanguageListener ) ((DroneProgramingLanguageListener)listener).exitType_declaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DroneProgramingLanguageVisitor ) return ((DroneProgramingLanguageVisitor<? extends T>)visitor).visitType_declaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Type_declarationContext type_declaration() throws RecognitionException {
		Type_declarationContext _localctx = new Type_declarationContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_type_declaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(67); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(66);
				match(WORDS);
				}
				}
				setState(69); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==WORDS );
			setState(71);
			match(T__2);
			setState(72);
			type_value();
			setState(76);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NEWLINE) {
				{
				{
				setState(73);
				match(NEWLINE);
				}
				}
				setState(78);
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
	public static class Type_valueContext extends ParserRuleContext {
		public TupleContext tuple() {
			return getRuleContext(TupleContext.class,0);
		}
		public TerminalNode DECIMAL() { return getToken(DroneProgramingLanguageParser.DECIMAL, 0); }
		public TerminalNode WORDS() { return getToken(DroneProgramingLanguageParser.WORDS, 0); }
		public Type_valueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type_value; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DroneProgramingLanguageListener ) ((DroneProgramingLanguageListener)listener).enterType_value(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DroneProgramingLanguageListener ) ((DroneProgramingLanguageListener)listener).exitType_value(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DroneProgramingLanguageVisitor ) return ((DroneProgramingLanguageVisitor<? extends T>)visitor).visitType_value(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Type_valueContext type_value() throws RecognitionException {
		Type_valueContext _localctx = new Type_valueContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_type_value);
		try {
			setState(82);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__7:
				enterOuterAlt(_localctx, 1);
				{
				setState(79);
				tuple();
				}
				break;
			case DECIMAL:
				enterOuterAlt(_localctx, 2);
				{
				setState(80);
				match(DECIMAL);
				}
				break;
			case WORDS:
				enterOuterAlt(_localctx, 3);
				{
				setState(81);
				match(WORDS);
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
	public static class Variables_sectionContext extends ParserRuleContext {
		public List<TerminalNode> NEWLINE() { return getTokens(DroneProgramingLanguageParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(DroneProgramingLanguageParser.NEWLINE, i);
		}
		public List<Variable_declarationContext> variable_declaration() {
			return getRuleContexts(Variable_declarationContext.class);
		}
		public Variable_declarationContext variable_declaration(int i) {
			return getRuleContext(Variable_declarationContext.class,i);
		}
		public Variables_sectionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variables_section; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DroneProgramingLanguageListener ) ((DroneProgramingLanguageListener)listener).enterVariables_section(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DroneProgramingLanguageListener ) ((DroneProgramingLanguageListener)listener).exitVariables_section(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DroneProgramingLanguageVisitor ) return ((DroneProgramingLanguageVisitor<? extends T>)visitor).visitVariables_section(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Variables_sectionContext variables_section() throws RecognitionException {
		Variables_sectionContext _localctx = new Variables_sectionContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_variables_section);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(84);
			match(T__3);
			setState(88);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NEWLINE) {
				{
				{
				setState(85);
				match(NEWLINE);
				}
				}
				setState(90);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(94);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==WORDS) {
				{
				{
				setState(91);
				variable_declaration();
				}
				}
				setState(96);
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
	public static class Variable_declarationContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public List<TerminalNode> WORDS() { return getTokens(DroneProgramingLanguageParser.WORDS); }
		public TerminalNode WORDS(int i) {
			return getToken(DroneProgramingLanguageParser.WORDS, i);
		}
		public List<TerminalNode> NEWLINE() { return getTokens(DroneProgramingLanguageParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(DroneProgramingLanguageParser.NEWLINE, i);
		}
		public Variable_declarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variable_declaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DroneProgramingLanguageListener ) ((DroneProgramingLanguageListener)listener).enterVariable_declaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DroneProgramingLanguageListener ) ((DroneProgramingLanguageListener)listener).exitVariable_declaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DroneProgramingLanguageVisitor ) return ((DroneProgramingLanguageVisitor<? extends T>)visitor).visitVariable_declaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Variable_declarationContext variable_declaration() throws RecognitionException {
		Variable_declarationContext _localctx = new Variable_declarationContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_variable_declaration);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(98); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(97);
					match(WORDS);
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(100); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			setState(107);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==WORDS) {
				{
				setState(103); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(102);
					match(WORDS);
					}
					}
					setState(105); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==WORDS );
				}
			}

			setState(109);
			match(T__4);
			setState(110);
			expression();
			setState(111);
			match(T__5);
			setState(115);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NEWLINE) {
				{
				{
				setState(112);
				match(NEWLINE);
				}
				}
				setState(117);
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
	public static class Instructions_sectionContext extends ParserRuleContext {
		public List<TerminalNode> NEWLINE() { return getTokens(DroneProgramingLanguageParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(DroneProgramingLanguageParser.NEWLINE, i);
		}
		public List<InstructionContext> instruction() {
			return getRuleContexts(InstructionContext.class);
		}
		public InstructionContext instruction(int i) {
			return getRuleContext(InstructionContext.class,i);
		}
		public Instructions_sectionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_instructions_section; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DroneProgramingLanguageListener ) ((DroneProgramingLanguageListener)listener).enterInstructions_section(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DroneProgramingLanguageListener ) ((DroneProgramingLanguageListener)listener).exitInstructions_section(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DroneProgramingLanguageVisitor ) return ((DroneProgramingLanguageVisitor<? extends T>)visitor).visitInstructions_section(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Instructions_sectionContext instructions_section() throws RecognitionException {
		Instructions_sectionContext _localctx = new Instructions_sectionContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_instructions_section);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(118);
			match(T__6);
			setState(122);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NEWLINE) {
				{
				{
				setState(119);
				match(NEWLINE);
				}
				}
				setState(124);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(128);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==WORDS) {
				{
				{
				setState(125);
				instruction();
				}
				}
				setState(130);
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
	public static class InstructionContext extends ParserRuleContext {
		public List<TerminalNode> WORDS() { return getTokens(DroneProgramingLanguageParser.WORDS); }
		public TerminalNode WORDS(int i) {
			return getToken(DroneProgramingLanguageParser.WORDS, i);
		}
		public Argument_listContext argument_list() {
			return getRuleContext(Argument_listContext.class,0);
		}
		public List<TerminalNode> NEWLINE() { return getTokens(DroneProgramingLanguageParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(DroneProgramingLanguageParser.NEWLINE, i);
		}
		public InstructionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_instruction; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DroneProgramingLanguageListener ) ((DroneProgramingLanguageListener)listener).enterInstruction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DroneProgramingLanguageListener ) ((DroneProgramingLanguageListener)listener).exitInstruction(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DroneProgramingLanguageVisitor ) return ((DroneProgramingLanguageVisitor<? extends T>)visitor).visitInstruction(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InstructionContext instruction() throws RecognitionException {
		InstructionContext _localctx = new InstructionContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_instruction);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(132); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(131);
				match(WORDS);
				}
				}
				setState(134); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==WORDS );
			setState(136);
			match(T__7);
			setState(138);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 403712L) != 0)) {
				{
				setState(137);
				argument_list();
				}
			}

			setState(140);
			match(T__8);
			setState(141);
			match(T__5);
			setState(145);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NEWLINE) {
				{
				{
				setState(142);
				match(NEWLINE);
				}
				}
				setState(147);
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
	public static class Argument_listContext extends ParserRuleContext {
		public List<ArgumentContext> argument() {
			return getRuleContexts(ArgumentContext.class);
		}
		public ArgumentContext argument(int i) {
			return getRuleContext(ArgumentContext.class,i);
		}
		public Argument_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_argument_list; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DroneProgramingLanguageListener ) ((DroneProgramingLanguageListener)listener).enterArgument_list(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DroneProgramingLanguageListener ) ((DroneProgramingLanguageListener)listener).exitArgument_list(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DroneProgramingLanguageVisitor ) return ((DroneProgramingLanguageVisitor<? extends T>)visitor).visitArgument_list(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Argument_listContext argument_list() throws RecognitionException {
		Argument_listContext _localctx = new Argument_listContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_argument_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(148);
			argument();
			setState(153);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__9) {
				{
				{
				setState(149);
				match(T__9);
				setState(150);
				argument();
				}
				}
				setState(155);
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
	public static class ArgumentContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public PlaceholderContext placeholder() {
			return getRuleContext(PlaceholderContext.class,0);
		}
		public TupleContext tuple() {
			return getRuleContext(TupleContext.class,0);
		}
		public ArrayContext array() {
			return getRuleContext(ArrayContext.class,0);
		}
		public ArgumentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_argument; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DroneProgramingLanguageListener ) ((DroneProgramingLanguageListener)listener).enterArgument(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DroneProgramingLanguageListener ) ((DroneProgramingLanguageListener)listener).exitArgument(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DroneProgramingLanguageVisitor ) return ((DroneProgramingLanguageVisitor<? extends T>)visitor).visitArgument(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArgumentContext argument() throws RecognitionException {
		ArgumentContext _localctx = new ArgumentContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_argument);
		try {
			setState(160);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(156);
				expression();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(157);
				placeholder();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(158);
				tuple();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(159);
				array();
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
	public static class PlaceholderContext extends ParserRuleContext {
		public List<TerminalNode> WORDS() { return getTokens(DroneProgramingLanguageParser.WORDS); }
		public TerminalNode WORDS(int i) {
			return getToken(DroneProgramingLanguageParser.WORDS, i);
		}
		public PlaceholderContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_placeholder; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DroneProgramingLanguageListener ) ((DroneProgramingLanguageListener)listener).enterPlaceholder(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DroneProgramingLanguageListener ) ((DroneProgramingLanguageListener)listener).exitPlaceholder(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DroneProgramingLanguageVisitor ) return ((DroneProgramingLanguageVisitor<? extends T>)visitor).visitPlaceholder(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PlaceholderContext placeholder() throws RecognitionException {
		PlaceholderContext _localctx = new PlaceholderContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_placeholder);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(162);
			match(T__10);
			setState(164); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(163);
				match(WORDS);
				}
				}
				setState(166); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==WORDS );
			setState(168);
			match(T__11);
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
	public static class ExpressionContext extends ParserRuleContext {
		public List<TermContext> term() {
			return getRuleContexts(TermContext.class);
		}
		public TermContext term(int i) {
			return getRuleContext(TermContext.class,i);
		}
		public List<OpContext> op() {
			return getRuleContexts(OpContext.class);
		}
		public OpContext op(int i) {
			return getRuleContext(OpContext.class,i);
		}
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DroneProgramingLanguageListener ) ((DroneProgramingLanguageListener)listener).enterExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DroneProgramingLanguageListener ) ((DroneProgramingLanguageListener)listener).exitExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DroneProgramingLanguageVisitor ) return ((DroneProgramingLanguageVisitor<? extends T>)visitor).visitExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		ExpressionContext _localctx = new ExpressionContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_expression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(170);
			term();
			setState(176);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 114696L) != 0)) {
				{
				{
				setState(171);
				op();
				setState(172);
				term();
				}
				}
				setState(178);
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
	public static class TermContext extends ParserRuleContext {
		public TerminalNode DECIMAL() { return getToken(DroneProgramingLanguageParser.DECIMAL, 0); }
		public TerminalNode WORDS() { return getToken(DroneProgramingLanguageParser.WORDS, 0); }
		public TupleContext tuple() {
			return getRuleContext(TupleContext.class,0);
		}
		public ArrayContext array() {
			return getRuleContext(ArrayContext.class,0);
		}
		public TermContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_term; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DroneProgramingLanguageListener ) ((DroneProgramingLanguageListener)listener).enterTerm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DroneProgramingLanguageListener ) ((DroneProgramingLanguageListener)listener).exitTerm(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DroneProgramingLanguageVisitor ) return ((DroneProgramingLanguageVisitor<? extends T>)visitor).visitTerm(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TermContext term() throws RecognitionException {
		TermContext _localctx = new TermContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_term);
		try {
			setState(184);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,22,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(179);
				match(DECIMAL);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(180);
				match(WORDS);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(181);
				match(T__12);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(182);
				tuple();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(183);
				array();
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
	public static class TupleContext extends ParserRuleContext {
		public List<TerminalNode> DECIMAL() { return getTokens(DroneProgramingLanguageParser.DECIMAL); }
		public TerminalNode DECIMAL(int i) {
			return getToken(DroneProgramingLanguageParser.DECIMAL, i);
		}
		public TupleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tuple; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DroneProgramingLanguageListener ) ((DroneProgramingLanguageListener)listener).enterTuple(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DroneProgramingLanguageListener ) ((DroneProgramingLanguageListener)listener).exitTuple(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DroneProgramingLanguageVisitor ) return ((DroneProgramingLanguageVisitor<? extends T>)visitor).visitTuple(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TupleContext tuple() throws RecognitionException {
		TupleContext _localctx = new TupleContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_tuple);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(186);
			match(T__7);
			setState(187);
			match(DECIMAL);
			setState(192);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__9) {
				{
				{
				setState(188);
				match(T__9);
				setState(189);
				match(DECIMAL);
				}
				}
				setState(194);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(195);
			match(T__8);
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
	public static class ArrayContext extends ParserRuleContext {
		public List<TupleContext> tuple() {
			return getRuleContexts(TupleContext.class);
		}
		public TupleContext tuple(int i) {
			return getRuleContext(TupleContext.class,i);
		}
		public ArrayContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_array; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DroneProgramingLanguageListener ) ((DroneProgramingLanguageListener)listener).enterArray(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DroneProgramingLanguageListener ) ((DroneProgramingLanguageListener)listener).exitArray(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DroneProgramingLanguageVisitor ) return ((DroneProgramingLanguageVisitor<? extends T>)visitor).visitArray(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArrayContext array() throws RecognitionException {
		ArrayContext _localctx = new ArrayContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_array);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(197);
			match(T__7);
			setState(198);
			tuple();
			setState(203);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__9) {
				{
				{
				setState(199);
				match(T__9);
				setState(200);
				tuple();
				}
				}
				setState(205);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(206);
			match(T__8);
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
	public static class OpContext extends ParserRuleContext {
		public OpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_op; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DroneProgramingLanguageListener ) ((DroneProgramingLanguageListener)listener).enterOp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DroneProgramingLanguageListener ) ((DroneProgramingLanguageListener)listener).exitOp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DroneProgramingLanguageVisitor ) return ((DroneProgramingLanguageVisitor<? extends T>)visitor).visitOp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OpContext op() throws RecognitionException {
		OpContext _localctx = new OpContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_op);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(208);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 114696L) != 0)) ) {
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

	public static final String _serializedATN =
		"\u0004\u0001\u0015\u00d3\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001"+
		"\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004"+
		"\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007"+
		"\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b"+
		"\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007"+
		"\u000f\u0002\u0010\u0007\u0010\u0001\u0000\u0001\u0000\u0001\u0000\u0001"+
		"\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0004\u0001*\b\u0001\u000b"+
		"\u0001\f\u0001+\u0001\u0001\u0001\u0001\u0001\u0001\u0005\u00011\b\u0001"+
		"\n\u0001\f\u00014\t\u0001\u0001\u0002\u0001\u0002\u0005\u00028\b\u0002"+
		"\n\u0002\f\u0002;\t\u0002\u0001\u0002\u0005\u0002>\b\u0002\n\u0002\f\u0002"+
		"A\t\u0002\u0001\u0003\u0004\u0003D\b\u0003\u000b\u0003\f\u0003E\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0005\u0003K\b\u0003\n\u0003\f\u0003N\t"+
		"\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0003\u0004S\b\u0004\u0001"+
		"\u0005\u0001\u0005\u0005\u0005W\b\u0005\n\u0005\f\u0005Z\t\u0005\u0001"+
		"\u0005\u0005\u0005]\b\u0005\n\u0005\f\u0005`\t\u0005\u0001\u0006\u0004"+
		"\u0006c\b\u0006\u000b\u0006\f\u0006d\u0001\u0006\u0004\u0006h\b\u0006"+
		"\u000b\u0006\f\u0006i\u0003\u0006l\b\u0006\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0005\u0006r\b\u0006\n\u0006\f\u0006u\t\u0006\u0001"+
		"\u0007\u0001\u0007\u0005\u0007y\b\u0007\n\u0007\f\u0007|\t\u0007\u0001"+
		"\u0007\u0005\u0007\u007f\b\u0007\n\u0007\f\u0007\u0082\t\u0007\u0001\b"+
		"\u0004\b\u0085\b\b\u000b\b\f\b\u0086\u0001\b\u0001\b\u0003\b\u008b\b\b"+
		"\u0001\b\u0001\b\u0001\b\u0005\b\u0090\b\b\n\b\f\b\u0093\t\b\u0001\t\u0001"+
		"\t\u0001\t\u0005\t\u0098\b\t\n\t\f\t\u009b\t\t\u0001\n\u0001\n\u0001\n"+
		"\u0001\n\u0003\n\u00a1\b\n\u0001\u000b\u0001\u000b\u0004\u000b\u00a5\b"+
		"\u000b\u000b\u000b\f\u000b\u00a6\u0001\u000b\u0001\u000b\u0001\f\u0001"+
		"\f\u0001\f\u0001\f\u0005\f\u00af\b\f\n\f\f\f\u00b2\t\f\u0001\r\u0001\r"+
		"\u0001\r\u0001\r\u0001\r\u0003\r\u00b9\b\r\u0001\u000e\u0001\u000e\u0001"+
		"\u000e\u0001\u000e\u0005\u000e\u00bf\b\u000e\n\u000e\f\u000e\u00c2\t\u000e"+
		"\u0001\u000e\u0001\u000e\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f"+
		"\u0005\u000f\u00ca\b\u000f\n\u000f\f\u000f\u00cd\t\u000f\u0001\u000f\u0001"+
		"\u000f\u0001\u0010\u0001\u0010\u0001\u0010\u0000\u0000\u0011\u0000\u0002"+
		"\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018\u001a\u001c\u001e"+
		" \u0000\u0002\u0001\u0000\u0011\u0012\u0002\u0000\u0003\u0003\u000e\u0010"+
		"\u00e0\u0000\"\u0001\u0000\u0000\u0000\u0002)\u0001\u0000\u0000\u0000"+
		"\u00045\u0001\u0000\u0000\u0000\u0006C\u0001\u0000\u0000\u0000\bR\u0001"+
		"\u0000\u0000\u0000\nT\u0001\u0000\u0000\u0000\fb\u0001\u0000\u0000\u0000"+
		"\u000ev\u0001\u0000\u0000\u0000\u0010\u0084\u0001\u0000\u0000\u0000\u0012"+
		"\u0094\u0001\u0000\u0000\u0000\u0014\u00a0\u0001\u0000\u0000\u0000\u0016"+
		"\u00a2\u0001\u0000\u0000\u0000\u0018\u00aa\u0001\u0000\u0000\u0000\u001a"+
		"\u00b8\u0001\u0000\u0000\u0000\u001c\u00ba\u0001\u0000\u0000\u0000\u001e"+
		"\u00c5\u0001\u0000\u0000\u0000 \u00d0\u0001\u0000\u0000\u0000\"#\u0003"+
		"\u0002\u0001\u0000#$\u0003\u0004\u0002\u0000$%\u0003\n\u0005\u0000%&\u0003"+
		"\u000e\u0007\u0000&\'\u0005\u0000\u0000\u0001\'\u0001\u0001\u0000\u0000"+
		"\u0000(*\u0007\u0000\u0000\u0000)(\u0001\u0000\u0000\u0000*+\u0001\u0000"+
		"\u0000\u0000+)\u0001\u0000\u0000\u0000+,\u0001\u0000\u0000\u0000,-\u0001"+
		"\u0000\u0000\u0000-.\u0005\u0001\u0000\u0000.2\u0005\u0011\u0000\u0000"+
		"/1\u0005\u0013\u0000\u00000/\u0001\u0000\u0000\u000014\u0001\u0000\u0000"+
		"\u000020\u0001\u0000\u0000\u000023\u0001\u0000\u0000\u00003\u0003\u0001"+
		"\u0000\u0000\u000042\u0001\u0000\u0000\u000059\u0005\u0002\u0000\u0000"+
		"68\u0005\u0013\u0000\u000076\u0001\u0000\u0000\u00008;\u0001\u0000\u0000"+
		"\u000097\u0001\u0000\u0000\u00009:\u0001\u0000\u0000\u0000:?\u0001\u0000"+
		"\u0000\u0000;9\u0001\u0000\u0000\u0000<>\u0003\u0006\u0003\u0000=<\u0001"+
		"\u0000\u0000\u0000>A\u0001\u0000\u0000\u0000?=\u0001\u0000\u0000\u0000"+
		"?@\u0001\u0000\u0000\u0000@\u0005\u0001\u0000\u0000\u0000A?\u0001\u0000"+
		"\u0000\u0000BD\u0005\u0012\u0000\u0000CB\u0001\u0000\u0000\u0000DE\u0001"+
		"\u0000\u0000\u0000EC\u0001\u0000\u0000\u0000EF\u0001\u0000\u0000\u0000"+
		"FG\u0001\u0000\u0000\u0000GH\u0005\u0003\u0000\u0000HL\u0003\b\u0004\u0000"+
		"IK\u0005\u0013\u0000\u0000JI\u0001\u0000\u0000\u0000KN\u0001\u0000\u0000"+
		"\u0000LJ\u0001\u0000\u0000\u0000LM\u0001\u0000\u0000\u0000M\u0007\u0001"+
		"\u0000\u0000\u0000NL\u0001\u0000\u0000\u0000OS\u0003\u001c\u000e\u0000"+
		"PS\u0005\u0011\u0000\u0000QS\u0005\u0012\u0000\u0000RO\u0001\u0000\u0000"+
		"\u0000RP\u0001\u0000\u0000\u0000RQ\u0001\u0000\u0000\u0000S\t\u0001\u0000"+
		"\u0000\u0000TX\u0005\u0004\u0000\u0000UW\u0005\u0013\u0000\u0000VU\u0001"+
		"\u0000\u0000\u0000WZ\u0001\u0000\u0000\u0000XV\u0001\u0000\u0000\u0000"+
		"XY\u0001\u0000\u0000\u0000Y^\u0001\u0000\u0000\u0000ZX\u0001\u0000\u0000"+
		"\u0000[]\u0003\f\u0006\u0000\\[\u0001\u0000\u0000\u0000]`\u0001\u0000"+
		"\u0000\u0000^\\\u0001\u0000\u0000\u0000^_\u0001\u0000\u0000\u0000_\u000b"+
		"\u0001\u0000\u0000\u0000`^\u0001\u0000\u0000\u0000ac\u0005\u0012\u0000"+
		"\u0000ba\u0001\u0000\u0000\u0000cd\u0001\u0000\u0000\u0000db\u0001\u0000"+
		"\u0000\u0000de\u0001\u0000\u0000\u0000ek\u0001\u0000\u0000\u0000fh\u0005"+
		"\u0012\u0000\u0000gf\u0001\u0000\u0000\u0000hi\u0001\u0000\u0000\u0000"+
		"ig\u0001\u0000\u0000\u0000ij\u0001\u0000\u0000\u0000jl\u0001\u0000\u0000"+
		"\u0000kg\u0001\u0000\u0000\u0000kl\u0001\u0000\u0000\u0000lm\u0001\u0000"+
		"\u0000\u0000mn\u0005\u0005\u0000\u0000no\u0003\u0018\f\u0000os\u0005\u0006"+
		"\u0000\u0000pr\u0005\u0013\u0000\u0000qp\u0001\u0000\u0000\u0000ru\u0001"+
		"\u0000\u0000\u0000sq\u0001\u0000\u0000\u0000st\u0001\u0000\u0000\u0000"+
		"t\r\u0001\u0000\u0000\u0000us\u0001\u0000\u0000\u0000vz\u0005\u0007\u0000"+
		"\u0000wy\u0005\u0013\u0000\u0000xw\u0001\u0000\u0000\u0000y|\u0001\u0000"+
		"\u0000\u0000zx\u0001\u0000\u0000\u0000z{\u0001\u0000\u0000\u0000{\u0080"+
		"\u0001\u0000\u0000\u0000|z\u0001\u0000\u0000\u0000}\u007f\u0003\u0010"+
		"\b\u0000~}\u0001\u0000\u0000\u0000\u007f\u0082\u0001\u0000\u0000\u0000"+
		"\u0080~\u0001\u0000\u0000\u0000\u0080\u0081\u0001\u0000\u0000\u0000\u0081"+
		"\u000f\u0001\u0000\u0000\u0000\u0082\u0080\u0001\u0000\u0000\u0000\u0083"+
		"\u0085\u0005\u0012\u0000\u0000\u0084\u0083\u0001\u0000\u0000\u0000\u0085"+
		"\u0086\u0001\u0000\u0000\u0000\u0086\u0084\u0001\u0000\u0000\u0000\u0086"+
		"\u0087\u0001\u0000\u0000\u0000\u0087\u0088\u0001\u0000\u0000\u0000\u0088"+
		"\u008a\u0005\b\u0000\u0000\u0089\u008b\u0003\u0012\t\u0000\u008a\u0089"+
		"\u0001\u0000\u0000\u0000\u008a\u008b\u0001\u0000\u0000\u0000\u008b\u008c"+
		"\u0001\u0000\u0000\u0000\u008c\u008d\u0005\t\u0000\u0000\u008d\u0091\u0005"+
		"\u0006\u0000\u0000\u008e\u0090\u0005\u0013\u0000\u0000\u008f\u008e\u0001"+
		"\u0000\u0000\u0000\u0090\u0093\u0001\u0000\u0000\u0000\u0091\u008f\u0001"+
		"\u0000\u0000\u0000\u0091\u0092\u0001\u0000\u0000\u0000\u0092\u0011\u0001"+
		"\u0000\u0000\u0000\u0093\u0091\u0001\u0000\u0000\u0000\u0094\u0099\u0003"+
		"\u0014\n\u0000\u0095\u0096\u0005\n\u0000\u0000\u0096\u0098\u0003\u0014"+
		"\n\u0000\u0097\u0095\u0001\u0000\u0000\u0000\u0098\u009b\u0001\u0000\u0000"+
		"\u0000\u0099\u0097\u0001\u0000\u0000\u0000\u0099\u009a\u0001\u0000\u0000"+
		"\u0000\u009a\u0013\u0001\u0000\u0000\u0000\u009b\u0099\u0001\u0000\u0000"+
		"\u0000\u009c\u00a1\u0003\u0018\f\u0000\u009d\u00a1\u0003\u0016\u000b\u0000"+
		"\u009e\u00a1\u0003\u001c\u000e\u0000\u009f\u00a1\u0003\u001e\u000f\u0000"+
		"\u00a0\u009c\u0001\u0000\u0000\u0000\u00a0\u009d\u0001\u0000\u0000\u0000"+
		"\u00a0\u009e\u0001\u0000\u0000\u0000\u00a0\u009f\u0001\u0000\u0000\u0000"+
		"\u00a1\u0015\u0001\u0000\u0000\u0000\u00a2\u00a4\u0005\u000b\u0000\u0000"+
		"\u00a3\u00a5\u0005\u0012\u0000\u0000\u00a4\u00a3\u0001\u0000\u0000\u0000"+
		"\u00a5\u00a6\u0001\u0000\u0000\u0000\u00a6\u00a4\u0001\u0000\u0000\u0000"+
		"\u00a6\u00a7\u0001\u0000\u0000\u0000\u00a7\u00a8\u0001\u0000\u0000\u0000"+
		"\u00a8\u00a9\u0005\f\u0000\u0000\u00a9\u0017\u0001\u0000\u0000\u0000\u00aa"+
		"\u00b0\u0003\u001a\r\u0000\u00ab\u00ac\u0003 \u0010\u0000\u00ac\u00ad"+
		"\u0003\u001a\r\u0000\u00ad\u00af\u0001\u0000\u0000\u0000\u00ae\u00ab\u0001"+
		"\u0000\u0000\u0000\u00af\u00b2\u0001\u0000\u0000\u0000\u00b0\u00ae\u0001"+
		"\u0000\u0000\u0000\u00b0\u00b1\u0001\u0000\u0000\u0000\u00b1\u0019\u0001"+
		"\u0000\u0000\u0000\u00b2\u00b0\u0001\u0000\u0000\u0000\u00b3\u00b9\u0005"+
		"\u0011\u0000\u0000\u00b4\u00b9\u0005\u0012\u0000\u0000\u00b5\u00b9\u0005"+
		"\r\u0000\u0000\u00b6\u00b9\u0003\u001c\u000e\u0000\u00b7\u00b9\u0003\u001e"+
		"\u000f\u0000\u00b8\u00b3\u0001\u0000\u0000\u0000\u00b8\u00b4\u0001\u0000"+
		"\u0000\u0000\u00b8\u00b5\u0001\u0000\u0000\u0000\u00b8\u00b6\u0001\u0000"+
		"\u0000\u0000\u00b8\u00b7\u0001\u0000\u0000\u0000\u00b9\u001b\u0001\u0000"+
		"\u0000\u0000\u00ba\u00bb\u0005\b\u0000\u0000\u00bb\u00c0\u0005\u0011\u0000"+
		"\u0000\u00bc\u00bd\u0005\n\u0000\u0000\u00bd\u00bf\u0005\u0011\u0000\u0000"+
		"\u00be\u00bc\u0001\u0000\u0000\u0000\u00bf\u00c2\u0001\u0000\u0000\u0000"+
		"\u00c0\u00be\u0001\u0000\u0000\u0000\u00c0\u00c1\u0001\u0000\u0000\u0000"+
		"\u00c1\u00c3\u0001\u0000\u0000\u0000\u00c2\u00c0\u0001\u0000\u0000\u0000"+
		"\u00c3\u00c4\u0005\t\u0000\u0000\u00c4\u001d\u0001\u0000\u0000\u0000\u00c5"+
		"\u00c6\u0005\b\u0000\u0000\u00c6\u00cb\u0003\u001c\u000e\u0000\u00c7\u00c8"+
		"\u0005\n\u0000\u0000\u00c8\u00ca\u0003\u001c\u000e\u0000\u00c9\u00c7\u0001"+
		"\u0000\u0000\u0000\u00ca\u00cd\u0001\u0000\u0000\u0000\u00cb\u00c9\u0001"+
		"\u0000\u0000\u0000\u00cb\u00cc\u0001\u0000\u0000\u0000\u00cc\u00ce\u0001"+
		"\u0000\u0000\u0000\u00cd\u00cb\u0001\u0000\u0000\u0000\u00ce\u00cf\u0005"+
		"\t\u0000\u0000\u00cf\u001f\u0001\u0000\u0000\u0000\u00d0\u00d1\u0007\u0001"+
		"\u0000\u0000\u00d1!\u0001\u0000\u0000\u0000\u0019+29?ELRX^diksz\u0080"+
		"\u0086\u008a\u0091\u0099\u00a0\u00a6\u00b0\u00b8\u00c0\u00cb";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}