package arrayPractice;

public class CountPalindromicSubsequenceUsingDP {

	static String s="aba";
	static int dp[][]=new int[s.length()][s.length()];
	public static void main(String[] args) {
		
		int count=getCountOfPalindromicSubsequence();
		System.out.println(count);

	}
	private static int getCountOfPalindromicSubsequence() {
		
		for(int i=0;i<s.length();i++) {
			for(int j=0;j<s.length();j++) {
				if(i-j==0) {
					dp[i][j]=1;
				}else if(i-j==1) {
					dp[i][j]=s.charAt(i)==s.charAt(j) ? 3: 2;
				}else {
					dp[i][j]= (s.charAt(i)==s.charAt(j) ? dp[i][j-1]+dp[i+1][j]+1
							: dp[i][j-1]+dp[i+1][j]-dp[i+1][j-1]);
				}
			}
		}
		return dp[0][s.length()];
	}

}
