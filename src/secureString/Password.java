package secureString;
import java.util.Random;

public class Password implements SecureString {
    private String[][] vigTable = new String[70][70];
    private String base = "!@#$%^&*1234567890abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private String key = "ie@ZxX#snoq4hU%^!DTp!2*";
    private Random rand = new Random(10);

    public void fillVigTable() {
        for (int i = 0; i < 70; i++) {
            for (int j = 0; j < 70; j++) {
                vigTable[i][j] = base.substring(j) + base.substring(0, j);
            }
        }
    }

    @Override
    public String digitize(String password) {
        String digital = "";
        int rNum = rand.nextInt(100);
        for (int i = 0; i < password.length(); i++) {
            if (rNum <= 50) {
                digital += (password.charAt(i) + 2023);
            }
            else {
                digital += (password.charAt(i) - 600);
            }
            rNum = rand.nextInt(100);
        }
        return digital;
    }

    @Override
    public String decryptDigitize(String digitalPassword) {
        String original = "";
        rand.setSeed(10);
        int rNum = rand.nextInt(100);
        for (int i = 0; i < digitalPassword.length(); i++) {
            if (rNum <= 50) {
                original += (char)(digitalPassword.charAt(i) - 2023);
            }
            else {
                original += (char)(digitalPassword.charAt(i) + 600);
            }
        }
        return original;
    }

    @Override
    public String encryptString(String password) {
        String encrypted = "";
        String editedKey = key.substring(0, password.length());
        int baseIndex, keyIndex;
        for (int i = password.length() - 1; i > 0; i--) {
            baseIndex = base.indexOf(password.charAt(i));
            keyIndex = base.indexOf(editedKey.charAt(i));
            encrypted += vigTable[baseIndex][keyIndex];
        }
        return encrypted;
    }

    @Override
    public String decryptString(String encryptedPassword) {
        String decrypted = "";
        String editedKey = key.substring(0, encryptedPassword.length());
        int keyIndex, encryptIndex;
        for (int i = 0; i < encryptedPassword.length(); i++) {
            keyIndex = base.indexOf(editedKey.charAt(i));
            encryptIndex = base.indexOf(encryptedPassword.charAt(i));
            decrypted += vigTable[keyIndex][encryptIndex];
        }
        return decrypted;
    }

    public static void main(String[] args) {
        Password pass = new Password();
        String digit = pass.digitize("apple");
        String undigit = pass.decryptDigitize(digit);
        String encrypty = pass.encryptString("apple");
        String decrypty = pass.decryptString(encrypty);
        System.out.println(digit);
        System.out.println(undigit);
        System.out.println(encrypty);
        System.out.println(decrypty);
    }
}
