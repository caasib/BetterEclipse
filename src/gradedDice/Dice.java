/**
 * Author: Caasi Boakye
 * Date:   Oct 20, 2022
 * Description: Dice class
 */
package gradedDice;
import java.util.Scanner;
import java.util.Random;

/**
 * @author studentgvsc
 *
 */
public class Dice {
	private int die1, die2;
	
	public Dice() {
		this.die1 = 6;
		this.die2 = 6;
	}
	
	public Dice(int sides) {
		if ((sides < 4) || (sides > 20)) {
			this.die1 = 6;
			this.die2 = 6;
		}
		else {
			this.die1 = sides;
			this.die2 = sides;
		}
	}
	
	public Dice(int sides1, int sides2) {
		if ((sides1 < 4) || (sides1 > 20)) {
			this.die1 = 6;
		}
		else {
			this.die1 = sides1;
		}
		if ((sides2 < 4) || (sides2 > 20)) {
			this.die2 = 6;
		}
		else {
			this.die2 = sides2;
		}
	}
	
	public void setDie1(int sides) {
		if ((sides < 4) || (sides > 20)) {
			this.die1 = 6;
		}
		else {
			this.die1 = sides;
		}
	}
	
	public void setDie2(int sides) {
		if ((sides < 4) || (sides > 20)) {
			this.die2 = 6;
		}
		else {
			this.die2 = sides;
		}
	}
	
	public int getDie1() {
		Random rand = new Random();
		return rand.nextInt(this.die1) + 1;
	}
	
	public int getDie2() {
		Random rand = new Random();
		return rand.nextInt(this.die2) + 1;
	}
	
	public String toString() {
		String summary = "";
		
		summary += "Die 1 - " + this.die1 + " sides\n"
				+ "Die 2 - " + this.die2 + " sides\n"
				+ "\n"
				+ (this.die1 * this.die2) + " possible Outcomes\n"
				+ "\n";
		
		for (int i = 1; i <= die1; i++) {
			for (int j = 1; j <= die2; j++) {
				summary += "(" + i + "," + j + ")\t";
			}
			summary += "\n";
		}
		
		return summary;
	}
}
