package structures;

/**
 * A Binary Search Tree of WordNodes.
 * 
 * @author Suhas Julapalli
 * @date 2/19/2021
 * @period 3
 */
public class WordTree {
	
	public WordNode root;
	int numWords;
	
	public WordTree(){
		root = null;
		numWords = 0;
	}
	
	/**
	 * If word doesn't exist in this word tree, it should be inserted in
	 * 		the appropriate place based on Binary Search.  If words already
	 * 		exists in this tree, the quantity should be updated to reflect 
	 * 		the appropriate number of times word appears in the text
	 * @param word a word to be inserted into this Binary Search Tree
	 * @return the quantity, or number of times that word has been added to the list
	 */
	public int insertWord(String word) {
		//complete this method
		
		if (root == null) {
			root = new WordNode(word, null, null);
			System.out.println(root.word);
			return 1;
		} else {
			WordNode temp = root;
			if (temp.word.equals(word)) {
				temp.updateQuantity();
				return temp.getQuantity();
			} else if (word.compareTo(temp.word) < 0) {
				insertWordLeft(temp.left, word);
			} else {
				insertWordRight(temp.right, word);
			}
		}
		
		return 1; //quiets the compiler
	}
	
	private int insertWordLeft(WordNode left, String word) {
		if (left == null) {
			left = new WordNode(word, null, null);
			System.out.println(left.word);
			return 1;
		} else {
			WordNode temp = left;
			if (temp.word.equals(word)) {
				temp.updateQuantity();
				return temp.getQuantity();
			} else if (word.compareTo(temp.word) < 0) {
				insertWordLeft(temp.left, word);
			} else {
				insertWordRight(temp.right, word);
			}
		}
		return 1;
	}
	
	
	private int insertWordRight(WordNode right, String word) {
		if (right == null) {
			right = new WordNode(word, null, null);
			System.out.println(right.word);
			return 1;
		} else {
			WordNode temp = right;
			if (temp.word.equals(word)) {
				temp.updateQuantity();
				return temp.getQuantity();
			} else if (word.compareTo(temp.word) < 0) {
				insertWordLeft(temp.left, word);
			} else {
				insertWordRight(temp.right, word);
			}
		}
		return 1;
	}
	
	/**
	 * Performs a search in this word tree for the word.  Determines and returns
	 *      the depth of the word in the tree.  The root is at depth 0, a child of
	 *      the root is at depth 1, etc... If the word is not in this word tree, -1
	 *      is returned to reflect that the word does not exist in the tree.
	 * 
	 * @param word a word to be searched for in this tree
	 * @return the depth of the word in the tree, or -1 if word is not found.
	 */
	public int wordSearch(String word) {
		if (root.word.equals(word))
			return 0;
		else
			return wordSearch(word, root, 0); //quiets the compiler
	}

	private int wordSearch(String word, WordNode prev, int depth) {
		if (prev == null)
			return -1;
		else if (prev.word.equals(word))
			return depth++;
		else if (word.compareTo(prev.word) < 0)
			return wordSearch(word, prev.left, depth++);
		else
			return wordSearch(word, prev.left, depth++);
	}
}
