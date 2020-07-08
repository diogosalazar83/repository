package twopointers;

class RemoveDuplicates {

	public static int remove(int[] arr) {
		int nextNonDuplicate = 1;
		for (int i = 1; i < arr.length; i++) {
			// they are the same
			if (arr[i] != arr[nextNonDuplicate]) {
				arr[nextNonDuplicate] =arr[i];
				nextNonDuplicate++;
			}
		}
		return nextNonDuplicate;
	}

	public static void main(String[] args) {
		int[] arr = new int[] { 2, 3, 3, 3, 6, 9, 9 };
		System.out.println(RemoveDuplicates.remove(arr));

		arr = new int[] { 2, 2, 2, 11 };
		System.out.println(RemoveDuplicates.remove(arr));
	}
}