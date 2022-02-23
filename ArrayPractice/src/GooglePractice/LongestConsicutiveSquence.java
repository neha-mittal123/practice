package GooglePractice;

import java.util.HashSet;
import java.util.Set;

public class LongestConsicutiveSquence {
    public static void main(String[] args){
        int [] arr ={100,4,99,1,3,2};
        int result=findLongestStreak(arr);
        System.out.print(result);
    }

    private static int findLongestStreak(int[] nums) {
        Set<Integer> num_set = new HashSet<Integer>();
        for (int num : nums) {
            num_set.add(num);
        }

        int longestStreak = 0;

        for (int num : num_set) {
            if (!num_set.contains(num-1)) {
                int currentNum = num;
                int currentStreak = 1;

                while (num_set.contains(currentNum+1)) {
                    currentNum += 1;
                    currentStreak += 1;
                }

                longestStreak = Math.max(longestStreak, currentStreak);
            }
        }

        return longestStreak;
    }
}