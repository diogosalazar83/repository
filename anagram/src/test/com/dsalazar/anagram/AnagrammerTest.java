package com.dsalazar.anagram;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.dsalazar.anagram.Anagrammer;

class AnagrammerTest {

	@Test
	void testAreAnagrams() {
		
		Anagrammer a = new Anagrammer();
		try {
			a.areAnagrams("!!!", "test");
			fail("Only letters and space characters should be allowed");
		} catch (IllegalArgumentException e) {
			assertEquals(e.getMessage(), "The string !!! can only have letters and space characters");
		}
		
		try {
			a.areAnagrams("test", "???");
			fail("Only letters and space characters should be allowed");
		} catch (IllegalArgumentException e) {
			assertEquals(e.getMessage(), "The string ??? can only have letters and space characters");
		}
		
		assertTrue(a.areAnagrams("herpes", "sphere"));
		assertTrue(a.areAnagrams("Parson Gotti", "protagonist"));
		assertFalse(a.areAnagrams("Eric Bana", "Banana"));
		assertFalse(a.areAnagrams("Sam I am", "Wil I am"));
	}
	
	@Test
	void testGetAnagrams() {
		Anagrammer a = new Anagrammer();
		a.areAnagrams("Tom Marvolo Riddle", "I am Lord Voldemort");
		assertTrue(a.getAreAnagrams());
	}
	
	@Test
	void testSetAnagrams() {
		Anagrammer a = new Anagrammer();
		a.setAreAnagrams(false);
		assertFalse(a.getAreAnagrams());
	}

}
