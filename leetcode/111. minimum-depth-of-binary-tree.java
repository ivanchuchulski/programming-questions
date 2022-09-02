// 111. Minimum Depth of Binary Tree

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
    public int minDepth(TreeNode root) {
        if (root == null) { return 0; }
        int left = root.left != null ? nearestLeaf(root.left) : Integer.MAX_VALUE;
        int right = root.right != null ? nearestLeaf(root.right) : Integer.MAX_VALUE;
        
        if (root.left == null && root.right == null) { return 1; }
        return Math.min(left, right) + 1;
    }
    
    private int nearestLeaf(TreeNode node) {
        if (node == null) {
            return Integer.MAX_VALUE;
        }

        if (node.left == null && node.right == null) {
            return 1;
        }

        return Math.min(nearestLeaf(node.left), nearestLeaf(node.right)) + 1;
    }
}