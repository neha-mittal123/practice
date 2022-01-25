package arrayPractice;

import java.util.HashMap;


public class PermutationOfStringWithDifferentNeighbouringCharactors {

	static int n=0;
	class Entry{
		Character key;
		int value;
		public Entry(Character key, int value) {
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
		public int getValue() {
			return value;
		}
		public void setValue(int value) {
			this.value = value;
		}
		
		
	}
	public static void main(String[] args) {
		String input="aabb";
		HashMap<Character, Integer> map=new HashMap<Character, Integer>();
		for(int i=0;i<input.length();i++) {
			if(map.containsKey(input.charAt(i))) {
				map.put(input.charAt(i),map.get(input.charAt(i))+1);
			}else {
				map.put(input.charAt(i), 1);
			}
		}
		Entry[] entry =new Entry[map.size()];
		PermutationOfStringWithDifferentNeighbouringCharactors  x= new PermutationOfStringWithDifferentNeighbouringCharactors(); 
		for(java.util.Map.Entry<Character, Integer> e : map.entrySet()) {
			Entry temp=x.new Entry(e.getKey(),e.getValue());
			entry[n] = temp;
			n++;
		}
		buildMaxHeap(entry,n);
		StringBuilder res=new StringBuilder();
		while(getMax(entry).value > 0) {
			Entry e = extractMax(entry);
			res.append(e.key);
			//permut(res.toString()," ");
			if(e.value>0) {
				e.setValue(e.getValue()-1);
				insertKey(entry,e);
			}
		}
		System.out.println(res);
	}
	private static void permut(String in,String res ) {
		if (in.length() == 0) {
            System.out.print(res + " ");
            return;
        }
		for(int i=0;i<in.length();i++) {
			Character ch=in.charAt(i);
			String ros=in.substring(0,i)+in.substring(i+1);
			permut(ros, res+ch);
		}
		
	}
	private static Entry getMax(Entry[] entry) {
		return entry[0];
	}
	private static void insertKey(Entry[] entry, Entry e) {
		System.out.println("");
		//System.out.println("new key is inserting " + e);
		n = n + 1;
		int lastIndex = entry.length - 1;
		entry[lastIndex] = e;
		while (lastIndex >= 0 && entry[lastIndex / 2].value < entry[lastIndex].value) {
			Entry temp = entry[lastIndex / 2];
			entry[lastIndex / 2] = entry[lastIndex];
			entry[lastIndex] = temp;
			lastIndex = lastIndex / 2;
		}
		
	}
	private static Entry extractMax(Entry[] entry) {
		if(n<=1) {
			return entry[0];
		}
		Entry max=entry[0];
		entry[0]=entry[n-1];
		n=n-1;
		buildMaxHeapify(entry, 0);
		return max;
	}
	private static void buildMaxHeap(Entry[] entry, int n) {
		for(int i=(int) (Math.floor(n/2)-1);i>=0;i--) {
			buildMaxHeapify(entry,i);
		}
		
	}
	private static void buildMaxHeapify(Entry[] entry, int i) {
		int left=2*i+1;
		int right=2*i+2;
		int largest=-1;
		if(left<=n-1) {
			if(right<=n-1) {
				if(entry[left].value>entry[right].value) {
					largest=left;
				}else {
					largest=right;
				}
			}else {
				largest=left;
			}
		}
		if(largest>=0 && entry[largest].value> entry[i].value) {
			Entry temp = entry[i];
			entry[i] = entry[largest];
			entry[largest] = temp;
			buildMaxHeapify(entry, largest);
		}
		
	}

}
