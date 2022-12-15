/**
 * Author: Caasi Boakye
 * Date:   Oct 20, 2022
 * Description: 
 */
package arrays;
import java.util.Scanner;

/**
 * @author studentgvsc
 *
 */
public class Library {
	//This library class will function as a database (array) for all of our books
	
	private Book[] library; //Only initialize static variables and objects outside of the class
	private static int count = 0;
	
	public Library() {
		library = new Book[1]; //A default library contains 1 book
		library[0] = new Book();
		
		//Each time we add a book to the library, we want to increment our count variable
	}
	
	//This library contains an administrator defined number of books
	
	public Library(int num) {
		library = new Book[num]; //It is not necessary for a constructor parameter to be tied to a class variable
	}
	
	//We need a method to retrieve a book from the library
	//Methods can return objects (just like they return ints, doubles, Strings, etc.)
	
	public Book getBook(int index) {
		return library[index];
	}
	
	//This method will print the info for every book in the library
	//It will stop at the static variable count to avoid NullPointerException
	
	public String toString() {
		String summary = "";
		
		for (int i = 0; i < library.length; i++) {
			summary += library[i];
		}
		
		return summary;
	}
	
	//Create a method that adds a book to the library
	
	public void addBook() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the author's name and book title on separate lines: ");
		String name = scan.nextLine();
		String title = scan.nextLine();
		//Add the book at the current value of count
		library[count] = new Book(name, title);
	}
}
