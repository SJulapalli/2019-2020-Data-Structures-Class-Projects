package tree;


public class RBTNode<T> {
	T data;
	RBTNode<T> left;
	RBTNode<T> right;
	
	RBTNode (T data, RBTNode<T> left, RBTNode<T> right) {
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
	
	public boolean search(RBTNode<T> root, T target) {
		if (root == null)
			return false;
		if (target.equals(root.data))
			return true;
		
		return search(root.left, target) || search(root.right, target);
	}
	
	public static RBTNode<String> buildTree(String infix) { //needs more work
		if (infix.indexOf("*") != -1)
			return new RBTNode<String>("*",
					buildTree(infix.substring(0, infix.indexOf("*"))),
					buildTree(infix.substring(infix.indexOf("*") + 1)));
		else if (infix.indexOf("/") != -1)
			return new RBTNode<String>("/",
					buildTree(infix.substring(0, infix.indexOf("/"))),
					buildTree(infix.substring(infix.indexOf("/") + 1)));
		else if (infix.indexOf("%") != -1)
			return new RBTNode<String>("%",
					buildTree(infix.substring(0, infix.indexOf("%"))),
					buildTree(infix.substring(infix.indexOf("%") + 1)));
		else if (infix.indexOf("+") != -1)
			return new RBTNode<String>("+",
					buildTree(infix.substring(0,infix.indexOf("+"))),
					buildTree(infix.substring(infix.indexOf("+") + 1)));
		else if (infix.indexOf("-") != -1)
			return new RBTNode<String>("-",
					buildTree(infix.substring(0, infix.indexOf("-"))),
					buildTree(infix.substring(infix.indexOf("-") + 1)));
		else
			return new RBTNode<String>(infix, null, null);
	}
	//		for (int i = infix.length() - 1; i > 0; i--) {
	//			if (prec0.contains(infix.substring(i, i+1))) {
	//				return new BTNode<String>(infix.substring(i, i+1),
	//								buildTree(infix.substring(0, i)),
	//								buildTree(infix.substring(i)));
	//			} else if (prec1.contains(infix.substring(i, i+1))) {
	//				return new BTNode<String>(infix.substring(i, i+1),
	//						buildTree(infix.substring(0, i)),
	//						buildTree(infix.substring(i)));
	//			} else {
	//				return new BTNode<String>(infix, null, null);
	//			}
	//		}
	//		if (infix.indexOf("*") != -1)
	//			return new BTNode<String>("*",
	//					buildTree(infix.substring(0, infix.indexOf("*"))),
	//					buildTree(infix.substring(infix.indexOf("*") + 1)));
	//		else if (infix.indexOf("/") != -1)
	//			return new BTNode<String>("/",
	//					buildTree(infix.substring(0, infix.indexOf("/"))),
	//					buildTree(infix.substring(infix.indexOf("/") + 1)));
	//		else if (infix.indexOf("%") != -1)
	//			return new BTNode<String>("%",
	//					buildTree(infix.substring(0, infix.indexOf("%"))),
	//					buildTree(infix.substring(infix.indexOf("%") + 1)));
	//		else if (infix.indexOf("+") != -1)
	//			return new BTNode<String>("+",
	//					buildTree(infix.substring(0,infix.indexOf("+"))),
	//					buildTree(infix.substring(infix.indexOf("+") + 1)));
	//		else if (infix.indexOf("-") != -1)
	//			return new BTNode<String>("-",
	//					buildTree(infix.substring(0, infix.indexOf("-"))),
	//					buildTree(infix.substring(infix.indexOf("-") + 1)));
	//		else
	//			return new BTNode<String>(infix, null, null);
	//	if (infix.contains("+")) {
	//	return new RBTNode<String>("+", buildTree(infix.substring(0, infix.length()/2)), buildTree(infix.substring(infix.length()/2+1)));
	//} else {
	//	System.out.println(new RBTNode<String>("a", null, null).data);
	//	return new RBTNode<String>("a", null, null);
	//}
	//if (infix.contains("+") || infix.contains("-")) {
	//	for (int i = infix.length() - 2; i > -1; i--) {
	//		if (infix.substring(i, i+1).equals("+") ||
	//			infix.substring(i, i+1).contentEquals("-")) {
	//			
	//			return new RBTNode<String>(infix.substring(i, i+1),
	//					buildTree(infix.substring(0, i)),
	//					buildTree(infix.substring(i, infix.length())));
	//		}
	//	}
	//} else if (infix.contains("*") || infix.contains("/") || infix.contains("%")) {
	//	for (int i = infix.length() - 2; i > -1; i--) {
	//		if (infix.substring(i, i+1).equals("*") ||
	//			infix.substring(i, i+1).equals("/") ||
	//			infix.substring(i, i+1).equals("%")) {
	//			
	//			return new RBTNode<String>(infix.substring(i, i+1),
	//					buildTree(infix.substring(0, i)),
	//					buildTree(infix.substring(i)));
	//		}
	//	}
	//} else {return new RBTNode<String>(infix, null, null);}
	//return new RBTNode<String>(infix, null, null);
	//if (operators.indexOf(infix.charAt(infix.length() / 2)) != -1) {
	//	return new RBTNode<String>("" + infix.charAt(infix.length() / 2),
	//			buildTree(infix.substring(0, infix.indexOf(infix.charAt(infix.length() / 2)))),
	//			buildTree(infix.substring(infix.indexOf(infix.charAt(infix.length() / 2)) + 1)));
	//}
	//else return new RBTNode<String>(infix, null, null);
	
	
	public static String toInfix(RBTNode<String> tree) { //likely working
		if (tree.left != null) 
			return toInfix(tree.left) + tree.data + toInfix(tree.right);
		else return tree.data;
	}
	
	public static String toPostfix(RBTNode<String> tree) { //if infix works this will work 100%
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
	
	public static String toPrefix(RBTNode<String> tree) { //Will work once postfix is patched
		String infix = toInfix(tree);
		String reversedInfix = "";
		String reversedPostfix = "";
		String prefix = "";
		RBTNode<String> reversedInfixTree;
		
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
	
	public static void main(String[] args) {
		buildTree("a+a");
	}
}