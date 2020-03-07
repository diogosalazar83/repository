package com.dsalazar.anagram;

import java.util.Arrays;

public class Anagrammer {
	
	private boolean areAnagrams;

	/**
	 * This method checks for anagrams, but it also assumes the anagram might be formed by 
	 * splitting big words into a set of two or more smaller words
	 * 
	 * @param string1 - it should only contain letters and space characters
	 * @param string2 - it should only contain letters and space characters
	 * @return true if they are anagram, false otherwise
	 */
	public boolean areAnagrams(String string1, String string2) {
		validateString(string1);
		validateString(string2);
		
		char[] array1 = string1.replaceAll("\\s", "").toLowerCase().toCharArray();
		char[] array2 = string2.replaceAll("\\s", "").toLowerCase().toCharArray();
		
		Arrays.sort(array1);
		Arrays.sort(array2);
		
		if (array1.length != array2.length) {
			setAreAnagrams(false);
			return getAreAnagrams();
		} else {
			for (int i = 0; i < array1.length; i++) {
				if (array1[i] != array2[i]) {
					setAreAnagrams(false);
					return getAreAnagrams();
				}
			}
			setAreAnagrams(true);
			return getAreAnagrams();
		}
	}
	
	private void validateString(String string) {
		for (int i = 0; i < string.length(); i++) {
			if(!Character.isLetter(string.charAt(i)) && !Character.isSpaceChar(string.charAt(i))) {
				throw new IllegalArgumentException("The string "+string+" can only have letters and space characters");
			}
		}
	}
	
	public boolean getAreAnagrams() {
		return areAnagrams;
	}
	
	public void setAreAnagrams(boolean areAnagrams) {
		this.areAnagrams = areAnagrams;
	}
}
