package arrayPractice;

import java.util.Map.Entry;
import java.util.Scanner;
import java.util.concurrent.ConcurrentHashMap;

/*Given an array A of N integers, 
find a combination of four elements in the array whose sum is equal to a given value X.*/

public class FourElementsWithGivenSum {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int x = 0; x < t; x++) {
			int n = sc.nextInt();
			int arr[] = new int[n];
			for (int j = 0; j < n; j++) {
				arr[j] = sc.nextInt();
			}
			int sum = sc.nextInt();
			ConcurrentHashMap<Integer, Integer> hm = new ConcurrentHashMap<>();
			int i = 0;
			boolean flag = false;
			for (; i < arr.length; i++) {
				if (flag) {
					break;
				}

				for (Entry<Integer, Integer> e : hm.entrySet()) {
					if (sum - e.getKey() == arr[i] && e.getValue() == 1) {
						System.out.println("Found");
						flag = true;
						break;
					} else {
						hm.put(e.getKey() + arr[i], e.getValue() - 1);
					}
				}

				hm.put(arr[i], 3);
			}
			if (i > arr.length) {
				System.out.println("Not Found");
			}
		}
	}
}
