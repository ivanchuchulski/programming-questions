package example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class SortingUtilTest {

    private int[] unsorted;
    private int[] expectedSortedArray;

    @BeforeEach
    void setUp() {
        unsorted = new int[]{6, 1, 8, 10, -101, 321, 7, 500, 700};
        expectedSortedArray = Arrays.stream(unsorted).sorted().toArray();
    }

    @Test
    void testSelectionSortSortsUnsortedArray() {
        new SortingUtil.SelectionSort().sort(unsorted);

        assertArrayEquals(expectedSortedArray, unsorted);
    }

    @Test
    void testSelectionSortDoesNotSortSortedArray() {
        int[] sorted = Arrays.stream(unsorted).sorted().toArray();

        new SortingUtil.SelectionSort().sort(sorted);

        assertArrayEquals(expectedSortedArray, sorted);
    }

    @Test
    void testBubbleSortSortsUnsortedArray() {
        new SortingUtil.BubbleSort().sort(unsorted);

        assertArrayEquals(expectedSortedArray, unsorted);
    }

    @Test
    void testBubbleSortDoesNotSortSortedArray() {
        int[] sorted = Arrays.stream(unsorted).sorted().toArray();

        new SortingUtil.BubbleSort().sort(sorted);

        assertArrayEquals(expectedSortedArray, sorted);
    }

    @Test
    void testInsertionSortSortsUnsortedArray() {
        new SortingUtil.InsertionSort().sort(unsorted);

        assertArrayEquals(expectedSortedArray, unsorted);
    }
}

