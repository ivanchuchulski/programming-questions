package example.bst;

public class BinarySearchTree {
    private TreeNode root;
    private int size;

    public BinarySearchTree(int rootValue) {
        root = new TreeNode(rootValue);
        size = 1;
    }

    public BinarySearchTree() {
        size = 0;
    }

    public TreeNode getRoot() {
        return root;
    }

    public int getSize() {
        return size;
    }

    public boolean contains(int value) {
        return containsRecursive(root, value);
    }

    public void insert(int value) {
        if (size == 0) {
            root = new TreeNode(value);
            size++;
        } else {
            insertRecursive(root, value);
        }
    }

    private TreeNode insertRecursive(TreeNode treenode, int value) {
        if (treenode == null) {
            size++;
            return new TreeNode(value);
        }

        if (treenode.value == value) {
            return treenode;
        }

        if (value < treenode.value) {
            treenode.left = insertRecursive(treenode.left, value);
        } else {
            treenode.right = insertRecursive(treenode.right, value);
        }

        return treenode;
    }


    private boolean containsRecursive(TreeNode node, int value) {
        if (node == null) {
            return false;
        }

        if (node.value == value) {
            return true;
        } else if (value < node.value) {
            return containsRecursive(node.left, value);
        } else {
            return containsRecursive(node.right, value);
        }
    }

    public class TreeNode {
        private int value;
        private TreeNode left;
        private TreeNode right;

        public TreeNode(int value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }

        public int getValue() {
            return value;
        }

        public TreeNode getLeft() {
            return left;
        }

        public TreeNode getRight() {
            return right;
        }
    }
}
