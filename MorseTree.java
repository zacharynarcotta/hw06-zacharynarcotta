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
}