package org.fska.projects.problems1_99.prob_50_59.problem57;

import java.math.BigInteger;

/**
 * 
It is possible to show that the square root of two can be expressed as an infinite continued fraction.

√ 2 = 1 + 1/(2 + 1/(2 + 1/(2 + ... ))) = 1.414213...

By expanding this for the first four iterations, we get:

1 + 1/2 = 3/2 = 1.5
1 + 1/(2 + 1/2) = 7/5 = 1.4
1 + 1/(2 + 1/(2 + 1/2)) = 17/12 = 1.41666...
1 + 1/(2 + 1/(2 + 1/(2 + 1/2))) = 41/29 = 1.41379...

The next three expansions are 99/70, 239/169, and 577/408, but the eighth expansion, 1393/985, is the first example where the number of digits in the numerator exceeds the number of digits in the denominator.

In the first one-thousand expansions, how many fractions contain a numerator with more digits than denominator?

 * @author fskallos
 *
 */

/*
 * The trick to this problem isn't through brute force, but by knowing what the next numerator / denomiator values will be in the next iteration.
 * 
 * take the first 3 final values above:
 * 
 * f(0) = 3 / 2
 * f(1) = 7 / 5
 * f(2) = 17/12
 * 
 * f(2) can be described by the previous two values:
 * f(2) = (f(n0) + 2 * f(n1)) / (f(d0) + 2 * f(d1))
 * 
 * With that formula, you can predict f(3):
 * f(3) = (f(n1) + 2 * f(n2)) / (f(d1) + 2 * f(d2))
 * f(3) = (7 + 2 * 17) / (5 + 2 * 12)
 * f(3) = 41 / 29
 */

public class Problem57_Main {

	public static void main(String[] args) {
		Problem57_Main problem = new Problem57_Main();
		problem.run();
	}

	public Problem57_Main(){
	}
	
	private BigInteger[] numerators;
	private BigInteger[] denomiators;
	private final BigInteger MULTIPLIER = new BigInteger("2");
	public void run(){
		
		//Intialize our variables & starting values
		numerators = new BigInteger[1000];
		denomiators = new BigInteger[1000];
		
		numerators[0] = new BigInteger("3");
		numerators[1] = new BigInteger("7");
		
		denomiators[0] = new BigInteger("2");
		denomiators[1] = new BigInteger("5");
		
		for(int c = 2; c < 1000; c++){
			numerators[c] = nextIteration(numerators[c-2], numerators[c-1]);
			denomiators[c] = nextIteration(denomiators[c-2], denomiators[c-1]);
		}
		
		//Now goes back through and find the number of times a numerator is greater than a denominator
		int count = 0;
		for(int c =0; c < 1000; c++){
			if(numerators[c].toString().length() > denomiators[c].toString().length()){
//				System.out.println(numerators[c] + " / " + denomiators[c]);
				count++;
			}
		}
		
		System.out.println("Final Count: " + count);
	}
	
	private BigInteger nextIteration(BigInteger f0, BigInteger f1){
		return f0.add(f1.multiply(MULTIPLIER));
	}
}
