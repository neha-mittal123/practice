package arrayPractice;

public class ManacherAlgo {
	public static void main(String[] args) {
		String input = "forgeeksaskeegf";
		calculateLongestSubstring(input);

	}

	private static void calculateLongestSubstring(String input) {
		int length = input.length();
		int[] array = new int[length];
		int center = 0;
		int Right = 0;
		array[0] = 1;
		int max = -1;
		for (int i = 1; i < length; i++) {
			int mirr = 2 * center - i;
			if (i < Right) {
				array[i] = Math.min(Right - i, array[mirr]);
			}
			while ((i + (1 + array[i]) < length) && (i - (1 + array[i]) >= 0)
					&& input.charAt(i + (1 + array[i])) == input.charAt(i - (1 + array[i]))) {
				array[i]++;
			}
			if (array[i] > max) {
				max = array[i];
			}
			if (i + array[i] > Right) {
				center = i;
				Right = i + array[i];
			}
		}
		max = 2 * max + 1;
		System.out.println("max:" + max);
	}

}
