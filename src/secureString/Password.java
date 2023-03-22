package secureString;
import java.util.*;

public class Password implements SecureString {
    ArrayList<Integer> encryptDigit = new ArrayList<>();
    int prime = 19;
    int prm = 2;
    int base;
    Random rand = new Random();

    @Override
    public String digitize(String password) {
        String encrypted = "";
        for (int i = 0; i < password.length(); i++) {
            int num = (int)Math.pow(prm, password.charAt(i) - 96) % prime;
            encryptDigit.add(num);
            encrypted += num;
        }
        return encrypted;
    }

    @Override
    public String decryptDigitize(String password) {
        String decrypted = "";
        int randInt = rand.nextInt(prime);
        for (int i = 0; i < encryptDigit.size(); i++) {
            int num = (int)Math.pow(encryptDigit.get(i), randInt) % prime;
            System.out.println(num);
            decrypted += (char)(num + 96);
        }
        return decrypted;
    }

    @Override
    public String encryptString(String password) {
        return null;
    }

    @Override
    public String decryptString(String password) {
        return null;
    }

    public static void main(String[] args) {
        Password pass = new Password();
        String bruh = pass.digitize("apple");
        System.out.println(bruh);
        System.out.println(pass.encryptDigit);
        System.out.println(pass.decryptDigitize(bruh));
    }
}
