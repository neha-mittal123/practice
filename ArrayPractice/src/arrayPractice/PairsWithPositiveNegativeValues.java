package arrayPractice;

import java.util.HashMap;

/*Given an array of distinct integers, 
print all the pairs having positive value and negative value of a number that exists in the array.*/
public class PairsWithPositiveNegativeValues {

	public static void main(String[] args) {
		int arr[] = {-3,-1, 2, 1, 6, 3};
		int length = 6;
		printPairs(arr,length);

	}

	private static void printPairs(int[] arr, int length) {
		HashMap<Integer,Integer> hm = new HashMap<>();
		for(int i=0,j=length-1;j>=i;i++,j--) {
			if(hm.containsKey(-arr[i])) {
				hm.put(-arr[i], arr[i]);
			}else {
				hm.put(arr[i], 0);
			}
			if(hm.containsKey(-arr[j])) {
				hm.put(-arr[j], arr[j]);
			}else {
				hm.put(arr[j], 0);
			}
		}
		int flag = 0;
		for(Integer i : hm.values()) {
			if(i == 0) {
				continue;
			}else {
				System.out.println("Pairs Found:"+ i + "," + -i);
				flag = 1;
			}
		}
		if(flag == 0) {
			System.out.println("Pair Not Found");
		}
		
	}

}
