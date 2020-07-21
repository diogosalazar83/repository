package codewarriors;

import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CountDig {

	public static int nbDig(int n, int d) {
		int value = 0;  
		ArrayList<Integer> list = new ArrayList<Integer>();
		//squaring all numbers
		for (int k = 0; k <= n; k++) {
			list.add(k*k);
		}//end squaring all numbers
		for (Integer current : list) {
			String intAsString = Integer.toString(current);
			for (int i = 0; i < intAsString.length(); i++) {
				if (Character.getNumericValue(intAsString.charAt(i)) == d) {
					value++;
				}
			}
		}
		return value;
	}
	
	   public static int nbDigAsStream(int n, int d) {
		     return IntStream.range(0, n+1)
		                     .mapToObj(i -> String.valueOf(i*i))
		                     .map(s -> s.replaceAll("[^"+d+"]", ""))
		                     .collect(Collectors.joining())
		                     .length();
		   }
	
	public static void main(String[] args) {
		System.out.println(CountDig.nbDig(25, 1));
	}
}
