package finalProject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.regex.*;

public class LyricPuzzle {
    public static String[] allLyrics = {"Baby, keep on dancing like you ain't got a choice", "She got a light-skinned friend look like Michael Jackson",
            "A falling star fell from your heart and landed in my eyes", "But you in LA, and I'm out at Jermaine's", "Now I'm at the White House, looking for your President",
            "So I creep, yeah, cause he doesn't know what I do", "That's why I need a one dance", "Young rebel, Young Money, nothin' you could tell me",
            "My man is my man, is your man, heard that's her man"};
    private ArrayList<PuzzleSegment> segments = new ArrayList<PuzzleSegment>();
    private ArrayList<String> colors = new ArrayList<String>(Arrays.asList("Red, Yellow, Green, Blue"));
    private Random rand = new Random();

    public ArrayList<String> splitLyric() {
        String fullLyric = allLyrics[rand.nextInt(allLyrics.length)];
        ArrayList<String> splitLyricArray = new ArrayList<String>();
        Pattern pattern = Pattern.compile("\\S+(\\s\\S+)?");
        Matcher matcher = pattern.matcher(fullLyric);
        while (matcher.find()) {
            splitLyricArray.add(matcher.group());
        }
        return splitLyricArray;
    }

    public void makeSegments(ArrayList<String> splitLyricArray) {
        for (int i = 0; i < splitLyricArray.size(); i++) {
            segments.add(new PuzzleSegment(splitLyricArray.get(i)));
        }
    }

    public void cleanSegmentsArray() {
        for (int i = 0; i < segments.size(); i++) {
            if (segments.get(i).getColor() == null) {
                segments.remove(i);
            }
        }
    }
    /*
    match colors method:
    two for loops over big puzzlesegments arraylist
    get main lyric using puzzlesegment.getfulllyric
        if both puzzlesegments (i and j) have same full lyric:
            check that neither puzzlesegment has a color before adding
            add to temporary array
        when iterated over all j:
            do puzzlesegment.setcolor for all elements in temp. array to a random color
            remove the color used from the colors array so it won't be repeated
            check if colors arraylist is empty
            if colors arraylist is empty:
                use cleanSegmentsList method to clear all unnecessary puzzlesegments
                end method
            otherwise: continue for loop
    continue for loop until done
     */
    public void matchSegmentColors() {
        ArrayList<PuzzleSegment> tempColorMatch = new ArrayList<PuzzleSegment>();
        for (int i = 0; i < segments.size(); i++) {
            for (int j = 0; j < segments.size(); j++) {
                if (segments.get(i).getFullLyric().equals(segments.get(j).getFullLyric())) {
                    if ((segments.get(i).getColor() != null) || (segments.get(j).getColor() != null)) {
                        tempColorMatch.add(segments.get(j));
                    }
                }
            }
            String randColor = colors.get(rand.nextInt(colors.size()));
            for (int k = 0; k < tempColorMatch.size(); k++) {
                tempColorMatch.get(k).setColor(randColor);
            }
            tempColorMatch.clear();
            colors.remove(randColor);
            if (colors.isEmpty()) {
                cleanSegmentsArray();
                break;
            }
        }
    }

    public void test() {
        makeSegments(splitLyric());
        matchSegmentColors();
        for (int i = 0; i < segments.size(); i++) {
            System.out.println(segments.get(i).getLyric());
            System.out.println(segments.get(i).getColor());
        }
    }
}
