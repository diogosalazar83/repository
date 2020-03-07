package com.dsalazar.anagram;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.dsalazar.anagram.exceptions.BadRequestException;

class AnagramControllerTest {

	@Test
	void testDocket() {
		AnagramController ac = new AnagramController();
		assertNotNull(ac.api());
		assertTrue(ac.api().isEnabled());
	}
	
	@Test
	void testAnagrams() {
		AnagramController ac = new AnagramController();
		assertEquals(6, ac.anagrams("aba").getAnagrams().size());
		try {
			ac.anagrams("something");
		} catch (BadRequestException e) {
			assertEquals("java.lang.IllegalArgumentException: You shouldn't ask for a list of anagrams of a word bigger than 6 letters!", e.getMessage());
		}
	}
	
	@Test
	void testAreAnagrams() {
		AnagramController ac = new AnagramController();
		assertTrue(ac.areAnagrams("herpes", "sphere").getAreAnagrams());
		try {
			ac.areAnagrams("..", "something");
		} catch (BadRequestException e) {
			assertEquals("java.lang.IllegalArgumentException: The string .. can only have letters and space characters", e.getMessage());
		}
	}

}
