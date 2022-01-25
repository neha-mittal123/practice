package arrayPractice;

import java.util.Scanner;

/*Given 2 sorted arrays A and B of size N each. 
Print sum of middle elements of the array obtained after merging the given arrays.*/

public class SumOfMiddleElementsOfTwoSortedArrays {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int x = 0; x < t; x++) {
			int n = sc.nextInt();
			int arr1[] = new int[n];
			int arr2[] = new int[n];
			for (int j = 0; j < n; j++) {
				arr1[j] = sc.nextInt();
			}
			for (int j = 0; j < n; j++) {
				arr2[j] = sc.nextInt();
			}
			findSum(arr1,arr2);
		}
	}

	private static void findSum(int[] arr1, int[] arr2) {
		int arr3[] = new int[arr1.length+arr2.length];
		int i =0 ,j =0,k=0;
		while(i<arr1.length && j<arr2.length) {
			if(arr1[i]<arr2[j]) {
				arr3[k] = arr1[i];
				k++;
				i++;
			}else if(arr1[i] == arr2[j]){
				arr3[k] = arr1[i];
				k++;
				i++;
				arr3[k] = arr2[j];
				k++;
				j++;
			}else if(arr1[i]>arr2[j]){
				arr3[k] = arr2[j];
				k++;
				j++;
			}
		}
		if(i < arr1.length) {
			while(i<arr1.length) {
				arr3[k] = arr1[i];
				k++;
				i++;
			}
		}
		if(j < arr2.length) {
			while(j<arr2.length) {
				arr3[k] = arr2[j];
				k++;
				j++;
			}
		}
		int mid = arr3.length/2;
		int sum = arr3[mid]+arr3[mid-1];
		System.out.println(sum);
	}

}