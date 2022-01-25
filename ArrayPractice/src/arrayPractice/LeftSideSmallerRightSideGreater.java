package arrayPractice;

import java.util.Scanner;

public class LeftSideSmallerRightSideGreater {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int x = 0; x < t; x++) {
			int n = sc.nextInt();
			int arr[] = new int[n];
			for (int i = 0; i < n; i++) {
				arr[i] = sc.nextInt();
			}
		int pos = findInflexionPoint(arr);
		System.out.println(pos);
		}
	}

	private static int findInflexionPoint(int[] arr) {
		// Base case
	    if (arr.length == 1 || arr.length == 2)
	    {
	        return -1;
	    }
		int max = arr[0];
		int inflexionPos = -1;
		for(int i=1;i<arr.length;i++) {
			if(arr[i]>max && inflexionPos == -1 && i<arr.length-1) {
				max = arr[i];
				inflexionPos = i;
			}
			if(inflexionPos>0 && i>inflexionPos) {
				if(arr[i]>=max) {
					max = arr[i];
					continue;
				}else {
					inflexionPos = -1;
				}
			}
		}
		if(inflexionPos > 0){
		    return arr[inflexionPos];
		}else{
		    return inflexionPos;
		}	
	}

}
