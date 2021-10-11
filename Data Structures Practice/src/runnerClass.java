
public class runnerClass {

	public static void main(String[] args) {
		String string = "abcdefghi";
		
		System.out.println(string);
		System.out.println(reverseString(string));
	}
	
	public static String reverseString(String str) {
		if (str == null) return str;
		String temp = new String();
		
		return reverseString(str, temp);
	}
	
	public static String reverseString(String str, String temp) {
		
		if (str.length() == 0) return temp;
		
		temp = str.substring(0, 1) + temp;
		
		return reverseString(str.substring(1), temp);
	}
	
}
