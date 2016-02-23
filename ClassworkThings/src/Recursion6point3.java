
public class Recursion6point3 {

	public static void main(String[] args) {
		String string = "Carmen";
		System.out.println("Original String: " + string);
		System.out.println("Reversed String: " + recursiveMethod(string));

	}
	
	public static String recursiveMethod(String string){
	 if(string.length()== 1)
	 {
	  return string;
	 }
	 else
	 {
		 return recursiveMethod(string.substring(1)) + string.charAt(0);
	 }
	 
	}
	
	
}
