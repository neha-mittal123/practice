package arrayPractice;

public class MaxProductSubArray {

	public static void main(String[] args) {
		int [] arr={6, -3, -10, 0, 2};
		int max_so_far=1,max_ending_here=1,min_ending_here=1;
		for(int i=0;i<arr.length;i++) {
			if(arr[i]==0) {
				max_ending_here=1;
				min_ending_here=1;
			}
			if(arr[i]>0) {
				max_ending_here=max_ending_here*arr[i];
				min_ending_here=Math.min(min_ending_here*arr[i], 1);
			}else if(arr[i]<0) {
				int temp=max_ending_here;
				max_ending_here=Math.max(min_ending_here*arr[i],1);
				min_ending_here=temp*arr[i];
			}
			if(max_ending_here>max_so_far) {
				max_so_far=max_ending_here;
			}
		}
		System.out.println(max_so_far);	
	}
}
