/**
 * Author: Caasi Boakye
 * Date:   Oct 20, 2022
 * Description: 
 */
package cardGame;
import java.util.Scanner;

/**
 * @author studentgvsc
 *
 */
public class Tester {

	public static void main(String[] args) {
		Deck deck = new Deck(true);
		System.out.println(deck.dealCard());
		System.out.println(deck.dealCard());
		System.out.println(deck.dealCard());
		System.out.println(deck.dealCard());
		System.out.println(deck);
	}

}
