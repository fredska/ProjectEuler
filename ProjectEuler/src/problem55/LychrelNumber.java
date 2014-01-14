package problem55;

import java.math.BigInteger;

/**
 * This class attempts to prove the following as described
 * by Project Euler's problem 55:
 * 
 * A number that never forms a palindrome through the reverse 
 * and add process is called a Lychrel number.
 * 
 * @author fskallos
 */

public class LychrelNumber {
	private BigInteger startValue;
	//Maximum number of iterations as described by the problem
	private final static int ITERATIONS = 50;
	
	public LychrelNumber(BigInteger value){
		this.startValue = value;
	}
	
	public boolean isLychrelNumber(){
		//Make a copy of the startValue;  function may not be needed
		BigInteger value = this.startValue;
		
		for(int iterationCount = 0; iterationCount < ITERATIONS; iterationCount++){
			value = getNextIteration(value);
			if(isPalindrome(value)) return false;
		}
		
		return true;
	}
	
	private BigInteger getNextIteration(BigInteger value){
		StringBuilder sb = new StringBuilder();
		sb.append(value.toString());
		return value.add(new BigInteger(sb.reverse().toString()));
	}
	
	public static boolean isLychrelNumber(BigInteger value){
		LychrelNumber lycrhelNumber = new LychrelNumber(value);
		return lycrhelNumber.isLychrelNumber();
	}
	
	public boolean isPalindrome(BigInteger value){
		StringBuilder sb = new StringBuilder(value.toString());
		StringBuilder sb_reverse = new StringBuilder(value.toString());
		return sb_reverse.reverse().toString().equals(sb.toString());
	}
}
