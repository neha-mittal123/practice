package arrayPractice;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Set;

public class LRUImplementation {
	Set<Integer> cache;
	int capacity;

	public LRUImplementation( int capacity) {
		super();
		this.cache=new LinkedHashSet<Integer>();
		this.capacity = capacity;
	}

	public static void main(String[] args) {
		LRUImplementation ca=new LRUImplementation(4);
		ca.refer(1);
        ca.refer(2);
        ca.refer(3);
        ca.refer(1);
        ca.refer(4);
        ca.refer(5);
        ca.display();

	}

	private void display() {
		LinkedList<Integer> list=new LinkedList<Integer>(cache);
		Iterator<Integer> itr=list.descendingIterator();
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}
		
	}

	private void refer(int key) {
		if(get(key)==false) {
			put(key);
		}
		
	}

	private void put(int key) {
		if(cache.size()==capacity) {
			int firstElement=cache.iterator().next();
			cache.remove(firstElement);
		}
		cache.add(key);
	}

	private boolean get(int key) {
		if(!cache.contains(key)) {
			return false;
		}else {
			cache.remove(key);
			cache.add(key);
			return true;
		}
		
	}

}
