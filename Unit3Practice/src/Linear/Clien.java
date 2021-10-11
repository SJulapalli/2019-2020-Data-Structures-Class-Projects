package Linear;

public class Clien {

	public static void main(String[] args) {
		Node one = new Node();
		Node two = new Node(5, Math.PI, "adcdefg", one);
		
		System.out.println(one);
		System.out.println(two);
		System.out.println(one.next);
		System.out.println(two.next);
	}
	
}