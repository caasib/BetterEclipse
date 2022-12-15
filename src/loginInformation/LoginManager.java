/**
 * Author: Caasi Boakye
 * Date:   Sep 15, 2022
 * Description: 
 * 
 * Take a user's first, middle, and last name and create a Gov School email address
 * that ends in @GSIP.edu and gives a random 8 character password
 * and sends a confirmation code to the email address
 * If the user's last name is more than 6 characters, only use the first six characters
 * 
 * Ex: For Christopher Lawrence Martin, the program would generate
 * martinCL@GSIP.edu
 * 
 */
package loginInformation;
import java.util.Random;
import java.util.Scanner;

/**
 * @author studentgvsc
 *
 */
public class LoginManager {
	//static ensures the variables and objects exist for the class and not just the methods
	
	static Scanner scan = new Scanner(System.in);
	
	//populate the user variables
	public static void getUserInfo() {
		String first, middle, last;
		System.out.println("What is your first name? ");
		first = scan.nextLine();
		
		System.out.println("What is your middle name? ");
		middle = scan.nextLine();
		
		System.out.println("What is your last name? ");
		last = scan.nextLine();
		
		System.out.print("At the end of this program, you will have a GSIP email address");
		System.out.println(" and a temporary password.");
		System.out.printf("Your email is: %s.\n", getEmailAddress(first, middle, last));
		System.out.printf("Your password is %s.\n", getPassword());
		System.out.printf("Your confirmation code of %d has been sent to your new email. Please check your spam folder.", getConfirmation());
	}
	
	//controls the entire program
	public static void run() {
		getUserInfo();
	}
	
	public static String getEmailAddress(String first, String middle, String last) {
		String email = "";
		
		if (last.length() >= 7) {
			email += last.substring(0,6).toLowerCase();
			email += first.substring(0,1).toUpperCase() + middle.substring(0,1).toUpperCase();
			email += "@GSIP.edu";
		}
		
		else {
			email += last.toLowerCase();
			email += first.substring(0,1).toUpperCase() + middle.substring(0,1).toUpperCase();
			email += "@GSIP.edu";
		}
		
		return email;
	}
	
	public static String getPassword() {
		String characters = "abcdefghijklmnopqrstuvwxyz";
		characters += characters.toUpperCase();
		characters += "!@#$%^&*";
		
		//characters now contains 60 characters
		String password = "";
		Random rand = new Random();
		
		//add random character from characters to password
		int x = rand.nextInt(characters.length()); //value between 0 and 59
		password += characters.substring(x,x+1);
		
		x = rand.nextInt(characters.length());
		password += characters.substring(x,x+1);
		
		x = rand.nextInt(characters.length());
		password += characters.substring(x,x+1);
		
		x = rand.nextInt(characters.length());
		password += characters.substring(x,x+1);
		
		x = rand.nextInt(characters.length());
		password += characters.substring(x,x+1);
		
		x = rand.nextInt(characters.length());
		password += characters.substring(x,x+1);
		
		x = rand.nextInt(characters.length());
		password += characters.substring(x,x+1);
		
		return password;
	}
	
	public static int getConfirmation() {
		//returns 6 digit confirmation code emailed to new address
		//(max - min + 1) + min
		Random rand = new Random();
		
		return rand.nextInt(999999 - 100000 + 1) + 100000;
	}

	public static void main(String[] args) {
		run();
	}

}
