package GooglePractice;

//Implement the next permutation, which rearranges the list of numbers into Lexicographically next greater permutation of list of numbers. If such arrangement is
//        not possible, it must be rearranged to the lowest possible order i.e. sorted in an ascending order. You are given an list of numbers arr[ ] of size N.


import java.util.Arrays;

public class NextPermutation {

    static  int[] arr={1, 2, 4, 6, 5, 3,2};
    public static void main(String[] args){
        findNextPermut();
        for(int i:arr)
        System.out.print(i+" ");
    }

    private static void findNextPermut() {
        if(arr.length==1){
            return;
        }
        int lastPeakPos=-1;
        for(int i=1;i<arr.length;i++){
            if(arr[i]>arr[i-1]){
                lastPeakPos=i;
            }
        }
        if(lastPeakPos==-1){
            return;
        }
        int index=lastPeakPos,temp=lastPeakPos-1;
        for(int i=index;i<arr.length-1;i++){
            if(arr[i+1]<arr[i] && arr[i+1]>arr[i-1]){
                lastPeakPos=i+1;
            }
        }
        swap(lastPeakPos,temp);
        Arrays.sort(arr,lastPeakPos+1,arr.length);

    }
    private static void swap(int a,int b){
        if(a==b)
            return;
        int temp=arr[a];
        arr[a]=arr[b];
        arr[b]=temp;
    }
}
