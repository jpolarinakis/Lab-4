/*
    ADD YOUR HEADER HERE
 */

package assignment4;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// do not change class name or interface it implements
public class WordLadderSolver implements Assignment4Interface {
	
	
	// delcare class members here.

	// add a constructor for this object. HINT: it would be a good idea to set
	// up the dictionary there
	private List<String> dictionary;
	private Map<String, String[]> oneLetterDifference;
	
	public WordLadderSolver() {
		dictionary = new ArrayList<String>();
		try {
			FileReader freader = new FileReader("A4words.dat");
			BufferedReader reader = new BufferedReader(freader);
			for (String s = reader.readLine(); s != null; s = reader.readLine()) {
				if (s.charAt(0) == '*')
					continue;
				s = s.substring(0, 5);
				dictionary.add(s);
			}
		} catch (FileNotFoundException e) {
			System.out.println("Error: File not found. Exiting...");
			System.exit(-1);
		} catch (IOException e) {
			System.out.println("Error: IO exception. Exiting...");
			System.exit(-1);
		}
	}
	
	
	// do not change signature of the method implemented from the interface
	// @Override
	public List<String> computeLadder(String startWord, String endWord)
			throws NoSuchLadderException {
		// implement this method
		throw new UnsupportedOperationException("Not implemented yet!");
	}

	// @Override
	public boolean validateResult(String startWord, String endWord,
			List<String> wordLadder) {
		throw new UnsupportedOperationException("Not implemented yet!");
		/*
		 * boolean ret = false;
		 * 
		 * return ret;
		 */
	}
	
	public static boolean OneLetterDifference(String first, String second) {
		int ret = 0;
		for (int i = 0; i < first.length(); i++) {
			if (first.charAt(i) != second.charAt(i)){
				ret++;
				if (ret == 2) {
					return false;
				}
			}
		}
		//if ret is 0 that means the word matched. 
		//this will never happen in the dictionary.
		return true;
	}

	public static int letterDifference(String first, String second) {
		int ret = 0;
		for (int i = 0; i < first.length(); i++) {
			if (first.substring(i, i + 1).equals(second.substring(i, i + 1))) {
				continue;
			}
			ret++;
		}
		return ret;
	}

	// add additional methods here
}
