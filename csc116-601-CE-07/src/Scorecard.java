import java.util.*;

/**
 * Encapsulates Yahtzee scorecard information
 * @author Jessica Greene
 * @author Sari Byrd
 */
public class Scorecard {
	// Class constants should always be public
    /** Number of dice in game */
	public static final int DICE_COUNT = 5;
	/** Number of points to add for each die with a 1 face value when scoring Ones */
	public static final int ONE = 1;
	/** Number of points to add for each die with a 2 face value when scoring Twos */
	public static final int TWO = 2;
	/** Number of points to add for each die with a 3 face value when scoring Threes */
	public static final int THREE = 3;
	/** Number of points to add for each die with a 4 face value when scoring Fours */
	public static final int FOUR = 4;
	/** Number of points to add for each die with a 5 on the face when scoring Fives */
	public static final int FIVE = 5;
	/** Number of points to add for each die with a 6 on the face when scoring Sixes */
    public static final int SIX = 6;
    /** Number of points to add for each die with a 6 on the face when scoring Sixes */
    public static final int FULL_HOUSE = 25;
    /** Number of points scored for a small straight */
    public static final int SMALL_STRAIGHT = 30;
    /** Number of points scored for a large straight */
    public static final int LARGE_STRAIGHT = 40;
    /** Number of points scored for a Yahtzee */
    public static final int YAHZTEE = 50;
    
    //Instance Variables
	/** Name of Player */
	private String name;
	/** Number of times a player has rolled in each turn */
	private int rolls;
	
	//Instance Variables: Scores
	
	/** Total score */
	private int totalScore;
	/** Upper score */
	private int upperScore;
	/** Lower score */
	private int lowerScore; 
	/** Upper score bonus */
	private int upperBonus;
	
	// Instance Variables:  Categories
	/** Ones category score */
	private int ones;
	/** Twos category score */
	private int twos;
	/** Threes category score */
	private int threes;
	/** Fours category score */
	private int fours;
	/** Fives category score */
	private int fives;
	/** Sixes category score */
	private int sixes;
	/** Three of a kind category score */
	private int threeOfAKind;
	/** Four of a kind category score */
	private int fourOfAKind;
	/** Small straight category score */
	private int smallStraight;
	/** Large straight category score */
	private int largeStraight;
	/** Full house category score */
	private int fullHouse;
	/** Yahtzee category score */
	private int yahtzee;
	/** Chance category score */
	private int chance;
	
	/** 
	 * Constructs an object representation of a scorecard for a player 
	 */
    public Scorecard(String playerName) {     
                                //TODO NEGATIVE VALUES INDICATED UNASSIGNED SCORES.  These are not included in the score totals.
		name = playerName;
		rolls = 0;
		upperScore = 0;
        lowerScore = 0;
        totalScore = 0;
		upperBonus = -1;
		ones = -1;
		twos = -1;
		threes = -1;
		fours = -1;
		fives = -1;
		sixes = -1;
		threeOfAKind = -1;
		fourOfAKind = -1;
		smallStraight = -1;
		largeStraight = -1;
		fullHouse = -1;
		yahtzee = -1;
		chance = -1;
	}
	
	
	/**
	 * Returns a string representation of the name of the player who owns the scorecard
	 * @return name of the player
	 */
	public String getName() {
		return name;
	} 
	
	/** 
	 * Calculates and returns the player's total score
	 * @return player's total score
	 */
	public int getTotalScore() {
		return totalScore;
	} 
	
	/** 
	 * Calculates and returns the player's upper score 
	 * @return player's upper category score
	 */
	public int getUpperScore() {   
	   return upperScore;
	}
	
	/** 
	 * Calculates and returns the player's lower score 
	 */
	public int getLowerScore() {
		return lowerScore;
	} 
	
	/** 
	 * Calculates and returns the upper score bonus.  At the end of the game, if the upper 
	 * score is greater than or equal to 63, the upper score bonus is 35 points.  
	 * If the upper score is less than 63, the upper score bonus is 0 points. 
	 * @return the upper bonus score 
	 */
	public int getUpperScoreBonus() {                     //TODO client code must calculate upperBonus at the end of the game (IF VALUE IS NEGATIVE, DO NOT ADD TO SCORE)
        upperBonus = 0;
        if (upperScore >= 63) {
            upperBonus = 35;
        }
        upperScore += upperBonus;
        totalScore = upperScore + lowerScore;
		return upperBonus; 		
	 }
	 
	/**
	 * Returns the number of times a player has rolled the dice during the player's turn
	 * @return number of times the player has rolled the dice during the player's turn
	 */
    public int getNumberOfRolls() {
        return rolls;
    }
	
    /**
     * Sets the number of rolls in the rolls private field.
     * 
     * @param numberOfRolls passes into the method the number of player's rolls
     */
    public void setNumberOfRolls(int numberOfRolls) {
        rolls = numberOfRolls;
    }	
	
