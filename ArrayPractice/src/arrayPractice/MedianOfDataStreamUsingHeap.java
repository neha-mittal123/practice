package arrayPractice;

public class MedianOfDataStreamUsingHeap {
	static int maxHeapCurrSize = 0;
	static int minHeapCurrSize = 0;

	public static void main(String[] args) {
		int[] arr = { 5, 3, 4, 2, 6 };
		int[] maxHeap = new int[3];
		int[] minHeap = new int[2];
		for (int i = 0; i < arr.length; i++) {
			if (maxHeapCurrSize == 0) {
				maxHeap[maxHeapCurrSize] = arr[i];
				maxHeapCurrSize++;
			} else if (arr[i] > getMax(maxHeap) && arr[i] > getMin(minHeap) && maxHeapCurrSize == minHeapCurrSize) {
				int element = extractMin(minHeap);
				insertKeyMin(minHeap, arr[i]);
				insertKeyMax(maxHeap, element);
			} else if (arr[i] > getMax(maxHeap) && maxHeapCurrSize == minHeapCurrSize) {
				insertKeyMax(maxHeap, arr[i]);
			} else if (arr[i] < getMax(maxHeap) && maxHeapCurrSize == minHeapCurrSize + 1) {
				int element = extractMax(maxHeap);
				insertKeyMin(minHeap, element);
				insertKeyMax(maxHeap, arr[i]);
			}
			float median = -1;
			System.out.println("min:"+i+"-"+getMin(minHeap));
			System.out.println("max:"+i+"-"+getMax(maxHeap));
			if(i%2 == 0) {
				median = getMax(maxHeap);
			}else {
				median =(float) (getMax(maxHeap)+getMin(minHeap))/2;
			}
			System.out.println("median:"+median);
		}
	}

	private static void maxHeapify(int[] arr, int i) {
		int L = 2 * i + 1;
		int R = 2 * i + 2;
		int largest = -1;
		if (L <= maxHeapCurrSize - 1) {
			if (R <= maxHeapCurrSize - 1) {
				if (arr[L] > arr[R]) {
					largest = L;
				} else {
					largest = R;
				}
			} else {
				largest = L;
			}
		}
		if (largest >= 0 && arr[largest] > arr[i]) {
			int temp = arr[i];
			arr[i] = arr[largest];
			arr[largest] = temp;
			maxHeapify(arr, largest);
		}

	}

	private static int getMax(int[] arr) {
		if(maxHeapCurrSize>0) {
			return arr[0];
		}else {
			return 0;
		}
	}

	private static int getMin(int[] arr) {
		if(minHeapCurrSize>0) {
			return arr[0];
		}else {
			return 0;
		}
	}

	private static int extractMax(int[] arr) {
		if (maxHeapCurrSize < 1) {
			return arr[0];
		} else {
			int max = arr[0];
			arr[0] = arr[maxHeapCurrSize - 1];
			maxHeapCurrSize = maxHeapCurrSize - 1;
			maxHeapify(arr, 0);
			return max;
		}

	}

	private static int extractMin(int[] arr) {
		if (minHeapCurrSize < 1) {
			return arr[0];
		} else {
			int min = arr[0];
			arr[0] = arr[minHeapCurrSize - 1];
			minHeapCurrSize = minHeapCurrSize - 1;
			minHeapify(arr, 0);
			return min;
		}

	}

	private static void minHeapify(int[] arr, int i) {
		int L = 2 * i + 1;
		int R = 2 * i + 2;
		int smallest = -1;
		if (L <= minHeapCurrSize - 1) {
			if (R <= minHeapCurrSize - 1) {
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
			minHeapify(arr, smallest);
		}

	}

	private static void insertKeyMin(int[] arr, int newKey) {
		// System.out.println("");
		// System.out.println("new key is inserting " + newKey);
		minHeapCurrSize = minHeapCurrSize + 1;
		int lastIndex = minHeapCurrSize - 1;
		arr[lastIndex] = newKey;
		while (lastIndex >= 0 && arr[lastIndex / 2] > arr[lastIndex]) {
			int temp = arr[lastIndex / 2];
			arr[lastIndex / 2] = arr[lastIndex];
			arr[lastIndex] = temp;
			lastIndex = lastIndex / 2;
		}

	}

	private static void insertKeyMax(int[] arr, int newKey) {
		System.out.println("");
		System.out.println("new key is inserting " + newKey);
		maxHeapCurrSize = maxHeapCurrSize + 1;
		int lastIndex = maxHeapCurrSize - 1;
		arr[lastIndex] = newKey;
		while (lastIndex >= 0 && arr[lastIndex / 2] < arr[lastIndex]) {
			int temp = arr[lastIndex / 2];
			arr[lastIndex / 2] = arr[lastIndex];
			arr[lastIndex] = temp;
			lastIndex = lastIndex / 2;
		}

	}

}
