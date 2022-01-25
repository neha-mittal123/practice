package arrayPractice;

import java.util.Arrays;

public class CandyDistribution {

	public static void main(String[] args) {
		int ranking[]= {1,5,2,1};
		int l2R[]=new int[ranking.length];
		int r2L[]= new int[ranking.length];
		Arrays.fill(l2R, 1);
		Arrays.fill(r2L, 1);
		for(int i=1;i<ranking.length;i++) {
			if(ranking[i]>ranking[i-1]) {
				l2R[i]=l2R[i-1]+1;
			}
		}
		for(int j=ranking.length-2;j>0;j--) {
			if(ranking[j]>ranking[j+1]) {
				r2L[j]=r2L[j+1]+1;
			}
		}
		int sum=0;
		for(int k=0;k<l2R.length;k++) {
			if(l2R[k]>r2L[k]) {
				sum=sum+l2R[k];
			}else {
				sum=sum+r2L[k];
			}
		}
		System.out.println(sum);
	}

}
