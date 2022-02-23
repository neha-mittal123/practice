package GooglePractice;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class UniqueWordAbbreviation {
    static HashMap<String,Set<String>> dictionary=new HashMap<String, Set<String>>();
    public static void main(String[] args){
        String[] arr={"deer", "door", "cake", "card" };
        preProcessGivenDic(arr);
        String s1="dear";
        System.out.println(isUnique(s1));
        System.out.println(isUnique("cart"));
        System.out.println(isUnique("cane"));
        System.out.println(isUnique("make"));
        System.out.println(isUnique("poor"));
    }

    private static boolean isUnique(String s) {
        String key=buildKey(s);
        if(!dictionary.containsKey(key)){
            return true;
        }else{
            return dictionary.get(key).contains(s) && dictionary.get(key).size()<=1;
        }
    }

    private static void preProcessGivenDic(String[] arr) {
        for(String s:arr){
            String key=buildKey(s);
            if(dictionary.containsKey(key)){
                dictionary.get(key).add(s);
            }else{
                Set<String> temp=new HashSet<>();
                temp.add(s);
                dictionary.put(key,temp);
            }
        }
    }

    private static String buildKey(String s) {
        if(s.length()<=2){
            return s;
        }
        return s.charAt(0)+Integer.toString(s.length()-2)+s.charAt(s.length()-1);
    }
}