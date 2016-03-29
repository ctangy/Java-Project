package review;

public class Homework {

	public static void main(String[] arg){
		int[][] g ={{9, 8, 7, 6},           

				{5, 4, 2, 1},

				{3, 9, 2, 3}};
		rowMajorOrder(g);
		posToNeg2D(g,0,0);

	}



//	public static int[][] posToNeg2D(int[][] mat, int i, int j){
//		for(int rIndex = 0; rIndex < mat.length; rIndex++){
//			for(int cIndex = 0; cIndex < mat[0].length; cIndex++){
//				if(Math.abs(rIndex - i) == 0 && Math.abs(cIndex - j)==0){
//					mat[i][j] = 0 - mat[i][j];
//					System.out.println(mat[i][j]);//wrong
//				}	
//			}
//		}return mat;
	    public static void posToNeg2D(int[][] array,int a, int b){
	        for(int i = a-1;i<a+2;i++){
	            for(int j = b-1;j<b+2;j++){
	                if(i == a && j==b)
	                    continue;
	                if(i> -1 && i < array.length && j > -1 && j < array[i].length)
	                    array[i][j] *= -1;
	            }
	        }
	    }
	

	public static int[] rowMajorOrder(int[][] nums){
		int items = nums.length*nums[0].length;
		int[] a = new int[items];
		int count = 0;
		for(int i = 0; i < nums.length;i++){
			for(int j = 0; j < nums[0].length; j++){
				a[count] = nums[i][j];
				System.out.println(a[count]);
				count++;
			}
		}return a;
	}	
}	
//	int[][] g ={{9, 8, 7, 6},         
//
//			{5, 4, 2, 1},
//
//			{3, 9, 2, 3}};
//
//	 rowMajorOrder(g)   = {9, 8, 7, 6, 5, 4, 2, 1, 3, 9, 2, 3};

