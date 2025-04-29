public class MorseTree {
    public TreeNode<String> root;

    // Default constructor for NULL root
    public MorseTree() {
        root = null;
    }

    public void preorder(TreeNode<String> node) {
        // BASE CASE
        if(node == null) return;

        // RECURSIVE CASES
        System.out.println(node.getElement() + " ");
        preorder(node.getLeft());
        preorder(node.getRight());
    }

    public void postorder(TreeNode<String> node) {
        // BASE CASE
        if(node == null) return;

        // RECURSIVE CASES
        postorder(node.getLeft());
        postorder(node.getRight());
        System.out.println(node.getElement() + " ");
    }
}