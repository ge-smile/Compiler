// Generated from Tscript.g by ANTLR 4.4

  package ts.parse;
  import ts.Location;
  import ts.tree.*;
  import static ts.parse.TreeBuilder.*;
  import java.util.List;
  import java.util.ArrayList;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class TscriptParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.4", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		NUMERIC_LITERAL=1, STRING_LITERAL=2, BOOLEANL_LITERAL=3, NULLL_LITERAL=4, 
		NaN_LITERAL=5, LPAREN=6, RPAREN=7, SEMICOLON=8, EQUAL=9, PLUS=10, MINUS=11, 
		ASTERISK=12, SLASH=13, NOT=14, EQUALITY=15, SMALLER=16, LARGER=17, COMMA=18, 
		PRINT=19, VAR=20, IDENTIFIER=21, WhiteSpace=22;
	public static final String[] tokenNames = {
		"<INVALID>", "NUMERIC_LITERAL", "STRING_LITERAL", "BOOLEANL_LITERAL", 
		"'null'", "'NaN'", "LPAREN", "RPAREN", "SEMICOLON", "EQUAL", "PLUS", "MINUS", 
		"ASTERISK", "SLASH", "NOT", "EQUALITY", "SMALLER", "LARGER", "COMMA", 
		"'print'", "'var'", "IDENTIFIER", "WhiteSpace"
	};
	public static final int
		RULE_program = 0, RULE_statementList = 1, RULE_statement = 2, RULE_varStatement = 3, 
		RULE_variableDeclarationList = 4, RULE_variableDeclaration = 5, RULE_expressionStatement = 6, 
		RULE_printStatement = 7, RULE_expression = 8, RULE_assignmentExpression = 9, 
		RULE_leftHandSideExpression = 10, RULE_additiveExpression = 11, RULE_multiplicativeExpression = 12, 
		RULE_unaryExpression = 13, RULE_postfixExpression = 14, RULE_equalityExpression = 15, 
		RULE_relationalExpression = 16, RULE_shiftExpression = 17, RULE_primaryExpression = 18;
	public static final String[] ruleNames = {
		"program", "statementList", "statement", "varStatement", "variableDeclarationList", 
		"variableDeclaration", "expressionStatement", "printStatement", "expression", 
		"assignmentExpression", "leftHandSideExpression", "additiveExpression", 
		"multiplicativeExpression", "unaryExpression", "postfixExpression", "equalityExpression", 
		"relationalExpression", "shiftExpression", "primaryExpression"
	};

	@Override
	public String getGrammarFileName() { return "Tscript.g"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }


	  // grab location info (filename/line/column) from token
	  // in order to stick into AST nodes for later error reporting
	  public Location loc(final Token token)
	  {
	    return new Location(getSourceName(), token.getLine(),
	      token.getCharPositionInLine());
	  }

	  // a program is a list of statements
	  // i.e. root of AST is stored here
	  // set by the action for the start symbol
	  private List<Statement> semanticValue;
	  public List<Statement> getSemanticValue()
	  {
	    return semanticValue;
	  }

	public TscriptParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class ProgramContext extends ParserRuleContext {
		public StatementListContext sl;
		public TerminalNode EOF() { return getToken(TscriptParser.EOF, 0); }
		public StatementListContext statementList() {
			return getRuleContext(StatementListContext.class,0);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(38); ((ProgramContext)_localctx).sl = statementList(0);
			setState(39); match(EOF);
			 semanticValue = ((ProgramContext)_localctx).sl.lval; 
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

	public static class StatementListContext extends ParserRuleContext {
		public List<Statement> lval;
		public StatementListContext sl;
		public StatementContext s;
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public StatementListContext statementList() {
			return getRuleContext(StatementListContext.class,0);
		}
		public StatementListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statementList; }
	}

	public final StatementListContext statementList() throws RecognitionException {
		return statementList(0);
	}

	private StatementListContext statementList(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		StatementListContext _localctx = new StatementListContext(_ctx, _parentState);
		StatementListContext _prevctx = _localctx;
		int _startState = 2;
		enterRecursionRule(_localctx, 2, RULE_statementList, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			 ((StatementListContext)_localctx).lval =  new ArrayList<Statement>(); 
			}
			_ctx.stop = _input.LT(-1);
			setState(51);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new StatementListContext(_parentctx, _parentState);
					_localctx.sl = _prevctx;
					pushNewRecursionContext(_localctx, _startState, RULE_statementList);
					setState(45);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(46); ((StatementListContext)_localctx).s = statement();
					 ((StatementListContext)_localctx).sl.lval.add(((StatementListContext)_localctx).s.lval);
					                ((StatementListContext)_localctx).lval =  ((StatementListContext)_localctx).sl.lval; 
					}
					} 
				}
				setState(53);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class StatementContext extends ParserRuleContext {
		public Statement lval;
		public VarStatementContext v;
		public ExpressionStatementContext e;
		public PrintStatementContext p;
		public VarStatementContext varStatement() {
			return getRuleContext(VarStatementContext.class,0);
		}
		public PrintStatementContext printStatement() {
			return getRuleContext(PrintStatementContext.class,0);
		}
		public ExpressionStatementContext expressionStatement() {
			return getRuleContext(ExpressionStatementContext.class,0);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_statement);
		try {
			setState(63);
			switch (_input.LA(1)) {
			case VAR:
				enterOuterAlt(_localctx, 1);
				{
				setState(54); ((StatementContext)_localctx).v = varStatement();
				 ((StatementContext)_localctx).lval =  ((StatementContext)_localctx).v.lval; 
				}
				break;
			case NUMERIC_LITERAL:
			case STRING_LITERAL:
			case BOOLEANL_LITERAL:
			case NULLL_LITERAL:
			case LPAREN:
			case MINUS:
			case NOT:
			case IDENTIFIER:
				enterOuterAlt(_localctx, 2);
				{
				setState(57); ((StatementContext)_localctx).e = expressionStatement();
				 ((StatementContext)_localctx).lval =  ((StatementContext)_localctx).e.lval; 
				}
				break;
			case PRINT:
				enterOuterAlt(_localctx, 3);
				{
				setState(60); ((StatementContext)_localctx).p = printStatement();
				 ((StatementContext)_localctx).lval =  ((StatementContext)_localctx).p.lval; 
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

	public static class VarStatementContext extends ParserRuleContext {
		public Statement lval;
		public VariableDeclarationListContext v;
		public TerminalNode SEMICOLON() { return getToken(TscriptParser.SEMICOLON, 0); }
		public VariableDeclarationListContext variableDeclarationList() {
			return getRuleContext(VariableDeclarationListContext.class,0);
		}
		public TerminalNode VAR() { return getToken(TscriptParser.VAR, 0); }
		public VarStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varStatement; }
	}

	public final VarStatementContext varStatement() throws RecognitionException {
		VarStatementContext _localctx = new VarStatementContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_varStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(65); match(VAR);
			setState(66); ((VarStatementContext)_localctx).v = variableDeclarationList(0);
			setState(67); match(SEMICOLON);
			 ((VarStatementContext)_localctx).lval =  buildVarStatement(loc(_localctx.start), ((VarStatementContext)_localctx).v.lval); 
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

	public static class VariableDeclarationListContext extends ParserRuleContext {
		public List<Expression> lval;
		public VariableDeclarationListContext vlist;
		public VariableDeclarationContext v;
		public VariableDeclarationListContext variableDeclarationList() {
			return getRuleContext(VariableDeclarationListContext.class,0);
		}
		public TerminalNode COMMA() { return getToken(TscriptParser.COMMA, 0); }
		public VariableDeclarationContext variableDeclaration() {
			return getRuleContext(VariableDeclarationContext.class,0);
		}
		public VariableDeclarationListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variableDeclarationList; }
	}

	public final VariableDeclarationListContext variableDeclarationList() throws RecognitionException {
		return variableDeclarationList(0);
	}

	private VariableDeclarationListContext variableDeclarationList(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		VariableDeclarationListContext _localctx = new VariableDeclarationListContext(_ctx, _parentState);
		VariableDeclarationListContext _prevctx = _localctx;
		int _startState = 8;
		enterRecursionRule(_localctx, 8, RULE_variableDeclarationList, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(71); ((VariableDeclarationListContext)_localctx).v = variableDeclaration();
			 ((VariableDeclarationListContext)_localctx).lval =  new ArrayList<Expression>(); 
			      _localctx.lval.add(((VariableDeclarationListContext)_localctx).v.lval); 
			}
			_ctx.stop = _input.LT(-1);
			setState(81);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new VariableDeclarationListContext(_parentctx, _parentState);
					_localctx.vlist = _prevctx;
					pushNewRecursionContext(_localctx, _startState, RULE_variableDeclarationList);
					setState(74);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(75); match(COMMA);
					setState(76); ((VariableDeclarationListContext)_localctx).v = variableDeclaration();
					 ((VariableDeclarationListContext)_localctx).vlist.lval.add(((VariableDeclarationListContext)_localctx).v.lval);
					                ((VariableDeclarationListContext)_localctx).lval =  ((VariableDeclarationListContext)_localctx).vlist.lval; 
					}
					} 
				}
				setState(83);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class VariableDeclarationContext extends ParserRuleContext {
		public Expression lval;
		public Token IDENTIFIER;
		public AssignmentExpressionContext a;
		public TerminalNode IDENTIFIER() { return getToken(TscriptParser.IDENTIFIER, 0); }
		public AssignmentExpressionContext assignmentExpression() {
			return getRuleContext(AssignmentExpressionContext.class,0);
		}
		public TerminalNode EQUAL() { return getToken(TscriptParser.EQUAL, 0); }
		public VariableDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variableDeclaration; }
	}

	public final VariableDeclarationContext variableDeclaration() throws RecognitionException {
		VariableDeclarationContext _localctx = new VariableDeclarationContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_variableDeclaration);
		try {
			setState(91);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(84); ((VariableDeclarationContext)_localctx).IDENTIFIER = match(IDENTIFIER);
				 ((VariableDeclarationContext)_localctx).lval =  buildVarDeclaration(loc(_localctx.start), (((VariableDeclarationContext)_localctx).IDENTIFIER!=null?((VariableDeclarationContext)_localctx).IDENTIFIER.getText():null), null); 
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(86); ((VariableDeclarationContext)_localctx).IDENTIFIER = match(IDENTIFIER);
				setState(87); match(EQUAL);
				setState(88); ((VariableDeclarationContext)_localctx).a = assignmentExpression();
				 ((VariableDeclarationContext)_localctx).lval =  buildVarDeclaration(loc(_localctx.start), (((VariableDeclarationContext)_localctx).IDENTIFIER!=null?((VariableDeclarationContext)_localctx).IDENTIFIER.getText():null),
				              buildBinaryOperator(loc(_localctx.start), Binop.ASSIGN,
				              buildIdentifier(loc(_localctx.start), (((VariableDeclarationContext)_localctx).IDENTIFIER!=null?((VariableDeclarationContext)_localctx).IDENTIFIER.getText():null)), ((VariableDeclarationContext)_localctx).a.lval));
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

	public static class ExpressionStatementContext extends ParserRuleContext {
		public Statement lval;
		public ExpressionContext e;
		public TerminalNode SEMICOLON() { return getToken(TscriptParser.SEMICOLON, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ExpressionStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expressionStatement; }
	}

	public final ExpressionStatementContext expressionStatement() throws RecognitionException {
		ExpressionStatementContext _localctx = new ExpressionStatementContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_expressionStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(93); ((ExpressionStatementContext)_localctx).e = expression(0);
			setState(94); match(SEMICOLON);
			 ((ExpressionStatementContext)_localctx).lval =  buildExpressionStatement(loc(_localctx.start), ((ExpressionStatementContext)_localctx).e.lval); 
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

	public static class PrintStatementContext extends ParserRuleContext {
		public Statement lval;
		public ExpressionContext e;
		public TerminalNode PRINT() { return getToken(TscriptParser.PRINT, 0); }
		public TerminalNode SEMICOLON() { return getToken(TscriptParser.SEMICOLON, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public PrintStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_printStatement; }
	}

	public final PrintStatementContext printStatement() throws RecognitionException {
		PrintStatementContext _localctx = new PrintStatementContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_printStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(97); match(PRINT);
			setState(98); ((PrintStatementContext)_localctx).e = expression(0);
			setState(99); match(SEMICOLON);
			 ((PrintStatementContext)_localctx).lval =  buildPrintStatement(loc(_localctx.start), ((PrintStatementContext)_localctx).e.lval); 
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

	public static class ExpressionContext extends ParserRuleContext {
		public Expression lval;
		public AssignmentExpressionContext a;
		public TerminalNode COMMA() { return getToken(TscriptParser.COMMA, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public AssignmentExpressionContext assignmentExpression() {
			return getRuleContext(AssignmentExpressionContext.class,0);
		}
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
	}

	public final ExpressionContext expression() throws RecognitionException {
		return expression(0);
	}

	private ExpressionContext expression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpressionContext _localctx = new ExpressionContext(_ctx, _parentState);
		ExpressionContext _prevctx = _localctx;
		int _startState = 16;
		enterRecursionRule(_localctx, 16, RULE_expression, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(103); ((ExpressionContext)_localctx).a = assignmentExpression();
			 ((ExpressionContext)_localctx).lval =  ((ExpressionContext)_localctx).a.lval; 
			}
			_ctx.stop = _input.LT(-1);
			setState(113);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new ExpressionContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_expression);
					setState(106);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(107); match(COMMA);
					setState(108); ((ExpressionContext)_localctx).a = assignmentExpression();
					 ((ExpressionContext)_localctx).lval =  ((ExpressionContext)_localctx).a.lval; 
					}
					} 
				}
				setState(115);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class AssignmentExpressionContext extends ParserRuleContext {
		public Expression lval;
		public AdditiveExpressionContext a;
		public LeftHandSideExpressionContext l;
		public AssignmentExpressionContext r;
		public EqualityExpressionContext e;
		public AdditiveExpressionContext additiveExpression() {
			return getRuleContext(AdditiveExpressionContext.class,0);
		}
		public LeftHandSideExpressionContext leftHandSideExpression() {
			return getRuleContext(LeftHandSideExpressionContext.class,0);
		}
		public EqualityExpressionContext equalityExpression() {
			return getRuleContext(EqualityExpressionContext.class,0);
		}
		public AssignmentExpressionContext assignmentExpression() {
			return getRuleContext(AssignmentExpressionContext.class,0);
		}
		public TerminalNode EQUAL() { return getToken(TscriptParser.EQUAL, 0); }
		public AssignmentExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignmentExpression; }
	}

	public final AssignmentExpressionContext assignmentExpression() throws RecognitionException {
		AssignmentExpressionContext _localctx = new AssignmentExpressionContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_assignmentExpression);
		try {
			setState(127);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(116); ((AssignmentExpressionContext)_localctx).a = additiveExpression(0);
				 ((AssignmentExpressionContext)_localctx).lval =  ((AssignmentExpressionContext)_localctx).a.lval; 
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(119); ((AssignmentExpressionContext)_localctx).l = leftHandSideExpression();
				setState(120); match(EQUAL);
				setState(121); ((AssignmentExpressionContext)_localctx).r = assignmentExpression();
				 checkAssignmentDestination(loc(_localctx.start), ((AssignmentExpressionContext)_localctx).l.lval);
				      ((AssignmentExpressionContext)_localctx).lval =  buildBinaryOperator(loc(_localctx.start), Binop.ASSIGN,
				        ((AssignmentExpressionContext)_localctx).l.lval, ((AssignmentExpressionContext)_localctx).r.lval); 
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(124); ((AssignmentExpressionContext)_localctx).e = equalityExpression(0);
				 ((AssignmentExpressionContext)_localctx).lval =  ((AssignmentExpressionContext)_localctx).e.lval; 
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

	public static class LeftHandSideExpressionContext extends ParserRuleContext {
		public Expression lval;
		public PrimaryExpressionContext p;
		public PrimaryExpressionContext primaryExpression() {
			return getRuleContext(PrimaryExpressionContext.class,0);
		}
		public LeftHandSideExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_leftHandSideExpression; }
	}

	public final LeftHandSideExpressionContext leftHandSideExpression() throws RecognitionException {
		LeftHandSideExpressionContext _localctx = new LeftHandSideExpressionContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_leftHandSideExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(129); ((LeftHandSideExpressionContext)_localctx).p = primaryExpression();
			 ((LeftHandSideExpressionContext)_localctx).lval =  ((LeftHandSideExpressionContext)_localctx).p.lval; 
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

	public static class AdditiveExpressionContext extends ParserRuleContext {
		public Expression lval;
		public AdditiveExpressionContext l;
		public MultiplicativeExpressionContext m;
		public MultiplicativeExpressionContext r;
		public AdditiveExpressionContext additiveExpression() {
			return getRuleContext(AdditiveExpressionContext.class,0);
		}
		public TerminalNode MINUS() { return getToken(TscriptParser.MINUS, 0); }
		public MultiplicativeExpressionContext multiplicativeExpression() {
			return getRuleContext(MultiplicativeExpressionContext.class,0);
		}
		public TerminalNode PLUS() { return getToken(TscriptParser.PLUS, 0); }
		public AdditiveExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_additiveExpression; }
	}

	public final AdditiveExpressionContext additiveExpression() throws RecognitionException {
		return additiveExpression(0);
	}

	private AdditiveExpressionContext additiveExpression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		AdditiveExpressionContext _localctx = new AdditiveExpressionContext(_ctx, _parentState);
		AdditiveExpressionContext _prevctx = _localctx;
		int _startState = 22;
		enterRecursionRule(_localctx, 22, RULE_additiveExpression, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(133); ((AdditiveExpressionContext)_localctx).m = multiplicativeExpression(0);
			 ((AdditiveExpressionContext)_localctx).lval =  ((AdditiveExpressionContext)_localctx).m.lval; 
			}
			_ctx.stop = _input.LT(-1);
			setState(148);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(146);
					switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
					case 1:
						{
						_localctx = new AdditiveExpressionContext(_parentctx, _parentState);
						_localctx.l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_additiveExpression);
						setState(136);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(137); match(PLUS);
						setState(138); ((AdditiveExpressionContext)_localctx).r = multiplicativeExpression(0);
						 ((AdditiveExpressionContext)_localctx).lval =  buildBinaryOperator(loc(_localctx.start), Binop.ADD,
						                  ((AdditiveExpressionContext)_localctx).l.lval, ((AdditiveExpressionContext)_localctx).r.lval); 
						}
						break;
					case 2:
						{
						_localctx = new AdditiveExpressionContext(_parentctx, _parentState);
						_localctx.l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_additiveExpression);
						setState(141);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(142); match(MINUS);
						setState(143); ((AdditiveExpressionContext)_localctx).r = multiplicativeExpression(0);
						 ((AdditiveExpressionContext)_localctx).lval =  buildBinaryOperator(loc(_localctx.start), Binop.MINUS,
						                  ((AdditiveExpressionContext)_localctx).l.lval, ((AdditiveExpressionContext)_localctx).r.lval); 
						}
						break;
					}
					} 
				}
				setState(150);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class MultiplicativeExpressionContext extends ParserRuleContext {
		public Expression lval;
		public MultiplicativeExpressionContext l;
		public UnaryExpressionContext u;
		public TerminalNode ASTERISK() { return getToken(TscriptParser.ASTERISK, 0); }
		public UnaryExpressionContext unaryExpression() {
			return getRuleContext(UnaryExpressionContext.class,0);
		}
		public MultiplicativeExpressionContext multiplicativeExpression() {
			return getRuleContext(MultiplicativeExpressionContext.class,0);
		}
		public TerminalNode SLASH() { return getToken(TscriptParser.SLASH, 0); }
		public MultiplicativeExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_multiplicativeExpression; }
	}

	public final MultiplicativeExpressionContext multiplicativeExpression() throws RecognitionException {
		return multiplicativeExpression(0);
	}

	private MultiplicativeExpressionContext multiplicativeExpression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		MultiplicativeExpressionContext _localctx = new MultiplicativeExpressionContext(_ctx, _parentState);
		MultiplicativeExpressionContext _prevctx = _localctx;
		int _startState = 24;
		enterRecursionRule(_localctx, 24, RULE_multiplicativeExpression, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(152); ((MultiplicativeExpressionContext)_localctx).u = unaryExpression();
			 ((MultiplicativeExpressionContext)_localctx).lval =  ((MultiplicativeExpressionContext)_localctx).u.lval; 
			}
			_ctx.stop = _input.LT(-1);
			setState(167);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(165);
					switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
					case 1:
						{
						_localctx = new MultiplicativeExpressionContext(_parentctx, _parentState);
						_localctx.l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_multiplicativeExpression);
						setState(155);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(156); match(ASTERISK);
						setState(157); ((MultiplicativeExpressionContext)_localctx).u = unaryExpression();
						 ((MultiplicativeExpressionContext)_localctx).lval =  buildBinaryOperator(loc(_localctx.start), Binop.MULTIPLY,
						                ((MultiplicativeExpressionContext)_localctx).l.lval, ((MultiplicativeExpressionContext)_localctx).u.lval); 
						}
						break;
					case 2:
						{
						_localctx = new MultiplicativeExpressionContext(_parentctx, _parentState);
						_localctx.l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_multiplicativeExpression);
						setState(160);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(161); match(SLASH);
						setState(162); ((MultiplicativeExpressionContext)_localctx).u = unaryExpression();
						 ((MultiplicativeExpressionContext)_localctx).lval =  buildBinaryOperator(loc(_localctx.start), Binop.DIVIDE,
						                ((MultiplicativeExpressionContext)_localctx).l.lval, ((MultiplicativeExpressionContext)_localctx).u.lval); 
						}
						break;
					}
					} 
				}
				setState(169);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class UnaryExpressionContext extends ParserRuleContext {
		public Expression lval;
		public PostfixExpressionContext p;
		public UnaryExpressionContext u;
		public UnaryExpressionContext unaryExpression() {
			return getRuleContext(UnaryExpressionContext.class,0);
		}
		public TerminalNode MINUS() { return getToken(TscriptParser.MINUS, 0); }
		public TerminalNode NOT() { return getToken(TscriptParser.NOT, 0); }
		public PostfixExpressionContext postfixExpression() {
			return getRuleContext(PostfixExpressionContext.class,0);
		}
		public UnaryExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unaryExpression; }
	}

	public final UnaryExpressionContext unaryExpression() throws RecognitionException {
		UnaryExpressionContext _localctx = new UnaryExpressionContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_unaryExpression);
		try {
			setState(181);
			switch (_input.LA(1)) {
			case NUMERIC_LITERAL:
			case STRING_LITERAL:
			case BOOLEANL_LITERAL:
			case NULLL_LITERAL:
			case LPAREN:
			case IDENTIFIER:
				enterOuterAlt(_localctx, 1);
				{
				setState(170); ((UnaryExpressionContext)_localctx).p = postfixExpression();
				 ((UnaryExpressionContext)_localctx).lval =  ((UnaryExpressionContext)_localctx).p.lval; 
				}
				break;
			case NOT:
				enterOuterAlt(_localctx, 2);
				{
				setState(173); match(NOT);
				setState(174); ((UnaryExpressionContext)_localctx).u = unaryExpression();
				 ((UnaryExpressionContext)_localctx).lval =  buildUnaryOperator(loc(_localctx.start), Unop.NOT, 
				  	  ((UnaryExpressionContext)_localctx).u.lval); 
				}
				break;
			case MINUS:
				enterOuterAlt(_localctx, 3);
				{
				setState(177); match(MINUS);
				setState(178); ((UnaryExpressionContext)_localctx).u = unaryExpression();
				 ((UnaryExpressionContext)_localctx).lval =  buildUnaryOperator(loc(_localctx.start), Unop.MINUS, 
				  	  ((UnaryExpressionContext)_localctx).u.lval); 
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

	public static class PostfixExpressionContext extends ParserRuleContext {
		public Expression lval;
		public LeftHandSideExpressionContext l;
		public LeftHandSideExpressionContext leftHandSideExpression() {
			return getRuleContext(LeftHandSideExpressionContext.class,0);
		}
		public PostfixExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_postfixExpression; }
	}

	public final PostfixExpressionContext postfixExpression() throws RecognitionException {
		PostfixExpressionContext _localctx = new PostfixExpressionContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_postfixExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(183); ((PostfixExpressionContext)_localctx).l = leftHandSideExpression();
			 ((PostfixExpressionContext)_localctx).lval =  ((PostfixExpressionContext)_localctx).l.lval; 
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

	public static class EqualityExpressionContext extends ParserRuleContext {
		public Expression lval;
		public EqualityExpressionContext l;
		public RelationalExpressionContext r;
		public TerminalNode EQUALITY() { return getToken(TscriptParser.EQUALITY, 0); }
		public RelationalExpressionContext relationalExpression() {
			return getRuleContext(RelationalExpressionContext.class,0);
		}
		public EqualityExpressionContext equalityExpression() {
			return getRuleContext(EqualityExpressionContext.class,0);
		}
		public EqualityExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_equalityExpression; }
	}

	public final EqualityExpressionContext equalityExpression() throws RecognitionException {
		return equalityExpression(0);
	}

	private EqualityExpressionContext equalityExpression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		EqualityExpressionContext _localctx = new EqualityExpressionContext(_ctx, _parentState);
		EqualityExpressionContext _prevctx = _localctx;
		int _startState = 30;
		enterRecursionRule(_localctx, 30, RULE_equalityExpression, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(187); ((EqualityExpressionContext)_localctx).r = relationalExpression(0);
			 ((EqualityExpressionContext)_localctx).lval =  ((EqualityExpressionContext)_localctx).r.lval; 
			}
			_ctx.stop = _input.LT(-1);
			setState(197);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new EqualityExpressionContext(_parentctx, _parentState);
					_localctx.l = _prevctx;
					pushNewRecursionContext(_localctx, _startState, RULE_equalityExpression);
					setState(190);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(191); match(EQUALITY);
					setState(192); ((EqualityExpressionContext)_localctx).r = relationalExpression(0);
					 ((EqualityExpressionContext)_localctx).lval =  buildBinaryOperator(loc(_localctx.start), Binop.EQUALITY,
					          		  ((EqualityExpressionContext)_localctx).l.lval, ((EqualityExpressionContext)_localctx).r.lval); 
					}
					} 
				}
				setState(199);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class RelationalExpressionContext extends ParserRuleContext {
		public Expression lval;
		public RelationalExpressionContext r;
		public ShiftExpressionContext s;
		public TerminalNode LARGER() { return getToken(TscriptParser.LARGER, 0); }
		public RelationalExpressionContext relationalExpression() {
			return getRuleContext(RelationalExpressionContext.class,0);
		}
		public ShiftExpressionContext shiftExpression() {
			return getRuleContext(ShiftExpressionContext.class,0);
		}
		public TerminalNode SMALLER() { return getToken(TscriptParser.SMALLER, 0); }
		public RelationalExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_relationalExpression; }
	}

	public final RelationalExpressionContext relationalExpression() throws RecognitionException {
		return relationalExpression(0);
	}

	private RelationalExpressionContext relationalExpression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		RelationalExpressionContext _localctx = new RelationalExpressionContext(_ctx, _parentState);
		RelationalExpressionContext _prevctx = _localctx;
		int _startState = 32;
		enterRecursionRule(_localctx, 32, RULE_relationalExpression, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(201); ((RelationalExpressionContext)_localctx).s = shiftExpression();
			 ((RelationalExpressionContext)_localctx).lval =  ((RelationalExpressionContext)_localctx).s.lval; 
			}
			_ctx.stop = _input.LT(-1);
			setState(216);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(214);
					switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
					case 1:
						{
						_localctx = new RelationalExpressionContext(_parentctx, _parentState);
						_localctx.r = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_relationalExpression);
						setState(204);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(205); match(SMALLER);
						setState(206); ((RelationalExpressionContext)_localctx).s = shiftExpression();
						 ((RelationalExpressionContext)_localctx).lval =  buildBinaryOperator(loc(_localctx.start), Binop.SMALLER,
						          		  ((RelationalExpressionContext)_localctx).r.lval, ((RelationalExpressionContext)_localctx).s.lval); 
						}
						break;
					case 2:
						{
						_localctx = new RelationalExpressionContext(_parentctx, _parentState);
						_localctx.r = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_relationalExpression);
						setState(209);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(210); match(LARGER);
						setState(211); ((RelationalExpressionContext)_localctx).s = shiftExpression();
						 ((RelationalExpressionContext)_localctx).lval =  buildBinaryOperator(loc(_localctx.start), Binop.LARGER,
						          		  ((RelationalExpressionContext)_localctx).r.lval, ((RelationalExpressionContext)_localctx).s.lval); 
						}
						break;
					}
					} 
				}
				setState(218);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class ShiftExpressionContext extends ParserRuleContext {
		public Expression lval;
		public AdditiveExpressionContext a;
		public AdditiveExpressionContext additiveExpression() {
			return getRuleContext(AdditiveExpressionContext.class,0);
		}
		public ShiftExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_shiftExpression; }
	}

	public final ShiftExpressionContext shiftExpression() throws RecognitionException {
		ShiftExpressionContext _localctx = new ShiftExpressionContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_shiftExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(219); ((ShiftExpressionContext)_localctx).a = additiveExpression(0);
			 ((ShiftExpressionContext)_localctx).lval =  ((ShiftExpressionContext)_localctx).a.lval; 
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

	public static class PrimaryExpressionContext extends ParserRuleContext {
		public Expression lval;
		public Token IDENTIFIER;
		public Token NUMERIC_LITERAL;
		public Token STRING_LITERAL;
		public ExpressionContext e;
		public Token BOOLEANL_LITERAL;
		public TerminalNode BOOLEANL_LITERAL() { return getToken(TscriptParser.BOOLEANL_LITERAL, 0); }
		public TerminalNode NUMERIC_LITERAL() { return getToken(TscriptParser.NUMERIC_LITERAL, 0); }
		public TerminalNode NULLL_LITERAL() { return getToken(TscriptParser.NULLL_LITERAL, 0); }
		public TerminalNode IDENTIFIER() { return getToken(TscriptParser.IDENTIFIER, 0); }
		public TerminalNode STRING_LITERAL() { return getToken(TscriptParser.STRING_LITERAL, 0); }
		public TerminalNode RPAREN() { return getToken(TscriptParser.RPAREN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode LPAREN() { return getToken(TscriptParser.LPAREN, 0); }
		public PrimaryExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_primaryExpression; }
	}

	public final PrimaryExpressionContext primaryExpression() throws RecognitionException {
		PrimaryExpressionContext _localctx = new PrimaryExpressionContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_primaryExpression);
		try {
			setState(237);
			switch (_input.LA(1)) {
			case IDENTIFIER:
				enterOuterAlt(_localctx, 1);
				{
				setState(222); ((PrimaryExpressionContext)_localctx).IDENTIFIER = match(IDENTIFIER);
				 ((PrimaryExpressionContext)_localctx).lval =  buildIdentifier(loc(_localctx.start), (((PrimaryExpressionContext)_localctx).IDENTIFIER!=null?((PrimaryExpressionContext)_localctx).IDENTIFIER.getText():null)); 
				}
				break;
			case NUMERIC_LITERAL:
				enterOuterAlt(_localctx, 2);
				{
				setState(224); ((PrimaryExpressionContext)_localctx).NUMERIC_LITERAL = match(NUMERIC_LITERAL);
				 ((PrimaryExpressionContext)_localctx).lval =  buildNumericLiteral(loc(_localctx.start), (((PrimaryExpressionContext)_localctx).NUMERIC_LITERAL!=null?((PrimaryExpressionContext)_localctx).NUMERIC_LITERAL.getText():null)); 
				}
				break;
			case STRING_LITERAL:
				enterOuterAlt(_localctx, 3);
				{
				setState(226); ((PrimaryExpressionContext)_localctx).STRING_LITERAL = match(STRING_LITERAL);
				 ((PrimaryExpressionContext)_localctx).lval =  buildStringLiteral(loc(_localctx.start), (((PrimaryExpressionContext)_localctx).STRING_LITERAL!=null?((PrimaryExpressionContext)_localctx).STRING_LITERAL.getText():null));
				}
				break;
			case LPAREN:
				enterOuterAlt(_localctx, 4);
				{
				setState(228); match(LPAREN);
				setState(229); ((PrimaryExpressionContext)_localctx).e = expression(0);
				setState(230); match(RPAREN);
				 ((PrimaryExpressionContext)_localctx).lval =  ((PrimaryExpressionContext)_localctx).e.lval; 
				}
				break;
			case NULLL_LITERAL:
				enterOuterAlt(_localctx, 5);
				{
				setState(233); match(NULLL_LITERAL);
				 ((PrimaryExpressionContext)_localctx).lval =  buildNullLiteral(loc(_localctx.start)); 
				}
				break;
			case BOOLEANL_LITERAL:
				enterOuterAlt(_localctx, 6);
				{
				setState(235); ((PrimaryExpressionContext)_localctx).BOOLEANL_LITERAL = match(BOOLEANL_LITERAL);
				 ((PrimaryExpressionContext)_localctx).lval =  buildBooleanLiteral(loc(_localctx.start), (((PrimaryExpressionContext)_localctx).BOOLEANL_LITERAL!=null?((PrimaryExpressionContext)_localctx).BOOLEANL_LITERAL.getText():null)); 
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 1: return statementList_sempred((StatementListContext)_localctx, predIndex);
		case 4: return variableDeclarationList_sempred((VariableDeclarationListContext)_localctx, predIndex);
		case 8: return expression_sempred((ExpressionContext)_localctx, predIndex);
		case 11: return additiveExpression_sempred((AdditiveExpressionContext)_localctx, predIndex);
		case 12: return multiplicativeExpression_sempred((MultiplicativeExpressionContext)_localctx, predIndex);
		case 15: return equalityExpression_sempred((EqualityExpressionContext)_localctx, predIndex);
		case 16: return relationalExpression_sempred((RelationalExpressionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expression_sempred(ExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 2: return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean statementList_sempred(StatementListContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0: return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean equalityExpression_sempred(EqualityExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 7: return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean relationalExpression_sempred(RelationalExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 8: return precpred(_ctx, 2);
		case 9: return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean variableDeclarationList_sempred(VariableDeclarationListContext _localctx, int predIndex) {
		switch (predIndex) {
		case 1: return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean additiveExpression_sempred(AdditiveExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 3: return precpred(_ctx, 2);
		case 4: return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean multiplicativeExpression_sempred(MultiplicativeExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 5: return precpred(_ctx, 2);
		case 6: return precpred(_ctx, 1);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\30\u00f2\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\7\3\64"+
		"\n\3\f\3\16\3\67\13\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\5\4B\n\4\3\5"+
		"\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\7\6R\n\6\f\6\16\6"+
		"U\13\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\5\7^\n\7\3\b\3\b\3\b\3\b\3\t\3\t\3"+
		"\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\7\nr\n\n\f\n\16\nu\13\n"+
		"\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\5\13\u0082\n\13"+
		"\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\7"+
		"\r\u0095\n\r\f\r\16\r\u0098\13\r\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3"+
		"\16\3\16\3\16\3\16\3\16\3\16\3\16\7\16\u00a8\n\16\f\16\16\16\u00ab\13"+
		"\16\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\5\17\u00b8"+
		"\n\17\3\20\3\20\3\20\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\7\21"+
		"\u00c6\n\21\f\21\16\21\u00c9\13\21\3\22\3\22\3\22\3\22\3\22\3\22\3\22"+
		"\3\22\3\22\3\22\3\22\3\22\3\22\3\22\7\22\u00d9\n\22\f\22\16\22\u00dc\13"+
		"\22\3\23\3\23\3\23\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3"+
		"\24\3\24\3\24\3\24\3\24\5\24\u00f0\n\24\3\24\2\t\4\n\22\30\32 \"\25\2"+
		"\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&\2\2\u00f4\2(\3\2\2\2\4,\3\2"+
		"\2\2\6A\3\2\2\2\bC\3\2\2\2\nH\3\2\2\2\f]\3\2\2\2\16_\3\2\2\2\20c\3\2\2"+
		"\2\22h\3\2\2\2\24\u0081\3\2\2\2\26\u0083\3\2\2\2\30\u0086\3\2\2\2\32\u0099"+
		"\3\2\2\2\34\u00b7\3\2\2\2\36\u00b9\3\2\2\2 \u00bc\3\2\2\2\"\u00ca\3\2"+
		"\2\2$\u00dd\3\2\2\2&\u00ef\3\2\2\2()\5\4\3\2)*\7\2\2\3*+\b\2\1\2+\3\3"+
		"\2\2\2,-\b\3\1\2-.\b\3\1\2.\65\3\2\2\2/\60\f\3\2\2\60\61\5\6\4\2\61\62"+
		"\b\3\1\2\62\64\3\2\2\2\63/\3\2\2\2\64\67\3\2\2\2\65\63\3\2\2\2\65\66\3"+
		"\2\2\2\66\5\3\2\2\2\67\65\3\2\2\289\5\b\5\29:\b\4\1\2:B\3\2\2\2;<\5\16"+
		"\b\2<=\b\4\1\2=B\3\2\2\2>?\5\20\t\2?@\b\4\1\2@B\3\2\2\2A8\3\2\2\2A;\3"+
		"\2\2\2A>\3\2\2\2B\7\3\2\2\2CD\7\26\2\2DE\5\n\6\2EF\7\n\2\2FG\b\5\1\2G"+
		"\t\3\2\2\2HI\b\6\1\2IJ\5\f\7\2JK\b\6\1\2KS\3\2\2\2LM\f\3\2\2MN\7\24\2"+
		"\2NO\5\f\7\2OP\b\6\1\2PR\3\2\2\2QL\3\2\2\2RU\3\2\2\2SQ\3\2\2\2ST\3\2\2"+
		"\2T\13\3\2\2\2US\3\2\2\2VW\7\27\2\2W^\b\7\1\2XY\7\27\2\2YZ\7\13\2\2Z["+
		"\5\24\13\2[\\\b\7\1\2\\^\3\2\2\2]V\3\2\2\2]X\3\2\2\2^\r\3\2\2\2_`\5\22"+
		"\n\2`a\7\n\2\2ab\b\b\1\2b\17\3\2\2\2cd\7\25\2\2de\5\22\n\2ef\7\n\2\2f"+
		"g\b\t\1\2g\21\3\2\2\2hi\b\n\1\2ij\5\24\13\2jk\b\n\1\2ks\3\2\2\2lm\f\3"+
		"\2\2mn\7\24\2\2no\5\24\13\2op\b\n\1\2pr\3\2\2\2ql\3\2\2\2ru\3\2\2\2sq"+
		"\3\2\2\2st\3\2\2\2t\23\3\2\2\2us\3\2\2\2vw\5\30\r\2wx\b\13\1\2x\u0082"+
		"\3\2\2\2yz\5\26\f\2z{\7\13\2\2{|\5\24\13\2|}\b\13\1\2}\u0082\3\2\2\2~"+
		"\177\5 \21\2\177\u0080\b\13\1\2\u0080\u0082\3\2\2\2\u0081v\3\2\2\2\u0081"+
		"y\3\2\2\2\u0081~\3\2\2\2\u0082\25\3\2\2\2\u0083\u0084\5&\24\2\u0084\u0085"+
		"\b\f\1\2\u0085\27\3\2\2\2\u0086\u0087\b\r\1\2\u0087\u0088\5\32\16\2\u0088"+
		"\u0089\b\r\1\2\u0089\u0096\3\2\2\2\u008a\u008b\f\4\2\2\u008b\u008c\7\f"+
		"\2\2\u008c\u008d\5\32\16\2\u008d\u008e\b\r\1\2\u008e\u0095\3\2\2\2\u008f"+
		"\u0090\f\3\2\2\u0090\u0091\7\r\2\2\u0091\u0092\5\32\16\2\u0092\u0093\b"+
		"\r\1\2\u0093\u0095\3\2\2\2\u0094\u008a\3\2\2\2\u0094\u008f\3\2\2\2\u0095"+
		"\u0098\3\2\2\2\u0096\u0094\3\2\2\2\u0096\u0097\3\2\2\2\u0097\31\3\2\2"+
		"\2\u0098\u0096\3\2\2\2\u0099\u009a\b\16\1\2\u009a\u009b\5\34\17\2\u009b"+
		"\u009c\b\16\1\2\u009c\u00a9\3\2\2\2\u009d\u009e\f\4\2\2\u009e\u009f\7"+
		"\16\2\2\u009f\u00a0\5\34\17\2\u00a0\u00a1\b\16\1\2\u00a1\u00a8\3\2\2\2"+
		"\u00a2\u00a3\f\3\2\2\u00a3\u00a4\7\17\2\2\u00a4\u00a5\5\34\17\2\u00a5"+
		"\u00a6\b\16\1\2\u00a6\u00a8\3\2\2\2\u00a7\u009d\3\2\2\2\u00a7\u00a2\3"+
		"\2\2\2\u00a8\u00ab\3\2\2\2\u00a9\u00a7\3\2\2\2\u00a9\u00aa\3\2\2\2\u00aa"+
		"\33\3\2\2\2\u00ab\u00a9\3\2\2\2\u00ac\u00ad\5\36\20\2\u00ad\u00ae\b\17"+
		"\1\2\u00ae\u00b8\3\2\2\2\u00af\u00b0\7\20\2\2\u00b0\u00b1\5\34\17\2\u00b1"+
		"\u00b2\b\17\1\2\u00b2\u00b8\3\2\2\2\u00b3\u00b4\7\r\2\2\u00b4\u00b5\5"+
		"\34\17\2\u00b5\u00b6\b\17\1\2\u00b6\u00b8\3\2\2\2\u00b7\u00ac\3\2\2\2"+
		"\u00b7\u00af\3\2\2\2\u00b7\u00b3\3\2\2\2\u00b8\35\3\2\2\2\u00b9\u00ba"+
		"\5\26\f\2\u00ba\u00bb\b\20\1\2\u00bb\37\3\2\2\2\u00bc\u00bd\b\21\1\2\u00bd"+
		"\u00be\5\"\22\2\u00be\u00bf\b\21\1\2\u00bf\u00c7\3\2\2\2\u00c0\u00c1\f"+
		"\3\2\2\u00c1\u00c2\7\21\2\2\u00c2\u00c3\5\"\22\2\u00c3\u00c4\b\21\1\2"+
		"\u00c4\u00c6\3\2\2\2\u00c5\u00c0\3\2\2\2\u00c6\u00c9\3\2\2\2\u00c7\u00c5"+
		"\3\2\2\2\u00c7\u00c8\3\2\2\2\u00c8!\3\2\2\2\u00c9\u00c7\3\2\2\2\u00ca"+
		"\u00cb\b\22\1\2\u00cb\u00cc\5$\23\2\u00cc\u00cd\b\22\1\2\u00cd\u00da\3"+
		"\2\2\2\u00ce\u00cf\f\4\2\2\u00cf\u00d0\7\22\2\2\u00d0\u00d1\5$\23\2\u00d1"+
		"\u00d2\b\22\1\2\u00d2\u00d9\3\2\2\2\u00d3\u00d4\f\3\2\2\u00d4\u00d5\7"+
		"\23\2\2\u00d5\u00d6\5$\23\2\u00d6\u00d7\b\22\1\2\u00d7\u00d9\3\2\2\2\u00d8"+
		"\u00ce\3\2\2\2\u00d8\u00d3\3\2\2\2\u00d9\u00dc\3\2\2\2\u00da\u00d8\3\2"+
		"\2\2\u00da\u00db\3\2\2\2\u00db#\3\2\2\2\u00dc\u00da\3\2\2\2\u00dd\u00de"+
		"\5\30\r\2\u00de\u00df\b\23\1\2\u00df%\3\2\2\2\u00e0\u00e1\7\27\2\2\u00e1"+
		"\u00f0\b\24\1\2\u00e2\u00e3\7\3\2\2\u00e3\u00f0\b\24\1\2\u00e4\u00e5\7"+
		"\4\2\2\u00e5\u00f0\b\24\1\2\u00e6\u00e7\7\b\2\2\u00e7\u00e8\5\22\n\2\u00e8"+
		"\u00e9\7\t\2\2\u00e9\u00ea\b\24\1\2\u00ea\u00f0\3\2\2\2\u00eb\u00ec\7"+
		"\6\2\2\u00ec\u00f0\b\24\1\2\u00ed\u00ee\7\5\2\2\u00ee\u00f0\b\24\1\2\u00ef"+
		"\u00e0\3\2\2\2\u00ef\u00e2\3\2\2\2\u00ef\u00e4\3\2\2\2\u00ef\u00e6\3\2"+
		"\2\2\u00ef\u00eb\3\2\2\2\u00ef\u00ed\3\2\2\2\u00f0\'\3\2\2\2\21\65AS]"+
		"s\u0081\u0094\u0096\u00a7\u00a9\u00b7\u00c7\u00d8\u00da\u00ef";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}