package com.company;

import java.util.*;
import java.util.Collections;

public class TrieWithBitManipulation {

     static class Node{
        TrieWithBitManipulation.Node[] trieNodes=new Node[2];

        boolean containsKey(int bit){
            return trieNodes[bit]!=null;
        }

        Node getNode(int bit){
            return trieNodes[bit];
        }

        void putNode(int bit){
            trieNodes[bit] = new Node();
        }
    }

    public static  void main(String args[]){
         Node root=new Node();
        int[] arr1 = {6, 6, 0, 6, 8, 5, 6};
        int[] arr2 = {1, 7, 1, 7, 8, 0, 2};

        for(Integer i : arr1){
            insert(i,root);
        }
        int maxXor=0;
        for(Integer i : arr2){
            maxXor=Math.max(maxXor,getMax(i,root));
        }
        System.out.println("max xor="+maxXor);

        Node root1=new Node();
        int [] nums={5,2,4,6,6,3};
        ArrayList<ArrayList<Integer>> offlineQueries = new ArrayList<ArrayList<Integer>>();
        findMaxXorUtil(nums,offlineQueries);
        for(Integer i : findMaxXor(nums,offlineQueries,root1)){
            System.out.println(i);
        }

        Node root2=new Node();

    }

    private static int getMax(Integer number, Node root) {
        int max=0;
        Node node=root;
        for(int i=31;i>=0;i--){
            int bit=(number >> i) & 1;
            if(node.containsKey(1-bit)){
                max=max | 1 << i;
                node=node.getNode(1-bit);
            }else{
                node=node.getNode(bit);
            }
        }
        return max;
    }

    private static void insert(Integer number, Node root) {
        Node node=root;
        for(int i=31;i>=0;i--){
            int bit=(number >> i) & 1;
            if(!node.containsKey(bit)){
                node.putNode(bit);
            }
            node=node.getNode(bit);
        }
    }

    private static void findMaxXorUtil(int[] nums, ArrayList<ArrayList<Integer>> offlineQueries) {
        Arrays.sort(nums);
        ArrayList<Integer> temp = new ArrayList<Integer>();
        temp.add(4);
        temp.add(12);
        temp.add(0);
        offlineQueries.add(temp);
        ArrayList<Integer> temp1 = new ArrayList<Integer>();
        temp1.add(1);
        temp1.add(8);
        temp1.add(1);
        offlineQueries.add(temp1);
        ArrayList<Integer> temp2 = new ArrayList<Integer>();
        temp2.add(3);
        temp2.add(6);
        temp2.add(2);
        offlineQueries.add(temp2);
        Collections.sort(offlineQueries, new Comparator<ArrayList<Integer>> () {
            @Override
            public int compare(ArrayList<Integer> a, ArrayList<Integer> b) {
                return a.get(0).compareTo(b.get(0));
            }
        });
        for(ArrayList<Integer> i : offlineQueries){
            System.out.println(i);
        }
    }

    private static int[] findMaxXor(int[] nums, ArrayList<ArrayList<Integer>> offlineQueries, Node root) {
        int[] ans = {-1, -1, -1};
        int index = 0;
        for (int i = 0; i < 3; i++) {
            while (index < nums.length && nums[index] <= offlineQueries.get(i).get(0)) {
                int temp = nums[index];
                insert(temp, root);
                index++;
            }
            if (index == 0) {
                ans[offlineQueries.get(i).get(2)] = -1;
            } else {
                ans[offlineQueries.get(i).get(2)] = getMax(offlineQueries.get(i).get(1), root);
            }
        }
        return ans;
    }

}
