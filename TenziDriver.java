import java.util.Scanner;

/**
 * This class runs the Leaderboard and TenziGame class to complete the game
 * 
 * @author Kruse
 *
 */
public class TenziDriver {

    public static void main(String[] args) {
        Leaderboard topTimes = new Leaderboard();
        Scanner keyboard = new Scanner(System.in);
        boolean continueGame = true;
        while (continueGame == true) {
            TenziGame game1 = new TenziGame();
            game1.addDice(10);
            System.out.println(game1);
            while (game1.isOver() == false) {
                System.out.print("Which dice should be rerolled: ");
                String input = keyboard.nextLine();
                game1.roll(splitToInts(input));
                System.out.println(game1);
            }
            System.out.println("Game Over. You used " + game1.getTurns() + " turns and "
                    + game1.getTimeElapsed() / (double) 1000 + " seconds." + "\n");
            topTimes.update(game1.getTimeElapsed());
            System.out.println("--CurrentLeaderboard (in seconds)--");
            System.out.println(topTimes.toString());
            System.out.print("Play again? (Y/N) ");
            if (keyboard.nextLine().equals("N")) {
                continueGame = false;
            }
        }
    }

    /**
     * This method splits the user input into an integer array so that it can be easily read by the program.
     * 
     * @param dice The user input string for which die to reroll.
     * @return An integer array stating which die to reroll.
     */
    public static int[] splitToInts(String dice) {
        String[] diceSplit;
        diceSplit = dice.split(",");
        int[] reroll = new int[diceSplit.length];
        for (int i = 0; i < diceSplit.length; i++) {
            int currentDie = Integer.parseInt(diceSplit[i]);
            reroll[i] = currentDie;

        }
        return reroll;
    }

}
