/**
 * Author: Caasi Boakye
 * Date:   Sep 20, 2022
 * Description: 
 */
package lotteryThing;
import java.util.Scanner;
import java.util.Random;

/**
 * @author studentgvsc
 *
 */
public class Lottery {
	
	static Scanner scan = new Scanner(System.in);
	static Random rand = new Random();
	
	public static void getUserNumber() {
		int randNum = rand.nextInt(9000) + 1000;
		String winningNum = String.valueOf(randNum);
		System.out.println("What is your 4 digit number? ");
		String userNum = scan.next();
		checkLottery(userNum, winningNum);
	}
	
	public static void checkLottery(String userNum, String winningNum) {
		if (winningNum.equals(userNum)) {
			System.out.println("You win $100,000!");
		}
		else if ((userNum.indexOf(winningNum.charAt(0)) != -1) && (userNum.indexOf(winningNum.charAt(1)) != -1) && (userNum.indexOf(winningNum.charAt(2)) != -1) && (userNum.indexOf(winningNum.charAt(3)) != -1)) {
			System.out.println("You win $25,000!");
		}
		else if ((userNum.indexOf(winningNum.charAt(0)) != -1) || (userNum.indexOf(winningNum.charAt(1)) != -1) || (userNum.indexOf(winningNum.charAt(2)) != -1) || (userNum.indexOf(winningNum.charAt(3)) != -1)) {
			System.out.println("You win $5 you sad idiot");
		}
		else {
			System.out.println("You suck");
		}
	}
	
	public static void run() {
		getUserNumber();
	}

	public static void main(String[] args) {
		run();
	}

}
