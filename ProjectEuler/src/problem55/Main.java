package problem55;

import java.math.BigInteger;

/**
 * Problem states to find all Lychel numbers below 10,000 Restrictions; must be
 * palindromic by the end if after 50 iterations, no palindromic number is
 * found, it is considered Lychrel
 * 
 * @author fskallos
 * 
 */
public class Main {

	public static void main(String[] args) {
		int lychrelCount = 0;
		for(int count = 0; count < 10000; count++){
			if(LychrelNumber.isLychrelNumber(
					new BigInteger(Integer.toString(count)))){
				System.out.println("Lychrel Number: " + count);
				lychrelCount++;
			}
		}
		
		System.out.println("All Done: # of Lychrel Nums: " + lychrelCount);
	}
}
