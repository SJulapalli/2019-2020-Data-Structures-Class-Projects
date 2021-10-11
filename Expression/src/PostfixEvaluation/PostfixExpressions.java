package PostfixEvaluation;

public class PostfixExpressions {

	/**
	 * Creates a postfix expression based on an infix expression
	 * @param infix a mathematical expression
	 * PRECONDITION: Numeric values are single digits and Variables are single letters
	 * @return a postfix expression
	 * 
	 * Examples:
	 * a+b 		-> ab+
	 * (a+b)*c 	-> ab+c*
	 * 3+a-b+5 	-> 3a+b-5+
	 * 2+3*4 	-> 234*+
	 * (2-3+a)*(A+B*x)	-> 23-a+ABx*+*
	 */
	public static String toPostfix(String infix) {
		String postfix = "";
		String precedence1 = "*/%";
		String precedence2 = "+-";
		String temp = "";
		boolean stop = false;
		Stack<String> stack = new Stack<String>();
		
		for (int i = 0; i < infix.length(); i++) {
			temp = infix.substring(i, i+1);
			if (precedence1.indexOf(temp) != -1) {
				if (stack.peek() == null) stop = true;
				while (!stop) {
					if (precedence1.indexOf(stack.peek()) != -1)
						postfix += stack.pop();
					if (stack.peek() == null)
						stop = true;
					else if (precedence2.indexOf(stack.peek()) != -1)
						stop = true;
				}
				stack.push(temp);
				stop = false;
			} else if (precedence2.indexOf(temp) != -1) {
					while (stack.peek() != null)
						postfix += stack.pop();
					stack.push(temp);
			} else {
				postfix += temp;
			}
		}
		while (stack.peek() != null)
			postfix += stack.pop();
		
		return postfix;
	}
	
	public static String toPrefix(String infix) {
		String reversedInfix = "";
		String reversedPostfix = "";
		String prefix = "";
		
		for (int i = infix.length() - 1; i > -1; i--) {
			reversedInfix += infix.charAt(i);
		}
		
		reversedPostfix = toPostfix(reversedInfix);
		
		for (int i = infix.length() - 1; i > -1; i--) {
			prefix += reversedPostfix.charAt(i);
		}
		
		return prefix;
	}
	
	/**
	 * Implement a method to evaluate a postfix expression. 
	 * The expression is a string which contains either single digit 
	 * numbers (09), or the operators +, , *, /, and %, and nothing else. 
	 * 
	 * @param postfix A postfix expression
	 * PRECONDITION: the postfix expression contains single-digit numbers (0-9), or
	 * 		the operators +, -, *, /, %, and nothing else.
	 * @return the value of the expression evaluated as a double
	 * 
	 * Examples:
	 * 	2		-> 2.0
	 * 	23+		-> 5.0
	 * 	234+*	-> 14.0
	 * 	234-*5/	-> -0.4
	 */
	public static double evaluatePostfix(String postfix) {
		return 0.0; //quiets compiler
	}
	
	public static void main(String[] args) {
		System.out.println("Testing toPostfix Method");
		System.out.println("1+23/48*7-4 ->");
		System.out.println("+1-/23*4874");
		System.out.println(toPrefix("1+23/48*7-4"));
//		System.out.printf("(a+b)*c -> ab+c* :: %b\n", toPostfix("(a+b)*c").equals("ab+c*"));
//		System.out.printf("3+a-b+5 -> 3a+b-5+ :: %b\n", toPostfix("3+a-b+5").equals("3a+b-5+"));
//		System.out.printf("2+3*4 -> 234*+ :: %b\n", toPostfix("2+3*4").equals("234*+"));
//		System.out.printf("(2-3+a)*(A+B*x) -> 23-a+ABx*+* :: %b\n", toPostfix("(2-3+a)*(A+B*x)").equals("23-a+ABx*+*"));
//		//Create additional test cases
//		
//		System.out.println();
//		System.out.println("Testing evaluatePostfix");
//		System.out.println("2 evaluates to 2.0, It became " + evaluatePostfix("2"));
//		System.out.println("23+ evaluates to 5.0, It became " + evaluatePostfix("23+"));
//		System.out.println("234+* evaluates to 14.0, It became " + evaluatePostfix("234+*"));
//		System.out.println("234-*5/ evaluates to -0.4, It became " + evaluatePostfix("234-*5/"));
		//Create additional test cases

	}

}
