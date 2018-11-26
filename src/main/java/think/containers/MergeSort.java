package think.containers;

import java.util.Random;

public class MergeSort {

	static void merge(int[] arr, int l, int m, int r) {
		
		int n1 = m - l + 1;
		int n2 = r - m;
		int[] left = new int[n1];
		int[] right = new int[n2];
		for(int i = 0; i < n1; i++)
			left[i] = arr[l+i];
		for(int j = 0; j < n2; j++)
			right[j] = arr[m + 1 + j];
		int i= 0,j= 0;
		int k = l;
		while(i<n1 && j<n2) {
			if(left[i] <= right[j]) {
				arr[k++] = left[i++];
			}else {
				arr[k++] = right[j++];
			}
		}
		//copy left if there are still elements left
		while(i<n1) {
			arr[k++] = left[i++];
		}
		while(j < n2)
			arr[k++] = right[j++];	
	}	
	static void sort(int[] arr, int l, int r) {
		if(l < r) {
			int m = (r + l) / 2;
			sort(arr, l, m);
			sort(arr, m + 1, r);
			merge(arr,l,m,r);
		}
	}
	public static void main(String[] args) {
        int[] b = new int[100000];
        Random rand = new Random();
        for(int i = 0 ; i < 100000; i ++)
        	b[i] = rand.nextInt(100000);
        	
        long start = System.currentTimeMillis();
//       BubbleSort.sort(b);
//        SelectionSort.sort(b);
        sort(b, 0, b.length-1);
        long duration = System.currentTimeMillis()-start;
//        System.out.println(Arrays.toString(b));
        System.out.println(b.length);
        System.out.println(duration);

	}

}
