package jlox;

import jlox.Expr.Binary;
import jlox.Expr.Grouping;
import jlox.Expr.Literal;
import jlox.Expr.Unary;

// Prints in RPN
class AstPrinter implements Expr.Visitor<String>
{
	/* === USED FOR TESTING ===
	 * public static void main(String[] args) { Expr expression = new Expr.Binary (
	 * new Expr.Grouping(new Expr.Binary(new Expr.Literal(1), new
	 * Token(TokenType.PLUS, "+", null, 1), new Expr.Literal(2))), new
	 * Token(TokenType.STAR, "*", null, 1), new Expr.Grouping(new Expr.Binary(new
	 * Expr.Literal(4), new Token(TokenType.MINUS, "-", null, 1), new
	 * Expr.Literal(3))) );
	 * 
	 * System.out.println(new AstPrinter().print(expression)); }
	 */	
	
	String print(Expr expr)
	{
		return expr.accept(this);
	}

	@Override
	public String visitBinaryExpr(Binary expr)
	{
		return recursivePrint(expr.operator.lexeme, expr.left, expr.right);
	}

	@Override
	public String visitGroupingExpr(Grouping expr)
	{
		return recursivePrint("", expr.expression);
	}

	@Override
	public String visitLiteralExpr(Literal expr)
	{
		if (expr.value == null)
		{
			return "nil";
		}
		
		return recursivePrint(expr.value.toString());
	}

	@Override
	public String visitUnaryExpr(Unary expr)
	{
		return recursivePrint(expr.operator.lexeme, expr.right);
	}
	
	private String recursivePrint(String name, Expr... exprs)
	{
		StringBuilder builder = new StringBuilder();
		
		for (Expr expr : exprs)
		{
			builder.append(expr.accept(this));
		}
		
		if (name.length() > 0)
		{
			builder.append(name);
			builder.append(" ");
		}
		
		return builder.toString();
	}
}
