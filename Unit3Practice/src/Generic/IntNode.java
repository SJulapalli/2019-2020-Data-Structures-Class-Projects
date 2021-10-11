package Generic;
/**
 * Problem Set 2
 * Writing methods for an IntNode class
 * 
 * @author Suhas Julapalli
 * @date 11/8/2020
 * @period 3
 */
public class IntNode {
	  public int data;
      public IntNode next;
      public IntNode() {
    	  this.data = 0;
    	  this.next = null;
      }
      public IntNode(int data, IntNode next) {
          this.data = data; 
          this.next = next;
      }
      public String toString() 
      {
    	  if(next != null)
    		  return data + " " + next.toString();
          return data + "";
      }

      /** #1
       * Implement the addBefore method such that newItem will be added before 
       * target in the list starting with front.  If the target does not exist,
       * addBefore should return the original list, unchanged.
       * 
       * @param front, the first node in the linked list
       * @param target 
       * @param newItem item to be inserted
       * @return the front node of the updated linked list
       */
      public static IntNode addBefore(IntNode front, int target, int newItem) {
    	  /* COMPLETE THIS METHOD */
    	  
    	  if (numberOfOccurrences(front, target) == 0) return front;
    	  
    	  if (front.data == target) {
    		  IntNode pointer = new IntNode(front.data, front.next);
    		  front = new IntNode(newItem, pointer);
    		  return front;
    	  }

    	  for (IntNode pointer2 = front; !pointer2.next.equals(null); pointer2 = pointer2.next) {
    		  if (pointer2.next.data == target) {
    			  IntNode temp = new IntNode(newItem, pointer2.next);
    			  pointer2.next = temp;
    			  return front;
    		  }
    	  }
    	  
    	  return front;
      }

      /** #2
       * Implement the addBeforeLast method such that newItem will be added 
       * just before the last item in the linked list.  If the initial list is 
       * empty addBeforeLast should return null, returning the original list, unchanged.
       * 
       * @param front, the first node in the linked list
       * @param newItem
       * @return the front node of the updated linked list
       */
      public static IntNode addBeforeLast(IntNode front, int newItem) {
          /* COMPLETE THIS METHOD */
    	  if (front.equals(null)) return front;

    	  IntNode pointer = front;
    	  
    	  if (front.next.equals(null)) {
    		  pointer = new IntNode(front.data, front.next);
    		  front = new IntNode(newItem, pointer);
    		  return front;
    	  }
    	  
    	  while(!pointer.next.equals(null)) {
    		  if (pointer.next.next.equals(null)) {
    			  IntNode temp = new IntNode(newItem, pointer.next);
    			  pointer.next = temp;
    			  return front;
    		  }
    		  
    		  pointer = pointer.next;
    	  }
    	  
    	  return front;
      }
      
      /** #3
       * Implement the method numberOfOccurrances that will search 
       * a given linked list for a target int, and return the 
       * number of occurrences of the target
       * 
       * @param front, the first node in the linked list
       * @param target
       * @return the number of occurrences of the target
       */
      public static int numberOfOccurrences(IntNode front, int target) {
    	  /*COMPLETE THIS METHOD */
    	  int count = 0;
    	  
    	  for (IntNode pointer = front; !pointer.equals(null); pointer = pointer.next)
    		  if (pointer.data == target) ++count;
    	  
    	  return count; //quiets the compiler
      }
      
      /** #4
       * Implement the method deleteEveryOther to delete EVERY OTHER 
       * item from an integer linked list. 
       * For example:
       * 	before: 3->9->12->15->21
       * 	after: 3->12->21
       * 
       * 	before: 3->9->12->15
       * 	after: 3->12
       *
       * 	before: 3->9
       * 	after: 3
       * 	
       * 	before: 3
       * 	after: 3
       * 
       * If the list is empty, the method should do nothing.
       * @param front, the first node in the linked list
       */
      public static void deleteEveryOther(IntNode front) {
          /* COMPLETE THIS METHOD */ 	  
    	  IntNode pointer = front;
    	  IntNode temp = pointer;
    	  while(!temp.equals(null)) {
    		  pointer.next = pointer.next.next;
    		  temp = pointer.next;
    	  }
      }
      
      /** #5
       * Implement the method deleteAllOccurrences that will 
       * delete all occurrences of a given target int from a 
       * linked list, and return a pointer to the first node 
       * of the resulting linked list.
       * 
       * @param front, the first node in the linked list
       * @param target
       * @return the front node of the updated linked list
       */
      public static IntNode deleteAllOccurrences(IntNode front, int target) {
    	  /* COMPLETE THIS METHOD */
    	  while (front.data == target) front = front.next;

    	  for (IntNode pointer = front; !pointer.equals(null); pointer = pointer.next) {
    		  if (pointer.next.data == target && pointer.next.equals(null)) {
    			  pointer = null;
    			  return front;
    		  }
    		  
    		  if (pointer.next.data == target) pointer.next = pointer.next.next;
    	  }
    	  return front; //quiets the compiler
      }
      
      /** #6
       * Implement the method commonElements to find the common elements 
       * in two SORTED linked lists, and return the common elements in 
       * sorted order in a NEW linked list. The original linked lists 
       * should not be modified. 
       * For instance:
       *  	l1 = 3->9->12->15->21
       *  	l2 = 2->3->6->12->19
       *  should produce a new linked list:
       *  	3->12
       *  
       * You may assume that the original lists do not have any duplicate items.
       * Return null if no common elements exist.
       * 
       * @param frontL1, the first node in the linked list 1
       * @param frontL2, the first node in the linked list 2
       * @return A reference to the front node of a new linked list
       * 	which holds the common elements of L1 and L2 in sorted order.
       * 	Or null if no common elements exist.
       */
      public static IntNode commonElements(IntNode frontL1, IntNode frontL2) {
    	  /* COMPLETE THIS METHOD */
    	  IntNode returnNode = null;
    	  
    	  if (frontL1.equals(null) || frontL2.equals(null)) return null;
    	  
    	  for (IntNode front1 = frontL1; !front1.equals(null); front1 = front1.next) {
    		  for (IntNode front2 = frontL2; compare(front1, front2) >= 0; front2 = front2.next) {
    			  
    			  if (compare(front1, front2) == 0 && returnNode.equals(null))
    				  returnNode = new IntNode(front1.data, null);

    			  if (compare(front1, front2) == 0)
    				  returnNode.next = new IntNode(front1.data, front1);
    		  }
    		  
    	  }
    	  
    	  return returnNode; //quiets the compiler
      }
      
      public static int compare(IntNode node1, IntNode node2) {
    	  return node1.data - node2.data;
      }
}