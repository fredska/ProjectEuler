package org.fska.projects.test.problem34;

import static org.junit.Assert.*;

import org.junit.Test;

import org.fska.projects.problems1_99.prob_30_39.problem34.Problem34_Main;

public class Problem34_Test {
	Problem34_Main problem;
	@Test
	public void test() {
		problem = new Problem34_Main();
		assertTrue(problem.isCuriousFactorial(145));
	}

}
