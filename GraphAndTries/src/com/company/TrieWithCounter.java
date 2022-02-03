package com.company;

public class TrieWithCounter {

    static class Node{
        Node[] trieNodes=new Node[26];
        int completeWordCounter=0,prefixCounter=0;

        boolean containsKey(Character ch){
            return trieNodes[ch-'a']!=null;
        }

        public void setCompleteWordCounter(int completeWordCounter) {
            this.completeWordCounter = completeWordCounter;
        }

        public void setPrefixCounter(int prefixCounter) {
            this.prefixCounter = prefixCounter;
        }

        public int getCompleteWordCounter() {
            return completeWordCounter;
        }

        public int getPrefixCounter() {
            return prefixCounter;
        }
    }

    static Node root=new Node();

    public static void main(String[] args) {
        System.out.println("inserting words in trie");
        String words[]={"apple","apple","apps","back","bat","bac","cat","rat","apxl"};
        for(int i=0;i<words.length;i++){
            insert(words[i]);
        }

        System.out.println("searching a word in trie");
        for(int i=0;i<words.length;i++){
            System.out.println("searching "+words[i]+" in trie----"+search(words[i]));
        }
        System.out.println("searching cattle in trie----"+search("cattle"));

        String prefix="bac";
        System.out.println("searching word starting with "+prefix+" "+searchStartsWith(prefix));

        String wordToErase="apple";
        System.out.println("erasing "+wordToErase+" from trie "+erase(wordToErase));


    }

    private static int erase(String wordToErase) {
        Node node=root;
        for(int i=0;i<wordToErase.length();i++){
            if(!node.containsKey(wordToErase.charAt(i))){
                return 0;
            }else{
                node=node.trieNodes[wordToErase.charAt(i)-'a'];
                node.setPrefixCounter(node.getPrefixCounter()-1);
            }
        }
        node.setCompleteWordCounter(node.getCompleteWordCounter()-1);
        return node.getCompleteWordCounter();
    }

    private static int searchStartsWith(String prefix) {
        Node node=root;
        for(int i=0;i<prefix.length();i++){
            if(!node.containsKey(prefix.charAt(i))){
                return 0;
            }else{
                node=node.trieNodes[prefix.charAt(i)-'a'];
            }
        }
        return node.getPrefixCounter();
    }

    private static int search(String word) {
        Node node=root;
        for(int i=0;i<word.length();i++){
            if(!node.containsKey(word.charAt(i))){
                return 0;
            }else{
                node=node.trieNodes[word.charAt(i)-'a'];
            }
        }
        return node.getCompleteWordCounter();
    }

    private static void insert(String word) {
        Node node =root;
        for(int i=0;i<word.length();i++){
            if(!node.containsKey(word.charAt(i))){
                node.trieNodes[word.charAt(i)-'a']=new Node();
            }
            node=node.trieNodes[word.charAt(i)-'a'];
            node.setPrefixCounter(node.getPrefixCounter()+1);
        }
        node.setCompleteWordCounter(node.getCompleteWordCounter()+1);
    }
}
