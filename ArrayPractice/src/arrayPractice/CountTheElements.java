package arrayPractice;

import java.util.Scanner;

/*Given two arrays A and B. Given Q queries each having a positive integer i 
denoting an index of the array A. 
For each query, your task is to find all the elements less than or equal to Ai in the array B.*/

public class CountTheElements {

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
			int noOfQueries = sc.nextInt();
			while (noOfQueries != 0) {
				int q = sc.nextInt();
				findCount(arr1, arr2,q);
				noOfQueries = noOfQueries - 1;
			}
		}

	}

	private static void findCount(int[] arr1, int[] arr2, int q) {
		int number = arr1[q];
		int count = 0;
		
		for(int i=0;i<arr2.length;i++) {
			if(arr2[i]<=number) {
				count++;
			}
		}
		System.out.println(count);
		
	}

}
