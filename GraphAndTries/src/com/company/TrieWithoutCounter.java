package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.ListIterator;

public class TrieWithoutCounter {

    static class Node{
        Node[] trieNodes=new Node[26];
        boolean flag=false;

        boolean containsKey(Character ch){
            return trieNodes[ch-'a']!=null;
        }

        void setFlag(boolean val){
            flag=val;
        }

        boolean getFlag(){
            return flag;
        }
    }
    static Node root=new Node();

    static int index = 0;

    public static void main(String args[]){
        System.out.println("inserting words in trie");
        /*String words[]={"apple","apps","bat","bac","cat","rat","apxl"};
        for(int i=0;i<words.length;i++){
            insert(words[i]);
        }

        System.out.println("searching a word in trie");
        for(int i=0;i<words.length;i++){
            System.out.println("searching "+words[i]+" in trie----"+search(words[i]));
        }
        System.out.println("searching cattle in trie----"+search("cattle"));*/

        String prefix="cb";
        System.out.println("searching word starting with "+prefix+" "+searchStartsWith(prefix));

        System.out.println("find longest word with all prefixes given in the input array");
        String[] input={"n","ni","nin","ninj","ninja","ninga","ning"};
        for(int i=0;i<input.length;i++){
            insert(input[i]);
        }
        String longest = "";
        for(String s : input){
            boolean isCompleteString = findLongestStringWithAllPrefixes(s);
            if(isCompleteString){
                if(s.length()>longest.length()){
                    longest = s;
                }else if(s.length() == longest.length() && s.compareTo(longest)<0){
                    longest = s;
                }
            }
        }
        System.out.println(longest);

        System.out.println("Longest common prefix in a given array of words----"+searchLongestPrefix());

        String str="abab";
        System.out.println("finding no of distinct substring in a "+str+" is "+findNoOfDistinctSubStringsInString(str));

        System.out.println("Finding all words starting with a prefix:");
        PrintPaths(root,new ArrayList<>());
    }

    private static void PrintPaths(Node root1, ArrayList<Character> path) {

        if (root1 == null)
            return;

        if (root1.flag == true) {
            //print the entire path
            ListIterator<Character> itr1 = path.listIterator();
            while (itr1.hasNext()) {
                System.out.print(itr1.next());
            }
            System.out.println();
            return;
        } else {
            for(int i=0;i<root1.trieNodes.length;i++){
                Node child = root1.trieNodes[i];
                int c = i+'a';
                char c1 = (char)c;
                path.add(c1);
                PrintPaths(child, path);
                path.remove(path.size() - 1);

            }
        }
    }

    private static int findNoOfDistinctSubStringsInString(String str) {
        Node node=root;
        int counter=1;
        for(int i=0;i<str.length();i++){
            for(int j=i;j<str.length();j++){
                if(!node.containsKey(str.charAt(j))){
                    node.trieNodes[str.charAt(j)-'a']=new Node();
                    counter++;
                }
                node=node.trieNodes[str.charAt(j)-'a'];
            }
            node = root;
        }
        return counter;
    }

    private static int NoOfChildrensOfCurrentTrieode(Node node){
        int count = 0;

        for(int i=0;i<26;i++){
            if(node.trieNodes[i] != null){
                count++;
                index = i;
            }
        }
        return count;
    }
    private static String searchLongestPrefix() {
        Node node = root;
        StringBuilder prefix = new StringBuilder();

        while(NoOfChildrensOfCurrentTrieode(node) == 1 && node.getFlag() == false){
            node = node.trieNodes[index];
            char curr = (char) ('a' + index);
            prefix.append(curr);
        }
        return prefix.toString();
    }

    private static boolean findLongestStringWithAllPrefixes(String word) {
        Node node = root;
        for(int i=0;i<word.length();i++){
            if(node.containsKey(word.charAt(i))){
                node = node.trieNodes[word.charAt(i)-'a'];
                if(node.getFlag()){
                    continue;
                }else{
                    return false;
                }
            }else{
                return false;
            }
        }
        return true;
    }

    private static boolean searchStartsWith(String prefix) {
        Node node =root;
        for(int i=0;i<prefix.length();i++){
            if(node.containsKey(prefix.charAt(i))){
                node=node.trieNodes[prefix.charAt(i)-'a'];
            }else{
                return false;
            }
        }
        return true;
    }

    private static boolean search(String word) {
        Node node=root;
        for(int i=0;i<word.length();i++){
            if(node.containsKey(word.charAt(i))){
                node=node.trieNodes[word.charAt(i)-'a'];
            }else{
                return false;
            }
        }
        return node.getFlag();
    }

    private static void insert(String word) {
        Node node=root;
        for(int i=0;i<word.length();i++){
            if(!node.containsKey(word.charAt(i))){
                node.trieNodes[word.charAt(i)-'a']=new Node();
            }
            node=node.trieNodes[word.charAt(i)-'a'];
        }
        node.setFlag(true);
    }
}
