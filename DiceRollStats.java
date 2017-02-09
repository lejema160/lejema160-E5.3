/**
 * 
 */
package StatAndRollUtils;

import CalcUtils.StatCalc;
import DiceUtils.PairOfDice;

/**
 * @author lejema160
 *
 */
public class DiceRollStats {
	
	/**
	 * dice is the unique pair of dice that will be used for all roll
	 */
	private static PairOfDice dice = new PairOfDice();
	
	/**
	 * Main method counting how many times a pair of dice is rolled before a given total comes up.
	 * It repeats this experiment 10000 times and then reports the average number of rolls.
	 * Report the average number of rolls and report the standard deviation and the maximum number of rolls
	 */
	public static void main(String[] args) {
	       System.out.println("Dice Total | Avg # of Rolls | Stand. Deviation | Max # of Rolls");
	       System.out.println("__________ | ______________ | ________________ | ______________");
	       for (int sum = 2;  sum <= 12;  sum++) {
	          StatCalc stat; 
	          stat = new StatCalc();
	          for (int i = 0; i < 10000; i++) {
	             stat.enter(numberOfRoll(sum));
	          }
	          System.out.printf("%6d", sum);
	          System.out.printf("%18.3f", stat.getMean());
	          System.out.printf("%19.3f", stat.getStandardDeviation());
	          System.out.printf("%14.3f", stat.getMax());
	          System.out.println();
	       }
	       
	   }
	   
	   /**
	    * Return the number of roll needed to reach a number (sum of the pair of dice)
	    * @param sum : the sum wanted for the pair of dice 
	    * @return counter : the number of rolls needed to reach the sum
	    */
	   static int numberOfRoll( int sum ) {
	       int counter = 0;
	       while (dice.getSum() != sum){
	          dice.roll();
	          counter++;
	       } 
	       return counter;
	   }

}
