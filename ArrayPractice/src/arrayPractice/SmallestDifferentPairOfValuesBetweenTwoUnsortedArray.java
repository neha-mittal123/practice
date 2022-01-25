package arrayPractice;

import java.util.Arrays;

public class SmallestDifferentPairOfValuesBetweenTwoUnsortedArray {

	public static void main(String[] args) {
		int arr1[] = {1, 3, 15, 11, 2};
		int arr2[] = {23, 127, 235, 19, 8};
		int diff=findSmallestDifferentPairOfVlauesBetweenTwoUnsortedArray(arr1,arr2);
		System.out.println(diff);

	}

	private static int findSmallestDifferentPairOfVlauesBetweenTwoUnsortedArray(int[] arr1, int[] arr2) {
		int n1=arr1.length;
		int n2=arr2.length;
		int res=Integer.MAX_VALUE;
		int a=0,b=0;
		Arrays.sort(arr1);
		Arrays.sort(arr2);
		while(a<n1 && b<n2) {
			if(Math.abs(arr1[a]-arr2[b])<res) {
				res=Math.abs(arr1[a]-arr2[b]);
			}
			if(arr1[a]<arr2[b]) {
				a++;
			}else {
				b++;
			}
		}
		return res;
	}

}
