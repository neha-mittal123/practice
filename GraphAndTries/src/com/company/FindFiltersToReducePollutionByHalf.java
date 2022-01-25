package com.company;

import java.util.Collections;
import java.util.PriorityQueue;

public class FindFiltersToReducePollutionByHalf {
    public  static void main(String[] args){
        int [] arr={3,0,5};
        PriorityQueue<Double> queue=new PriorityQueue<>(Collections.reverseOrder());
        double currsum=0;
        for(int i:arr){
            currsum +=i;
            queue.add(Double.valueOf(i));
        }
        double initialSum=currsum;
        int filters=0;
        while(currsum>initialSum/2){
            double element=queue.remove();
            element=element/2;
            currsum=currsum-element;
            filters++;
        }
        System.out.println(filters);
    }
}
