package arrayPractice;

import java.util.Scanner;

/*Given an array of n integers(duplicates allowed). Print “Yes” if it is a set of contiguous 
integers else print “No”.*/

class CheckContiguousIntegersInArray {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int x = 0; x < t; x++) {
			int n = sc.nextInt();
			int arr[] = new int[n];
			for (int j = 0; j < n; j++) {
				arr[j] = sc.nextInt();
			}
			findContiguousIntegersInArray(arr);
		}

	}

	private static void findContiguousIntegersInArray(int[] arr) {
			int min = 9999999;
			int max = -1;
			int flag = 0;
			for(int i=0;i<arr.length;i++) {
				if(arr[i]>max) {
					max = arr[i];
				}
				if(arr[i]<min) {
					min = arr[i];
				}
			}
			boolean visited_arr[] = new boolean[max-min+1];
			for(int i=0;i<arr.length;i++) {
				visited_arr[arr[i]-min] = true;
			}
			for(int i=0;i<visited_arr.length;i++) {
				if(visited_arr[i]== false) {
					flag = 1;
				}
			}
			if(flag == 0) {
				System.out.println("Yes");
			}else {
				System.out.println("No");
			}
	}

}
