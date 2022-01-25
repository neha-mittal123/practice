package arrayPractice;

import java.util.Scanner;
import java.util.Stack;

/*Given an unsorted array. The task is to find all the star and super star elements in the array. 
Star are those elements which are strictly greater than all the elements on its right side. 
Super star are those elements which are strictly greater than all the elements 
on its left and right side.*/

public class StarElements {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int x = 0; x < t; x++) {
			int n = sc.nextInt();
			int arr[] = new int[n];
			for (int j = 0; j < n; j++) {
				arr[j] = sc.nextInt();
			}
			findStarElements(arr);
		}

	}

	private static void findStarElements(int[] arr) {
		int superStarElement = 0;
		int starLength = 0;
		int max = -1;
		int maxPos = 0;
		// Base case
		if (arr.length == 1) {
			System.out.println(arr[0]);
			System.out.println(arr[0]);
			return;
		}
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > max) {
				max = arr[i];
				maxPos = i;
				superStarElement = arr[i];
			}
		}
		int maxElementFreq = 0;
		for (int i = 0; i < arr.length; i++) {
			if(arr[i] == superStarElement) {
				maxElementFreq++;
			}
		}
		if(maxElementFreq>1) {
			superStarElement = -1;
		}
		Stack<Integer> s = new Stack<>();
		for (int i = maxPos ; i < arr.length; i++) {
			if (!s.isEmpty() &&  s.peek() > arr[i]) {
				s.push(arr[i]);
			} else {
				while (!s.isEmpty() && s.peek() <= arr[i]) {
					s.pop();
				}
				s.push(arr[i]);
			}
		}
		while (!s.isEmpty()) {
			arr[starLength] = s.pop();
			starLength++;
		}
		for (int i = starLength-1; i >=0; i--) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
		System.out.println(superStarElement);
	}

}
