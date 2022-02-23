package GooglePractice;

import arrayPractice.RottenOrangesUsingQueueBFS;

import java.util.LinkedList;

public class WallsAndGates {
    static class Node{
        int i,j,dist;
        Node(int i,int j,int dist){
            this.i=i;
            this.j=j;
            this.dist=dist;
        }
    }
    public static void main(String[] args){
        int [][] arr={{40,-1,0,40},
                {40,40,40,-1},
                {40,-1,40,-1},
                {0,-1,40,40}};
        fillemptyRoomWithNearestDistGate(arr);
    }

    private static void fillemptyRoomWithNearestDistGate(int[][] arr) {
        int row= arr.length;
        int col=arr[0].length;
        int dist=0;
        LinkedList<Node> queue=new LinkedList<Node>();
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(arr[i][j]==0){
                    Node temp=new Node(i,j,dist);
                    queue.addLast(temp);
                }
            }
        }
        while(!queue.isEmpty()){
            Node node=queue.removeFirst();
            if(isSafe(node.i+1,node.j,row,col) && arr[node.i+1][node.j]==40){
                arr[node.i+1][node.j]=node.dist+1;
                Node temp=new Node(node.i+1,node.j,node.dist+1);
                queue.addLast(temp);
            }
            if(isSafe(node.i-1,node.j,row,col) && arr[node.i-1][node.j]==40){
                arr[node.i-1][node.j]=node.dist+1;
                Node temp=new Node(node.i-1,node.j,node.dist+1);
                queue.addLast(temp);
            }
            if(isSafe(node.i,node.j+1,row,col) && arr[node.i][node.j+1]==40){
                arr[node.i][node.j+1]=node.dist+1;
                Node temp=new Node(node.i,node.j+1,node.dist+1);
                queue.addLast(temp);
            }
            if(isSafe(node.i,node.j-1,row,col) && arr[node.i][node.j-1]==40){
                arr[node.i][node.j-1]=node.dist+1;
                Node temp=new Node(node.i,node.j-1,node.dist+1);
                queue.addLast(temp);
            }
        }
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }

    }

    private static boolean isSafe(int i, int j, int row, int col) {
        return (i>=0 && i<row && j>=0 && j<col);
    }
}