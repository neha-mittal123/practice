package GooglePractice;

public class GameOfLife {
    public static void main(String[] args){
        int[][] board={{0,1,0},
                {0,0,1},
                {1,1,1},
                {0,0,0}};
        findNextState(board);

    }

    private static void findNextState(int[][] board) {
        int row=board.length;
        int col=board[0].length;
        int[] dx={1,1,0,-1,-1,-1,0,1};
        int[] dy={0,1,1,1,0,-1,-1,-1};
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                int livePoints=0;
                for(int k=0;k<8;k++){
                    if(isSafe(i+dx[k],j+dy[k],row,col) && Math.abs(board[i+dx[k]][j+dy[k]])==1){
                        livePoints++;
                    }
                }
                if(board[i][j]==0 && livePoints==3){
                    board[i][j]=2;
                }
                if(board[i][j]==1 && (livePoints<2 || livePoints>3)){
                    board[i][j]=-1;
                }
            }
        }
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                board[i][j]=board[i][j]>0 ? 1: 0;
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }
    }
    private static boolean isSafe(int i, int j, int row, int col) {
        return (i>=0 && i<row && j>=0 && j<col);
    }
}