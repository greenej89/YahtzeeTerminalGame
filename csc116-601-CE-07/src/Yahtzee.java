import java.util.*;

// TODO insert javadoc here and fix all the other javadoc...complete TODO tasks
// We need some way to display scorecard updates during the game (e.g. # of rolls). A GUI
// might help if you are up for making one.
/**
 * 
 * @author Jessica Greene
 * @author Sari Byrd
 */
public class Yahtzee {

    /**  String array of player names */
    private static  String[] playerArr;

    /** Scorecard array for each player */
    private static Scorecard[]  playerScoreCardArr;

    /**  Dice object used by all players */
    private static Dice dice;

    /** Number of sides of each die */
    public static final int SIDES = 6;

    /** Total number of die */
    public static final int NUMBER_OF_DICE = 5;

    /** Array containing Yahtzee scoring categories */
    public static final String[] CATEGORIES = {
            "ones", "twos", "threes", "fours", "fives", "sixes", 
            "three of a kind", "four of a kind", "small straight", 
            "large straight", "full house", "Yahtzee", "chance"
    };
    /**
     * Starts program
     */
    public static void main(String[] args) {
        userInterface();
        //Dice dice = new Dice();                 // This creates a set of dice for the game
    }
    
    /**
     * Prints a head with game instructions. Prompts user for the number of players and player
     * names.  Players cannot continue until they have all entered names.  Constructs a 
     * scorecard for each player. Initiates 13 rounds of game play. During each round, each
     * player takes a turn. Starts each player's turn and prompts player to score the 
     * first roll or roll again.  The player may roll any or all dice two additional times 
     * after the starting their turn with an initial roll of all dice.
     * If the player rolls again, the program prompts the player to enter the values of each die 
     * they would like to roll again.  If the player enters an invalid value (value < 1, 
     * value > number of sides on the dice, or value != any of the
     * value of any dice in the currently roll), print an error message and continuously prompt
     * until the user gives a valid value.  If the user chooses to score the roll, the 
     * program should display a menu of category choices and prompt for a category to score.  
     * If the user enters an invalid category, the program should display "Invalid Category"
     * and prompt continuously until a valid category is entered.  If the program is unable to 
     * score the roll in the category selected by the user, print a message that says "This
     * category has already been scored. Choose a different category." Continuously prompt
     * until a scoreable category is selected. After a player successfully scores a roll, 
     * move on to the next player's turn.  After 13 rounds of game play, displays the total
     * score for each player and a message declaring the winner. Prompts the user to quit
     * or play again.
     */
    public static void userInterface() {
        //TODO Print header with instructions
        System.out.println("Welcome to the Yahtzee Game! ");
        System.out.println("To play this game you have to enter the number ");
        System.out.println("of players and their names. The objective of the ");
        System.out.println("game is to score the highest number of points for ");
        System.out.println("different categories 1 to 6, 3 of a kind, 4 of a  ");
        System.out.println("kind, small straight, large straight, full house, ");
        System.out.println("and Yahtzee. Each player can roll the dice up to ");
        System.out.println("3 times, first roll all 5 dice and subsequent rolls ");
        System.out.println("the player chooses which dice to re-roll and score ");
        System.out.println("a particular category for 13 rounds. \n");
        
        String choice = "";

        do {
        //TODO Prompt for number of players
        Scanner console = new Scanner(System.in);

        System.out.print("Please enter the number of players (2-4): ");

        int playerNumber = playerNumberWithinRange(console);

        playerArr = new String[playerNumber];
        
        playerScoreCardArr = new Scorecard[playerNumber];

        dice = new Dice(SIDES, NUMBER_OF_DICE);//creating object of Dice class

        //TODO Prompt for player names and construct a Scorecard object for each player (for loop).
        for (int i = 0; i < playerNumber; i++) {
            System.out.print("Please enter the name of player " + (i + 1) + ": ");
            playerArr[i] = console.next();//name of player
            playerScoreCardArr[i] = new Scorecard(playerArr[i]);//populating
            //the scorecard with this particular player's name
        }
        
        //TODO 13 rounds of game play (for loop)
        for (int round = 1; round <= 13; round++) {
            // TODO each player should take a turn (for loop with number of players)
            // TODO when scoreRoll is not null...move on to the next player's turn...
            for (int player = 0; player < playerNumber; player++) {
                // TODO Start turn for player
                startTurn(player);

                // TODO Prompt player to score the roll or roll again for up to 
                //two additional rolls
                 
                System.out.print("Do you want to score the current roll or ");
                System.out.print("re-roll (score or roll)? ");

                String response = console.next();

                while (response.equalsIgnoreCase("roll") && 
                playerScoreCardArr[player].getNumberOfRolls() <= 3) {
                    
                    // TODO call rollAgain
                    rollAgain(player, console);

                    System.out.print("Do you want to score the current roll or ");
                    System.out.print("re-roll (score or roll)? ");

                    response = console.next();
                    
                }

                // TODO If player scores the roll
                if (response.equalsIgnoreCase("score"))  {
                    // TODO prompt for a category to score
                    boolean isValidCategory = false;
                    String categoryScored = "";
                    String category = "";
                    do {
                        System.out.print("Enter a category to score: \n" +
                                         "Categories: ");
                        for (int j = 0; j < 12; j++) {
                            System.out.print(CATEGORIES[j] + ", ");
                        }
                        System.out.println(CATEGORIES[12]);
                    
                        console.nextLine();                                             // Need to discard the first token
                        category = console.nextLine();
                        if (Arrays.toString(CATEGORIES).contains(category)) {           // I found this strategy easier...but might not be foolproof
                            isValidCategory = true;
                            // TODO If category is valid, call scoreRoll
                            categoryScored = scoreRoll(playerScoreCardArr[player], category);
                            // TODO while scoreRoll returns "null", print "This category
                            // has already been scored. Choose a different category.",
                            // reprompt until a scoreable category is selected
                            while (categoryScored == null) {                               // I think I fixed this....need to run some tests
                                System.out.print("This category has already been scored. ");
                                System.out.println("Choose a different category.");
                                category = console.nextLine();
                                categoryScored = scoreRoll(playerScoreCardArr[player], category);
                            }
                        } 
                        if (!isValidCategory) {
                            // TODO If category is invalid, print "Invalid category"
                            System.out.println("Invalid category.");
                        }  
                    } while (!isValidCategory);
                }
            }
        }
                    
        int playerWithHighestScoreIndex = 0;
        int maxScore = playerScoreCardArr[0].getTotalScore();

        //TODO Print the total score for each player
        System.out.println("Total score for each player: \n");

        for (int m = 0; m < playerNumber; m++) {
            System.out.println("Player " + playerArr[m]);
            System.out.println("Total Score " + playerScoreCardArr[m].
            getTotalScore() + "\n");

            if (playerScoreCardArr[m].getTotalScore() > maxScore) {
                playerWithHighestScoreIndex = m;//highest player stored here
                maxScore = playerScoreCardArr[m].getTotalScore();
            }
        }

        //TODO Print a message declaring the winner
        System.out.println("The winner is: " + 
        playerArr[playerWithHighestScoreIndex]);
        
        //TODO Prompt user to quit or play again
        System.out.println("Do you want to continue playing or quit (q)? ");
        choice = console.next();

        } while(!choice.equalsIgnoreCase("q"));

    }

