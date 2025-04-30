import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MorseTree {
    public TreeNode<Character> root;

    // Default constructor for NULL root
    public MorseTree() {
        root = new TreeNode<Character>(null);
    }

    public void preorder(TreeNode<Character> node) {
        // BASE CASE
        if(node == null) return;

        // RECURSIVE CASES
        if(node.getElement() != null) System.out.print(node.getElement() + " "); // Prevent root from being printed
        preorder(node.getLeft());
        preorder(node.getRight());
    }

    public void postorder(TreeNode<Character> node) {
        // BASE CASE
        if(node == null) return;

        // RECURSIVE CASES
        postorder(node.getLeft());
        postorder(node.getRight());
        if(node.getElement() != null) System.out.print(node.getElement() + " "); 
    }

    // Eng to Morse
    public String engToMorse(String toTranslate) {
        String translated = "";
        toTranslate = toTranslate.toLowerCase();

        for(int i = 0; i < toTranslate.length(); i++) {
            char letter = toTranslate.charAt(i);
            if(letter != ' ') {
                try (Scanner scanner = new Scanner(new File("morsecode.txt"))) {
                    while(scanner.hasNextLine()) {
                        String line = scanner.nextLine();
                        char check = line.charAt(0);
                        if(check == letter) { // The line we are looking at is the correct letter.
                            for(int j = 1; j < line.length(); j++) {
                                translated += line.charAt(j); // Add all characters that are not the English letter.
                            }
                            break;
                        }
                    }
                }
                catch (FileNotFoundException ex) {
                    System.out.println("No file with name \"morsecode.txt\"!");
                }

                translated += " |"; // Add the pipe once we are done adding the o and -.
            }
        }

        return translated;
    }

    // Morse to Eng
    public String morseToEng(String toTranslate) {
        TreeNode<Character> node = root;
        String translated = "";
        for(int i = 0; i < toTranslate.length(); i++) {
            if(toTranslate.charAt(i) == 'o') {
                node = node.getLeft();
            }
            else if(toTranslate.charAt(i) == '-') {
                node = node.getRight();
            }
            else if(toTranslate.charAt(i) == '|') {
                // If we reach the pipe character, our letter has ended.
                translated += node.getElement(); 
                
                // To move on to the next letter, we must go back to the top of the Tree.
                node = root;
            }
        }

        return translated;
    }
}