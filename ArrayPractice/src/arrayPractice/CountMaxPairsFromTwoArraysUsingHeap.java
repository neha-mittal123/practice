package arrayPractice;

//Count of pairs from arrays A and B such that element in A is greater than element in B at that index
//
//Given two arrays A[] and B[] of size N, the task is to count the maximum number of pairs, where each pair contains one from each array,
// such that A[i] > B[i]. Also the array A can be rearranged any number of times.
//
//        Examples:
//
//        Input: A[] = {20, 30, 50}, B[]= {60, 40, 25}
//        Output: 2
//        Explanation:
//        Initially:
//        A[0] = 20 < B[0] = 60
//        A[1] = 30 < B[1] = 40
//        A[2] = 50 > B[2] = 25
//        Clearly, this arrangement has only 1 value such that A[i] > B[i].
//        This array A[] when rearranged to {20, 50, 30}:
//        A[0] = 20 < B[0] = 60
//        A[1] = 50 > B[1] = 40
//        A[2] = 30 > B[2] = 25
//        2 values follow the condition A[i] > B[i] which is the maximum for these set of arrays.

import java.util.Collections;
import java.util.PriorityQueue;

public class CountMaxPairsFromTwoArraysUsingHeap {

    public static void main(String [] args){
        int arr1[] = { 20,30,50 };
        int arr2[] = { 60,40,25};
        PriorityQueue<Integer> maxHeapForArr1=new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> maxHeapForArr2=new PriorityQueue<>(Collections.reverseOrder());
        for(int i:arr1){
            maxHeapForArr1.add(i);
        }
        for(int i:arr2){
            maxHeapForArr2.add(i);
        }
        System.out.println(findMaxPairsCount(maxHeapForArr1,maxHeapForArr2));

    }

    private static int findMaxPairsCount(PriorityQueue<Integer> maxHeapForArr1, PriorityQueue<Integer> maxHeapForArr2) {
        int counter=0;
        while (maxHeapForArr1.size() >= 0) {
            if(maxHeapForArr1.peek()>maxHeapForArr2.peek()){
                counter++;
                maxHeapForArr1.poll();
                maxHeapForArr2.poll();
            }else{
                maxHeapForArr2.poll();
            }
            if(maxHeapForArr2.size()==0){
                break;
            }
        }
        return counter;
    }
}
