package arrayPractice;

//Given a list of list of positive integers stacks, you can take any stack(s) in stacks and pop any number of elements. Return the maximum sum that can be achieved such that all stacks have the same sum.
//
//        Constraints
//
//        n * m ≤ 500,000 where n and m are the number of rows and columns in stacks
//        Example 1
//        Input
//        stacks = [
//        [2, 3, 4, 5],
//        [4, 5, 2, 3, 3],
//        [9, 1, 1, 1]
//        ]
//        Output
//        9
//        Explanation
//        Here are the operations we can take
//
//        Pop [5] from the first stack to get [2, 3, 4] for a sum of 9.
//        Pop [2, 3, 3] from the second stack to get [4, 5] for a sum of 9.
//        Pop [1, 1, 1] from the first stack to get [9] for a sum of 9.

public class MaximumEqualSumofEveryStacks {
    public static void main(String[] args){
        int[] stack1={2, 3, 4, 5};//14
        int[] stack2={4, 5, 2, 3, 3};//17
        int[] stack3={9, 1, 1, 1};//13
        System.out.println(maxSum(stack1,stack2,stack3));
    }

    private static int maxSum(int[] stack1, int[] stack2, int[] stack3) {
        int n1=stack1.length,n2=stack2.length,n3=stack3.length;
        int sum1=0,sum2=0,sum3=0,top1=0,top2=0,top3=0,ans=0;
        for(int i: stack1){
            sum1 +=i;
        }
        for(int i: stack2){
            sum2 +=i;
        }
        for(int i: stack3){
            sum3 +=i;
        }
        while(true) {
            if(n1==top1 || n2==top2 || n3==top3){
                return 0;
            }
            if(sum1==sum2 && sum2==sum3){
                return sum1;
            }
            if(sum1>=sum2 && sum1>=sum3){
                sum1 -=stack1[top1++];
            }else if(sum2>=sum1 && sum2>=sum3){
                sum2 -=stack2[top2++];
            }else if(sum3>=sum1 && sum3>=sum1){
                sum3 -=stack3[top3++];
            }
        }
    }

}
