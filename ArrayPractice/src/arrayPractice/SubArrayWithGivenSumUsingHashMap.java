package arrayPractice;

import java.util.HashMap;

public class SubArrayWithGivenSumUsingHashMap {

	public static void main(String[] args) {
		 int[] arr = {10, 2, -2, -20, 10}; 
	        int n = arr.length; 
	        int sum = -10; 
	        subArraySum(arr, n, sum); 

	}

	private static void subArraySum(int[] arr, int n, int sum) {
		int start=0,curr_sum=0,end=-1;
		HashMap<Integer, Integer> map=new HashMap<Integer, Integer>();
		for(int i=0;i<n;i++) {
			curr_sum=curr_sum+arr[i];
			if(curr_sum-sum==0) {
				start=0;
				end=i;
				break;
			}
			if(map.containsKey(curr_sum-sum)) {
				start=map.get(curr_sum-sum)+1;
				end=i;
				break;
			}
			map.put(curr_sum, i);
		}
		if(end==-1)
			System.out.println("no subArray Found");
		else
			System.out.println("subArray start:"+start+"end upto:"+end);
			
		
	}

}
