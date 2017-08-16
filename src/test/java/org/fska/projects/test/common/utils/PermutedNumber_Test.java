package org.fska.projects.test.common.utils;

import static org.junit.Assert.*;

import org.junit.Test;

import utils.common.PermutedNumber;

public class PermutedNumber_Test {

	@Test
	public void testIsMatch() {
		PermutedNumber pn1 = new PermutedNumber(41063625);
		PermutedNumber pn2 = new PermutedNumber(56623104);
		PermutedNumber pn3 = new PermutedNumber(66430125);
		
		assertTrue(pn1.isMatch(pn2));
		assertTrue(pn1.isMatch(pn3));
		
		assertTrue(pn1.equals(pn3));
		
		assertTrue(new PermutedNumber(345*345*345).equals(new PermutedNumber(405*405*405)));
	}
	
	@Test 
	public void testIsNotMatch(){
		PermutedNumber pn1 = new PermutedNumber(41063625);
		PermutedNumber pn2 = new PermutedNumber(61862305);
		PermutedNumber pn3 = new PermutedNumber(98084515);
		
		assertFalse(pn1.isMatch(pn2));
		assertFalse(pn1.isMatch(pn3));
	}

}
