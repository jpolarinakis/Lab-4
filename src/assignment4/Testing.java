package assignment4;

import static org.junit.Assert.*;

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
		assertTrue(WordLadderSolver.letterDifference("asdf", "asda") == 1);
		assertTrue(WordLadderSolver.letterDifference("asdfa", "asdaa") == 1);
		assertTrue(WordLadderSolver.letterDifference("asdfgg", "asdagg") == 1);
		assertTrue(WordLadderSolver.letterDifference("asdff", "asdaa") == 2);
		assertTrue(WordLadderSolver.letterDifference("asdfff", "asdaaa") == 3);
		assertTrue(WordLadderSolver.letterDifference("asdf", "asda") == 1);
		assertTrue(WordLadderSolver.letterDifference("asdf", "asda") == 1);
		
	}

	@Test
	/*
	 * Will test to ensure the accuracy of the program
	 * */
	public void testSolveWordLadder() throws Throwable {
		/*
		 * Standard black box testing. inputs with known outputs will be test
		 * */
		assertNotNull(test.computeLadder("zebra","money"));
		assertNotNull(test.computeLadder("stone","money"));
		assertNotNull(test.computeLadder("corny","corky"));
		assertNotNull(test.computeLadder("coins","tests"));

		
		/*
		 * White box testing: These tests will ensure that particular functions work
		 * */
	}

	
}
