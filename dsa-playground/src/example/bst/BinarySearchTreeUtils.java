package example.bst;

public class BinarySearchTreeUtils {

    public static int[] inorderDFS(BinarySearchTree binarySearchTree) {
        BinarySearchTree.TreeNode root = binarySearchTree.getRoot();

        int[] treeElements = new int[binarySearchTree.getSize()];

        int i = 0;
        recursiveInorderDFS(root, treeElements, i);

        return treeElements;
    }

    private static void recursiveInorderDFS(BinarySearchTree.TreeNode node, int[] treeElements, int i) {
        if (node == null) {
            return;
        }

        treeElements[i] = node.getValue();
        recursiveInorderDFS(node.getLeft(), treeElements, i + 1);
        recursiveInorderDFS(node.getRight(), treeElements, i + 1);
    }
}
