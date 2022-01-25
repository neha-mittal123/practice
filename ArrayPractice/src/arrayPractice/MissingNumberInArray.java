package arrayPractice;

import java.util.BitSet;

/*Given an array of size N-1 such that it can 
only contain distinct integers in the range of 1 to N. Find the missing element.*/

public class MissingNumberInArray {

	public static void main(String[] args) {
		int N = 9;
		int A[] = {1,2,3,5,7,9};
		//int number = MissingNumber(A,N);
		//System.out.println(number);
		MissingNumbers(A,N);
	}

	
	private static void MissingNumbers(int[] a, int n) {
		BitSet array=new BitSet(n);
		int missingCount=n-a.length;
		for(int num: a) {
			array.set(num-1);
		}
		int lastElementMissingIndex=0;
		for(int i=0;i<missingCount;i++) {
			lastElementMissingIndex=array.nextClearBit(lastElementMissingIndex);
			//System.out.println(array.nextClearBit(lastElementMissingIndex));
			System.out.println(++lastElementMissingIndex);
		}
		
		
	}


	static int MissingNumber(int array[], int n) {
        int TotalSum = (n*(n+1))/2;
        System.out.println(TotalSum);
        int arraySum = 0;
        for(int i=0;i<=n-2;i++){
            arraySum = arraySum + array[i];
        }
        System.out.println(arraySum);
        return TotalSum-arraySum;
    }
}
