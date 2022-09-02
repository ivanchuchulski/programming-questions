class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    public int maxDepth(TreeNode root) {
        return calculateDepth(root);

    }

    private int calculateDepth(TreeNode node) {
        if (node == null) {
            return 0;
        }

        return 1 + Math.max(calculateDepth(node.left), calculateDepth(node.right));
    }
}
