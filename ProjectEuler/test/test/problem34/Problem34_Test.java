package test.problem34;

import static org.junit.Assert.*;

import org.junit.Test;

import problem34.Problem34_Main;

public class Problem34_Test {
	Problem34_Main problem;
	@Test
	public void test() {
		problem = new Problem34_Main();
		assertTrue(problem.isCuriousFactorial(145));
	}

}
