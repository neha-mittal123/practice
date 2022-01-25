package arrayPractice;

import java.util.*;

//Print all permutations of a string keeping the sequence but changing cases.
//Input : ab
//Output : AB Ab ab aB

public class PermutationOfStringByChangingCase {

	public static void main(String[] args) {
		String s="a1B2";
		List<String> result=new ArrayList<>();
		ArrayList<String> list=findPermutations(s,result,0);
		for(String st:list) {
			System.out.println(st);
		}

	}

	private static ArrayList<String> findPermutations(String s, List<String> result, int start) {
		result.add(s);
		for(int i=start;i<s.length();i++) {
			char[] word=s.toCharArray();
			if(!Character.isDigit(s.charAt(i))) {
				if(Character.isUpperCase(s.charAt(i))) {
					word[i]=Character.toLowerCase(s.charAt(i));
					findPermutations(String.valueOf(word), result, i+1);
				}else {
					word[i]=Character.toUpperCase(s.charAt(i));
					findPermutations(String.valueOf(word), result, i+1);
				}
			}
		}
		return (ArrayList<String>) result;
	}

}
