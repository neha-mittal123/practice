package arrayPractice;

public class SlidingWindowMaxUsingHeap {

	static int[] arr = { 1, 2, 3, 1, 4, 5, 2, 3, 6 };
	static int n = arr.length;
	static int count = 0;

	class Entry {
		int value;
		int index;

		public Entry(int index, int value) {
			this.index = index;
			this.value = value;
		}

		@Override
		public String toString() {
			return "Entry [key=" + index + ", value=" + value + "]";
		}

		public Entry() {
			super();
		}

	}

	public static void main(String[] args) {
		int k = 3;
		Entry[] entry = new Entry[n];
		int[] result = new int[n - k + 1];
		SlidingWindowMaxUsingHeap s = new SlidingWindowMaxUsingHeap();
		for (int i = 0; i < k; i++) {
			Entry e = s.new Entry(i, arr[i]);
			entry[count] = e;
			count++;
		}
		buildMaxHeap(entry, k);
		int resultCount = 0;
		result[resultCount] = getMax(entry).value;
		resultCount++;
		for (int j = k; j < n; j++) {
			Entry e = getMax(entry);
			if (e.index > j - k) {
				Entry e1 = s.new Entry(j, arr[j]);
				insertKey(entry, e1);
				result[resultCount] = getMax(entry).value;
				resultCount++;
			}else {
				extractMax(entry);
				Entry e1 = s.new Entry(j, arr[j]);
				insertKey(entry, e1);
				result[resultCount] = getMax(entry).value;
				resultCount++;
			}
			
		}
		for (int i : result) {
			System.out.println(i);
		}
	}
	
	private static Entry extractMax(Entry[] arr) {
		if (count < 1) {
			return arr[0];
		} else {
			Entry max = arr[0];
			arr[0] = arr[count - 1];
			count = count - 1;
			maxHeapify1(arr, 0);
			return max;
		}

	}
	
	private static void insertKey(Entry[] arr, Entry newKey) {
		System.out.println("");
		System.out.println("new key is inserting " + newKey.value);
		count = count + 1;
		int lastIndex = count - 1;
		arr[lastIndex] = newKey;
		while (lastIndex >= 0 && arr[lastIndex / 2].value < arr[lastIndex].value) {
			Entry temp = arr[lastIndex / 2];
			arr[lastIndex / 2] = arr[lastIndex];
			arr[lastIndex] = temp;
			lastIndex = lastIndex / 2;
		}

	}

	private static void buildMaxHeap(Entry[] entry, int n) {
		for (int i = (int) (Math.floor(n / 2) - 1); i >= 0; i--) {
			maxHeapify1(entry, i);

		}
	}

	private static void maxHeapify1(Entry[] entry, int i) {
		int L = 2 * i + 1;
		int R = 2 * i + 2;
		int largest = -1;
		if (L <= count - 1) {
			if (R <= count - 1) {
				if (entry[L].value > entry[R].value) {
					largest = L;
				} else {
					largest = R;
				}
			} else {
				largest = L;
			}
		}
		if (largest >= 0 && entry[largest].value > entry[i].value) {
			Entry temp = entry[i];
			entry[i] = entry[largest];
			entry[largest] = temp;
			maxHeapify1(entry, largest);
		}

	}

	private static Entry getMax(Entry[] entry) {
		if (count > 0) {
			return entry[0];
		} else {
			return null;
		}
	}

}
