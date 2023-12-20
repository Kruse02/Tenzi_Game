import java.util.ArrayList;

/**
 * This class controls the times by taking them in and ordering them from fastest
 * to slowest.
 * 
 * @author Kruse
 *
 */
public class Leaderboard {

    /**  The list of times for past games  */
    private ArrayList<Long> bestTimes;

    /**  
     * Constructor to initialize the Array List
     */
    public Leaderboard() {
        bestTimes = new ArrayList<Long>();
    }

    /**
     * This method adds times to the Array List and orders them least to greatest
     * 
     * @param newTime The time of the recent game that is to be added.
     */
    public void update(long newTime) {
        int finalTime = bestTimes.size();
        if (bestTimes.size() == 0) {
            bestTimes.add(newTime);
        } else if (bestTimes.get(finalTime - 1) > newTime) {
            for (int i = 0; i < bestTimes.size(); i++) {
                if (bestTimes.get(i) > newTime) {
                    bestTimes.add(i, newTime);
                    break;
                }
            }
        } else {
            bestTimes.add(newTime);
        }
    }
    
    /**
     * Method to return a String that displays the Array list of times.
     */
    @Override
    public String toString() {
        String leaderboardString = "";
        for (int i = 0; i < bestTimes.size(); i++) {
            long currentTime = bestTimes.get(i);
            int numberTime = i + 1;
            leaderboardString = leaderboardString + numberTime + ". " + currentTime / (double) 1000 + "\n";
        }
        return leaderboardString;
    }
}
