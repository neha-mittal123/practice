package arrayPractice;

import java.util.Scanner;

public class BuildingsReceivingSunlight {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int x = 0; x < t; x++) {
			int n = sc.nextInt();
			int arr[] = new int[n];
			for (int j = 0; j < n; j++) {
				arr[j] = sc.nextInt();
			}
			buildingReceivingSunlight(arr);
		}
	}

	private static void buildingReceivingSunlight(int[] arr) {
		int max = -1;
		int count = 0;
		for(int i=0;i<arr.length;i++) {
			if(arr[i]>=max) {
				max = arr[i];
				count++;
			}
		}
		System.out.println(count);
	}

}
