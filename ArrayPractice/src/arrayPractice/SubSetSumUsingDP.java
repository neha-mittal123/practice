package arrayPractice;

public class SubSetSumUsingDP {

	static int[] arr = { 2, 2, 3,1,4 };
	static int sum = 5;
	static int n = arr.length;
	static boolean dp[][] = new boolean[n + 1][sum + 1];

	public static void main(String[] args) {
		boolean result = checkSubSetHavingGivenSum();
		System.out.println(result);

	}

	private static boolean checkSubSetHavingGivenSum() {
		for (int i = 0; i <= n; i++) {
			for (int j = 0; j <= sum; j++) {
				if (j == 0) {
					dp[i][j] = true;
				} else if (i == 0 && j > 0) {
					dp[i][j] = false;
				} else if (arr[i - 1] > j) {
					dp[i][j] = dp[i - 1][j];
				} else {
					if(dp[i-1][j]) {
						dp[i][j] = true;
					}else {
						boolean include = true;
						if(j-arr[i-1]>0) {
							include = dp[i-1][j-arr[i-1]];
						}
						dp[i][j] = dp[i-1][j] || include;
					}
				}
			}
		}
		return dp[n][sum];
	}

}
