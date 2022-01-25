package arrayPractice;

public class CoinChangeProbByDP {

	static int [] coins= {1,5,4};
	static int amount=6;
	static int n=coins.length;
	static int[][] dp=new int[n+1][amount+1];
	public static void main(String[] args) {
		int coins=findMinNoOfCoins();
		System.out.println(coins);
	}
	private static int findMinNoOfCoins() {
		for(int i=0;i<=n;i++) {
			for(int j=0;j<=amount;j++) {
				if(j==0) {
					dp[i][j]=0;
				}else if(i==0 & j>0) {
					dp[i][j]=Integer.MAX_VALUE;
				}else if(coins[i-1]>j) {
					dp[i][j]=dp[i-1][j];
				}else {
					dp[i][j]=Math.min(dp[i-1][j], 1+dp[i][j-coins[i-1]]);
				}
			}
			
		}
		return dp[n][amount] > Integer.MAX_VALUE-1000 ? -1 : dp[n][amount] ;
	}

}
