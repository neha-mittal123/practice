package arrayPractice;

import java.util.Scanner;

/*Given an array of integers (A[])  and a number x, 
find the smallest subarray with sum greater than the given value.*/

public class SmallestSubArrayWithSumGreaterThanX {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int x = 0; x < t; x++) {
			int n = sc.nextInt();
			int sum = sc.nextInt();
			int arr[] = new int[n];
			for (int j = 0; j < n; j++) {
				arr[j] = sc.nextInt();
			}
			findSmallestSubarray(arr, sum);
		}
	}

	private static void findSmallestSubarray(int[] arr, int sum) {
		int start = 0, i;
		int curr_sum = arr[0];
		int min = 999999;
		int flag = 0;
		if (arr[0] > sum) {
			min = 1;
			flag = 1;
		}
		if (flag == 0) {
			for (i = 1; i < arr.length; i++) {
				if (arr[i] > sum) {
					min = 1;
					break;
				}
				if (curr_sum > sum) {
					int p = i - 1;
					if (min > p - start + 1) {
						min = p - start + 1;
					}
					while (curr_sum > sum && start < p) {
						if(min>p-start+1) {
							min = p-start+1;
						}
						curr_sum = curr_sum - arr[start];
						start++;
					}
				}
				curr_sum = curr_sum + arr[i];
			}
		}
		System.out.println(min);
	}

}