	/**
	 * Scores a category specified as a parameter
	 * @param category String representation of the category to be scored
	 * @param dice Dice object
	 * @return String stating which category was scored
	 */
    public String setScore(String category, Dice dice) {      //TODO client code must return an error if the user does not specify an appropriate category
        int[] tallyArray = dice.tallyDice();
        String tallyString = Arrays.toString(tallyArray);
        String diceString = dice.toString();
        
        //Score ones category
        if (category.equalsIgnoreCase("ones") && ones == -1) {                 //TODO client code will specify the category
            ones = (ONE * tallyArray[1]);                   
            upperScore += ones;                             
            totalScore = upperScore + lowerScore;
            return "Scored 'Ones' category";
        }
        
        //Score twos category
        if (category.equalsIgnoreCase("twos") && twos == -1) {                             
                twos = (TWO * tallyArray[2]);                  
                upperScore += twos;    
                totalScore = upperScore + lowerScore;
                return "Scored 'Twos' category";
        }

        //Score threes category
        if (category.equalsIgnoreCase("threes") && threes == -1) {                             
                threes = (THREE * tallyArray[3]);                  
                upperScore += threes; 
                totalScore = upperScore + lowerScore;                          
                return "Scored 'Threes' category";
        }

        //Score fours category
        if (category.equalsIgnoreCase("fours") && fours == -1) {                             
                fours = (FOUR * tallyArray[4]);                 
                upperScore += fours;  
                totalScore = upperScore + lowerScore;                          
                return "Scored 'Fours' category";
        }

        //Score fives category
        if (category.equalsIgnoreCase("fives") && fives == -1) {                            
                fives = (FIVE * tallyArray[5]);             
                upperScore += fives;   
                totalScore = upperScore + lowerScore;                         
                return "Scored 'Fives' category";
        }

        //Score sixes category
        if (category.equalsIgnoreCase("sixes") && sixes == -1) {                              
                sixes = (SIX * tallyArray[6]);                 
                upperScore += sixes; 
                totalScore = upperScore + lowerScore;                          
                return "Scored 'Sixes' category";
        }
        
        //Score three of a kind category
        if (category.equalsIgnoreCase("three of a kind") && threeOfAKind == -1) {
            threeOfAKind = 0;
            if (dice.findHighestFrequency() >= 3) {
                threeOfAKind = dice.sumAllDice();
            }
            lowerScore += threeOfAKind;
            totalScore = upperScore + lowerScore;                 // We have to total the scores before we return to the client program
            return "Scored 'three of a kind' category";
        }
        
        //Score four of a kind category
        if (category.equalsIgnoreCase("four of a kind") && fourOfAKind == -1) {
            fourOfAKind = 0;
            if (dice.findHighestFrequency() >= 4) {
                fourOfAKind = dice.sumAllDice();
            }
            lowerScore += fourOfAKind;
            totalScore = upperScore + lowerScore; 
            return "Scored 'four of a kind' category";
        }
        
        //Score small straight category
        if (category.equalsIgnoreCase("small straight") && smallStraight == -1) {
            smallStraight = 0;
            //4 dice with consecutive values (1, 2, 3, 4 || 2, 3, 4, 5 || 3, 4, 5, 6)
            if ((diceString.contains("3") && diceString.contains("4")) &&
                    ((diceString.contains("1") && diceString.contains("2")) ||
                     (diceString.contains("2") && diceString.contains("5")) ||
                     (diceString.contains("5") && diceString.contains("6")))) {
                    smallStraight = SMALL_STRAIGHT;
            }
            lowerScore += smallStraight;
            totalScore = upperScore + lowerScore;
            return "Scored 'small straight' category";
        }
        
        //Score large straight category
        if (category.equalsIgnoreCase("large straight") && largeStraight == -1) {
            largeStraight = 0;
        //5 consecutive values (1, 2, 3, 4, 5 || 2, 3, 4, 5, 6)
            if ((diceString.contains("2") && diceString.contains("3") && 
                (diceString.contains("4") && diceString.contains("5")) && 
                (diceString.contains("1") || diceString.contains("6")))) {
                largeStraight = LARGE_STRAIGHT;
            }
            lowerScore += largeStraight; 
            totalScore = upperScore + lowerScore;      
            return "Scored 'large straight' category";
        }

        //Score full house category
        if (category.equalsIgnoreCase("full house") && fullHouse == -1) {
            fullHouse = 0;
            //full house: 3 dice faces are same and 2 others the same
            for (int i = 1; i < tallyArray.length; i++) {
                if (tallyArray[i] == 3) {                               // 3 of a kind
                    for (int j = 1; j < tallyArray.length; j++) {    
                        if (tallyArray[j] == 2) {                       // pair
                            fullHouse = FULL_HOUSE;
                        }
                    }
                } else if (tallyArray[i] == 5) {                        //TODO A Yahtzee can be played as Full House....test this
                    fullHouse = FULL_HOUSE;
                }
            } 
            lowerScore += fullHouse;
            totalScore = upperScore + lowerScore;
            return "Scored 'full house' category";
        }  
        
        //TODO Check if this correctly scores Yahtzee category
        if (category.equalsIgnoreCase("Yahtzee") && yahtzee == -1) {                     //TODO finish testing Yahtzee category
            yahtzee = 0;
            if ((tallyArray[1] == 5) ||     //all 5 dice are 1 
                (tallyArray[2] == 5) ||     //all 5 dice are 2 
                (tallyArray[3] == 5) ||     //all 5 dice are 3
                (tallyArray[4] == 5) ||     //all 5 dice are 4
                (tallyArray[5] == 5) ||     //all 5 dice are 5
                (tallyArray[6] == 5)) {     //all 5 dice are 6
                yahtzee = YAHZTEE;
                lowerScore += yahtzee;
            }
            lowerScore += yahtzee;
            totalScore = upperScore + lowerScore;
            return "Scored 'Yahtzee' category";
        }
        
        //Score Chance category
        if (category.equalsIgnoreCase("chance") && chance == -1) {
            chance = dice.sumAllDice();
            lowerScore += chance;
            totalScore = upperScore + lowerScore;
            return "Scored 'Chance' category";
        } 
        
        return null;                                            // TODO If returned value is null, client code must reprompt user for a category
    }
    
