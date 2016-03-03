package review;

public class Homework {

	public static void main(String[] arg){
		int[][] g ={{9, 8, 7, 6},           

				{5, 4, 2, 1},

				{3, 9, 2, 3}};
		rowMajorOrder(g);
		posToNeg2D(g,0,0);

	}



	public static int[][] posToNeg2D(int[][] mat, int i, int j){
		for(int rIndex = 0; rIndex < mat.length; rIndex++){
			for(int cIndex = 0; cIndex < mat[0].length; cIndex++){
				if(Math.abs(rIndex - i) == 1 && Math.abs(cIndex - j)==0){
					mat[i][j] = 0 - mat[i][j];
					System.out.println(mat[i][j]);//wrong
				}	
			}
		}return mat;
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

