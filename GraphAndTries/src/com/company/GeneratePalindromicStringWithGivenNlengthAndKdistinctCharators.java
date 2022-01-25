package com.company;

public class GeneratePalindromicStringWithGivenNlengthAndKdistinctCharators {
    public static void main(String [] args){
        int n=5,k=2;
        String res=findPalindromicString(n,k);
        System.out.println(res);
    }

    private static String findPalindromicString(int n, int k) {
        StringBuilder res=new StringBuilder();
        res.setLength(n);
        int distinctCharactors=k;
        for(int i=0,j=res.length()-1;i<=j;i++,j--){
            res.setCharAt(i,(char)('a'+k));
            res.setCharAt(j,(char)('a'+k));
            k--;
            if (k == 0) {
                k=distinctCharactors;
            }
        }
        return res.toString();
    }
}
