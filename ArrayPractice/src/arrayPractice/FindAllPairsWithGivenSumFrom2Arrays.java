package arrayPractice;

import java.util.HashMap;

//Given two unsorted arrays A of size N and B of size M of distinct elements, 
//the task is to find all pairs from both arrays whose sum is equal to X.

public class FindAllPairsWithGivenSumFrom2Arrays {

	public static void main(String[] args) {
		int arr1[] = {1,2,4,5,3};
		int arr2[] = {5,6,4};
		int sum = 9;
		findPairs(arr1,arr2,sum);

	}

	private static void findPairs(int[] arr1, int[] arr2, int sum) {
		HashMap<Integer,Integer> hm1 = new HashMap<>();
		HashMap<Integer,Integer> hm2 = new HashMap<>();
		
		int size1 = arr1.length;
		int size2 = arr2.length;
		int size = 0;
		if(size1>size2) {
			size = size1;
		}else {
			size = size2;
		}
		for(int i=0;i<size;i++) {
			if(i>size1-1) {
				continue;
			}else {
				if(hm2.containsKey(Math.abs(arr1[i]-sum))) {
					System.out.println("Pair found:"+arr1[i]+","+hm2.get(Math.abs(arr1[i]-sum)));
				}else {
					hm1.put(arr1[i], arr1[i]);
				}
			}
			if(i>size2-1) {
				continue;
			}else {
				if(hm1.containsKey(Math.abs(arr2[i]-sum))) {
					System.out.println("Pair found:"+arr2[i]+","+hm1.get(Math.abs(arr2[i]-sum)));
				}else {
					hm2.put(arr2[i], arr2[i]);
				}
			}
		}
		
	}

}
