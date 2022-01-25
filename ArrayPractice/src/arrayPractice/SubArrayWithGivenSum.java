package arrayPractice;

public class SubArrayWithGivenSum {

	// Driver code 
    public static void main(String[] args) { 
        int[] arr = {1, 2, 3, 7, 5}; 
        int n = arr.length; 
        int sum = 12; 
        subArraySum(arr, n, sum); 
    }

	private static void subArraySum(int[] arr, int n, int sum) {
		int start = 0,i;
		int curr_sum = arr[0];
		
		for(i=1;i<n;i++) {
			
			while(curr_sum > sum && start < i-1) {
				curr_sum = curr_sum - arr[start];
				start++;
			}
			
			if(curr_sum == sum) {
				int p = i-1;
				System.out.println("Start Index:"+ start + "End Index:" + p);
			}
			
			curr_sum = curr_sum + arr[i];
		}
		
	} 

    
}
