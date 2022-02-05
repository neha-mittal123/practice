package GooglePractice;

import java.util.ArrayList;

public class PrintMatrixInSpiralForm {

    public static void main(String[] args){
        int matrix[][] = { { 1, 2, 3, 4 },
                { 5, 6, 7, 8 },
                { 9, 10, 11, 12 },
                { 13, 14, 15, 16 } };
        int noOfRows=matrix.length;
        int noOfColumns=matrix[0].length;
        //spirallyTraverse(matrix,noOfRows,noOfColumns);
        iterativeSpiralTraversal(matrix,noOfRows,noOfColumns);
    }

    private static void iterativeSpiralTraversal(int[][] matrix, int noOfRows, int noOfColumns) {
        int m=0,n=0;
        while(m<noOfRows && n<noOfColumns){
            for(int i=n;i<noOfColumns;i++){
                System.out.print(matrix[m][i]+" ");
            }
            m++;
            for(int i=m;i<noOfRows;i++){
                System.out.print(matrix[i][noOfColumns-1]+" ");
            }
            noOfColumns--;
            for(int i=noOfColumns-1;i>=n;i--){
                System.out.print(matrix[noOfRows-1][i]+" ");
            }
            noOfRows--;
            for(int i=noOfRows-1;i>=m;i--){
                System.out.print(matrix[i][n]+" ");
            }
            n++;
        }
    }

    private static void spirallyTraverse(int[][] matrix, int noOfRows, int noOfColumns) {
        ArrayList<Integer> result= new ArrayList<>();
        spirallyTraverseUsingDFS(matrix,noOfRows,noOfColumns,0,0,0,result);
        for(Integer i:result){
            System.out.print(i+" ");
        }
    }

    private static void spirallyTraverseUsingDFS(int[][] matrix, int noOfRows, int noOfColumns, int i, int j, int direction,ArrayList<Integer> result) {
        if(isBlocked(matrix,i,j,noOfRows,noOfColumns)){
            return ;
        }
        boolean allBlocked=false;
        for(int index=-1;index<=1;index+=2){
            if(isBlocked(matrix,i,j+index,noOfRows,noOfColumns) && isBlocked(matrix,i+index,j,noOfRows,noOfColumns)){
                allBlocked=allBlocked && true;
            }
        }
        result.add(matrix[i][j]);
        matrix[i][j]=-1;
        if(allBlocked){
            return ;
        }
        int nextRow=i,nextCol=j,nextDir=direction;
        if(direction==0){
            if(!isBlocked(matrix,i,j+1,noOfRows,noOfColumns)){
                nextCol++;
            }else{
                nextDir=1;
                nextRow++;
            }
        }else if(direction==1){
            if(!isBlocked(matrix,i+1,j,noOfRows,noOfColumns)){
                nextRow++;
            }else{
                nextDir=2;
                nextCol--;
            }
        }else if(direction==2){
            if(!isBlocked(matrix,i,j-1,noOfRows,noOfColumns)){
                nextCol--;
            }else{
                nextDir=3;
                nextRow--;
            }
        }else if(direction==3){
            if(!isBlocked(matrix,i-1,j,noOfRows,noOfColumns)){
                nextRow--;
            }else{
                nextDir=0;
                nextCol++;
            }
        }
        spirallyTraverseUsingDFS(matrix,noOfRows,noOfColumns,nextRow,nextCol,nextDir,result);
    }

    private static boolean isBlocked(int[][] matrix, int i, int j, int noOfRows, int noOfColumns) {
        if(!isInBounds(i,j,noOfRows,noOfColumns)){
            return true;
        }
        if(matrix[i][j]==-1){
            return true;
        }
        return false;
    }

    private static boolean isInBounds(int i, int j, int noOfRows, int noOfColumns) {
        if(i>=0 && i<noOfRows && j>=0 && j<noOfColumns){
            return true;
        }
        return false;
    }
}
