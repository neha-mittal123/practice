package GooglePractice;

import java.util.Collections;
import java.util.PriorityQueue;

public class SuperUglyNumber {
    public static void main(String[] args){
        int [] primes={2,7,13,19};
        int n=12;
        System.out.println(findSuperUglyNo(primes,n));
    }

    private static int findSuperUglyNo(int[] primes, int n) {
        if(n<=0){
            return -1;
        }
        if(n==1){
            return 1;
        }
        int count=1,no=0;
        PriorityQueue<Integer> minHeap=new PriorityQueue<>();
        for(int i:primes){
            minHeap.add(i);
        }
        while(count<n){
            no=minHeap.poll();
            if(no!=minHeap.peek()){
                count++;
                for(int i:primes){
                    minHeap.add(no*i);
                }
            }

        }
        return no;
    }
}
