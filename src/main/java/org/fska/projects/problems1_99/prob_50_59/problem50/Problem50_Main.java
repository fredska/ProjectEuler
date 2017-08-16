package org.fska.projects.problems1_99.prob_50_59.problem50;

import java.util.LinkedList;
import java.util.List;

import utils.common.SieveOfEratosthenes;

/**
 * 
 * The prime 41, can be written as the sum of six consecutive primes: 
 * 41 = 2 + 3 + 5 + 7 + 11 + 13
 * 
 * This is the longest sum of consecutive primes that adds to a prime below
 * one-hundred.
 * 
 * The longest sum of consecutive primes below one-thousand that adds to a
 * prime, contains 21 terms, and is equal to 953.
 * 
 * Which prime, below one-million, can be written as the sum of the most
 * consecutive primes?
 * 
 * @author fskallos
 * 
 */
public class Problem50_Main {
	
	boolean[] primes = SieveOfEratosthenes.getPrimesToLimit(10000000);
	private List<Integer> primeValues;
	public Problem50_Main(){
		primeValues = new LinkedList<Integer>();
		for(int i = 0; i < primes.length; i++){
			if(primes[i]) primeValues.add(i);
		}
		
		System.out.println("---- : " + findLongestConsecutiveChain(1000000));
	}
	
	public int findLongestConsecutiveChain(int limit){
		
		int maxChainLength = 0;
		int highestConsecutivePrime = 0;
		int primeMarker = 0; //Marks where to start in the primeValues list
		for(int i = 0; i < limit; i++){
			if(!primes[i]) continue; //If i is not a prime, keep moving on (check each consecutive chain starting w/ the lowest  marked prime)
			
			int primeValueCheck = 0;
			int currentChainLength = 0;
			for(int p = primeMarker; primeValueCheck < limit; p++){
				primeValueCheck += primeValues.get(p);
				currentChainLength++;
				if(primes[primeValueCheck]){
					if (maxChainLength < currentChainLength) {
						maxChainLength = currentChainLength;
						highestConsecutivePrime = primeValueCheck;
					}
				}
			}
			primeMarker++;
		}
		return highestConsecutivePrime;
	}
	
	public static void main(String[] args){
		Problem50_Main problem = new Problem50_Main();
		problem.findLongestConsecutiveChain(1000);
	}
}
