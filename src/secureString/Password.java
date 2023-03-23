package secureString;
import java.util.*;

public class Password implements SecureString {
    Random rand = new Random();
    int[] primes = {7919, 6197, 4639, 5333, 7793};
    int prime = primes[rand.nextInt(primes.length)];
    int base = 3;
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

        return null;
    }

    @Override
    public String decryptString(String password) {
        return null;
    }

    public static void main(String[] args) {
        Password pass = new Password();
        String bruh = pass.digitize("hypertension");
        System.out.println(bruh);
        System.out.println(pass.decryptDigitize(bruh));
    }
}
