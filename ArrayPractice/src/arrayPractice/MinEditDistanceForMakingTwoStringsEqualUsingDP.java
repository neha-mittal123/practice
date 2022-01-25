package arrayPractice;

public class MinEditDistanceForMakingTwoStringsEqualUsingDP {
	static String s1="abcd";//abc
	static String s2="aebd";//bcd
	static int m=s1.length();
	static int n=s2.length();
	static int dp[][]=new int[m+1][n+1];
	public static void main(String[] args) {
		int minDist=calcMinDist();
		System.out.println(minDist);
		

	}
	private static int calcMinDist() {
		for(int i=0;i<=m;i++) {
			for(int j=0;j<=n;j++) {
				if(i==0) {
					dp[i][j]=j;
				}else if(j==0) {
					dp[i][j]=i;
				}else if(s1.charAt(i-1)==s2.charAt(j-1)) {
					dp[i][j]=dp[i-1][j-1];
				}else {
					int min=Math.min(dp[i-1][j],dp[i][j-1]);
					dp[i][j]=1+Math.min(min,dp[i-1][j-1]);
				}
			}
		}
		return dp[m][n];
	}

}
