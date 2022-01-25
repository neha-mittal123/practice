package arrayPractice;

public class RomanToDecimalNumber {

	public static void main(String[] args) {
		String str = "MCMIV";
		int num=calcDecimalNumberFromRomanString(str);
		System.out.println(num);
	}

	private static int calcDecimalNumberFromRomanString(String str) {
		int res=0,firstDigit=0,secondDigit=0;
		for(int i=0;i<str.length();i++) {
			 firstDigit=numValueOfChar(str.charAt(i));
			if(i+1<str.length()) {
			 secondDigit=numValueOfChar(str.charAt(i+1));
			}
			if(firstDigit>=secondDigit) {
				res=res+firstDigit;
			}else {
				res=res+secondDigit-firstDigit;
				i++;
			}
		}
		return res;
	}

	private static int numValueOfChar(char r) {
		 if (r == 'I')
	            return 1;
	        if (r == 'V')
	            return 5;
	        if (r == 'X')
	            return 10;
	        if (r == 'L')
	            return 50;
	        if (r == 'C')
	            return 100;
	        if (r == 'D')
	            return 500;
	        if (r == 'M')
	            return 1000;
	        return -1;
	}

}
