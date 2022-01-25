package arrayPractice;

public class ScrambledStringUsingDP {

	public static void main(String[] args) {
		String s1="abcde";
		String s2="caebd";
		boolean res=checkScrambledString(s1,s2);
		System.out.println(res);
	}

	private static boolean checkScrambledString(String s1, String s2) {
		if(s1.length()!=s2.length()) {
			return false;
		}
		int n=s1.length();
		boolean [][][] dp=new boolean[n][n][n+1];
		for(int len=1;len<=n;len++) {
			for(int i=0;i<=n-len;i++) {
				for(int j=0;j<=n-len;j++) {
					if(len==1) {
						dp[i][j][len]=(s1.charAt(i)==s2.charAt(j));
					}else {
						for(int k=1;k<len && !dp[i][j][len];k++) {
							dp[i][j][len]=((dp[i][j][k] || dp[i+k][j+k][len-k]) && (dp[i][j+len-k][k] || dp[i+k][j][len-k]));
						}
					}
				}
			}
			
		}
		return dp[0][0][n];
		
	}

}
