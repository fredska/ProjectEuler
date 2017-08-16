package org.fska.projects.problems1_99.prob_60_69.problem65;

import java.math.BigInteger;

/**
 * Find the sum of digits in the numerator of the 100th convergent 
 *  of the continued fraction for e.
 * @author fskallos
 *
 */
public class Problem65_Main{

	public static void main(String[] args) {
		Problem65_Main problem = new Problem65_Main();
		problem.run();
	}
	
	public void run(){
		long[] partialValues = getPartialValues(100);
		BigInteger num = BigInteger.ONE;
		BigInteger den = new BigInteger(Long.toString(partialValues[partialValues.length-1]));
		for(int i = partialValues.length - 2; i >= 0; i--){
			if(i == 0){
				BigInteger biTmp = new BigInteger(num.toString());
				num = new BigInteger(Long.toString(partialValues[i])).multiply(den).add(biTmp);
				break;
			}
			
			BigInteger biTmp = new BigInteger(den.toString());
			den = new BigInteger(Long.toString(partialValues[i])).multiply(den).add(num);
			num = biTmp;
		}
		System.out.println("Done :: " + num + " / " + den);
		System.out.print("Sum of the numerator digits: ");
		int answer = 0;
		String numString = num.toString();
		for(int i = 0; i < numString.length(); i++){
			answer += numString.charAt(i) - 48;
		}
		System.out.println(answer);
	}
	
	public long[] getPartialValues(int length){
		long[] results = new long[length];
		results[0] = 2;
		long n = 1;
		for(int i =0; i < results.length-1; i++){
			if((i % 3) == 1){
				results[i+1] = 2 * n;
				n++;
			} else
				results[i+1] = 1;
		}
		return results;
	}
}
