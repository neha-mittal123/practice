package GooglePractice;

public class WiggleSort {
    static  int arr[] = {5,5,5,4,4,4,4};
    public static void main(String[] args){

        //wiggleSort(arr);
        zigZag(arr);
        for(int i:arr)
            System.out.print(i+" ");
    }

    private static void wiggleSort(int[] arr) {
        int prev=0;
        boolean equal=true;
        for(int i=1;i<arr.length;){
            if(i>0 && arr[i]<arr[i-1]){
                swap(i,i-1);
                i=i+2;
            }
            if(i<arr.length-1 && arr[i]<arr[i+1]){
                swap(i,i+1);
                i=i+2;
            }
            if(i>0 && arr[i]==arr[i-1]){
                if(equal) {
                    prev = i - 1;
                }
                equal=false;
                i++;
            }else{
                swap(prev,i);
                prev=prev+2;
            }
        }
    }
    static void zigZag(int [] arr)
    {
        // Flag true indicates relation "<" is expected,
        // else ">" is expected. The first expected relation
        // is "<"
        boolean flag = true;

        int temp =0;

        for (int i=0; i<=arr.length-2; i++)
        {
            if (flag) /* "<" relation expected */
            {
                /* If we have a situation like A > B > C,
                we get A > B < C by swapping B and C */
                if (arr[i] > arr[i+1])
                {
                    // swap
                    temp = arr[i];
                    arr[i] = arr[i+1];
                    arr[i+1] = temp;
                }

            }
            else /* ">" relation expected */
            {
                /* If we have a situation like A < B < C,
                we get A < C > B by swapping B and C */
                if (arr[i] < arr[i+1])
                {
                    // swap
                    temp = arr[i];
                    arr[i] = arr[i+1];
                    arr[i+1] = temp;
                }
            }
            flag = !flag; /* flip flag */
        }
    }

    private static void swap(int i, int j) {
        int temp=0;
        temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
}