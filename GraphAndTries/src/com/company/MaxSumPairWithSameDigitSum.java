package com.company;

import java.util.HashMap;

public class MaxSumPairWithSameDigitSum {
    public static void main(String[] args){
        int [] arr={55,23,32,46,88};
        int res=findMaxSum(arr);
        System.out.println(res);
    }

    private static int findMaxSum(int[] arr) {
        int res=0;
        HashMap<Integer,Integer>map=new HashMap<>();
        for(int i=0;i<arr.length;i++){
            int temp=digitSum(arr[i]);
            if(map.containsKey(temp)){
                if(map.get(temp)+arr[i]>res){
                    res=map.get(temp)+arr[i];
                }else{
                    map.put(temp,Math.max(arr[i],map.get(temp)));
                }
            }else{
                map.put(temp,arr[i]);
            }
        }
        return res;
    }

    private static int digitSum(int i) {
        int sum=0;
        while(i>0){
            sum += i%10;
            i /= 10;
        }
        return sum;
    }
}
