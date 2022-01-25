package arrayPractice;

public class LongestPalindromicSubString {

	public static void main(String[] args) {
		String str = "forgeeksskeegfor";
		int len=str.length(),low,high,maxlen=1,start;
		for(int i=1;i<len;i++) {
			low=i-1;
			high=i;
			while(low>=0 && high<len && str.charAt(low)==str.charAt(high)) {
				low--;
				high++;
			}
			low++;
			high--;
			if(str.charAt(low)==str.charAt(high) && high-low+1>maxlen) {
				start=low;
				maxlen=high-low+1;
			}
			low=i-1;
			high=i+1;
			while(low>=0 && high<len && str.charAt(low)==str.charAt(high)) {
				low--;
				high++;
			}
			low++;
			high--;
			if(str.charAt(low)==str.charAt(high) && high-low+1>maxlen) {
				start=low;
				maxlen=high-low+1;
			}	
		}
		System.out.println(maxlen);
		
	}

}
