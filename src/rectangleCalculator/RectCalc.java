/**
 * Author: Caasi Boakye
 * Date:   Sep 15, 2022
 * Description: 
 * Learn to write static methods for a rectangle
 * We will calculate the area, perimeter, length of diagonal
 * We will write a single method that summarizes that information
 */

package rectangleCalculator;
import java.util.Scanner;
/**
* @author studentgvsc
 *
 */

public class RectCalc {
	/*
	 * When writing a method, the must have:
	 * 
	 * 1) Scope level (generally public)
	 * 2) Static (if class is calling the method)
	 * 3) Return type (int, double, String, boolean) and void (returns nothing)
	 * 4) Name (be descriptive) if the method returns a value it should start with 'get'
	 * 5) If the method contains parameters, calls to the method must use the same type(s) of
	 * parameters in the same order
	 * 
	 * The type of the parameter must be declared in the method header's parameter list
	 */
	public static int getArea(int length, int width) { //method header: public is the scope, static means that class calls method, int means it returns an integer
		return length * width; //all methods with return types must have a return statement
		//Nothing executes after return
	}
	
	public static int getPerimeter(int length, int width) {
		return (2 * length) + (2 * width);
	}
	
	public static double getDiagonalLength(int length, int width) {
		return Math.sqrt(length * length + width * width);
	}
	
	//This method allows access to the other RectCalc methods
	//and prints a nice summary of a rectangle
	
	//void methods are "do this" methods
	//void methods cannot be stored in variables or used in print statements
	
	public static void getSummary(int length, int width) {
		System.out.printf("The dimensions of the rectangle are %d x %d.\n", length, width);
		System.out.printf("The area of the rectangle is %d.\n", getArea(length, width));
		System.out.printf("The perimeter of the rectangle is %d.\n", getPerimeter(length,width));
		System.out.printf("The diagonal length of the rectangle is %.1f.\n", getDiagonalLength(length, width));
	}
	
	public static void main(String[] args) {
		//In the class of the static method, you can just call the method name
		RectCalc.getSummary(4,5);
	}

}
