package arrayPractice;

public class SortKSortedArray {
	static int k = 3;
	static int n = k+1;
	public static void main(String[] args) {
		
        int arr[] = { 2, 6, 3, 12, 56, 8 };
        int sortedArr[] =new int[arr.length];
        int temparr[] = new int[k+1];
        for(int i=0;i<n;i++) {
        	temparr[i] = arr[i];
        }
        int count=0;
        buildMinHeap(temparr, n);
        
        for(int i=k+1;i<arr.length;i++) {
        	int min=extractMin(temparr);
        	sortedArr[count]=min;
        	count++;
        	insertKey(temparr, arr[i]);
        }
        for(int i: temparr) {
        	System.out.print(i+ " ");
        	
        }
        System.out.println(" ");
        while(count<arr.length) {
        	sortedArr[count]=extractMin(temparr);
        	count++;
        }
        for(int i: sortedArr) {
        	System.out.print(i +" ");
        }
        

	}
	private static void buildMinHeap(int[] arr, int n) {
		for (int i = (int) (Math.floor(n / 2) - 1); i >= 0; i--) {
			minHeapify1(arr, i);
		}
	}
	private static void insertKey(int[] arr, int newKey) {
		//System.out.println("");
		//System.out.println("new key is inserting " + newKey);
		n = n + 1;
		int lastIndex = n - 1;
		arr[lastIndex] = newKey;
		while (lastIndex >= 0 && arr[lastIndex / 2] > arr[lastIndex]) {
			int temp = arr[lastIndex / 2];
			arr[lastIndex / 2] = arr[lastIndex];
			arr[lastIndex] = temp;
			lastIndex = lastIndex / 2;
		}

	}
	
	private static int extractMin(int[] arr) {
		if (n < 1) {
			return arr[0];
		} else {
			int min = arr[0];
			arr[0] = arr[n - 1];
			n = n - 1;
			minHeapify1(arr, 0);
			return min;
		}

	}
	private static void minHeapify1(int[] arr, int i) {
		int L = 2 * i + 1;
		int R = 2 * i + 2;
		int smallest = -1;
		if (L <= n - 1) {
			if (R <= n - 1) {
				if (arr[L] < arr[R]) {
					smallest = L;
				} else {
					smallest = R;
				}
			} else {
				smallest = L;
			}
		}
		if (smallest >= 0 && arr[smallest] < arr[i]) {
			int temp = arr[i];
			arr[i] = arr[smallest];
			arr[smallest] = temp;
			minHeapify1(arr, smallest);
		}

	}

}
