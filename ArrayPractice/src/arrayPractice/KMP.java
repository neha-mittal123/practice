package arrayPractice;

public class KMP {

	public static void main(String[] args) {
		String text = "BABDABACDABABCABAB";
		String pattern = "ABABCABAB";
		int[] lps = new int[pattern.length()];
		int i = 0;
		lps[i] = 0;
		for (int j = 1; j < pattern.length(); j++) {
			if (pattern.charAt(i) != pattern.charAt(j)) {
				while (i > 0) {
					if (pattern.charAt(lps[i - 1]) != pattern.charAt(j)) {
						lps[j] = 0;
						i = lps[i - 1];
					} else {
						i = lps[i - 1];
						lps[j] = i + 1;
					}
				}if(i==0) {
					lps[j]=0;
				}
			} else {
				lps[j] = i + 1;
				i++;
			}
		}
		for (int k : lps)
			System.out.print(k + " ");
		patternMatchingKMP(text, pattern, lps);

	}

	private static void patternMatchingKMP(String text, String pattern, int[] lps) {
		int j = 0;
		for (int i = 0; i < text.length();) {
			if (j == pattern.length() - 1) {
				System.out.println("found");
			}
			if (text.charAt(i) != pattern.charAt(j)) {
				if (j > 0 && pattern.charAt(lps[j - 1]) != text.charAt(i)) {
					j = lps[j - 1];
					i++;
				}
				if(j==0) {
					i++;
				}
			} else {
				j++;
				i++;
			}
		}

	}

}
