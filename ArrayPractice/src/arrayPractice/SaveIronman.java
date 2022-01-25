package arrayPractice;

/*Jarvis is weak in computing palindromes for Alphanumeric characters.
While Ironman is busy fighting Thanos, he needs to activate sonic punch but Jarvis 
is stuck in computing palindromes.
You are given a string S containing alphanumeric characters. 
Find out whether the string is a palindrome or not.
If you are unable to solve it then it may result in the death of Iron Man.*/

public class SaveIronman {

	public static void main(String[] args) {
		String s = "I An :IronnorI Ma, i";
		checkPallindrome(s);
	}

	private static void checkPallindrome(String s) {
		char ch[] = s.toCharArray();
		for(int q = 0;q<ch.length;q++)
	    {
	        if(ch[q]>=97 && ch[q]<=122)
	        {
	            ch[q] = (char) ((char)ch[q]-32);
	        }
	    }
		int i,j=0;
		for(i=0,j=ch.length-1;j>=i;i++,j--) {
			while(ch[i]<65 || ch[i]>90) {
				//System.out.println(ch[i]);
				i++;
			}
			while(ch[j]<65 || ch[j]>90) {
				//System.out.println(ch[j]);
				j--;
			}
			if(ch[i] == ch[j]) {
				//System.out.println(ch[i]);
				i++;
				j--;
			}else {
				System.out.println("No");
				break;
			}
		}
		if(i<j) {
			System.out.println("Yes");
		}
			

		
	}

}
