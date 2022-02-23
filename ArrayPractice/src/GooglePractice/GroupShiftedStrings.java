package GooglePractice;

//Given a string, we can "shift" each of its letter to its successive letter, for example: "abc" -> "bcd". We can keep "shifting" which forms the sequence:
//
//        "abc" -> "bcd" -> ... -> "xyz"
//        Given a list of strings which contains only lowercase alphabets, group all strings that belong to the same shifting sequence.
//
//        For example, given: ["abc", "bcd", "acef", "xyz", "az", "ba", "a", "z"], Return:
//
//        [
//        ["abc","bcd","xyz"],
//        ["az","ba"],
//        ["acef"],
//        ["a","z"]
//        ]
//        Note: For the return value, each inner list's elements must follow the lexicographic order.
//
//        things to consider: 1 does each group allow duplicates, such as ["a", "a"]. 2 how to calculate unique hash key.

import java.util.*;

public class GroupShiftedStrings {
    public static void main(String[] args){
        String[] arr={"abc", "bcd", "acef", "xyz", "az", "ba", "a", "z"};
        for(List<String> list :groupStrings(arr)){
            for(String s:list){
                System.out.print(s+" ");
            }
        }
    }

    private static List<List<String>> groupStrings(String[] arr) {
        HashMap<String, ArrayList<String>> map=new HashMap<>();
        for(String s:arr){
            String hash=getHash(s);
            if(map.containsKey(hash)){
                map.get(hash).add(s);
            }else{
                ArrayList<String> list=new ArrayList<>();
                list.add(s);
                map.put(hash,list);
            }
        }
        return new ArrayList<List<String>>(map.values());
    }

    private static String getHash(String s) {
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<s.length();i++){
            sb.append((s.charAt(i)-s.charAt(0)+26)%26);
            sb.append(".");
        }
        return sb.toString();
    }
}