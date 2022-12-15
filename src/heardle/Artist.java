/**
 * Author: Caasi Boakye
 * Date:   Nov 3, 2022
 * Description: 
 */
package heardle;
import java.util.Scanner;
import java.util.Random;

/**
 * @author studentgvsc
 *
 */
public class Artist {
	private String[] artists = {"Dua Lipa", "Lauryn Hill", "Kanye West", "Florence + the Machine", "Mariah Carey", "Outkast", "jpegmafia", "TLC", "Havlin", "Drake", "SZA"};
	private Random rand = new Random();
	private String artist = "";
	private int artistIndex = rand.nextInt(artists.length);
	
	public Artist() {
		artist = artists[artistIndex];
	}
	
	public String getArtist() {
		return artist;
	}
	
	public String getLyrics() {
		int var = rand.nextInt(3);
		return Lyrics.lyrics[(artistIndex * 3) + var];
	}
}