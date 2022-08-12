package example;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class BinarySearchTreeTest {
    @Test
    void testAddingElementsInsertsThemInTheCorrectOrder() {
        int[] values = new int[]{3, 1, 5, 4, 9};
        BinarySearchTree binarySearchTree = insertArrayValuesInTree(values);

        int[] traversedValues = new Traversal.InorderDFS().traverseAndRetrieveValues(binarySearchTree);
        Arrays.sort(values);

        assertEquals(values.length, binarySearchTree.getSize());
        assertArrayEquals(values, traversedValues);
    }

    @Test
    void testCopyTreeWithPreorderTraversal() {
        int[] values = new int[]{1, 9, 5, 3, 11, -3, -5};
        BinarySearchTree binarySearchTree = insertArrayValuesInTree(values);

        int[] traversedValuesForCopying = new Traversal.PreorderDFS().traverseAndRetrieveValues(binarySearchTree);

        BinarySearchTree copiedBST = insertArrayValuesInTree(traversedValuesForCopying);

        int[] copiedTreeValues = new Traversal.InorderDFS().traverseAndRetrieveValues(copiedBST);
        int[] expectedValues = new Traversal.InorderDFS().traverseAndRetrieveValues(binarySearchTree);

        assertArrayEquals(expectedValues, copiedTreeValues);
    }

    @Test
    void testSearchingInsertedElementReturnsTrue() {
        int[] values = new int[]{7, 5, 10, 8, 6};
        BinarySearchTree binarySearchTree = insertArrayValuesInTree(values);

        int valueToFind = values[3];
        boolean treeContains = binarySearchTree.contains(valueToFind);

        assertTrue(Arrays.stream(values).anyMatch(value -> value == valueToFind));
        assertTrue(treeContains);
    }

    @Test
    void testSearchingNonExistingElementReturnsFalse() {
        int[] values = new int[]{7, 5, 10, 8, 6};
        BinarySearchTree binarySearchTree = insertArrayValuesInTree(values);

        int valueToFind = 100;
        boolean treeContains = binarySearchTree.contains(valueToFind);

        assertTrue(Arrays.stream(values).allMatch(value -> value != valueToFind));
        assertFalse(treeContains);
    }

    private static BinarySearchTree insertArrayValuesInTree(int[] values) {
        BinarySearchTree binarySearchTree = new BinarySearchTree(values[0]);

        for (int i = 1; i < values.length; i++) {
            binarySearchTree.insert(values[i]);
        }

        return binarySearchTree;
    }
}