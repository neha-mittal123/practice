package GooglePractice;

//Given a 2D grid, each cell is either a wall 'W', an enemy 'E' or empty '0' (the number zero), return the maximum enemies you can kill using one bomb.
// The bomb kills all the enemies in the same row and column from the planted point until it hits the wall since the wall is too strong to be destroyed.
// Note that you can only put the bomb at an empty cell.
//
//        Example: For the given grid
//
//        0 E 0 0
//        E 0 W E
//        0 E 0 0
//        return 3. (Placing a bomb at (1,1) kills 3 enemies)

public class BombEnemy {
    public static void  main(String[] args){
        char[][] grid={{'0','E','0','0'},
                {'E','0','W','E'},
                {'0','E','0','0'}};
        System.out.println(findMaxEnemiesKilledViaOneBomb(grid));
    }

    private static int findMaxEnemiesKilledViaOneBomb(char[][] grid) {
        int res=0;
        int row=grid.length;
        int col=grid[0].length;
        int rows=0;
        int []cols=new int[col];
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(j==0 || grid[i][j-1]=='W'){
                    rows=0;
                    for(int k=j;k<col && grid[i][k]!='W';k++){
                        if(grid[i][k]=='E')
                        rows++;
                    }
                }
                if(i==0 || grid[i-1][j]=='W'){
                    cols[j]=0;
                    for(int k=i;k<row && grid[k][j]!='W';k++){
                        if(grid[k][j]=='E')
                            cols[j]++;
                    }
                }
                if(grid[i][j]=='0' && res<rows+cols[j]){
                    res=rows+cols[j];
                }
            }
        }
        return res;
    }
}
