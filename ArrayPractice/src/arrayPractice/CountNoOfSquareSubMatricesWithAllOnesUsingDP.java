package arrayPractice;

public class CountNoOfSquareSubMatricesWithAllOnesUsingDP {

	public static void main(String[] args) {
		int arr[][] = { { 1, 0, 1 },
                { 1, 1, 0 },
                { 1, 1, 0 } };
		int col=arr[0].length;
		int row=arr.length,count=0;
		for(int i=0;i<row;i++) {
			count=count+arr[i][0];
		}
		for(int i=0;i<col;i++) {
			count=count+arr[0][i];
		}
		for(int i=1;i<row;i++) {
			for(int j=1;j<col;j++) {
				if(arr[i][j]==0) {
					continue;
				}else {
					arr[i][j]=Math.min(arr[i-1][j-1], Math.min(arr[i-1][j], arr[i][j-1]))+1;
				}
				count=count+arr[i][j];
			}
		}
		System.out.println(count);

	}

}