    public static int isInteger(Scanner console) {

        while (!console.hasNextInt()) {
            console.next();
            System.out.print("Not an integer, Try Again. ");
        }

        return console.nextInt();
    }

    public static int playerNumberWithinRange(Scanner console) {

        int playerNumber = isInteger(console);

        while(playerNumber < 2 || playerNumber > 4) {
            System.out.print("Player Number Invalid, Try Again. ");

            playerNumber = isInteger(console);
        }

        return playerNumber;//player number within range
    }
    
    /**
     * Starts a player's turn by displaying the player's scorecard and completing the first
     * roll of the turn. All dice are rolled during the first roll. Increments the roll counter
     * and displays a String representation of the dice roll.
     */
    public static void startTurn(int player) {

        // TODO display player scorecard on the console using the Scorecard toString
        // method
        System.out.println(playerScoreCardArr[player]);//calls toString method
        //of the player in the playerScoreCardArr

        // TODO Roll all dice using Dice object methods
        dice.rollAllDice();

        // TODO increment the roll counter in the scorecard
        playerScoreCardArr[player].setNumberOfRolls(playerScoreCardArr[player].
        getNumberOfRolls() + 1);//increment current number of rolls by 1

        System.out.println(playerArr[player] + " current dice roll \n");


        // TODO Print a String representation of the dice roll
        System.out.println(dice);//when print object java knows to call
        //toString() method

    }
    
    /**
     * Re-rolls the dice selected by the user. Increments the roll counter and displays a String
     * representation of the dice roll.
     */
    public static void rollAgain(int player, Scanner console) {
        //TODO roll the dice selected by the user (use a scanner to read in the
        // integer values and pass them as parameters to rollOneDie method)
        // TODO If player rolls again, prompt for which dice to roll again,
        
        int valueToReroll = 0;
        System.out.print("Enter value(s) of dice to re-roll: ");                  // The intent here was for them to enter all the dice they want to re-roll
        console.nextLine();                                // read in all values as a string
        String diceValues = console.nextLine();
        Scanner valueScanner = new Scanner(diceValues);    //scan in the values one by one
        while (valueScanner.hasNextInt()) {
            valueToReroll = valueScanner.nextInt();
            // TODO If user enters number <1 or >number of sides on the dice
            while (valueToReroll < 1 || valueToReroll > SIDES) {
                System.out.println(valueToReroll + "is an invalid die value.");

                // print "Enter the values of the dice you would like to re-roll.",
                System.out.println("Enter a valid dice value between 1 - 6: ");

                // reprompt until a valid number is entered
                valueToReroll = valueScanner.nextInt();                                 // I tried to fix this, but I think it is wrong
            }
            dice.rollOneDie(valueToReroll);
            
        }

            

        //TODO increment the roll counter in the scorecard
        playerScoreCardArr[player].setNumberOfRolls(playerScoreCardArr[player].
        getNumberOfRolls() + 1);

        //TODO Print a String representation of the dice roll
        System.out.println(playerArr[player] + " current dice roll \n");

        System.out.println(dice);

    }
    
    /**
     * Attempts to score a roll in a given category on a given player's scorecard, and returns
     * a String representing the outcome of the score attempt.  Returns null if the score 
     * category has already been scored.
     */
    public static String scoreRoll(Scorecard player, String category) {
        // Attempt to score the category using the Scorecard methods
        String categoryScored = player.setScore(category, dice);
        // Return the result of the score attempt 
        return categoryScored;
    }
}