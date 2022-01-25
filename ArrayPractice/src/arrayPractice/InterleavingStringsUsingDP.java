package arrayPractice;

public class InterleavingStringsUsingDP {

	static String s1="xxy",s2="xxz",s3="xxxxzy";
	static int n1=s1.length();
	static int n2=s2.length();
	static boolean dp[][]=new boolean[n1+1][n2+1];
	public static void main(String[] args) {
		boolean res=checkInterleavingString();
		System.out.println(res);
		

	}
	private static boolean checkInterleavingString() {
		if((n1+n2)!=s3.length()) {
			return false;
		}
		for(int i=0;i<=n1;i++) {
			for(int j=0;j<=n2;j++) {
				int l=i+j-1;
				if(i==0 && j==0) {
					dp[i][j]=true;
				}else if(i==0) {
					if(s3.charAt(j-1)==s2.charAt(j-1)) {
						dp[i][j]=dp[i][j-1];
					}
				}else if(j==0) {
					if(s3.charAt(i-1)==s1.charAt(i-1)) {
						dp[i][j]=dp[i-1][j];
					}
				}else {
					//dp[i][j]=(s3.charAt(l)==s2.charAt(i-1) ? dp[i][j]=dp[i-1][j] : false) || (s3.charAt(l)==s2.charAt(j-1) ? dp[i][j]=dp[i][j-1] : false );
					if((s1.charAt(i-1)==s3.charAt(l)) && (s2.charAt(j-1)!=s3.charAt(l))){
						dp[i][j]=dp[i-1][j];
					}else if((s2.charAt(j-1)==s3.charAt(l)) && (s1.charAt(i-1)!=s3.charAt(l))) {
						dp[i][j]=dp[i][j-1];
					}else if((s2.charAt(j-1)==s3.charAt(l)) && (s1.charAt(i-1)==s3.charAt(l))) {
						dp[i][j]=dp[i-1][j] || dp[i][j-1];
					}
				}
			}
		}
		return dp[n1][n2];
	}

}
