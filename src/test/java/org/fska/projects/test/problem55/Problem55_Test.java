package org.fska.projects.test.problem55;

import static org.junit.Assert.*;

import java.math.BigInteger;

import org.junit.Test;

import org.fska.projects.problems1_99.prob_50_59.problem55.LychrelNumber;

public class Problem55_Test {

	@Test
	public void LychrelNumber_Valid() {
		// Valid numbers;
		BigInteger value_1 = new BigInteger("4994");

		LychrelNumber ln = new LychrelNumber(value_1);
		assertTrue(ln.isLychrelNumber());
	}

	@Test
	public void LychrelNumber_Invalid() {
		BigInteger value_1 = new BigInteger("10");

		LychrelNumber ln = new LychrelNumber(value_1);
		assertFalse(ln.isLychrelNumber());
	}
	
	@Test
	public void Palindrome_Test(){
		LychrelNumber ln = new LychrelNumber(new BigInteger("121"));
		assertTrue(ln.isPalindrome(new BigInteger("121")));
	}

}
