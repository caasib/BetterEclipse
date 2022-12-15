/**
 * Author: Caasi Boakye
 * Date:   Sep 6, 2022
 * Description: 
 */
import java.util.Scanner;

/**
 * @author studentgvsc
 *
 */

// In Java, Strings are objects. Objects are referenced when they are used in methods.
// This means the value of the object is never changed unless it is given a new value
//somewhere in your program.

public class StringLesson {

	public static void main(String[] args) {
		String myName = "Caasi";
		
		// (1) The .indexOf(target) returns the first index of the occurrence of 'target'
		// -1 is returned if the target is NOT located in the string
		// data structures are zero indexed (the first counting value is zero not 1)
		
		System.out.println("The index of C is: " + myName.indexOf("C"));
		
		//.indexOf(target, startHere) --> returns the index of target beginning the search at startHere
		
		System.out.println("The index of a is: " + myName.indexOf("a", myName.indexOf("a") + 1));
		
		// (2) .charAt(index) --> return the character at the location 'index'
		
		System.out.println("The 4th character is: " + myName.charAt(3));
		System.out.println("" + myName.charAt(0) + 11);
		
		// You will get an OutOfBounds exception if you attempt to access an invalid index
		
		// (3) .length() --> returns the length of the string (including whitespace and punctuation)
		// The final index of a string is always .length() - 1
		
		System.out.println("There are " + myName.length() + " letters in my name.");
		
		// (4) .toLowerCase() and .toUpperCase() --> returns a string that is all lowercase/uppercase
		
		System.out.println("Lowercase: " + myName.toLowerCase());
		System.out.println(myName);
		System.out.println("Uppercase: " + myName.toUpperCase());
		System.out.println(myName);
		
		// (5) .substring(start) --> returns the string from 'start' to end of the string
		
		System.out.println("A substring from the 3rd index is: " + myName.substring(3));
		
		// .substring(start, end) --> returns the string from 'start' to end - 1
		
		System.out.println("A substring from the 2nd index to the 4th is: " + myName.substring(2,4));
		
		String repeater = myName.repeat(6);
		System.out.println(repeater);
	}

}
