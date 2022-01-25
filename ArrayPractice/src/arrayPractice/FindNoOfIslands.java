package arrayPractice;

public class FindNoOfIslands {
	static int Row=5,Col=5;
	static int M[][]= new int[][] { { 1, 1, 0, 0, 0 },
        { 0, 1, 0, 0, 1 },
        { 1, 0, 0, 1, 1 },
        { 0, 0, 0, 0, 0 },
        { 1, 0, 1, 0, 1 } };
    static boolean[][] visited=new boolean[Row][Col];
	public static void main(String[] args) {
		
            
           int islands= countNoOfIslands();
           System.out.println(islands);

	}

	private static int countNoOfIslands() {
		
		int counter=0;
		for(int i=0;i<Row;i++) {
			for(int j=0;j<Col;j++) {
				if(M[i][j]==1 && !visited[i][j] ) {
					DFS(i,j);
					counter++;
				}
			}
		}
		return counter;
	}

	private static void DFS( int i, int j) {
		int rArray[]= {-1,-1,-1,0,1,1,1,0};
		int cArray[]= {-1,0,1,1,1,0,-1,-1};
		visited[i][j]=true;
		for(int k=0;k<8;k++) {
			if(isSafe(i+rArray[k],j+cArray[k]))
				DFS(i+rArray[k],j+cArray[k]);
		}
		
	}

	private static boolean isSafe( int i, int j) {
		return ( (i>=0) && (i<Row) && (j>=0) && (j<Col) && ((M[i][j]==1)&& (!visited[i][j])));
		
		
	}

}
