package problem37;

import java.util.Calendar;

import utils.common.Sieve_of_Eratosthenes;

/**
 * 
 * The number 3797 has an interesting property. Being prime itself, it is
 * possible to continuously remove digits from left to right, and remain prime
 * at each stage: 3797, 797, 97, and 7. Similarly we can work from right to
 * left: 3797, 379, 37, and 3.
 * 
 * Find the sum of the only eleven primes that are both truncatable from left to
 * right and right to left.
 * 
 * NOTE: 2, 3, 5, and 7 are not considered to be truncatable primes.
 * 
 * @author fskallos
 * 
 */
public class Problem37_Main {
	
	public static void main(String[] args){
		Problem37_Main problem = new Problem37_Main();
		Calendar startTime = Calendar.getInstance();
		problem.run();
		System.out.println("Time to run: " + 
				(Calendar.getInstance().getTimeInMillis() - startTime.getTimeInMillis())/1000d + " seconds");
	}
	private boolean[] primes = Sieve_of_Eratosthenes.getPrimesToLimit(1000000);
	public void run(){
		int finalValue = 0;
		for(int i = 1; i < 1000000; i++){
			if(isPrimeTrucatable(primes, i)){
				finalValue += i;
				System.out.println("Prime Value: " + i);
			}
		}
		System.out.println("Final Value: " + finalValue);
	}

	public boolean isPrimeTrucatable(boolean[] primes, int value){
		//First check if value is a prime number:
		if(!primes[value] || value < 10) return false;
		//Trunc from left -> right
		boolean isTrunc = true;
		int startValuePlace = 100000000; //Start at the leftmost position
		for(; startValuePlace >= 10; startValuePlace /= 10){
			int newValue = value % startValuePlace;
			if(newValue == value) continue;
			//If the trunc value is a prime, go on with the loop;
			if(primes[newValue]) continue;
			
			//Else, the number fails & break out of the loop
			return false;
		}
		for(startValuePlace = 10; (value / startValuePlace) != 0; startValuePlace *= 10){
			int newValue = value / startValuePlace;
			//If the trunc value is a prime, go on with the loop;
			if(primes[newValue]) continue;
			
			//Else, the number fails & break out of the loop
			return false;
		}
		//If both loops pass, return true
		return true;
	}
}
