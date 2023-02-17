package zyLabs;

public class BalancedNumber {
    static int count = 0;

    public static boolean isEven(int num) {
        return num % 2 == 0;
    }

    public static boolean evenCheck(int number) {
        boolean valid = false;
        int evens = 0;
        int odds = 0;
        int evenSum = 0;
        int oddSum = 0;
        while (number > 0) {
            if (isEven(number % 10)) {
                evens += 1;
                evenSum += number % 10;
            }
            else {
                odds += 1;
                oddSum += number % 10;
            }
            number /= 10;
        }
        if ((evens == odds) && (evenSum == oddSum)) {
            valid = true;
        }
        return valid;
    }

    public static boolean oddCheck(int number) {
        boolean valid = false;
        int evenSum = 0;
        int oddSum = 0;
        while (number > 0) {
            if (isEven(number % 10)) {
                evenSum += number % 10;
            }
            else {
                oddSum += number % 10;
            }
            number /= 10;
        }
        if (evenSum == oddSum) {
            valid = true;
        }
        return valid;
    }

    public static void main(String[] args){
        /*
         * Complete the program as described. You may use as many (or as few) methods as
         * you desire. Your program should output a single value
         */
        for (int i = 100; i < 100000001; i++) {
            int numDigits = (int)(Math.log10(i) + 1);
            if (isEven(numDigits)) {
                if (evenCheck(i)) {
                    count++;
                }
            }
            else {
                if (oddCheck(i)) {
                    count++;
                }
            }
        }
        System.out.println(count);
    }
}