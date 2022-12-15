/**
 * Author: Caasi Boakye
 * Date:   Oct 20, 2022
 * Description: 
 */
package cardGame;
import java.util.Scanner;
import java.util.Random;

/**
 * @author studentgvsc
 *
 */
public class Card {
	/*
	 * Card class overview:
	 * Default constructor - random suit and value
	 * Constructor - picked suit and value
	 * 2 methods to get a card's suit and value
	 * 2 methods to set a card's suit and value
	 * 2 methods to check whether a card is greater than, less than, or equal to another card
	 * toString() method - print "[Value] of [Suit]"
	 */
	private int[] cardValues = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};
	private String[] valueToString = {"Jack", "Queen", "King"};
	private String[] cardSuits = {"Spades", "Clubs", "Hearts", "Diamonds"};
	private Random rand = new Random();
	
	private String suit;
	private int value;
	
	public Card() {
		this.suit = cardSuits[rand.nextInt(4)];
		this.value = cardValues[rand.nextInt(13)];
	}
	
	//Card card = new Card();
	
	public Card(int value, String suit) {
		this.value = value;
		this.suit = suit;
	}
	
	//Card card = new Card(5, "Hearts");
	
	public String getSuit() {
		return suit;
	}
	
	//card.getSuit() --> "Hearts"
	
	public String getSuitFromNum(int num) {
		return cardSuits[num];
	}
	
	public int getValue() {
		return value;
	}
	
	public void setSuit(String suit) {
		this.suit = suit;
	}
	
	//card.setSuit("Diamonds");
	//card.getSuit() --> "Diamonds"
	
	public void setValue(int value) {
		this.value = value;
	}
	
	public Boolean greaterThan(Card card) {
		if (this.value > card.value) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public Boolean equalTo(Card card) {
		if (this.value == card.value) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public String toString() {
		String summary = "";
		
		if (this.value > 10) {
			summary += valueToString[this.value - 11] + " of " + this.suit;
		}
		else if (this.value == 1) {
			summary += "Ace of " + this.suit;
		}
		else {
			summary += this.value + " of " + this.suit;
		}
		
		return summary;
	}
	
}
