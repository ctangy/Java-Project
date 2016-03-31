package Sorting;

import java.util.Arrays;

public class insertionSort {

	public static void main(String[] args) {
		int[] array =  {4,7,5,2,6,3,1,0};
		sort(array);

	}

//	public static void swap(int[] array, int i, int j){
//		array[j] = array[j-1];
//		j= j-1;
//	}
	
	public static void sort(int[] array) {
		for(int i = 1; i < array.length; i++){
			int num = array[i];
			int j = i;
			while( j > 0 && array[j-1] > num){
//			swap(array, i , j);
				array[j] = array[j-1];
				j = j-1;
				
			}
			array[j] = num;
			System.out.println("Switched " +array[i]+ " and " +array[j] +".");
				System.out.println(Arrays.toString(array));
		}
	}
}
