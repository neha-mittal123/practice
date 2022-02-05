package arrayPractice;

//Clone a linked list with next and random pointer in O(1) space
//Given a linked list having two pointers in each node. The first one points to the next node of the list, however, the other pointer is random and can point
// to any node of the list. Write a program that clones the given list in O(1) space, i.e., without any extra space.


public class CloneLinkedListWithNextAndRandomPointerInZeroSpace {
    class Node{
        int data;
        Node next,random;
        Node(int data){
            this.data=data;
            next=random=null;
        }


    }
    public static void main(String [] args){
        CloneLinkedListWithNextAndRandomPointerInZeroSpace c=new CloneLinkedListWithNextAndRandomPointerInZeroSpace();
        Node start = c.new Node(1);
        start.next = c.new Node(2);
        start.next.next = c.new Node(3);
        start.next.next.next = c.new Node(4);
        start.next.next.next.next = c.new Node(5);

        // 1's random points to 3
        start.random = start.next.next;

        // 2's random points to 1
        start.next.random = start;

        // 3's and 4's random points to 5
        start.next.next.random = start.next.next.next.next;
        start.next.next.next.random
                = start.next.next.next.next;

        // 5's random points to 2
        start.next.next.next.next.random = start.next;
        System.out.println("before cloning the linklist");
        print(start);
        System.out.println("after cloning the linklist");
        print(clone(start,c));

    }

    private static Node clone(Node start, CloneLinkedListWithNextAndRandomPointerInZeroSpace c) {
        Node curr=start,temp=null;
        while(curr!=null){
            temp=curr.next;
            curr.next=c.new Node(curr.data);
            curr.next.next=temp;
            curr=temp;
        }
        curr=start;
        while(curr!=null){
            curr.next.random=curr.random.next;
            curr=curr.next.next;
        }
        Node original=start,cloned=start.next;
        temp=cloned;
        while(original!=null){
            original.next=original.next.next;
            temp.next=temp.next!=null?temp.next.next:temp.next;
            original=original.next;
            temp=temp.next;
        }
        return cloned;
    }

    private static void print(Node start) {
        Node curr=start;
        while(curr!=null){
            System.out.println(curr.data);
            curr=curr.next;
        }
    }
}
