package review;
public class Hanoi {

	public static void main(String[] args) {
		move(1,"A","B","C");//index of the last disc out of w length

	}
	
	public static void move(int n, String from, String mid, String to){
		if(n == 0){
			System.out.println("Move a disc "+n+ "from"+ from + "to "+ to);
		}
		if(n > 1){
			move(n-1, from,to, mid);
			System.out.println("Move a disc "+n+ "from"+ from + "to "+ to);
		}
	}
}
