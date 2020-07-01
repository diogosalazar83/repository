package slidingwindow;

import java.util.*;

class NoRepeatSubstring {
	public static int findLength(String str) {
		int maxSize = 0;
		for (int i = 0; i < str.length(); i++) {
			HashSet<Character> set = new HashSet<Character>();
			set.add(str.charAt(i));
			int currentSize = 1;
			for (int j = i+1; j < str.length(); j++) {
				if (set.contains(str.charAt(j))) {
					i = j-1;
					break;
				}
				if (!set.contains(str.charAt(j))) {
					set.add(str.charAt(j));
					currentSize++;
					if (currentSize > maxSize) {
						maxSize = currentSize;
					}
				}
			}//end of second for
		}//end of first for
		return maxSize;
	}
	
	public static void main(String[] args) {
		System.out.println(NoRepeatSubstring.findLength("aabccbb"));
		System.out.println(NoRepeatSubstring.findLength("abbbb"));
	}
}
