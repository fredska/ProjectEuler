package org.fska.projects.test.common.utils;

import static org.junit.Assert.*;

import org.junit.Test;

import utils.common.SieveOfEratosthenes;

public class Sieve_Of_Eratosthenes_Test {

	@Test
	public void test() {
		boolean[] primes = SieveOfEratosthenes.getPrimesToLimit(100);
		
		assertTrue(primes[5]);
		assertFalse(primes[6]);
		assertTrue(primes[7]);
		assertTrue(primes[13]);
		assertFalse(primes[21]);
	}

}
