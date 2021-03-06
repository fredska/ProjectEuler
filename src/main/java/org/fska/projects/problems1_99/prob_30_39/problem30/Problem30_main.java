package org.fska.projects.problems1_99.prob_30_39.problem30;

import java.util.ArrayList;

public class Problem30_main {

	private static double power = 5;

	/**
	 * @param args
	 */
	public static void main(String args[]) {
		String regex = "[/d.]+";
		ArrayList<Double> result = new ArrayList<Double>();
		double a = 2;

		while (a < 500000) {
			if (checkResult(a)) {
				result.add(a);
				System.out.println("Hit found! : " + a);
			}
			a++;
		}

		System.out.println("Super awesome fun time!");
		double finalResult = 0;
		for (Double val : result) {
			finalResult += val;
		}
		System.out.println("Final Result: " + finalResult);
	}

	private static boolean checkResult(double value) {
		String regex = "[/d.]+";
		String splitValue = Double.toString(value).split(regex)[0];

		char[] charArray = splitValue.toCharArray();

		return (value == getSum(charArray));
	}

	private static double getSum(char... input) {
		double output = 0;
		for (Character chr : input) {
			output += Math.pow(Double.parseDouble(chr.toString()), power);
		}
		return output;
	}
}
