
public class ArrayClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] array = new String[2];
		ArrayHelper ah = new ArrayHelper(array);
	
		System.out.println(ah);
		
		ah.add("Chase");
		ah.add("Zuma");
		ah.add("Rocky");
		ah.add("Marshall", 0);
		ah.add("Skye", 2);
		try {
			ah.add("Mayor Humdinger",8);
		}
		catch(IllegalArgumentException e)
		{
			System.out.println("Mayor Humdinger is not a paw patrol character.");
		}
		ah.remove("Zuma");
		ah.remove(3);
		try {
			ah.remove(5);
		}
		catch(ArrayIndexOutOfBoundsException e)
		{
			System.out.println("Index 5 doesn't exist.");
		}
		if(ah.contains("Chase"))
			System.out.println("Chase was found.");
		if(ah.contains("Zuma"))
			System.out.println("Zuma was found");
		System.out.println("Rocky is stored at index " + ah.indexOf("Rocky"));
		System.out.println(ah);
				
	}

}
