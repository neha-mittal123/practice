package GooglePractice;

import java.util.*;

public class GreatestPalindromeNumber {
    static class Node{
        int key,value;
        Node(int key,int value){
            this.key=key;
            this.value=value;
        }

        @Override
        public String toString() {
            return  key+"" ;
        }
    }
    public static void main(String[] args){
        String s="333399987888";
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
        PriorityQueue<Node> maxHeap=new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o2.key-o1.key;
            }
        });
        PriorityQueue<Node> minHeap=new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.key- o2.key;
            }
        });
        for(Map.Entry entry:map.entrySet()){
            if((int)entry.getValue()%2==1){
                maxHeap.add(new Node((int)entry.getKey(),(int)entry.getValue()));
            }
            if((int)entry.getValue()%2==0){
                if((int)entry.getKey()!=0){
                    minHeap.add(new Node((int)entry.getKey(),(int)entry.getValue()));
                }
            }
        }
        String res=String.valueOf(maxHeap.peek().key)+"";
        minHeap.add(new Node(maxHeap.peek().key,maxHeap.poll().value-1));
        while(minHeap.size()!=0){
            Node temp = null;
            if(minHeap.peek().value>0){
                 temp=minHeap.poll();
            }else
            {
                minHeap.poll();
                continue;
            }
            res=temp.key+res+temp.key;
            if(temp.value==0){
                minHeap.poll();
            }else{
                minHeap.add(new Node(temp.key,temp.value-2));
            }
        }

        return res;
    }
}
