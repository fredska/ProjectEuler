package org.fska.projects.problems100_199.problem146;

public class Problem146_Main {
	
	private static final int rangeOfPrime = 100000000;
	
	public static void main(String args[])
	{
		
		PrimeSieve ps = new PrimeSieve();
		
		boolean isPrime[] = ps.returnPrimes(rangeOfPrime);
		System.out.println("Primes have been checked");
	}
}
