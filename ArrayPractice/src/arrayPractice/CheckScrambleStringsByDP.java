package arrayPractice;

public class CheckScrambleStringsByDP {

	static String s1="great";
	static String s2="aterg";
	static int n=s1.length();
	static boolean dp[][][]=new boolean[n][n][n+1];
	
	public static void main(String[] args) {
		
		boolean res=checkStringsAreScrambled();
		System.out.println(res);
	}
	private static boolean checkStringsAreScrambled() {
		for(int len=1;len<=n;len++) {
			for(int i=0;i<=n-len;i++) {
				for(int j=0;j<=n-len;j++) {
					if(len==1) {
						dp[i][j][len]=(s1.charAt(i)==s2.charAt(j));
					}else {
						for(int k=1;k<len && !dp[i][j][len];k++) {
							dp[i][j][len]=(dp[i][j][k] && dp[i+k][j+k][len-k]) || (dp[i][j+len-k][k] && dp[i+k][j][len-k]);
						}
					}
				}
			}
		}
		
		return dp[0][0][n];
	}

}
