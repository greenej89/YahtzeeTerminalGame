import java.util.Random;

/** 
 * Creates an integer array representing a set of dice and interacts with the Yahtzee class 
 * to simulate the dice in the game.
 * @author Jessica Greene
 * @author Sari Byrd
 */
public class Dice {
    /** Number of dice in the set represented by the length of the integer array */
    private int diceCount;
    
    /** Number of sides per die represented by the maximum value of each integer in the array */
    private int sidesPerDie;
    
    /** An integer array object representing of a set of dice */
    private int[] dice;
    
    /**
     * Constructs an object representation of dice by initializing an integer array with a
     * length equal to the number of dice, given as a parameter. Each integer in the array 
     * represents the value of a die. Sets the number of sides per die to the given value, 
     * and sets the initial value of each die to 1.
     * @param numberOfSides number (integer) of sides on each die 
     * @param numberOfDice number (integer) of dice in the set
     */
    public Dice (int numberOfSides, int numberOfDice) {
        sidesPerDie = numberOfSides;
        diceCount = numberOfDice;
        dice = new int[numberOfDice];
        for (int i = 0; i < numberOfDice; i++) {
            dice[i] = 1;
        }
    }
    
    /**
     * Returns the integer array representation of the dice set
     * @return integer array representation of the dice set
     */
     public int[] getDice() {
        return dice;
     }
    
    /**
     * Returns the number of dice in the set
     * @return number of dice in the set
     */
    public int getDiceCount() {
        return diceCount;
    }
    
    /**
     * Returns the number of sides per die 
     * @return number of sides on each die in the set
     */
    public int getSidesPerDie() {
        return sidesPerDie;
    }
    
    /**
     * Returns a String representation of the dice array (e.g., "[1] [2] [3] [4] [5]")
     * @return String representation of the dice array
     */
    public String toString() {
        String diceString = "";
        for (int i = 0; i < diceCount; i++) {
            if (i != diceCount - 1) {
            diceString += "[" + dice[i] + "] ";
        } 
        else {
            diceString += "[" + dice[i] + "]";
        }
     }
     return diceString;
    }
    
    /**
     * Simulates the roll of all dice. Assigns a random number between 1 and the number
     * of sides per die in each index of the dice array.
     */
    public void rollAllDice() {
            Random rand = new Random();
            for (int i = 0; i < diceCount; i++) {
                dice[i] = rand.nextInt(sidesPerDie) + 1;
            }
    }
    
    /**
     * Simulates the roll of one die in a set of dice by replacing the first occurrence of 
     * the given value with a random number between 1 and the number of sides per die.
     * @param dieValue value of the die to roll
     * @return true if a die if re-rolled, false if no dice in the set contain the given value
     */
    public Boolean rollOneDie(int dieValue) {         //TODO client program will read in integers representing die values from console using a while loop
        Random rand = new Random();
        for (int i = 0; i < diceCount; i++) {
            if (dice[i] == dieValue) {
                dice[i] = rand.nextInt(sidesPerDie) + 1;
                return true;
            }
        }
        return false;                                   //TODO in client program if false is returned after a user attempts to rollOneDie, display error message
    }
    
    /**
     * Returns an array representing a tally of the number of dice displaying each possible 
     * die value.
     * The value is the array index.  The tally is an element stored at the value index.
     * This method is based on slide 13 of CSC 116 lecture on Advanced Arrays.
     * @return array of tally data
     */
    public int[] tallyDice() {
        int[] tallyArray = new int[sidesPerDie + 1];
        for (int i = 0; i < diceCount; i++) {                                                                                  
            tallyArray[dice[i]]++;
        }
        
        return tallyArray;
    } 
    
    /**
     * Returns the index of the first occurrence of the maximum value in an integer array. 
     * After a simulated roll, this method returns the most frequently occurring 
     * die value) in the array and breaks ties by choosing the lower value.
     * This method is based on the findMode method from the CSC 116 CalculateMode assignment.
     * @param tallyArray array containing a tally of values (index = value, element = 
     * frequency of the value)
     * @return index of the first occurrence of the maximum value in an integer array
     */
    public int findHighestFrequency() {
        int[] tallyArray = tallyDice();
        int highestFrequency = 0;
        int modeIndex = 0;
        for (int i = 0; i < tallyArray.length; i++) {
            if (tallyArray[i] > highestFrequency) {
                highestFrequency = tallyArray[i];
            }
        }
        return highestFrequency;
    }
    
    /**
     * Returns the sum of all values in the dice array
     * @return sum of all dice values
     */
    public int sumAllDice() {
        int sum = 0;
        for (int i = 0; i < diceCount; i++) {
            sum += dice[i];    
        }
        return sum;
    }
}