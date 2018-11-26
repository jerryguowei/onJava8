package think.containers;

import java.util.Arrays;

public class BubbleSort {
	
	static void sort(int[] arr) {
		int temp = 0;
		for(int i = 0; i< arr.length-1;i++) {
			for(int j =0; j < arr.length-1;j++) {
				if(arr[j] > arr[j+1]) {
				  temp = arr[j];
				  arr[j] = arr[j+1];
				  arr[j+1]= temp;
				}
			}
		}
	}
	public static void main(String[] args) {
		int[] a = {3,2,5,4,1,21,33,55,11};
		sort(a);
		System.out.println(Arrays.toString(a));
	}
}
