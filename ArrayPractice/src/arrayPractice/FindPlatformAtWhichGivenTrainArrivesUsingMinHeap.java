package arrayPractice;

//Given a 2D array arr[][3] consisting of information of N trains where arr[i][0] is the train number, arr[i][1] is the arrival time, and arr[i][2] is the duration of stoppage time. Given another integer F representing the train number, the task is to find the platform number on which the train with train number F arrives according to the following rules:
//
//        Platform numbering starts from 1 and there is an infinite number of platforms.
//        The platform which is freed earlier is allocated to the next train.
//        If two or more platforms are freed at the same time then the train arrives at the platform with the lowest platform number.
//        If two or more trains arriving at the same time, then the train with a smaller train number is allocated first.
//        Examples:
//
//        Input: arr[] = {{112567, 1, 2}, {112563, 3, 3}, {112569, 4, 7}, {112560, 9, 3}}, F = 112569
//        Output: 1
//        Explanation:
//        Below is the order of the arrival of trains:
//        Train          Platform   Leaving Time
//        112567        1               4
//        112563        2               7
//        112569       1              12
//        112560       2              13
//
//        Therefore, the train with train number 112569 arrives at platform number 1.

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.PriorityQueue;

public class FindPlatformAtWhichGivenTrainArrivesUsingMinHeap {
    static HashMap<Integer,Integer> mapOfTrainAndPlatform=new HashMap<>();
    static PriorityQueue<int[]> queueOfPlatformNoAndDepartureTime=new PriorityQueue<>((a,b)->a[1]==b[1] ? a[0] -b[0] : a[1]-b[1] );
    static class Train{
        int trainNumber;
        int arrivalTime;
        int stoppageTime;
        Train(int trainNumber,int arrivalTime,int stoppageTime){
            this.trainNumber=trainNumber;
            this.arrivalTime=arrivalTime;
            this.stoppageTime=stoppageTime;
        }
    }
    public static void main(String [] args){
        ArrayList<Train> trains=new ArrayList<>();
        trains.add(new Train(112567, 2, 1));
        trains.add(new Train(
                112569, 5, 5));
        trains.add(new Train(
                112563, 5, 3));
        trains.add(new Train(
                112560, 3, 7));
        int F=112563;
        System.out.print(findPlatform(trains,F));
    }

    private static int findPlatform(ArrayList<Train> trains, int f) {
        Collections.sort(trains,(a,b)->a.arrivalTime==b.arrivalTime ? a.trainNumber-b.trainNumber : a.arrivalTime-b.arrivalTime);
        queueOfPlatformNoAndDepartureTime.add(new int[]{1,0});
        for(Train train:trains){
            int [] freePlatform=queueOfPlatformNoAndDepartureTime.poll();
            if(train.arrivalTime>=freePlatform[1]){
                freePlatform[1]=train.arrivalTime+train.stoppageTime+1;
                queueOfPlatformNoAndDepartureTime.add(freePlatform);
                mapOfTrainAndPlatform.put(train.trainNumber,freePlatform[0]);
            }else{
                queueOfPlatformNoAndDepartureTime.add(freePlatform);
                int platform=queueOfPlatformNoAndDepartureTime.size()+1;
                mapOfTrainAndPlatform.put(train.trainNumber,platform);
                queueOfPlatformNoAndDepartureTime.add(new int[]{platform,train.arrivalTime+train.stoppageTime+1});
            }
        }
        return mapOfTrainAndPlatform.get(f);
    }
}
