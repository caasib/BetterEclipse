package secureString;
import java.util.*;

public class Password implements SecureString {
    Random rand = new Random();
    static Scanner scan = new Scanner(System.in);
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
            if (!Character.isDigit(password.charAt(i))) {
                int num = (int) Math.pow(base, (password.charAt(i) - 100)) % prime;
                digitalDecrypt.put(num, String.valueOf(password.charAt(i)));
                digitalEncrypt.add(num);
                encrypted += num;
            }
            else {
                int num = (int)(Math.pow(base, password.charAt(i) - 50) % prime) + password.charAt(i);
                digitalDecrypt.put(num, String.valueOf(password.charAt(i)));
                digitalEncrypt.add(num);
                encrypted += num;
            }
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
        System.out.println("Please input a password: ");
        String userPass = scan.next();
        String digitizePass = pass.digitize(userPass);
        String encryptPass = pass.encryptString(userPass);
        System.out.println("Encrypted digital password: " + digitizePass);
        System.out.println("Decrypted digital password: " + pass.decryptDigitize(digitizePass));
        System.out.println("Encrypted string password: " + encryptPass);
        System.out.println("Decrypted string password: " + pass.decryptString(encryptPass));
    }
}