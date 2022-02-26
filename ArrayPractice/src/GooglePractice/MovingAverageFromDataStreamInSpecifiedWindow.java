package GooglePractice;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class MovingAverageFromDataStreamInSpecifiedWindow {
    static int maxSize;
    static LinkedList<Integer> window;
    static long sum;

    MovingAverageFromDataStreamInSpecifiedWindow(int maxSize){
        this.maxSize=maxSize;
        this.window=new LinkedList<>();
        this.sum=0;
    }
    public static void main(String[] args){
        MovingAverageFromDataStreamInSpecifiedWindow element=new MovingAverageFromDataStreamInSpecifiedWindow(3);
        int[] stream={1,2,3,4,5,6};
        for(int i:stream){
            System.out.print(findAvg(i)+" ");
        }

    }

    private static double findAvg(int i) {
        window.addLast(i);
        sum +=i;
        if(window.size()>maxSize){
            sum -=window.removeFirst();
        }
        return (double) sum/window.size();
    }
}
