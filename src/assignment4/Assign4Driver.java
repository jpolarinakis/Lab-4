package assignment4;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class Assign4Driver {

	private static List<String> inputs;

	public static void main(String[] args) throws Throwable {
		WordLadderSolver word = new WordLadderSolver(); //driver to control the ladder
		InitializeInputs(args);		//prepares the map
		/*
		 * Begin test code
		 * */
		/*
		Testing test = new Testing();
		test.testIsDifferent();
		test.testSolveWordLadder();
	    Result results = JUnitCore.runClasses(Testing.class);
	    for (Failure failure : results.getFailures()) {
	      System.out.println(failure.toString());
	      System.out.println("something is happening");
	    }
		System.err.println("Test has concluded, exiting...");
		System.exit(-1);
		*/
		/*
		 * End test code
		 * */
		/*
		 * Begins actual code
		 * */
		String firstWord = null; //beginning of word ladder
		String secondWord = null;// end of word ladder
		for (int i = 0; i < inputs.size(); i++ ) {
			Scanner scanner = new Scanner(inputs.get(i));
			//error handling for incorrect number of arguments
			try {
				firstWord = scanner.next();
			} catch (Exception e) {
				System.out.println("There is no first word");
				continue;
			}
			
			try {
				secondWord = scanner.next();
			} catch (Exception e) {
				
				System.out.println("There is no second word");
				continue;
			}
			//computes word ladder in the event that there are inputs
			try {
				List<String> result = word.computeLadder(firstWord,
						secondWord);
				//does not output in the event that it's null
				if(result == null){}
				else{
				for (int x = 0; x < result.size(); x ++) {
					System.out.println(result.get(x));
				}
				//outputs the result
				System.out.println("********************************************************");
				System.out.println("The results of the test are: ");
				boolean correct = word.validateResult(firstWord, secondWord,result);
				System.out.println(correct);
				System.out.println("********************************************************");
				System.out.println("");
			}
				
			} catch (NoSuchLadderException e) {
				e.printStackTrace();
			}
		}

		


	}
	/*
	 * prepares the map for the use in the program
	 * @param String[] args gives the inputed data
	 * */
	private static void InitializeInputs(String[] args) {
		// Check if there is a valid file in the argument
		if (args.length != 1) {
			System.err.println("Error: Incorrect number of command line arguments");
			System.exit(-1);
		}
		
		inputs = new ArrayList<String>();
		
		// Open file; file name specified in args (command line)
		try {
			//reads valid words out of the dictionary
			FileReader freader = new FileReader(args[0]);
			BufferedReader reader = new BufferedReader(freader);
			for (String s = reader.readLine(); s != null; s = reader.readLine()) {
				inputs.add(s);
			}
		} catch (FileNotFoundException e) {
			System.out.println("Error: File not found. Exiting...");
			System.exit(-1);
		} catch (IOException e) {
			System.out.println("Error: IO exception. Exiting...");
			System.exit(-1);
		}
	}
}