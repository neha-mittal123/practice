package GooglePractice;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/*Given an integer array containing digits from [0, 9], the task is to print all possible letter combinations that the numbers could represent.

        A mapping of digit to letters (just like on the telephone buttons) is being followed. Note that 0 and 1 do not map to any letters. All the mapping are shown in the image below:

        Input: arr[] = {2, 3}
        Output: ad ae af bd be bf cd ce cf

        Input: arr[] = {9}
        Output: w x y z*/
public class IterativeLetterCombinationOfPhoneNumber {
    public static void main(String args[])
    {
        int[] number = { 2, 3 };
        int n = number.length;

        // Function call
        letterCombinations(number, n);
    }

    private static void letterCombinations(int[] number, int n) {
        String[] table
                = { "0",   "1",   "abc",  "def", "ghi",
                "jkl", "mno", "pqrs", "tuv", "wxyz" };
        ArrayList<String> list=findLetterCombos(number,n,table);
        for(String s:list){
            System.out.print(s+" ");
        }
    }

    private static ArrayList<String> findLetterCombos(int[] number, int n, String[] table) {
        ArrayList<String> list=new ArrayList<>();
        Queue<String> queue=new LinkedList<>();
        queue.add("");
        while(!queue.isEmpty()){
            String temp=queue.remove();
            if(temp.length()==n){
                list.add(temp);
            }else{
                String currVal=table[number[temp.length()]];
                for(int i=0;i<currVal.length();i++){
                    queue.add(temp+currVal.charAt(i));
                }
            }
        }
        return list;
    }
}
