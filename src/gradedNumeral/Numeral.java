/**
 * Author: Caasi Boakye
 * Date:   Oct 4, 2022
 * Description: 
 */
package gradedNumeral;
import java.util.Scanner;

/**
 * @author studentgvsc
 *
 */
public class Numeral {
	
	public static void showDivisors(int integer) {
		System.out.print("1");
		for (int i = 1; i < Math.abs(integer); i++) {
			if ((Math.abs(integer) % i == 0) && (i != 1)) {
				System.out.print(", " + i);
			}
		}
		System.out.println("");
	}
	
	public static void isPrime(int integer) {
		int posInteger = Math.abs(integer);
		boolean prime = true;
		
		if ((posInteger == 1) || (posInteger == 0)) {
			prime = false;
		}
		
		for (int i = 2; i < posInteger; i++) {
			if ((posInteger % i == 0) && (i != posInteger)) {
				prime = false;
				break;
			}
		}
		
		if (prime) {
			System.out.println(integer + " is a prime number");
		}
		
		else {
			System.out.println(integer + " is not a prime number");
		}
	}
	
	public static void factorial(int integer) {
		if ((integer == 1) || (integer == 0)) {
			System.out.print(integer + "! = 1.");
			return;
		}
		
		if (integer < 0) {
			System.out.print(integer + "! = -1.");
			return;
		}
		
		int product = integer;
		System.out.print(integer + "! = " + integer + " x ");
		
		for (int i = integer - 1; i > 0; --i) {
			if (i == 1) {
				System.out.print(i + " = " + product + ".");
				break;
			}
			product *= i;
			System.out.print(i + " x ");
		}
		
	}
	
	public static void contains(int integerToSearch, int integer) {
		String strIntSearch = "" + integerToSearch;
		char charInt = ("" + integer).charAt(0);
		boolean found = false;
		for (int i = strIntSearch.length() - 1; i > -1; --i) {
			if (strIntSearch.charAt(i) == charInt) {
				System.out.println((int)Math.pow(10, (strIntSearch.length() - 1) - i));
				found = true;
			}
		}
		if (!found) {
			System.out.println(integerToSearch + " does not contain " + integer);
		}
	}

}
