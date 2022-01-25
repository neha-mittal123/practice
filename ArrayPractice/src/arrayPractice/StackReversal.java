package arrayPractice;

import java.util.Stack;

public class StackReversal {
	stackNode top;
	 static class stackNode{
		 int data ;
		 stackNode next;
		 
		public stackNode(int data) {
			super();
			this.data = data;
			this.next=null;
		}
		 
	 }

	public static void main(String[] args) {
		Stack<Integer> s=new Stack<>();
		s.push(1);
		s.push(2);
		s.push(3);
		reverse(s);
		System.out.println();
		StackReversal sR=new StackReversal();
		sR.push(1);
		sR.push(2);
		sR.push(3);
		display(sR);
		reversal(sR);
		System.out.println("after reverse");
		display(sR);
	}

	private static void display(StackReversal sR) {
		System.out.println("inside display");
		stackNode s=sR.top;
		while(s!=null) {
			System.out.print(s.data+" ");
			s=s.next;
		}
		
	}

	private static void reversal(StackReversal sR) {
		stackNode curr=null,prev=null,succ=null;
		prev=curr=sR.top;
		curr=curr.next;
		while(curr!=null) {
			succ=curr.next;
			curr.next=prev;
			prev=curr;
			curr=succ;
		}
		sR.top=prev;
		
	}

	private void push(int data) {
		if(this.top==null) {
			this.top=new stackNode(data);
			return;
		}
		stackNode s=new stackNode(data);
		s.next=this.top;
		this.top=s;
		
	}

	private static void reverse(Stack<Integer> s) {
		if(s.isEmpty()) {
			return ;
		}
		int currElelemt = s.pop();
		reverse(s);
		System.out.print(currElelemt+" ");
		
	}

}
