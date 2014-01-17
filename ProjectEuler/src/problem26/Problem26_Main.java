package problem26;

import utils.common.Sieve_of_Eratosthenes;

/**
 * Find the value of d < 1000 for which 1/d contains the longest recurring cycle
 * in its decimal fraction part.
 * 
 * @author fskallos
 * 
 */
public class Problem26_Main {

	public static void main(String[] args) {
		Problem26_Main problem = new Problem26_Main();
		System.out.println("Result: " + problem.findRecurringCycle());
	}
	
	public int findRecurringCycle(){
		int sequenceLength = 0;
		for(int i = 1000; i > 1; i--){
			if(sequenceLength >= i) break;
			
			int[] foundRemainders = new int[i];
			int value =1;
			int position = 0;
			
			while(foundRemainders[value] == 0 && value != 0){
				foundRemainders[value] = position;
				value *= 10;
				value %= i;
				position++;
			}
			
			if(position - foundRemainders[value] > sequenceLength){
				sequenceLength = position - foundRemainders[value];
			}
		}
		return sequenceLength + 1;
		
	}
}
