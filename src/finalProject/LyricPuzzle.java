package finalProject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.util.Collections;

public class LyricPuzzle {
    protected static String[] allLyrics = {"Baby, keep on dancing like you ain't got a choice", "She got a light-skinned friend look like Michael Jackson",
            "A falling star fell from your heart and landed in my eyes", "But you in LA, and I'm out at Jermaine's", "Now I'm at the White House, looking for your President",
            "So I creep, yeah, cause he doesn't know what I do", "That's why I need a one dance", "Young rebel, Young Money, nothin' you could tell me",
            "My man is my man, is your man, heard that's her man"}; //If you have any suggestions, let me know
    //The allLyrics array is protected rather than private and static so that it can be referenced in the PuzzleSegment class in order for the
    //getFullLyric() method to work
    private ArrayList<PuzzleSegment> segments = new ArrayList<PuzzleSegment>();
    private ArrayList<String> colors = new ArrayList<String>(Arrays.asList("Red", "Yellow", "Green", "Blue"));
    //Arrays.asList converts an array to a list. I just used it here so that I could initialize an ArrayList with values instead of having to
    //add them later line by line
    //I could have done the same thing with allLyrics, but I thought it looked ugly that way ¯\_(ツ)_/¯
    private Random rand = new Random();
    private Scanner scan = new Scanner(System.in);
    private int counter = 0;

