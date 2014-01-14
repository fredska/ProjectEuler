package test.common.utils;

import static org.junit.Assert.*;

import org.junit.Test;

import utils.common.Sieve_of_Eratosthenes;

public class Sieve_Of_Eratosthenes_Test {

	@Test
	public void test() {
		boolean[] primes = Sieve_of_Eratosthenes.getPrimesToLimit(100);
		
		assertTrue(primes[5]);
		assertFalse(primes[6]);
		assertTrue(primes[7]);
		assertTrue(primes[13]);
		assertFalse(primes[21]);
	}

}
