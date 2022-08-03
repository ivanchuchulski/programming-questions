package example;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

class BinarySearchTreeTest {
    @Test
    void testAddingElementsInsertsThemInTheCorrectOrder() {
        int[] values = new int[]{3, 1, 5, 4, 9};
        BinarySearchTree binarySearchTree = insertArrayValuesInTree(values);

        int[] traversedValues = new Traversal.PreorderDFS().traverseAndRetrieveValues(binarySearchTree);
        Arrays.sort(values);

        assertEquals(values.length, binarySearchTree.getSize());
        assertArrayEquals(values, traversedValues);
    }

    @Test
    void testAddingElementsInsertsThemInTheCorrectOrder2() {
        int[] values = new int[]{3, 1, 5, 4, 9};
        BinarySearchTree binarySearchTree = insertArrayValuesInTree(values);

        Arrays.sort(values);

        for (int i = 0; i < values.length / 2; ++i) {
            int temp = values[i];
            values[i] = values[values.length - i - 1];
            values[values.length - i - 1] = temp;
        }

        int[] traversedValues = new Traversal.PostorderDFS().traverseAndRetrieveValues(binarySearchTree);

        System.out.println(Arrays.toString(traversedValues));

        assertEquals(values.length, binarySearchTree.getSize());
        assertArrayEquals(values, traversedValues);
    }

    @Test
    void testCopyTreeWithPreorderTraversal() {
        int[] values = new int[]{1, 9, 5, 3, 11, -3, -5};
        BinarySearchTree binarySearchTree = insertArrayValuesInTree(values);

        int[] traversedValues = new Traversal.InorderDFS().traverseAndRetrieveValues(binarySearchTree);

        BinarySearchTree copiedBST = insertArrayValuesInTree(traversedValues);
        int[] copiedTreeTraversedValues = new Traversal.InorderDFS().traverseAndRetrieveValues(copiedBST);

        assertArrayEquals(traversedValues, copiedTreeTraversedValues);
    }

    private static BinarySearchTree insertArrayValuesInTree(int[] values) {
        BinarySearchTree binarySearchTree = new BinarySearchTree(values[0]);

        for (int i = 1; i < values.length; i++) {
            binarySearchTree.insert(values[i]);
        }

        return binarySearchTree;
    }
}