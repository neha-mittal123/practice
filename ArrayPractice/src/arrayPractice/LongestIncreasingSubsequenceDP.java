package arrayPractice;

import java.util.Arrays;

public class LongestIncreasingSubsequenceDP {

	public static void main(String[] args) {
		int [] arr= {0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15};
		int lis[]= new int[arr.length];
		Arrays.fill(lis, 1);
		for(int i=1;i<arr.length;i++) {
			for(int j=0;j<i;j++) {
				if(arr[i]>arr[j] && lis[i]<=lis[j]) {
					lis[i]=lis[j]+1;
				}
			}
		}
		System.out.println(lis[lis.length-1]);
		

	}

}
