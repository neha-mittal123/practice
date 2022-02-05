package GooglePractice;

import java.util.Stack;

//Design a stack that supports getMin() in O(1) time and O(1) extra space
//        Question: Design a Data Structure SpecialStack that supports all the stack operations like push(), pop(), isEmpty(), isFull() and an additional operation getMin() which should return minimum element from the SpecialStack. All these operations of SpecialStack must be O(1). To implement SpecialStack, you should only use standard Stack data structure and no other data structure like arrays, list, .. etc.
//        Example:
//
//
//        Consider the following SpecialStack
//        16  --> TOP
//        15
//        29
//        19
//        18
//
//        When getMin() is called it should return 15,
//        which is the minimum element in the current stack.
//
//        If we do pop two times on stack, the stack becomes
//        29  --> TOP
//        19
//        18
//
//        When getMin() is called, it should return 18
//        which is the minimum in the current stack.
public class MinStack {
    Stack<Node> stack;
    Integer minElement;
    Stack<Integer> stackDifferently;
    MinStack(){
        this.stack=new Stack<>();
        this.stackDifferently=new Stack<>();
    }
    class Node{
        int min,val;
        Node(int min,int val){
            this.min=min;
            this.val=val;
        }
    }
    public static void main(String[] args){
        MinStack minStack=new MinStack();
        minStack.push(-1);
        minStack.push(10);
        minStack.push(-4);
        minStack.push(0);
        System.out.println(minStack.getMin());
        System.out.println(minStack.getTop());


        minStack.pushDifferently(-1);
        minStack.pushDifferently(10);
        minStack.pushDifferently(-4);
        minStack.pushDifferently(0);
        System.out.println(minStack.getMinDifferently());
        minStack.popDifferetly();
        System.out.println(minStack.printTopStackDifferentlyElement());
    }

    private int printTopStackDifferentlyElement() {
        int top=stackDifferently.peek();
        if(top>minElement){
            return top;
        }else{
            return minElement;
        }
    }

    private void popDifferetly() {
        int s=stackDifferently.pop();
        if(s<minElement){
            minElement=2*minElement-s;
        }
    }

    private int getMinDifferently() {
        return minElement;
    }

    private void pushDifferently(int i) {
        if(this.stackDifferently.isEmpty()){
            this.stackDifferently.push(i);
            minElement=i;
            return;
        }
        if(i>=minElement){
            this.stackDifferently.push(i);
        }else{
            stackDifferently.push(2*i-minElement);
            minElement=i;
        }
    }

    private int getTop() {
        return this.stack.peek().val;
    }

    private int getMin() {
        return this.stack.peek().min;
    }

    private void push(int i) {
        if(this.stack.isEmpty()){
            this.stack.push(new Node(i,i));
        }else{
            int min=Math.min(this.stack.peek().min,i);
            this.stack.push(new Node(min,i));
        }
    }
}
