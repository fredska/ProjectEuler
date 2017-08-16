package org.fska.projects.problems1_99.prob_60_69.problem63;

import java.math.BigInteger;

/**
 * 
 * The 5-digit number, 16807=7^5, is also a fifth power. Similarly, the 9-digit
 * number, 134217728=8^9, is a ninth power.
 * 
 * How many n-digit positive integers exist which are also an nth power?
 * 
 * @author fskallos
 * 
 */
public class Problem63_Main {

	public static void main(String[] args) {
		Problem63_Main problem = new Problem63_Main();
		problem.run();
	}
	
	public void run(){
		int result = 0;
		int pow = 1;
//		int base = 0;
		BigInteger base = BigInteger.ONE;
		for(int i = 0; i < 100; i++){
			while(base.intValue() < 10){
				if(numOfPower(base.pow(pow)) == pow){
					result++;
					System.out.println(base.pow(pow).toString() + " :: " + base.toString() + " ^ " + pow);
				}
				base = base.add(BigInteger.ONE);			
			}
			pow++;
			base = BigInteger.ONE;
		}
		
		System.out.println("Done!  Result: " + result);
	}
	
	public int numOfPower(long value){
		int result = 1;
		long modifier = 10;
		while((value / modifier) != 0){
			modifier *= 10;
			result++;
		}
		return result;
	}
	
	public int numOfPower(BigInteger value){
		int result = 1;
		BigInteger modifier = BigInteger.TEN;
		while((value.divide(modifier)) != BigInteger.ZERO){
			modifier = modifier.multiply(BigInteger.TEN);
			result++;
		}
		return result;
	}
}
