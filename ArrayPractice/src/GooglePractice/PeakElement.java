package GooglePractice;

//Given an array of integers. Find a peak element in it. An array element is a peak if it is NOT smaller than its neighbours. For corner elements, we need to consider only one neighbour.
//
//        Example:
//
//        Input: array[]= {5, 10, 20, 15}
//        Output: 20
//        The element 20 has neighbours 10 and 15,
//        both of them are less than 20.
//
//        Input: array[] = {10, 20, 15, 18, 23, 90, 100}
//        Output: 20 or 90
//        The element 20 has neighbours 10 and 15,
//        both of them are less than 20, similarly 90 has neighbours 23 and 67.

public class PeakElement {
    public static void main(String [] args){
        int arr[] = { 10, 20, 15, 18, 23, 90, 100};
        System.out.println(findPeakElement(arr,0,arr.length-1));
    }

    private static int findPeakElement(int[] arr, int low, int high) {
        int mid=low+(high-low)/2;
        if((mid==0 ||arr[mid]>arr[mid-1]) && (mid==arr.length-1 || arr[mid]>arr[mid+1])) {
            return arr[mid];
        }else if(mid>0 && arr[mid-1]>arr[mid]){
            return findPeakElement(arr,low,mid-1);
        }else{
            return findPeakElement(arr,mid+1,high);
        }

    }
}
