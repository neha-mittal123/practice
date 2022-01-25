package arrayPractice;

import java.util.HashMap;

public class FindDoubletWithGivenSum {
	
	public static void main(String args[]) {
		int arr[] = {142, 712, 254, 869, 548, 645, 663, 758, 38, 860, 724, 742, 530, 779, 317, 36, 191, 843, 289, 107, 41, 943, 265, 649, 447, 806, 891, 730, 371, 351, 7, 102, 394, 549, 630, 624, 85, 955, 757, 841, 967, 377, 932, 309, 945, 440, 627, 324, 538, 539, 119, 83, 930, 542, 834, 116, 640, 659, 705, 931, 978, 307, 674, 387, 22, 746, 925, 73, 271, 830, 778, 574, 98, 513};
		int sum = 165;
		findDoublet(arr,sum);
	}

	private static void findDoublet(int[] arr, int sum) {
		HashMap<Integer,Integer> hm = new HashMap<>();
		for(int i =0,j=arr.length-1;j>=i;i++,j--) {
			if(hm.containsKey(Math.abs(sum-arr[i]))) {
				System.out.println("x:"+hm.get(Math.abs(sum-arr[i])) + "y:" +arr[ i]);
			}else {
				hm.put(arr[i], arr[i]);
			}
			if(hm.containsKey(Math.abs(sum-arr[j]))) {
				System.out.println("x:"+hm.get(Math.abs(sum-arr[j])) + "y:" + arr[j]);
			}else {
				hm.put(arr[j], arr[j]);
			}
		}
		
	}
}
