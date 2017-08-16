package org.fska.projects.problems1_99.prob_30_39.problem34;

/**
 * 145 is a curious number, as 1! + 4! + 5! = 1 + 24 + 120 = 145.
 * 
 * Find the sum of all numbers which are equal to the sum of the factorial of
 * their digits.
 * 
 * Note: as 1! = 1 and 2! = 2 are not sums they are not included.
 * 
 * @author fskallos
 * 
 */
public class Problem34_Main {

	public static void main(String[] args) {
		Problem34_Main problem = new Problem34_Main();
		problem.run();
	}
	
	public void run(){
		//Upper limit would be 9! + 8! + 7! + ... which is about 500k
		int sumOfCuriousFactorials = 0;
		for(int i = 10; i < 500000; i++){
			if(isCuriousFactorial(i)){
				sumOfCuriousFactorials += i;
			}
		}
		System.out.println("Result: " + sumOfCuriousFactorials);
		
	}
	public boolean isCuriousFactorial(int value){
		int valueMarker = 100000000;
		int tmpValue = value;
		int factorialValue = 0;
		for(; valueMarker >= 1; valueMarker /= 10){
			if(value == (tmpValue % valueMarker)) continue;
			
			factorialValue += getFactorial(tmpValue / valueMarker);
			tmpValue %= valueMarker;
		}
		return factorialValue == value;
	}
	
	public int getFactorial(int value){
		int result = 1;
		for(int a = value; a > 0; a--){
			result *= a;
		}
		return result;
	}

}
