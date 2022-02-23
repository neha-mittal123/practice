package GooglePractice;

//You are playing the following Flip Game with your friend: Given a string that contains only these two characters: + and -, you and your friend take turns to flip two consecutive "++" into "--". The game ends when a person can no longer make a move and therefore the other person will be the winner.
//        Write a function to compute all possible states of the string after one valid move.
//        For example, given s = "++++", after one move, it may become one of the following states:
//        [    "--++",    "+--+",    "++--"  ]
//
//        If there is no valid move, return an empty list [].

import java.util.ArrayList;
import java.util.Arrays;

public class FlipGame {
    public static void main(String[] args){
        String s="++--";
        for(String str:findAllValidMoves(s)){
            //System.out.print(str+" ");
        }
    }

    private static ArrayList<String> findAllValidMoves(String s) {
        ArrayList<String > list=new ArrayList<>();
        char[] arr=s.toCharArray();
        for(int i=0;i<arr.length-1;i++){
            if(arr[i]== '+' && s.charAt(i+1)=='+'){
                arr[i]=arr[i+1]='-';
                list.add(arr.toString());
                arr[i]=arr[i+1]='+';
            }
        }
        for(String str:list)
            System.out.print(str+" ");
        return list;
    }
}