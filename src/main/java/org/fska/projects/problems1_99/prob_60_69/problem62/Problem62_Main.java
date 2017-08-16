package org.fska.projects.problems1_99.prob_60_69.problem62;

import java.util.HashMap;
import java.util.Map;

import utils.common.PermutedNumber;

/**
 * 
 The cube, 41063625 (345^3), can be permuted to produce two other cubes:
 * 56623104 (384^3) and 66430125 (405^3). In fact, 41063625 is the smallest cube
 * which has exactly three permutations of its digits which are also cube.
 * 
 * Find the smallest cube for which exactly five permutations of its digits are
 * cube.
 * 
 * @author fskallos
 * 
 */
public class Problem62_Main {

	public static void main(String[] args) {
		Problem62_Main problem = new Problem62_Main();
		problem.run();
	}
	Map<PermutedNumber, Integer> cubicPermutations;

	public void run() {
		cubicPermutations = new HashMap<PermutedNumber, Integer>();
		for (long value = 2; value < 10000; value++) {
			long input = value * value * value;
			PermutedNumber pn = new PermutedNumber(input);
			if (cubicPermutations.containsKey(pn)) {
				if (cubicPermutations.get(pn) == 4) {
					// Game is over, 5 permuted values found!
					for (PermutedNumber key : cubicPermutations.keySet()) {
						if (key.isMatch(pn)) {
							System.out.println("Game over!  Value: "
									+ key.getValue());
							return;
						}
					}
				} else {
					cubicPermutations.put(pn, cubicPermutations.get(pn) + 1);
				}
			} else {
				cubicPermutations.put(pn, 1);
			}
		}
	}
}
