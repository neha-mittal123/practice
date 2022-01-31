package arrayPractice;

//Given an array arr[] of n integers, find the maximum that maximizes the sum of the value of i*arr[i] where i varies from 0 to n-1.
//
//        Examples:
//
//        Input: arr[] = {8, 3, 1, 2}
//        Output: 29
//        Explanation: Lets look at all the rotations,
//        {8, 3, 1, 2} = 8*0 + 3*1 + 1*2 + 2*3 = 11
//        {3, 1, 2, 8} = 3*0 + 1*1 + 2*2 + 8*3 = 29
//        {1, 2, 8, 3} = 1*0 + 2*1 + 8*2 + 3*3 = 27
//        {2, 8, 3, 1} = 2*0 + 8*1 + 3*2 + 1*3 = 17

public class MaximumRotatedSum {

    public static void main(String [] args){
        int[] arr={8,3,1,2};
        System.out.println(findMaxRotatedSum(arr));
    }

    private static int findMaxRotatedSum(int[] arr) {
        int result=0,maxSum=0,currVal=0,n=arr.length;

        for(int i=0;i<arr.length;i++){
            int temp=i*arr[i];
            currVal +=temp;
            maxSum +=arr[i];
        }
        result=currVal;
        for(int i=1;i<arr.length;i++){
            int nextVal=currVal-(maxSum-arr[i-1])+(n-1)*arr[i-1];
            currVal=nextVal;
            result=Math.max(result,currVal);
        }

        return result;
    }
}
