package jlox;

enum TokenType
{
	// Single-character tokens.
	L_PAREN,
	R_PAREN,
	L_BRACE,
	R_BRACE,
	COMMA,
	PERIOD,
	PLUS,
	MINUS,
	STAR,
	SLASH,
	SEMICOLON,
	
	// One or two character tokens
	BANG,
	BANG_EQUAL,
	EQUAL,
	EQUAL_EQUAL,
	GREATER,
	GREATER_EQUAL,
	LESS,
	LESS_EQUAL,
	
	// Literals
	IDENTIFIER,
	STRING,
	NUMBER,
	
	// Keywords
	AND,
	CLASS,
	ELSE,
	FALSE,
	FUN,
	FOR,
	IF,
	NIL,
	OR,
	PRINT,
	RETURN,
	SUPER,
	THIS,
	TRUE,
	VAR,
	WHILE,
	
	EOF
}