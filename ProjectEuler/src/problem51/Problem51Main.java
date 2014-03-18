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

	private boolean[] primes = Sieve_of_Eratosthenes.getPrimesToLimit(1000000);
	private boolean[][] combination;
	private static final char REPLACE_MARKER = '*';
	public static void main(String[] args) {
		Problem51Main problem = new Problem51Main();
		problem.run();
	}
	
	public void run(){
		List<Integer> allPrimes = new ArrayList<Integer>();
		for(int i = 0; i < primes.length; i++){
			if(primes[i]){
				allPrimes.add(i);
			}
		}
		List<Integer> results = null;
		int lastNumLength = 1;
		int primeFamilySize = 8;
		for(Integer prime : allPrimes){
			final String stringPrime = String.valueOf(prime);
			
			if(stringPrime.length() == 1) continue;
			String tmp = stringPrime;
			if(lastNumLength != tmp.length()){
				lastNumLength = tmp.length();
				combination = getCombination(lastNumLength);
			}
			
			for(boolean[] combine : combination){
				if(validateCombinationCheck(tmp, combine)){
					StringBuilder sb = new StringBuilder();
					for(int i = 0; i < tmp.length(); i++){
						if(combine[i]){
							sb.append(REPLACE_MARKER);
						} else
							sb.append(tmp.charAt(i));
					}
					results = replaceStarWithValue(sb.toString());
					if(results.size() == primeFamilySize)
						break;
				}
				if(results.size() == primeFamilySize)
					break;
			}
			if(results.size() == primeFamilySize)
				break;
		}
		System.out.println("All done!");
		System.out.println(results.size());
		System.out.println(results.get(0));
	}
	
	public boolean validateCombinationCheck(String input, boolean[] combination){
		int value = -1;
		for(int i = 0; i < combination.length; i++){
			if(combination[i]){
				if(value == -1){
					value = input.charAt(i);
				} else {
					if(value != input.charAt(i))
						return false;
				}
			}
		}
		return true;
	}
	
	public boolean[][] getCombination(int intLength){
		boolean[][] results = new boolean[(intLength * intLength) * 2][intLength];
		for(int i = 0; i < intLength; i++){
			for(int j = 0; j < intLength; j++){
				results[i*intLength+j][i] = true;
				results[i*intLength+j][j] = true;
			}
		}
		for(int i = (intLength * intLength); i < 2 *((intLength * intLength)); i++){
			for(int j = 0; j < intLength; j++){
				results[i][j] = !results[i - (intLength * intLength)][j];
			}
		}
		if(intLength == 6){
			results[0] = new boolean[]{true, false, true, false, true, false};
		}
		
		return results;
	}
	
	public String replaceCharacterAtPosition(String input, int index){
		StringBuilder sb = new StringBuilder();
		if(index == 0){
			sb.append(REPLACE_MARKER);
		} else {
			sb.append(input.substring(0, index));
			sb.append(REPLACE_MARKER);
		}
		if(sb.length() != input.length()){
			sb.append(input.substring(index+1));
		}
		return sb.toString();
	}
	
	public int getNumOfSimilarDigits(int value){
		int[] digits = new int[10];
		int modifier = 1;
		while((value / modifier) != 0){
			digits[(value / modifier) % 10]++;
			modifier *= 10;
		}
		
		int result = 0;
		for(int i = 0; i < 10; i++){
			result = Math.max(result, digits[i]);
		}
		return result;
	}
	
	public List<Integer> replaceStarWithValue(String input){
		String tmp = input.toLowerCase();
		List<Integer> results = new ArrayList<Integer>();
		if(input.charAt(0) != REPLACE_MARKER){
			int value = Integer.parseInt(tmp.replace(REPLACE_MARKER, (char)(48)));
			if(primes[value]){
				results.add(value);
			}
		}
		for(int i = 1; i < 10; i++){
			tmp = input.toLowerCase();
			int value = Integer.parseInt(tmp.replace(REPLACE_MARKER, (char)(i + 48)));
			if(primes[value]){
				results.add(value);
			}
		}
		return results;
	}
	
}
