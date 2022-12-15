/**
 * Author: Caasi Boakye
 * Date:   Oct 18, 2022
 * Description: This class covers how to write and traverse arrays using for-loops and enhanced for-loops
 * We will also make arrays of objects
 */
package arrays;
import java.util.Scanner;

/**
 * @author studentgvsc
 *
 */
public class ArrayLesson {
	
	/*
	 * An array is a data structure that holds "values" of the same data type
	 * An array is fixed in size when it is declared
	 * Elements of an array are accessed by using arrayName[index] --> index is from 0 to length - 1
	 * arrayName.length is the number of elements contained in an array
	 * If not initialized, all primitive types will default to their version of "0"
	 * For arrays of objects, the default value is "null"
	 * For non-string objects, attempts to use methods on null objects will give a NullPointerException
	 */
	
	//dataType[] arrayName = new dataType[arraySize];
	//dataType[] arrayName = {elements that match dataType, separated by commas} --> for a small # of elements

	public static void main(String[] args) {
		int[] numbers = new int[5]; //Creates an array of 50 integers, currently each element is 0
		//numbers[0] = 7; //changes the first element to 7
		//numbers[49] = 25; //changes the last element to 25
		
		/*
		 * There are two ways to iterate over an array:
		 * 1. Traditional for loop --> can access and change the values in the array
		 * 2. Enhanced for loop --> can only access the values of the array (read-only)
		 */
		
		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = (i + 1);
			System.out.print(numbers[i] + " ");
		}
		
		System.out.println("");
		
		//for(dataType single : collection) --> loop body
		
		for (int number : numbers) { //Does not actually change the array
			number = number * number + number;
			System.out.print(number + " ");
		}
		
		System.out.println("");
		
		for (int i = 0; i < numbers.length; i++) {
			System.out.print(numbers[i] + " ");
		}
		
		System.out.println("");
		
		/*
		 * Parallel arrays keep track of data that has at least two characteristics
		 */
		
		String[] letters = new String[26];
		String alphabet = "abcdefghijklmnopqrstuvwxyz";
		
		int[] letterValues = new int[26];
		
		for (int i = 0; i < letters.length; i++) {
			letters[i] = alphabet.substring(i, i+1);
			letterValues[i] = i + 1;
		}
		
		for (int i = 0; i < letters.length; i++) {
			System.out.printf("%s: %d\n", letters[i], letterValues[i]);
		}

	}

}
