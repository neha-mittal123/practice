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

import java.util.Comparator;
import java.util.PriorityQueue;

public class SearchAndFindKthSmallestElementInTwoDimensionalSortedMatrix {
    static class Node{
        int val,row,col;
        Node(int val,int row,int col){
            this.val=val;
            this.row=row;
            this.col=col;
        }
        Node(){

        }

        @Override
        public String toString() {
            return val+" ";
        }
    }
    public static void main(String [] args){
        int mat[][] = { { 10, 20, 30, 40 },
                        { 15, 25, 35, 45 },
                        { 27, 29, 37, 48 },
                        { 32, 33, 39, 50 } };

        System.out.println(search(mat, mat.length, 9));
        System.out.println(findkthSmallest(mat,mat.length,7));
    }

    private static int findkthSmallest(int[][] mat, int length, int k) {
        PriorityQueue<Node> minHeap=new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.val-o2.val ;
            }
        });
        for(int i=0;i<length;i++){
            minHeap.add(new Node(mat[0][i],0,i));
        }
        for(int i=1;i<k;i++){
            Node currNode=minHeap.poll();
            Node nextNode=new Node(currNode.row<length-1 ? mat[currNode.row+1][currNode.col] :Integer.MAX_VALUE,currNode.row+1,currNode.col);
            minHeap.add(nextNode);
        }
        return minHeap.peek().val;
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
