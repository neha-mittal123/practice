package arrayPractice;

import java.util.HashMap;
import java.util.Map;

public class CountDistinctNoOfPairsWithGivenSum {

	public static void main(String[] args) {
		int arr[] = { 5, 6, 5, 7, 7, 8,9,4 };
	    int K = 13;
	    System.out.println(findNoOfPairs(arr,K));

	}

	private static int findNoOfPairs(int[] arr, int k) {
		HashMap<Integer, Boolean> map=new HashMap<>();
		int count=0;
		for(int i=0;i<arr.length;i++) {
			if(map.containsKey(arr[i])) {
				continue;
			}else {
				map.put(arr[i], false);
			}
			if(map.containsKey(k-arr[i])) {
				count++;
			}
		}
		
		return count;
	}

}
