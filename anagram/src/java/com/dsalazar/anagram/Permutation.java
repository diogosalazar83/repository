package com.dsalazar.anagram;

import java.util.ArrayList;
import java.util.List;

/**
 * This class has a cap on 6 letters because otherwise it would get too big a list of all possible permutations
 * since permutations are calulated by n! where n is the number of letters and 7! is 5040 and 6! is 720
 * 
 * @author Diogo Salazar
 *
 */
public class Permutation { 
	
	private List<String> anagrams;
	
	public List<String> getAnagrams() {
		return anagrams;
	}
	
	public Permutation(String word) {
		if (word.length() > 6) {
			throw new IllegalArgumentException("You shouldn't ask for a list of anagrams of a word bigger than 6 letters!");
		}
		validateString(word);
		anagrams = new ArrayList<String>();
		this.permute(word.toLowerCase(), 0, word.length() -1);
		
	}
	
	public void setAnagrams(List<String> anagrams) {
		this.anagrams = anagrams;
	}
	
	private void validateString(String string) {
		for (int i = 0; i < string.length(); i++) {
			if(!Character.isLetter(string.charAt(i))) {
				throw new IllegalArgumentException("The string "+string+" should only have letters");
			}
		}
	}

	/** 
	 * permutation function 
	 * @param str string to calculate permutation for 
	 * @param l starting index 
	 * @param r end index 
	 */
	private void permute(String str, int l, int r) 
	{ 
		if (l == r) {
			anagrams.add(str); 
		} else { 
			for (int i = l; i <= r; i++) { 
				str = swap(str, l, i); 
				permute(str, l + 1, r); 
				str = swap(str, l, i); 
			} 
		} 
	} 

	/** 
	 * Swap Characters at position 
	 * @param a string value 
	 * @param i position 1 
	 * @param j position 2 
	 * @return swapped string 
	 */
	public String swap(String a, int i, int j) 
	{ 
		char temp; 
		char[] charArray = a.toCharArray(); 
		temp = charArray[i]; 
		charArray[i] = charArray[j]; 
		charArray[j] = temp; 
		return String.valueOf(charArray); 
	} 
}
