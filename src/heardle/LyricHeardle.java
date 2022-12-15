/**
 * Author: Caasi Boakye
 * Date:   Nov 10, 2022
 * Description: 
 */
package heardle;
import java.util.Scanner;

/**
 * @author studentgvsc
 *
 */
public class LyricHeardle {
	static Artist artistToGuess = new Artist();
	static Lyrics lyricsToGuess = new Lyrics();
	static Scanner scan = new Scanner(System.in);
	static int wrong = 0;
	
	public static void select() {
		System.out.println("Do you want to guess the artist from the lyrics (AL), or the song from the lyrics? (SL)");
		String selection = scan.nextLine();
		while ((!selection.toUpperCase().equals("AL") || (!selection.toUpperCase().equals("SL")))) {
			if (selection.toUpperCase().equals("AL")) {
				runArtistLyric();
				break;
			}
			else if (selection.toUpperCase().equals("SL")) {
				runSongLyric();
				break;
			}
			else {
				System.out.println("Invalid input");
				selection = scan.nextLine();
			}
		}
	}
	
	public static void runArtistLyric() {
		System.out.println("Guess the artist which matches these lyrics: ");
		System.out.println("\n"+ artistToGuess.getLyrics());
		boolean userGuess = guessArtist(scan.nextLine());
		while (!userGuess) {
			wrong += 1;
			System.out.println("Try again!");
			userGuess = guessArtist(scan.nextLine());
			if (wrong > 2) {
				System.out.println("You lost! The correct artist is " + artistToGuess.getArtist() + ".");
				break;
			}
		}
	}
	
	public static void runSongLyric() {
		System.out.println("Guess the song which matches these lyrics: ");
		System.out.println("\n" + lyricsToGuess.getLyrics());
		boolean userGuess = guessSong(scan.nextLine());
		while (!userGuess) {
			wrong += 1;
			System.out.println("Try again!");
			userGuess = guessSong(scan.nextLine());
			if (wrong > 2) {
				System.out.println("You lost! The correct song is " + lyricsToGuess.getSong() + ".");
				break;
			}
		}
	}
		
	public static boolean guessArtist(String guess) {
		if (guess.toLowerCase().equals(artistToGuess.getArtist().toLowerCase())) {
			System.out.println("Congratulations! You guessed the right artist.");
			return true;
		}
		else {
			return false;
		}
	}
	public static boolean guessSong(String guess) {
		if (guess.toLowerCase().equals(lyricsToGuess.getSong().toLowerCase())) {
			System.out.println("Congratulations! You guessed the right song.");
			return true;
		}
		else {
			return false;
		}
	}

	public static void main(String[] args) {
		select();
	}

}
