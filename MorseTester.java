import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MorseTester {
    // insert rules:
    // ROOT IS NONE, simple a starting point
    // if a character is represented by a dot (o), left descendant
    // if a character is represented by a dash (-), right descendant
    // if a character is one symbol, it will be one level below root
    // represented by N symbols, N levels below root

    public static void main(String[] args) {
        MorseTree tree = new MorseTree();
        
        // Try-Catch and Scanner functionality researched online; W3Schools, Java documentation, 12 year old StackOverflow forums <-- the best
        try (Scanner scanner = new Scanner(new File("morsecode.txt"))) {
            while(scanner.hasNext()) {
                System.out.println(scanner.next()); // look at all characters one by one
            }
        }
        catch (FileNotFoundException ex) {
            System.out.println("No file with name \"morsecode.txt\"!");
        }
    }
}
