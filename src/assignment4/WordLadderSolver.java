/*
    ADD YOUR HEADER HERE
 */

package assignment4;

import java.util.List;

// do not change class name or interface it implements
public class WordLadderSolver implements Assignment4Interface
{
    // delcare class members here.

    // add a constructor for this object. HINT: it would be a good idea to set up the dictionary there

    // do not change signature of the method implemented from the interface
   // @Override
    public List<String> computeLadder(String startWord, String endWord) throws NoSuchLadderException 
    {
        // implement this method
        throw new UnsupportedOperationException("Not implemented yet!");
    }

   // @Override
    public boolean validateResult(String startWord, String endWord, List<String> wordLadder) 
    {
       throw new UnsupportedOperationException("Not implemented yet!");
        /*boolean ret = false;
        
        return ret;*/
    }
    
    public int letterDifference(String first, String second)
    {
    	int ret = 0;
    	for(int i =0; i < first.length(); i++)
    	{
    		if(first.substring(i,i+1).equals(second.substring(i,i+1))){}
    			ret++;
    	}
    	return ret;
    }

    // add additional methods here
}
