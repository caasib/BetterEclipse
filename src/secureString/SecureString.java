package secureString;

public interface SecureString {
    //Write an algorithm that returns a digital representation of a string
    //DO NOT USE A SIMPLE CAESAR CIPHER or other basic ENCRYPTION algorithm
    public String digitize(String password);

    //Write an algorithm that processes a digitized String and returns a String

    public String decryptDigitize(String digitalPassword);

    //Write your version of encrypting a String
    public String encryptString(String password);

    //Write your version of decrypting a String
    public String decryptString(String encryptedPassword);
}
