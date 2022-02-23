package GooglePractice;

//Given an array of n integers nums and a target, find the number of index triplets i, j, k with 0 <= i < j < k < n that satisfy the condition nums[i] + nums[j] + nums[k] < target.
//        For example, given nums = [-2, 0, 1, 3], and target = 2.
//        Return 2. Because there are two triplets which sums are less than 2:
//        [-2, 0, 1]
//        [-2, 0, 3]
//        Follow up:
//        Could you solve it in O(n2) runtime?

import java.util.Arrays;

public class ThreeSumSmaller {
    public static void main(String [] args){
        int [] nums={-2,0,1,3};
        int target=2;
        findTriplets(nums,target);
    }

    private static void findTriplets(int[] nums, int target) {
        Arrays.sort(nums);
        int counter=0;
        for(int i=0;i<nums.length-1;i++){
            int l=i+1,r=nums.length-1,x=nums[i];
            while(l<=r){
                if(nums[l]+nums[r]+x<target){
                    l++;
                    counter++;
                }else{
                    r--;
                }
            }
        }
        System.out.print(counter);
    }
}