package arrayPractice;

public class SearchOrInsertElementInSortedArray {
    public static void main(String[] args){
        int [] arr={1,3,5,7,9};
        int input=4;
        int result = -1;
        int start = 0;
        int end = arr.length-1;
        while(start <=end ){
            int mid = (start+end)/2;
            if(input > arr[mid]){
                start = mid+1;
            }else if(input < arr[mid]){
                end = mid-1;
            }else{
                System.out.println("mid : "+mid);
                break;
            }
            result = mid;
        }
        if(arr[result]>input){
            result = result;
        }else{
            result = result+1;
        }

        System.out.println("pos : "+result);



    }
}
