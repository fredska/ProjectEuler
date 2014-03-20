package problem69;

import utils.common.Sieve_of_Eratosthenes;

/**
 * Find the value of n ≤ 1,000,000 for which n/φ(n) is a maximum.
 * 
 * φ(n) is the phi function, finds all relatively prime numbers under n
 * 
 */
public class TotientMaximum {

	public static void main(String[] args) {
		TotientMaximum problem = new TotientMaximum();
//		problem.run();
		
		//The fun way is to brute force...
		
		//Smart way is just to multiple each prime until n <= 1000000
		boolean[] primes = Sieve_of_Eratosthenes.getPrimesToLimit(100);
		int n = 1;
		for(int i = 0; i < primes.length; i++){
			
			if(primes[i])
				n *= i;
			if(n * i >= 1000000)
				break;
		}
		System.out.println(n);
	}

	public void run(){
		int bestN = 2;
		double record = 0;
		for(int i = 2; i <= 1000000; i++){
			double phi = findPhiFunction(i);
			if(record < (i / phi)){
				bestN = i;
				record = (i / phi);
				System.out.println("New Record: " + i + " :: " + record);
			}
//		System.out.println(findPhiFunction(i));
		}
	}
	
	public int findPhiFunction(int n){
		if(n <= 1) return -1;
		//Any remaining false values in this array
		// are considered non-relative primes
		boolean[] relativePrimes = new boolean[n];
		relativePrimes[0] = false;
		for(int i = 1; i < relativePrimes.length; i++){
			if(!relativePrimes[i]){
				if((n % (i + 1)) == 0){
					int a = i;
					for(int b = 0; b * (i + 1) < relativePrimes.length; b++){
						relativePrimes[i + (b * (i+1))] = true;
					}
				}
			}
		}
		int finalCount = 0;
		for(int i = 0; i < relativePrimes.length; i++){
			if(!relativePrimes[i]) finalCount++;
		}
		return finalCount;
	}
}
