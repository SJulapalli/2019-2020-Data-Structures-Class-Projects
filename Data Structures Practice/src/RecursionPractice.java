public class RecursionPractice {

	/**
	 * This is an edited version of the original file
	 * Suhas Julapalli
	 * 9/16/20
	 * Period 3
	 */
	
	static String[] words1 = {"escape", "meat", "mix", "ultra", "interesting", "wakeful", "fumbling", "worm", "point", "third"};
	static String[] words2 = {"potato", "linen", "point", "wakeful", "ultra", "precede", "meat", "amuse", "third"};
	static int[] numbers = {3, 5, 7, 10, 14, 26, 32, 33, 34, 36, 39, 40, 41, 50, 52, 55, 57, 61, 63, 65, 67, 75, 77, 83, 95};
	
	public static void main(String[] args) {
		
		System.out.println("Factorial");
		for(int i = 0; i <= 20; i++)
		{
			if(i == 13)
				System.out.println("Due to Integer boundaries the following is incorrect");
			System.out.printf("%d! = %d\n", i, factorial(i));
		}
		System.out.println();
		
		System.out.println("Sequential Search");
		System.out.printf("%-12s%10s\n", "word", "found?");
		for(String s: words2)
			System.out.printf("%-12s%10s\n", s, contains(words1, s));
		System.out.println();
		
		System.out.println("Binary Search");
		System.out.printf("%-12s%10s\n", "number", "found?");
		for(int i = 1; i < 100; i +=  1 + (int)(Math.random() * 4))
			System.out.printf("%-12s%10s\n", i, contains(numbers, i));
		System.out.println();

		System.out.println("Fibonacci Sequence");
		for(int n = 1; n < 20; n++)
			System.out.printf("%d ", fibonacci(n));
	}

	/**
	 * Factorial using recursion
	 * @return the factorial of an integer n using recursion
	 */
	public static int factorial(int n)
	{
		if (n < 0) throw new IllegalArgumentException("Cannot take the factorial of a negative number");
		if (n > 12) throw new IllegalArgumentException("Factorials of integers greater than 12 cannot be represented by this method");
		
		if(n == 0 || n == 1) 
			return 1;
		return n * factorial(n-1);
	}

	/**
	 * Sequential Search.
	 * @return true if target is in array, false otherwise
	 */
	public static boolean contains(String[] array, String target)
	{
		int n = array.length - 1;
		
		return contains(array, target, n);
	}
	
	/**
	 * Sequential Search Helper Method
	 * 
	 */
	public static boolean contains(String[] array, String target, int index) {
		if (index < 0) {
			return false;
		}
		else if (target.equals(array[index])) {
			return true;
		}
		else {
			return contains(array, target, index - 1);
		}
	}
	
	/**
	 * Binary Search.
	 * PRECONDITION: array is sorted from smallest to largest
	 * @return true if target is in array, false otherwise
	 */
	public static boolean contains(int[] array, int target)
	{
		
		return contains(array, target, 0, array.length - 1);
		
	}
	
	/**
	 * Binary Search Helper Method
	 */
	public static boolean contains(int[] array, int target, int low, int high) {
		
		int middle =  (low + high)/2;
		if (high < low) return false;
		
		if (target < array[middle]) {
			return contains(array, target, low, middle - 1);
		}
		else if (target > array[middle]) {
			return contains(array, target, middle + 1, high);
		}
		else if (target == array[middle]) {
			return true;
		}
		else return false;
	}
	
	/**
	 * Fibonacci
	 * @return the nth value in the Fibonacci sequence.
	 */
	public static int fibonacci(int n) {
		  if (n < 1) throw new IllegalArgumentException("Entered index must be greater than or equal to one");
		  if (n <= 2) return 1;
		  return fibonacci(n-1) + fibonacci(n-2);
		}
}