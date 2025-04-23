public class MorseTree {
    public TreeNode<String> root;

    // Default constructor for NULL root
    public MorseTree() {
        root = null;
    }

    public String preOrder(String out, TreeNode<String> node){ // Self -> Left -> Right
        if (node.getLeft() == null && node.getRight() == null){
            return node.getElement().toString();
        }
        else if (node.getLeft() != null && node.getRight() == null){
            return node.getElement().toString() + " " + preOrder(out, node.getLeft());
        }
        else if (node.getLeft() == null && node.getRight() != null){
            return node.getElement().toString() + " " + preOrder(out, node.getRight());
        }
        else{
            return node.getElement().toString() + " " +
            preOrder(out, node.getLeft()) + " " +
            preOrder(out, node.getRight());
        }
    }
    public String postOrder(String out, TreeNode<String> node){ // Left -> Right -> Self
        if (node.getLeft() == null && node.getRight() == null){
            return node.getElement().toString();
        }
        else if (node.getLeft() != null && node.getRight() == null){
            return postOrder(out, node.getLeft()) + " " + node.getElement().toString();
        }
        else if (node.getLeft() == null && node.getRight() != null){
            return postOrder(out, node.getRight()) + " " + node.getElement().toString();
        }
        else{
            return preOrder(out, node.getLeft()) + " " +
            preOrder(out, node.getRight()) + " " + 
            node.getElement().toString();
        }
    }
}