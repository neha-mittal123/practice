package arrayPractice;

//Maximize sum of topmost elements of S stacks by popping at most N elements
//        Given S stacks of length M, the task is to maximize the sum of elements at the top of each stack by popping at most N elements.
//        Example:
//        Input: S = 2, N = 2, stacks = { { 2, 6, 4, 5}, {1, 6, 15, 10} }
//        Output: 17
//        Explanation:
//        Current sum of the elements at the top = 2 + 1 = 3.
//        Popping 1 from top of the second stack only makes the sum 8 (6 + 2 = 8)
//        Popping 2 from the top of the second stack only makes the sum 7 (6 + 1).
//        Popping both 1 and 2 from the top of each stack makes the sum 12 (6 + 6).
//        Popping 2 and 6 from the first stack makes the sum 5 (4 + 1).
//        Popping 1 and 6 from the second stack leaves 15 as the element at the top.
//        Hence, the sum of elements at the top of the two stacks is maximized (15 + 2 = 17).

public class MaximumSumOfStacksTopElementsUsingDP {

    static int [][]stacks = {{ 2, 6, 4, 5 },
                             { 1, 6, 15, 10 }};
    static int N = 2,S=2;
    static int[][] dp=new int[S+1][N+1];
    static int stackSize=stacks[0].length;

    public static void main(String[] args){
        System.out.println(findMaxSum());


    }

    private static int findMaxSum() {
        int res=Integer.MIN_VALUE;
        for(int i=0;i<S;i++){
            for(int j=0;j<=N;j++){
                for(int k=0;k<=Math.min(j,stackSize);k++){
                    dp[i+1][j]=Math.max(dp[i+1][j],stacks[i][k]+dp[i][j-k]);
                }
            }
        }
        for(int i=0;i<=N;i++){
            res=Math.max(res,dp[S][i]);
        }

        return res;
    }
}
