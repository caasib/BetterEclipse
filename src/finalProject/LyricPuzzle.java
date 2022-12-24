package finalProject;

import java.util.ArrayList;
import java.util.Arrays;

public class LyricPuzzle {
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
    private ArrayList<PuzzleSegment> segments = new ArrayList<PuzzleSegment>();
    private ArrayList<String> colors = new ArrayList<String>(Arrays.asList("Red, Yellow, Green, Blue"));

}
