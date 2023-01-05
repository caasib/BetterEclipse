package finalProject;

import java.util.Random;

public class PuzzleSegment {
    private Random rand = new Random();
    private String lyric, color; //the lyric portion and color (respectively) pertaining to a PuzzleSegment
    //color will start out as null and will later be set in LyricPuzzle

    //Constructor
    public PuzzleSegment(String lyric) {
        this.lyric = lyric;
    }
    //No default constructor because there is no point

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
        for (int i = 0; i < LyricPuzzle.allLyrics.length; i++) {
            if (LyricPuzzle.allLyrics[i].contains(this.lyric)) {
                fullLyric = LyricPuzzle.allLyrics[i];
            }
        }
        return fullLyric;
    }


}
