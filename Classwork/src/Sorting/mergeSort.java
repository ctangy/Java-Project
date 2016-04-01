package Sorting;

import java.util.Arrays;

public class mergeSort {

	public static void main(String[] args) {
		int[] array =  {4,7,5,2,6,3,1,0};
//		int half = array.length/2;
//	    int[] firstHalf = new int[half];
//	    int[] secondHalf = new int[array.length - half];
		sort(array);

	}
	public static int[] sort(int[] array) {
		if(array.length == 1){
			return array;
		}

	    int[] first = new int [array.length/2];
	    int[] second = new int[array.length - first.length];
	    
	    for(int i = 0; i < first.length; i++){
	    	firts[i] = array[i];
	    }
	    for(int j = 0; j < second.length; j++){
	    	second[j] = array[j + first.length];
	    }
		return merge(sort(first),sort(second));
		

	}
	
	public static int[] merge(int[]a, int[]b) {
		int[] result = new int[a.length + b.length];
		int resultIndex = 0;
		int aIndex = 0;
		int bIndex= 0;
		
		while(resultIndex < a.length && aIndex < b.length){
			
//				public static int[] merge(int[] a, int[] b){
//				int[] array= new int[a.length + b.length];
//				int i =0;
//				int j =0;
//				int z =0;
//				while(i<a.length && j<b.length){//i<a.length && j<b.length
//					if(a[i]<=b[j])
//					{
//						array[z]=a[i];
//						i++;
//					}
//					else{
//						array[z]=b[j];
//						j++;
//					}
//					z++;
//				}
//				while(i<a.length){
//					array[z]=a[i];
//					i++;
//					z++;
//				}
//				while(j<b.length){
//					array[z]=b[j];
//					j++;
//					z++;
//				}
//				System.out.println(Arrays.toString(array));
//				return array;
//		}
		/**compare element at a/b Index,
		 * put smaller element at resultIndex 
		 * increment resultIndex and 
		 * index of the array from which the
		 * value was copied
		 * >>>> while aIndex < a.length && bIndex < b.length <<<<**/
		
		return result;

		

	}

}