package twopointers;

class PairWithTargetSum {

	public static int[] search(int[] arr, int targetSum) {
		int headPointer = 0;
		int tailPointer = arr.length-1;
		while (headPointer < tailPointer) {
			if (arr[headPointer] + arr[tailPointer] == targetSum) {
				return new int[] {headPointer, tailPointer};
			}
			else if (arr[headPointer] + arr[tailPointer] < targetSum) {
				headPointer++;
			}
			else if (arr[headPointer] + arr[tailPointer] > targetSum) {
				tailPointer--;
			}
		}//end of while
		return new int[] { -1, -1 };
	}
	
	public static void main(String[] args) {
		System.out.println(PairWithTargetSum.search(new int[]{1, 2, 3, 4, 6}, 6));
		System.out.println(PairWithTargetSum.search(new int[]{2, 5, 9, 11}, 11));
	}
}
