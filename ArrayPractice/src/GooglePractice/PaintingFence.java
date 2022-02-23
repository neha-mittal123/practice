package GooglePractice;

//Given a fence with n posts and k colors, find out the number of ways of painting the fence such that at most 2 adjacent posts have the same color. Since answer can be large return it modulo 10^9 + 7.
//        Examples:
//
//        Input : n = 2 k = 4
//        Output : 16
//        We have 4 colors and 2 posts.
//        Ways when both posts have same color : 4
//        Ways when both posts have diff color :
//        4(choices for 1st post) * 3(choices for
//        2nd post) = 12
//
//        Input : n = 3 k = 2
//        Output : 6

public class PaintingFence {
    public static void main(String[] args){
        int n = 3, k = 2;
        System.out.print(countNoOfWays(n,k));
    }

    private static int countNoOfWays(int n, int k) {
        int[] dp=new int[n+1];
        dp[1]=k;
        int same=0,diff=k;
        for(int i=2;i<=n;i++){
            same=diff;
            diff=dp[i-1]*(k-1);
            dp[i]=same+diff;
        }
        return dp[n];
    }
}