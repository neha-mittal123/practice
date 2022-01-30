package com.streams;


import java.util.ArrayList;
import java.util.List;

public class FindMediansOfDataStreams {

	public static void main(String[] args) {
		List<Integer> list=new ArrayList<Integer>();
		list.add(12);
		list.add(4);
		list.add(5);
		list.add(3);
		list.add(8);
		list.add(7);
		List<Double> result=runningMedian(list);
		System.out.println(result);

	}

	private static List<Double> runningMedian(List<Integer> a) {
		List<Double> result = new ArrayList<Double>();
		int count=0;
        for(int i=0;i<a.size();i++){
            if(i%2!=0){
            	if(i==0) {
            		result.add((double)a.get(i));
            	}
            	count=i++;
                result.add((double)a.get(count/2));
               // System.out.println(a.get(count/2));
        }else{
            double temp=(a.get(i/2)+a.get(i/2+1))/2;
            //System.out.println(temp);
            result.add(temp);
        }
        }
        
        return result;
	}

}
