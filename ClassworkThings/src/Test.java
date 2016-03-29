
public class Test {
	static int x = 3543;
	/**
	 * @param args
	 */
//	public static void main(String[] args) {
//
//		System.out.println(mystery(x));
//
//	}


	public static int mystery(int x)
	{
	 if (x == 0)
	 {
	  return 0;
	 }
	 else
	 {
	  return ((x % 10) + mystery(x / 10));
	 }
	}
}	
