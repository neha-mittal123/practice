package GooglePractice;

import java.util.LinkedList;
import java.util.Queue;

public class FindListOfStrobogrammaticNumber {

    public static void main(String args[]){
        int n = 4;
        Queue<String> result;
        result = findStrobogrammaticNumber(n);
        for(String s : result){
            System.out.println(s);
        }
    }

    private static Queue<String> findStrobogrammaticNumber(int n) {
        Queue<String> result = new LinkedList<String>();
        if(n%2 !=0){
            result.offer("0");
            result.offer("1");
            result.offer("8");
            n--;
        }else{
            result.offer("");
        }
        while(n-2 >= 0){
            Queue<String> temp = new LinkedList<>();
            for(String s : result){
                if(n-2 != 0){
                    temp.offer("0"+ s + "0");
                }
                temp.offer("1"+ s + "1");
                temp.offer("8"+ s + "8");
                temp.offer("6"+ s + "9");
                temp.offer("9"+ s + "6");
            }
            result = temp;
            n = n-2;
        }
        return result;
    }
}
