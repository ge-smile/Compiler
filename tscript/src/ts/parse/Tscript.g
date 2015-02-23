/
// an ANTLR parser specification for a Tscript subset
//

grammar Tscript;

@header {
  package ts.parse;
  import ts.Location;
  import ts.tree.*;
  import static ts.parse.TreeBuilder.*;
  import java.util.List;
  import java.util.ArrayList;
}

@members {
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
}

// grammar proper
program
  : sl=statementList EOF
    { semanticValue = $sl.lval; }
  ;

statementList
  returns [ List<Statement> lval ]
  : // empty rule
    { $lval = new ArrayList<Statement>(); }
  | sl=statementList s=statement
    { $sl.lval.add($s.lval);
      $lval = $sl.lval; }
  ;

statement
  returns [ Statement lval ]
  : v=varStatement
    { $lval = $v.lval; }
  | e=expressionStatement
    { $lval = $e.lval; }
  | p=printStatement
    { $lval = $p.lval; }
  | b=block
    { $lval = $b.lval; }
  | e=emptyStatement
    { $lval = $e.lval; }
  | i=iterationStatement
    { $lval = $i.lval; }
  | if=ifStatement
    { $lval = $if.lval; }
  | br=breakStatement
    { $lval = $br.lval; }
  | c=continueStatement
    { $lval = $c.lval; }
  ｜ t=throwStatement
    { $lval = $t.lval; }
  | try=tryStatement
    { $lval = $try.lval; }
  ;
  
block
  returns [ Statement lval ]
  : LBRACE RBRACE
    { $lval = buildBlockStatement(loc($start), null); }
  | LBRACE s=statementList RBRACE
    { $lval = buildBlockStatement(loc($start), $s.lval); }
  ;

emptyStatement
   returns [ Statement lval ]
   : SEMICOLON
   { $lval = buildEmptyStatement(loc($start)); }
   ;
   
iterationStatement
   returns [ Statement lval ]
   : WHILE LPAREN e=expression RPAREN
   { $lval = buildWhileStatement(loc($start)); }
   ;
   
ifStatement
	 returns [Statement lval]
	 : IF LPAREN e=expression RPAREN s1=statement else s2=statement
	 { $lval = buildifStatement(loc($start), s1, s2); }
	 | IF LPAREN e=expression RPAREN s1=statement
	 { $lval = buildifStatement(loc($start), s1, null); } 
	 ;

breakStatement
   returns [Statement lval]
   : BREAK SEMICOLON
   { $lval = buildBreakStatement(loc($start), null); }
   | BREAK i=identifier SEMICOLON
   { $lval = buildBreakStatement(loc($start),i); }
   ;
    
continueStatement
   returns [Statement lval]
   : CONTINUE SEMICOLON
   { $lval = buildContinueStatement(loc($start), null); }
   | CONTINUE i=identifier SEMICOLON
   { $lval = buildContinueStatement(loc($start), i); }
   ;

throwStatement
   returns [Statement lval]
   : THROW e=expression SEMICOLON
   { $lval = buildThrowStatement(loc($start), e); }
   ;
   
tryStatement
   returns [Statement lval]
   : TRY b=block CATCH
   { $lval = ; }
   | TRY b=block FINALLY
   { $lval = ; }
   | TRY b=block CATCH FINALLY
   { $lval = ; }
   ;

varStatement
  returns [ Statement lval ]
  : VAR v=variableDeclarationList SEMICOLON
    { $lval = buildVarStatement(loc($start), $v.lval); }
  ;

variableDeclarationList
  returns [ List<Expression> lval ]
  : v=variableDeclaration
    { $lval = new ArrayList<Expression>(); 
      $lval.add($v.lval); }
  | vlist=variableDeclarationList COMMA v=variableDeclaration
    { $vlist.lval.add($v.lval);
      $lval = $vlist.lval; }
  ;
  
variableDeclaration
  returns [ Expression lval ]
  : IDENTIFIER
    { $lval = buildVarDeclaration(loc($start), $IDENTIFIER.text, null); }
  | IDENTIFIER EQUAL a=assignmentExpression
    { $lval = buildVarDeclaration(loc($start), $IDENTIFIER.text,
              buildBinaryOperator(loc($start), Binop.ASSIGN,
              buildIdentifier(loc($start), $IDENTIFIER.text), $a.lval));}
  ;
  
