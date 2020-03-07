package com.dsalazar.anagram;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class PermutationTest {

	@Test
	void test() {
		Permutation p = new Permutation("herpes");
		assertEquals(720, p.getAnagrams().size());
		
		try {
			p = new Permutation("!!!");
			fail("it should thrown an exception");
		} catch (IllegalArgumentException e) {
			assertEquals("The string !!! should only have letters", e.getMessage());
		}
		
		try {
			p = new Permutation("thousands");
			fail("it should thrown an exception");
		} catch (IllegalArgumentException e) {
			assertEquals("You shouldn't ask for a list of anagrams of a word bigger than 6 letters!", e.getMessage());
		}
		
		p.setAnagrams(new ArrayList<String>(1));
		assertNotNull(p.getAnagrams());
	}

}
