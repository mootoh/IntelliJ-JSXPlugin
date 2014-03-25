package net.mootoh.intellij.JSXPlugin;

import com.intellij.lexer.FLexLexer;
import com.intellij.psi.tree.IElementType;
import net.mootoh.intellij.JSXPlugin.psi.JSXTypes;
import com.intellij.psi.TokenType;

%%

%class JSXLexer
%implements FlexLexer
%unicode
%function advance
%type IElementType
%eof{ return;
%eof}

CRLF= \n|\r|\r\n
WHITE_SPACE=[\ \t\f]
END_OF_LINE_COMMENT=("//")[^\r\n]*
SEPARATOR=[:=]

IMPORTKEY="import"
MODULE_CHARACTER=[^\n\r\f\\] | "\\"{CRLF} | "\\".

%state WAITING_VALUE

%%

<YYINITIAL> {END_OF_LINE_COMMENT}                           { yybegin(YYINITIAL); return JSXTypes.COMMENT; }

<YYINITIAL> {IMPORTKEY}                                     { yybegin(YYINITIAL); return JSXTypes.IMPORTKEY; }

<YYINITIAL> {SEPARATOR}                                     { yybegin(WAITING_VALUE); return JSXTypes.SEPARATOR; }

<WAITING_VALUE> {CRLF}                                     { yybegin(YYINITIAL); return JSXTypes.CRLF; }

<WAITING_VALUE> {WHITE_SPACE}+                              { yybegin(WAITING_VALUE); return JSXTypes.WHITE_SPACE; }

<YYINITIAL> {MODULE_CHARACTER}+                                { yybegin(YYINITIAL); return JSXTypes.MODULE_NAME; }

{CRLF}                                                     { yybegin(YYINITIAL); return JSXTypes.CRLF; }

{WHITE_SPACE}+                                              { yybegin(YYINITIAL); return JSXTypes.WHITE_SPACE; }

.                                                           { return JSXTypes.BAD_CHARACTER; }
