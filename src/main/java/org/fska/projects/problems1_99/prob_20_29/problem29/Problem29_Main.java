package org.fska.projects.problems1_99.prob_20_29.problem29;

import java.util.HashSet;
import java.util.Set;

public class Problem29_Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		System.out.println("Project Euler: Problem 29");
		//Set<Double> answer = getNumber(new HashSet<Double>(), 2, 2);
		//System.out.println("Size of all unique combinations: " + answer.size());
		double a = 2;
		double b = 2;
		Set<Double> answer = new HashSet<Double>();
		while(b <= 100)
		{
			a = 2;
			while(a < 100)
			{
				answer.add(Math.pow(a, b));
				a++;
			}
			answer.add(Math.pow(a, b));
			b++;
		}
		System.out.println("Final Tally: " + answer.size());
	}

	private static Set<Double> getNumber(Set<Double> dblArray, double a, double b)
	{
		//Cut out the recursive function here
		if(a>100 && b>100)
		{
			return dblArray;
		}
		if(a <= 100 && a > 1)
		{
			dblArray.add(Math.pow(a, b));
			return getNumber(dblArray, a+1, b);
		}
		if( b <= 100 && b > 1)
		{
			dblArray.add(Math.pow(a, b));
			return getNumber(dblArray, 2, b+1);
		}
		
		//If something goes wrong!
		System.out.println("Something went wrong!");
		return null;
	}

}
