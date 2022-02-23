package GooglePractice;

import java.util.Arrays;

public class FlattenTwoDimensionalArray {
    public static void main(String[] args){
        int [][] arr={{1,6,5,8},
                {9,3,2,1},
                {0,8,1,3}};
        int flatArr[]= Arrays.stream(arr).flatMapToInt(Arrays::stream).toArray();
        for(int i:flatArr){
            System.out.print(i+" ");
        }
    }
}