import java.util.Arrays;
/**
 * Tests the Dice class.  Creates a Dice object representation. Prints a string representation
 * of the Dice object. Prints the number of dice in the set, the number of sides per die, 
 * the result of rolling all of the dice, the results of re-rolling the first die with each
 * value, the tally of values resulting from the rolls, the most frequently occurring value, 
 * and the sum of all of the dice.
 * @author Jessica Greene
 */
public class TestDice {
    public static void main (String[] args) {
        //Create a dice object named yahtzeeDice
        Dice yahtzeeDice = new Dice(6, 5);
        
        //Print out the dice in string representation format
        System.out.println("The initial dice are " + yahtzeeDice);
        
        //Print dice count
        System.out.println("There are " + yahtzeeDice.getDiceCount() + " dice in your set.");
        
        //Print sides per die
        System.out.println("There are " + yahtzeeDice.getSidesPerDie() + " sides on each die.");
        
        //Roll all the dice
        yahtzeeDice.rollAllDice();
        System.out.println("Roll all dice results: " + yahtzeeDice);
        
        //Re-roll die with value "1"
        yahtzeeDice.rollOneDie(1);
        System.out.println("Re-roll the first '1': " + yahtzeeDice);
        
        //Re-roll die with value "2"
        yahtzeeDice.rollOneDie(2);
        System.out.println("Re-roll the first '2': " + yahtzeeDice);
        
        //Re-roll die with value "3"
        yahtzeeDice.rollOneDie(3);
        System.out.println("Re-roll the first '3': " + yahtzeeDice);
        
        //Re-roll die with value "4"
        yahtzeeDice.rollOneDie(4);
        System.out.println("Re-roll the first '4': " + yahtzeeDice);
        
        //Re-roll die with value "5"
        yahtzeeDice.rollOneDie(5);
        System.out.println("Re-roll the first '5': " + yahtzeeDice);
        
        //Re-roll die with value "6"
        yahtzeeDice.rollOneDie(6);
        System.out.println("Re-roll the first '6': " + yahtzeeDice); 
        
        //Print dice tally
        System.out.println("Tally for each value is given below. The [0] tally should always be 0.");
        System.out.println("[0][1][2][3][4][5][6]");
        System.out.println(Arrays.toString(yahtzeeDice.tallyDice()));
        
        //Print highest frequency 
        System.out.println("The highest frequency of any value is " + yahtzeeDice.findHighestFrequency());
        
        //Print sum of dice
        System.out.println("The sum of all of the dice is " + yahtzeeDice.sumAllDice());
    }
}