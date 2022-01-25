package arrayPractice;

import java.util.Scanner;

/*Given an array of size N containing only 0s, 1s, and 2s; sort the array in ascending order.*/

public class SortAnArrayOf1And2And3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[] = new int[n];
		for (int j = 0; j < n; j++) {
			arr[j] = sc.nextInt();
		}
		//SortApproach1(arr);
		SortApproach2(arr);
	}

	private static void SortApproach1(int[] arr) {
		int temp=0;
		for(int i=0;i<arr.length;) {
			if(i<=arr.length-2 && arr[i]>arr[i+1]) {
				temp=arr[i];
				arr[i]=arr[i+1];
				arr[i+1]=temp;
				if(i>0) {
				i--;
				}
			}else {
				i++;
				continue;
			}
		}
		for(int i:arr)
		System.out.print(i+" ");
		
	}
	
	private static void SortApproach2(int[] arr) {
		int pos0=0;
		int pos2=arr.length-1;
		int temp = 0;
		for(int i=0;i<arr.length && i<=pos2;) {
			if(arr[i] == 2) {
				temp=arr[i];
				arr[i]=arr[pos2];
				arr[pos2]=temp;
				pos2--;
			}else if(arr[i] == 0) {
				temp=arr[i];
				arr[i]=arr[pos0];
				arr[pos0]=temp;
				pos0++;
				i++;
			}else {
				i++;
				continue;
			}
		}
		for(int i:arr)
		System.out.print(i+" ");
		
	}


}
