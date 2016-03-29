package SelectionSort;

import java.util.Arrays;

public class sortingSelection {

	public static void main(String[] args) {
		int[] array =  {4,7,5,2,6,3,1,0};
		sort(array);
		System.out.println(Arrays.toString(array));

	}

	public static void sort(int[] array) {
		
		for(int i = 0; i < array.length; i++){
			int min = i;
			for(int j = i + 1; j < array.length; j++){
				if(array[min] > array[j]){
					min = j;
					int num = array[min];
					array[min] = array[i];
					array[i] = num;
					
					System.out.println("Switched " +array[i]+ " and " +array[j] +".");
					System.out.println(Arrays.toString(array));
				}
			}
		}
		
		
	}

}
