/**
 * Author: Caasi Boakye
 * Date:   Aug 25, 2022
 * Description: 
 */
import java.util.Scanner;

// The Scanner class is used to communicate with the user (Via Keyboard), or read files
// The Scanner class is imported below the package declaration and above the class name

// The syntax to create ANY OBJECT in JAVA is:

// ClassName yourObjectName = ClassName(parameterList);

public class IntroLesson {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		
		System.out.println("What is your name?");
		
		String username = keyboard.nextLine();
		
		System.out.println("So you're telling me that your name is " + username + ".");
	}

}
