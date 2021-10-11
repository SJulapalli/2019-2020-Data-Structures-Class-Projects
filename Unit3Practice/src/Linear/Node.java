package Linear;

public class Node {
	int data;
	double decimals;
	String letters;
	Node next;

	public Node() {
		data = 0;
		decimals = 0.0;
		letters = new String();
		next = null;
	}
	
	public Node(int data, double decimals, String letters, Node next) {
		this.data = data;
		this.decimals = decimals;
		this.letters = letters;
		this.next = next;
	}
}