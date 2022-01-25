package arrayPractice;

public class AddTwoLinkedList {
	static Node head1,head2,res;
	static AddTwoLinkedList list = new AddTwoLinkedList();
	class Node{
		int data;
		Node next;
		public Node(int data) {
			super();
			this.data = data;
		}
		public Node() {
		}
		
	}

	public static void main(String[] args) {
		
//        list.head1 = null;
//        list.head2 = null;
//        list.res = null;
        int arr1[] = { 9, 9, 9 };
        int arr2[] = { 1, 8 };
 
        // Create first list as 9->9->9
        for (int i = arr1.length - 1; i >= 0; --i)
            list.push(arr1[i], 1);
 
//        while(head1!=null) {
//        	System.out.println(head1.data);
//        	head1=head1.next;
//        }
        	
        // Create second list as 1->8
        for (int i = arr2.length - 1; i >= 0; --i)
            list.push(arr2[i], 2);
//        while(head2!=null) {
//        	System.out.println(head2.data);
//        	head2=head2.next;
//        }
        
        int oldCarry=addTwoLists(head1,arr1.length,head2,arr2.length);
		res.next=list.new Node(oldCarry);
//		while(res!=null) {
//			System.out.println(res.data);
//			res=res.next;
//		}
	}
	private static int addTwoLists(Node head1, int length1, Node head2, int length2) {
		int data=0;
		if(length1>length2) {
			int oldCarry=addTwoLists(head1.next, length1-1, head2, length2);
			data=head1.data+oldCarry;
		}else if(length1<length2) {
			int oldCarry=addTwoLists(head1, length1, head2.next, length2-1);
			data=head2.data+oldCarry;
		}else {
			int oldCarry=addTwoLists(head1.next, length1-1, head2.next, length2-1);
			data=head2.data+oldCarry+head1.data;
		}
		int newData=data%10;
		int newCarry=data/10;
		res.next=list.new Node(newData);
		return newCarry;
	}
	void push(int val, int list)
    {
        Node newnode = new Node(val);
        if (list == 1)
        {
            newnode.next = head1;
            head1 = newnode;
        }
        else if (list == 2)
        {
            newnode.next = head2;
            head2 = newnode;
        }
        else
        {
            newnode.next = res;
            res = newnode;
        }
 
    }

}
