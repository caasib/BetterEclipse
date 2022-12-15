/**
 * Author: Caasi Boakye
 * Date:   Oct 13, 2022
 * Description: 
 */
package fan;
import java.util.Scanner;

/**
 * @author studentgvsc
 *
 */
public class FanTest {

	public static void main(String[] args) {
		//This constructor uses the no-parameter constructor
		Fan defaultFan = new Fan();
		
		Fan myFan = new Fan("purple", true, 8, 2.5);
		
		System.out.println(defaultFan);
		System.out.println(myFan);
	}

}
