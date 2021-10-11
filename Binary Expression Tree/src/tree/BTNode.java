/*
 * Name: Suhas Julapalli
 * Period: 3
 * Class: @CS - Datastructures
 * Date: 1/13/2021
 */

package tree;

public class BTNode<T> {
	T data;
	BTNode<T> left;
	BTNode<T> right;
	
	BTNode (T data, BTNode<T> left, BTNode<T> right) {
		this.data = data;
		this.left = left;
		this.right = right;
	}
	
	public int getHeight() {
		if (left == null && right == null)
			return 0;
		if (left == null)
			return 1 + right.getHeight();
		if (right == null)
			return 1 + left.getHeight();
		return 1 + Math.max(right.getHeight(), left.getHeight());
	}
	
	public boolean search(BTNode<T> root, T target) {
		if (root == null)
			return false;
		if (target.equals(root.data))
			return true;
		
		return search(root.left, target) || search(root.right, target);
	}
	
	/*
	 * Returns a Binary Expression Tree representation of the passed expression
	 * 
	 * Throws an IllegalArgumentException if the passed String is null
	 * Thrown an ArithmeticException if the passed expression contains a divide by zero
	 */
	public static BTNode<String> buildTree(String infix) throws Exception {		
		String prec0 = "+-";
		String prec1 = "*/%";
		
		if (infix == null) throw new IllegalArgumentException("Cannot convert a null String to a Binary Tree");
		if (infix.contains("/0")) throw new ArithmeticException("Entered expression contains a divide by zero");
		
		if (infix.contains("+") || infix.contains("-")) {
			for (int i = infix.length() - 2; i > 0; i--) {
				if (prec0.contains(infix.substring(i, i+1))) {
					return new BTNode<String>(infix.substring(i, i+1),
									buildTree(infix.substring(0, i)),
									buildTree(infix.substring(i+1)));
				}
			}
		} else if (infix.contains("*") || infix.contains("/") || infix.contains("%")) {
			for (int i = infix.length() - 2; i > 0; i--) {
				if (prec1.contains(infix.substring(i, i+1))) {
					return new BTNode<String>(infix.substring(i, i+1),
									buildTree(infix.substring(0, i)),
									buildTree(infix.substring(i+1)));
				}
			}
		} else {
			return new BTNode<String>(infix, null, null);
		}
		return new BTNode<String>(infix, null, null);
	}

	/*
	 * Returns the Binary Expression Tree converted to an infix String.
	 * 
	 * Throws an IllegalArgumentException if the passed tree is null
	 */
	public static String toInfix(BTNode<String> tree) throws Exception {
		if (tree == null) throw new IllegalArgumentException("Cannot convert a null Binary Tree");

		if (tree.left != null) 
			return toInfix(tree.left) + tree.data + toInfix(tree.right);
		else return tree.data;
	}
	
	/*
	 * Returns the Binary Expression Tree converted to a postfix String
	 * 
	 * Throws an IllegalArgumentException if the passed tree is null
	 */
	public static String toPostfix(BTNode<String> tree) throws Exception {
		String infix = toInfix(tree);
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

	/*
	 * Returns the Binary Expression Tree converted to a prefix String
	 * 
	 * Throws an IllegalArgumentException if the passed tree is null
	 */
	public static String toPrefix(BTNode<String> tree) throws Exception {
		String infix = toInfix(tree);
		String reversedInfix = "";
		String reversedPostfix = "";
		String prefix = "";
		BTNode<String> reversedInfixTree;
		
		for (int i = infix.length() - 1; i > -1; i--) {
			reversedInfix += infix.charAt(i);
		}
		
		reversedInfixTree = buildTree(reversedInfix);
		
		reversedPostfix = toPostfix(reversedInfixTree);
		
		for (int i = infix.length() - 1; i > -1; i--) {
			prefix += reversedPostfix.charAt(i);
		}
		
		return prefix;
	}
	
	/*
	 * Returns a double evaluation of the passed Binary Expression Tree.
	 * 
	 * Throws an IllegalArgumentException if the passed tree is null
	 * Throws an ArithmeticException if the tree contains a divide by zero
	 */
	public static double evaluate(BTNode<String> tree) throws Exception {
		if (tree == null) throw new IllegalArgumentException("Cannot evaluate a null Binary Tree");
		
		if (tree.data.equals("*")) {
			return evaluate(tree.left) * evaluate(tree.right);
		} else if (tree.data.equals("/")) {
			if (evaluate(tree.right) == 0.0)
				throw new ArithmeticException("Cannot evaluate divide by zero");
			else return evaluate(tree.left) / evaluate(tree.right);
		} else if (tree.data.equals("%")) {
			return evaluate(tree.left) % evaluate(tree.right);
		} else if (tree.data.equals("+")) {
			return evaluate(tree.left) + evaluate(tree.right);
		} else if (tree.data.equals("-")) {
			return evaluate(tree.left) - evaluate(tree.right);
		} else {
			return Integer.parseInt(tree.data);
		}
	}
	
	public static void main(String[] args) throws Exception {
		String testVar = "1+1*4+23/12*104987";
		System.out.println("testVar: " + testVar);
		System.out.println("Infix: " + toInfix(buildTree(testVar)));
		System.out.println("Postfix: " + toPostfix(buildTree(testVar)));
		System.out.println("Prefix: " + toPrefix(buildTree(testVar)));
		System.out.println("Evaluate: " + evaluate(buildTree(testVar)));
	}
}