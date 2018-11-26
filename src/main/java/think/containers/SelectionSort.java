package think.containers;

import java.util.Arrays;

public class SelectionSort {
	static void sort(int[] arr) {
		int n = arr.length;
		for(int i = 0; i < n-1; i++)
		{
			int minIndex =i;
			for( int j = i + 1; j < n; j++)
				if(arr[j] < arr[minIndex]) {
					minIndex = j;
				}
			int tempValue = arr[i];
			arr[i] = arr[minIndex];
			arr[minIndex] = tempValue;
		}
	}
	
	public static void main(String[] args) {
		int[] a = { 4, 3, 5, 2, 1};
		sort(a);
		System.out.println(Arrays.toString(a));
	}
}
