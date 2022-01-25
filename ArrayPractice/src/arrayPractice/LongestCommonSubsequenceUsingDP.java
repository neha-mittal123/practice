package arrayPractice;

public class LongestCommonSubsequenceUsingDP {

	static String s1="ABCDGH";
	static String s2="AEDFHR";
	static int n1=s1.length();
	static int n2=s2.length();
	static int dp[][]=new int[n1+1][n2+1];
	public static void main(String[] args) {
		int lengthOfLCS=findLengthOfLCS();
		System.out.println(lengthOfLCS);
		String lcs=findLCS();
		System.out.println(lcs);

	}
	private static String findLCS() {
		StringBuilder res=new StringBuilder();
		int i=n1,j=n2;
		while(i>0 && j>0) {
			if(s1.charAt(i-1)==s2.charAt(j-1)) {
				res.append(s1.charAt(i-1));
				i--;
				j--;
			}else if(dp[i-1][j]>dp[i][j-1]) {
				i--;
			}else {
				j--;
			}
			
		}
		return res.reverse().toString();
	}
	private static int findLengthOfLCS() {
		for(int i=0;i<=n1;i++) {
			for(int j=0;j<=n2;j++) {
				if(i==0 || j==0) {
					dp[i][j]=0;
				}else if(s1.charAt(i-1)==s2.charAt(j-1) && i!=j) {//for longest repeating subsequence with this charactors matching check, need to check the indexes also ie i!=j and remaining all ll be same
					dp[i][j]=1+dp[i-1][j-1];
				}else {// for longest common substring in this dp[i][j] ll be zero coz substring is continuos charactors so if charactors are not matching then it ll be 0 and remaining all ll be same
					dp[i][j]=Math.max(dp[i-1][j], dp[i][j-1]);
					//dp[i][j] = 0;
				}
			}
		}
		return dp[n1][n2];
	}

}
