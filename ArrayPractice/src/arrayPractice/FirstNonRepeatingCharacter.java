package arrayPractice;

import java.util.ArrayList;

public class FirstNonRepeatingCharacter {

	public static void main(String[] args) {
		String s = "abcdefghija";
		ArrayList<Character> list = new ArrayList<Character>();
		for(int i=0;i<s.length();i++) {
			if(list.contains(s.charAt(i))){
				list.remove((Character)s.charAt(i));
			}else {
				list.add(s.charAt(i));
			}
		}
		System.out.println(list.get(0));
	}
	

}
