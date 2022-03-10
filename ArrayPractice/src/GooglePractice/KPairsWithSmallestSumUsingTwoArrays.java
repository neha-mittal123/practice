package GooglePractice;

public class KPairsWithSmallestSumUsingTwoArrays {
    public static void main(String[] args){
        int arr1[] = {1, 4, 11};
        int n1 = arr1.length;

        int arr2[] = {2, 4, 8};
        int n2 = arr2.length;

        int k = 4;
        kSmallestPair( arr1, n1, arr2, n2, k);
    }

    private static void kSmallestPair(int[] arr1, int n1, int[] arr2, int n2, int k) {
        int index[]=new int[n1];
        while(k>0){
            int minSum=Integer.MAX_VALUE;
            int minIndex=0;
            for(int i=0;i<n1;i++){
                if(index[i]<n2 && arr1[i]+arr2[index[i]]<minSum){
                    minIndex=i;
                    minSum=arr1[i]+arr2[index[i]];
                }
            }
            System.out.println(arr1[minIndex]+","+arr2[index[minIndex]]);
            index[minIndex]++;
            k--;
        }
    }
}
