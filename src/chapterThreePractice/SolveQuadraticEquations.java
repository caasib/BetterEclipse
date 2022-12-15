/**
 * Author: Caasi Boakye
 * Date:   Sep 26, 2022
 * Description: 
 */
package chapterThreePractice;
import java.util.Scanner;

/**
 * @author studentgvsc
 *
 */
public class SolveQuadraticEquations {
	
	static Scanner scan = new Scanner(System.in);
	static int a, b, c;
	
	public static void getNumbers() {
		System.out.println("Enter integers a, b, c: ");
		a = scan.nextInt();
		b = scan.nextInt();
		c = scan.nextInt();
	}
	
	public static void solveQuadratic(int a, int b, int c) {
		double discriminant = Math.pow(b, 2) - (4 * a * c);
		double rootOne, rootTwo;
		if (discriminant > 0) {
			rootOne = ((-b) + Math.sqrt(discriminant)) / (2 * a);
			rootTwo = ((-b) - Math.sqrt(discriminant)) / (2 * a);
			System.out.println("The equation has two roots: " + rootOne + " and " + rootTwo);
		}
		else if (discriminant == 0) {
			rootOne = ((-b) + Math.sqrt(discriminant)) / (2 * a);
			System.out.println("The equation has one root: " + rootOne);
		}
		else if (discriminant < 0) {
			System.out.println("The equation has no real roots");
		}
		
			
	}
	
	public static void run() {
		getNumbers();
		solveQuadratic(a, b, c);
	}

	public static void main(String[] args) {
		run();
	}

}
