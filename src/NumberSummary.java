/**
 * Author: Caasi Boakye
 * Date:   Aug 30, 2022
 * Description: 
 */
import java.util.Scanner;
import java.util.Random;
/**
 * @author studentgvsc
 *
 */
public class NumberSummary {

	public static void main(String[] args) {
		/* 0. Planning Phase - What do you need to accomplish?
		 * We need variables for the three values - the mean, median,
		 * sum, maxValue, and minValue
		 * 
		 * We'll need to write an algorithm that calculates the mean,
		 * an algorithm that calculates the median
		 */
		// 1. Input Phase
		
		int number1, number2, number3, sum, median, maxValue, minValue;
		double mean;
		
		//To create a random number generator, we need a Random object
		
		Random random = new Random(); //Creates a Random object named 'random'
		
		//Generate three random integers between 0 and 50
		//random.nextInt(n) generates a random value between 0 and n - 1
		
		number1 = random.nextInt(51);
		number2 = random.nextInt(51);
		number3 = random.nextInt(51);
		
		//Use print statements to frequently check your code to see if it is performing
		//as expected
		
		//System.out.println(number1 + " " + number2 + " " + number3);
		
		//2. Process Phase
		//Process numbers to get the mean, median, max value, and minimum value
		
		sum = number1 + number2 + number3;
		mean = sum / 3.0; //To get a true decimal, one part of the operation must be a double
		
//		System.out.println(number1 + " " + number2 + " " + number3 + " " + mean);
		
		maxValue = Math.max(Math.max(number1, number2), number3);
		minValue = Math.min(Math.min(number1, number2), number3);
		
		median = sum - maxValue - minValue;
		
		System.out.println("Number Summary");
		System.out.println("--------------");
		System.out.println("The numbers in order are " + minValue + ", " + median + ", " + maxValue + ".");
		System.out.println("Mean:    " + mean);
		System.out.println("Median:  " + median);
		System.out.println("Maximum: " + maxValue);
		System.out.println("Minimum: " + minValue);
		
		
	}

}
