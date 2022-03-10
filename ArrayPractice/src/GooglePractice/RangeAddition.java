package GooglePractice;

public class RangeAddition {
    public static void main(String [] args){
        int N=6;
        int[][] updates={{0,2,100},
                         {1,5,100},
                         {2,3,100}};
        int row=updates.length;
        int[] result=new int[N];
        for(int i=0;i<row;i++){
            add(N,updates[i],result);
        }
        printArray(result);
    }

    private static void printArray(int[] result) {
        for(int i=1;i<result.length;i++){
            result[i] +=result[i-1];
        }
        for(int i:result){
            System.out.print(i+" ");
        }
    }

    private static void add(int n, int[] updates, int[] result) {
        result[updates[0]] +=updates[2];
        if(updates[1]!=n-1){
            result[updates[1]+1] -=updates[2];
        }
    }
}
