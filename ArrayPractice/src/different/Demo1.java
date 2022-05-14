package different;

import java.util.HashMap;

public class Demo1 {

    public static void main(String args[]){
        int[] arr = {5,10,15,17,20,14,12};
        int start = 0;
        int end = arr.length;
        int pivot = findPivot(arr,start,end);
    }

    public static int findPivot(int[] arr,int start,int end){
        int mid = start+end/2;

        if(arr[mid-1]<arr[mid] && arr[mid]>arr[mid+1]){
            return mid;
        }else{
            findPivot(arr,start,mid);
            findPivot(arr,mid+1,end);
        }
        return -1;
    }

    public int findElement(int[] arr,int start,int end,int pivot,int number){
        if(number == arr[pivot]){
            return pivot;
        }
        if(number > arr[pivot+1]){
            return findNumber(arr,start,pivot-1,number);
        }else{
            int position = -1;
                position    = findNumber(arr,start,pivot-1,number);
            if(position == -1){
                position = findNumber(arr,pivot+1,end,number);
            }
        }
        return 1;
    }

    private int findNumber(int[] arr, int start, int end, int number) {
        int mid = start+end/2;

        if(number == arr[mid]){
            return mid;
        }else if(number < arr[mid]){
            findNumber(arr,start,mid-1,number);
        }else{
            findNumber(arr,mid+1,end,number);
        }
        return -1;
    }

    public boolean findPairs(int[] arr, int sum){
        HashMap<Integer,Integer> map = new HashMap<>();

        for(Integer i : arr){
            if(map.containsKey(sum - i)){
                return true;
            }
            map.put(i,i);
        }
        return false;
    }
}
