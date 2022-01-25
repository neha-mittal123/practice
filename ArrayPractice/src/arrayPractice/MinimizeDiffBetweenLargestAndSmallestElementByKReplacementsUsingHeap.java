package arrayPractice;

//Given an array A[] consisting of N integers, the task is to find the minimum difference between the largest and the smallest element in the given array after replacing K elements.
//
//        Examples:
//
//        Input: A[] = {-1, 3, -1, 8, 5, 4}, K = 3
//        Output: 2
//        Explanation:Replace A[0] and A[2] by 3 and 4 respectively. Replace A[3] by 5. Modified array A[] is {3, 3, 4, 5, 5, 4}. Therefore, required output = (5-3) = 2.

import java.util.*;

public class MinimizeDiffBetweenLargestAndSmallestElementByKReplacementsUsingHeap {

    public static void main(String[] args){
        int A[] = { -1, 3, -1, 8, 5, 4 };
        int K = 3;
        System.out.println(findMinDiff(A,K));
    }

    private static int findMinDiff(int[] a, int k) {
        int minDiff=Integer.MAX_VALUE;
        PriorityQueue<Integer> minHeap=new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap=new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });
        for(int i:a){
            maxHeap.add(i);
            if(maxHeap.size()>k+1){
                maxHeap.remove();
            }
            minHeap.add(i);
            if(minHeap.size()>k+1){
                minHeap.remove();
            }
        }
        ArrayList<Integer> maxList=new ArrayList<>();
        while(maxHeap.size()>0){
            maxList.add(maxHeap.remove());
        }
        ArrayList<Integer> minList=new ArrayList<>();
        while(minHeap.size()>0){
            minList.add(minHeap.remove());
        }
        for(int i=0;i<=k;i++){
            minDiff=Math.min(minDiff,minList.get(i)-maxList.get(k-i));
        }

        return minDiff;
    }

}
