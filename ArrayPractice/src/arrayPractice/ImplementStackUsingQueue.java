package arrayPractice;

import java.util.LinkedList;
import java.util.Queue;


public class ImplementStackUsingQueue {
	
	private static class Stack{
		Queue<Integer> q1=new LinkedList<Integer>();
		Queue<Integer> q2=new LinkedList<Integer>();
		
	public void push(int i) {
			q1.add(i);
		}

	public int pop() {
		if(q1.isEmpty() && q2.isEmpty()) {
			return 0;
		}else {
			while(q1.size()!=1) {
				q2.add(q1.peek());
				q1.remove();
			}
			int res= q1.remove();
			Queue<Integer> q=q1;
			q1=q2;
			q2=q;
			return res;
		}
	}
	}

	public static void main(String[] args) {
		Stack s=new Stack();
		s.push(1);
		s.push(2);
		s.push(3);
		s.push(4);
		s.push(5);
		System.out.println(s.pop());
		System.out.println(s.pop());
		System.out.println(s.pop());
		System.out.println(s.pop());
		System.out.println(s.pop());
		}
}
