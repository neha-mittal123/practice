package GooglePractice;

import java.util.ArrayList;
import java.util.Arrays;

public class GeneralizedAbbreviation {
    public static void main(String[] args){
        String word="word";
        for(String s:generateAbbriviations(word)){
            System.out.print(s+" ");
        }
    }

    private static ArrayList<String> generateAbbriviations(String word) {
        ArrayList<String> result=new ArrayList<>();
        helper(result,"",word,0,0);
        return result;
    }

    private static void helper(ArrayList<String> result, String curr, String word, int pos, int count) {
        if(pos==word.length()){
            if(count>0){
                curr +=count;
            }
            result.add(curr);
        }else{
            helper(result,curr,word,pos+1,count+1);
            helper(result,curr+(count>0?count:"")+word.charAt(pos),word,pos+1,0);
        }
    }
}
