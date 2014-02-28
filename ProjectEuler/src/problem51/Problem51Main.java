package problem51;

import java.util.ArrayList;
import java.util.List;

import utils.common.Sieve_of_Eratosthenes;

/**
 * By replacing the 1st digit of the 2-digit number *3, it turns out that six of
 * the nine possible values: 13, 23, 43, 53, 73, and 83, are all prime.
 * 
 * By replacing the 3rd and 4th digits of 56**3 with the same digit, this
 * 5-digit number is the first example having seven primes among the ten
 * generated numbers, yielding the family: 56003, 56113, 56333, 56443, 56663,
 * 56773, and 56993. Consequently 56003, being the first member of this family,
 * is the smallest prime with this property.
 * 
 * Find the smallest prime which, by replacing part of the number (not
 * necessarily adjacent digits) with the same digit, is part of an eight prime
 * value family.
 * 
 * @author fskallos
 * 
 */
public class Problem51Main {

	public static void main(String[] args) {
		boolean[] primes = Sieve_of_Eratosthenes.getPrimesToLimit(1000000);
		List<Integer> primesEndWithOne = new ArrayList<Integer>();
		List<Integer> primesEndWithThree = new ArrayList<Integer>();
		List<Integer> primesEndWithSeven = new ArrayList<Integer>();
		List<Integer> primesEndWithNine = new ArrayList<Integer>();
		
		for(int i = 0; i < primes.length; i++){
			if(primes[i]){
				if((i % 10) == 1)
					primesEndWithOne.add(i);
				if((i % 10) == 3)
					primesEndWithThree.add(i);
				if((i % 10) == 7)
					primesEndWithSeven.add(i);
				if((i % 10) == 9)
					primesEndWithNine.add(i);
			}
		}
		
		System.out.println("Finish!");
	}
	
	
}
