package arrayPractice;

//Priyanka works for an international toy company that ships by container. Her task is to the determine the lowest cost way to combine her orders for shipping.
//
//She has a list of item weights. The shipping company has a requirement that all items loaded in a container must weigh less than or equal to 4 units plus the weight of the minimum weight item. All items meeting that requirement will be shipped in one container.
//
//What is the smallest number of containers that can be contracted to ship the items based on the given list of weights?
//
//Input Format
//
//The first line contains an integer , the number of orders to ship.
//Next line will contain  integers,  , representing the orders in a weight array.
//
//Output Format
//
//Return the integer value of the number of containers Priyanka must contract ot ship all of the toys.
//
//Constraints
//
//
//Sample Input
//
//8
//1 2 3 21 7 12 14 21
//Sample Output
//
//4

public class PriyankaToyProblemUsingHeap {

	static int[] toyWeight = { 1, 2, 3, 21, 7, 12, 14, 31,35,22,25,24 };
	static int size = toyWeight.length;

	public static void main(String[] args) {
		int noOfContiners = findMinNoOfContainers();
		System.out.println(noOfContiners);

	}

	private static int findMinNoOfContainers() {
		int containers = 1;
		buildMinHeap();
		int minElement = getMin(toyWeight) + 4;
		while (size > 0) {
			if (getMin(toyWeight) <= minElement) {
				extractMin(toyWeight);
			}else {
				containers++;
				minElement = getMin(toyWeight)+4;
			}
		}

		return containers;
	}

	private static void buildMinHeap() {
		for (int i = (int) Math.floor((size / 2) - 1); i >= 0; i--) {
			minHeapify(toyWeight, i);
		}
	}

	private static void minHeapify(int[] arr, int i) {
		int L = 2 * i + 1;
		int R = 2 * i + 2;
		int smallest = -1;
		if (L <= size - 1) {
			if (R <= size - 1) {
				if (arr[L] < arr[R]) {
					smallest = L;
				} else {
					smallest = R;
				}
			} else {
				smallest = L;
			}
		}
		if (smallest >= 0 && arr[smallest] < arr[i]) {
			int temp = arr[i];
			arr[i] = arr[smallest];
			arr[smallest] = temp;
			minHeapify(arr, smallest);
		}

	}

	private static int extractMin(int[] arr) {
		if (size < 1) {
			return arr[0];
		} else {
			int min = arr[0];
			arr[0] = arr[size - 1];
			size = size - 1;
			minHeapify(arr, 0);
			return min;
		}

	}

	private static int getMin(int[] arr) {
		if (size > 0) {
			return arr[0];
		} else {
			return 0;
		}
	}

}
