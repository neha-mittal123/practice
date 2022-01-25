package arrayPractice;

public class ZeroOrOneKnapsackDPIterative {

	static int profit[]= {2,3,5};
	static int weight[]= {1,2,3};
	static int m=profit.length;
	//static int n=weight.length;
	static int totalWeight = 8;
	static int dp[][] =new int[m+1][totalWeight+1];
	
	public static void main(String[] args) {	
		int maxProfit=CalcMaxProfit();
		System.out.println(maxProfit);

	}

	private static int CalcMaxProfit() {
		for(int i=0;i<=m;i++) {
			for(int j=0;j<=totalWeight;j++) {
				if(i==0 || j==0) {
					dp[i][j]=0;
				}else if(weight[i-1]>j) {
					dp[i][j]=dp[i-1][j];
				}else {
					dp[i][j]=Math.max(dp[i-1][j], profit[i-1]+dp[i-1][totalWeight-weight[i-1]]);
				}
			}
		}
		return dp[m][totalWeight];
	}

}
