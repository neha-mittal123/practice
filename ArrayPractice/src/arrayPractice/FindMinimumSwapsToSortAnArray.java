package arrayPractice;

import java.util.Arrays;
import java.util.HashMap;

public class FindMinimumSwapsToSortAnArray {

	public static void main(String[] args) {
		int []a = {1, 5, 4, 3, 2};
		int noOfSwaps=findSwaps(a);
		System.out.println(noOfSwaps);
	}

	private static int findSwaps(int[] a) {
		int res=0;
		HashMap<Integer, Integer> map=new HashMap<Integer, Integer>();
		for(int i=0;i<a.length;i++) {
			map.put(a[i],i );
		}
		Arrays.sort(a);
		for(int j=0;j<a.length;j++) {
			if(j==map.get(a[j])) {
				continue;
			}else {
				res++;
				int temp=a[j];
				a[j]=a[map.get(a[j])];
				a[map.get(a[j])]=temp;
			}
		}
		return res;
	}

}
