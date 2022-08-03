package example;

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