expressionStatement
  returns [ Statement lval ]
  : e=expression SEMICOLON
    { $lval = buildExpressionStatement(loc($start), $e.lval); }
  ;

printStatement
  returns [ Statement lval ]
  : PRINT e=expression SEMICOLON
    { $lval = buildPrintStatement(loc($start), $e.lval); }
  ;

expression
  returns [ Expression lval ]
  : a=assignmentExpression
    { $lval = $a.lval; }
  | expression COMMA a=assignmentExpression
    { $lval = $a.lval; }
  ;

assignmentExpression
  returns [ Expression lval ]
  : a=additiveExpression
    { $lval = $a.lval; }
  | l=leftHandSideExpression EQUAL r=assignmentExpression
    { checkAssignmentDestination(loc($start), $l.lval);
      $lval = buildBinaryOperator(loc($start), Binop.ASSIGN,
        $l.lval, $r.lval); }
  | e=equalityExpression
    { $lval = $e.lval; }
  ;
  
leftHandSideExpression
  returns [Expression lval]
  : p=primaryExpression
 		{ $lval = $p.lval; }
  ;
	
additiveExpression
  returns [ Expression lval ]
  : m=multiplicativeExpression
    { $lval = $m.lval; }
  | l=additiveExpression PLUS r=multiplicativeExpression
    { $lval = buildBinaryOperator(loc($start), Binop.ADD,
        $l.lval, $r.lval); }
  | l=additiveExpression MINUS r=multiplicativeExpression
    { $lval = buildBinaryOperator(loc($start), Binop.MINUS,
        $l.lval, $r.lval); }     
  ;

multiplicativeExpression
  returns [ Expression lval ]
  : u=unaryExpression
    { $lval = $u.lval; }
  | l=multiplicativeExpression ASTERISK u=unaryExpression
    { $lval = buildBinaryOperator(loc($start), Binop.MULTIPLY,
      $l.lval, $u.lval); }
  | l=multiplicativeExpression SLASH u=unaryExpression
    { $lval = buildBinaryOperator(loc($start), Binop.DIVIDE,
      $l.lval, $u.lval); }
  ;
  
unaryExpression
  returns [Expression lval]
  : p=postfixExpression
 		{ $lval = $p.lval; }
  | NOT u=unaryExpression 
  	{ $lval = buildUnaryOperator(loc($start), Unop.NOT, 
  	  $u.lval); }
  | MINUS u=unaryExpression 
  	{ $lval = buildUnaryOperator(loc($start), Unop.MINUS, 
  	  $u.lval); }	  
  ;

postfixExpression
  returns [Expression lval]
  : l=leftHandSideExpression
 		{ $lval = $l.lval; }
  ;

equalityExpression
	returns [ Expression lval ]
	: r=relationalExpression
		{ $lval = $r.lval; }
	| l=equalityExpression EQUALITY r=relationalExpression
		{ $lval = buildBinaryOperator(loc($start), Binop.EQUALITY,
		  $l.lval, $r.lval); }
	; 

relationalExpression
  returns [Expression lval]
  : s=shiftExpression
  	{ $lval = $s.lval; }
  |r=relationalExpression SMALLER s=shiftExpression
		{ $lval = buildBinaryOperator(loc($start), Binop.SMALLER,
		  $r.lval, $s.lval); }
  | r=relationalExpression LARGER s=shiftExpression
		{ $lval = buildBinaryOperator(loc($start), Binop.LARGER,
		  $r.lval, $s.lval); }
  ;

shiftExpression
	returns [ Expression lval ]
	: a=additiveExpression
		{ $lval = $a.lval; }
	;
 
