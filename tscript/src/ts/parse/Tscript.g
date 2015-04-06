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
  | ex=expressionStatement
    { $lval = $ex.lval; }
  | p=printStatement
    { $lval = $p.lval; }
  | b=blockStatement
    { $lval = $b.lval; }
  | em=emptyStatement
    { $lval = $em.lval; }
  | i=iterationStatement
    { $lval = $i.lval; }
  | ifs=ifStatement
    { $lval = $ifs.lval; }
  | br=breakStatement
    { $lval = $br.lval; }
  | c=continueStatement
    { $lval = $c.lval; }
  | t=throwStatement
    { $lval = $t.lval; }
  | ty=tryStatement
    { $lval = $ty.lval; }
  | r=returnStatement
    { $lval = $r.lval; }
  ;
  
blockStatement
  returns [ Statement lval ]
  : LBRACE RBRACE
    { $lval = buildBlockStatement(loc($start), null); }
  | LBRACE sl=statementList RBRACE
    { $lval = buildBlockStatement(loc($start), $sl.lval); }
  ;

emptyStatement
   returns [ Statement lval ]
   : SEMICOLON
   { $lval = buildEmptyStatement(loc($start)); }
   ;
   
iterationStatement
   returns [ Statement lval ]
   : WHILE LPAREN e=expression RPAREN s=statement
   { $lval = buildWhileStatement(loc($start), $e.lval, $s.lval); }
   ;
   
ifStatement
	 returns [Statement lval]
	 : IF LPAREN e=expression RPAREN s1=statement ELSE s2=statement
	 { $lval = buildIfStatement(loc($start), $e.lval, $s1.lval, $s2.lval); }
	 | IF LPAREN e=expression RPAREN s1=statement
	 { $lval = buildIfStatement(loc($start), $e.lval, $s1.lval, null); } 
	 ;

breakStatement
   returns [Statement lval]
   : BREAK SEMICOLON
   { $lval = buildBreakStatement(loc($start), null); }
   | BREAK IDENTIFIER SEMICOLON
   { $lval = buildBreakStatement(loc($start), $IDENTIFIER.text); }
   ;
    
continueStatement
   returns [Statement lval]
   : CONTINUE SEMICOLON
   { $lval = buildContinueStatement(loc($start), null); }
   | CONTINUE IDENTIFIER SEMICOLON
   { $lval = buildContinueStatement(loc($start), $IDENTIFIER.text); }
   ;

throwStatement
   returns [Statement lval]
   : THROW e=expression SEMICOLON
   { $lval = buildThrowStatement(loc($start), $e.lval); }
   ;

tryStatement
	 returns [Statement lval]
	 : TRY b=blockStatement c=catchStatement
	 { $lval = buildTryStatement(loc($start), $b.lval, $c.lval, null); }
	 | TRY b=blockStatement f=finallyStatement
	 { $lval = buildTryStatement(loc($start), $b.lval, null, $f.lval); }
	 | TRY b=blockStatement c=catchStatement f=finallyStatement
	 { $lval = buildTryStatement(loc($start), $b.lval, $c.lval, $f.lval); }
	 ;

catchStatement
	 returns [Statement lval]
	 : CATCH LPAREN IDENTIFIER RPAREN b=blockStatement
	 { $lval = buildCatchStatement(loc($start), $IDENTIFIER.text, $b.lval); }
	 ;
	 
finallyStatement
	 returns [Statement lval]
	 : FINALLY b=blockStatement
	 { $lval = buildFinallyStatement(loc($start), $b.lval);}
	 ;

returnStatement
	 returns [Statement lval]
	 : RETURN SEMICOLON
	 { $lval = buildReturnStatement(loc($start), null); }
	 | RETURN e=expression SEMICOLON
	 { $lval = buildReturnStatement(loc($start), $e.lval); }
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
  : c=callExpression
 	  { $lval = $c.lval; }
 	| n=newExpression
 	  { $lval = $n.lval; }
  ;

newExpression
 	returns [Expression lval]
	: m=memberExpression
	 	{ $lval = $m.lval; }
	| NEW n=newExpression
	  { $lval = buildNewExpression(loc($start), $n.lval, null); }
	; 

memberExpression
	returns [Expression lval]
	: p=primaryExpression
	 	{ $lval = $p.lval; }
	| f=functionExpression
	  { $lval = $f.lval; }
	| m=memberExpression POINT IDENTIFIER
	  { $lval = buildMemberExpression(loc($start), $m.lval, $IDENTIFIER.text); }
	| NEW m=memberExpression a=arguments
	  { $lval = buildNewExpression(loc($start), $m.lval, $a.lval); }
	;
	
functionExpression
  returns [Expression lval]
  : FUNCTION IDENTIFIER LPAREN fpl=formalParameterList RPAREN 
    LBRACE fb=functionBody RBRACE 
    { $lval = buildFunctionExpression(loc($start), $IDENTIFIER.text, 
    			$fpl.lval, $fb.lval); }
  | FUNCTION IDENTIFIER LPAREN RPAREN 
    LBRACE fb=functionBody RBRACE 
    { $lval = buildFunctionExpression(loc($start), $IDENTIFIER.text, 
    			null, $fb.lval); }
  | FUNCTION LPAREN fpl=formalParameterList RPAREN
    LBRACE fb=functionBody RBRACE 
    { $lval = buildFunctionExpression(loc($start), null, 
    			$fpl.lval, $fb.lval); }
  | FUNCTION LPAREN RPAREN
    LBRACE fb=functionBody RBRACE 
    { $lval = buildFunctionExpression(loc($start), null, 
    			null, $fb.lval); }	
  ;

formalParameterList
  returns [ List<String> lval ]
  : IDENTIFIER
    { $lval = new ArrayList<String>(); 
      $lval.add($IDENTIFIER.text); }
  | fList=formalParameterList COMMA IDENTIFIER
    { $fList.lval.add($IDENTIFIER.text);
      $lval = $fList.lval; }
  ;
  
functionBody
  returns [List<Statement> lval]
  : sl = statementList
  	{ $lval = $sl.lval; }
  |
    { $lval = null; }
  ;

callExpression
	returns [Expression lval]
	: m=memberExpression a=arguments
	  { $lval = buildCallExpression(loc($start), $m.lval, $a.lval, null); }
	| c=callExpression a=arguments
	  { $lval = buildCallExpression(loc($start), $c.lval, $a.lval, null); }
	| c=callExpression POINT IDENTIFIER
	  { $lval = buildCallExpression(loc($start), $c.lval, null, $IDENTIFIER.text); }
	;

arguments
	returns [List<Expression> lval]
  : LPAREN RPAREN
    { $lval = null; }
  | LPAREN aL=argumentList RPAREN
    { $lval = $aL.lval; }
  ;
  
argumentList
	returns [List<Expression> lval]
	: a=assignmentExpression
	  { $lval = new ArrayList<Expression>();
	    $lval.add($a.lval); }
	| aL=argumentList COMMA a=assignmentExpression
	  { $aL.lval.add($a.lval);
	    $lval = $aL.lval; }
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
  : THIS
  	{ $lval = buildThisExpression(loc($start)); }
  | IDENTIFIER
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
THIS : 'this';

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
POINT : [.];

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
ELSE : 'else';
FUNCTION : 'function';
RETURN : 'return';
NEW : 'new';
IDENTIFIER : IdentifierCharacters;

// skip whitespace and comments

WhiteSpace : SpaceTokens+ -> skip;

