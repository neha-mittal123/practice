package GooglePractice;

import java.util.HashSet;

public class CheckPalindromePermutation {
    public static void main(String[] args){
        String [] str={"code","aab","carerac"};
        for(boolean b:check(str)){
            System.out.print(b+" ");
        }
    }

    private static boolean[] check(String[] str) {
        boolean[] arr=new boolean[str.length];
        for(int i=0;i<str.length;i++){
            arr[i]=checkPermut(str[i]);
        }
        return arr;
    }

    private static boolean checkPermut(String s) {
        HashSet<Character> set=new HashSet<>();
        for(int i=0;i<s.length();i++){
            if(set.contains(s.charAt(i))){
                set.remove(s.charAt(i));
            }else{
                set.add(s.charAt(i));
            }
        }
        return set.size()<=1;
    }
}