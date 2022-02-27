package GooglePractice;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class GreatestPalindromeNumber {
    public static void main(String[] args){
        String s="39878";
        System.out.println(findGreatestPalindromeNumber(s));
    }

    private static String findGreatestPalindromeNumber(String s) {
        HashMap<Integer,Integer>map=new HashMap<>();
        for(int i=0;i<s.length();i++){
            if(map.containsKey(s.charAt(i)-'0')){
                map.put(s.charAt(i)-'0',map.get(s.charAt(i)-'0')+1);
            }else{
                map.put(s.charAt(i)-'0',1);
            }
        }
        PriorityQueue<Integer> maxHeap=new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> minHeap=new PriorityQueue<>();
        for(Map.Entry entry:map.entrySet()){
            if((int)entry.getValue()==1){
                maxHeap.add((int)entry.getKey());
            }
            if((int)entry.getValue()==2){
                if((int)entry.getKey()!=0){
                    minHeap.add((int)entry.getKey());
                }
            }
        }
        String res=String.valueOf(maxHeap.poll())+"";
        while(minHeap.size()!=0){
            res=String.valueOf(minHeap.peek())+res+String.valueOf(minHeap.peek());
            minHeap.poll();
        }

        return res;
    }
}
