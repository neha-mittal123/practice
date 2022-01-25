package arrayPractice;

/*We have a collection of stones, each stone has a positive integer weight.

Each turn, we choose the two heaviest stones and smash them together.  Suppose the stones have weights x and y with x <= y.  The result of this smash is:

If x == y, both stones are totally destroyed;
If x != y, the stone of weight x is totally destroyed, and the stone of weight y has new weight y-x.
At the end, there is at most 1 stone left.  Return the weight of this stone (or 0 if there are no stones left.)
*/
public class LastStoneWeightUsingBinaryHeap {

	static int[] arr = { 3, 6, 5, 0, 8, 2, 1, 9 };
	static int n = arr.length;
	static int first;
	static int second;

	public static void main(String[] args) {
		buildMaxHeap(arr, n);
		for (int i = 0; i < n; i++) {
			System.out.print(arr[i] + " ");
		}
		while (n >= 1) {
			first = extractMax(arr);
			second = extractMax(arr);
			if (first - second == 0) {
				continue;
			}
			if (first - second > 0) {
				int temp = first - second;
				insertKey(arr, temp);
			} else {
				int temp = second - first;
				insertKey(arr, temp);
			}
		}
		for (int i = 0; i < n; i++) {
			System.out.println(arr[i] + " ");
		}
		if (n >= 0) {
			System.out.println("element:" + arr[0]);
		} else {
			System.out.println("no element");
		}
	}

	private static void buildMaxHeap(int[] arr, int n) {
		for (int i = (int) (Math.floor(n / 2) - 1); i >= 0; i--) {
			// maxHeapify(arr,i);
			maxHeapify1(arr, i);

		}
	}

	private static void insertKey(int[] arr, int newKey) {
		System.out.println("");
		System.out.println("new key is inserting " + newKey);
		n = n + 1;
		int lastIndex = n - 1;
		arr[lastIndex] = newKey;
		while (lastIndex >= 0 && arr[lastIndex / 2] < arr[lastIndex]) {
			int temp = arr[lastIndex / 2];
			arr[lastIndex / 2] = arr[lastIndex];
			arr[lastIndex] = temp;
			lastIndex = lastIndex / 2;
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
}
