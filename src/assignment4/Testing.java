package assignment4;

import static org.junit.Assert.*;

import org.junit.Test;

public class Testing {

	//@Test
	public void testIsDifferent() {
		System.out.println(WordLadderSolver.letterDifference("asdf", "asda"));
		assertTrue(WordLadderSolver.letterDifference("asdf", "asda") == 1);
		assertTrue(WordLadderSolver.letterDifference("asdfa", "asdaa") == 1);
		assertTrue(WordLadderSolver.letterDifference("asdfgg", "asdagg") == 1);
		assertTrue(WordLadderSolver.letterDifference("asdff", "asdaa") == 2);
		assertTrue(WordLadderSolver.letterDifference("asdfff", "asdaaa") == 3);
		assertTrue(WordLadderSolver.letterDifference("asdf", "asda") == 1);
		assertTrue(WordLadderSolver.letterDifference("asdf", "asda") == 1);
		
	}

	@Test
	public void testSolveWordLadder() {
		
	}
	
}
