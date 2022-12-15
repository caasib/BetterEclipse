/**
 * Author: Caasi Boakye
 * Date:   Oct 20, 2022
 * Description: 
 */
package cardGame;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

/**
 * @author studentgvsc
 *
 */
public class Deck {
	/*
	 * Deck class overview:
	 * Default constructor - shuffled or unshuffled deck
	 * Method to deal a card
	 * Method to shuffle a deck
	 * Method to print out cards in deck in order
	 * toString() method - print # of cards dealt
	 */
	
	private ArrayList<Card> deck = new ArrayList<Card>();
	private int numDealtCards = 0;
	private boolean shuffled = false;
	
	public Deck(boolean shuffled) {
		this.shuffled = shuffled;
		if (shuffled) {
			for (int i = 0; i < 4; i++) {
				for (int j = 0; j < 13; j++) {
					Card card = new Card();
					card.setSuit(card.getSuitFromNum(i));
					card.setValue(j);
					deck.add(card);
				}
			}
			Collections.shuffle(deck);
		}
		else {
			for (int i = 0; i < 4; i++) {
				for (int j = 1; j < 14; j++) {
					Card card = new Card();
					card.setSuit(card.getSuitFromNum(i));
					card.setValue(j);
					deck.add(card);
				}
			}
		}
	}
	
	public Card dealCard() {
		Card dealtCard = deck.get(0);
		deck.remove(0);
		numDealtCards += 1;
		return dealtCard;
	}
	
	public void shuffleDeck() {
		Collections.shuffle(this.deck);
	}
	
	public String toString() {
		String summary = "";
		
		summary += "Deck (" + numDealtCards + " dealt" + ", shuffled = " + shuffled + ")";
		
		return summary;
	}
	
	
}
