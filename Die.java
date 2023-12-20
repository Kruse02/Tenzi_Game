import java.util.Random;

/**
 * This class is used to build Die objects of a specified number of sides that
 * can be randomly rolled.
 * 
 * @author Kruse
 *
 */
public class Die {

    // instance variables (internal state)
    /** How many sides the Die has. */
    private int numberOfSides;

    /**
     * The current face value of the Die.
     */
    private int faceValue;

    Random generator = new Random();

    // constructors

    /**
     * This constructor builds a Die object and sets the number of sides to 6 and
     * the face value to 1.
     * 
     */
    public Die() {
        numberOfSides = 6;
        faceValue = generator.nextInt(numberOfSides) + 1;

    }

    /**
     * This constructor builds a Die object with the input number of sides and sets
     * the initial face value to 1.
     * 
     * @param sides The number of sides the Die should have.
     */
    public Die(int sides) {
        // job: put meaningful values into all instance variables
        numberOfSides = sides;
        faceValue = 1;

    }

    // methods

    /**
     * This method returns the current face value of the die.
     * 
     * @return The current face value of the Die object.
     * 
     */
    public int getFaceValue() {
        return faceValue;
    }

    /**
     * This method rolls the current Die, resulting in the face value being a random
     * value from 1 to the number of sides.
     */
    public void roll() {
        Random generator = new Random();
        faceValue = generator.nextInt(numberOfSides) + 1;

    }

    /**
     * Converts the current Die state to a String with the number of sides and the
     * face value
     * 
     * @return A String representation of the current state of the Die.
     */
    @Override
    public String toString() {
        String representation = "";
        for (int i = 0; i < getFaceValue(); i++) {
            representation = representation + "* ";
        }
        return representation;
    }

}