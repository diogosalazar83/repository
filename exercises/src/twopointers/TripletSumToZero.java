package twopointers;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class TripletSumToZero {

	public static List<List<Integer>> searchTriplets(int[] arr) {
		List<List<Integer>> triplets = new ArrayList<>();
		for (int i = 0; i < arr.length; i++) {
			int firstNumber = arr[i];
			for (int j = i+1; j < arr.length; j++) {
				int secondNumber = arr[j];
				for (int k = j+1; k < arr.length; k++) {
					int thirdNumber = arr[k];
					if (firstNumber+secondNumber+thirdNumber == 0) {
						ArrayList<Integer> arrayList = new ArrayList<Integer>();
						arrayList.add(firstNumber);
						arrayList.add(secondNumber);
						arrayList.add(thirdNumber);
						Comparator<? super Integer> c = (Integer i1, Integer i2) ->{
							return i1-i2;
						};
						arrayList.sort(c);
						if (!triplets.contains(arrayList)) {
							triplets.add(arrayList);
						}
						
					}
				}//end of third for
			}//end of second for
		}//end of first for
		return triplets;
	}
	
	public static void main(String[] args) {
		int[] arr = new int[] {-3, 0, 1, 2, -1, 1, -2};
		List<List<Integer>> searchTriplets = TripletSumToZero.searchTriplets(arr);
		System.out.println(searchTriplets);
	}
}
