package arrayPractice;

public class BinaryHeaps {

	static int[] arr = { 3, 6, 5, 0, 8, 2, 1, 9 };
	static int n = arr.length;

	public static void main(String[] args) {

		buildMaxHeap(arr, n);
		for (int i = 0; i < n; i++) {
			System.out.print(arr[i] + " ");
		}
		heapSort();
		System.out.println();
		for (int i = 0; i < n; i++) {
			System.out.print(arr[i] + " ");
		}
	}

	private static void buildMaxHeap(int[] arr, int n) {
		for (int i = (int) (Math.floor(n / 2) - 1); i >= 0; i--) {
			// maxHeapify(arr,i);
			maxHeapify1(arr, i);

		}
		int max = extractMax(arr);
		System.out.println("extracting max element " + max);
		int i = 2, key = 4, newKey = 10;
		increaseKey(arr, i, key);
		decreaseKey(arr, i, key);
		insertKey(arr, newKey);

	}

	private static void heapSort() {
		for (int i = n - 1; i >= 0; i--) {
			int temp = arr[0];
			arr[0] = arr[i];
			arr[i] = temp;
			maxHeapifyForAort(arr, 0, i);
		}

	}

	private static void insertKey(int[] arr, int newKey) {
		System.out.println("");
		System.out.println("new key is inserting " + newKey);
		n = n + 1;
		int lastIndex = arr.length - 1;
		arr[lastIndex] = newKey;
		while (lastIndex >= 0 && arr[lastIndex / 2] < arr[lastIndex]) {
			int temp = arr[lastIndex / 2];
			arr[lastIndex / 2] = arr[lastIndex];
			arr[lastIndex] = temp;
			lastIndex = lastIndex / 2;
		}

	}

	private static void decreaseKey(int[] arr, int i, int key) {
		if (key > arr[i]) {
			System.out.println("wrong operation as updated value of key can't be larger then original one.");
			System.out.println("original value is " + arr[i] + " but updated value is " + key);
		} else {
			System.out.println("key is decreasing from " + arr[i] + " to " + key);
			arr[i] = key;
			maxHeapify1(arr, i);
		}
		for (int j = 0; j < n; j++) {
			System.out.print(arr[j] + " ");
		}

	}

	private static void increaseKey(int[] arr, int i, int key) {
		if (key < arr[i]) {
			System.out.println("wrong operation as updated value of key can't be smaller then original one.");
			System.out.println("original value is " + arr[i] + " but updated value is " + key);
		} else {
			arr[i] = key;
			while (i >= 0 && arr[i / 2] < arr[i]) {
				int temp = arr[i / 2];
				arr[i / 2] = arr[i];
				arr[i] = temp;
				i = i / 2;
			}
		}

	}

	private static int extractMax(int[] arr) {
		if (n < 1) {
			return arr[0];
		} else {
			int max = arr[0];
			arr[0] = arr[n - 1];
			n = n - 1;
			maxHeapify1(arr, 0);
			return max;
		}

	}

	private static void maxHeapify1(int[] arr, int i) {
		int L = 2 * i + 1;
		int R = 2 * i + 2;
		int largest = -1;
		if (L <= n - 1) {
			if (R <= n - 1) {
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
			maxHeapify1(arr, largest);
		}

	}

	private static void maxHeapifyForAort(int[] arr, int i, int n) {
		int L = 2 * i + 1;
		int R = 2 * i + 2;
		int largest = -1;
		if (L <= n - 1) {
			if (R <= n - 1) {
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
			maxHeapifyForAort(arr, largest, n);
		}

	}

	private static void maxHeapify(int[] arr, int i) {
		int L = 2 * i + 1;
		int R = 2 * i + 2;
		int largest = 0;
		if (L <= n - 1 && arr[L] > arr[i]) {
			largest = L;
		} else {
			largest = i;
		}
		if (R <= n - 1 && arr[R] > arr[largest]) {
			largest = R;
		}
		if (largest != i) {
			int temp = arr[i];
			arr[i] = arr[largest];
			arr[largest] = temp;
			maxHeapify(arr, largest);
		}
	}

}
