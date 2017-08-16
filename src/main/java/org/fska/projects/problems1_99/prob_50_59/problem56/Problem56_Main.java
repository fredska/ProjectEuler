package org.fska.projects.problems1_99.prob_50_59.problem56;

import java.math.BigInteger;

/**
 * 

A googol (10^100) is a massive number: one followed by one-hundred zeros; 
100^100 is almost unimaginably large: one followed by two-hundred zeros.
 Despite their size, the sum of the digits in each number is only 1.

Considering natural numbers of the form, a^b, where a, b < 100,
 what is the maximum digital sum?

 * @author fskallos
 *
 */
public class Problem56_Main {

	private int highestDigitalSum = -1;
	//Notes:  The largest possible number would be 99^99
	public static void main(String[] args) {
		Problem56_Main problem = new Problem56_Main();
		problem.digitalSum(new BigInteger("12345"));
	}
	
	public Problem56_Main(){
		BigInteger a;
		int b;
		for(a = new BigInteger("1"); a.intValue() < 100; a = a.add(BigInteger.ONE)){
			for(b = 0; b < 100; b++){
				int sum = digitalSum(a.pow(b));
				if(highestDigitalSum < sum)
					highestDigitalSum = sum;
			}
		}
		
		System.out.println("Maximum Digital sum: " + highestDigitalSum);
	}
	
	private int digitalSum(BigInteger value){
		int sum = 0;
		for(char character : value.toString().toCharArray()){
			sum += ((int)character) - 48;
		}
		
		return sum;
	}
}
