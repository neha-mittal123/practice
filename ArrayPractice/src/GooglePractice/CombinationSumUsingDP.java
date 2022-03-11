package GooglePractice;

public class CombinationSumUsingDP {
    public static void main(String[] args){
        int [] nums={1,2,3};
        int targetSum=4;
        System.out.print(findNoOfWays(nums,targetSum));
    }

    private static int findNoOfWays(int[] nums, int targetSum) {
        int[] dp=new int[targetSum+1];
        dp[0]=1;
        for(int i=1;i<=targetSum;i++){
            for(int j=0;j<nums.length;j++){
                if(i-nums[j]>=0){
                    dp[i] +=dp[i-nums[j]];
                }
            }
        }
        return dp[targetSum];
    }
}
