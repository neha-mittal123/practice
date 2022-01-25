package arrayPractice;

public class CenterElementOfMatrixEqualsSumsOfHalfDiagonals {

//	code matrix problem . A 2n+1 (odd) size square matrix is given . We have to check if the centre element is 
//	equal to the individual sum of all the half diagonals in only ONE for loop . For example –
//
//	5*5 matrix –
//
//	M =   2   9   1   4   -2
//
//	6   7   2   11   4
//
//	4    2  9  2   4
//
//	1   9   2    4   4
//
//	0   2   4   2   5
//
//	 
//
//	Sum of Half Diagonal 1 = 2+7=9
//
//	Sum of Half Diagonal 2 = 9+0=9
//
//	Sum of Half Diagonal 3 = 11 + -2 = 9
//
//	Sum of Half Diagonal 4 = 5+4 = 9
//
//	All the sums equal to the centre element that is M [2][2]=9, Hence return true or if any on of the sums of 
//	half diagonals doesnt match to the centre element, return false.
	
	public static void main(String[] args) {
		int arr[][] = { { 2, 9, 1, 4, -2},
                { 6, 7, 2, 11, 4},
                { 4, 2, 9, 2, 4},
                { 1, 9, 2, 4, 4},
                { 0, 2, 4, 2, 5} };
		boolean output=checkHalfDiagonalSums(arr);
		System.out.println(output);
	}

	private static boolean checkHalfDiagonalSums(int[][] arr) {
		int sumLeftOne=0,sumLeftTwo=0,sumRightOne=0,sumRightTwo=0;
		int n=arr.length;
		for(int i=0,j=n-1;i<n;i++,j--) {
			if(i<n/2) {
				sumLeftOne=sumLeftOne+arr[i][i];
				sumLeftTwo=sumLeftTwo+arr[j][i];
			}else if(i>n/2) {
				sumRightOne=sumRightOne+arr[i][i];
				sumRightTwo=sumRightTwo+arr[j][i];
			}
		}
		return (arr[n/2][n/2]==sumLeftOne && sumLeftOne==sumLeftTwo && sumRightOne==sumRightTwo && sumLeftOne==sumRightOne );
	}

}
