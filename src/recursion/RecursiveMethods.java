package recursion;
import java.util.Scanner;

public class RecursiveMethods {
    /*
    * A recursive method is a method that references itself (calls itself)
    * A recursive method must have a base case (terminal case) that is the final call to the method
    * Otherwise a StackOverflow error occurs
    * The cases of recursion are generally handled using if-else or switch statements
    * If the base case is met, recursion is over
    * Else, call the recursive method again
     */
    static Scanner scan = new Scanner(System.in);
    private static int num;

    //Method that plays higher-lower game using binary search
    public static void binaryGuess(int high, int low) {
        int midpoint = (high + low) / 2;
        System.out.println(midpoint);
        if (num != midpoint) {
            if (num < midpoint) {
                binaryGuess(midpoint, low);
            }
            else if (num > midpoint) {
                binaryGuess(high, midpoint + 1);
            }
        }
        else {
            System.out.println("Found");
        }
    }

    //Method that prints numbers from n to 1
    public static void printNums(int num) {
        if (num == 1) {
            System.out.print(1 + " ");
        }
        else {
            System.out.print(num + " ");
            printNums(num - 1);
        }
    }

    //Method that returns the sum of all integers from 1 to n
    public static int sum(int num) {
        if (num == 1) {
            return 1;
        }
        else {
            return num + sum(num - 1);
        }
    }

    public static void reverse(String str) {
        if (str.length() < 2) {
            System.out.println(str);
        }
        else {
            System.out.println(str.charAt(str.length() - 1));
            reverse(str.substring(0, str.length() - 1));
        }
    }

    public static void main(String[] args) {
        System.out.println(sum(5));
    }
}
