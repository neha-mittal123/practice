package arrayPractice;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class AmountOfWater {

	public static void main(String[] args) {
		int arr[] = {2,2,3,4,2,3,3};
		int noOfBaskets = 2;
		calculateMaxFruits(arr,noOfBaskets);

	}

	private static void calculateMaxFruits(int[] arr, int noOfBaskets) {
		HashMap<Integer,Integer> hm = new HashMap<>();
		int max = -1;
		int secondMax = -1;
		int MaxValue = -1;
		for(int i=0;i<arr.length;i++) {
			if(hm.get(arr[i]) != null) {
				hm.put(arr[i], hm.get(arr[i])+1);
			}else {
				hm.put(arr[i], 1);
			}
		}
		Iterator itr = hm.entrySet().iterator();
		
		while(itr.hasNext()) {
			Map.Entry element = (Map.Entry)itr.next();
			if((int)element.getValue()>max) {
				max = (int)element.getValue();
				MaxValue = (int)element.getKey();
			}
		}
		
		while(itr.hasNext()) {
			Map.Entry element = (Map.Entry)itr.next();
			if((int)element.getValue()>secondMax) {
				if(secondMax <= max && MaxValue != (int)element.getKey())
					secondMax = (int)element.getValue();
			}
		}
		System.out.println("Total Fruits:"+max+secondMax);
	}

}
