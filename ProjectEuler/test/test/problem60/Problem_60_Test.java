package test.problem60;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import problem60.Problem_60;

public class Problem_60_Test {

	Problem_60 problem;
	
	@Before
	public void initialize(){
		problem = new Problem_60();
	}
	
	@Test
	public void testConfirmPrimePair(){
		assertTrue(problem.confirmPairSet(7, 109));
		assertTrue(problem.confirmPairSet(109, 673));
	}
	
	@Test
	public void testSetOfPairs(){
		assertTrue(problem.checkPairs(new int[]{3,7,109,673}));
		assertFalse(problem.checkPairs(new int[]{3,7,109,673, 1021}));
	}
	
	@Test
	public void testGetAllPotentialPrimes(){
		List<Integer> matchedPrimes = problem.getAllPotentialPrimes(109);
		assertTrue(matchedPrimes.contains(7109));
	}
	
	@Test
	public void testBreakDownPrime(){
		List<Integer> brokenDownPrimes = problem.breakDownPrime(7109);
		assertNotNull(brokenDownPrimes);
		assertTrue(brokenDownPrimes.contains(7));
		assertTrue(brokenDownPrimes.contains(71));
		assertTrue(brokenDownPrimes.contains(109));
	}
}
