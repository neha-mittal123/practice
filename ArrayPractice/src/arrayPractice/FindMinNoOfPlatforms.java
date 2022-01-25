package arrayPractice;

import java.util.Arrays;

public class FindMinNoOfPlatforms {

	public static void main(String[] args) {
		int arr[] = { 900, 940, 950, 1100, 1500, 1800 };
        int dep[] = { 910, 1200, 1120, 1130, 1900, 2000 };
        int platforms=findPlatforms(arr,dep);
        System.out.println(platforms);
	}

	private static int findPlatforms(int[] arr, int[] dep) {
		int platform=1;
		int j=0,i=1,res=1;
		Arrays.sort(arr);
		Arrays.sort(dep);
		while(j<arr.length && i<arr.length) {
			if(arr[i]>dep[j]) {
				platform--;
				j++;
			}else {
				platform++;
				i++;
			}
			if(platform>res) {
				res=platform;
			}
		}
		return res;
	}

}
