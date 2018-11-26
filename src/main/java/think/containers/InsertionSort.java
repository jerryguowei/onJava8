package think.containers;

import java.util.Arrays;

public class InsertionSort {
	
	static void sort(int[] arr) {
		int n = arr.length;
		
		for (int i = 1; i < n; i++) {
			int j = i - 1;
			int tempValue = arr[i];
			while (j >= 0 && arr[j] > tempValue) {
				arr[j + 1] = arr[j];
				j--;
			}
			arr[j+1] = tempValue;
		}
	}
	
	public static void main(String[] args) {
		int[] a = {3,5,4,2,1};
		sort(a);
		System.out.println(Arrays.toString(a));
	}

}
