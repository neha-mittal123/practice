package arrayPractice;

public class SticklerThiefOptimized {

	public static void main(String[] args) {
		int hval[] = { 6, 7, 1, 3, 8, 2, 4 };
		int maxEven = hval[0], maxOdd = hval[1];
		if (hval.length == 1) {
			System.out.println(maxEven);
		}
		if (hval.length == 2) {
			if (maxEven > maxOdd) {
				System.out.println(maxEven);
			} else {
				System.out.println(maxOdd);
			}
		}

		for (int i = 2; i < hval.length; i++) {
			if (i % 2 == 0) {
				maxEven = maxEven + hval[i];
			} else {
				maxOdd = maxOdd + hval[i];
			}
		}
		if (hval.length > 2) {
			if (maxEven > maxOdd) {
				System.out.println(maxEven);
			} else {
				System.out.println(maxOdd);
			}
		}

	}

}
