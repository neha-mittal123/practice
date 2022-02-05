package GooglePractice;

//Write an efficient algorithm that searches for a value target in an m x n integer matrix matrix. This matrix has the following properties:
//
//        Integers in each row are sorted in ascending from left to right.
//        Integers in each column are sorted in ascending from top to bottom.
//
//        Example:
//
//        Input: mat[4][4] = { {10, 20, 30, 40},
//        {15, 25, 35, 45},
//        {27, 29, 37, 48},
//        {32, 33, 39, 50}};
//        x = 29
//        Output: Found
//        Explanation: Element at (2,1) is 29
//
//        Input : mat[4][4] = { {10, 20, 30, 40},
//        {15, 25, 35, 45},
//        {27, 29, 37, 48},
//        {32, 33, 39, 50}};
//        x = 100
//        Output :  not found
//        Explanation: Element 100 is not found

public class SearchInTwoDimensionalMatrix {
    public static void main(String [] args){
        int mat[][] = { { 10, 20, 30, 40 },
                { 15, 25, 35, 45 },
                { 27, 29, 37, 48 },
                { 32, 33, 39, 50 } };

        System.out.println(search(mat, mat.length, 9));
    }

    private static String search(int[][] mat, int length, int x) {
       boolean result=false;
        int i=0,j=length-1;
        while(i<length && j>=0){
            if(mat[i][j]==x){
                return "found";
            }else if(mat[i][j]<x){
                i++;
            }else{
                j--;
            }
        }
        return result?"found":"not found";
    }

}