    public ArrayList<String> splitLyric() {
        String fullLyric = allLyrics[counter];
        ++counter; //This way it always gives you something different when you call splitLyric(). I only call it 4 times, so no worries about
        //accidentally calling an index which is out of bounds
        ArrayList<String> splitLyricArray = new ArrayList<String>();
        Pattern pattern = Pattern.compile("\\S+(\\s\\S+)?"); //Trying to do .split() for every 2 spaces is too complicated, and the only ways
        //that I could find were broken because they relied on an old bug with the lookbehind regex. Instead, Pattern and Matcher regex is much
        //easier to use and understand and gives me the result I'm looking for.
        /*
        A quick explanation:
        The regex "\S+(\s\S+)? finds and groups together every 2 words. \S matches non-whitespace characters and \s matches whitespace.
        Basically, it looks for a non-whitespace character, and then it looks for the group of a whitespace character and another
        non-whitespace character. The \S+ means that it looks for one or more non-whitespace characters; as many as it can find.
        The ? means that it matches for the group of a whitespace character and then as many non-whitespace characters as possible
        0-1 times.
        The double \ in the actual code is because you have to escape special characters. Nothing big there.
        */
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

    public ArrayList<ArrayList<PuzzleSegment>> groupSameSegments() { //It's ArrayLists all the way down!
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

    /*
    Gameplay:
    Board is a grid of lyrics (coordinate system like battleship)
    Limited amount of moves in a game
    To win, match x amount of lyric segments OR put together x amount of full lyrics
    Select a piece - can move it left, right, up, or down
    When piece is moved, check pieces to the left and right of it to see if they are part of the same lyric
    If they are, then check to see if they are in the right order
    If they're in the right order, delete from board and increment matches
    Even if a piece doesn't match, keep it in the same position and count the move
    If there is a singular lyric of one color, count it as a match and delete it from the board
     */
    public int findMiddleDivisor() {
        /* Using the middle divisor, I can make the display look more even
        For example, if segments.size() = 20, then instead of having something like 2 rows and 10 columns, I can instead find the middle
        factors of 20 and get 4 rows and 5 columns, which looks a lot better
        Of course, if the number is prime or the factors have a large difference between them, it's gonna look bad anyway, but what can you do?
        */
        ArrayList<Integer> divisors = new ArrayList<Integer>();
        for (int i = 1; i < segments.size()+1; i++) {
            if (segments.size() % i == 0) {
                divisors.add(i);
            }
        }
        int middleDivisor = divisors.get((divisors.size() - 1)/2); //Finds the middle value in the divisors arrayList
        return middleDivisor;
    }

    public void displayBoard() { //Big thanks to Kenzie for helping me do basic math
        //Because it's a 1D array, I'm just going to iterate over the array the normal way and then check to see if we're at the end
        //of the column so that it can split up the rows
        int columns = findMiddleDivisor();
        for (int i = 0; i < segments.size(); i++) {
            if ((i % columns == 0 ) && (i != 0)) {
                System.out.println();
            }
            System.out.printf("%-15s   ", segments.get(i).getLyric()); //Strings take up 15 spaces and I add a few spaces for niceness
            //I could have used \t, but I didn't like how large the gap was. It's better to have things closer together since this will
            //be a matching game
        }
    }

    //I hate repeating code too much, so now these will be 2 separate methods for either direction
    //They still repeat code, but I think it looks better this way
    public boolean checkLeftMatch(PuzzleSegment selectedSegment) {
        boolean match = false;
        int segmentIndex = segments.indexOf(selectedSegment);
        if (selectedSegment.getFullLyric().equals(segments.get(segmentIndex - 1).getFullLyric())) {
            match = true;
        }
        return match;
    }

    public boolean checkRightMatch(PuzzleSegment selectedSegment) {
        boolean match = false;
        int segmentIndex = segments.indexOf(selectedSegment);
        if (selectedSegment.getFullLyric().equals(segments.get(segmentIndex + 1).getFullLyric())) {
            match = true;
        }
        return match;
    }

    //And now, the main checkForMatch method which combines the two previous methods and makes this method look a lot nicer with a lot less
    //repeated code
    public boolean checkForMatch(PuzzleSegment selectedSegment) { //Check the left and right of the piece to see if there was a match
        boolean match = false;
        int columns = findMiddleDivisor();
        int segmentIndex = segments.indexOf(selectedSegment);
        if (segmentIndex % columns == 0) {
            if (checkRightMatch(selectedSegment)) {
                match = true;
            }
        }
        else if ((segmentIndex + 1) % columns == 0) {
            if (checkLeftMatch(selectedSegment)) {
                match = true;
            }
        }
        else {
            if ((checkLeftMatch(selectedSegment) || checkRightMatch(selectedSegment))) {
                match = true;
            }
        }
        return match;
    }

    public int segmentPositionInArray(int row, int column) {
        int columns = findMiddleDivisor(); //Need to find a way to give this a wider scope so that I don't have to constantly run this method
        /* Because this is a 1D array, I have to be a little creative with the math in order to get this to work.
        To visualize:
        (0,0) (0,1) (0,2)
        (1,0) (1,1) (1,2)
        (2,0) (2,1) (2,2)
        Consider an input of row 1, column 2 (1,2). With the way that the grid is displayed, that would be the 5th item in the array.
        There are 3 columns, so when we plug everything in, we get (1 * 3) + 2 = 5.
        Now, even without using a 2D array like in the vending machine project, I can still get the correct index for the item I want.
         */
        return (row * columns) + column;
    }

    public boolean isValidMove(int originalSegment, int segmentToSwap) {
        boolean valid = false;
        int columns = findMiddleDivisor();
        if ((originalSegment - 1 == segmentToSwap) || (originalSegment + 1 == segmentToSwap) || (originalSegment + columns == segmentToSwap) || (originalSegment - columns == segmentToSwap)) {
            valid = true;
        }
        return valid;
    }

    public int[] getInput() {
        System.out.println("Select a segment using the row number and column number. For example: \"1 2\"");
        String fullInput = scan.nextLine();
        fullInput = fullInput.trim(); //Removes leading and trailing spaces
        String[] strInputArray = fullInput.split("\\s+"); //Gets rid of all spaces in the middle
        System.out.println(Arrays.toString(strInputArray));
        int[] intArray = new int[2];
        if (strInputArray.length == 2) {
            for (int i = 0; i < strInputArray.length; i++) {
                try {
                    intArray[i] = Integer.parseInt(strInputArray[i]);
                } catch (NumberFormatException e) {
                    System.out.println("Please only input numbers.");
                    System.out.println(e);
                    getInput();
                    break;
                }
            }
            for (int i = 0; i < intArray.length; i++) {
                if (String.valueOf(intArray[i]).length() > 1) {
                    System.out.println("Please only input single digit numbers.");
                    getInput();
                    break;
                }
            }

        }
        else {
            System.out.println("Please format your input properly. For example: \"1 2\"");
            getInput();
        }
        System.out.println(Arrays.toString(intArray));
        System.out.println("ur mom");
        return intArray;
    }

    public void test() {
//        Collections.shuffle(Arrays.asList(allLyrics)); //This prevents repetition without me having to do a bunch of checks
//        //There are ways to shuffle without just converting an array to a list and shuffling, but that requires a lot more work
//        makeSegments(splitLyric());
//        makeSegments(splitLyric());
//        makeSegments(splitLyric());
//        makeSegments(splitLyric());
//        matchSegmentColors(groupSameSegments());
//        Collections.shuffle(segments); //Shuffling segments so that all the lyrics don't print out in the right order and ruin the game
//        displayBoard();
        getInput();
    }
}
