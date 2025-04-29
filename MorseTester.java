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
            while(scanner.hasNextLine()) {
                String next = scanner.nextLine();
                TreeNode<Character> toInsert = tree.root;
                char letter = next.charAt(0);
                int lineLength = next.length();

                // Build the Tree.
                for(int i = 0; i < lineLength; i++) {
                    if(next.charAt(i) == 'o') {
                        if(toInsert.getLeft() != null) {
                            toInsert = toInsert.getLeft();
                        }
                        else { 
                            toInsert.setLeft(new TreeNode<Character>(letter));
                        }
                    }
                    else if(next.charAt(i) == '-') {
                        if(toInsert.getRight() != null) {
                            toInsert = toInsert.getRight();
                        }
                        else { 
                            toInsert.setRight(new TreeNode<Character>(letter));
                        }
                    }
                }
            }
            tree.preorder(tree.root);
            System.out.println();
            tree.postorder(tree.root);
        }
        catch (FileNotFoundException ex) {
            System.out.println("No file with name \"morsecode.txt\"!");
        }


    }
}
