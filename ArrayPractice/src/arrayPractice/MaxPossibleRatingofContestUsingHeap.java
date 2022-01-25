package arrayPractice;

//Given two arrays of positive integer Point[], Upvote[] of size N and a value K (1 <= K <= N). The task is to choose atleast K elements(Problems) such that the rating of the coding contest is maximum.
//
//        Rating of contest: Rating of a contest is defined as total points of all problems in the contest multiplied by the minimum upvotes among all problems in the contest
//
//        Hence, Rating = sum of points of contest problems * minimum upvotes among contest problems.
//
//        Examples:
//
//        Input: Point[] = {2, 10, 3, 1, 5, 8}, Upvote[] = {5, 4, 3, 9, 7, 2}, K = 2
//        Output: 60
//        Explanation:
//        Here we select 2nd and 5th problem to get the maximum rating of the contest.
//        So maximum rating is (10 + 5) * min(4, 7) = 60

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MaxPossibleRatingofContestUsingHeap {

    static class Pair{
        int point,upvote;
        Pair(int point,int upvote){
            this.point=point;
            this.upvote=upvote;
        }
        Pair(){

        }
    }
    public static void main(String [] args){
        int point[] = {2, 10, 3, 1, 5, 8};
        int upvote[] = {5, 4, 3, 9, 7, 2}, k = 3;
        PriorityQueue<Pair> minHeap=new PriorityQueue<>(new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                return o1.point-o2.point;
            }
        });
        PriorityQueue<Pair> maxHeap=new PriorityQueue<>(new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                return o2.upvote-o1.upvote;
            }
        });
        for(int i=0;i<upvote.length;i++){
            Pair pair=new Pair(point[i],upvote[i]);
            maxHeap.add(pair);
        }
        int maxRate=findMaxRating(minHeap,maxHeap,k);
        System.out.println(maxRate);
    }

    private static int findMaxRating(PriorityQueue<Pair> minHeap, PriorityQueue<Pair> maxHeap,int k) {
        int counter=0,maxRate=Integer.MIN_VALUE;
        while(counter!=k){
            minHeap.add(maxHeap.poll());
            counter++;
        }
        int n=maxHeap.size();
        for(int i=0;i<n;i++){
            int temp=0;
            Pair pair1=minHeap.poll();
            Pair pair2=minHeap.peek();
            temp=(pair1.point+pair2.point)*Math.min(pair1.upvote,pair2.upvote);
            maxRate=Math.max(maxRate,temp);
            minHeap.add(maxHeap.poll());
        }

        return maxRate;
    }
}
