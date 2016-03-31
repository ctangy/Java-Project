package Sorting;

import java.util.Arrays;

public class mergeSort {

	public static void main(String[] args) {
		int[] array =  {4,7,5,2,6,3,1,0};
		int half = array.length/2;
	    int[] firstHalf = new int[half];
	    int[] secondHalf = new int[array.length - half];
		sort(array);

	}
	public static void sort(int[] array) {
	
		

	}
	
	public static int[] merge(int[]a, int[]b) {
		int[] result = new int[a.length + b.length];
		int resultIndex = 0;
		int aIndex = 0;
		int bIndex= 0;
		
		while(bIndex <b.length){
			result[resultIndex] = b[bIndex];
			resultIndex++;
			bIndex++;
		}
		/**compare element at a/b Index,
		 * put smaller element at resultIndex 
		 * increment resultIndex and 
		 * index of the array from which the
		 * value was copied
		 * >>>> while aIndex < a.length && bIndex < b.length <<<<**/
		
		return result;

		

	}

}