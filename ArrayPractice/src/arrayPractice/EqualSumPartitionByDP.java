package arrayPractice;

public class EqualSumPartitionByDP {

	static int[] arr = { 1,5,5,11 };
	static int n = arr.length;
	
	public static void main(String[] args) {
		int sum=0;
		for(int i=0;i<arr.length;i++) {
			sum=sum+arr[i];
		}
		 
		 boolean res=checkEqualSumPartitionByDP(sum/2);
		 System.out.println(res);
	}

	private static boolean checkEqualSumPartitionByDP(int sum) {
		boolean dp[][] = new boolean[n + 1][sum + 1];
		for(int i=0;i<=n;i++) {
			for(int j=0;j<=sum;j++) {
				if(j==0) {
					dp[i][j]=true;
				}else if(i==0 && j>0) {
					dp[i][j]=false;
				}else if(arr[i-1]>j) {
					dp[i][j]=dp[i-1][j];
				}else {
					dp[i][j] = dp[i-1][j] || dp[i-1][j-arr[i-1]]; 
				}
			}
		}
		return dp[n][sum];
	}

}
