package utils.common;

public class SieveOfEratosthenes {
	
	public static boolean[] getPrimesToLimit(int limit){
		boolean[] primes = new boolean[limit];
		for(int i = 0; i < limit; i++){
			primes[i] = true;
		}
		
		int p = 2;
		while(p < (int)Math.sqrt(limit)){
			for(int i = 2; i * p < limit; i++){
				primes[p*i] = false;
			}
			p++;
			//Find the next true value in the boolean array
			while(p < primes.length && !primes[p])
				p++;
		}
		primes[0] = false;
		primes[1] = false;
		return primes;
	}
}
