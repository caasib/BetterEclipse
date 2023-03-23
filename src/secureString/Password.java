package secureString;
import java.util.*;

public class Password implements SecureString {
    Random rand = new Random();
    int[] primes = {7919, 6197, 4639, 5333, 7793};
    String[] words = {"lemon", "game", "elephant", "werewolf", "image"};
    String word = words[rand.nextInt(words.length)];
    int prime = primes[rand.nextInt(primes.length)];
    int base = rand.nextInt(1) + 2;
    String alphabet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#$%^&*";
    ArrayList<Integer> digitalEncrypt = new ArrayList<>();
    HashMap<Integer, String> digitalDecrypt = new HashMap<>();

    @Override
    public String digitize(String password) {
        String encrypted = "";
        for (int i = 0; i < password.length(); i++) {
            int num = (int)Math.pow(base, (password.charAt(i) - 100)) % prime;
            digitalDecrypt.put(num, String.valueOf(password.charAt(i)));
            digitalEncrypt.add(num);
            encrypted += num;
        }
        return encrypted;
    }

    @Override
    public String decryptDigitize(String password) {
        String decrypted = "";
        for (int i = 0; i < digitalEncrypt.size(); i++) {
            decrypted += digitalDecrypt.get(digitalEncrypt.get(i));
        }
        return decrypted;
    }

    @Override
    public String encryptString(String password) {
        String encrypted = "";
        if (word.length() < password.length()) {
            while (word.length() < password.length()) {
                word += word;
            }
        }
        for (int i = 0; i < password.length(); i++) {
            String newAlpha = alphabet.substring(alphabet.indexOf(word.charAt(i))) + alphabet.substring(0, alphabet.indexOf(word.charAt(i)));
            //System.out.println(newAlpha);
            encrypted += newAlpha.charAt(alphabet.indexOf(password.charAt(i)));
        }
        return encrypted;
    }

    @Override
    public String decryptString(String password) {
        String decrypted = "";
        for (int i = 0; i < password.length(); i++) {
            String newAlpha = alphabet.substring(alphabet.indexOf(word.charAt(i))) + alphabet.substring(0, alphabet.indexOf(word.charAt(i)));
            decrypted += alphabet.charAt(newAlpha.indexOf(password.charAt(i)));
        }
        return decrypted;
    }

    public static void main(String[] args) {
        Password pass = new Password();
        String bruh = pass.encryptString("hypertension");
        System.out.println(bruh);
        System.out.println(pass.decryptString(bruh));
    }
}
