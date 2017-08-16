package org.fska.projects.problems100_199.problem146;

public class PrimeSieve {

	public boolean[] returnPrimes(int size)
	{
		//Set all numbers to "prime".. i.e. true
		boolean[] isPrime = new boolean[size + 1];
		for(int i = 2; i < size; i++)
		{
			isPrime[i] = true;
		}
		
		//mark non-primes <= N using Sieve of Erathosthenes
		for(int i = 2; i*i <= size; i++)
		{
			//if i is prime, then market multiples of i as nonprime
			//suffices to consider mutiples i, i+1, ..., N/i
			if(isPrime[i])
			{
				for(int j=i; i*j <= size; j++)
				{
					isPrime[i*j] = false;
				}
			}
		}
		
		//Count the primes
		int primes = 0;
		for(int i = 2; i<=size; i++)
		{
			if(isPrime[i]) primes++;
		}
		
		System.out.println("The number of primes <= " + size + " is " + primes);
		
		return isPrime;
	}
}
