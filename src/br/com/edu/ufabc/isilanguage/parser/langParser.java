// Generated from lang.g4 by ANTLR 4.7.1
package br.edu.ufabc.isilanguage.parser;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;

import br.edu.ufabc.isilanguage.datastructure.IsiVariable;
import br.edu.ufabc.isilanguage.datastructure.IsiSymbol;
import br.edu.ufabc.isilanguage.datastructure.IsiSymbolTable;
import br.edu.ufabc.isilanguage.exceptions.IsiSemanticException;

import java.util.Stack;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class langParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, AP=10, FP=11, SC=12, OP=13, ATTR=14, ID=15, VIR=16,
		NUMBER=17, WS=18, ACH=19, FCH=20, OPREL=21, TEXTO=22;
	public static final int
		RULE_prog = 0, RULE_decl=1, RULE_declaravar=2, RULE_tipo=3, RULE_bloco = 4, RULE_cmd = 5, RULE_cmdleitura = 6, RULE_cmdescrita = 7, 
		RULE_cmdattrib = 8, RULE_cmdenquanto=9, RULE_cmdselecao=10, RULE_expr = 11, RULE_termo = 12;
	public static final String[] ruleNames = {
		"prog", "bloco", "cmd", "cmdleitura", "cmdescrita", "cmdattrib", "expr", 
		"cmdenquanto", "cmdselecao","termo", "decl", "declaravar", "tipo"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'programa'", "'fimprog;'", "'numero'", "'texto'" , "'leia'", "'escreva'", "'enquanto'", "'se'",
		"'('", "')'", "';'", null, "'='"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, "AP", "FP", "SC", "OP", "ATTR", "VIR", "ACH", "FCH", "OPREL",
		"ID", "NUMBER", "TEXTO", "WS"
	};
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
	public String getGrammarFileName() { return "lang.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

		private int _tipo;
		private String _varName;
		private String _varValue;
		private IsiSymbolTable symbolTable = new IsiSymbolTable();
		private IdiSymbol symbol;
		private IsiProgram program = new IsiProgram();
		private ArrayList<AbstractCommand> curThread;
		private Stack<ArrayList<AbstractCommand>> stack = stack = new Stack<ArrayList<AbstractCommand>>();
		private String _readID;
		private String _writeID;
		private String _exprID;
		private String _exprContent;
		private String _exprDecision;
		private String _exprRepetition;
	
	public void verificaID(String id){
		if (!symbolTable.exists(id)){
			throw new IsiSemanticException("Symbol "+id+" not declared");
		}
	}

	public void exibeComandos(){
		for (AbstractCommand c: program.getComandos()){
			System.out.println(c);
		}
	}

	public void generateCode(){
		program.generateTarget();
	}

	public void verificaTipo(String id, int tipo){
		if (symbolTable.get(id).getType() != tipo){
			throw new IsiSemanticException("Symbol "+id+" must be "+tipo);
		}
	}

	public langParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class ProgContext extends ParserRuleContext { 
		public BlocoContext bloco() {
			return getRuleContext(BlocoContext.class,0);
		}
		public ProgContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prog; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof langListener ) ((langListener)listener).enterProg(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof langListener ) ((langListener)listener).exitProg(this);
		}
	}

	public final ProgContext prog() throws RecognitionException {
		ProgContext _localctx = new ProgContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_prog);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(26);
			match(T__0);
			setState(27);
			decl();
			setState(28);
			bloco();
			setState(29);
			match(T__1);
			 program.setVarTable(symbolTable);
			          program.setComandos(stack.pop());
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

	public static class DeclContext extends ParserRuleContext {
		public List<DeclaravarContext> declaravar() {
			return getRuleContexts(DeclaravarContext.class);
		}
		public DeclaravarContext declaravar(int i) {
			return getRuleContext(DeclaravarContext.class,i);
		}
		public DeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_decl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof langListener ) ((langListener)listener).enterBloco(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof langListener ) ((langListener)listener).exitBloco(this);
		}
	}

	public final DeclContext decl() throws RecognitionException {
		DeclContext _localctx = new DeclContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_decl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(33); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(32);
				cmd();
				}
				}
				setState(35); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << T__3) | (1L << ID))) != 0) );
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

	public static class DeclaravarContext extends ParserRuleContext {
		public TipoContext tipo() {
			return getRuleContext(TipoContext.class,0);
		}
		public List<TerminalNode> ID() { return getTokens(langParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(langParser.ID, i);
		}
		public TerminalNode SC() { return getToken(langParser.SC, 0); }
		public List<TerminalNode> VIR() { return getTokens(langParser.VIR); }
		public TerminalNode VIR(int i) {
			return getToken(langParser.VIR, i);
		}
		public DeclaravarContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaravar; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof langListener ) ((langListener)listener).enterDeclaravar(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof langListener ) ((langListener)listener).exitDeclaravar(this);
		}
	}

	public final DeclaravarContext declaravar() throws RecognitionException {
		DeclaravarContext _localctx = new DeclaravarContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_declaravar);
		int _la;
		try {
				enterOuterAlt(_localctx, 1);
				{
				setState(37);
				tipo();
				setState(38);
				match(ID);
				_varName = _input.LT(-1).getText();
				_varValue = null;
				if (!symbolTable.exists(_varName)){
					symbolTable.add(symbol);
				}
				else{
					throw new IsiSemanticException("Symbol "+_varName+" already declared");
				}
				setState(45);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==VIR) {
					{
					{
					setState(40);
					match(VIR);
					setState(41);
					match(ID);
					_varName = _input.LT(-1).getText();
					_varValue = null;
					if (!symbolTable.exists(_varName)){
						symbolTable.add(symbol);
					}
					else{
						throw new IsiSemanticException("Symbol "+_varName+" already declared");
					}
					}
					}
					setState(47);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(48);
				match(SC);
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

	public static class TipoContext extends ParserRuleContext {
		public TipoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tipo; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof langListener ) ((langListener)listener).enterTipo(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof langListener ) ((langListener)listener).exitTipo(this);
		}
	}

	public final TipoContext tipo() throws RecognitionException {
		TipoContext _localctx = new TipoContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_tipo);
		try {
			setState(54);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
				case T__2:
					enterOuterAlt(_localctx, 1);
					{
					setState(50);
					match(T__2);
					_tipo = IsiVariable.NUMBER;
					}
					break;
				case T__3:
					enterOuterAlt(_localctx, 2);
					{
					setState(52);
					match(T__3);
					_tipo = IsiVariable.TEXT;
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

	public static class BlocoContext extends ParserRuleContext {
		public List<CmdContext> cmd() {
			return getRuleContext(CmdContext.class);
		}
		public CmdContext cmd(int i) {
			return getRuleContext(CmdContext.class,i);
		}
		public BlocoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bloco; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof langListener ) ((langListener)listener).enterBloco(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof langListener ) ((langListener)listener).exitBloco(this);
		}
	}

	public final BlocoContext bloco() throws RecognitionException {
		BlocoContext _localctx = new BlocoContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_bloco);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			stack.push(curThread = new ArrayList<AbstractCommand>());
			setState(58); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(57);
				cmd();
				}
				}
				setState(60); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__4) | (1L << T__5) | (1L << T__6) || (1L<< T__7) | (1L << ID))) != 0) );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this,re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CmdContext extends ParserRuleContext {
		public CmdleituraContext cmdleitura() {
			return getRuleContext(CmdleituraContext.class,0);
		}
		public CmdescritaContext cmdescrita() {
			return getRuleContext(CmdescritaContext.class,0);
		}
		public CmdattribContext cmdattrib() {
			return getRuleContext(CmdattribContext.class,0);
		}
		public CmdenquantoContext cmdenquanto() {
			return getRuleContext(CmdenquantoContext.class,0);
		}
		public CmdselecaoContext cmdselecao() {
			return getRuleContext(CmdselecaoContext.class,0);
		}
		public CmdContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmd; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof langListener ) ((langListener)listener).enterCmd(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof langListener ) ((langListener)listener).exitCmd(this);
		}
	}

	public final CmdContext cmd() throws RecognitionException {
		CmdContext _localctx = new CmdContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_cmd);
		try {
			setState(67);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
				case T__4:
					enterOuterAlt(_localctx, 1);
					{
					setState(62);
					cmdleitura();
					}
					break;
				case T__5:
					enterOuterAlt(_localctx, 2);
					{
					setState(63);
					cmdescrita();
					}
					break;
				case ID:
					enterOuterAlt(_localctx, 3);
					{
					setState(64);
					cmdattrib();
					}
					break;
				case T__6:
					enterOuterAlt(_localctx, 4);
					{
					setState(65);
					cmdenquanto();
					}
					break;
				case T__7:
					enterOuterAlt(_localctx, 5);
					{
					setState(66);
					cmdselecao();
					}
					break;
				default:
					throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this,re);
			_errHandler.recover(this,re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}


	public static class CmdleituraContext extends ParserRuleContext {
		public TerminalNode AP() { return getToken(langParser.AP, 0); }
		public TerminalNode ID() { return getToken(langParser.ID, 0); }
		public TerminalNode FP() { return getToken(langParser.FP, 0); }
		public TerminalNode SC() { return getToken(langParser.SC, 0); }
		public CmdleituraContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmdleitura; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof langListener ) ((langListener)listener).enterCmdleitura(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof langListener ) ((langListener)listener).exitCmdleitura(this);
		}
	}

	public final CmdleituraContext cmdleitura() throws RecognitionException {
		CmdleituraContext _localctx = new CmdleituraContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_cmdleitura);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(69);
			match(T__4);
			setState(70);
			match(AP);
			setState(71);
			match(ID);
			 verificaID(_input.LT(-1).getText());
			                      _readID = _input.LT(-1).getText();
			                      _exprID = _input.LT(-1).getText();
			                      _exprContent = _input.LT(-1).getText();
			                      _exprDecision = _input.LT(-1).getText();
			                      _exprRepetition = _input.LT(-1).getText();
			                      curThread.add(new ReadCommand(_readID));
			setState(73);
			match(FP);
			setState(74);
			match(SC);

			IsiVariable	var = (IsiVariable) symbolTable.get(_readID);
			CommandLeitura cmd = new CommandLeitura(_readID, var);
			stack.peek().add(cmd);
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

	public static class CmdescritaContext extends ParserRuleContext {
		public TerminalNode AP() { return getToken(langParser.AP, 0); }
		public TerminalNode ID() { return getToken(langParser.ID, 0); }
		public TerminalNode FP() { return getToken(langParser.FP, 0); }
		public TerminalNode SC() { return getToken(langParser.SC, 0); }
		public CmdescritaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmdescrita; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof langListener ) ((langListener)listener).enterCmdescrita(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof langListener ) ((langListener)listener).exitCmdescrita(this);
		}
	}

	public final CmdescritaContext cmdescrita() throws RecognitionException {
		CmdescritaContext _localctx = new CmdescritaContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_cmdescrita);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(77);
			match(T__5);
			setState(78);
			match(AP);
			setState(79);
			match(ID);
				verificaID(_input.LT(-1).getText());
			                      _writeID = _input.LT(-1).getText();
			                      _exprID = _input.LT(-1).getText();
			                      _exprContent = _input.LT(-1).getText();
			                      _exprDecision = _input.LT(-1).getText();
			                      _exprRepetition = _input.LT(-1).getText();
			                      curThread.add(new WriteCommand(_writeID)
			setState(81);
			match(FP);
			setState(82);
			match(SC);
			CommandEscrita cmd = new CommandEscrita(_writeID);
			stack.peek().add(cmd);
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

	public static class CmdattribContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(langParser.ID, 0); }
		public TerminalNode ATTR() { return getToken(langParser.ATTR, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode SC() { return getToken(langParser.SC, 0); }
		public CmdattribContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmdattrib; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof langListener ) ((langListener)listener).enterCmdattrib(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof langListener ) ((langListener)listener).exitCmdattrib(this);
		}
	}

	public final CmdattribContext cmdattrib() throws RecognitionException {
		CmdattribContext _localctx = new CmdattribContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_cmdattrib);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(85);
			match(ID);
				verificaID(_input.LT(-1).getText());
			                      _exprID = _input.LT(-1).getText();
			                      _exprContent = _input.LT(-1).getText();
			                      _exprDecision = _input.LT(-1).getText();
			                      _exprRepetition = _input.LT(-1).getText();
			                      curThread.add(new AtribCommand(_exprID, _exprContent));
			setState(87);
			match(ATTR);
			_exprContent = "";
			setState(89);
			expr();
			setState(90);
			match(SC);
				if(_exprContent == ""){
					throw new IsiSemanticException("Symbol "+_exprID+" must be initialized");
				}
				else{
					CommandAtribuicao cmd = new CommandAtribuicao(_exprID, _exprContent);
					stack.peek().add(cmd);
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

	public static class CmdenquantoContext extends ParserRuleContext {
		public TerminalNode AP() { return getToken(langParser.AP, 0); }
		public List<TerminalNode> ID() { return getTokens(langParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(langParser.ID, i);
		}
		public TerminalNode OPREL() { return getToken(langParser.OPREL, 0); }
		public TerminalNode NUMBER() { return getToken(langParser.NUMBER, 0); }
		public TerminalNode FP() { return getToken(langParser.FP, 0); }
		public TerminalNode ACH() { return getToken(langParser.ACH, 0); }
		public TerminalNode FCH() { return getToken(langParser.FCH, 0); }
		public List<CmdContext> cmd() {
			return getRuleContexts(CmdContext.class);
		}
		public CmdContext cmd(int i) {
			return getRuleContext(CmdContext.class,i);
		}
		public CmdenquantoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmdenquanto; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof langListener ) ((langListener)listener).enterCmdenquanto(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof langListener ) ((langListener)listener).exitCmdenquanto(this);
		}
	}

	public final CmdenquantoContext enquanto() throws RecognitionException {
		CmdenquantoContext _localctx = new CmdenquantoContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_cmdenquanto);
		int _la;
		try{
			enterOuterAlt(_localctx, 1);
			{
			setState(93);
			match(T__6);
			setState(94);
			match(AP);
			setState(95);
			match(ID);
				_exprRepetition = _input.LT(-1).getText();
			setState(97);
			match(OPREL);
				_exprRepetition += _input.LT(-1).getText();
			setState(99);
			_la = _input.LA(1);
			if ( !(_la==ID || _la==NUMBER) ) {
				_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			_exprRepetition += _input.LT(-1).getText();
			setState(101);
			match(FP);
			setState(102);
			match(ACH);
			curThread = new ArrayList<AbstractCommand>();
			stack.push(curThread);
			setState(105);
			_errHandler.sync(this);
			_la = _input.LA(1);
			do{
				{
				{
				setState(104);
				cmd();
				}
				}
				setState(107);
				_errHandler.sync(this);
				_la = _input.LA(1);	
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__4) | (1L << T__5) | (1L << T__6) || (1L<< T__7) | (1L << ID))) != 0) );
			setState(109);
			match(FCH);
			listaTrue = stack.pop();
			CommandRepeticao cmd = new CommandRepeticao(_exprRepetition, listaTrue);
			stack.peek().add(cmd);
			}
		}
		catch (RecognitionException re){
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this,re);
		}
		finally{
			exitRule();
		}
		return _localctx;
	}

	public static class CmdselecaoContext extends ParserRuleContext {
		public TerminalNode AP() { return getToken(langParser.AP, 0); }
		public List<TerminalNode> ID() { return getTokens(langParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(langParser.ID, i);
		}
		public TerminalNode OPREL() { return getToken(langParser.OPREL, 0); }
		public TerminalNode NUMBER() { return getToken(langParser.NUMBER, 0); }
		public TerminalNode FP() { return getToken(langParser.FP, 0); }
		public TerminalNode ACH() { return getToken(langParser.ACH, 0); }
		public TerminalNode ACH(int i) {
			return getToken(langParser.ACH, i);
		}
		public List<TerminalNode> FCH() { return getTokens(langParser.FCH); }
		public TerminalNode FCH(int i) {
			return getToken(langParser.FCH, i);
		}
		public List<CmdContext> cmd() {
			return getRuleContexts(CmdContext.class);
		}
		public CmdContext cmd(int i) {
			return getRuleContext(CmdContext.class,i);
		}
		public CmdselecaoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmdselecao; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof langListener ) ((langListener)listener).enterCmdselecao(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof langListener ) ((langListener)listener).exitCmdselecao(this);
		}
	}

	public final CmdselecaoContext cmdselecao() throws RecognitionException {
		CmdselecaoContext _localctx = new CmdselecaoContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_cmdselecao);
		int _la;
		try{
			enterOuterAlt(_localctx, 1);
			{
			setState(112);
			match(T__7);
			setState(113);
			match(AP);
			setState(114);
			match(ID);
				_exprDecision = _input.LT(-1).getText();
			setState(116);
			match(OPREL);
				_exprDecision += _input.LT(-1).getText();
			setState(118);
			_la = _input.LA(1);
			if ( !(_la==ID || _la==NUMBER) ) {
				_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			_exprDecision += _input.LT(-1).getText();
			setState(120);
			match(FP);
			setState(121);
			match(ACH);
			curThread = new ArrayList<AbstractCommand>();
			stack.push(curThread);
			setState(124);
			_errHandler.sync(this);
			_la = _input.LA(1);
			do{
				{
				{
				setState(123);
				cmd();
				}
				}
				setState(126);
				_errHandler.sync(this);
				_la = _input.LA(1);	
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__4) | (1L << T__5) | (1L << T__6) || (1L<< T__7) | (1L << ID))) != 0) );
			setState(128);
			match(FCH);
			listaTrue = stack.pop();
			setState(141);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if(_la==T__8) {
				{
				setState(130);
				match(T__8);
				setState(131);
				match(ACH);
				curThread = new ArrayList<AbstractCommand>();
				stack.push(curThread);
				setState(134);
				_errHandler.sync(this);
				_la = _input.LA(1);
				do{
					{
					{
					setState(133);
					cmd();
					}
					}
					setState(136);
					_errHandler.sync(this);
					_la = _input.LA(1);	
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__4) | (1L << T__5) | (1L << T__6) || (1L<< T__7) | (1L << ID))) != 0) );
				setState(138);
				match(FCH);
				listaFalse = stack.pop();
				CommandDecisao cmd = new CommandDecisao(_exprDecision, listaTrue, listaFalse);
				stack.peek().add(cmd);
				}
			}
		}
		catch (RecognitionException re){
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this,re);
		}
		finally{
			exitRule();
		}
		return _localctx;
	}

	public static class ExprContext extends ParserRuleContext {
		public List<TermoContext> termo() {
			return getRuleContexts(TermoContext.class);
		}
		public TermoContext termo(int i) {
			return getRuleContext(TermoContext.class,i);
		}
		public List<TerminalNode> OP() { return getTokens(langParser.OP); }
		public TerminalNode OP(int i) {
			return getToken(langParser.OP, i);
		}
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof langListener ) ((langListener)listener).enterExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof langListener ) ((langListener)listener).exitExpr(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		ExprContext _localctx = new ExprContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_expr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(143);
			termo();
			setState(149);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==OP) {
				{
				{
				setState(144);
				match(OP);
				setState(146);
				termo();
				}
				}
				setState(151);
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

	public static class TermoContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(langParser.ID, 0); }
		public TerminalNode NUMBER() { return getToken(langParser.NUMBER, 0); }
		public TerminalNode TEXT() { return getToken(langParser.TEXT, 0); }
		public TermoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_termo; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof langListener ) ((langListener)listener).enterTermo(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof langListener ) ((langListener)listener).exitTermo(this);
		}
	}

	public final TermoContext termo() throws RecognitionException {
		TermoContext _localctx = new TermoContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_termo);
		int _la;
		try {
				setState(156);
				_errHandler.sync(this);
				case ID:
					enterOuterAlt(_localctx, 1);
					{
					setState(152);
					match(ID);
					verificaID(_input.LT(-1).getText());
					_exprContent += _input.LT(-1).getText();
					}
					break;
				case TEXTO:
					enterOuterAlt(_localctx, 2);
					{
					setState(154);
					_la = _input.LA(1);
					if ( !(_la==NUMBER||_la==TEXTO) ) {
						_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					_exprContent += _input.LT(-1).getText();
					}
					break;
				default:
					throw new NoViableAltException(this);
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\16C\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\3\2\3\2\3\2\3\2\3\3"+
		"\6\3\30\n\3\r\3\16\3\31\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\5\4%\n\4\3"+
		"\5\3\5\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7"+
		"\3\b\3\b\3\b\7\b<\n\b\f\b\16\b?\13\b\3\t\3\t\3\t\2\2\n\2\4\6\b\n\f\16"+
		"\20\2\3\3\2\f\r\2>\2\22\3\2\2\2\4\27\3\2\2\2\6$\3\2\2\2\b&\3\2\2\2\n-"+
		"\3\2\2\2\f\63\3\2\2\2\168\3\2\2\2\20@\3\2\2\2\22\23\7\3\2\2\23\24\5\4"+
		"\3\2\24\25\7\4\2\2\25\3\3\2\2\2\26\30\5\6\4\2\27\26\3\2\2\2\30\31\3\2"+
		"\2\2\31\27\3\2\2\2\31\32\3\2\2\2\32\5\3\2\2\2\33\34\5\b\5\2\34\35\b\4"+
		"\1\2\35%\3\2\2\2\36\37\5\n\6\2\37 \b\4\1\2 %\3\2\2\2!\"\5\f\7\2\"#\b\4"+
		"\1\2#%\3\2\2\2$\33\3\2\2\2$\36\3\2\2\2$!\3\2\2\2%\7\3\2\2\2&\'\7\5\2\2"+
		"\'(\7\7\2\2()\7\f\2\2)*\b\5\1\2*+\7\b\2\2+,\7\t\2\2,\t\3\2\2\2-.\7\6\2"+
		"\2./\7\7\2\2/\60\7\f\2\2\60\61\7\b\2\2\61\62\7\t\2\2\62\13\3\2\2\2\63"+
		"\64\7\f\2\2\64\65\7\13\2\2\65\66\5\16\b\2\66\67\7\t\2\2\67\r\3\2\2\28"+
		"=\5\20\t\29:\7\n\2\2:<\5\20\t\2;9\3\2\2\2<?\3\2\2\2=;\3\2\2\2=>\3\2\2"+
		"\2>\17\3\2\2\2?=\3\2\2\2@A\t\2\2\2A\21\3\2\2\2\5\31$=";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}