/**
 * 
 * @author Suhas Julapalli
 * Period 3
 */
public class ArrayHelper {
	
	private String[] array;
	
	/**
	 * Constructs an ArrayHelper object
	 * @param array
	 */
	public ArrayHelper(String[] array)
	{	this.array = array;		}
	
	/**
	 * Add an item to the end of this.array
	 */
	public void add(String item)
	{
		//your code goes here
		String[] temp = new String[this.array.length + 1];

		for (int i = 0; i < this.array.length; i++)
			temp[i] = this.array[i];
			
		temp[this.array.length] = item;
		
		this.array = temp;
	}
	
	/**
	 * Add an item at a given index of this.array
	 * 
	 * Throws an IllegalArgumentException if the index < 0 or 
	 * 					index > array.length
	 */
	public void add(String item, int index)
		throws IllegalArgumentException
	{
		//your code goes here
		if (index < 0 || index > this.array.length)
			throw new IllegalArgumentException();
		
		String[] temp = new String[this.array.length + 1];
		
		for (int i = 0; i < index; i++)
			temp[i] = this.array[i];
		
		temp[index] = item;
		
		for (int i = index + 1; i < temp.length; i++)
			temp[i] = this.array[i - 1];
		
		this.array = temp;
	}
	
	/**
	 * Removes a given item from this.array.
	 * 
	 * array remains unchanged if the item is not an element of this.array.
	 * @return true if a change was made, false otherwise
	 */
	public boolean remove(String item)
	{
		//your code goes here
		if (contains(item)) {
			
			String[] temp = new String[array.length - 1];
			
			for (int i = 0; i < indexOf(item); i++)
				temp[i] = this.array[i];
			for (int k = indexOf(item) + 1; k < array.length; k++) 
				temp[k - 1] = this.array[k];
			
			this.array = temp;
			
			return true;
		}
		
		return false;
	}
	
	/**
	 * Removes an item from this.array at a given index
	 * 
	 * Throws an ArrayIndexOutOfBoundsException if the index is not valid
	 * @return true if a change was made, false otherwise
	 */
	public boolean remove(int index) throws ArrayIndexOutOfBoundsException
	{
		//your code goes here
		if (index < 0 || index > array.length - 1)
			throw new ArrayIndexOutOfBoundsException();

		String[] temp = new String[array.length - 1];
		
		for (int i = 0; i < index; i++)
			temp[i] = this.array[i];
		for (int i = index + 1; i < this.array.length; i++) {
			temp [i - 1] = this.array[i];
		}
		
		this.array = temp;
		
		return true;
	}
	
	/**
	 * Determines if an element exists in this.array
	 * @return true if a element was found, false otherwise
	 */
	public boolean contains(String element)
	{
		//your code goes here
		for (String str : this.array) 
			if (element.equals(str))
				return true;
		return false;
	}
	
	/**
	 * returns the index of an element in this.array or 
	 * 					-1 if the element does not exist
	 */
	public int indexOf(String element)
	{
		//your code goes here
		for (int i = 0; i < this.array.length; i++) {
			if (element.equals(this.array[i]))
				return i;
		}
		
		return -1;
	}
	
	/**
	 * @return a String representation of this.array
	 */
	public String toString()
	{
		if(array.length == 0) return "{}";
		
		String str = "{";
		int i = 0;
		for( ; i < array.length - 1; i++)
		{
			if(array[i] == null)
				str += String.format("%s,", array[i]);
			else
				str += String.format("\"%s\",", array[i]);
		}
		if(array[i] == null)
			str += String.format("%s}", array[i]);
		else
			str += String.format("\"%s\"}", array[i]);
		return str;
				
	}
}
