package finalProject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.util.Collections;

public class LyricPuzzle {
    public static String[] allLyrics = {"Baby, keep on dancing like you ain't got a choice", "She got a light-skinned friend look like Michael Jackson",
            "A falling star fell from your heart and landed in my eyes", "But you in LA, and I'm out at Jermaine's", "Now I'm at the White House, looking for your President",
            "So I creep, yeah, cause he doesn't know what I do", "That's why I need a one dance", "Young rebel, Young Money, nothin' you could tell me",
            "My man is my man, is your man, heard that's her man"};
    private ArrayList<PuzzleSegment> segments = new ArrayList<PuzzleSegment>();
    private ArrayList<String> colors = new ArrayList<String>(Arrays.asList("Red", "Yellow", "Green", "Blue"));
    //Arrays.asList converts an array to a list. I just used it here so that I could initialize an ArrayList with values instead of having to
    //add them later line by line
    //I could have done the same thing with allLyrics, but I thought it looked ugly that way
    private Random rand = new Random();
    private static int counter = 0;

    public ArrayList<String> splitLyric() {
        String fullLyric = allLyrics[counter];
        ++counter; //This way it always gives you something different when you call splitLyric(). I only call it 4 times, so no worries about
        //accidentally calling an index which is out of bounds
        ArrayList<String> splitLyricArray = new ArrayList<String>();
        Pattern pattern = Pattern.compile("\\S+(\\s\\S+)?"); //Trying to do .split() for spaces is too complicated, and the only ways
        //that I could find were broken because they relied on an old bug with the lookbehind regex. Instead, Pattern and Matcher regex is much
        //easier to use and understand and gives me the same result
        Matcher matcher = pattern.matcher(fullLyric);
        while (matcher.find()) {
            splitLyricArray.add(matcher.group());
        }
        return splitLyricArray;
    }

    public void makeSegments(ArrayList<String> splitLyricArray) { //I'm not very creative with parameter names
        for (int i = 0; i < splitLyricArray.size(); i++) {
            segments.add(new PuzzleSegment(splitLyricArray.get(i)));
        }
    }

    //I don't think I'll ever need this method, but it doesn't hurt to keep it as a comment just in case
/*
    public void removeNullSegments() {
        for (int i = 0; i < segments.size(); i++) {
            if (segments.get(i).getColor() == null) {
                segments.remove(i);
            }
        }
    }
*/

    public ArrayList<ArrayList<PuzzleSegment>> groupSameSegments() {
        ArrayList<ArrayList<PuzzleSegment>> colorLists = new ArrayList<ArrayList<PuzzleSegment>>();
        ArrayList<PuzzleSegment> tempColorMatch = null; //This is a flag to see the last ArrayList made
        for (int i = 0; i < segments.size(); i++) {
            //Lots of thanks to the kind man on StackOverflow who did this 5 years ago. I struggled for hours over this
                if ((tempColorMatch == null) || (!tempColorMatch.get(0).getFullLyric().equals(segments.get(i).getFullLyric()))) {
                    //If the lyric segments belong to different lyrics (or if there is no ArrayList yet), make a new ArrayList
                    tempColorMatch = new ArrayList<PuzzleSegment>();
                    tempColorMatch.add(segments.get(i));
                    colorLists.add(tempColorMatch);
            }
                else {
                    //Otherwise, just add it to the one already made
                    tempColorMatch.add(segments.get(i));
                }
        }
        return colorLists;
    }

    public void matchSegmentColors(ArrayList<ArrayList<PuzzleSegment>> colorLists) { //A lot of these methods just feed into each other
        //I think this can be considered lasanga code (code that is so intertwined that you can't make changes in one layer without changing
        //the rest)
        for (int k = 0; k < colorLists.size(); k++) {
            String randColor = colors.get(rand.nextInt(colors.size()));
            for (int l = 0; l < colorLists.get(k).size(); l++) {
                colorLists.get(k).get(l).setColor(randColor);
                //This is kinda ugly, but it just gets the PuzzleSegment inside the ArrayList inside colorLists and changes its color
            }
            colors.remove(randColor);
            if (colors.isEmpty()) {
                //removeNullSegments();
                break;
            }
        }
    }

    public void test() {
        Collections.shuffle(Arrays.asList(allLyrics)); //This prevents repetition without me having to do a bunch of checks
        //There are ways to shuffle without just converting an array to a list and shuffling, but that requires a lot more work
        makeSegments(splitLyric());
        makeSegments(splitLyric());
        makeSegments(splitLyric());
        makeSegments(splitLyric());
        matchSegmentColors(groupSameSegments());
        for (int i = 0; i < segments.size(); i++) {
            System.out.println(segments.get(i).getLyric());
            System.out.println(segments.get(i).getColor());
        }
    }
}
