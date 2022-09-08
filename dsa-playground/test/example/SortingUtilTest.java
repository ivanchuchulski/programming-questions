package example;

import example.sorting.SortingUtil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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

    @Test
    void testCountingSortSortsUnsortedArray() {
        int rangeStart = -5;
        int rangeEnd = 5;
        int size = Math.abs(rangeEnd - rangeStart) + 1;

        int[] rangedArray = new int[size];
        for (int i = rangeStart, j = 0; i <= rangeEnd && j < size; i++, j++) {
            rangedArray[j] = i;
        }
        int[] sortedRanged = Arrays.copyOf(rangedArray, rangedArray.length);
        shuffleArray(rangedArray);

        new SortingUtil.CountingSort().sort(rangedArray, rangeStart, rangeEnd);

        assertArrayEquals(sortedRanged, rangedArray);
    }

    @Test
    void testCountingSortSortsUnsortedArray2() {
        int rangeStart = -27;
        int rangeEnd = 57;

        List<Integer> integers = IntStream.range(rangeStart, rangeEnd + 1)
                                          .boxed()
                                          .collect(Collectors.toCollection(LinkedList::new));
        Collections.shuffle(integers);

        int[] rangedArray = integers.stream().mapToInt(integer -> integer).toArray();

        integers.sort(Integer::compareTo);
        int[] sortedRanged = integers.stream().mapToInt(integer -> integer).toArray();

        new SortingUtil.CountingSort().sort(rangedArray, rangeStart, rangeEnd);

        assertArrayEquals(sortedRanged, rangedArray);
    }

    @Test
    void testMergeSort() {
        SortingUtil.MergeSort.sort(unsorted, 0, unsorted.length - 1);

        assertArrayEquals(expectedSortedArray, unsorted);

    }

    // source : https://stackoverflow.com/a/1520212/9127495
    private void shuffleArray(int[] arr) {
        Random random = new Random();
        for (int i = arr.length - 1; i > 0; i--) {
            int index = random.nextInt(i + 1);
            // Simple swap
            int a = arr[index];
            arr[index] = arr[i];
            arr[i] = a;
        }
    }
}

