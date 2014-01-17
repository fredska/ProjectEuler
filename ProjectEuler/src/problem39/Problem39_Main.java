package problem39;

import javax.print.attribute.standard.Finishings;

/**
 * 
 If p is the perimeter of a right angle triangle with integral length sides,
 * {a,b,c}, there are exactly three solutions for p = 120.
 * 
 * {20,48,52}, {24,45,51}, {30,40,50}
 * 
 * For which value of p ≤ 1000, is the number of solutions maximised?
 * 
 * @author fskallos
 * 
 * Notes:  This is a right triangle, so the pythagorean theorem needs to be upheld
 * as well;  c^2 = a^2 + b^2
 * 
 * Since the perimeter p = a + b + c, you can solve (after pen & Paper) the following:
 * p^2 - 2*p(a+b) + 2*a*b = 0
 * 
 * => b = ((p^2)/2 - (p*a)) / (p - a)
 * 
 * Given that p, a, b and c have to be integers, loop through all p & a combinations
 * and if b is an integer value, then that set is considered part of the above set
 */
public class Problem39_Main {

	public static void main(String[] args) {
		Problem39_Main problem = new Problem39_Main();
		int maxNumOfSets = 0;
		int perimeterValue = 0;
		for (int p = 1; p <= 1000; p++) {
			int numOfSets = problem.findNumberOfSets(p);
			if (maxNumOfSets < numOfSets) {
				maxNumOfSets = numOfSets;
				perimeterValue = p;
			}
		}

		System.out.println("Maximum Number of Sets of 1 <= p <= 1000: "
				+ perimeterValue);
	}

	public int findNumberOfSets(int perimeterLength) {
		double p = perimeterLength;
		int numberOfSets = 0;
		for (int a = 1; a < perimeterLength / 2; a++) {
			//Apply the formula mentioned above to find b
			double b = ((p * p) / 2 - (p * a)) / (p - a);
			//If casting b to an integer results in the same value, then the set holds true
			if ((int) b == b)
				numberOfSets++;
		}

		return numberOfSets / 2;
	}
}
