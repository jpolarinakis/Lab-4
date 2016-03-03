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
	
	//int array contains indexes of words that are only 1 letter different
	private Map<String, List<String>> dictionaryMap;
	
	public WordLadderSolver() {
		
		System.out.println(System.currentTimeMillis());
		dictionaryMap = new HashMap<String, List<String>>();
		try {
			FileReader freader = new FileReader("A4words.dat");
			BufferedReader reader = new BufferedReader(freader);
			for (String s = reader.readLine(); s != null; s = reader.readLine()) {
				if (s.charAt(0) == '*')
					continue;
				s = s.substring(0, 5);
				dictionaryMap.put(s, new ArrayList<String>());
			}
		} catch (FileNotFoundException e) {
			System.out.println("Error: File not found. Exiting...");
			System.exit(-1);
		} catch (IOException e) {
			System.out.println("Error: IO exception. Exiting...");
			System.exit(-1);
		}

		for (String key: dictionaryMap.keySet()) {
			for (String key2: dictionaryMap.keySet()) {
				if (OneLetterDifference(key, key2)) {
					dictionaryMap.get(key).add(key2);
				}
			}
		}
		
		
		System.out.println(System.currentTimeMillis());

	}
	
	
	// do not change signature of the method implemented from the interface
	// @Override
	public List<String> computeLadder(String startWord, String endWord)
			throws NoSuchLadderException {
		// implement this method
		if (!dictionaryMap.containsKey(startWord))
			throw new NoSuchLadderException("First word is not in dictionary");
		
		if (!dictionaryMap.containsKey(endWord))
			throw new NoSuchLadderException("Last word is not in dictionary");
		
		List<String> retObj = computeLadderRecursively(startWord, endWord, new ArrayList<String>());
		
		if (retObj == null)
			throw new NoSuchLadderException("No ladder for " + startWord + " and " + endWord);
		else
			return retObj;
	}
	
	private List<String> computeLadderRecursively(String startWord, String endWord, List<String> prevWords) {
		
		
		if (dictionaryMap.get(startWord).contains(endWord)) {
			prevWords.add(startWord);
			prevWords.add(endWord);
			return prevWords;
		}
		for (String middleWord: dictionaryMap.get(startWord)) {
			if (prevWords.contains(middleWord))
				continue;
			prevWords.add(startWord);
			List<String> test = computeLadderRecursively(middleWord, endWord, prevWords);
			if(test != null)
				return test;
		}
		
		return null;
		}

	// @Override
	public boolean validateResult(String startWord, String endWord,
			List<String> wordLadder) {
		//throw new UnsupportedOperationException("Not implemented yet!");
		return OneLetterDifference(startWord,endWord);
		
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
		if (ret == 0) {
			return false;
		}
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
