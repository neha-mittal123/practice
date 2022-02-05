package GooglePractice;

//Given a sorted integer array nums, where the range of elements are in the inclusive range [lower, upper], return its missing ranges.
//        Example:
//        Input: nums = [0, 1, 3, 50, 75], lower = 0 and upper = 99,
//        Output: ["2", "4->49", "51->74", "76->99"]

import java.util.ArrayList;

public class MissingRanges {
    public static void main(String [] args){
        int[] arr={0, 1, 3, 50, 75};
        int lower=-2,upper=99;
        for(String s: findMissingRanges(arr,lower,upper))
            System.out.print(s+" ");
    }

    private static ArrayList<String> findMissingRanges(int[] arr, int lower, int upper) {
        ArrayList<String> result=new ArrayList<>();
        if(arr[0]!=lower){
            result.add(calcRange(lower,arr[0]-1));
        }
        for(int i=1;i<arr.length;i++){
            if(arr[i-1]+1==arr[i]){
                continue;
            }else{
                result.add(calcRange(arr[i-1]+1,arr[i-1]+2==arr[i]?0:arr[i]-1));
            }
        }
            if(arr[arr.length-1]!=upper){
                result.add(calcRange(arr[arr.length-1]+1,upper));
            }
        return result;
    }

    private static String calcRange(int i, int j) {
        StringBuilder sb=new StringBuilder();
        sb.append(Integer.toString(i));
        if(j==0)
        return sb.toString();
        sb.append("->").append(Integer.toString(j));
        return sb.toString();
    }
}
