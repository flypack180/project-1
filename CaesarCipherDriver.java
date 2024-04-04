import java.util.Random;
import java.util.Scanner;

/**
 * CaesarCipherDriver
 * Name: Carson Steinbach
 */
public class CaesarCipherDriver {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random;


        System.out.println("Welcome to the Cipher program.");


        System.out.println("Enter a string of exactly twelve characters you want to encrypt:");
        String plaintext = scanner.nextLine();


        if (plaintext.length() != 12) {
            System.out.println("Please read directions and rerun it again!");
            return;
        }


        System.out.println("Enter a seed value for random number generation:");
        int seed = scanner.nextInt();
        random = new Random(seed);


        int[] key = new int[12];
        System.out.print("Key: ");
        for (int i = 0; i < key.length; i++) {
            key[i] = random.nextInt(26);
            System.out.print(key[i] + " ");
        }
        System.out.println();


        StringBuilder ciphertext = new StringBuilder();
        for (int i = 0; i < plaintext.length(); i++) {
            char c = plaintext.charAt(i);
            int encodedValue = ((c - 'A' + key[i]) % 26) + 'A';
            if (encodedValue > 'Z') {
                encodedValue += 46;
            }
            ciphertext.append((char) encodedValue);
        }


        System.out.println("Ciphertext: " + ciphertext.toString());
    }
}
