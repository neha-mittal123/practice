package arrayPractice;

public class LongestVowelSubsequence {
    public static void main(String[] args){
        System.out.println(longestVowelSubsequence("aeiou"));
    }

    public static int longestVowelSubsequence(String s) {
        // Write your code here
        int i = 0;
        int A=0,E=0,I=0,O=0,U=0;
        for(i=0;i<s.length();i++){
            if(s.charAt(i) == 'a'){
                break;
            }
        }
        while(i<s.length()){
            char ch = s.charAt(i);
            if(ch == 'a'){
                A=A+1;
            }else if(ch == 'e'){
                E=Math.max(E,A)+1;
            }else if(ch == 'i'){
                I = Math.max(E,I)+1;
            }else if(ch == 'o'){
                O = Math.max(I,O)+1;
            }else if(ch == 'u'){
                U = Math.max(O, U)+1;
            }
            i++;
        }
        return U;
    }
}
