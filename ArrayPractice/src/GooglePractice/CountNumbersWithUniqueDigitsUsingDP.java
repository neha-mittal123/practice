package GooglePractice;

public class CountNumbersWithUniqueDigitsUsingDP {
    public static void main(String[] args){
        int n=2;
        System.out.println(findCountOfUniqueDigitsNumbers(n));
    }

    private static int findCountOfUniqueDigitsNumbers(int n) {
        if(n==0){
            return 1;
        }
        if(n==1){
            return 10;
        }
        int [] dp=new int[n+1];
        dp[0]=1;
        dp[1]=10;
        for(int i=2;i<=n;i++){
            int ones=9;
            int tens=9;
            int temp=i;
            while(temp!=1){
                ones=ones*tens;
                tens--;
                temp--;
            }
            dp[i]=dp[i-1]+ones;
        }
        return dp[n];
    }
}
