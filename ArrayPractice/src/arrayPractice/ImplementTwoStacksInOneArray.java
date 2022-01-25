package arrayPractice;

public class ImplementTwoStacksInOneArray {

	public static void main(String[] args) {
		TwoStack stack = new TwoStack();

	}
	
	void push1(int x, TwoStack sq)
    {
        if(sq.size-sq.top1+(sq.size-sq.top2)>0) {
        	sq.top1++;
        	sq.arr[sq.top1] = x;
        }
    }

    /* The method push to push element into the stack 2*/
    void push2(int x, TwoStack sq)
    {
    	if(sq.size-sq.top1+(sq.size-sq.top2)>0) {
    		sq.top2--;
        	sq.arr[sq.top2] = x;
        }
    }

    /* The method pop to pop element from the stack 1 */
    //Return the popped element
    int pop1(TwoStack sq)
    {
        if(sq.top1 == -1) {
        	return -1;
        }else {
        	int z = sq.arr[sq.top1];
        	sq.top1--;
        	return z;
        }
    }

    /* The method pop to pop element from the stack 2 */
    //Return the popper element
    int pop2(TwoStack sq)
    {
    	if(sq.top2 == sq.size) {
        	return -1;
        }else {
        	int z = sq.arr[sq.top2];
        	sq.top2++;
        	return z;
        }
    }

}
