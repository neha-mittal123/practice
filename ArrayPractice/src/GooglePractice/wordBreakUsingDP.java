package GooglePractice;

import java.util.ArrayList;

public class wordBreakUsingDP {
    public static void main(String[]args){
        String[] dictionary = { "mobile", "samsung",  "sam",  "sung", "man",
                "mango",  "icecream", "and",  "go",   "i",
                "like",   "ice",      "cream" };
        ArrayList<String> dic=new ArrayList<>();
        for(String s:dictionary)
            dic.add(s);
        System.out.println(checkWordBreak("ilikedog",dic));
    }

    private static boolean checkWordBreak(String s, ArrayList<String> dic) {
        boolean dp[]=new boolean[s.length()+1];
        dp[0]=true;
        for(int i=0;i<=s.length();i++){
            for(int j=0;j<i;j++){
                if(dp[j] && dic.contains(s.substring(j,i))){
                    dp[i]=true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}
