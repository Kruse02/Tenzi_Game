import java.util.ArrayList;

/**
 * This class controls individual games 
 * 
 * @author Kruse
 *
 */
public class TenziGame {
    /**  The amount of turns that have been taken */
    private int turns;
    
    /**  The time that the game starts*/
    private long startTime;
    
    /**  The time that the game ends*/
    private long endTime;
    
    /**  The Array of 10 die*/
    private ArrayList<Die> theDice;

    /**
     * Constructor that initializes the amount of turns, the start time of the game, the end time, and the Array of Die
     */
    public TenziGame() {
        turns = 1;
        startTime = System.currentTimeMillis();
        endTime = 0;
        theDice = new ArrayList<Die>();
    }

    /**
     * This method adds Dice to the Array List
     * 
     * @param numberOfDice An integer of the amount of dice being added to the Array List
     */
    public void addDice(int numberOfDice) {
        while (numberOfDice > 0) {
            theDice.add(new Die());
            numberOfDice = numberOfDice - 1;
        }
    }

    /**
     * This method determines if the game is over or not
     * 
     * @return boolean of true if the game is over or false if not.
     */
    public boolean isOver() {
        int numberOfMatches = 0;
        int matchingValue = theDice.get(0).getFaceValue();
        for (int i = 0; i < theDice.size(); i++) {
            Die currentDie = theDice.get(i);
            if (matchingValue == currentDie.getFaceValue()) {
                numberOfMatches = numberOfMatches + 1;
            }
        }
        if (numberOfMatches == 10) {
            return true;
        }
        return false;
    }

    /**
     * This method rolls the die selected by the user.
     * 
     * @param reroll An integer array stating which die to reroll.
     */
    public void roll(int[] reroll) {
        for (int i = 0; i < reroll.length; i++) {
            theDice.get(reroll[i]).roll();
        }
        turns = turns + 1;
    }

    /**
     * This method determines how long the game took.
     * 
     * @return A long integer stating the time in milliseconds for how long the game took.
     */
    public long getTimeElapsed() {
        long stopTime = System.currentTimeMillis();
        long time = stopTime - startTime;
        return time;
    }

    /**
     * This method is used to find the number of turns.
     * 
     * @return an integer stating the amount of turns.
     */
    public int getTurns() {
        return turns;
    }

    /**
     *This method turns the Array list of die into a String so it can be printed.
     */
    @Override
    public String toString() {
        String dieString = "";
        for (int i = 0; i < theDice.size(); i++) {
            Die currentDie = theDice.get(i);
            dieString = dieString + i + ": " + currentDie.toString() + "\n";
        }
        return dieString;

    }

}
