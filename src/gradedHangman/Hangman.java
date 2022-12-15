package gradedHangman;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Hangman {
    private static String[] wordList = {"butter", "abyss", "button", "game", "hangman", "hydrogen", "distribution", "parasite", "paradox", "zebra", "yellow", "spring", "woman", "winter", "transportation", "education", "disestablishmentarianism", "pneumonoultramicroscopicsilicovolcanoconiosis", "stocking", "stomach", "blackberry", "xenobiotic", "xenomorph", "portrayal", "betrayal", "romance", "marriage", "divorce", "capybara", "calculus", "representative", "political", "porter", "crystal", "jewelry", "pensive", "vacuum", "ventriloquist", "queen", "queue", "commander", "violet", "violence", "waterfall", "wednesday", "mountain", "feast", "shoebill", "waitress", "dopamine"};
    private static ArrayList<String> guessedLetters = new ArrayList<String>();
    private static Random rand = new Random();
    private static Scanner scan = new Scanner(System.in);
    private static int chances = 6;

    private static String wordToGuess = wordList[rand.nextInt(wordList.length)];
    private static ArrayList<String> lettersToGuess = new ArrayList<String>();
    private static ArrayList<String> underscores = new ArrayList<String>();
    private static String userGuess;

    public static void splitWordIntoArray() {
        for (int i = 0; i < wordToGuess.length(); i++) {
            lettersToGuess.add(Character.toString(wordToGuess.charAt(i)));
        }
    }

    public static void makeUnderscores() {
        for (int i = 0; i < lettersToGuess.size(); i++) {
            underscores.add("_");
        }
    }

    public static void replaceUnderscores(String guess) {
        for (int i = 0; i < lettersToGuess.size(); i++) {
            if (lettersToGuess.get(i).equals(guess.toLowerCase())) {
                underscores.set(i, guess.toLowerCase());
            }
        }
    }

    public static boolean isCorrectGuess(String guess) {
        boolean correct = false;
        for (int i = 0; i < lettersToGuess.size(); i++) {
            if (guess.equalsIgnoreCase(lettersToGuess.get(i))) {
                correct = true;
            }
        }
        return correct;
    }

    public static boolean isAlreadyGuessed(String guess) {
        boolean guessed = false;
        for (int i = 0; i < guessedLetters.size(); i++) {
            if (guess.equalsIgnoreCase(guessedLetters.get(i))) {
                guessed = true;
            }
        }
        return guessed;
    }

    public static boolean checkGameWin() {
        int matchNum = 0;
        boolean won = false;
        for (int i = 0; i < lettersToGuess.size(); i++) {
            for (int j = 0; j < guessedLetters.size(); j++) {
                if (lettersToGuess.get(i).equalsIgnoreCase(guessedLetters.get(j))) {
                    matchNum += 1;
                    if (matchNum == lettersToGuess.size()) {
                        won = true;
                        break;
                    }
                }
            }
        }
        return won;
    }

    public static boolean checkGameLoss() {
        boolean loss = chances == 0;
        return loss;
    }

    public static void play() {
        System.out.println("Make a guess: ");
        System.out.println(underscores);
        userGuess = scan.next();
        if (userGuess.length() > 1) {
            System.out.println("Please only input one letter at a time.");
            play();
        }
        char charUserGuess = userGuess.charAt(0);
        if (Character.isDigit(charUserGuess)) {
            System.out.println("Please only input letters.");
            play();
        }
        if (isAlreadyGuessed(userGuess)) {
            System.out.println("You already guessed that!");
            play();
        }
        if (isCorrectGuess(userGuess)) {
            System.out.println("Correct guess!");
            guessedLetters.add(userGuess);
            replaceUnderscores(userGuess);
            if (checkGameWin()) {
                System.out.println("Congratulations, you won!");
                System.exit(0);
            }
            else {
                play();
            }
        }
        else {
            chances -= 1;
            System.out.println("Incorrect guess! You have " + chances + " guess(es) left.");
            guessedLetters.add(userGuess);
            if (checkGameLoss()) {
                System.out.println("You lost! The correct word is: " + wordToGuess);
                System.exit(0);
            }
            else {
                play();
            }
        }
    }

    public static void run() {
        splitWordIntoArray();
        makeUnderscores();
        play();
    }

    public static void main(String[] args) {
        run();
    }
}
