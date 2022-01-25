package arrayPractice;

import java.util.Stack;

public class smallestNumerByRemovingKDigits {

	public static void main(String[] args) {
		String num = "14301620";
		char[] numArray = num.toCharArray();
		int k = 4;
		Stack<Character> stack = new Stack<Character>();
		stack.push(numArray[0]);
		int i;
		for (i = 1; i < numArray.length; i++) {
			while (stack.size() > 0 && k >= 0) {
				if (numArray[i] > stack.firstElement()) {
					stack.push(numArray[i]);
					break;
				} else {
					stack.pop();
					k--;
				}
			}
			stack.push(numArray[i]);
		}
		StringBuilder result = new StringBuilder();
		for (Character c : stack) {
			result.append(c);
		}
		if(result.charAt(0)=='0') {
			result.deleteCharAt(0);
		}
		System.out.println(result);
	}

}
