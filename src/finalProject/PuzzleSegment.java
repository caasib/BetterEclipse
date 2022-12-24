package finalProject;

import java.util.Random;

public class PuzzleSegment {
    private String[] allLyrics = {"Baby, keep on dancing like you ain't got a choice", "She got a light-skinned friend look like Michael Jackson",
            "A falling star fell from your heart and landed in my eyes", "But you in LA, and I'm out at Jermaine's", "Now I'm at the White House, looking for your President",
            "So I creep, yeah, cause he doesn't know what I do", "That's why I need a one dance", "Young rebel, Young Money, nothin' you could tell me",
            "My man is my man, is your man, heard that's her man"};
    private Random rand = new Random();
    private String lyric, color; //the lyric portion and color (respectively) pertaining to a PuzzleSegment
    //color will start out as null and will later be set in LyricPuzzle

    public PuzzleSegment() { //Constructor
        String fullLyric = allLyrics[rand.nextInt(allLyrics.length)]; //get a random lyric from the main arraylist
        String[] lyricArray = fullLyric.split("\\b\\s\\b"); //takes the lyric and splits it every 2 words making a temporary array to store
        this.lyric = lyricArray[rand.nextInt(lyricArray.length)]; //picks a random lyric portion from the lyric array (check for dupes in LyricPuzzle)
    }

    //Getters and Setters
    public String getLyric() {
        return lyric;
    }

    public void setLyric(String lyric) {
        this.lyric = lyric;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getFullLyric() {
        String fullLyric = "";
        for (int i = 0; i < allLyrics.length; i++) {
            if (allLyrics[i].contains(this.lyric)) {
                fullLyric = allLyrics[i];
            }
        }
        return fullLyric;
    }


}
