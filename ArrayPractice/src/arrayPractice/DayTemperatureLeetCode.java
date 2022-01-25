package arrayPractice;

import java.util.Arrays;
import java.util.Stack;

//Count of days remaining for the next day with higher temperature

//Given a list arr[] of everyday temperatures. For each day, the task is to find the count of days remaining for the next day with warmer temperatures. If there is no such day for which warmer temperature is possible then print -1.
//Examples:
//
//Input: arr[] = {73, 74, 75, 71, 69, 72, 76, 73} 
//Output: {1, 1, 4, 2, 1, 1, -1, -1} 
//Explanation: 
//For 73 temperature, next warmer temperature is 74 which at a distance 1 
//For 74 temperature, next warmer temperature is 75 which at a distance 1 
//For 75 temperature, next warmer temperature is 76 which at a distance 4 
//For 71 temperature, next warmer temperature is 72 which at a distance 2 
//For 69 temperature, next warmer temperature is 72 which at a distance 1 
//For 72 temperature, next warmer temperature is 76 which at a distance 1 
//For 76 temperature, there is no valid next warmer day 
//For 73 temperature, there is no valid next warmer day

public class DayTemperatureLeetCode {

	public static void main(String[] args) {
		int[] arr = { 73, 74, 75, 71,69, 72, 76, 73 };
		calcTemperature(arr);

	}

	private static void calcTemperature(int[] arr) {
		int[] output=new int[arr.length];
		Arrays.fill(output, -1);
		Stack<Integer> s=new Stack<>();
		for(int i=0;i<arr.length;i++) {
			while(!s.isEmpty() && arr[s.peek()]<arr[i]) {
				output[s.peek()]=i-s.peek();
				s.pop();
			}
			s.push(i);
		}
		for(int i:output) {
			System.out.println(i);
		}
		
		
		
	}

}
