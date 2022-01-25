package arrayPractice;

import java.util.Scanner;

public class FirstNegativeIntegerInEveryWindowOfSizeK {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int x = 0; x < t; x++) {
			int n = sc.nextInt();
			int arr[] = new int[n];
			for (int j = 0; j < n; j++) {
				arr[j] = sc.nextInt();
			}
			int windowSize = sc.nextInt();
			findNegativeInteger(arr, windowSize);
			System.out.println();
		}

	}

	private static void findNegativeInteger(int[] arr, int windowSize) {
		int start = 0, i;
		int curWindowSize = 0;
		int negativeNum = 0;
		for (i = 0; i < arr.length; i++) {
			curWindowSize = i - start + 1;
			if(i<windowSize) {
				if (negativeNum == 0 && arr[i] < 0) {
					negativeNum = arr[i];
				}
			}else {
				int temp = curWindowSize;
				int pos = start;
				while(temp>0) {
					if(negativeNum == 0 && arr[pos]<0) {
						negativeNum = arr[pos];
						break;
					}
					pos++;
					temp--;
				}
			}
			if (curWindowSize == windowSize) {
				System.out.print(negativeNum + " ");
				start++;
				curWindowSize = 0;
				negativeNum = 0;
			}
		}

	}
}
