package example.searching;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SearchingUtilTest {

    private int[] arr;
    private int rangeStart;
    private int rangeEnd;

    @BeforeEach
    void setUp() {
        rangeStart = -5;
        rangeEnd = 5;

        List<Integer> integers = IntStream.range(rangeStart, rangeEnd + 1)
                                          .boxed()
                                          .collect(Collectors.toCollection(LinkedList::new));
        Collections.shuffle(integers);

        arr = integers.stream().mapToInt(integer -> integer).toArray();
    }

    @Test
    void testLinearSearchFindsElementIn() {
        int elementIn = Arrays.stream(arr).findAny().getAsInt();
        int indexOf = arrayToListConversion(arr).indexOf(elementIn);

        int actual = new SearchingUtil.LinearSearch().search(arr, elementIn);

        assertEquals(indexOf, actual);
    }

    @Test
    void testLinearSearchDoesntFindElementOut() {
        int elementOut = rangeEnd + 1;
        int actual = new SearchingUtil.LinearSearch().search(arr, elementOut);

        assertEquals(SearchingUtil.NOT_FOUND_CODE, actual);
    }

    @Test
    void testBinarySearchFindsElementIn() {
        int[] sorted = Arrays.stream(arr).sorted().toArray();

        int elementIn = Arrays.stream(sorted).findAny().getAsInt();
        int indexOf = arrayToListConversion(sorted).indexOf(elementIn);

        int actual = new SearchingUtil.BinarySearch().search(sorted, elementIn);

        assertEquals(indexOf, actual);
    }

    @Test
    void testBinarySearchDoesntFindElementOut() {
        int[] sorted = Arrays.stream(Arrays.copyOf(arr, arr.length)).sorted().toArray();
        int elementOut = Integer.MAX_VALUE;

        int actual = new SearchingUtil.BinarySearch().search(sorted, elementOut);

        assertEquals(SearchingUtil.NOT_FOUND_CODE, actual);
    }

    private List<Integer> arrayToListConversion(int[] arr) {
        List<Integer> result = new ArrayList<>();

        for (int num : arr) {
            result.add(num);
        }

        return result;
    }
}