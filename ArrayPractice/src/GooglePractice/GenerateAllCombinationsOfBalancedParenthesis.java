package GooglePractice;

//Write a function to generate all possible n pairs of balanced parentheses.
//
//        Examples:
//
//        Input: n=1
//        Output: {}
//        Explanation: This the only sequence of balanced
//        parenthesis formed using 1 pair of balanced parenthesis.
//
//        Input : n=2
//        Output:
//        {}{}
//        {{}}
//        Explanation: This the only two sequences of balanced
//        parenthesis formed using 2 pair of balanced parenthesis.

public class GenerateAllCombinationsOfBalancedParenthesis {

    public static void main(String[] args){
        int n=3;
        printAllCombos(n);
    }

    private static void printAllCombos(int n) {
        char []str=new char[n*2];
        printAllCombosUtil(str,n,0,0,0);
    }

    private static void printAllCombosUtil(char[] str, int n, int pos, int open, int close) {
        if(close==n){
            for(char s : str){
                System.out.print(s+" ");
            }
            System.out.println();
            return;
        }else{
            if(open>close){
                str[pos]='}';
                printAllCombosUtil(str,n,pos+1,open,close+1);
            }
            if(open<n){
                str[pos]='{';
                printAllCombosUtil(str,n,pos+1,open+1,close);
            }
        }
    }
}
