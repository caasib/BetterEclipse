package recursion;
import java.util.Arrays;
import java.util.Random;

public class Warmups {
    public static double sumSeries(int num) {
        if (num == 1) {
            return num;
        }
        else {
            return (double)1/num + sumSeries(num - 1);
        }
    }

    public static double sumSeries2(int num) {
        if (num == 1) {
            return (double)1/3;
        }
        else {
            return (double)num/(2 * num + 1) + sumSeries2(num - 1);
        }
    }

    public static int count(String str, String target) {
        if (str.indexOf(target) != -1) {
            return 1 + count(str.substring(str.indexOf(target) + 1), target);
        }
        else {
            return 0;
        }
    }

    public static int sumDigits(int num) {
        if (num == 0) {
            return 0;
        }
        else {
            return (num % 10 + sumDigits(num/10));
        }
    }

    public static int largestInt(int[] array, int max, int index) {
        if (index == array.length - 1) {
            return Math.max(max, array[index]);
        }
        else {
            max = Math.max(max, array[index]);
            return largestInt(array, max, index + 1);
        }
    }

    public static void main(String[] args) {
        Random rand = new Random();
        int[] intArr = new int[25];
        for (int i = 0; i < intArr.length; i++) {
            intArr[i] = rand.nextInt(100);
        }
        System.out.println(Arrays.toString(intArr));
        System.out.println(largestInt(intArr, 0, 0));
    }
}
