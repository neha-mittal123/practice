package arrayPractice;

import java.util.HashMap;
import java.util.Map;

public class KFrequentElementsUsingHeap {
	static int n = 0;
	class Entry{
		int key;
		int value;
		public Entry(int key, int value) {
			this.key = key;
			this.value = value;
		}
		@Override
		public String toString() {
			return "Entry [key=" + key + ", value=" + value + "]";
		}
		public Entry() {
			super();
		}
		
	}

	public static void main(String[] args) {
		int[] arr = {1,1,1,2,2,3};
		int k = 2;
		HashMap<Integer, Integer> map=new HashMap<Integer, Integer>();
		for(int i=0;i<arr.length;i++) {
			if(map.containsKey(arr[i])) {
				map.put(arr[i], map.get(arr[i])+1);
			}else {
				map.put(arr[i], 1);
			}
		}
		Entry[] entry =new Entry[map.size()];
		KFrequentElementsUsingHeap  x= new KFrequentElementsUsingHeap(); 
		for(Map.Entry<Integer, Integer> e : map.entrySet()) {
			System.out.println(e);
			Entry temp=x.new Entry(e.getKey(),e.getValue());
			entry[n] = temp;
			n++;
		}
		buildMaxHeap(entry, n);
		for(int i=0;i<k;i++) {
			Entry e = extractMax(entry);
			System.out.println(e.toString());
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
		if (L <= n - 1) {
			if (R <= n - 1) {
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
	
	private static Entry extractMax(Entry[] arr) {
		if (n < 1) {
			return arr[0];
		} else {
			Entry max = arr[0];
			arr[0] = arr[n - 1];
			n = n - 1;
			maxHeapify1(arr, 0);
			return max;
		}

	}

}
