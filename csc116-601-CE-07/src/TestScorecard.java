/**
 * Interacts with the Scorecard and Dice classes to test the Scorecard class
 * Rolls a set of dice one time and creates a scorecard for "Player 1"
 * Prints the dice as a String
 * Prints scorecard before and after a roll.  
 * Shows how each category would be scored (by the Scorecard class) for the displayed roll
 * Also displays upper, lower, and total scores
 * @author Jessica Greene
 */
public class TestScorecard {
    public static void main (String[] args) {
        //Get some dice
        Dice dice = new Dice(6, 5);
    
        //Construct a scorecard for Player 1
        Scorecard player1 = new Scorecard("Player 1");
        
        //Print blank scorecard for Player 1
        System.out.println(player1);
        
        //Test upper category scoring methods
        dice.rollAllDice();
        player1.setNumberOfRolls(1);
        System.out.println(dice);
        player1.setScore("ones", dice);
        player1.setScore("twos", dice);
        player1.setScore("threes", dice);
        player1.setScore("fours", dice);
        player1.setScore("fives", dice);
        player1.setScore("sixes", dice);
        player1.setScore("three of a kind", dice);
        player1.setScore("four of a kind", dice);
        player1.setScore("small straight", dice);
        player1.setScore("large straight", dice);
        player1.setScore("full house", dice);
        player1.setScore("yahtzee", dice);
        player1.setScore("chance", dice);
        System.out.println(player1);
    }
}