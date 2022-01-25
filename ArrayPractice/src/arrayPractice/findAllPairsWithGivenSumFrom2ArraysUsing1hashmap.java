package arrayPractice;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

public class findAllPairsWithGivenSumFrom2ArraysUsing1hashmap {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int x = 0; x < t; x++) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			int sum = sc.nextInt();
			Integer arr1[] = new Integer[n];
			int arr2[] = new int[m];
			for(int i=0;i<n;i++) {
				arr1[i] = sc.nextInt();
			}
			for(int i=0;i<m;i++) {
				arr2[i] = sc.nextInt();
			}
			findPairs(arr1,arr2,sum);
			System.out.println();
		}
	}

	private static void findPairs(Integer[] arr1, int[] arr2, int sum) {
		HashMap<Integer, Integer> map=new HashMap<>();
		int flag = 0;
		for(int i=0;i<arr2.length;i++) {
			map.put(arr2[i], i);
		}
		Collections.sort(Arrays.asList(arr1));
		for(int i=0;i<arr1.length;i++) {
			if(map.containsKey(sum - arr1[i])) {
				if(flag == 0) {
					System.out.print(arr1[i] +" "+ arr2[map.get(sum - arr1[i])]);
					flag =1;
				}else {
					System.out.print(", "+arr1[i] +" "+ arr2[map.get(sum - arr1[i])]);
				}
			}
		}
		if(flag == 0) {
			System.out.print(-1);
		}
		
	}

}
