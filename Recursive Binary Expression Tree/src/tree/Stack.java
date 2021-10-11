package tree;


import java.util.NoSuchElementException;

/**
 * This class implements a generic LIFO stack.
 * 
 *
 * @param <T> The type of objects to be stored in this stack.
 */
public class Stack<T> {
	
	/**
	 * Items in this stack, stored in a generic linked list.  
	 */
	private LinkedList<T> list;
	
	/**
	 * Initializes this stack to empty.
	 */
	public Stack() {
		list = new LinkedList<T>();
	}
	
	/**
	 *  Pushes a given item on this stack by adding to the top.
	 * 
	 * @param item Item to be pushed.
	 */
	public void push(T item) {
		if (list.size() == 0) {
			list.add(item);
		} else {
			list.insertAt(item,0);
		}	
	}
	
	/**
	 * Pops from this stack by deleting and returning the item at the top.
	 * 
	 * @return Popped item.
	 * @throws NoSuchElementException If this stack is empty.
	 */
	public T pop() {
		if (list.isEmpty()) {
			throw new NoSuchElementException();
		}
		return list.removeAt(0);
	}
	
	/**
	 * Returns the number of items in this stack.
	 * 
	 * @return Number of items in this stack.
	 */
	public int size() {
		return list.size();
	}
	
	/**
	 * Tells whether this stack is empty or not.
	 * 
	 * @return True if this stack is empty, false otherwise.
	 */
	public boolean isEmpty() {
		return list.isEmpty();
	}
	
	/**
	 * Empties this stack by removing all items.
	 */
	public void clear() {
		list.clear();
	}
	
	/**
	 * Returns the item at the top of this stack, without removal from list
	 * 
	 * @return Item at the top of this stack, null if stack is empty.
	 */
	public T peek() {
		if (list.size() == 0) {
			return null;
		}
		return list.getAt(0);
	}
}
