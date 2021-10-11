package Circular;
/**
 * Unit 2 Linked List Coding Task
 * 	Complete the two methods below. Submit ONLY this file.
 * 
 * @name Suhas Julapalli
 * @period 9
 * @date 11/13/2020
 */
public class CLLHelper {
	
	/**
	 * Deletes all nodes with data that is less than target 
	 * 		from a CLL as referenced by tail. 
	 * @param target, a Comparable dataType value, not null
	 * @param tail, the tail Node of a circular linked list
	 * @return the tail reference to a circular linked list with 
	 * 			all Nodes with data of greater or equal value to target, or null
	 */
	public static <T extends Comparable<T>> 
		Node<T> removeLessThan(T target, Node<T> tail) {
		
		Node<T> temp = tail;
		
		if (temp.next.data.compareTo(target) < 0) {
			temp.next = temp.next.next;
			temp = temp.next;
		}
		
		while (!temp.equals(tail)) {
			if (temp.next.data.compareTo(target) < 0) {
				temp.next = temp.next.next;
			}
			temp = temp.next;
		}
		
		return tail;
	}

	/** 
	 * Deletes the first occurrence of item from a CLL
	 * @param item to be removed, is not null.
	 * @param rear, a reference to the last node
	 * @return a reference to the rear of the resulting CLL
	 * If item is not in the list, return the original CLL
	 */
	public static <T extends Comparable<T>> 
		Node<T> delete(T item, Node<T> rear) {
		
		Node<T> temp = rear;
		
		if (temp.next.data.equals(item)) {
			temp.next = temp.next.next;
			return rear;
		}
		
		temp = temp.next;
		
		while (!temp.equals(rear)) {
			if (temp.next.data.equals(item)) {
				temp.next = temp.next.next;
			}
			
			temp = temp.next;
		}
		
		return rear;
	}
}
