package GooglePractice;

//Given a string s, return all the palindromic permutations (without duplicates) of it. Return an empty list if no palindromic permutation could be form.
//
//        For example:
//
//        Given s = "aabb", return ["abba", "baab"].
//
//        Given s = "abc", return [].

import java.util.ArrayList;
import java.util.List;

public class PalindromePermutation {
    public static void main(String[] args){
        String s="aabb";
        for(String string:generatePalindromes(s)){
            System.out.print(string+" ");
        }
    }

    private static List<String> generatePalindromes(String s) {
        int[] frequency=new int[256];
        for(int i=0;i<s.length();i++){
            frequency[s.charAt(i)] +=1;
        }
        boolean odd=false;
        int oddIndex=0;
        List<String > result=new ArrayList<>();
        for(int i=0;i<256;i++){
            if(frequency[i]%2==1){
                if(odd){
                    return result;
                }
                odd=true;
                oddIndex=i;
            }
        }
        String base="";
        if(odd){
            base=(char)oddIndex+"";
            frequency[oddIndex]--;
        }
        process(result,base,frequency,s.length());
        return result;
    }

    private static void process(List<String> result, String base, int[] frequency, int length) {
        if(base.length()==length)
            result.add(base);
        for(int i=0;i<frequency.length;i++){
            if(frequency[i]>0){
                frequency[i] -=2;
                process(result,(char)i+base+(char)i,frequency,length);
                frequency[i] +=2;
            }
        }
    }
}