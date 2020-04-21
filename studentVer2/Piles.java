import java.util.ArrayList;
import java.util.Random;
import java.util.*;
/**
 * A class that plays Bulgarian Solitare.
 * Version 3: Complete the isDone method.
 */
public class Piles
{    
    private ArrayList<Integer> piles;

    /**
    Sets up the game randomly with some number of piles of random
    size. The pile sizes add up to 45.
     */
    public Piles(Random generator)
    {
        piles = new ArrayList<Integer>();
        /* randomly divide up the deck into piles */
        int TOTAL_SIZE = 45;  // number of cards in a deck
        int numCards = TOTAL_SIZE;
        while (numCards > 0)
        {
            int pile = generator.nextInt(numCards) + 1;
            piles.add(pile);
            numCards -= pile;
        }
    }

    /**
    Set up a pile with a known (non-random) configuration for testing.
    @param pileSizes an array of numbers whose sum is 45
     */
    public Piles(int[] pileSizes)
    {
        piles = new ArrayList<>();
        for (int s : pileSizes)
            piles.add(s);
    }

    /**
    Play one round of the game.
     */
    public void playRound()
    {
        //had to redo this function because it wouldn't work in ver2. Worked fine in ArrayList---> will go back and fix
        piles.add(0); 
        for (int i = 0; i < piles.size(); i++)
        {
            if (piles.get(i) == 1)
            {
                piles.remove(i);
                i--; //to ensure that the next iteration isn't skipped
            }
            else if (piles.get(i)>1) 
            {
                piles.set(i, piles.get(i)-1);
            }

            piles.set(piles.size()-1, piles.get(piles.size()-1)+1);
        }

    }
        /**
    Checks whether the game is done.
    @return true when the piles have size
    1, 2, 3, 4, 5, 6, 7, 8, and 9, in some order.
     */
    public boolean isDone()
    {

        Collections.sort(piles); //sorts

        //start by making sure the array has exactly nine piles
        if (piles.size() == 9)
        {
         //ensures that the cards are actually in order
            if (piles.get(0)==1 && piles.get(1)==2 && piles.get(2)==3 && piles.get(3)==4 && piles.get(4)==5 && piles.get(5)==6 && piles.get(6)==7 && piles.get(7)==8 && piles.get(8)==9)
                return true;
        }
        return false; //if not, fase
    }
    
    /**
     * Return the string representation of the piles.
     * @return the string representation of the piles.
     */
    public String toString()
    {
        return piles.toString(); //allows you to print
    }

}