primaryExpression
  returns [ Expression lval ]
  : IDENTIFIER
    { $lval = buildIdentifier(loc($start), $IDENTIFIER.text); }
  | NUMERIC_LITERAL
    { $lval = buildNumericLiteral(loc($start), $NUMERIC_LITERAL.text); }
  | STRING_LITERAL
    { $lval = buildStringLiteral(loc($start), $STRING_LITERAL.text);}
  | LPAREN e=expression RPAREN
    { $lval = $e.lval; }
  | NULLL_LITERAL
  	{ $lval = buildNullLiteral(loc($start)); }
  | BOOLEANL_LITERAL
  	{ $lval = buildBooleanLiteral(loc($start), $BOOLEANL_LITERAL.text); }
  ; 

// fragments to support the lexer rules

fragment IdentifierCharacters : [a-zA-Z_$] [a-zA-Z0-9_$]*; 

fragment SpaceTokens : SpaceChars | LineTerminator | EndOfLineComment;

fragment SpaceChars : ' ' | '\t' | '\f';

fragment EndOfLineComment : '//' ( ~[\n\r] )* (LineTerminator | EOF);

fragment LineTerminator : '\r' '\n' | '\r' | '\n';

// Numeric Literal
fragment DecimalDigit : [0-9];

fragment NonZeroDigit : [1-9];

fragment ExponentPart : ExponentIndicator SignedInteger;

fragment ExponentIndicator : [eE];

fragment SignedInteger : DecimalDigits
                       | [+] DecimalDigits
                       | [-] DecimalDigits;

fragment HexIntegerLiteral : [0][xX] HexDigit+;

fragment HexDigit : [0-9a-fA-F];

fragment DecimalIntegerLiteral : [0] | (NonZeroDigit DecimalDigits*);

fragment DecimalDigits : DecimalDigit | (DecimalDigit DecimalDigits);

fragment DecimalLiteral: DecimalIntegerLiteral[.] DecimalDigits* ExponentPart* 
						         	 | [.]DecimalDigits ExponentPart*
							         | DecimalIntegerLiteral ExponentPart*;
							         
// String Literal
fragment DoubleStringCharacters : DoubleStringCharacter DoubleStringCharacters*;

fragment SingleStringCharacters : SingleStringCharacter SingleStringCharacters*;

fragment DoubleStringCharacter :  ~["\\\r\n]
                               | [\\] EscapeSequence
                               | LineContinuation;

fragment SingleStringCharacter :  ~['\\\r\n]
                               | [\\] EscapeSequence
                               | LineContinuation;
                               

fragment LineContinuation : [\\] LineTerminator;

fragment EscapeSequence : CharacterEscapeSequence | [0] | HexEscapeSequence
                        | UnicodeEscapeSequence;

fragment CharacterEscapeSequence : SingleEscapeCharacter | NonEscapeCharacter;

fragment SingleEscapeCharacter : ['"\\bfnrtv];

fragment NonEscapeCharacter : ~['"\\bfnrtv0-9xu\r\n];

fragment EscapeCharacter : SingleEscapeCharacter | DecimalDigit | [x] | [u];

fragment HexEscapeSequence : [x]HexDigit HexDigit;

fragment UnicodeEscapeSequence : [u]HexDigit HexDigit HexDigit HexDigit;

// lexer rules
//   keywords must appear before IDENTIFIER

// cannot have a leading 0 unless the literal is just 0
							         
NUMERIC_LITERAL : DecimalLiteral | HexIntegerLiteral;

STRING_LITERAL : ["]DoubleStringCharacter*["]
               | [']SingleStringCharacters*['];

BOOLEANL_LITERAL: 'true'|'false';
NULLL_LITERAL: 'null';
NaN_LITERAL: 'NaN';

LPAREN : [(];
RPAREN : [)];
SEMICOLON : [;];
EQUAL : [=];
PLUS : [+];
MINUS : [-];
ASTERISK : [*];
SLASH : [/];
NOT : [!];
EQUALITY : [=][=];
SMALLER : [<];
LARGER : [>];
COMMA : [,];
LBRACE : [{];
RBRACE : [}];

// keywords start here
PRINT : 'print';
VAR : 'var';
TRY : 'try';
BREAK : 'break';
CONTINUE : 'continue';
CATCH : 'catch';
FINALLY : 'finally';
THROW : 'throw';
IF : 'if';
WHILE : 'while';

IDENTIFIER : IdentifierCharacters;

// skip whitespace and comments

WhiteSpace : SpaceTokens+ -> skip;

