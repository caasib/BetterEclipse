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
public class Book {
	//A book consists of an author and a title
	String author, title;
	
	//No parameter/no argument/default constructor - unknown author and untitled book
	public Book() {
		this.author = "Unknown";
		this.title = "Untitled";
	}
	
	public Book(String author, String title) {
		this.author = author;
		this.title = title;
	}
	
	public String getAuthor() {
		return author;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setAuthor(String author) {
		this.author = author;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String toString() {
		return "Book [Author = " + author + ", " + "Title = " + title + "]\n";
	}
}
