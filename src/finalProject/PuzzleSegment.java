package finalProject;

import java.util.ArrayList;
import java.util.Random;

public class PuzzleSegment {
    private String[] allLyrics = {"Baby, keep on dancing like you ain't got a choice", "She got a light-skinned friend look like Michael Jackson",
            "A falling star fell from your heart and landed in my eyes", "But you in LA, and I'm out at Jermaine's", "Now I'm at the White House, looking for your President",
            "So I creep, yeah, cause he doesn't know what I do", "That's why I need a one dance", "Young rebel, Young Money, nothin' you could tell me",
            "My man is my man, is your man, heard that's her man"};
    private ArrayList<String> splitLyric = new ArrayList<String>();
    private Random rand = new Random();
    //get random lyric, split it into multiple parts, put it in to the arraylist
    public PuzzleSegment() {
        String fullLyric = allLyrics[rand.nextInt(allLyrics.length)];

    }

}
