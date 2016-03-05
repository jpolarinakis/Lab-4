package assignment4;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Assign4Driver {

	private static List<String> inputs;

	public static void main(String[] args) {
		// Create a word ladder solver object
		//Assignment4Interface wordLadderSolver = new WordLadderSolver();
		WordLadderSolver word = new WordLadderSolver();
		InitializeInputs(args);		
		String firstWord = null;
		String secondWord = null;
		for (int i = 0; i < inputs.size(); i++ ) {
			Scanner scanner = new Scanner(inputs.get(i));
		
			//String firstWord = null;
			try {
				firstWord = scanner.next();
			} catch (Exception e) {
				System.out.println("There is no first word");
				continue;
			}
			
			//String secondWord = null;
			try {
				secondWord = scanner.next();
			} catch (Exception e) {
				
				System.out.println("There is no second word");
				continue;
			}
			
			try {
				List<String> result = word.computeLadder(firstWord,
						secondWord);

				
				for (int x = 0; x < result.size(); x ++) {
					System.out.println(result.get(x));
				}

				boolean correct = word.validateResult(firstWord, secondWord, result);
				System.out.println(correct);
			} catch (NoSuchLadderException e) {
				e.printStackTrace();
			}
		}

		


	}

	private static void InitializeInputs(String[] args) {
		// Check if there is a valid file in the argument
		if (args.length != 1) {
			System.err.println("Error: Incorrect number of command line arguments");
			System.exit(-1);
		}
		
		inputs = new ArrayList<String>();
		
		// Open file; file name specified in args (command line)
		try {
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
