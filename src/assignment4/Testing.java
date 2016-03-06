package assignment4;

import static org.junit.Assert.*;

import java.awt.List;

import javax.naming.spi.DirStateFactory.Result;

import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.notification.Failure;

public class Testing {
	private WordLadderSolver test = new WordLadderSolver();

	/*
	 * Tests if there is are differences between the strings
	 * */
	public void testIsDifferent() {
		//System.out.println(WordLadderSolver.letterDifference("asdf", "asda"));
		assertTrue(WordLadderSolver.OneLetterDifference("asdf", "asda"));
		assertTrue(WordLadderSolver.OneLetterDifference("money", "coney"));
		assertTrue(WordLadderSolver.OneLetterDifference("veryy", "kjfdd"));
		assertTrue(WordLadderSolver.OneLetterDifference("45678", "26455"));
		assertTrue(WordLadderSolver.OneLetterDifference("aaaaa", "aabaa"));
		assertTrue(WordLadderSolver.OneLetterDifference("aaaaa", "baaaa"));
		assertTrue(WordLadderSolver.OneLetterDifference("aaaaa", "aaaba"));
		assertTrue(WordLadderSolver.OneLetterDifference("aaaaa", "abaaa"));
		assertTrue(WordLadderSolver.OneLetterDifference("aaaaa", "aaaab"));
		
	}

	@Test
	/*
	 * Will test to ensure the accuracy of the program
	 * */
	public void testSolveWordLadder() throws Throwable {
		/*
		 * Standard black box testing. inputs with known outputs will be test
		 * */
		
		assertNotNull(test.computeLadder("12345","3jlk*"));
		assertNotNull(test.computeLadder("ljksd","money"));
		assertNotNull(test.computeLadder("money","ljksd"));
		assertNotNull(test.computeLadder("coins","money"));
		assertNotNull(test.computeLadder("coins","zebra"));
		assertNotNull(test.computeLadder("coney","money"));
		
		/*
		 * White box testing: These tests will ensure that particular functions work
		 * */
		testIsDifferent();
		String start = "coins";
		String end = "corny";
		java.util.List<String> test1 = (java.util.List<String>) new List();
		java.util.List<String> test2 = (java.util.List<String>) new List();
		java.util.List<String> test3 = (java.util.List<String>) new List();
		test1.add("coins");
		test1.add("corns");
		test1.add("corny");
		test2.add("coins");
		test2.add("corns");
		test2.add("money");
		assertTrue(test.validateResult(start,end,test1));
		assertFalse(test.validateResult(start,end,test2));
		assertFalse(test.validateResult(start,end,test3));
		
		
	}

	
}
