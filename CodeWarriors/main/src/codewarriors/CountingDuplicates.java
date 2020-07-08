package codewarriors;

import java.util.HashSet;

public class CountingDuplicates {
	public static int duplicateCount(String text) {
		text = text.toLowerCase();
		HashSet<Character> set = new HashSet<Character>();
		HashSet<Character> duplicates = new HashSet<Character>();
		for (int i = 0; i < text.length(); i++) {
			if (!set.contains(text.charAt(i))) {
				set.add(text.charAt(i));
			} else {
				duplicates.add(text.charAt(i));
			}
		}
		return duplicates.size();
	}

}
