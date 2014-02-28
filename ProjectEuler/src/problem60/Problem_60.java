package problem60;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import utils.common.Sieve_of_Eratosthenes;

/**
 * 
 The primes 3, 7, 109, and 673, are quite remarkable. By taking any two primes
 * and concatenating them in any order the result will always be prime. For
 * example, taking 7 and 109, both 7109 and 1097 are prime. The sum of these
 * four primes, 792, represents the lowest sum for a set of four primes with
 * this property.
 * 
 * Find the lowest sum for a set of five primes for which any two primes
 * concatenate to produce another prime.
 * 
 * @author fskallos
 * 
 */
public class Problem_60 {

	private boolean[] primes;
	private final int PRIME_LIMIT = 1000000;
	private List<Integer> primeList;

	public static void main(String[] args) {
		Problem_60 problem = new Problem_60();
		problem.run();
	}

	public void run() {
		initialize();
		Calendar start = Calendar.getInstance();
		Map<Integer, List<Integer>> mapAllPotentialPrimes = 
				new HashMap<Integer, List<Integer>>();
		for(int primeIndex = 0; primeIndex < primeList.size(); primeIndex++){
			int comparePrime = primeList.get(primeIndex);
			List<Integer> potentialPrimes = getAllPotentialPrimes(comparePrime);
			if(!potentialPrimes.isEmpty())
			mapAllPotentialPrimes.put(comparePrime,potentialPrimes);
		}
		System.out.println("Jobs Done!");
		System.out.println("Processing Time: " + (Calendar.getInstance().getTimeInMillis() - start.getTimeInMillis()));
	}
	
	/**
	 * This method breaks down a prime into any primes that can be concantenated with it.
	 * 
	 * For instance, 7109 returns 7, 71, 109
	 * @param prime 
	 * @return
	 */
	
	public List<Integer> breakDownPrime(int prime){
		return null;
	}
	
	/**
	 * This method returns all potential concantenated primes based on the
	 * given prime.  I.E. 109 returns 1093, 1097, 3109, 7109, 673109, etc..
	 * @param prime
	 * @return
	 */
	public List<Integer> getAllPotentialPrimes(int prime){
		List<Integer> matchedPrimes = new ArrayList<Integer>();
		if(primes == null) initialize();
		int primeModifier = 1;
		//Define the power of 10 value for the prime 
		// e.g. 109 gets a value of 1000
		while ((prime / (primeModifier)) != 0) {
			primeModifier *= 10;
		}
		//Prime Compare Modifier
		int primeCM = 10;
		for(int comparePrime : primeList){
			if((primeModifier * primeCM / 100) >= PRIME_LIMIT)
				return matchedPrimes;
			if((comparePrime / primeModifier) != 0){
				//Get all primes ending with the given prime
				if((comparePrime % primeModifier) == prime)
					matchedPrimes.add(comparePrime);
				
				while ((comparePrime / (primeCM)) != 0) {
					primeCM *= 10;
				}
				if(prime == (comparePrime / (primeCM / primeModifier)))
					matchedPrimes.add(comparePrime);
			}			
		}
		return matchedPrimes;
	}

	private void initialize() {
		primes = Sieve_of_Eratosthenes.getPrimesToLimit(PRIME_LIMIT);
		primeList = new ArrayList<Integer>();
		for (int i = 0; i < PRIME_LIMIT; i++) {
			if (primes[i])
				primeList.add(i);
		}
	}

	public boolean checkPairs(int... pairs) {
		if (primes == null)
			initialize();
		if (pairs.length != 5 && pairs.length != 4)
			return false;

		for (int a = 0; a < pairs.length-1; a++) {
			for (int b = pairs.length - 1; b > a; b--) {
				if (!confirmPairSet(pairs[a], pairs[b]))
					return false;
			}
		}
		return true;
	}

	public boolean confirmPairSet(int prime1, int prime2) {
		if (primes == null || primes.length != PRIME_LIMIT)
			primes = Sieve_of_Eratosthenes.getPrimesToLimit(PRIME_LIMIT);

		int prime1Modifier = 1;
		int prime2Modifier = 1;
		while ((prime1 / (10 * prime1Modifier)) != 0) {
			prime1Modifier *= 10;
		}
		while ((prime2 / (10 * prime2Modifier)) != 0) {
			prime2Modifier *= 10;
		}

		if (((prime1 * prime2Modifier * 10) + prime2) > PRIME_LIMIT)
			return false;
		return primes[(prime1 * prime2Modifier * 10) + prime2]
				&& primes[(prime2 * prime1Modifier * 10) + prime1];
	}
}
