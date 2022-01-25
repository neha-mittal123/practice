package arrayPractice;

import java.util.*;

public class FindNoOfIncreasingStockPriceWindows {

	public static void main(String[] args) {
		int [] arr= {5,3,4,6,7,1};
		int k=3;
		System.out.println(calcNoOfWindows(arr,k));
	}

	private static int calcNoOfWindows(int[] arr, int k) {
		int counter=0;
		Stack<Integer> s=new Stack<Integer>();
		for(int i=0;i<arr.length;i++) {
			if(!s.isEmpty()) {
				if(arr[i]>s.peek()) {
					s.push(arr[i]);
				}else {
					if(s.size()>1) {
						counter=counter+s.size()-k+1;
					}
					s.clear();
				}
			}else {
				s.push(arr[i]);
			}
			
		}
		return counter;
	}

}
