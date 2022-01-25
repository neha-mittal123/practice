package arrayPractice;

import java.util.Stack;

public class ImplementQueueUsingStack {
	
	private static class Queue{
		Stack<Integer> s1;
		Stack<Integer> s2;
	}

	public static void main(String[] args) {
		Queue q=new Queue();
		q.s1=new Stack<Integer>();
		q.s2=new Stack<Integer>();
		enqueue(q,1);
		enqueue(q,2);
		enqueue(q,3);
		enqueue(q,4);
		System.out.println(dequeue(q));
		System.out.println(dequeue(q));
		System.out.println(dequeue(q));
		System.out.println(dequeue(q));
	}

	private static int dequeue(Queue q) {
		if(q.s1.isEmpty() && q.s2.isEmpty()) {
			System.out.println("empty");
			return 0;
		}else {
			while(!q.s1.isEmpty()) {
				q.s2.push(q.s1.pop());
			}
			return q.s2.pop();
		}
		
	}

	private static void enqueue(Queue q, int i) {
		q.s1.push(i);	
	}

}
