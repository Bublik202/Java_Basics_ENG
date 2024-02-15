package com.epam.rd.autotasks.arithmeticexpressions;

public class Expressions {

    public static Variable var(String name, int value) {       
        return new Variable(name, value);
    }

    public static Expression val(int value) {
    	Expression expression = new Expression() {
			
			@Override
			public String toExpressionString() {
				String str = String.valueOf(value);
				if(value < 0) {
					str = "(" + str + ")";
				}
				return str;
			}
			
			@Override
			public int evaluate() {			
				return value;
			}
		};
        return expression;
    }

    public static Expression sum(Expression... members){
    	Expression expression = new Expression() {
			
			@Override
			public String toExpressionString() {
				StringBuilder builder = new StringBuilder();				
				builder.append("(").append(members[0].toExpressionString());
				
				for (int i = 1; i < members.length; i++) {
					builder.append(" + ").append(members[i].toExpressionString());
				}
				
				builder.append(")");
				return builder.toString();
			}
			
			@Override
			public int evaluate() {
				int sum = 0;
				for (Expression expression : members) {
					sum += expression.evaluate();
				}
				return sum;
			}
		};
        return expression;
    }

    public static Expression product(Expression... members){
    	Expression expression = new Expression() {
			
			@Override
			public String toExpressionString() {
				StringBuilder builder = new StringBuilder();				
				builder.append("(").append(members[0].toExpressionString()).append(" * ");
				builder.append(members[1].toExpressionString());
				for (int i = 2; i < members.length; i++) {
					builder.append(" * ").append(members[i].toExpressionString());
				}
				builder.append(")");
				return builder.toString();
			}
			
			@Override
			public int evaluate() {
				int sum = 1;
				for (Expression expression : members) {
					sum *= expression.evaluate();
				}
				return sum;
			}
		};
        return expression;
    }

    public static Expression difference(Expression minuend, Expression subtrahend){
    	Expression expression = new Expression() {
			
			@Override
			public String toExpressionString() {
				return "(" + minuend.toExpressionString() + " - " + subtrahend.toExpressionString() + ")";
			}
			
			@Override
			public int evaluate() {
				return minuend.evaluate() - subtrahend.evaluate();
			}
		};
        return expression;
    }

    public static Expression fraction(Expression dividend, Expression divisor){
    	Expression expression = new Expression() {
			
			@Override
			public String toExpressionString() {
				return "(" + dividend.toExpressionString() + " / " + divisor.toExpressionString() + ")";
			}
			
			@Override
			public int evaluate() {
				return dividend.evaluate() / divisor.evaluate();
			}
		};
        return expression;
    }

}
