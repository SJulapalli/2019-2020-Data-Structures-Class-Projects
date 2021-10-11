package Generic;

class Node<T>{
	T data;
	Node<T> next;
	public Node(T data, Node<T> next) {
		this.data = data;
		this.next = next;
	}
	
	public String toString() {
		return data.toString();
	}
}

public class LinkedList<T> {
	Node<T> front;
	int numNodes;
	
	public LinkedList(Node<T> front){
		this.front = front;
		numNodes = countNodes();
	}

	private int countNodes(){
		int count = 0;
		Node<T> temp = front;
		while(temp != null)
		{
			count++;
			temp = temp.next;
		}
		return count;
	}
	
	/**
	 * If front == null sets front to newNode.
	 * Otherwise, sets the variable 'next' for newNode to front
	 * @param newNode
	 */
	public void addToFront(Node<T> newNode) {
		if (front == null) front = newNode;
		else newNode.next = front;
	}
	
	/**
	 * Removes the Node 'front' from the list.
	 * Does nothing if front == null.
	 */
	public void removeHead() {
		if (front == null) {}
		else front = front.next;
	}
	
	/**
	 * Finds the node at the passed index; Throws a RuntimeException if Node temp == null;
	 * @param index
	 * @return the T variable 'data' stored by the node
	 */
	public T elementAt(int index) {
		Node<T> temp = front;
		int counter = 0;
		
		while (counter < index) {
				if (temp == null) throw new IllegalArgumentException("Index is out of bounds");
				
				temp = temp.next;
		}
		
		return temp.data;
	}
	
	/**
	 * 
	 * @param data
	 * @return
	 */
	public boolean contains(T data) {
		
		for (Node<T> i = front; i != null; i = i.next) {
			if (i.data.equals(data)) return true;
		}
		
		return false;
	}
	
	public int indexOf(T data) {
		if (contains(data)) {
			int i = 0;
			for (Node<T> temp = front; temp != null; temp = temp.next) {
				++i;
				if (temp.data.equals(data)) return i;
			}
		}
		return -1;
	}
	
	public void add(Node<T> newNode, T target) {
		Node<T> temp = front;
		for (int i = 0; i < indexOf(target); i++) {
			temp = temp.next;
		}
		newNode.next = temp.next;
		temp.next = newNode;
	}
	
	public void removeAfter(T target) {
		Node<T> temp = front;
		for (int i = 0; i < indexOf(target); i++) {
			temp = temp.next;
		}
		temp.next = temp.next.next;
	}
	
	public Node<T> last() {
		Node<T> temp = front;
		while (temp != null) {
			temp = temp.next;
		}
		return temp;
	}
	
	public void add(Node<T> newNode) {
		last().next = newNode;
	}
	
	public void removeLast() {
		Node<T> temp = front;
		while (temp.next.next != null) {
			temp = temp.next;
		}
		temp.next = null;
	}
	
	public String toString()
	{
		if(front == null) return null;
		
		String str = "[" + front.toString();
		Node<T> temp = front;
		while(temp.next != null)
		{
			temp = temp.next;
			str += "," + temp.toString();
		}
		return str + "]";
	}
}
