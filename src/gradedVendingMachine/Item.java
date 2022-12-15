/**
 * Author: Caasi Boakye
 * Date:   Nov 22, 2022
 * Description: 
 */
package gradedVendingMachine;
import java.util.Scanner;
import java.util.Random;

/**
 * @author studentgvsc
 *
 */
public class Item {
	private String name;
	private double price;
	private Random rand = new Random();
	private String[] defaultNames = {"Snickers Bar", "Pop-Tart", "Cheez-its", "Doritos", "Lays", "Cookie", "Monster", "Coke Cherry", "Sprite", "Honey Bun", "Granola Bar", "M&Ms", "Skittles", "Takis", "Pretzels", "Popcorn", "Gummy Bears", "Cheetos", "Reese's Pieces", "Starbursts", "Twix", "Butterfingers", "Milky Way", "Trail Mix"};
	//all the possible names of items
	public Item() {
		this.name = defaultNames[rand.nextInt(defaultNames.length)]; //picks random name from the array
		this.price = (rand.nextInt(16) + 5) / 10.0;
		//rand.nextInt(16) returns a number from 0 to 15
		//the "+ 5" makes the number vary from 5 to 20
		//the division by 10.0 makes it so that it becomes a double from 0.5 to 2.0
	}
	
	public Item(String name, double price) {
		this.name = name;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
}
