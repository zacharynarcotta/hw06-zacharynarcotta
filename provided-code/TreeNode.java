public class TreeNode<T> {
    private T element;

    // TreeNode references (containing: memory address, name).
    private TreeNode<T> left; 
    private TreeNode<T> right;

    // O(1)
    public TreeNode(T element) {
        this.element = element;
    }

    // All accessors are O(1). 
    public T getElement() {
        return element;
    }
    public TreeNode<T> getLeft() {
        return left;
    }
    public TreeNode<T> getRight() {
        return right;
    }

    // All modifiers are O(1).
    public void setElement(T element) {
        this.element = element;
    }
    public void setLeft(TreeNode<T> left) {
        this.left = left;
    }
    public void setRight(TreeNode<T> right) {
        this.right = right;
    }

    // All print orders are O(n).
    public void preorder(TreeNode<T> node) {
        // BASE CASE
        if(node == null) return;

        // RECURSIVE CASES
        System.out.println(node.getElement() + " ");
        preorder(node.getLeft());
        preorder(node.getRight());
    }
    public void inorder(TreeNode<T> node) {
        // BASE CASE
        if(node == null) return;

        // RECURSIVE CASES
        inorder(node.getLeft());
        System.out.println(node.getElement() + " ");
        inorder(node.getRight());
    }
    public void postorder(TreeNode<T> node) {
        // BASE CASE
        if(node == null) return;

        // RECURSIVE CASES
        postorder(node.getLeft());
        postorder(node.getRight());
        System.out.println(node.getElement() + " ");
    }

    // O(n) ; Optimized time complexity.
    public int height() { // Returns the height of a TreeNode.
        if(left == null && right == null) {
            return 0;
        }
        else if(left != null && right == null) {
            return 1 + this.getLeft().height();
        }
        else if(left == null && right != null) {
            return 1 + this.getRight().height();
        }
        else {
            return 1 + Math.max(this.getLeft().height(), this.getRight().height());
        }
    }

    public boolean isBalanced() {
        if(left == null && right == null) {
            return true;
        }
        else if(left != null && right == null) {
            // return Math.abs(this.getLeft().height()) < 1;
            return this.getLeft().height() == 0;
        }
        else if(left == null && right != null) {
            // return Math.abs(this.getRight().height()) < 1;
            return this.getRight().height() == 0;
        }
        else {
            return Math.abs(this.getLeft().height() - this.getRight().height()) <= 1;
        }
    }

    // O(n)
    public boolean isIn(T target) { // Search our Tree for a specific target.
        // BASE CASES
        if(this.getElement().equals(target)) return true;
        else if(this.getLeft() == null && this.getRight() == null) return false;

        // RECURSIVE CASES
        else {
            if(this.getLeft() != null && this.getRight() != null) return this.getLeft().isIn(target) || this.getRight().isIn(target);
            else if(this.getLeft() != null && this.getRight() == null) return this.getLeft().isIn(target);
            else if(this.getLeft() == null && this.getRight() != null) return this.getRight().isIn(target);
            else return false; // Technically, this line is redundant, but effective for demonstrative purposes.
        }
    }

    public void insertLeft(T element) {
        if(this.getLeft() == null) {
            this.setLeft(new TreeNode<T>(element));
        }
        else {
            System.out.println("Cannot insert to left");
        }
    }
    public void insertRight(T element) {
        if(this.getRight() == null) {
            this.setRight(new TreeNode<T>(element));
        }
        else {
            System.out.println("Cannot insert to right");
        }
    }

    // Best case: O(1)
    // Worst case: O(n log(n))
    public void balancedInsert(T element) {
        // BASE CASES
        if(this.getLeft() == null) {
            this.setLeft(new TreeNode<T>(element));
        }
        else if(this.getRight() == null) {
            this.setRight(new TreeNode<T>(element));
        }

        // RECURSIVE CASES
        else {
            if(this.getLeft().height() <= this.getRight().height()) {
                this.getLeft().balancedInsert(element);
            }
            else {
                this.getRight().balancedInsert(element);
            }
        }
    }

    // Best case: O(1)
    // Worst case: O(n)
    public void lossyRemoval(T element) { // here, we are pruning, not actually removing
        // BASE CASES
        if(this.getLeft().getElement().equals(element)) {
            this.setLeft(left);
        }
        else if(this.getRight().getElement().equals(element)) {
            this.setRight(null);
        }
        
        // RECURSIVE CASE
        else {
            this.getLeft().lossyRemoval(element);
            this.getRight().lossyRemoval(element);
        }
    }

    @Override
    public String toString() {
        return element.toString();
    }
}