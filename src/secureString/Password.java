package secureString;

public class Password implements SecureString {
    private String[][] vigTable = new String[70][70];
    private String base = "!@#$%^&*1234567890abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private String key = "ie@ZxX#snoq4hU%^!DTp!2*";

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
        for (int i = 0; i < password.length(); i++) {
            digital += (Math.pow(password.charAt(i), 7) + 2023) / 5;
        }
        return digital;
    }

    @Override
    public String decryptDigitize(String digitalPassword) {
        String original = "";
        for (int i = 0; i < digitalPassword.length(); i++) {
            original += Math.pow(((digitalPassword.charAt(i) * 5) - 2023), (double)1/7);
        }
        return original;
    }

    @Override
    public String encryptString(String password) {
        String encrypted = "";
        String editedKey = key.substring(0, password.length());
        int baseIndex, keyIndex;
        for (int i = password.length(); i > 0; i--) {
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
}
