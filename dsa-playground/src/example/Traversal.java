package example;

public abstract class Traversal {
    public int[] traverseAndRetrieveValues(BinarySearchTree binarySearchTree) {
        BinarySearchTree.TreeNode root = binarySearchTree.getRoot();

        int[] treeElements = new int[binarySearchTree.getSize()];

        traverseMethod(root, treeElements, new MutableInteger(0));

        return treeElements;
    }

    public abstract void traverseMethod(BinarySearchTree.TreeNode node, int[] treeElements, MutableInteger insertIndex);

    public class MutableInteger {
        private int value;

        public MutableInteger(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        public int postfixIncrement() {
            return this.value++;
        }

        public int postfixDecrement() {
            return this.value--;
        }
    }

    public static class InorderDFS extends Traversal {
        @Override
        public void traverseMethod(BinarySearchTree.TreeNode node, int[] treeElements, MutableInteger insertIndex) {
            if (node == null) {
                return;
            }

            treeElements[insertIndex.postfixIncrement()] = node.getValue();
            traverseMethod(node.getLeft(), treeElements, insertIndex);
            traverseMethod(node.getRight(), treeElements, insertIndex);
        }
    }

    public static class PreorderDFS extends Traversal {
        @Override
        public void traverseMethod(BinarySearchTree.TreeNode node, int[] treeElements, MutableInteger insertIndex) {
            if (node == null) {
                return;
            }

            traverseMethod(node.getLeft(), treeElements, insertIndex);
            treeElements[insertIndex.postfixIncrement()] = node.getValue();
            traverseMethod(node.getRight(), treeElements, insertIndex);
        }
    }

    public static class PostorderDFS extends Traversal {
        @Override
        public void traverseMethod(BinarySearchTree.TreeNode node, int[] treeElements, MutableInteger insertIndex) {
            if (node == null) {
                return;
            }

            traverseMethod(node.getLeft(), treeElements, insertIndex);
            traverseMethod(node.getRight(), treeElements, insertIndex);
            treeElements[insertIndex.postfixIncrement()] = node.getValue();
        }
    }
}
