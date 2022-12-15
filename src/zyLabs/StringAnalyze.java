/**
 * Author: Caasi Boakye
 * Date:   Oct 4, 2022
 * Description: 
 */
package zyLabs;
import java.util.Scanner;

/**
 * @author studentgvsc
 *
 */
public class StringAnalyze {
	
	//This method takes two strings and returns all of the common letters between the two strings
	public static String commonLetters(String stringOne, String stringTwo) {
		String allLetters = "";
		stringOne = stringOne.toLowerCase();
		stringTwo = stringTwo.toLowerCase();
		for (int i = 0; i < stringOne.length(); ++i) {
			for (int j = 0; j < stringTwo.length(); ++j) {
				if (stringOne.charAt(i) == stringTwo.charAt(j)) {
					allLetters += stringOne.charAt(i);
				}
			}
		}
		for (int k = 0; k < allLetters.length() - 1; ++k) {
			if (allLetters.charAt(k) == allLetters.charAt(k+1)) {
				allLetters = allLetters.substring((allLetters.length() - 1) - k);
			}
		}
		if (allLetters == "") {
			allLetters = "<none>";
		}
		return allLetters;
	}
	
	//This method takes a string and an integer and swaps the string so that the substring that begins at the
	//index [integer] moves to the front and the rest of the string moves to the back
	public static String swapHere(String string, int index) {
		String swappedString = "";
		String firstPart = "";
		String secondPart = "";
		if ((index <= 0) || (string.length() < index)) {
			swappedString = string;
		}
		else {
			firstPart = string.substring(index-1);
			secondPart = string.substring(0, index-1);
			swappedString = firstPart + secondPart;
		}
		return swappedString;
	}
	
	//This method takes a string and adds up all of the characters in the string
	public static int letterSum(String string) {
		int finalSum = 0;
		string = string.toLowerCase();
		for (int i = 0; i < string.length(); ++i) {
			if (Character.isLetter(string.charAt(i))) {
				finalSum += (string.charAt(i) - 96);
			}
		}
		return finalSum;
	}
	
	//This method takes a string and checks to make sure it passes the criteria for being a valid password
	public static Boolean isValidPassword(String string) {
		int numInts = 0;
		int numCapitals = 0;
		int numLower = 0;
		boolean hasNonAlpha = false;
		boolean valid = false;
		if (string.length() - 1 >= 8) {
			for (int i = 0; i < string.length(); ++i) {
				if (((int)string.charAt(i) <= 90) && ((int)string.charAt(i) >= 65)) {
					numCapitals += 1;
				}
				else if (((int)string.charAt(i) <= 122) && ((int)string.charAt(i) >= 97)) {
					numLower += 1;
				}
				else if (((int)string.charAt(i) <= 57) && ((int)string.charAt(i) >= 48)) {
					numInts += 1;
				}
				else {
					hasNonAlpha = true;
				}
			}
			if ((numInts >= 2) && (numCapitals >= 2) && (numLower >= 2) && (hasNonAlpha == false)) {
				valid = true;
			}
		}
		return valid;
	}
	
	public static void main(String[] args) {
		System.out.println(commonLetters("apple","popcorn"));
	}

}