    public String toString() {                                  //TODO Use printf to print scorecard as a table  
        String scorecardString = "";
        scorecardString += "Player: \t\t\t\t" + name + "\n";
        scorecardString += "Roll Number: \t\t\t\t" + rolls + "\n";
        scorecardString += "Total Score: \t\t\t\t" + totalScore + "\n";
        scorecardString += "\n";
        scorecardString += "______________________\n";
        scorecardString += "Category \t\t\t\tScore \n";
        scorecardString += "1 \t\t\t\t\t\t\t\t";
        if (ones != -1) {
            scorecardString += ones + "\n";
        } else {
            scorecardString += "\n";
        }
        scorecardString += "2 \t\t\t\t\t\t\t\t";
        if (twos != -1) {
            scorecardString += twos + "\n";
        } else {
            scorecardString += "\n";
        }
        scorecardString += "3 \t\t\t\t\t\t\t\t";
        if (threes != -1) {
            scorecardString += threes + "\n";
        } else {
            scorecardString += "\n";
        }
        scorecardString += "4 \t\t\t\t\t\t\t\t";
        if (fours != -1) {
            scorecardString += fours + "\n";
        } else {
            scorecardString += "\n";
        }
        scorecardString += "5 \t\t\t\t\t\t\t\t";
        if (fives != -1) {
            scorecardString += fives + "\n";
        } else {
            scorecardString += "\n";
        }
        scorecardString += "6 \t\t\t\t\t\t\t\t";
        if (sixes != -1) {
            scorecardString += sixes + "\n";
        } else {
            scorecardString += "\n";
        }
                                                            //TODO Add logic for lower categories and upper bonus... IF VALUE IS NEGATIVE, DO NOT PRINT IT
        scorecardString += "Upper Bonus \t\t\t\t" + upperBonus + "\n";
        scorecardString += "_______________________\n";
        scorecardString += "Upper Score: \t\t\t\t" + upperScore + "\n";
        scorecardString += "_______________________\n";
        scorecardString += "\n";
        scorecardString += "Category \t\t\t\tScore \n";
        scorecardString += "3 of a kind \t\t\t\t" + threeOfAKind + "\n";
        scorecardString += "4 of a kind \t\t\t\t" + fourOfAKind + "\n";
        scorecardString += "Small Straight \t\t\t\t" + smallStraight + "\n";
        scorecardString += "Large Straight \t\t\t\t" + largeStraight + "\n";
        scorecardString += "Full House \t\t\t\t" + fullHouse + "\n";
        scorecardString += "Yahtzee \t\t\t\t" + yahtzee + "\n";
        scorecardString += "Chance \t\t\t\t" + chance + "\n";
        scorecardString += "\n";
        scorecardString += "_______________________\n";
        scorecardString += "Lower Score: \t\t\t\t" + lowerScore + "\n";
        scorecardString += "\n";
        scorecardString += "_______________________\n";



        /*
        Player: 
        Roll Number:        1
        Total Score:	  149
        ______________________
        Category		Score
        1		          
        2		
        3		            0
        4		            0
        5		           10
        6		           24
        Upper Bonus		    0
        _______________________
        Upper Score:       34
        _______________________

        Category		Score
        3 of a kind		    0
        4 of a kind		   19
        Small Straight		
        Large Straight		
        Full House		   25
        Yahtzee		       50
        Chance		       21
        ________________________
        Lower Score:      115
        ________________________
        */
        return scorecardString;
    }
}