package twopointers;

import java.util.Arrays;

class SortedArraySquares {

	public static int[] makeSquares(int[] arr) {
		int[] squares = new int[arr.length];
		for (int i = 0; i < arr.length; i++) {
			squares[i] = arr[i]*arr[i];
		}
		Arrays.sort(squares);
		return squares;
	}
	
	public static void main(String[] args) {
		int[] result = SortedArraySquares.makeSquares(new int[] {-2, -1, 0, 2, 3});
		
		for (int i = 0; i < result.length; i++) {
			System.out.print("arr["+i+"]="+result[i]+", ");
		}
		System.out.println();
	}
}

