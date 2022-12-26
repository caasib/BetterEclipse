/**
 * Author: Caasi Boakye
 * Date:   Nov 22, 2022
 * Description: 
 */
package gradedVendingMachine;
import java.util.Scanner;

/**
 * @author studentgvsc
 *
 */
public class VendingMachine {
	private Item[][] inventory = new Item[5][3]; //the vending machine itself
	private Scanner scan = new Scanner(System.in);
	private double totalUserSpent, userMoney = 0.0;
	private boolean paid = false;
	
	public VendingMachine() { //constructs the vending machine with 15 random Items
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 3; j++) {
				inventory[i][j] = new Item();
			}
		}
	}
	
	public void displayItems() { //displays the items in a nice formatted way
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 3; j++) {
				System.out.printf("%-20s %.2f\t[%d][%d]   ", inventory[i][j].getName(), inventory[i][j].getPrice(), i, j);
				// %-20s has a string with 20 spaces
				// %.2f is a double which only displays 2 numbers after the decimal
				// \t makes a tab space
				// %d is an integer
			}
			System.out.println();
		}
	}
	
	public Item getItem(int row, int column) { //returns an item from the vending machine when given a row and column
		return inventory[row][column];
	}
	
	public void setItemPrice() { //admin - sets the price of an item
		displayItems();
		System.out.println("Select the item stating the row and column. For example: \"2 2\"");
		int row = scan.nextInt();
		int column = scan.nextInt();
		Item selectedItem = this.getItem(row, column);
		System.out.printf("What price should %s be changed to? (Type a double)", selectedItem.getName());
		double price = scan.nextDouble();
		selectedItem.setPrice(price);
		System.out.println("Price set!\n");
		admin();
	}
	
	public void setItemName() { //admin - sets the name of an item
		displayItems();
		System.out.println("Select the item stating the row and column. For example: \"2 2\"");
		int row = scan.nextInt();
		int column = scan.nextInt();
		Item selectedItem = this.getItem(row, column);
		System.out.printf("What should the name of %s be changed to?", selectedItem.getName());
		String name = scan.next();
		selectedItem.setName(name);
		System.out.println("Name set!\n");
		admin();
	}
	
	public void admin() { //the admin interface, where you choose an option and it runs one of the other methods
		System.out.println("Choose an option:");
		System.out.println("A: Change an item name\nB: Change an item price\nC: Exit");
		String userInput = scan.next();
		if (userInput.equalsIgnoreCase("A")) {
			setItemName();
		}
		else if (userInput.equalsIgnoreCase("B")) {
			setItemPrice();
		}
		else if (userInput.equalsIgnoreCase("C")) {
			run(); //goes back to the run function where it asks you whether you want to use vending machine or run it again
		}
	}
	
	public void use() { //buying from the vending machine
		displayItems(); //displays the items nicely
		System.out.println("\nPlease select the item you want, stating the row and column. For example: \"2 2\"");
		int row = scan.nextInt();
		int column = scan.nextInt();
		System.out.printf("You have selected %s.\n", inventory[row][column].getName());
		System.out.println("This machine accepts nickels, dimes, quarters, and dollars. Please put in at least $0.25. Do not exceed two dollars.");
		System.out.println("Pennies are automatically returned to the user.");
		System.out.println("Please input money for your purchase.");
		userMoney = scan.nextDouble();
		double totalPrice = inventory[row][column].getPrice();
		while (!paid) { //paid is a boolean which checks to see if the full amount is paid for
			if (userMoney < 0.25) {
				System.out.println("Insufficient amount of money. Please put in at least $0.25.");
				userMoney = scan.nextDouble();
			}
			else if (userMoney > 2) {
				System.out.println("Too much money has been put in. Please do not exceed two dollars.");
				userMoney = scan.nextDouble();
			}
			else {
				totalUserSpent += Math.round(userMoney * 20.0) / 20.0; //automatically removes pennies from whatever amount is given
				if (totalUserSpent < totalPrice) {
					System.out.printf("Insufficient amount of money. Please enter the remaining $%.2f.", totalPrice - totalUserSpent);
					userMoney = scan.nextDouble();
				}
				else {
					System.out.printf("Enjoy! Your change is $%.2f.", totalUserSpent - totalPrice);
					paid = true;
				}
			}
		}
	}
	
	public void run() { //the default run where you pick to use the vending machine or the admin interface
		System.out.println("Choose an option:");
		System.out.println("A: Use the vending machine\nB: Use the admin interface");
		String userInput = scan.next();
		if (userInput.equalsIgnoreCase("A")) {
			use();
		}
		else if (userInput.equalsIgnoreCase("B")) {
			admin();
		}
		else {
			System.out.println("Invalid input.");
			run(); //runs again
		}
	}	
}
