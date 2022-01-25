package arrayPractice;

public class RotatedArrayToLeft {

	public static void main(String[] args) {
		int arr[] = {1,2,3,4,5};
		int k=2	;
		rotatedSortedArray(arr,k,arr.length);

	}

	private static void rotatedSortedArray(int[] arr, int d,int n) {
		int i,j,k,temp;
		
		for(i=0;i<gcd(d,n);i++) {
			temp = arr[i];
			j = i;
			System.out.println("öutside");
			while(true) {
				k = j + d;
				if(k >= n) {
					k = k - n;
				}
				if(k == i) {
					break;
				}
				arr[j] = arr [k];
				j = k;
			}
			arr[j] = temp;
		}
		for(int l : arr) {
			System.out.println(l);
		}
	}
	
	static int gcd(int d, int n) 
    { 
        if (n == 0) 
            return d; 
        else
            return gcd(n, d % n); 
    } 

}
