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
	private Map<String, List<String>> dictionaryMap;//AL for the problem
	
	public WordLadderSolver() {
		
		/*
		 * The goal of this section is to make an adjacenty list. Each node in the map 
		 * (any word in the dictionary) is paired in an array list with its edges 
		 * (the words it is one letter away from). This make it much easier to determine
		 * the BFS
		 * */
		dictionaryMap = new HashMap<String, List<String>>();
		try {
			FileReader freader = new FileReader("A4words.dat");
			BufferedReader reader = new BufferedReader(freader);
			//for loop finds all valid words to be used in dictionary
			//word = some word that belongs in the dictionary
			for (String word = reader.readLine(); word != null; word = reader.readLine()) {
				if (word.charAt(0) == '*')
					continue;
				word = word.substring(0, 5);
				dictionaryMap.put(word, new ArrayList<String>());
			}
		} catch (FileNotFoundException e) {//executes in the event that a file is not found
			System.out.println("Error: File not found. Exiting...");
			System.exit(-1);
		} catch (IOException e) {// executes in the event of some I/O bug
			System.out.println("Error: IO exception. Exiting...");
			System.exit(-1);
		}
		/*
		 * Step two of the map making endevour. We fill the adjacency list with the 
		 * appropriate edges
		 * */
		for (String key: dictionaryMap.keySet()) {
			for (String key2: dictionaryMap.keySet()) {
				if (OneLetterDifference(key, key2)) {
					dictionaryMap.get(key).add(key2);
				}
			}
		}
		
		
		

	}
	
	
	/*
	 * Computes the necessary word ladder
	 * @param starting word
	 * @param ending word
	 * @return the word ladder 
	 * */
	public List<String> computeLadder(String startWord, String endWord)
			throws NoSuchLadderException {
		// implements error checking
		if (!dictionaryMap.containsKey(startWord))
			throw new NoSuchLadderException("First word is not in dictionary");
		
		if (!dictionaryMap.containsKey(endWord))
			throw new NoSuchLadderException("Last word is not in dictionary");
		//computes the valid ladder
		List<String> retObj = computeLadderRecursively(startWord, endWord, new ArrayList<String>(), new ArrayList<String>());
		//in the event that a ladder does not exist this executes
		if (retObj == null){
			System.out.println("No ladder for " + startWord + " and " + endWord);}
			return retObj;
	}
	/*
	 * recursively determines the word ladder for the given problem
	 * @param startWord starting position
	 * @param endWord ending position
	 * @param List prevWords the words tried before
	 * @param List allWords all words in dictionary
	 * */
	private List<String> computeLadderRecursively(String startWord, String endWord, List<String> prevWords, List<String> allWords) {
		//if we have found the last word, it's time to terminate the program
		if (dictionaryMap.get(startWord).contains(endWord)) {
			prevWords.add(startWord);
			prevWords.add(endWord);
			return prevWords;
		}
		
		//creates the ladder for each word that could be the next word 
		for (String middleWord: dictionaryMap.get(startWord)) {
			if (allWords.contains(middleWord))
				continue;
			prevWords.add(startWord);
			allWords.add(startWord);
			List<String> test = computeLadderRecursively(middleWord, endWord, prevWords, allWords);
			//if we have found a ladder return
			if(test != null){
				return test;}
			//remove that word, try again
			prevWords.remove(prevWords.size() - 1);
		}
		//clearly there is no ladder so return a null
		return null;
		}

	/*
	 * validates if the ladder is valid or not
	 *@param startWord the starting position
	 *@param endWord the ending position
	 *@boolean a flag if the results are correct or not 
	 * 
	 * */
	public boolean validateResult(String startWord, String endWord,
			List<String> wordLadder) {		
		/*
		 * For each pair of words, makes sure they are only one letter apart
		 * */
		String prevWord = startWord;
 		for (int x = 1; x < wordLadder.size(); x++) {
 			if (!OneLetterDifference(prevWord, wordLadder.get(x)))
 				return false;
 			prevWord = wordLadder.get(x);
 		}
 		return true;
		
	}
	/*
	 * validates that there is only one letter difference between the words
	 * @param first the first word
	 * @param second the second word
	 * @boolean flag if the two words are similar except one word
	 * */
	public static boolean OneLetterDifference(String first, String second) {
		/*
		 * Makes sure that there are only one letter difference and exactly one
		 * letter difference between the two words input. Increments through each
		 * word. If a difference if found it is noted and then if the difference is 1
		 * true is returned
		 * */
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



	// add additional methods here
}