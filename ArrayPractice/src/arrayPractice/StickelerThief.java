package arrayPractice;

import java.util.Scanner;

/*Stickler the thief wants to loot money from a society having n houses in a single line. 
He is a weird person and follows a certain rule when looting the houses. 
According to the rule, he will never loot two consecutive houses. At the same time, 
he wants to maximize the amount he loots. The thief knows which house has what amount of money 
but is unable to come up with an optimal looting strategy. He asks for your help to find the 
maximum money he can get if he strictly follows the rule. Each house has a[i] amount of money 
present in it.*/

public class StickelerThief {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int x = 0; x < t; x++) {
			int n = sc.nextInt();
			int arr[] = new int[n];
			for (int i = 0; i < n; i++) {
				arr[i] = sc.nextInt();
			}
			findMaxProfit(arr);
		}

	}

	private static void findMaxProfit(int[] arr) {
		int j = 1, sum0 = 0, sum1 = 0;
		for (int i = 0;i < arr.length || j < arr.length ;) {
			if(i < arr.length) {
				sum0 = sum0 + arr[i];
				i = i + 2;
			}
			if(j < arr.length) {
				sum1 = sum1 + arr[j];
				j = j + 2;
			}
		}
		if (sum0 > sum1) {
			System.out.println(sum0);
		}else {
			System.out.println(sum1);
		}
		
	}

}
