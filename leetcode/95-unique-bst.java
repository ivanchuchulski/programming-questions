import java.util.List;
import java.util.Queue;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Set;
import java.util.HashSet;

class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    TreeNode(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }

    @Override
    public String toString() {
        return new String(Integer.toString(val));
    }
}

class BST {
    private TreeNode root;

    public BST(int root_val) {
        root = new TreeNode(root_val);
    }

    public TreeNode getRoot() {
        return root;
    }

    public void insertval(int val) {
        insertAtRoot(root, val);
    }

    // can't really be a proper use for BST, because even though trees have the same nodes, 
    // the super equals comparrison return false
    // so we comment it out for now
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }
        // if (!super.equals(object)) {
        //     return false;
        // }

        BST bst = (BST) object;

        return Utils.serializeWithBFS(this).equals(Utils.serializeWithBFS(bst));
        // return Utils.isSameTree(this.getRoot(), bst.getRoot());
    }

    public int hashCode() {
        return (Utils.serializeWithBFS(this)).hashCode();
    }

    private TreeNode insertAtRoot(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }

        if (val < root.val) {
            root.left = insertAtRoot(root.left, val);
        } else {
            root.right = insertAtRoot(root.right, val);
        }

        return root;
    }
}

class Utils {
    public static void bfs(BST bst) {
        Queue<TreeNode> que = new LinkedList<>();
        que.add(bst.getRoot());

        while (!que.isEmpty()) {
            TreeNode current = que.poll();

            System.out.print(current.val +  " ");

            if (current.left != null) {
                que.add(current.left);
            }

            if (current.right != null) {
                que.add(current.right);
            }
        }

        System.out.println();
    }

    public static boolean isSameTree(TreeNode left, TreeNode right) {
        Queue<TreeNode> leftQue = new LinkedList<>();
        Queue<TreeNode> rightQue = new LinkedList<>();

        leftQue.add(left);
        rightQue.add(right);

        while (!leftQue.isEmpty() && !rightQue.isEmpty()) {
            TreeNode curr1 = leftQue.poll();
            TreeNode curr2 = rightQue.poll();

            if (curr1.val != curr2.val) {
                return false;
            }

            if (curr1.left != null) {
                leftQue.add(curr1.left);
            }

            if (curr1.right != null) {
                leftQue.add(curr1.right);
            } 

            if (curr2.left != null) {
                rightQue.add(curr2.left);
            }

            if (curr2.right != null) {
                rightQue.add(curr2.right);
            }
        }

        return leftQue.isEmpty() && rightQue.isEmpty();
    }

    public static List<Integer> serializeWithBFS(BST bst) {
        Queue<TreeNode> que = new LinkedList<>();
        List<Integer> serialized = new ArrayList<>();

        que.add(bst.getRoot());
        while (!que.isEmpty()) {
            TreeNode current = que.poll();

            serialized.add(current.val);

            if (current.left != null) {
                que.add(current.left);
            }

            if (current.right != null) {
                que.add(current.right);
            }
        }

        return serialized;
    }
}

/* leetcode 95-unique-bst */
class Solution {
    public List<List<TreeNode>> generateTrees(int n) {
        List<Integer> nums = new ArrayList<>(n);
        for(int i = 0; i < n; i++) {
            nums.add(i + 1);
        }

        Set<List<Integer>> arrs = generatePermutations(nums);
        Set<BST> trees = generateTrees(arrs);

        System.out.println(trees.size());
        trees.forEach(t -> System.out.println(Utils.serializeWithBFS(t) + ", " +  t.hashCode()));

        return serializeNodes(trees);
    }

    private Set<List<Integer>> generatePermutations(List<Integer> nums) {
        Set<List<Integer>> arrs = new HashSet<>();

        heapPermutation(nums, nums.size(), arrs);

        return arrs;
    }

    private void heapPermutation(List<Integer> nums, int k, Set<List<Integer>> arrs) {
        if (k == 1) {
            arrs.add(new ArrayList<>(nums));
        } else {
            heapPermutation(nums, k - 1, arrs);

            for (int i = 0; i < k - 1; i++) {
                if (k % 2 == 0) {
                    Collections.swap(nums, i, k - 1);
                } else {
                    Collections.swap(nums, 0, k - 1);
                }
                heapPermutation(nums, k - 1, arrs);
            }
        }
    }

    private Set<BST> generateTrees(Set<List<Integer>> arrs) {
        Set<BST> trees = new HashSet<>();

        for (var arr : arrs) {
            BST currentBst = new BST(arr.get(0));
            for (int i = 1; i < arr.size(); i++) {
                currentBst.insertval(arr.get(i));
            }

            trees.add(currentBst);
        }

        return trees;
    }

    private List<List<TreeNode>> serializeNodes(Set<BST> trees) {
        List<List<TreeNode>> serTrees = new ArrayList<>();

        for (var t : trees) {
            List<TreeNode> currentList = new LinkedList<>();

            Queue<TreeNode> que = new LinkedList<>();
            que.add(t.getRoot());
            while (!que.isEmpty()) {
                TreeNode current = que.poll();

                currentList.add(current);

                if (current.left != null) {
                    que.add(current.left);
                }

                if (current.right != null) {
                    que.add(current.right);
                }
            }

            serTrees.add(currentList);
        }

        return serTrees;
    }
}

public class Main {
    public static void main(String[] args) {
        BST bst = new BST(2);
        bst.insertval(3);
        bst.insertval(1);

        BST bst1 = new BST(2);
        bst1.insertval(3);
        bst1.insertval(1);

        System.out.println("test test");
        Solution sol = new Solution();
        Utils.bfs(bst);
        var ser = sol.generateTrees(3);

        ser.forEach(s -> System.out.println(s.toString()));
    }
}
