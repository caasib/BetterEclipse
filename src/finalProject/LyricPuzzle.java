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
    private String[] colors = {"Red", "Yellow", "Green", "Blue"};
    private Random rand = new Random();
    private Scanner scan = new Scanner(System.in);
    private int counter = 0;
    private int columns = 0;
    private int matchesFound = 0;
    private int lyricsFound = 0;
    private int movesLeft;
    private int matchesToFind;
    private int lyricsToFind;

    public ArrayList<String> splitLyric() {
        String fullLyric = allLyrics[counter];
        ++counter; //This way it always gives you something different when you call splitLyric(). I only call it 4 times, so no worries about
        //accidentally calling an index which is out of bounds
        ArrayList<String> splitLyricArray = new ArrayList<String>();
        Pattern pattern = Pattern.compile("\\S+(\\s\\S+)?"); //Trying to do .split() for every 2 spaces is too complicated, and the only ways
        //that I could find were broken because they relied on an old bug with the lookbehind regex. Instead, Pattern and Matcher regex is much
        //easier to use and understand and gives me the result I'm looking for.
        /*
        A quick explanation of the regex:
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
            String color = colors[k];
            for (int l = 0; l < colorLists.get(k).size(); l++) {
                colorLists.get(k).get(l).setColor(color);
                //This is kinda ugly, but it just gets the PuzzleSegment inside the ArrayList inside colorLists and changes its color
            }
        }
    }

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
        if (middleDivisor == 1) {
            middleDivisor = 2;
        }
        return middleDivisor;
    }

    public void displayBoard() { //Big thanks to Kenzie for helping me do basic math
        //Because it's a 1D array, I'm just going to iterate over the array the normal way and then check to see if we're at the end
        //of the column so that it can split up the rows
        for (int i = 0; i < columns; i++) {
            if (i == 0) {
                System.out.printf("\t\t%-15d", i);
            }
            else {
                System.out.printf("%-20d", i);
            }
        }
        System.out.println();
        for (int i = 0; i < segments.size(); i++) {
            if (i == 0) {
                System.out.print(i + "  ");
            }
            if ((i % columns == 0 ) && (i != 0)) {
                System.out.println();
                System.out.print("\u001b[0m" + i / columns + "  ");
            }
            System.out.printf("%-20s   ", printColor(segments.get(i).getColor()) + segments.get(i).getLyric()); //Strings take up 15 spaces and I add a few spaces for niceness
            //I could have used \t, but I didn't like how large the gap was. It's better to have things closer together since this will
            //be a matching game
        }
        System.out.println("\u001b[0m" + ""); //Resets the color for later print statements
    }

    public boolean checkLeftMatch(PuzzleSegment selectedSegment) {
        boolean match = false;
        int segmentIndex = segments.indexOf(selectedSegment);
        if (segmentIndex - 1 == -1) {
            return match;
        }
        PuzzleSegment segmentToCheck = segments.get(segmentIndex - 1);
        String fullLyric = selectedSegment.getFullLyric();
        String wordsBefore = fullLyric.substring(0, fullLyric.indexOf(selectedSegment.getLyric())).trim(); //Gets the substring of words that come before the segment
        String wordBefore = wordsBefore.substring(wordsBefore.lastIndexOf(" ") + 1); //Finds the last word of that substring by finding the last space in the
        //substring and going one more for the letter
        if (selectedSegment.getFullLyric().equals(segments.get(segmentIndex - 1).getFullLyric())) {
            if (segmentToCheck.getLyric().contains(wordBefore)) {
                match = true;
                segments.remove(selectedSegment);
                segments.remove(segmentToCheck);
            }
        }
        return match;
    }

    public boolean checkRightMatch(PuzzleSegment selectedSegment) {
        boolean match = false;
        int segmentIndex = segments.indexOf(selectedSegment);
        if (segmentIndex + 1 == segments.size()) {
            return match;
        }
        PuzzleSegment segmentToCheck = segments.get(segmentIndex + 1);
        String fullLyric = selectedSegment.getFullLyric();
        int nextWordIndex = fullLyric.indexOf(selectedSegment.getLyric()) + (selectedSegment.getLyric().length() + 1); //Gets the index of the lyric in the segment, then adds
        //the length of that lyric to get to the end of the segment, then adds another one to get to the next word
        if (fullLyric.equals(segmentToCheck.getFullLyric())) {
            if (fullLyric.indexOf(segmentToCheck.getLyric()) == nextWordIndex){
                match = true;
                System.out.println(nextWordIndex);
                System.out.println(fullLyric.indexOf(segmentToCheck.getLyric()));
                System.out.println(fullLyric.charAt(nextWordIndex));
                segments.remove(selectedSegment);
                segments.remove(segmentToCheck);
            }
        }
        return match;
    }

    public boolean checkForMatch(PuzzleSegment selectedSegment) { //Combines the previous two methods
        boolean match = false;
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

    public boolean isValidMove(int originalSegment, int segmentToSwap) {
        boolean valid = false;
        if ((originalSegment - 1 == segmentToSwap) || (originalSegment + 1 == segmentToSwap) || (originalSegment + columns == segmentToSwap) || (originalSegment - columns == segmentToSwap)) {
            valid = true;
        }
        return valid;
    }

    public int getValidInput() {
        //This will return the index of the segment that is picked
        System.out.println("Select a segment using the row number and column number. For example: \"1 2\"");
        String fullInput = scan.nextLine(); //Normally you would use scan.nextInt() twice, but what if the user doesn't give us an integer?
        fullInput = fullInput.trim(); //Removes leading and trailing spaces
        String[] strInputArray = fullInput.split("\\s+"); //Gets rid of all spaces in the middle
        int[] intArray = new int[2];
        if (strInputArray.length != 2) {
            System.out.println("Please format your input properly. For example: \"1 2\"");
            return -1; //This is used as an abnormal value so that later on we can see if the input was good or not
            //I was originally going to make this function run itself again if the input was wrong, but that messed with the
            //return at the end.
        }
        for (int i = 0; i < strInputArray.length; i++) {
            try { //Try and catch allows us to execute code that could potentially error without completely stopping the program
                //Here, we're checking to see if the element in the strInputArray at i is an integer by trying to parse it as one
                intArray[i] = Integer.parseInt(strInputArray[i]);
            } catch (NumberFormatException e) { //Normally, if that didn't work, Java would throw a NumberFormatException error and then
                //stop the program. What this catch block does instead is make it so that the user just has to retry their input instead.
                System.out.println("Please only input numbers.");
                return -1;
            }
        }
        for (int i = 0; i < intArray.length; i++) {
            if (String.valueOf(intArray[i]).length() > 2) {
                System.out.println("Please only input single or double digit numbers.");
                return -1;
            }
        }
        int rows = (int)Math.ceil(segments.size() / (double)columns);
        if (intArray[0] > rows - 1 || intArray[0] < 0) {
            System.out.println("Invalid row number.");
            return -1;
        }
        if (intArray[1] > columns - 1 || intArray[1] < 0) {
            System.out.println("Invalid column number.");
            return -1;
        }
        int indexOfSegment = (intArray[0] * columns) + intArray[1];
        if (indexOfSegment == segments.size()) {
            System.out.println("There isn't anything there!");
            return -1;
        }
        return indexOfSegment; //Gives the index position of the segment in the array
        /* Because this is a 1D array, I have to be a little creative with the math in order to get this to work.
        To visualize:
        (0,0) (0,1) (0,2)
        (1,0) (1,1) (1,2)
        (2,0) (2,1) (2,2)
        Consider an input of row 1, column 2 (1,2). With the way that the grid is displayed, that would be the 5th item in the array.
        There are 3 columns, so when we plug everything in, we get (1 * 3) + 2 = 5.
        Now, even without using a 2D array like in the vending machine project, I can still get the correct index for the item I want.
         */
    }

    public boolean hasOtherMatches(PuzzleSegment segment) {
        boolean matches = false;
        for (int i = 0; i < segments.size(); i++) {
            if (segments.get(i).getColor().equals(segment.getColor()) && segments.get(i) != segment) {
                matches = true;
                break;
            }
        }
        return matches;
    }

    public void clearLonelyLyrics() {
        for (int i = 0; i < segments.size(); i++) {
            if (!hasOtherMatches(segments.get(i))) {
                segments.remove(i);
            }
        }
    }

    public boolean checkClearedLyric(String color) {
        boolean cleared = true;
        for (int i = 0; i < segments.size(); i++) {
            if (segments.get(i).getColor().equals(color)) {
                cleared = false;
                break;
            }
        }
        return cleared;
    }

    public String printColor(String segmentColor) { //This gives us pretty printing for the lyrics
        String color = "";
        switch (segmentColor) { //Basically an if-else statement, but runs a tiny bit faster because it doesn't have to go
            //through every single branch when it runs. Instead, it just immediately jumps to the proper case
            case "Red":
                color = "\u001b[31m";
                break;
            case "Blue":
                color = "\u001b[34m";
                break;
            case "Yellow":
                color = "\u001b[33m";
                break;
            case "Green":
                color = "\u001b[32m";
                break;
        }
        return color;
    }

    public void setup() {
        Collections.shuffle(Arrays.asList(allLyrics)); //This prevents repetition without me having to do a bunch of checks
        //There are ways to shuffle without just converting an array to a list and shuffling, but that requires a lot more work
        makeSegments(splitLyric());
        makeSegments(splitLyric());
        makeSegments(splitLyric());
        makeSegments(splitLyric());
        columns = findMiddleDivisor();
        matchSegmentColors(groupSameSegments());
        Collections.shuffle(segments); //Shuffling segments so that all the lyrics don't print out in the right order and ruin the game
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
    If there is a singular lyric left, end the game
     */

    public void play() {
        displayBoard();
        System.out.println(movesLeft + " move(s) left.");
        System.out.println(matchesFound + " match(es) found. You need to find " + matchesToFind + " matches to win.");
        if (lyricsToFind > 0) {
            System.out.println(lyricsFound + " lyric(s) found. You need to find " + lyricsToFind + " lyric(s) to win.");
        }
        int firstSegmentIndex = getValidInput();
        while (firstSegmentIndex == -1) {
            firstSegmentIndex = getValidInput();
        }
        PuzzleSegment firstSegment = segments.get(firstSegmentIndex);
        System.out.println("Select the segment you want to switch that segment with: ");
        int secondSegmentIndex = getValidInput();
        while (secondSegmentIndex == -1) {
            secondSegmentIndex = getValidInput();
        }
        PuzzleSegment secondSegment = segments.get(secondSegmentIndex);
        if (!isValidMove(firstSegmentIndex, secondSegmentIndex)) {
            System.out.println("Invalid move.");
            play();
        }
        --movesLeft;
        segments.set(secondSegmentIndex, firstSegment);
        segments.set(firstSegmentIndex, secondSegment);
        if (checkForMatch(firstSegment) || checkForMatch(secondSegment)) {
            ++matchesFound;
            System.out.println("Match found!");
            clearLonelyLyrics();
            if (checkClearedLyric(firstSegment.getColor()) || checkClearedLyric(secondSegment.getColor())) {
                ++lyricsFound;
            }
            if (matchesFound >= matchesToFind && lyricsFound >= lyricsToFind) {
                System.out.println("You won!");
                System.exit(0); //Makes the program end (return didn't work)
            }
        }
        else {
            System.out.println("No matches found.");
        }
        if (movesLeft == 0) {
            System.out.println("Game over!");
            System.exit(0);
        }
        if (segments.size() < 2) {
            System.out.println("Not enough segments to continue playing! Game over!");
            System.exit(0);
        }
        play();
    }

    public void tutorial() {
        System.out.println("This is a lyric matching game.");
        System.out.println("Depending on the difficulty you pick, you will either have to make a certain number of matches or make a full lyric in order to win.");
        System.out.println("You can move lyric segments up, down, left, or right - you cannot go diagonal, and you cannot move more than one space in a single turn.");
        System.out.println("If you make an invalid move, the segments will not move and the move will not count against you.");
        System.out.println("If the move is valid, even if it does not make a match, the segments will switch and the move will count.");
        System.out.println("To successfully match two segments, it has to be either on the left or right of a segment which has the same lyric and it has to be in the right order.");
        System.out.println("To make things easier for the player, segments which come from the same lyric are the same color.");
        System.out.println("Have fun!");
        menu();
    }

    public void menu() {
        System.out.println("Pick a difficulty:\n1 - Easy\n2 - Medium\n3 - Hard\nYou can also input 4 for a quick explanation of how to play.");
        int userPick = scan.nextInt(); //I should probably do another try-catch here, but I decided to actually
        //read the rubric and found out I don't have to do all of that. I'm too lazy to remove it from the getValidInput()
        //method, though
        scan.nextLine(); //Because getValidInput() uses scan.nextLine and this method uses scan.nextInt, I have to use
        //another scan.nextLine here to get rid of the newline that scan.nextInt leaves after pulling the integer
        switch (userPick) {
            case 1:
                matchesToFind = rand.nextInt(4) + 2;
                movesLeft = 20;
                play();
                break;
            case 2:
                lyricsToFind = 1;
                matchesToFind = rand.nextInt(4) + 5;
                movesLeft = 25;
                play();
                break;
            case 3:
                lyricsToFind = rand.nextInt(1) + 2;
                matchesToFind = 10;
                movesLeft = 30;
                play();
                break;
            case 4:
                tutorial();
                break;
            default: //If the user input isn't 1, 2, or 3, go here
                System.out.println("Invalid input.");
                menu();
        }
    }

    public void test() {
        setup();
        menu();
    }
}