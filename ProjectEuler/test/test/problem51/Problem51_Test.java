package test.problem51;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import problem51.Problem51Main;

public class Problem51_Test {

	private Problem51Main problem;
	@Before
	public void setup(){
		problem = new Problem51Main();
	}
	
	/**
	 * Badly named method;  Test returns all prime values when 
	 * the '*' character is replaced with values ranging from 0 to 9
	 */
	@Test
	public void replaceStarWithValue_Test() {
		List<Integer> results = problem.replaceStarWithValue("*3");
		assertTrue(results.size() == 6);
		results = problem.replaceStarWithValue("56**3");
		assertTrue(results.size() == 7);
		results = problem.replaceStarWithValue("*2*3*3");
		assertEquals(results.size(), 8);
	}
	
	@Test
	public void getNumOfSimilarDigits_Test(){
		
		assertTrue(problem.getNumOfSimilarDigits(12345) == 1);
		assertTrue(problem.getNumOfSimilarDigits(543210) == 1);
		assertTrue(problem.getNumOfSimilarDigits(168198) == 2);
		assertTrue(problem.getNumOfSimilarDigits(5454544) == 4);
	}
	
	@Test
	public void replaceCharacterAtPosition_Test(){
		assertEquals("12*45", problem.replaceCharacterAtPosition("12345", 2));
		assertEquals("1234*", problem.replaceCharacterAtPosition("12345", 4));
		assertEquals("*2345", problem.replaceCharacterAtPosition("12345", 0));
		
		String test = problem.replaceCharacterAtPosition("12345", 0);
		test = problem.replaceCharacterAtPosition(test, 3);
		assertEquals("*23*5", test);
	}
	
	@Test
	public void getCombination_Test(){
		boolean[][] checkValues = problem.getCombination(6);
		
		assertTrue(true);
	}
	
	@Test 
	public void validateCombinationCheck_Test(){
		assertTrue(problem.validateCombinationCheck("12345", new boolean[]{false, false, true, false, false}));
		assertFalse(problem.validateCombinationCheck("12345", new boolean[]{true, false, true, false, false}));
	}

}
