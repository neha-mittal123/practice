package arrayPractice;

import javax.naming.InsufficientResourcesException;
import java.util.Collections;
import java.util.PriorityQueue;

public class FindNonOverlappingIntervalsAmongGivenSetOfIntervalsUsingHeap {
    static class Interval{
        int startTime;
        int endTime;
        Interval(int startTime,int endTime){
            this.startTime=startTime;
            this.endTime=endTime;
        }
    }

    public static void main(String[] args){
        int[][] arr = { {1, 3}, {9, 12}, {2, 4}, {6, 8} };
        Interval[] intervals=new Interval[arr.length];
        for(int i=0;i<arr.length;i++){
            intervals[i]=new Interval(arr[i][0],arr[i][1]);
        }
        findFreeInterval(intervals);
    }

    private static void findFreeInterval(Interval[] intervals) {
        PriorityQueue<Interval> minHeap=new PriorityQueue<>((a, b)->a.startTime-b.startTime);
        for(Interval i: intervals){
            minHeap.add(i);
        }
        Interval[] freeIntervals=new Interval[intervals.length];
        Interval prevInterval=minHeap.remove();
        int count = 0;
        while(minHeap.size()>0){
            Interval interval=minHeap.remove();
            if(prevInterval.endTime >interval.startTime && prevInterval.endTime < interval.endTime){
                prevInterval = interval;
                continue;
            }else{
                freeIntervals[count] = new Interval(prevInterval.endTime,interval.startTime);
                count++;

            }
            prevInterval = interval;
        }
        for(Interval i: freeIntervals){
            if(count>0){
                System.out.println(i.startTime+" "+i.endTime);
                count--;
            }else{
                break;
            }

        }
    }
}
