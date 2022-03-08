package GooglePractice;

import java.util.Arrays;

public class LargestDivisibleSubSetInArray {
    public static void main(String[] args){
        int[] arr = { 1, 2, 17, 4};
        Arrays.sort(arr);
        findLargestDivisibleSubSet(arr);
    }

    private static void findLargestDivisibleSubSet(int[] arr) {
        int[] divCount=new int[arr.length];
        Arrays.fill(divCount,1);
        int[] prev=new int[arr.length];
        Arrays.fill(prev,-1);
        int maxIndex=0;
        for(int i=1;i<arr.length;i++){
            for(int j=0;j<i;j++){
                if(arr[i]%arr[j]==0 && divCount[i]<divCount[j]+1 ){
                    divCount[i]=divCount[j]+1;
                    prev[i]=j;
                }
            }
            if(divCount[i]>divCount[maxIndex]){
                maxIndex=i;
            }
        }
        while(maxIndex>=0){
            System.out.print(arr[maxIndex]+" ");
            maxIndex=prev[maxIndex];
        }
    }
}
