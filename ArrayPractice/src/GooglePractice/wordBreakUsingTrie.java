package GooglePractice;

public class wordBreakUsingTrie {
    static class Trie{
        Trie[] children;
        boolean isEndOfword;
        Trie(){
            children=new Trie[26];
            isEndOfword=false;
            for(Trie t:children)
                t=null;
        }
    }

    public static void main(String[] args){
        String[] dictionary = { "mobile", "samsung",  "sam",  "sung", "man",
                "mango",  "icecream", "and",  "go",   "i",
                "like",   "ice",      "cream" };
        Trie root=new Trie();
        for(String s:dictionary){
            insert(root,s);
        }
        System.out.println(checkWordBreak("ilike",root));
    }

    private static boolean checkWordBreak(String s, Trie root) {
        if(s.length()==0)
            return true;
        for(int i=0;i<=s.length();i++){
            if(search(s.substring(0,i),root) && checkWordBreak(s.substring(i,s.length()),root)){
                return true;
            }
        }
        return false;
    }

    private static boolean search(String s, Trie root) {
        Trie curr=root;
        for(int i=0;i<s.length();i++){
            int temp=s.charAt(i)-'a';
            if(curr.children[temp]==null){
                return false;
            }
            curr=curr.children[temp];
        }
        return curr.isEndOfword;
    }

    private static void insert(Trie root, String s) {
        Trie curr=root;
        for(int i=0;i<s.length();i++){
            int temp=s.charAt(i)-'a';
            if(curr.children[temp]==null){
                curr.children[temp]=new Trie();
            }
            curr=curr.children[temp];
        }
        curr.isEndOfword=true;
    }
}
