package codewarriors;

import java.util.ArrayList;

public class DeadFish {
	public static int[] parse(String data) {
		int value= 0;
		ArrayList<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < data.length(); i++) {
			if (data.charAt(i)=='i') {
				value++;
			} else if (data.charAt(i)=='d') {
				value--;
			} else if (data.charAt(i)=='s') {
				value*=value;
			} else if (data.charAt(i)=='o') {
				list.add(value);
			}
		}
		return list.stream().mapToInt(i -> i).toArray();
	}
}